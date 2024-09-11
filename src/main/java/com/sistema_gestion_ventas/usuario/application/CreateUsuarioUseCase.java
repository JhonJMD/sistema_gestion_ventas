package com.sistema_gestion_ventas.usuario.application;

import com.sistema_gestion_ventas.usuario.domain.entity.Usuario;
import com.sistema_gestion_ventas.usuario.domain.service.UsuarioService;

public class CreateUsuarioUseCase {
    private final UsuarioService usuarioService;

    public CreateUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(Usuario usuario) {
        usuarioService.createUsuario(usuario);
    }
}
