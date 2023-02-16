package Controller;

import ActionListeners.ProdusePage.BtnCautaActionListener;
import DAO.MedicamentDAO;
import Model.AngajatPageModel;
import Model.ProductPageModel;
import View.AngajatPage;
import View.ProductPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControllerAngajatPage {
    private AngajatPage view;
    private static int lastPositionClicked = 0;
    private AngajatPageModel model;

    public ControllerAngajatPage(JFrame viewMainPage) {
        view = new AngajatPage();
        model = new AngajatPageModel();
        view.getFrame().setVisible(true);
        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                viewMainPage.setVisible(true);
            }
        });
        view.getTable().setModel(model.getChosenModel());
        ProductPage productPageView = new ProductPage(true);
        productPageView.getFrame().setVisible(true);
        productPageView.getSearchButton().addActionListener(new BtnCautaActionListener(productPageView, new ProductPageModel(productPageView.getTable())));
        view.getBtnExecuta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getOperatiune().getSelectedItem().toString().toLowerCase().contains("modifica medicament"))
                {
                    int idMedicamentDeModificat = Integer.parseInt(JOptionPane.showInputDialog(view.getFrame(), "Introduceti id-ul medicamentului pe care il modificati: "));
                    int setStoc = Integer.parseInt(JOptionPane.showInputDialog(view.getFrame(), "Introduceti noul stoc"));
                    MedicamentDAO.modificaMedicament(idMedicamentDeModificat, setStoc);
                    view.getTable().setModel(model.getChosenModel());
                }
                else if(view.getOperatiune().getSelectedItem().toString().toLowerCase().contains("adauga medicament"))
                {
                    int idMedicamentDeModificat = Integer.parseInt(JOptionPane.showInputDialog(view.getFrame(), "Introduceti id-ul medicamentului pe care il adaugati: "));
                    int setStoc = Integer.parseInt(JOptionPane.showInputDialog(view.getFrame(), "Introduceti stocul"));
                    MedicamentDAO.adaugaMedicamentLaFarmacie(idMedicamentDeModificat, setStoc);
                    view.getTable().setModel(model.getChosenModel());
                }
            }
        });
    }
}
