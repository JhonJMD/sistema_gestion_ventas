package com.sistema_gestion_ventas.venta.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.venta.domain.entity.Venta;
import com.sistema_gestion_ventas.venta.domain.service.VentaService;

public class VentaRepository implements VentaService {
    private Connection connection;

    public VentaRepository() {
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
    public void createVenta(Venta venta) {
        String query = "INSERT INTO venta (ventaId, pedidoId, fechaVenta, totalSinDescuento, clienteId, estadoId, empleadoId) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, venta.getVentaId());
            ps.setInt(2, venta.getPedidoId());
            ps.setDate(3, new Date(venta.getFechaVenta().getTime()));
            ps.setDouble(4, venta.getTotalSinDescuento());
            ps.setString(5, venta.getClienteId());
            ps.setInt(6, venta.getEstadoId());
            ps.setString(7, venta.getEmpleadoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateVenta(Venta venta) {
        String query = "UPDATE venta SET pedidoId = ?, fechaVenta = ?, totalSinDescuento = ?, clienteId = ?, estadoId = ?, empleadoId = ? WHERE ventaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, venta.getPedidoId());
            ps.setDate(2, new Date(venta.getFechaVenta().getTime()));
            ps.setDouble(3, venta.getTotalSinDescuento());
            ps.setString(4, venta.getClienteId());
            ps.setInt(5, venta.getEstadoId());
            ps.setString(6, venta.getEmpleadoId());
            ps.setInt(7, venta.getVentaId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVenta(int ventaId) {
        String query = "DELETE FROM venta WHERE ventaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, ventaId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Venta> findVentaById(int ventaId) {
        String query = "SELECT * FROM venta WHERE ventaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, ventaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Venta venta = new Venta();
                    venta.setVentaId(rs.getInt("ventaId"));
                    venta.setPedidoId(rs.getInt("pedidoId"));
                    venta.setFechaVenta(rs.getDate("fechaVenta"));
                    venta.setTotalSinDescuento(rs.getDouble("totalSinDescuento"));
                    venta.setClienteId(rs.getString("clienteId"));
                    venta.setEstadoId(rs.getInt("estadoId"));
                    venta.setEmpleadoId(rs.getString("empleadoId"));
                    return Optional.of(venta);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Venta> getAllVenta() {
        List<Venta> ventaList = new ArrayList<>();
        String query = "SELECT * FROM venta";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setVentaId(rs.getInt("ventaId"));
                venta.setPedidoId(rs.getInt("pedidoId"));
                venta.setFechaVenta(rs.getDate("fechaVenta"));
                venta.setTotalSinDescuento(rs.getDouble("totalSinDescuento"));
                venta.setClienteId(rs.getString("clienteId"));
                venta.setEstadoId(rs.getInt("estadoId"));
                venta.setEmpleadoId(rs.getString("empleadoId"));
                ventaList.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventaList;
    }
}
