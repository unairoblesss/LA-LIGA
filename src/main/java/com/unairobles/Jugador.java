package com.unairobles;


public class Jugador extends Usuario {
    private int codJugador;
    private String nombre;
    private String nickname;
    private int salario;
    private String fechaAlta;
    private String posicion;

    public Jugador(int codJugador, String nombre, String nickname, int salario, String fechaAlta, String posicion) {
        this.codJugador = codJugador;
        this.nombre = nombre;
        this.nickname = nickname;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
        this.posicion = posicion;
    }

    public Jugador(String nombre, String nickname, int salario, String fechaAlta, String posicion, Equipo equipo) {
        this.nombre=nombre;
        this.nickname = nickname;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    public Jugador(String dni, String nombre, String fechaNac, int edad, String poblacion, String nickname, int salario, String fechaAlta, String posicion, Equipo equipo) {
        this.codJugador=-1;
        this.nickname = nickname;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    public Jugador(String nombre) {
        this.nombre=nombre;
    }

    public Jugador(int codJugador, String nombre, String nickname, int salario, String fechaAlta, String posicion, int codEquipo) {
        this.nombre=nombre;
        this.codJugador = codJugador;
        this.nickname = nickname;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
        this.posicion = posicion;
        this.equipo = equipo;

    }

    public int getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(int codJugador) {
        this.codJugador = codJugador;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return nickname ;
    }

    private Equipo equipo;
    private VerJugador verjugador1;
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
