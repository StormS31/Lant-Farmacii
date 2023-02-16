package Controller;

import DAO.FarmacieDAO;
import Model.Farmacie;
import View.FormFarmacie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerFormFarmacie {
    private FormFarmacie view;
    public ControllerFormFarmacie(){
        this.view = new FormFarmacie();
        this.view.getFrame().setVisible(true);
        this.view.getBtnInsereaza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oras = view.getTxtOras().getText();
                String strada = view.getTxtStrada().getText();
                int numar = Integer.parseInt(view.getTxtNumar().getText());
                String program = view.getTxtProgram().getText();
                FarmacieDAO.adaugaFarmacie(oras, strada, numar, program);
                JOptionPane.showMessageDialog(view.getFrame(), "Farmacie adaugata cu succes la baza de date");
            }
        });
    }
}
