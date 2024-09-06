package com.sistema_gestion_ventas.pais.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.pais.domain.entity.Pais;
import com.sistema_gestion_ventas.pais.domain.service.PaisService;


public class PaisRespository implements PaisService{
    private Connection connection;

    public PaisRespository() {
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
    public void createPais(Pais pais) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deletePais(int paisid) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<Pais> findPais(int paisid) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void updatePais(Pais pais) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Pais> getAllPais() {
        // TODO Auto-generated method stub
        return null;
    }
}
