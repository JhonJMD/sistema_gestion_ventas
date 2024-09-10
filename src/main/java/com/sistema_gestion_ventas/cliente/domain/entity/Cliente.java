package com.sistema_gestion_ventas.cliente.domain.entity;

public class Cliente {
    private int clienteId;
    private int tipoDocumentoId;
    private int tipoPersonaId;
    private String nombre;
    private String apellido;
    private int direccionId;
    private int telefonoId;
    private String email;
    private double totalGastado;
    private int comprasRealizadas;

    public Cliente() {}

    public Cliente(int clienteId, int tipoDocumentoId, int tipoPersonaId, String nombre, String apellido, int direccionId, int telefonoId, String email, double totalGastado, int comprasRealizadas) {
        this.clienteId = clienteId;
        this.tipoDocumentoId = tipoDocumentoId;
        this.tipoPersonaId = tipoPersonaId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccionId = direccionId;
        this.telefonoId = telefonoId;
        this.email = email;
        this.totalGastado = totalGastado;
        this.comprasRealizadas = comprasRealizadas;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(int tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public int getTipoPersonaId() {
        return tipoPersonaId;
    }

    public void setTipoPersonaId(int tipoPersonaId) {
        this.tipoPersonaId = tipoPersonaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDireccionId() {
        return direccionId;
    }

    public void setDireccionId(int direccionId) {
        this.direccionId = direccionId;
    }

    public int getTelefonoId() {
        return telefonoId;
    }

    public void setTelefonoId(int telefonoId) {
        this.telefonoId = telefonoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(double totalGastado) {
        this.totalGastado = totalGastado;
    }

    public int getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(int comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
    }

    @Override
    public String toString() {
        return "Cliente {clienteId=" + clienteId + ", tipoDocumentoId=" + tipoDocumentoId + ", tipoPersonaId=" + tipoPersonaId + ", nombre=" + nombre + ", apellido=" + apellido + ", direccionId=" + direccionId + ", telefonoId=" + telefonoId + ", email=" + email + ", totalGastado=" + totalGastado + ", comprasRealizadas=" + comprasRealizadas + "}";
    }
}
