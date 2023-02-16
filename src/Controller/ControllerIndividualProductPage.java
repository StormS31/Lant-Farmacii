package Controller;

import ActionListeners.IndividualProductPage.BtnAdaugaLaComandaActionListener;
import Model.Medicament;
import View.IndividualProductPage;

public class ControllerIndividualProductPage {
    private IndividualProductPage view;
    public void showView() {
        this.view.getFrame().setVisible(true);
    }
    public ControllerIndividualProductPage(Medicament medicament)
    {
        this.view = new IndividualProductPage(medicament);
        showView();
        this.view.getBtnAdaugaInCos().addActionListener(new BtnAdaugaLaComandaActionListener(medicament, view));
    }
}
