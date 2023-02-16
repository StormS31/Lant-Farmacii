package Controller;

import ActionListeners.LogInPage.BtnCredentialeActionListener;
import ActionListeners.LogInPage.BtnRegisterActionListener;
import Model.Client;
import View.LogInPage;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControllerLogInPage {
    private LogInPage view;
    private Client client;
    public void showView() {
        this.view.getFrame().setVisible(true);
    }
    public ControllerLogInPage(Client client, JFrame viewMainPage, JLabel lblUser)
    {
        this.client = client;
        this.view = new LogInPage();
        this.view.getBtnLogIn().addActionListener(new BtnCredentialeActionListener(this.view, viewMainPage, lblUser));
        this.view.getBtnRegister().addActionListener(new BtnRegisterActionListener(this.view.getFrame()));
        viewMainPage.setVisible(false);
        showView();
        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                viewMainPage.setVisible(true);

            }
        });
    }
}
