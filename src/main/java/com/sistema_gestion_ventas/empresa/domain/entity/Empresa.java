package com.sistema_gestion_ventas.empresa.domain.entity;

public class Empresa {
    private int empresaId;
    private String nombre;
    private int direccionId;
    private String representanteLegal;

    public Empresa() {}

    public Empresa(int empresaId, String nombre, int direccionId, String representanteLegal) {
        this.empresaId = empresaId;
        this.nombre = nombre;
        this.direccionId = direccionId;
        this.representanteLegal = representanteLegal;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
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

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    @Override
    public String toString() {
        return "Empresa {empresaId=" + empresaId + ", nombre=" + nombre + ", direccionId=" + direccionId + ", representanteLegal=" + representanteLegal + "}";
    }
}
