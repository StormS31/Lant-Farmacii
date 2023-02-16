package ActionListeners.ProdusePage;

import Controller.ControllerPharmacy;
import DAO.ComandaDAO;
import Model.Medicament;
import Model.ProductPageModel;
import View.ProductPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnFinalizeazaComandaActionListener implements ActionListener {

    private ProductPageModel productPageModel;
    private ProductPage view;
    public BtnFinalizeazaComandaActionListener(ProductPage view,ProductPageModel productPageModel) {
        this.productPageModel = productPageModel;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ProductPageModel.getComanda().isEmpty())
            JOptionPane.showMessageDialog(view.getFrame(),
                    "Cos de cumparaturi gol, adauga produse pentru a finaliza o comanda!");
        else {
            float finalPrice = 0.0f;
            int i = -1;
            for (Medicament medicament : ProductPageModel.getComanda()) {
                ++i;
                finalPrice += medicament.getPret() * ProductPageModel.getStoc().get(i);
            }
            JOptionPane.showMessageDialog(view.getFrame(),
                    "Comanda finalizata cu succes, pret total: " + finalPrice + " RON!");
            i = -1;
            ComandaDAO.insertIntoComanda(ControllerPharmacy.getClient().getIdClient(), ProductPageModel.computeTotalPrice());
            for (Medicament medicament : ProductPageModel.getComanda()) {
                ++i;
                ComandaDAO.insertIntoComprod(medicament.getIdMedicament(), ComandaDAO.getInsertedId(), ProductPageModel.getStoc().get(i));
            }
            ProductPageModel.getComanda().clear();
            finalPrice = 0;
        }
    }
}
