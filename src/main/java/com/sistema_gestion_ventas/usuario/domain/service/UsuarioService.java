package com.sistema_gestion_ventas.usuario.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.usuario.domain.entity.Usuario;

public interface UsuarioService {
    void createUsuario(Usuario usuario);
    void updateUsuario(Usuario usuario);
    void deleteUsuario(int usuarioId);
    Optional<Usuario> findUsuarioById(int usuarioId);
    List<Usuario> getAllUsuario();
    Optional<Usuario> autenticarUsuario(String username, String passwordHash);
}
