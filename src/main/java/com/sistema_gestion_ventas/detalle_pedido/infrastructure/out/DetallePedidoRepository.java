package com.sistema_gestion_ventas.detalle_pedido.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.detalle_pedido.domain.entity.DetallePedido;
import com.sistema_gestion_ventas.detalle_pedido.domain.service.DetallePedidoService;

public class DetallePedidoRepository implements DetallePedidoService {
    private Connection connection;

    public DetallePedidoRepository() {
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
    public void createDetallePedido(DetallePedido detallepedido) {
        String query = "INSERT INTO detallepedido (detallePedidoId, pedidoId, productoId, cantidad, precioUnitario, subTotal) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detallepedido.getDetallePedidoId());
            ps.setInt(2, detallepedido.getPedidoId());
            ps.setInt(3, detallepedido.getProductoId());
            ps.setInt(4, detallepedido.getCantidad());
            ps.setDouble(5, detallepedido.getPrecioUnitario());
            ps.setDouble(6, detallepedido.getSubTotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDetallePedido(DetallePedido detallepedido) {
        String query = "UPDATE detallepedido SET pedidoId = ?, productoId = ?, cantidad = ?, precioUnitario = ?, subTotal = ? WHERE detallePedidoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detallepedido.getPedidoId());
            ps.setInt(2, detallepedido.getProductoId());
            ps.setInt(3, detallepedido.getCantidad());
            ps.setDouble(4, detallepedido.getPrecioUnitario());
            ps.setDouble(5, detallepedido.getSubTotal());
            ps.setInt(6, detallepedido.getDetallePedidoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDetallePedido(int detallePedidoId) {
        String query = "DELETE FROM detallepedido WHERE detallePedidoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detallePedidoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<DetallePedido> findDetallePedidoById(int detallePedidoId) {
        String query = "SELECT * FROM detallepedido WHERE detallePedidoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, detallePedidoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    DetallePedido detallepedido = new DetallePedido();
                    detallepedido.setDetallePedidoId(rs.getInt("detallePedidoId"));
                    detallepedido.setPedidoId(rs.getInt("pedidoId"));
                    detallepedido.setProductoId(rs.getInt("productoId"));
                    detallepedido.setCantidad(rs.getInt("cantidad"));
                    detallepedido.setPrecioUnitario(rs.getDouble("precioUnitario"));
                    detallepedido.setSubTotal(rs.getDouble("subTotal"));
                    return Optional.of(detallepedido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<DetallePedido> getAllDetallePedido() {
        List<DetallePedido> detallepedidoList = new ArrayList<>();
        String query = "SELECT * FROM detallepedido";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DetallePedido detallepedido = new DetallePedido();
                detallepedido.setDetallePedidoId(rs.getInt("detallePedidoId"));
                detallepedido.setPedidoId(rs.getInt("pedidoId"));
                detallepedido.setProductoId(rs.getInt("productoId"));
                detallepedido.setCantidad(rs.getInt("cantidad"));
                detallepedido.setPrecioUnitario(rs.getDouble("precioUnitario"));
                detallepedido.setSubTotal(rs.getDouble("subTotal"));
                detallepedidoList.add(detallepedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detallepedidoList;
    }
}
