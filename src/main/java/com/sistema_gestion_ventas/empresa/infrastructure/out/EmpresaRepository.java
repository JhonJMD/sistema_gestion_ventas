package com.sistema_gestion_ventas.empresa.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.empresa.domain.entity.Empresa;
import com.sistema_gestion_ventas.empresa.domain.service.EmpresaService;

public class EmpresaRepository implements EmpresaService {
    private Connection connection;

    public EmpresaRepository() {
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
    public void createEmpresa(Empresa empresa) {
        String query = "INSERT INTO empresa (empresaId, nombre, direccionId, representanteLegal) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, empresa.getEmpresaId());
            ps.setString(2, empresa.getNombre());
            ps.setInt(3, empresa.getDireccionId());
            ps.setString(4, empresa.getRepresentanteLegal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmpresa(Empresa empresa) {
        String query = "UPDATE empresa SET nombre = ?, direccionId = ?, representanteLegal = ? WHERE empresaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, empresa.getNombre());
            ps.setInt(2, empresa.getDireccionId());
            ps.setString(3, empresa.getRepresentanteLegal());
            ps.setInt(4, empresa.getEmpresaId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmpresa(int empresaId) {
        String query = "DELETE FROM empresa WHERE empresaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, empresaId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Empresa> findEmpresaById(int empresaId) {
        String query = "SELECT * FROM empresa WHERE empresaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, empresaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Empresa empresa = new Empresa();
                    empresa.setEmpresaId(rs.getInt("empresaId"));
                    empresa.setNombre(rs.getString("nombre"));
                    empresa.setDireccionId(rs.getInt("direccionId"));
                    empresa.setRepresentanteLegal(rs.getString("representanteLegal"));
                    return Optional.of(empresa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Empresa> getAllEmpresa() {
        List<Empresa> empresaList = new ArrayList<>();
        String query = "SELECT * FROM empresa";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setEmpresaId(rs.getInt("empresaId"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setDireccionId(rs.getInt("direccionId"));
                empresa.setRepresentanteLegal(rs.getString("representanteLegal"));
                empresaList.add(empresa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresaList;
    }
}
