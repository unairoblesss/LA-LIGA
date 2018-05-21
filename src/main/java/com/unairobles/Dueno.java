package com.unairobles;

import java.util.List;

public class Dueno extends Usuario{
    private int codDueno;
    private String nombre;

    public Dueno(int codDueno, String nombre) {
        this.codDueno = codDueno;
        this.nombre = nombre;
    }
    public int getCodDueno() {
        return codDueno;
    }

    public void setCodDueno(int codDueno) {
        this.codDueno = codDueno;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }@Override
    public String toString() {
        return "Duenyo{" +
                "codDueno=" + codDueno +
                ", nombre='" + nombre + '\'' +
                ", cuenta=" + cuenta +
                ", equipos=" + equipos +
                '}';
    }

    private Cuenta cuenta;
    private List<Equipo> equipos;


}



