package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;


public class LogInPage{

    private JFrame frmLogInPage;
    private JPasswordField passwordField;
    private JPanel panel;
    private JButton btnLogIn;
    private JTextField txtUsername;
    private JLabel backgroundImg;
    private JButton btnRegister;

    public LogInPage() {
        initializeFrame();
        initialisePanel();
        initialiseBtnLogIn();
        initialiseBtnRegister();
        initialisePassField();
        initialiseUsernameField();
        initialiseBackground();
    }

    private void initializeFrame() {
        frmLogInPage = new JFrame();
        frmLogInPage.setResizable(false);
        frmLogInPage.setBackground(new Color(255, 255, 255));
        frmLogInPage.setTitle("Log In Page");
        frmLogInPage.setIconImage(Toolkit.getDefaultToolkit().getImage(LogInPage.class.getResource("/images/pharmacy_80x80.png")));
        frmLogInPage.setBounds(100, 100, 611, 428);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmLogInPage.setLocation(dim.width/2-frmLogInPage.getSize().width/2, dim.height/2-frmLogInPage.getSize().height/2);
    }
    private void initialisePanel(){
        panel = new JPanel();
        frmLogInPage.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
    }
    private void initialiseBtnLogIn(){
        btnLogIn = new JButton("Intra in cont");
        btnLogIn.setFocusable(false);
        btnLogIn.setFocusPainted(false);
        btnLogIn.setFocusTraversalKeysEnabled(false);
        btnLogIn.setRequestFocusEnabled(false);
        btnLogIn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        btnLogIn.setBackground(new Color(240, 255, 240));
        btnLogIn.setBorder(null);
        btnLogIn.setBounds(302, 259, 111, 62);
        panel.add(btnLogIn);
    }
    private void initialiseBtnRegister(){
        btnRegister = new JButton("Inregistreaza-te");
        btnRegister.setFocusable(false);
        btnRegister.setFocusPainted(false);
        btnRegister.setFocusTraversalKeysEnabled(false);
        btnRegister.setRequestFocusEnabled(false);
        btnRegister.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        btnRegister.setBackground(new Color(240, 255, 240));
        btnRegister.setBorder(null);
        btnRegister.setBounds(177, 259, 115, 62);
        panel.add(btnRegister);
    }
    private void initialisePassField(){
        passwordField = new JPasswordField();
        passwordField.setBorder(null);
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(passwordField.getText().equals("parola"))
                {
                    passwordField.setText("");
                    passwordField.setEchoChar((char)('*'));
                }
            }
        });
        passwordField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        passwordField.setBackground(new Color(240, 255, 240));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBounds(177, 186, 236, 62);
        passwordField.setText("parola");
        passwordField.setEchoChar((char)(0));
        panel.add(passwordField);
    }
    private void initialiseUsernameField(){
        txtUsername = new JTextField("email");
        txtUsername.setBackground(new Color(240, 255, 240));
        txtUsername.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(txtUsername.getText().equals("email"))
                    txtUsername.setText("");
            }
        });
        txtUsername.setForeground(new Color(0, 0, 0));
        txtUsername.setBorder(null);
        txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
        txtUsername.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));

        txtUsername.setBounds(177, 108, 236, 62);
        panel.add(txtUsername);
        txtUsername.setColumns(10);
    }
    private void initialiseBackground(){
            backgroundImg = new JLabel("");
            backgroundImg.setIcon(new ImageIcon(LogInPage.class.getResource("/images/farmacieBGLogIn_resized.png")));
            backgroundImg.setBounds(0, 0, 595, 389);
            panel.add(backgroundImg);
        }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getBtnLogIn() {
        return btnLogIn;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public JFrame getFrame() {
        return frmLogInPage;
    }
}
