package Controller;

import ActionListeners.MainPage.LogInActionListener;
import ActionListeners.ProdusePage.BtnCautaActionListener;
import ActionListeners.ProdusePage.BtnFinalizeazaComandaActionListener;
import ActionListeners.ProdusePage.ComboBoxActionListener;
import ActionListeners.ProdusePage.TableProductClickedMouseListener;
import Model.Client;
import Model.ProductPageModel;
import View.ProductPage;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ControllerProductPage {
    private Client client;
    private ProductPage view;
    private ProductPageModel productPageModel;

    public void showView() {
        this.view.getFrame().setVisible(true);
    }

    public ControllerProductPage(JFrame viewMainPage) {
        this.client = ControllerPharmacy.getClient();
        this.view = new ProductPage(ControllerPharmacy.getClient().getNume());
        this.view.getLblUser().setText(ControllerPharmacy.getLabel());
        this.productPageModel = new ProductPageModel(this.view.getTable());
        viewMainPage.setVisible(false);
        showView();
        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                viewMainPage.setVisible(true);

            }
        });
        this.view.getTable().addMouseListener(new TableProductClickedMouseListener(this.view.getTable()));
        this.view.getLogoutBtn().addActionListener(new LogInActionListener(this.client, this.view.getFrame(), this.view.getLblUser()));
        this.view.getComboBox().addActionListener(new ComboBoxActionListener(this.productPageModel, this.view));
        this.view.getSearchButton().addActionListener(new BtnCautaActionListener(this.view, this.productPageModel));
        this.view.getBtnFinalizeaza().addActionListener(new BtnFinalizeazaComandaActionListener(this.view,this.productPageModel));

    }

}