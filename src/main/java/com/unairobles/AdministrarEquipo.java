package com.unairobles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministrarEquipo {
    private JButton ACTUALIZARButton;
    private JButton CREARButton;
    private JButton ELIMINARButton;
    private JPanel AdministrarEQ;
    private JButton VERButton;

    public AdministrarEquipo() {
        JFrame frame = new JFrame("AdministrarEquipo");
        frame.setContentPane(AdministrarEQ);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        CREARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoEquipo pantalacrearequipo=new NuevoEquipo();
            }
        });

        VERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerEquipo pantallaverequipos=new VerEquipo();
            }
        });
        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarEquipo pantallaactualizarequipo=new EditarEquipo();
            }
        });
        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarEquipo pantallaborrarequipo=new EliminarEquipo();
            }
        });
    }
}

