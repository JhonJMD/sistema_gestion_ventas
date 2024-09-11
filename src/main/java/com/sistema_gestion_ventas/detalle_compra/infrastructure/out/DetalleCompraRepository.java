package com.sistema_gestion_ventas.detalle_compra.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.detalle_compra.domain.entity.DetalleCompra;
import com.sistema_gestion_ventas.detalle_compra.domain.service.DetalleCompraService;

public class DetalleCompraRepository implements DetalleCompraService {
    private Connection connection;

    public DetalleCompraRepository() {
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
    public void createDetalleCompra(DetalleCompra detallecompra) {
        String query = "INSERT INTO detallecompra (detalleCompraId, compraId, productoId, cantidad, precioUnitario, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detallecompra.getDetalleCompraId());
            ps.setInt(2, detallecompra.getCompraId());
            ps.setInt(3, detallecompra.getProductoId());
            ps.setInt(4, detallecompra.getCantidad());
            ps.setDouble(5, detallecompra.getPrecioUnitario());
            ps.setDouble(6, detallecompra.getSubtotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDetalleCompra(DetalleCompra detallecompra) {
        String query = "UPDATE detallecompra SET compraId = ?, productoId = ?, cantidad = ?, precioUnitario = ?, subtotal = ? WHERE detalleCompraId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detallecompra.getCompraId());
            ps.setInt(2, detallecompra.getProductoId());
            ps.setInt(3, detallecompra.getCantidad());
            ps.setDouble(4, detallecompra.getPrecioUnitario());
            ps.setDouble(5, detallecompra.getSubtotal());
            ps.setInt(6, detallecompra.getDetalleCompraId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDetalleCompra(int detalleCompraId) {
        String query = "DELETE FROM detallecompra WHERE detalleCompraId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detalleCompraId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<DetalleCompra> findDetalleCompraById(int detalleCompraId) {
        String query = "SELECT * FROM detallecompra WHERE detalleCompraId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detalleCompraId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    DetalleCompra detallecompra = new DetalleCompra();
                    detallecompra.setDetalleCompraId(rs.getInt("detalleCompraId"));
                    detallecompra.setCompraId(rs.getInt("compraId"));
                    detallecompra.setProductoId(rs.getInt("productoId"));
                    detallecompra.setCantidad(rs.getInt("cantidad"));
                    detallecompra.setPrecioUnitario(rs.getDouble("precioUnitario"));
                    detallecompra.setSubtotal(rs.getDouble("subtotal"));
                    return Optional.of(detallecompra);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<DetalleCompra> getAllDetalleCompra() {
        List<DetalleCompra> detallecompraList = new ArrayList<>();
        String query = "SELECT * FROM detallecompra";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DetalleCompra detallecompra = new DetalleCompra();
                detallecompra.setDetalleCompraId(rs.getInt("detalleCompraId"));
                detallecompra.setCompraId(rs.getInt("compraId"));
                detallecompra.setProductoId(rs.getInt("productoId"));
                detallecompra.setCantidad(rs.getInt("cantidad"));
                detallecompra.setPrecioUnitario(rs.getDouble("precioUnitario"));
                detallecompra.setSubtotal(rs.getDouble("subtotal"));
                detallecompraList.add(detallecompra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detallecompraList;
    }
}
