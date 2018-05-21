package com.unairobles;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class JugadorB {


    public static List<Jugador> jugadores(int codEquipo) {
        List<Jugador> listaJugadores = new ArrayList<>();
        Connection conexion = BaseDatos.conectar();
        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Jugador WHERE Equipo_codEquipo = " + codEquipo;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                listaJugadores.add(
                        new Jugador(
                                rs.getInt("codJugador"),
                                rs.getString("nombre"),
                                rs.getString("nick"),
                                rs.getInt("salario"),
                                rs.getString("fechaAlta"),
                                rs.getString("posicion")
                        )
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }        BaseDatos.desconectar();
        return listaJugadores;
    }

    public static Jugador buscarJugador(int codigo) {

        Jugador jugador = null;

        Connection conexion = BaseDatos.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Jugador where codJugador =" + codigo;
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                jugador = new Jugador(
                        rs.getInt("codJugador"),
                        rs.getString("Nombre"),
                        rs.getString("Nick"),
                        rs.getInt("Salario"),
                        rs.getString("FechaAlta"),
                        rs.getString("Posicion"),
                        rs.getInt("Equipo_codEquipo")
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        BaseDatos.desconectar();

        return jugador;
    }

    public static void guardar(Jugador jugador) {

        Connection conexion = BaseDatos.conectar();

        try {

            String sql;
            java.sql.PreparedStatement st;

            if (jugador.getCodJugador() == -1) {
                sql = "INSERT INTO Jugador (`nombre`, `nick`, `salario`, `fechaAlta`, `Equipo_codEquipo`,`posicion`) " +
                        "VALUES (?,?,?,?,?,?)";
                st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                //st.setString(1, jugador.getDni());
                st.setString(1, jugador.getNombre());
                //  st.setString(3, jugador.getFechaNac());
                // st.setInt(4, jugador.getEdad());
                //  st.setString(5, jugador.getPoblacion());
                st.setString(2, jugador.getNickname());
                st.setInt(3, jugador.getSalario());
                st.setString(4, jugador.getFechaAlta());
                st.setInt(5, jugador.getEquipo().getCodEquipo());
                st.setString(6, jugador.getPosicion());
            } else {
                sql = "UPDATE Jugador SET nombre=?, nick=?, salario=?, fechaAlta=?, Equipo_codEquipo=?, posicion=? " +
                        "WHERE codJugador =" + jugador.getCodJugador();

                st = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                st.setString(4, jugador.getFechaAlta());
                st.setInt(5, jugador.getEquipo().getCodEquipo());
                st.setString(6, jugador.getPosicion());

            }
            int filasAfectadas = st.executeUpdate();
            if (jugador.getCodJugador() == -1 && filasAfectadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    jugador.setCodJugador(rs.getInt(1));
                } }
            st.close();
        } catch (SQLException ex) { ex.printStackTrace();
        }
        BaseDatos.desconectar();

    }

    /*Jugadores TODOS*/
    public static List<Jugador> jugadoresDisponibles() {

        // Lista para dejar los objetos
        List<Jugador> listaJugadores = new ArrayList<>();

        // Conexión a la BD
        Connection conexion = BaseDatos.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Jugador WHERE Equipo_codEquipo is null";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                listaJugadores.add(
                        new Jugador(
                                rs.getInt("codJugador"),
                                rs.getString("nombre"),
                                rs.getString("nick"),
                                rs.getInt("salario"),
                                rs.getString("fechaAlta"),
                                rs.getString("posicion"))
                );}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        BaseDatos.desconectar();
        return listaJugadores;
    }
    public static void jugadorAdquirido(int codJugador, int codEquipo) {

        Jugador jugador = null;
        String sql;
        PreparedStatement st;
        Connection conexion = BaseDatos.conectar();
        try {

            sql = "UPDATE Jugador " +
                    "SET Equipo_codEquipo = ? " +
                    "WHERE codJugador = ";
            st = conexion.prepareStatement(sql);

            st.setInt(2, codJugador);
            st.setInt(1, codEquipo);

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        BaseDatos.desconectar();
    }

    public static void jugadorAbandonado(int codJugador, int codEquipo) {
        Jugador jugador = null;
        String sql;
        PreparedStatement st;
        Connection conexion = BaseDatos.conectar();
        try {
            sql = "UPDATE Jugador " +
                    "SET Equipo_codEquipo = null " +
                    "WHERE codJugador = ";
            st = conexion.prepareStatement(sql);

            st.setInt(1, codJugador);


            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        BaseDatos.desconectar();

    }

}


