package com.unairobles;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private int codEquipo;
    private String nombre;
    private int anoFundacion;

    // CONSTRUCTORES
    public Equipo(int codEquipo, String nombre, int anoFundacion, int dueno) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.anoFundacion = anoFundacion;
        this.dueno = dueno;/*NI GETTES NI SETTERS NI NAH*/
    }

    public Equipo(int codEquipo, String nombre) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
    }
    public int getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(int codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnoFundacion() {
        return anoFundacion;
    }

    public void setAnoFundacion(int anoFundacion) {
        this.anoFundacion = anoFundacion;
    }
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    @Override
    public String toString() {
        return "Equipo{" +
                "codEquipo=" + codEquipo +
                ", nombre='" + nombre + '\'' +
                ", anoFundacion=" + anoFundacion +
                ", dueno=" + dueno +
                '}';
    }
    private int dueno;
    private List<Jugador> jugadores;


    private List<Jugador> listaJugadores = new ArrayList<>();
    private List<Dueno> listaDuenos = new ArrayList<>();

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public List<Dueno> getListaDuenyos() {
        return listaDuenos;
    }




}