package com.sistema_gestion_ventas.factura.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.factura.domain.entity.Factura;
import com.sistema_gestion_ventas.factura.domain.service.FacturaService;

public class FacturaRepository implements FacturaService {
    private Connection connection;

    public FacturaRepository() {
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
    public void createFactura(Factura factura) {
        String query = "INSERT INTO factura (facturaId, descripcion, ventaId, fechaFactura, metodoPagoId, descuentoPorcentaje) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, factura.getFacturaId());
            ps.setString(2, factura.getDescripcion());
            ps.setInt(3, factura.getVentaId());
            ps.setDate(4, new Date(factura.getFechaFactura().getTime()));
            ps.setInt(5, factura.getMetodoPagoId());
            ps.setDouble(6, factura.getDescuentoPorcentaje());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFactura(Factura factura) {
        String query = "UPDATE factura SET descripcion = ?, ventaId = ?, fechaFactura = ?, metodoPagoId = ?, descuentoPorcentaje = ? WHERE facturaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, factura.getDescripcion());
            ps.setInt(2, factura.getVentaId());
            ps.setDate(3, new Date(factura.getFechaFactura().getTime()));
            ps.setInt(4, factura.getMetodoPagoId());
            ps.setDouble(5, factura.getDescuentoPorcentaje());
            ps.setInt(6, factura.getFacturaId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFactura(int facturaId) {
        String query = "DELETE FROM factura WHERE facturaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, facturaId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Factura> findFacturaById(int facturaId) {
        String query = "SELECT * FROM factura WHERE facturaId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, facturaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Factura factura = new Factura();
                    factura.setFacturaId(rs.getInt("facturaId"));
                    factura.setDescripcion(rs.getString("descripcion"));
                    factura.setVentaId(rs.getInt("ventaId"));
                    factura.setFechaFactura(rs.getDate("fechaFactura"));
                    factura.setMetodoPagoId(rs.getInt("metodoPagoId"));
                    factura.setDescuentoPorcentaje(rs.getDouble("descuentoPorcentaje"));
                    return Optional.of(factura);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Factura> getAllFactura() {
        List<Factura> facturaList = new ArrayList<>();
        String query = "SELECT * FROM factura";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Factura factura = new Factura();
                factura.setFacturaId(rs.getInt("facturaId"));
                factura.setDescripcion(rs.getString("descripcion"));
                factura.setVentaId(rs.getInt("ventaId"));
                factura.setFechaFactura(rs.getDate("fechaFactura"));
                factura.setMetodoPagoId(rs.getInt("metodoPagoId"));
                factura.setDescuentoPorcentaje(rs.getDouble("descuentoPorcentaje"));
                facturaList.add(factura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facturaList;
    }
}
