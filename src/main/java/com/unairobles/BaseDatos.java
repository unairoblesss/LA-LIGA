package com.unairobles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    private static Connection conexion;

    public static Connection conectar(){

        try{
            if (conexion==null || conexion.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver");
                String servidor ="10.10.10.9";
                String puerto = "1521";
                String bd="La Liga Oficial";
                String login="system";
                String password="oracle";
                String opciones = "?verifyServerCertificate=false&useSSL=true&requireSSL=false";
                String url = "jdbc:mysql://" + servidor + ":" + puerto + "/" + bd + opciones;
                conexion = DriverManager.getConnection(url,login,password);
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return conexion;
    }

    public static void desconectar(){
        if(conexion!= null) {
            try{
                conexion.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


}