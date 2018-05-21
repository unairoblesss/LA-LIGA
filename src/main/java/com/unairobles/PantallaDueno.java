package com.unairobles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import static com.unairobles.JugadorB.jugadores1;
public class PantallaDueno {
    private JPanel PantallaDueño;
    private JButton Resultados;
    private JComboBox equiposelect;
    private JComboBox jugadoreselect;
    private JButton ASIGNAR;
    private JButton SelectEquipo;
    private JButton SelectJugadores;
    private int codDueno;
    private Object Equipo;
    private int cod_equipo;
    private String nEquipo;
    public PantallaDueno(String nombre) {
        JFrame frame = new JFrame("PantallaDueno");
        frame.setContentPane(PantallaDueño);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        codDueno = DuenoB.dueno(nombre).getCodDueno();
        final List<Equipo> equiposDueno = EquipoB.equipos(codDueno);
        for (int i = 0; i < equiposDueno.size(); i++) {
            String nomEquipo = equiposDueno.get(i).getNombre();
            equiposelect.addItem(nomEquipo);
        }


        ASIGNAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numEquipo = equiposelect.getSelectedIndex();
                cod_equipo = equiposDueno.get(numEquipo).getCodEquipo();

                Confeccionar pantallaConfeccionar = new Confeccionar(cod_equipo);
            }

        });
    }}
