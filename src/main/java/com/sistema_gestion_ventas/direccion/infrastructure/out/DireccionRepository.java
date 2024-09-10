package com.sistema_gestion_ventas.direccion.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.direccion.domain.entity.Direccion;
import com.sistema_gestion_ventas.direccion.domain.service.DireccionService;

public class DireccionRepository implements DireccionService {
    private Connection connection;

    public DireccionRepository() {
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
    public void createDireccion(Direccion direccion) {
        String query = "INSERT INTO direccion (direccionId, direccionCompleta, ciudadId) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, direccion.getDireccionId());
            ps.setString(2, direccion.getDireccionCompleta());
            ps.setInt(3, direccion.getCiudadId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDireccion(Direccion direccion) {
        String query = "UPDATE direccion SET direccionCompleta = ?, ciudadId = ? WHERE direccionId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, direccion.getDireccionCompleta());
            ps.setInt(2, direccion.getCiudadId());
            ps.setInt(3, direccion.getDireccionId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDireccion(int direccionId) {
        String query = "DELETE FROM direccion WHERE direccionId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, direccionId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Direccion> findDireccionById(int direccionId) {
        String query = "SELECT * FROM direccion WHERE direccionId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, direccionId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Direccion direccion = new Direccion();
                    direccion.setDireccionId(rs.getInt("direccionId"));
                    direccion.setDireccionCompleta(rs.getString("direccionCompleta"));
                    direccion.setCiudadId(rs.getInt("ciudadId"));
                    return Optional.of(direccion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Direccion> getAllDireccion() {
        List<Direccion> direccionList = new ArrayList<>();
        String query = "SELECT * FROM direccion";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Direccion direccion = new Direccion();
                direccion.setDireccionId(rs.getInt("direccionId"));
                direccion.setDireccionCompleta(rs.getString("direccionCompleta"));
                direccion.setCiudadId(rs.getInt("ciudadId"));
                direccionList.add(direccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return direccionList;
    }
}
