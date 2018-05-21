package com.unairobles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Usuario {

    private String dni;
    private String nombre;
    private String fechaNac;
    private int edad;
    private String poblacion;


    Connection conexion=BaseDatos.conectar();

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", edad=" + edad +
                ", poblacion='" + poblacion + '\'' +
                '}';
    }
}