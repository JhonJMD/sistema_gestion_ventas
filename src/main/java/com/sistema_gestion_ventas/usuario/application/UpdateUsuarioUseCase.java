package com.sistema_gestion_ventas.usuario.application;

import com.sistema_gestion_ventas.usuario.domain.entity.Usuario;
import com.sistema_gestion_ventas.usuario.domain.service.UsuarioService;

public class UpdateUsuarioUseCase {
    private final UsuarioService usuarioService;

    public UpdateUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(Usuario usuario) {
        usuarioService.updateUsuario(usuario);
    }
}
