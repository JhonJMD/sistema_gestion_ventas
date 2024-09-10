package com.sistema_gestion_ventas.empleado.infrastructure.out;

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

import com.sistema_gestion_ventas.empleado.domain.entity.Empleado;
import com.sistema_gestion_ventas.empleado.domain.service.EmpleadoService;

public class EmpleadoRepository implements EmpleadoService {
    private Connection connection;

    public EmpleadoRepository() {
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
    public void createEmpleado(Empleado empleado) {
        String query = "INSERT INTO empleado (empleadoId, tipoDocumento, nombre, apellido, direccionId, sucursalId, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, empleado.getEmpleadoId());
            ps.setInt(2, empleado.getTipoDocumento());
            ps.setString(3, empleado.getNombre());
            ps.setString(4, empleado.getApellido());
            ps.setInt(5, empleado.getDireccionId());
            ps.setInt(6, empleado.getSucursalId());
            ps.setString(7, empleado.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        String query = "UPDATE empleado SET tipoDocumento = ?, nombre = ?, apellido = ?, direccionId = ?, sucursalId = ?, email = ? WHERE empleadoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, empleado.getTipoDocumento());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellido());
            ps.setInt(4, empleado.getDireccionId());
            ps.setInt(5, empleado.getSucursalId());
            ps.setString(6, empleado.getEmail());
            ps.setString(7, empleado.getEmpleadoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmpleado(String empleadoId) {
        String query = "DELETE FROM empleado WHERE empleadoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, empleadoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Empleado> findEmpleadoById(String empleadoId) {
        String query = "SELECT * FROM empleado WHERE empleadoId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, empleadoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Empleado empleado = new Empleado();
                    empleado.setEmpleadoId(rs.getString("empleadoId"));
                    empleado.setTipoDocumento(rs.getInt("tipoDocumento"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setApellido(rs.getString("apellido"));
                    empleado.setDireccionId(rs.getInt("direccionId"));
                    empleado.setSucursalId(rs.getInt("sucursalId"));
                    empleado.setEmail(rs.getString("email"));
                    return Optional.of(empleado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Empleado> getAllEmpleado() {
        List<Empleado> empleadoList = new ArrayList<>();
        String query = "SELECT * FROM empleado";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setEmpleadoId(rs.getString("empleadoId"));
                empleado.setTipoDocumento(rs.getInt("tipoDocumento"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setDireccionId(rs.getInt("direccionId"));
                empleado.setSucursalId(rs.getInt("sucursalId"));
                empleado.setEmail(rs.getString("email"));
                empleadoList.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleadoList;
    }
}
