package com.unairobles;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipoB {
    public static List<Equipo> equipos(int codDueno) {

        List<Equipo> listaEquipos = new ArrayList<>();

        Connection conexion = BaseDatos.conectar();

        try {
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Equipo" /*WHERE Dueño_codDueño = " + codDueno*/;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                listaEquipos.add(
                        new Equipo(
                                rs.getInt("codEquipo"),
                                rs.getString("nombre"),
                                rs.getInt("anyoFundacion"),
                                rs.getInt("Dueño_codDueño")
                        )
                );

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        BaseDatos.desconectar();

        return listaEquipos;


    }

    public static Equipo equipo(int codDueno, String nombreEquipo) {

        Equipo equipo = null;

        Connection conexion = BaseDatos.conectar();

        try {
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Equipo WHERE Dueño_codDueño = " + codDueno + " AND nombre = '" + nombreEquipo + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                equipo = new Equipo(
                        rs.getInt("codEquipo"),
                        rs.getString("nombre"),
                        rs.getInt("anoFundacion"),
                        rs.getInt("Dueño_codDueño")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        BaseDatos.desconectar();

        return equipo;

    }
    public boolean buscarEquipo(int codEquipo) {
        Connection conexion = BaseDatos.conectar();
        boolean estado=true;

        try {

            Statement st = conexion.createStatement();
            String sql = "select * from Equipo where codEquipo=" + codEquipo;
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                estado=true;
            }
            else{
                estado= false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return estado;

    }
}

