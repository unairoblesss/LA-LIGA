package com.unairobles;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EliminarEquipo {
    private JList equiposLista;
    private JButton Eliminar;
    private JPanel ElimiarEquipo;
    private JPanel listaEquip;
    private List<Equipo> equipos;
    public EliminarEquipo() {

        JFrame frame = new JFrame("EliminarEquipo");
        frame.setContentPane(ElimiarEquipo);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        equipos = EquipoB.equipos();
        actualizarLista();

        Eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipo equipoSeleccionado = (Equipo) equiposLista.getSelectedValue();
                EquipoB.eliminar(equipoSeleccionado);/* Crear metodo eliminar*/
                actualizarLista();
                EquipoB.equipos();
            }
        });
        equiposLista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Eliminar.setEnabled(true);
            }
        });
    }

    private void actualizarLista() {
        DefaultListModel<Equipo> modelo = new DefaultListModel<>();

        for (Equipo j : equipos) {
            modelo.addElement(j);
        }

        equiposLista.setModel(modelo);
    }
}
