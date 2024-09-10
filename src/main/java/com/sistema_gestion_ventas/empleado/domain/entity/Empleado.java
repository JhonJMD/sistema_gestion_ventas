package com.sistema_gestion_ventas.empleado.domain.entity;

public class Empleado {
    private String empleadoId;
    private int tipoDocumento;
    private String nombre;
    private String apellido;
    private int direccionId;
    private int sucursalId;
    private String email;

    public Empleado() {}

    public Empleado(String empleadoId, int tipoDocumento, String nombre, String apellido, int direccionId, int sucursalId, String email) {
        this.empleadoId = empleadoId;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccionId = direccionId;
        this.sucursalId = sucursalId;
        this.email = email;
    }

    public String getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(String empleadoId) {
        this.empleadoId = empleadoId;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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

    public int getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Empleado {empleadoId=" + empleadoId + ", tipoDocumento=" + tipoDocumento + ", nombre=" + nombre + ", apellido=" + apellido + ", direccionId=" + direccionId + ", sucursalId=" + sucursalId + ", email=" + email + "}";
    }
}
