package com.sistema_gestion_ventas.ciudad.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;
import com.sistema_gestion_ventas.ciudad.domain.service.CuidadService;

public class CiudadRepository implements CuidadService{
    private Connection connection;

    public CiudadRepository() {
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
    public void createCiudad(Ciudad ciudad) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteCiudad(int ciudadid) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<Ciudad> findCiudadById(int ciudadid) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<Ciudad> getAllCiudad() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateCiudad(Ciudad ciudad) {
        // TODO Auto-generated method stub
        
    }

    
}
