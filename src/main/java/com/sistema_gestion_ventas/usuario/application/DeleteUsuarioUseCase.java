package com.sistema_gestion_ventas.usuario.application;

import com.sistema_gestion_ventas.usuario.domain.service.UsuarioService;

public class DeleteUsuarioUseCase {
    private final UsuarioService usuarioService;

    public DeleteUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(int usuarioId) {
        usuarioService.deleteUsuario(usuarioId);
    }
}
