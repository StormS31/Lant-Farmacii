package View;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;


public class RegisterPage {

    private JFrame RegisterPageFrame;

    private JPasswordField pwdParola;

    private JTextField txtNume;
    private JTextField txtAdresa;
    private JTextField txtEmail;

    private JPanel panel;

    private JButton btnRegister;

    public RegisterPage() {
        initializeFrame();
        initializePanels();
        initializeBtnRegister();
        initializeLabelsAndTextFields();
    }
    private void initializePanels()
    {
        panel = new JPanel();
        RegisterPageFrame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
    }
    private void initializeFrame()
    {
        RegisterPageFrame = new JFrame();
        RegisterPageFrame.setBackground(new Color(255, 255, 255));
        RegisterPageFrame.setTitle("Log In Page");
        RegisterPageFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterPage.class.getResource("/images/pharmacy_80x80.png")));
        RegisterPageFrame.setBounds(100, 100, 600, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        RegisterPageFrame.setLocation(dim.width/2-RegisterPageFrame.getSize().width/2, dim.height/2-RegisterPageFrame.getSize().height/2);
        RegisterPageFrame.setResizable(false);
    }
    private void initializeBtnRegister()
    {
        btnRegister = new JButton("Inregistreaza-te");
        btnRegister.setFocusable(false);
        btnRegister.setFocusPainted(false);
        btnRegister.setFocusTraversalKeysEnabled(false);
        btnRegister.setRequestFocusEnabled(false);
        btnRegister.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        btnRegister.setBackground(new Color(240, 255, 240));
        btnRegister.setBorder(null);
        btnRegister.setBounds(177, 465, 236, 36);
        panel.add(btnRegister);
    }
    private void initializeLabelsAndTextFields() {
        pwdParola = new JPasswordField();
        pwdParola.setBorder(null);
        pwdParola.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(pwdParola.getText().equals("Parola"))
                {
                    pwdParola.setText("");
                    pwdParola.setEchoChar((char)('*'));
                }
            }
        });
        pwdParola.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        pwdParola.setBackground(new Color(240, 255, 240));
        pwdParola.setHorizontalAlignment(SwingConstants.CENTER);
        pwdParola.setBounds(177, 262, 236, 62);
        pwdParola.setText("Parola");
        pwdParola.setEchoChar((char)(0));
        panel.add(pwdParola);


        txtEmail = new JTextField("Email");
        txtEmail.setBackground(new Color(240, 255, 240));
        txtEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                txtEmail.setText("");
            }
        });
        txtEmail.setForeground(new Color(0, 0, 0));
        txtEmail.setBorder(null);
        txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        //textField.setOpaque(false);
        txtEmail.setBounds(177, 189, 236, 62);
        panel.add(txtEmail);
        txtEmail.setColumns(10);


        txtNume = new JTextField("Nume");
        txtNume.setHorizontalAlignment(SwingConstants.CENTER);
        txtNume.setForeground(Color.BLACK);
        txtNume.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        txtNume.setColumns(10);
        txtNume.setBorder(null);
        txtNume.setBackground(new Color(240, 255, 240));
        txtNume.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtNume.setText("");
            }
        });
        txtNume.setBounds(177, 116, 236, 62);
        panel.add(txtNume);


        txtAdresa = new JTextField("Adresa");
        txtAdresa.setHorizontalAlignment(SwingConstants.CENTER);
        txtAdresa.setForeground(Color.BLACK);
        txtAdresa.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        txtAdresa.setColumns(10);
        txtAdresa.setBorder(null);
        txtAdresa.setBackground(new Color(240, 255, 240));
        txtAdresa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtAdresa.setText("");
            }
        });
        txtAdresa.setBounds(177, 335, 236, 62);
        panel.add(txtAdresa);


        JLabel lblBg = new JLabel("");
        lblBg.setIcon(new ImageIcon(RegisterPage.class.getResource("/images/registerPage_600x600.png")));
        lblBg.setBounds(0, 0, 584, 561);
        panel.add(lblBg);
    }

    public JFrame getFrame() {
        return RegisterPageFrame;
    }

    public JPasswordField getPwdParola() {
        return pwdParola;
    }

    public JTextField getTxtNume() {
        return txtNume;
    }

    public JTextField getTxtAdresa() {
        return txtAdresa;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }
}
