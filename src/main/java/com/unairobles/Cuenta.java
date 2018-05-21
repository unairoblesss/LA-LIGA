package com.unairobles;

public class Cuenta {
    private String nombre;
    private String contrasena;
    private int tipoCuenta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Cuenta(String nombre, String contrasena, int tipoCuenta) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.tipoCuenta = tipoCuenta;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "nombre='" + nombre + '\'' +
                ", contrasña='" + contrasena + '\'' +
                ", tipoCuenta=" + tipoCuenta +
                '}';
    }

    /* ASOCIACIÓN -> NI PUTA IDEA PA QUE SIRVE ESTO
    private Duenyo duenyo;*/


}
