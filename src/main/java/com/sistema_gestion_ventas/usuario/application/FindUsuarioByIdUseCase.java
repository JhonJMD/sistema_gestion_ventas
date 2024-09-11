package com.sistema_gestion_ventas.usuario.application;

import java.util.Optional;
import com.sistema_gestion_ventas.usuario.domain.entity.Usuario;
import com.sistema_gestion_ventas.usuario.domain.service.UsuarioService;

public class FindUsuarioByIdUseCase {
    private final UsuarioService usuarioService;

    public FindUsuarioByIdUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Optional<Usuario> execute(int usuarioId) {
        return usuarioService.findUsuarioById(usuarioId);
    }
}
