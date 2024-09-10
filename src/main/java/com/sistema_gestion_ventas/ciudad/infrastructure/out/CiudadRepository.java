package com.sistema_gestion_ventas.ciudad.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;
import com.sistema_gestion_ventas.ciudad.domain.service.CiudadService;

public class CiudadRepository implements CiudadService {
    private Connection connection;

    public CiudadRepository() {
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
    public void createCiudad(Ciudad ciudad) {
        String query = "INSERT INTO ciudad (ciudadId, nombre, paisId) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, ciudad.getCiudadId());
            ps.setString(2, ciudad.getNombre());
            ps.setInt(3, ciudad.getPaisId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCiudad(Ciudad ciudad) {
        String query = "UPDATE ciudad SET nombre = ?, paisId = ? WHERE ciudadId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, ciudad.getNombre());
            ps.setInt(2, ciudad.getPaisId());
            ps.setInt(3, ciudad.getCiudadId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCiudad(String ciudadId) {
        String query = "DELETE FROM ciudad WHERE ciudadId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, ciudadId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Ciudad> findCiudadById(String ciudadId) {
        String query = "SELECT * FROM ciudad WHERE ciudadId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, ciudadId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Ciudad ciudad = new Ciudad();
                    ciudad.setCiudadId(rs.getInt("ciudadId"));
                    ciudad.setNombre(rs.getString("nombre"));
                    ciudad.setPaisId(rs.getInt("paisId"));
                    return Optional.of(ciudad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Ciudad> getAllCiudad() {
        List<Ciudad> ciudadList = new ArrayList<>();
        String query = "SELECT * FROM ciudad";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setCiudadId(rs.getInt("ciudadId"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setPaisId(rs.getInt("paisId"));
                ciudadList.add(ciudad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ciudadList;
    }
}
