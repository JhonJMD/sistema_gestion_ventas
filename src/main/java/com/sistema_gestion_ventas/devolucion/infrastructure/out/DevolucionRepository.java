package com.sistema_gestion_ventas.devolucion.infrastructure.out;

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

import com.sistema_gestion_ventas.devolucion.domain.entity.Devolucion;
import com.sistema_gestion_ventas.devolucion.domain.service.DevolucionService;

public class DevolucionRepository implements DevolucionService {
    private Connection connection;

    public DevolucionRepository() {
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
    public void createDevolucion(Devolucion devolucion) {
        String query = "INSERT INTO devolucion (devolucionId, fechaDevolucion, motivo, estadoId, facturaId) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, devolucion.getDevolucionId());
            ps.setDate(2, new Date(devolucion.getFechaDevolucion().getTime()));
            ps.setString(3, devolucion.getMotivo());
            ps.setInt(4, devolucion.getEstadoId());
            ps.setInt(5, devolucion.getFacturaId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDevolucion(Devolucion devolucion) {
        String query = "UPDATE devolucion SET fechaDevolucion = ?, motivo = ?, estadoId = ?, facturaId = ? WHERE devolucionId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setDate(1, new Date(devolucion.getFechaDevolucion().getTime()));
            ps.setString(2, devolucion.getMotivo());
            ps.setInt(3, devolucion.getEstadoId());
            ps.setInt(4, devolucion.getFacturaId());
            ps.setInt(5, devolucion.getDevolucionId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDevolucion(int devolucionId) {
        String query = "DELETE FROM devolucion WHERE devolucionId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, devolucionId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Devolucion> findDevolucionById(int devolucionId) {
        String query = "SELECT * FROM devolucion WHERE devolucionId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, devolucionId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Devolucion devolucion = new Devolucion();
                    devolucion.setDevolucionId(rs.getInt("devolucionId"));
                    devolucion.setFechaDevolucion(rs.getDate("fechaDevolucion"));
                    devolucion.setMotivo(rs.getString("motivo"));
                    devolucion.setEstadoId(rs.getInt("estadoId"));
                    devolucion.setFacturaId(rs.getInt("facturaId"));
                    return Optional.of(devolucion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Devolucion> getAllDevolucion() {
        List<Devolucion> devolucionList = new ArrayList<>();
        String query = "SELECT * FROM devolucion";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Devolucion devolucion = new Devolucion();
                devolucion.setDevolucionId(rs.getInt("devolucionId"));
                devolucion.setFechaDevolucion(rs.getDate("fechaDevolucion"));
                devolucion.setMotivo(rs.getString("motivo"));
                devolucion.setEstadoId(rs.getInt("estadoId"));
                devolucion.setFacturaId(rs.getInt("facturaId"));
                devolucionList.add(devolucion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devolucionList;
    }
}
