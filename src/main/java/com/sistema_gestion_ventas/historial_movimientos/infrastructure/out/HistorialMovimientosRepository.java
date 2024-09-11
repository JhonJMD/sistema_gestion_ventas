package com.sistema_gestion_ventas.historial_movimientos.infrastructure.out;

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

import com.sistema_gestion_ventas.historial_movimientos.domain.entity.HistorialMovimientos;
import com.sistema_gestion_ventas.historial_movimientos.domain.service.HistorialMovimientosService;

public class HistorialMovimientosRepository implements HistorialMovimientosService {
    private Connection connection;

    public HistorialMovimientosRepository() {
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
    public void createHistorialMovimientos(HistorialMovimientos historialmovimientos) {
        String query = "INSERT INTO historialmovimientos (movimientoId, productoId, sucursalId, tipoMovimientoId, cantidad, fechaMovimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, historialmovimientos.getMovimientoId());
            ps.setInt(2, historialmovimientos.getProductoId());
            ps.setInt(3, historialmovimientos.getSucursalId());
            ps.setInt(4, historialmovimientos.getTipoMovimientoId());
            ps.setInt(5, historialmovimientos.getCantidad());
            ps.setDate(6, new Date(historialmovimientos.getFechaMovimiento().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateHistorialMovimientos(HistorialMovimientos historialmovimientos) {
        String query = "UPDATE historialmovimientos SET productoId = ?, sucursalId = ?, tipoMovimientoId = ?, cantidad = ?, fechaMovimiento = ? WHERE movimientoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, historialmovimientos.getProductoId());
            ps.setInt(2, historialmovimientos.getSucursalId());
            ps.setInt(3, historialmovimientos.getTipoMovimientoId());
            ps.setInt(4, historialmovimientos.getCantidad());
            ps.setDate(5, new Date(historialmovimientos.getFechaMovimiento().getTime()));
            ps.setInt(6, historialmovimientos.getMovimientoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHistorialMovimientos(int historialMovimientosId) {
        String query = "DELETE FROM historialmovimientos WHERE movimientoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, historialMovimientosId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<HistorialMovimientos> findHistorialMovimientosById(int historialMovimientosId) {
        String query = "SELECT * FROM historialmovimientos WHERE movimientoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, historialMovimientosId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    HistorialMovimientos historialmovimientos = new HistorialMovimientos();
                    historialmovimientos.setMovimientoId(rs.getInt("movimientoId"));
                    historialmovimientos.setProductoId(rs.getInt("productoId"));
                    historialmovimientos.setSucursalId(rs.getInt("sucursalId"));
                    historialmovimientos.setTipoMovimientoId(rs.getInt("tipoMovimientoId"));
                    historialmovimientos.setCantidad(rs.getInt("cantidad"));
                    historialmovimientos.setFechaMovimiento(rs.getDate("fechaMovimiento"));
                    return Optional.of(historialmovimientos);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<HistorialMovimientos> getAllHistorialMovimientos() {
        List<HistorialMovimientos> historialmovimientosList = new ArrayList<>();
        String query = "SELECT * FROM historialmovimientos";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                HistorialMovimientos historialmovimientos = new HistorialMovimientos();
                historialmovimientos.setMovimientoId(rs.getInt("movimientoId"));
                historialmovimientos.setProductoId(rs.getInt("productoId"));
                historialmovimientos.setSucursalId(rs.getInt("sucursalId"));
                historialmovimientos.setTipoMovimientoId(rs.getInt("tipoMovimientoId"));
                historialmovimientos.setCantidad(rs.getInt("cantidad"));
                historialmovimientos.setFechaMovimiento(rs.getDate("fechaMovimiento"));
                historialmovimientosList.add(historialmovimientos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historialmovimientosList;
    }
}
