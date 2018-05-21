package com.unairobles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class DuenoB {

    // Para saber el código del dueño
    public static Dueno dueno(String nombre) {
        Dueno dueno = null;

        // Conexión a la BD
        Connection conexion = BaseDatos.conectar();

        try {

            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Dueño where Cuenta_nombre = '" + nombre +"'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                dueno = new Dueno(
                        rs.getInt("codDueño"),
                        rs.getString("Nombre")
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        BaseDatos.desconectar();

        return dueno;
    }

    // Para saber los equipos que tiene el dueño


}
