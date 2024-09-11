package com.sistema_gestion_ventas.categoria_producto.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.categoria_producto.domain.entity.CategoriaProducto;
import com.sistema_gestion_ventas.categoria_producto.domain.service.CategoriaProductoService;

public class CategoriaProductoRepository implements CategoriaProductoService {
    private Connection connection;

    public CategoriaProductoRepository() {
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
    public void createCategoriaProducto(CategoriaProducto categoriaproducto) {
        String query = "INSERT INTO categoriaproducto (categoriaProductoId, nombre, descripcion) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, categoriaproducto.getCategoriaProductoId());
            ps.setString(2, categoriaproducto.getNombre());
            ps.setString(3, categoriaproducto.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategoriaProducto(CategoriaProducto categoriaproducto) {
        String query = "UPDATE categoriaproducto SET nombre = ?, descripcion = ? WHERE categoriaProductoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, categoriaproducto.getNombre());
            ps.setString(2, categoriaproducto.getDescripcion());
            ps.setInt(3, categoriaproducto.getCategoriaProductoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategoriaProducto(int categoriaProductoId) {
        String query = "DELETE FROM categoriaproducto WHERE categoriaProductoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, categoriaProductoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<CategoriaProducto> findCategoriaProductoById(int categoriaProductoId) {
        String query = "SELECT * FROM categoriaproducto WHERE categoriaProductoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, categoriaProductoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    CategoriaProducto categoriaproducto = new CategoriaProducto();
                    categoriaproducto.setCategoriaProductoId(rs.getInt("categoriaProductoId"));
                    categoriaproducto.setNombre(rs.getString("nombre"));
                    categoriaproducto.setDescripcion(rs.getString("descripcion"));
                    return Optional.of(categoriaproducto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<CategoriaProducto> getAllCategoriaProducto() {
        List<CategoriaProducto> categoriaproductoList = new ArrayList<>();
        String query = "SELECT * FROM categoriaproducto";
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                CategoriaProducto categoriaproducto = new CategoriaProducto();
                categoriaproducto.setCategoriaProductoId(rs.getInt("categoriaProductoId"));
                categoriaproducto.setNombre(rs.getString("nombre"));
                categoriaproducto.setDescripcion(rs.getString("descripcion"));
                categoriaproductoList.add(categoriaproducto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoriaproductoList;
    }
}
