package com.unairobles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PantallaAdmin {
    private JButton equipoButton;
    private JButton jugadorButton;
    private JButton dueñoButton;
    private JButton usuarioButton;
    private JButton verButton;
    private JPanel PantallaAdmin;
    private JButton introButton;
    private final List<Dueno> duenos = new ArrayList<>();
    private final List<Jugador> jugadores = new ArrayList<>();


    public PantallaAdmin() {
        JFrame frame = new JFrame("PantallaAdmin1");
        frame.setContentPane(PantallaAdmin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        equipoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministrarEquipo pantallaEquipo=new AdministrarEquipo();
            }
        });
        jugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministrarJugador pantallajugador=new AdministrarJugador();
            }
        });
        dueñoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministrarDueno pantalladueno=new AdministrarDueno();
            }
        });
        usuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministrarUsuario pantallausuario=new AdministrarUsuario();
            }
        });
    }
}
