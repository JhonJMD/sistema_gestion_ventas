package com.sistema_gestion_ventas.producto.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.producto.domain.entity.Producto;
import com.sistema_gestion_ventas.producto.domain.service.ProductoService;

public class ProductoRepository implements ProductoService {
    private Connection connection;

    public ProductoRepository() {
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
    public void createProducto(Producto producto) {
        String query = "INSERT INTO producto (productoId, codigoBarras, nombre, descripcion, precio, categoriaProductoId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, producto.getProductoId());
            ps.setString(2, producto.getCodigoBarras());
            ps.setString(3, producto.getNombre());
            ps.setString(4, producto.getDescripcion());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getCategoriaProductoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProducto(Producto producto) {
        String query = "UPDATE producto SET codigoBarras = ?, nombre = ?, descripcion = ?, precio = ?, categoriaProductoId = ? WHERE productoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, producto.getCodigoBarras());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getCategoriaProductoId());
            ps.setInt(6, producto.getProductoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProducto(String productoId) {
        String query = "DELETE FROM producto WHERE productoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, productoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Producto> findProductoById(String productoId) {
        String query = "SELECT * FROM producto WHERE productoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, productoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Producto producto = new Producto();
                    producto.setProductoId(rs.getInt("productoId"));
                    producto.setCodigoBarras(rs.getString("codigoBarras"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setCategoriaProductoId(rs.getInt("categoriaProductoId"));
                    return Optional.of(producto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Producto> getAllProducto() {
        List<Producto> productoList = new ArrayList<>();
        String query = "SELECT * FROM producto";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setProductoId(rs.getInt("productoId"));
                producto.setCodigoBarras(rs.getString("codigoBarras"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCategoriaProductoId(rs.getInt("categoriaProductoId"));
                productoList.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productoList;
    }
}
