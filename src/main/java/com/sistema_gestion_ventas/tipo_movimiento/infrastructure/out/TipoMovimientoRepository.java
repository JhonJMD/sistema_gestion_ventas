package com.sistema_gestion_ventas.tipo_movimiento.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.tipo_movimiento.domain.entity.TipoMovimiento;
import com.sistema_gestion_ventas.tipo_movimiento.domain.service.TipoMovimientoService;

public class TipoMovimientoRepository implements TipoMovimientoService {
    private Connection connection;

    public TipoMovimientoRepository() {
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
    public void createTipoMovimiento(TipoMovimiento tipomovimiento) {
        String query = "INSERT INTO tipomovimiento (tipoMovimientoId, descripcion) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipomovimiento.getTipoMovimientoId());
            ps.setString(2, tipomovimiento.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTipoMovimiento(TipoMovimiento tipomovimiento) {
        String query = "UPDATE tipomovimiento SET descripcion = ? WHERE tipoMovimientoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, tipomovimiento.getDescripcion());
            ps.setInt(2, tipomovimiento.getTipoMovimientoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTipoMovimiento(int tipoMovimientoId) {
        String query = "DELETE FROM tipomovimiento WHERE tipoMovimientoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipoMovimientoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TipoMovimiento> findTipoMovimientoById(int tipoMovimientoId) {
        String query = "SELECT * FROM tipomovimiento WHERE tipoMovimientoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipoMovimientoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TipoMovimiento tipomovimiento = new TipoMovimiento();
                    tipomovimiento.setTipoMovimientoId(rs.getInt("tipoMovimientoId"));
                    tipomovimiento.setDescripcion(rs.getString("descripcion"));
                    return Optional.of(tipomovimiento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<TipoMovimiento> getAllTipoMovimiento() {
        List<TipoMovimiento> tipomovimientoList = new ArrayList<>();
        String query = "SELECT * FROM tipomovimiento";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TipoMovimiento tipomovimiento = new TipoMovimiento();
                tipomovimiento.setTipoMovimientoId(rs.getInt("tipoMovimientoId"));
                tipomovimiento.setDescripcion(rs.getString("descripcion"));
                tipomovimientoList.add(tipomovimiento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipomovimientoList;
    }
}
