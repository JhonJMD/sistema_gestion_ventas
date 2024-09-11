package com.sistema_gestion_ventas.sucursal.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.sucursal.domain.entity.Sucursal;
import com.sistema_gestion_ventas.sucursal.domain.service.SucursalService;

public class SucursalRepository implements SucursalService {
    private Connection connection;

    public SucursalRepository() {
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
    public void createSucursal(Sucursal sucursal) {
        String query = "INSERT INTO sucursal (sucursalId, direccionId, descripcion) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, sucursal.getSucursalId());
            ps.setInt(2, sucursal.getDireccionId());
            ps.setString(3, sucursal.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSucursal(Sucursal sucursal) {
        String query = "UPDATE sucursal SET direccionId = ?, descripcion = ? WHERE sucursalId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, sucursal.getDireccionId());
            ps.setString(2, sucursal.getDescripcion());
            ps.setInt(3, sucursal.getSucursalId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSucursal(int sucursalId) {
        String query = "DELETE FROM sucursal WHERE sucursalId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, sucursalId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Sucursal> findSucursalById(int sucursalId) {
        String query = "SELECT * FROM sucursal WHERE sucursalId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, sucursalId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Sucursal sucursal = new Sucursal();
                    sucursal.setSucursalId(rs.getInt("sucursalId"));
                    sucursal.setDireccionId(rs.getInt("direccionId"));
                    sucursal.setDescripcion(rs.getString("descripcion"));
                    return Optional.of(sucursal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Sucursal> getAllSucursal() {
        List<Sucursal> sucursalList = new ArrayList<>();
        String query = "SELECT * FROM sucursal";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setSucursalId(rs.getInt("sucursalId"));
                sucursal.setDireccionId(rs.getInt("direccionId"));
                sucursal.setDescripcion(rs.getString("descripcion"));
                sucursalList.add(sucursal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucursalList;
    }
}
