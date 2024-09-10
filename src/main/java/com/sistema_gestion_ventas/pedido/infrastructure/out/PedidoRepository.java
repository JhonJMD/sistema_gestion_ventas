package com.sistema_gestion_ventas.pedido.infrastructure.out;

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

import com.sistema_gestion_ventas.pedido.domain.entity.Pedido;
import com.sistema_gestion_ventas.pedido.domain.service.PedidoService;

public class PedidoRepository implements PedidoService {
    private Connection connection;

    public PedidoRepository() {
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
    public void createPedido(Pedido pedido) {
        String query = "INSERT INTO pedido (pedidoId, tipoPedidoId, clienteId, fechaPedido, estadoId, totalEstimado, fechaConfirmacion, usuarioId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, pedido.getPedidoId());
            ps.setInt(2, pedido.getTipoPedidoId());
            ps.setString(3, pedido.getClienteId());
            ps.setDate(4, new Date(pedido.getFechaPedido().getTime()));
            ps.setInt(5, pedido.getEstadoId());
            ps.setDouble(6, pedido.getTotalEstimado());
            ps.setDate(7, new Date(pedido.getFechaConfirmacion().getTime()));
            ps.setInt(8, pedido.getUsuarioId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePedido(Pedido pedido) {
        String query = "UPDATE pedido SET tipoPedidoId = ?, clienteId = ?, fechaPedido = ?, estadoId = ?, totalEstimado = ?, fechaConfirmacion = ?, usuarioId = ? WHERE pedidoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, pedido.getTipoPedidoId());
            ps.setString(2, pedido.getClienteId());
            ps.setDate(3, new Date(pedido.getFechaPedido().getTime()));
            ps.setInt(4, pedido.getEstadoId());
            ps.setDouble(5, pedido.getTotalEstimado());
            ps.setDate(6, new Date(pedido.getFechaConfirmacion().getTime()));
            ps.setInt(7, pedido.getUsuarioId());
            ps.setInt(8, pedido.getPedidoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePedido(String pedidoId) {
        String query = "DELETE FROM pedido WHERE pedidoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, pedidoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Pedido> findPedidoById(String pedidoId) {
        String query = "SELECT * FROM pedido WHERE pedidoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, pedidoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setPedidoId(rs.getInt("pedidoId"));
                    pedido.setTipoPedidoId(rs.getInt("tipoPedidoId"));
                    pedido.setClienteId(rs.getString("clienteId"));
                    pedido.setFechaPedido(rs.getDate("fechaPedido"));
                    pedido.setEstadoId(rs.getInt("estadoId"));
                    pedido.setTotalEstimado(rs.getDouble("totalEstimado"));
                    pedido.setFechaConfirmacion(rs.getDate("fechaConfirmacion"));
                    pedido.setUsuarioId(rs.getInt("usuarioId"));
                    return Optional.of(pedido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Pedido> getAllPedido() {
        List<Pedido> pedidoList = new ArrayList<>();
        String query = "SELECT * FROM pedido";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setPedidoId(rs.getInt("pedidoId"));
                pedido.setTipoPedidoId(rs.getInt("tipoPedidoId"));
                pedido.setClienteId(rs.getString("clienteId"));
                pedido.setFechaPedido(rs.getDate("fechaPedido"));
                pedido.setEstadoId(rs.getInt("estadoId"));
                pedido.setTotalEstimado(rs.getDouble("totalEstimado"));
                pedido.setFechaConfirmacion(rs.getDate("fechaConfirmacion"));
                pedido.setUsuarioId(rs.getInt("usuarioId"));
                pedidoList.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidoList;
    }
}
