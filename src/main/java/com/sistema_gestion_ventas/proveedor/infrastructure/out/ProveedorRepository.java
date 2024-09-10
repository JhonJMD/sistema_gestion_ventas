package com.sistema_gestion_ventas.proveedor.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.proveedor.domain.entity.Proveedor;
import com.sistema_gestion_ventas.proveedor.domain.service.ProveedorService;

public class ProveedorRepository implements ProveedorService {
    private Connection connection;

    public ProveedorRepository() {
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
    public void createProveedor(Proveedor proveedor) {
        String query = "INSERT INTO proveedor (proveedorId, tipoDocumentoId, tipoPersonaId, nombre, direccionId, telefonoId, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, proveedor.getProveedorId());
            ps.setInt(2, proveedor.getTipoDocumentoId());
            ps.setInt(3, proveedor.getTipoPersonaId());
            ps.setString(4, proveedor.getNombre());
            ps.setInt(5, proveedor.getDireccionId());
            ps.setInt(6, proveedor.getTelefonoId());
            ps.setString(7, proveedor.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProveedor(Proveedor proveedor) {
        String query = "UPDATE proveedor SET tipoDocumentoId = ?, tipoPersonaId = ?, nombre = ?, direccionId = ?, telefonoId = ?, email = ? WHERE proveedorId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, proveedor.getTipoDocumentoId());
            ps.setInt(2, proveedor.getTipoPersonaId());
            ps.setString(3, proveedor.getNombre());
            ps.setInt(4, proveedor.getDireccionId());
            ps.setInt(5, proveedor.getTelefonoId());
            ps.setString(6, proveedor.getEmail());
            ps.setString(7, proveedor.getProveedorId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProveedor(String proveedorId) {
        String query = "DELETE FROM proveedor WHERE proveedorId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, proveedorId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Proveedor> findProveedorById(String proveedorId) {
        String query = "SELECT * FROM proveedor WHERE proveedorId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, proveedorId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Proveedor proveedor = new Proveedor();
                    proveedor.setProveedorId(rs.getString("proveedorId"));
                    proveedor.setTipoDocumentoId(rs.getInt("tipoDocumentoId"));
                    proveedor.setTipoPersonaId(rs.getInt("tipoPersonaId"));
                    proveedor.setNombre(rs.getString("nombre"));
                    proveedor.setDireccionId(rs.getInt("direccionId"));
                    proveedor.setTelefonoId(rs.getInt("telefonoId"));
                    proveedor.setEmail(rs.getString("email"));
                    return Optional.of(proveedor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Proveedor> getAllProveedor() {
        List<Proveedor> proveedorList = new ArrayList<>();
        String query = "SELECT * FROM proveedor";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setProveedorId(rs.getString("proveedorId"));
                proveedor.setTipoDocumentoId(rs.getInt("tipoDocumentoId"));
                proveedor.setTipoPersonaId(rs.getInt("tipoPersonaId"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setDireccionId(rs.getInt("direccionId"));
                proveedor.setTelefonoId(rs.getInt("telefonoId"));
                proveedor.setEmail(rs.getString("email"));
                proveedorList.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedorList;
    }
}
