package com.unairobles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class CuentaB {

    // Lista de todas las cuentas
    public static List<Cuenta> cuentas() {
        VentanaLogin ventanaLogin;
        List<Cuenta> lista = new ArrayList<>();
        Connection conexion = BaseDatos.conectar();

        try {
            Statement st = conexion.createStatement();
            String sql = "SELECT * FROM Cuenta";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add (
                        new Cuenta(rs.getString("nombre"),
                                rs.getString("contrasena"),
                                rs.getInt("tipoCuenta")
                        )
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        BaseDatos.desconectar();

        return lista;
    }


}
