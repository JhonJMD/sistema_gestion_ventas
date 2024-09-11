package com.sistema_gestion_ventas.usuario.application;

import java.util.List;
import com.sistema_gestion_ventas.usuario.domain.entity.Usuario;
import com.sistema_gestion_ventas.usuario.domain.service.UsuarioService;

public class GetAllUsuarioUseCase {
    private final UsuarioService usuarioService;

    public GetAllUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public List<Usuario> execute() {
        return usuarioService.getAllUsuario();
    }
}
