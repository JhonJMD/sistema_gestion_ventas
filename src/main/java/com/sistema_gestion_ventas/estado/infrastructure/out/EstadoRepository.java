package com.sistema_gestion_ventas.estado.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.estado.domain.entity.Estado;
import com.sistema_gestion_ventas.estado.domain.service.EstadoService;

public class EstadoRepository implements EstadoService {
    private Connection connection;

    public EstadoRepository() {
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
    public void createEstado(Estado estado) {
        String query = "INSERT INTO estado (estadoId, descripcion) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, estado.getEstadoId());
            ps.setString(2, estado.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEstado(Estado estado) {
        String query = "UPDATE estado SET descripcion = ? WHERE estadoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, estado.getDescripcion());
            ps.setInt(2, estado.getEstadoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEstado(int estadoId) {
        String query = "DELETE FROM estado WHERE estadoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, estadoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Estado> findEstadoById(int estadoId) {
        String query = "SELECT * FROM estado WHERE estadoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, estadoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Estado estado = new Estado();
                    estado.setEstadoId(rs.getInt("estadoId"));
                    estado.setDescripcion(rs.getString("descripcion"));
                    return Optional.of(estado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Estado> getAllEstado() {
        List<Estado> estadoList = new ArrayList<>();
        String query = "SELECT * FROM estado";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setEstadoId(rs.getInt("estadoId"));
                estado.setDescripcion(rs.getString("descripcion"));
                estadoList.add(estado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estadoList;
    }
}
