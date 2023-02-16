package Controller;

import DAO.AngajatDAO;
import Model.Angajat;
import Util.PassEncryption;
import View.FormAngajat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControllerFormAngajat {
    private FormAngajat view;
    public ControllerFormAngajat(int mode, JTable table){
        this.view = new FormAngajat(mode);
        this.view.getFrame().setVisible(true);
        //mode = 0 -> adaugam angajati
        //mode = 1 -> editam angajati
        view.getBtnExecuta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String nume = view.getTxtUsername().getText();
                    int idFarmacie = Integer.parseInt(view.getTxtIdFarmacie().getText());
                    String CNP = view.getTxtCnp().getText();
                    String email = view.getTxtEmail().getText();
                    String parola = PassEncryption.computePassword(view.getTxtParolaSauIdAngajat().getText());
                    AngajatDAO.adaugaAngajat(nume, idFarmacie,CNP, email, parola);
                    JOptionPane.showMessageDialog(view.getFrame(), "Inserare executata cu succes!");
                    view.getFrame().dispose();
            }
        });
    }
}
