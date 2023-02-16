package ActionListeners.MainPage;

import Controller.ControllerProductPage;
import Model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnProduseActionListener implements ActionListener {
    private Client client;
    private ControllerProductPage controllerProductPage;
    private JFrame mainPageFrame;
    public BtnProduseActionListener(Client client, JFrame frame)
    {
        this.client = client;
        this.mainPageFrame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         this.controllerProductPage = new ControllerProductPage(mainPageFrame);
    }
}
