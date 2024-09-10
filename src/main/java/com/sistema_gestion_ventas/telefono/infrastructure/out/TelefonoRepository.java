package com.sistema_gestion_ventas.telefono.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.telefono.domain.entity.Telefono;
import com.sistema_gestion_ventas.telefono.domain.service.TelefonoService;

public class TelefonoRepository implements TelefonoService {
    private Connection connection;

    public TelefonoRepository() {
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
    public void createTelefono(Telefono telefono) {
        String query = "INSERT INTO telefono (telefonoId, tipoTelefonoId, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, telefono.getTelefonoId());
            ps.setInt(2, telefono.getTipoTelefonoId());
            ps.setString(3, telefono.getTelefono());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTelefono(Telefono telefono) {
        String query = "UPDATE telefono SET tipoTelefonoId = ?, telefono = ? WHERE telefonoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, telefono.getTipoTelefonoId());
            ps.setString(2, telefono.getTelefono());
            ps.setInt(3, telefono.getTelefonoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTelefono(String telefonoId) {
        String query = "DELETE FROM telefono WHERE telefonoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, telefonoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Telefono> findTelefonoById(String telefonoId) {
        String query = "SELECT * FROM telefono WHERE telefonoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, telefonoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Telefono telefono = new Telefono();
                    telefono.setTelefonoId(rs.getInt("telefonoId"));
                    telefono.setTipoTelefonoId(rs.getInt("tipoTelefonoId"));
                    telefono.setTelefono(rs.getString("telefono"));
                    return Optional.of(telefono);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Telefono> getAllTelefono() {
        List<Telefono> telefonoList = new ArrayList<>();
        String query = "SELECT * FROM telefono";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Telefono telefono = new Telefono();
                telefono.setTelefonoId(rs.getInt("telefonoId"));
                telefono.setTipoTelefonoId(rs.getInt("tipoTelefonoId"));
                telefono.setTelefono(rs.getString("telefono"));
                telefonoList.add(telefono);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return telefonoList;
    }
}
