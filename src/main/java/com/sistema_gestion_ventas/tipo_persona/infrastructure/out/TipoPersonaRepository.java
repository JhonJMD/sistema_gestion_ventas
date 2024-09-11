package com.sistema_gestion_ventas.tipo_persona.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.tipo_persona.domain.entity.TipoPersona;
import com.sistema_gestion_ventas.tipo_persona.domain.service.TipoPersonaService;

public class TipoPersonaRepository implements TipoPersonaService {
    private Connection connection;

    public TipoPersonaRepository() {
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
    public void createTipoPersona(TipoPersona tipoPersona) {
        String query = "INSERT INTO tipoPersona (tipoPersonaId, descripcion) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipoPersona.getTipoPersonaId());
            ps.setString(2, tipoPersona.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTipoPersona(TipoPersona tipoPersona) {
        String query = "UPDATE tipoPersona SET descripcion = ? WHERE tipoPersonaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, tipoPersona.getDescripcion());
            ps.setInt(2, tipoPersona.getTipoPersonaId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTipoPersona(int tipoPersonaId) {
        String query = "DELETE FROM tipoPersona WHERE tipoPersonaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipoPersonaId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TipoPersona> findTipoPersonaById(int tipoPersonaId) {
        String query = "SELECT * FROM tipoPersona WHERE tipoPersonaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipoPersonaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TipoPersona tipoPersona = new TipoPersona();
                    tipoPersona.setTipoPersonaId(rs.getInt("tipoPersonaId"));
                    tipoPersona.setDescripcion(rs.getString("descripcion"));
                    return Optional.of(tipoPersona);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<TipoPersona> getAllTipoPersona() {
        List<TipoPersona> tipoPersonaList = new ArrayList<>();
        String query = "SELECT * FROM tipoPersona";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TipoPersona tipoPersona = new TipoPersona();
                tipoPersona.setTipoPersonaId(rs.getInt("tipoPersonaId"));
                tipoPersona.setDescripcion(rs.getString("descripcion"));
                tipoPersonaList.add(tipoPersona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipoPersonaList;
    }
}
