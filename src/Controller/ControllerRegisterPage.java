package Controller;

import ActionListeners.RegisterPage.BtnRegisterPageActionListener;
import View.RegisterPage;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControllerRegisterPage {
    private RegisterPage view;

    public void showView() {
        this.view.getFrame().setVisible(true);
    }
    public ControllerRegisterPage(JFrame callerFrame)
    {
        callerFrame.setVisible(false);
        this.view = new RegisterPage();
        showView();
        this.view.getBtnRegister().addActionListener(new BtnRegisterPageActionListener(this.view, callerFrame));
        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                callerFrame.setVisible(true);
            }
        });
    }

}
