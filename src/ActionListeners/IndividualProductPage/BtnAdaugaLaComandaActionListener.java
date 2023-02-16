package ActionListeners.IndividualProductPage;

import Controller.ControllerPharmacy;
import Controller.ControllerProductPage;
import Model.Medicament;
import Model.PermissionLevel;
import Model.ProductPageModel;
import View.IndividualProductPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnAdaugaLaComandaActionListener implements ActionListener {

    private Medicament medicament;
    private int stoc;
    private IndividualProductPage view;
    public BtnAdaugaLaComandaActionListener(Medicament medicament, IndividualProductPage individualProductPage)
    {
        this.medicament = medicament;
        this.view = individualProductPage;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ControllerPharmacy.getClient().getPermissionLevel() == PermissionLevel.GUEST)
            JOptionPane.showMessageDialog(view.getFrame(),
                    "Logati-va pentru a efectua aceasta comanda!");
        else {
            int stoc = Integer.parseInt(view.getTxtCantitate().getText());
            if (medicament.getStoc() >= stoc) {
                ProductPageModel.getComanda().add(medicament);
                ProductPageModel.getStoc().add(stoc);
                medicament.setStoc(medicament.getStoc() - stoc);
                JOptionPane.showMessageDialog(view.getFrame(),
                        "Produs adaugat la comanda cu succes.");
            } else JOptionPane.showMessageDialog(view.getFrame(),
                    "Stoc insuficient!");
            System.out.println(medicament.getIdMedicament());
        }
    }
}
