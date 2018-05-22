package com.unairobles;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VerJugador {
    private JScrollPane panelJugadores;
    private JPanel VerJugadores;
    private JButton enviar2;
    private JTable tabla;
    private JList listaJugador;
    private List<Jugador> jugadores;


    public VerJugador(){
    JFrame frame = new JFrame("Ver Jugador");
    frame.setContentPane(VerJugadores);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);


    actualizarLista();
    tabla = new JTable();
    tabla.setModel(new DefaultTableModel());
    panelJugadores.setViewportView(tabla);
        listaJugador.addListSelectionListener(e -> {

            Jugador j = (Jugador) listaJugador.getSelectedValue();

        });
}
        private void actualizarLista() {
            DefaultListModel<Jugador> modelo = new DefaultListModel<>();

            for (Jugador j : jugadores) {
                modelo.addElement(j);
            }

            listaJugador.setModel(modelo);
        }

        public JPanel getVerJugadores() {
            return VerJugadores;
        }




    }
