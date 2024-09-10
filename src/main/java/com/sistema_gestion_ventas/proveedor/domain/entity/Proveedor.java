package com.sistema_gestion_ventas.proveedor.domain.entity;

public class Proveedor {
    private String proveedorId;
    private int tipoDocumentoId;
    private int tipoPersonaId;
    private String nombre;
    private int direccionId;
    private int telefonoId;
    private String email;

    public Proveedor() {}

    public Proveedor(String proveedorId, int tipoDocumentoId, int tipoPersonaId, String nombre, int direccionId, int telefonoId, String email) {
        this.proveedorId = proveedorId;
        this.tipoDocumentoId = tipoDocumentoId;
        this.tipoPersonaId = tipoPersonaId;
        this.nombre = nombre;
        this.direccionId = direccionId;
        this.telefonoId = telefonoId;
        this.email = email;
    }

    public String getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(String proveedorId) {
        this.proveedorId = proveedorId;
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

    @Override
    public String toString() {
        return "Proveedor {proveedorId=" + proveedorId + ", tipoDocumentoId=" + tipoDocumentoId + ", tipoPersonaId=" + tipoPersonaId + ", nombre=" + nombre + ", direccionId=" + direccionId + ", telefonoId=" + telefonoId + ", email=" + email + "}";
    }
}
