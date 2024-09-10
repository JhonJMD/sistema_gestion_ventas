package com.sistema_gestion_ventas.categoria_producto.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.categoria_producto.domain.entity.CategoriaProducto;
import com.sistema_gestion_ventas.categoria_producto.domain.service.CategoriaProductoService;

public class CategoriaProdcutoRepository implements CategoriaProductoService{
    private Connection connection;

    public CategoriaProdcutoRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCategoriaProdcuto(CategoriaProducto CategoriaProducto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteCategoriaProducto(int CategoriaProductoId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<CategoriaProducto> findCategoriaProductoById(int CategoriaProductoId) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<CategoriaProducto> getAllCategoriaProducto() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateCategoriaProducto(CategoriaProducto CategoriaProducto) {
        // TODO Auto-generated method stub
        
    }
}
