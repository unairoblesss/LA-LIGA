package com.unairobles;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class Confeccionar {
    private JPanel Confeccionar;
    private JButton AÑADIR;
    private JButton QUITAR;
    private JList ListaEquipo;
    private JList PanelJugador;
    private JPanel PanelEquipo;
    int jugador;
    int jugadorDisponible;
    DefaultListModel modelo = new DefaultListModel();
    DefaultListModel modelo2 = new DefaultListModel();
    public Confeccionar(final int cod_equipo) {
        JFrame frame = new JFrame("PantallaConfeccionar");
        frame.setContentPane(Confeccionar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        List<Jugador> jugadoresEquipo = JugadorB.jugadores(cod_equipo);
        List<Jugador> jugadoresDisponibles = JugadorB.jugadoresDisponibles();
        for (int i = 0; i < jugadoresEquipo.size(); i++) {
            modelo2.addElement(jugadoresEquipo.get(i));
        }
        for (int i = 0; i < jugadoresDisponibles.size(); i++) {
            modelo.addElement(jugadoresDisponibles.get(i));
        }

        PanelJugador.setModel(modelo);
        ListaEquipo.setModel(modelo2);

        AÑADIR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        Jugador jugSelec = (Jugador) PanelJugador.getSelectedValue();
        modelo2.addElement(jugSelec);

        modelo.remove(PanelJugador.getSelectedIndex());

        jugadorDisponible = jugSelec.getCodJugador();

        JugadorB.jugadorAdquirido(jugadorDisponible, cod_equipo);

    }

});
        QUITAR.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
        Jugador jugSelec = (Jugador) ListaEquipo.getSelectedValue();
        modelo.addElement(jugSelec);
        modelo2.remove(ListaEquipo.getSelectedIndex());
        jugador = jugSelec.getCodJugador();
        JugadorB.jugadorAbandonado(jugador, cod_equipo);

        }
        });}}
