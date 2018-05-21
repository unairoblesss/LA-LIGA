package com.unairobles;

import com.sun.tools.javac.code.Scope;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class NuevoEquipo {
    private JButton Guardar;
    private JTextField nombreEquip;
    private JTextField DuenoEqui;
    private JPanel NuevoEquipo;
    private List<Equipo> equipos = EquipoB.equipos();
    private List<Dueno> duenos = DuenoB.dueno();
    public NuevoEquipo() {
        JFrame frame = new JFrame("NuevoEquipo");
        frame.setContentPane(NuevoEquipo);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dueno duenoEncontrado;
                int codDueno = Integer.parseInt(DuenoEqui.getText());
                int i = 0;
                while (i < duenos.size() && duenos.get(i).getCodDueno() != codDueno) {
                    i++;
                }
                if (i < duenos.size()) {
                    //encontrado
                    duenoEncontrado = duenos.get(i);
                } else {
                    duenoEncontrado = null;
                }
                System.out.println(duenoEncontrado.getCodDueno());
                Equipo crearEquipo = new Equipo(nombreEquip.getText(), duenoEncontrado);
                equipos = EquipoB.equipos();
            }
        });
    }
}
