package com.sistema_gestion_ventas.usuario.infrastructure.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.sistema_gestion_ventas.usuario.domain.entity.Usuario;
import com.sistema_gestion_ventas.usuario.domain.service.UsuarioService;

public class UsuarioRepository implements UsuarioService {
    private Connection connection;

    public UsuarioRepository() {
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
    public void createUsuario(Usuario usuario) {
        String query = "INSERT INTO usuario (usuarioId, empleadoId, username, passwordHash, rol) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, usuario.getUsuarioId());
            ps.setString(2, usuario.getEmpleadoId());
            ps.setString(3, usuario.getUsername());
            ps.setString(4, usuario.getPasswordHash());
            ps.setString(5, usuario.getRol());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        String query = "UPDATE usuario SET empleadoId = ?, username = ?, passwordHash = ?, rol = ? WHERE usuarioId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, usuario.getEmpleadoId());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getPasswordHash());
            ps.setString(4, usuario.getRol());
            ps.setInt(5, usuario.getUsuarioId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUsuario(int usuarioId) {
        String query = "DELETE FROM usuario WHERE usuarioId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, usuarioId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Usuario> findUsuarioById(int usuarioId) {
        String query = "SELECT * FROM usuario WHERE usuarioId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setUsuarioId(rs.getInt("usuarioId"));
                    usuario.setEmpleadoId(rs.getString("empleadoId"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setPasswordHash(rs.getString("passwordHash"));
                    usuario.setRol(rs.getString("rol"));
                    return Optional.of(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Usuario> getAllUsuario() {
        List<Usuario> usuarioList = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuarioId(rs.getInt("usuarioId"));
                usuario.setEmpleadoId(rs.getString("empleadoId"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPasswordHash(rs.getString("passwordHash"));
                usuario.setRol(rs.getString("rol"));
                usuarioList.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarioList;
    }

    @Override
    public Optional<Usuario> autenticarUsuario(String username, String passwordHash) {
        String query = "SELECT * FROM usuario WHERE username = ? AND passwordHash = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, passwordHash);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setUsuarioId(rs.getInt("usuarioId"));
                    usuario.setEmpleadoId(rs.getString("empleadoId"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setPasswordHash(rs.getString("passwordHash"));
                    usuario.setRol(rs.getString("rol"));
                    return Optional.of(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
