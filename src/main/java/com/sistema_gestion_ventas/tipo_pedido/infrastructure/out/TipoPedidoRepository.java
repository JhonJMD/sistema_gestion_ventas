package com.sistema_gestion_ventas.tipo_pedido.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.tipo_pedido.domain.entity.TipoPedido;
import com.sistema_gestion_ventas.tipo_pedido.domain.service.TipoPedidoService;

public class TipoPedidoRepository implements TipoPedidoService {
    private Connection connection;

    public TipoPedidoRepository() {
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
    public void createTipoPedido(TipoPedido tipopedido) {
        String query = "INSERT INTO tipopedido (tipoPedidoId, descripcion) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipopedido.getTipoPedidoId());
            ps.setString(2, tipopedido.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTipoPedido(TipoPedido tipopedido) {
        String query = "UPDATE tipopedido SET descripcion = ? WHERE tipoPedidoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, tipopedido.getDescripcion());
            ps.setInt(2, tipopedido.getTipoPedidoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTipoPedido(int tipoPedidoId) {
        String query = "DELETE FROM tipopedido WHERE tipoPedidoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipoPedidoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TipoPedido> findTipoPedidoById(int tipoPedidoId) {
        String query = "SELECT * FROM tipopedido WHERE tipoPedidoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, tipoPedidoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TipoPedido tipopedido = new TipoPedido();
                    tipopedido.setTipoPedidoId(rs.getInt("tipoPedidoId"));
                    tipopedido.setDescripcion(rs.getString("descripcion"));
                    return Optional.of(tipopedido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<TipoPedido> getAllTipoPedido() {
        List<TipoPedido> tipopedidoList = new ArrayList<>();
        String query = "SELECT * FROM tipopedido";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TipoPedido tipopedido = new TipoPedido();
                tipopedido.setTipoPedidoId(rs.getInt("tipoPedidoId"));
                tipopedido.setDescripcion(rs.getString("descripcion"));
                tipopedidoList.add(tipopedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipopedidoList;
    }
}
