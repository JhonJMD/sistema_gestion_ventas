package com.sistema_gestion_ventas.usuario.domain.entity;

public class Usuario {
    private int usuarioId;
    private String empleadoId;
    private String username;
    private String passwordHash;
    private String rol;

    public Usuario() {}

    public Usuario(int usuarioId, String empleadoId, String username, String passwordHash, String rol) {
        this.usuarioId = usuarioId;
        this.empleadoId = empleadoId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.rol = rol;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(String empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario {usuarioId=" + usuarioId + ", empleadoId=" + empleadoId + ", username=" + username + ", passwordHash=" + passwordHash + ", rol=" + rol + "}";
    }
}
