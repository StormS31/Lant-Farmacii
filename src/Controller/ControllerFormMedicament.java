package Controller;

import DAO.MedicamentDAO;
import View.FormFarmacie;
import View.FormMedicament;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControllerFormMedicament {
    private FormMedicament view;
    public ControllerFormMedicament(JFrame callerView)
    {
        view = new FormMedicament();
        view.getFrame().setVisible(true);
        callerView.setVisible(false);
        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                callerView.setVisible(true);
            }
        });
        view.getBtnAdauga().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String denumire = view.getTxtDenumire().getText();
                int stoc = Integer.parseInt(view.getTxtStoc().getText());
                String categorie = view.getTxtCategorie().getText();
                String descriere = view.getTxtDescriere().getText().replaceAll("\n", " ");
                String furnizor = view.getTxtFurnizor().getText();
                float pret = Float.parseFloat(view.getTxtPret().getText());
                MedicamentDAO.adaugaMedicament(denumire, stoc, categorie, descriere, furnizor, pret);
                JOptionPane.showMessageDialog(view.getFrame(), "Medicament adaugat cu succes la baza de date!");
                callerView.setVisible(true);
                view.getFrame().dispose();
            }
        });
    }
}
