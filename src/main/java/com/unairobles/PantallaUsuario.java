package com.unairobles;

import javax.swing.*;
import java.util.List;

public class PantallaUsuario {
    private JButton resultado;
    private JButton clasificacion;
    private JPanel PantallaUsuario;

    public PantallaUsuario(List<Cuenta> cuentas){
        JFrame frame = new JFrame("Menu Usuario");
        frame.setContentPane(PantallaUsuario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
