package com.sistema_gestion_ventas.tipo_telefono.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.tipo_telefono.domain.entity.TipoTelefono;
import com.sistema_gestion_ventas.tipo_telefono.domain.service.TipoTelefonoService;

public class TipoTelefonoRepository implements TipoTelefonoService {
    private Connection connection;

    public TipoTelefonoRepository() {
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
    public void createTipoTelefono(TipoTelefono tipoTelefono) {
        String query = "INSERT INTO tipoTelefono (tipoTelefonoId, descripcion) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipoTelefono.getTipoTelefonoId());
            ps.setString(2, tipoTelefono.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTipoTelefono(TipoTelefono tipoTelefono) {
        String query = "UPDATE tipoTelefono SET descripcion = ? WHERE tipoTelefonoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, tipoTelefono.getDescripcion());
            ps.setInt(2, tipoTelefono.getTipoTelefonoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTipoTelefono(int tipoTelefonoId) {
        String query = "DELETE FROM tipoTelefono WHERE tipoTelefonoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipoTelefonoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TipoTelefono> findTipoTelefonoById(int tipoTelefonoId) {
        String query = "SELECT * FROM tipoTelefono WHERE tipoTelefonoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipoTelefonoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TipoTelefono tipoTelefono = new TipoTelefono();
                    tipoTelefono.setTipoTelefonoId(rs.getInt("tipoTelefonoId"));
                    tipoTelefono.setDescripcion(rs.getString("descripcion"));
                    return Optional.of(tipoTelefono);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<TipoTelefono> getAllTipoTelefono() {
        List<TipoTelefono> tipoTelefonoList = new ArrayList<>();
        String query = "SELECT * FROM tipoTelefono";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TipoTelefono tipoTelefono = new TipoTelefono();
                tipoTelefono.setTipoTelefonoId(rs.getInt("tipoTelefonoId"));
                tipoTelefono.setDescripcion(rs.getString("descripcion"));
                tipoTelefonoList.add(tipoTelefono);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipoTelefonoList;
    }
}
