package com.sistema_gestion_ventas.detalle_venta.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.detalle_venta.domain.entity.DetalleVenta;
import com.sistema_gestion_ventas.detalle_venta.domain.service.DetalleVentaService;

public class DetalleVentaRepository implements DetalleVentaService {
    private Connection connection;

    public DetalleVentaRepository() {
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
    public void createDetalleVenta(DetalleVenta detalleventa) {
        String query = "INSERT INTO detalleventa (detalleVentaId, ventaId, productoId, cantidad, precioUnitario, subTotal) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detalleventa.getDetalleVentaId());
            ps.setInt(2, detalleventa.getVentaId());
            ps.setInt(3, detalleventa.getProductoId());
            ps.setInt(4, detalleventa.getCantidad());
            ps.setDouble(5, detalleventa.getPrecioUnitario());
            ps.setDouble(6, detalleventa.getSubTotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDetalleVenta(DetalleVenta detalleventa) {
        String query = "UPDATE detalleventa SET ventaId = ?, productoId = ?, cantidad = ?, precioUnitario = ?, subTotal = ? WHERE detalleVentaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detalleventa.getVentaId());
            ps.setInt(2, detalleventa.getProductoId());
            ps.setInt(3, detalleventa.getCantidad());
            ps.setDouble(4, detalleventa.getPrecioUnitario());
            ps.setDouble(5, detalleventa.getSubTotal());
            ps.setInt(6, detalleventa.getDetalleVentaId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDetalleVenta(int detalleVentaId) {
        String query = "DELETE FROM detalleventa WHERE detalleVentaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detalleVentaId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<DetalleVenta> findDetalleVentaById(int detalleVentaId) {
        String query = "SELECT * FROM detalleventa WHERE detalleVentaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detalleVentaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    DetalleVenta detalleventa = new DetalleVenta();
                    detalleventa.setDetalleVentaId(rs.getInt("detalleVentaId"));
                    detalleventa.setVentaId(rs.getInt("ventaId"));
                    detalleventa.setProductoId(rs.getInt("productoId"));
                    detalleventa.setCantidad(rs.getInt("cantidad"));
                    detalleventa.setPrecioUnitario(rs.getDouble("precioUnitario"));
                    detalleventa.setSubTotal(rs.getDouble("subTotal"));
                    return Optional.of(detalleventa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<DetalleVenta> getAllDetalleVenta() {
        List<DetalleVenta> detalleventaList = new ArrayList<>();
        String query = "SELECT * FROM detalleventa";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DetalleVenta detalleventa = new DetalleVenta();
                detalleventa.setDetalleVentaId(rs.getInt("detalleVentaId"));
                detalleventa.setVentaId(rs.getInt("ventaId"));
                detalleventa.setProductoId(rs.getInt("productoId"));
                detalleventa.setCantidad(rs.getInt("cantidad"));
                detalleventa.setPrecioUnitario(rs.getDouble("precioUnitario"));
                detalleventa.setSubTotal(rs.getDouble("subTotal"));
                detalleventaList.add(detalleventa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalleventaList;
    }
}
