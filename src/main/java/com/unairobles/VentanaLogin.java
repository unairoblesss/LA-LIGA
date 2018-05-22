package com.unairobles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
import java.sql.Connection;


public class VentanaLogin  {
    private static JPanel VentanaLogin;
    private JTextField nickname;
    private JTextField password;
    private JButton login;
    private JLabel log;


    List<Cuenta> cuentas = com.unairobles.CuentaB.cuentas();
    private String nombreCuenta;


    public static void main(String[] args){
        JFrame frame = new JFrame("Login");
        frame.setContentPane(VentanaLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public VentanaLogin(){


        Connection conexion = BaseDatos.conectar();

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nickname.getText().equalsIgnoreCase("") && password.getText().equalsIgnoreCase("")) {
                    log.setText("Introduce datos");
                } else {
                    int y = 0;

                    while (y < cuentas.size() && !nickname.getText().equalsIgnoreCase(cuentas.get(y).getNombre())) {
                        y++;
                    }
                    int t = 0;

                    while (t < cuentas.size() && !password.getText().equalsIgnoreCase(cuentas.get(t).getContrasena())) {
                        t++;
                    }
                    if (t < cuentas.size() && y < cuentas.size()) {
                        log.setText("TODO OK");
                        if (cuentas.get(y).getTipoCuenta() == 1) {
                            PantallaAdmin ventanaAdmin = new PantallaAdmin();

                        } else if (cuentas.get(y).getTipoCuenta() == 2) {
                            nombreCuenta = nickname.getText();
                            PantallaDueno ventanaDueno = new PantallaDueno(nombreCuenta);


                        } else if (cuentas.get(y).getTipoCuenta() == 3) {
                            PantallaUsuario ventanaUsuario = new PantallaUsuario(cuentas);


                        }

                    } else {
                        log.setText("Error");
                    }

                }

            }
        });
    }


}
