package com.sistema_gestion_ventas.cliente.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.cliente.domain.entity.Cliente;
import com.sistema_gestion_ventas.cliente.domain.service.ClienteService;

public class ClienteRepository implements ClienteService {
    private Connection connection;

    public ClienteRepository() {
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
    public void createCliente(Cliente cliente) {
        String query = "INSERT INTO cliente (clienteId, tipoDocumentoId, tipoPersonaId, nombre, apellido, direccionId, telefonoId, email, totalGastado, comprasRealizadas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, cliente.getClienteId());
            ps.setInt(2, cliente.getTipoDocumentoId());
            ps.setInt(3, cliente.getTipoPersonaId());
            ps.setString(4, cliente.getNombre());
            ps.setString(5, cliente.getApellido());
            ps.setInt(6, cliente.getDireccionId());
            ps.setInt(7, cliente.getTelefonoId());
            ps.setString(8, cliente.getEmail());
            ps.setDouble(9, cliente.getTotalGastado());
            ps.setInt(10, cliente.getComprasRealizadas());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCliente(Cliente cliente) {
        String query = "UPDATE cliente SET tipoDocumentoId = ?, tipoPersonaId = ?, nombre = ?, apellido = ?, direccionId = ?, telefonoId = ?, email = ?, totalGastado = ?, comprasRealizadas = ? WHERE clienteId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, cliente.getTipoDocumentoId());
            ps.setInt(2, cliente.getTipoPersonaId());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getApellido());
            ps.setInt(5, cliente.getDireccionId());
            ps.setInt(6, cliente.getTelefonoId());
            ps.setString(7, cliente.getEmail());
            ps.setDouble(8, cliente.getTotalGastado());
            ps.setInt(9, cliente.getComprasRealizadas());
            ps.setString(10, cliente.getClienteId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCliente(String clienteId) {
        String query = "DELETE FROM cliente WHERE clienteId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, clienteId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Cliente> findClienteById(String clienteId) {
        String query = "SELECT * FROM cliente WHERE clienteId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, clienteId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setClienteId(rs.getString("clienteId"));
                    cliente.setTipoDocumentoId(rs.getInt("tipoDocumentoId"));
                    cliente.setTipoPersonaId(rs.getInt("tipoPersonaId"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setDireccionId(rs.getInt("direccionId"));
                    cliente.setTelefonoId(rs.getInt("telefonoId"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTotalGastado(rs.getDouble("totalGastado"));
                    cliente.setComprasRealizadas(rs.getInt("comprasRealizadas"));
                    return Optional.of(cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Cliente> getAllCliente() {
        List<Cliente> clienteList = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setClienteId(rs.getString("clienteId"));
                cliente.setTipoDocumentoId(rs.getInt("tipoDocumentoId"));
                cliente.setTipoPersonaId(rs.getInt("tipoPersonaId"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDireccionId(rs.getInt("direccionId"));
                cliente.setTelefonoId(rs.getInt("telefonoId"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTotalGastado(rs.getDouble("totalGastado"));
                cliente.setComprasRealizadas(rs.getInt("comprasRealizadas"));
                clienteList.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clienteList;
    }
}
