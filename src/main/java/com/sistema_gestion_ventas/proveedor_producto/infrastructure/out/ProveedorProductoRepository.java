package com.sistema_gestion_ventas.proveedor_producto.infrastructure.out;

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

import com.sistema_gestion_ventas.proveedor_producto.domain.entity.ProveedorProducto;
import com.sistema_gestion_ventas.proveedor_producto.domain.service.ProveedorProductoService;

public class ProveedorProductoRepository implements ProveedorProductoService {
    private Connection connection;

    public ProveedorProductoRepository() {
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
    public void createProveedorProducto(ProveedorProducto proveedorProducto) {
        String query = "INSERT INTO proveedorProducto (proveedorProductoId, productoId, precioCompra, tiempoEntrega, cantidadMinimaPedida, descuentoVolumen, moneda, condicionesPago, fechaUltimaCompra, calificacionProveedor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, proveedorProducto.getProveedorProductoId());
            ps.setInt(2, proveedorProducto.getProductoId());
            ps.setDouble(3, proveedorProducto.getPrecioCompra());
            ps.setInt(4, proveedorProducto.getTiempoEntrega());
            ps.setInt(5, proveedorProducto.getCantidadMinimaPedida());
            ps.setDouble(6, proveedorProducto.getDescuentoVolumen());
            ps.setString(7, proveedorProducto.getMoneda());
            ps.setString(8, proveedorProducto.getCondicionesPago());
            ps.setDate(9, new Date(proveedorProducto.getFechaUltimaCompra().getTime()));
            ps.setDouble(10, proveedorProducto.getCalificacionProveedor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProveedorProducto(ProveedorProducto proveedorProducto) {
        String query = "UPDATE proveedorProducto SET productoId = ?, precioCompra = ?, tiempoEntrega = ?, cantidadMinimaPedida = ?, descuentoVolumen = ?, moneda = ?, condicionesPago = ?, fechaUltimaCompra = ?, calificacionProveedor = ? WHERE proveedorProductoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, proveedorProducto.getProductoId());
            ps.setDouble(2, proveedorProducto.getPrecioCompra());
            ps.setInt(3, proveedorProducto.getTiempoEntrega());
            ps.setInt(4, proveedorProducto.getCantidadMinimaPedida());
            ps.setDouble(5, proveedorProducto.getDescuentoVolumen());
            ps.setString(6, proveedorProducto.getMoneda());
            ps.setString(7, proveedorProducto.getCondicionesPago());
            ps.setDate(8, new Date(proveedorProducto.getFechaUltimaCompra().getTime()));
            ps.setDouble(9, proveedorProducto.getCalificacionProveedor());
            ps.setString(10, proveedorProducto.getProveedorProductoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProveedorProducto(String proveedorProductoId) {
        String query = "DELETE FROM proveedorProducto WHERE proveedorProductoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, proveedorProductoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ProveedorProducto> findProveedorProductoById(String proveedorProductoId) {
        String query = "SELECT * FROM proveedorProducto WHERE proveedorProductoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, proveedorProductoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ProveedorProducto proveedorProducto = new ProveedorProducto();
                    proveedorProducto.setProveedorProductoId(rs.getString("proveedorProductoId"));
                    proveedorProducto.setProductoId(rs.getInt("productoId"));
                    proveedorProducto.setPrecioCompra(rs.getDouble("precioCompra"));
                    proveedorProducto.setTiempoEntrega(rs.getInt("tiempoEntrega"));
                    proveedorProducto.setCantidadMinimaPedida(rs.getInt("cantidadMinimaPedida"));
                    proveedorProducto.setDescuentoVolumen(rs.getDouble("descuentoVolumen"));
                    proveedorProducto.setMoneda(rs.getString("moneda"));
                    proveedorProducto.setCondicionesPago(rs.getString("condicionesPago"));
                    proveedorProducto.setFechaUltimaCompra(rs.getDate("fechaUltimaCompra"));
                    proveedorProducto.setCalificacionProveedor(rs.getDouble("calificacionProveedor"));
                    return Optional.of(proveedorProducto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<ProveedorProducto> getAllProveedorProducto() {
        List<ProveedorProducto> proveedorProductoList = new ArrayList<>();
        String query = "SELECT * FROM proveedorProducto";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ProveedorProducto proveedorProducto = new ProveedorProducto();
                proveedorProducto.setProveedorProductoId(rs.getString("proveedorProductoId"));
                proveedorProducto.setProductoId(rs.getInt("productoId"));
                proveedorProducto.setPrecioCompra(rs.getDouble("precioCompra"));
                proveedorProducto.setTiempoEntrega(rs.getInt("tiempoEntrega"));
                proveedorProducto.setCantidadMinimaPedida(rs.getInt("cantidadMinimaPedida"));
                proveedorProducto.setDescuentoVolumen(rs.getDouble("descuentoVolumen"));
                proveedorProducto.setMoneda(rs.getString("moneda"));
                proveedorProducto.setCondicionesPago(rs.getString("condicionesPago"));
                proveedorProducto.setFechaUltimaCompra(rs.getDate("fechaUltimaCompra"));
                proveedorProducto.setCalificacionProveedor(rs.getDouble("calificacionProveedor"));
                proveedorProductoList.add(proveedorProducto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedorProductoList;
    }
}
