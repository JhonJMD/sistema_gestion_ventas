package com.sistema_gestion_ventas.tipo_documento.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.tipo_documento.domain.entity.TipoDocumento;
import com.sistema_gestion_ventas.tipo_documento.domain.service.TipoDocumentoService;

public class TipoDocumentoRepository implements TipoDocumentoService {
    private Connection connection;

    public TipoDocumentoRepository() {
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
    public void createTipoDocumento(TipoDocumento tipodocumento) {
        String query = "INSERT INTO tipodocumento (tipoDocumentoId, nombre) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipodocumento.getTipoDocumentoId());
            ps.setString(2, tipodocumento.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTipoDocumento(TipoDocumento tipodocumento) {
        String query = "UPDATE tipodocumento SET nombre = ? WHERE tipoDocumentoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, tipodocumento.getNombre());
            ps.setInt(2, tipodocumento.getTipoDocumentoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTipoDocumento(String tipodocumentoId) {
        String query = "DELETE FROM tipodocumento WHERE tipoDocumentoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, tipodocumentoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TipoDocumento> findTipoDocumentoById(String tipodocumentoId) {
        String query = "SELECT * FROM tipodocumento WHERE tipoDocumentoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, tipodocumentoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TipoDocumento tipodocumento = new TipoDocumento();
                    tipodocumento.setTipoDocumentoId(rs.getInt("tipoDocumentoId"));
                    tipodocumento.setNombre(rs.getString("nombre"));
                    return Optional.of(tipodocumento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<TipoDocumento> getAllTipoDocumento() {
        List<TipoDocumento> tipodocumentoList = new ArrayList<>();
        String query = "SELECT * FROM tipodocumento";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TipoDocumento tipodocumento = new TipoDocumento();
                tipodocumento.setTipoDocumentoId(rs.getInt("tipoDocumentoId"));
                tipodocumento.setNombre(rs.getString("nombre"));
                tipodocumentoList.add(tipodocumento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipodocumentoList;
    }
}
