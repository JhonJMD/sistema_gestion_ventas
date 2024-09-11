package com.sistema_gestion_ventas.metodo_pago.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.metodo_pago.domain.entity.MetodoPago;
import com.sistema_gestion_ventas.metodo_pago.domain.service.MetodoPagoService;

public class MetodoPagoRepository implements MetodoPagoService {
    private Connection connection;

    public MetodoPagoRepository() {
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
    public void createMetodoPago(MetodoPago metodopago) {
        String query = "INSERT INTO metodopago (metodoPagoId, descripcion) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, metodopago.getMetodoPagoId());
            ps.setString(2, metodopago.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMetodoPago(MetodoPago metodopago) {
        String query = "UPDATE metodopago SET descripcion = ? WHERE metodoPagoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, metodopago.getDescripcion());
            ps.setInt(2, metodopago.getMetodoPagoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMetodoPago(int metodoPagoId) {
        String query = "DELETE FROM metodopago WHERE metodoPagoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, metodoPagoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<MetodoPago> findMetodoPagoById(int metodoPagoId) {
        String query = "SELECT * FROM metodopago WHERE metodoPagoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, metodoPagoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    MetodoPago metodopago = new MetodoPago();
                    metodopago.setMetodoPagoId(rs.getInt("metodoPagoId"));
                    metodopago.setDescripcion(rs.getString("descripcion"));
                    return Optional.of(metodopago);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<MetodoPago> getAllMetodoPago() {
        List<MetodoPago> metodopagoList = new ArrayList<>();
        String query = "SELECT * FROM metodopago";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MetodoPago metodopago = new MetodoPago();
                metodopago.setMetodoPagoId(rs.getInt("metodoPagoId"));
                metodopago.setDescripcion(rs.getString("descripcion"));
                metodopagoList.add(metodopago);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return metodopagoList;
    }
}
