package ActionListeners.MainPage;

import Controller.ControllerInformativePharmacyPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnFarmacieActionListener implements ActionListener {
    private JFrame mainPageFrame;
    private ControllerInformativePharmacyPage controllerInformativePharmacyPage;
    public BtnFarmacieActionListener(JFrame mainPageFrame)
    {
        this.mainPageFrame = mainPageFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.controllerInformativePharmacyPage = new ControllerInformativePharmacyPage(mainPageFrame);
    }
}
