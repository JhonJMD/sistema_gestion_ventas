package com.sistema_gestion_ventas.pais.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.pais.domain.entity.Pais;
import com.sistema_gestion_ventas.pais.domain.service.PaisService;

public class PaisRepository implements PaisService {
    private Connection connection;

    public PaisRepository() {
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
    public void createPais(Pais pais) {
        String query = "INSERT INTO pais (paisId, nombre) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, pais.getPaisId());
            ps.setString(2, pais.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePais(Pais pais) {
        String query = "UPDATE pais SET nombre = ? WHERE paisId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, pais.getNombre());
            ps.setInt(2, pais.getPaisId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePais(String paisId) {
        String query = "DELETE FROM pais WHERE paisId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, paisId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Pais> findPaisById(String paisId) {
        String query = "SELECT * FROM pais WHERE paisId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, paisId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Pais pais = new Pais();
                    pais.setPaisId(rs.getInt("paisId"));
                    pais.setNombre(rs.getString("nombre"));
                    return Optional.of(pais);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Pais> getAllPais() {
        List<Pais> paisList = new ArrayList<>();
        String query = "SELECT * FROM pais";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pais pais = new Pais();
                pais.setPaisId(rs.getInt("paisId"));
                pais.setNombre(rs.getString("nombre"));
                paisList.add(pais);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paisList;
    }
}
