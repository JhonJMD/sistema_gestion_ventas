package com.sistema_gestion_ventas.inventario.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.inventario.domain.entity.Inventario;
import com.sistema_gestion_ventas.inventario.domain.service.InventarioService;

public class InventarioRepository implements InventarioService {
    private Connection connection;

    public InventarioRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getResourceAsStream("/db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createInventario(Inventario inventario) {
        String query = "INSERT INTO inventario (productoId, sucursalId, stock) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, inventario.getProductoId());
            ps.setInt(2, inventario.getSucursalId());
            ps.setInt(3, inventario.getStock());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInventario(Inventario inventario) {
        String query = "UPDATE inventario SET sucursalId = ?, stock = ? WHERE productoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, inventario.getSucursalId());
            ps.setInt(2, inventario.getStock());
            ps.setInt(3, inventario.getProductoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInventario(int inventarioId) {
        String query = "DELETE FROM inventario WHERE productoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, inventarioId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Inventario> findInventarioById(int inventarioId) {
        String query = "SELECT * FROM inventario WHERE productoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, inventarioId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Inventario inventario = new Inventario();
                    inventario.setProductoId(rs.getInt("productoId"));
                    inventario.setSucursalId(rs.getInt("sucursalId"));
                    inventario.setStock(rs.getInt("stock"));
                    return Optional.of(inventario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Inventario> getAllInventario() {
        List<Inventario> inventarioList = new ArrayList<>();
        String query = "SELECT * FROM inventario";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Inventario inventario = new Inventario();
                inventario.setProductoId(rs.getInt("productoId"));
                inventario.setSucursalId(rs.getInt("sucursalId"));
                inventario.setStock(rs.getInt("stock"));
                inventarioList.add(inventario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventarioList;
    }
}
