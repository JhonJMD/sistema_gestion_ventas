package com.sistema_gestion_ventas.usuario.application;

import java.util.Optional;

import com.sistema_gestion_ventas.usuario.domain.entity.Usuario;
import com.sistema_gestion_ventas.usuario.domain.service.UsuarioService;

public class AutenticarUsuarioUseCase {
    private final UsuarioService usuarioService;

    public AutenticarUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Optional<Usuario> execute(String username, String passwordHash) {
        return usuarioService.autenticarUsuario(username, passwordHash);
    }
}
