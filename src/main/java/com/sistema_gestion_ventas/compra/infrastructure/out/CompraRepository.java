package com.sistema_gestion_ventas.compra.infrastructure.out;

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

import com.sistema_gestion_ventas.compra.domain.entity.Compra;
import com.sistema_gestion_ventas.compra.domain.service.CompraService;

public class CompraRepository implements CompraService {
    private Connection connection;

    public CompraRepository() {
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
    public void createCompra(Compra compra) {
        String query = "INSERT INTO compra (compraId, pedidoId, fechaCompra, estadoId, totalSinDescuento, empleadoId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, compra.getCompraId());
            ps.setInt(2, compra.getPedidoId());
            ps.setDate(3, new Date(compra.getFechaCompra().getTime()));
            ps.setInt(4, compra.getEstadoId());
            ps.setDouble(5, compra.getTotalSinDescuento());
            ps.setInt(6, compra.getEmpleadoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCompra(Compra compra) {
        String query = "UPDATE compra SET pedidoId = ?, fechaCompra = ?, estadoId = ?, totalSinDescuento = ?, empleadoId = ? WHERE compraId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, compra.getPedidoId());
            ps.setDate(2, new Date(compra.getFechaCompra().getTime()));
            ps.setInt(3, compra.getEstadoId());
            ps.setDouble(4, compra.getTotalSinDescuento());
            ps.setInt(5, compra.getEmpleadoId());
            ps.setInt(6, compra.getCompraId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompra(int compraId) {
        String query = "DELETE FROM compra WHERE compraId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, compraId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Compra> findCompraById(int compraId) {
        String query = "SELECT * FROM compra WHERE compraId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, compraId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Compra compra = new Compra();
                    compra.setCompraId(rs.getInt("compraId"));
                    compra.setPedidoId(rs.getInt("pedidoId"));
                    compra.setFechaCompra(rs.getDate("fechaCompra"));
                    compra.setEstadoId(rs.getInt("estadoId"));
                    compra.setTotalSinDescuento(rs.getDouble("totalSinDescuento"));
                    compra.setEmpleadoId(rs.getInt("empleadoId"));
                    return Optional.of(compra);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Compra> getAllCompra() {
        List<Compra> compraList = new ArrayList<>();
        String query = "SELECT * FROM compra";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setCompraId(rs.getInt("compraId"));
                compra.setPedidoId(rs.getInt("pedidoId"));
                compra.setFechaCompra(rs.getDate("fechaCompra"));
                compra.setEstadoId(rs.getInt("estadoId"));
                compra.setTotalSinDescuento(rs.getDouble("totalSinDescuento"));
                compra.setEmpleadoId(rs.getInt("empleadoId"));
                compraList.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compraList;
    }
}
