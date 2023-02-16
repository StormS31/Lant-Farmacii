package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;


public class FormAngajat {

    private JFrame frmFormAngajatPage;
    private JPasswordField txtParolaSauIdAngajat;
    private JTextField txtIdFarmacie;
    private JTextField txtCnp;
    private JTextField txtEmail;
    private  JTextField txtUsername;

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    private JButton btnExecuta;

    public FormAngajat(int mode) {
        initialize(mode);
    }

    public JFrame getFrame() {
        return frmFormAngajatPage;
    }

    public JPasswordField getTxtParolaSauIdAngajat() {
        return txtParolaSauIdAngajat;
    }

    public JTextField getTxtIdFarmacie() {
        return txtIdFarmacie;
    }

    public JTextField getTxtCnp() {
        return txtCnp;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JButton getBtnExecuta() {
        return btnExecuta;
    }

    private void initialize(int mode) {
        frmFormAngajatPage = new JFrame();
        frmFormAngajatPage.setBackground(new Color(255, 255, 255));
        frmFormAngajatPage.setTitle("Farmacia Jasmine");
        frmFormAngajatPage.setIconImage(Toolkit.getDefaultToolkit().getImage(FormAngajat.class.getResource("/images/pharmacy_80x80.png")));
        frmFormAngajatPage.setBounds(100, 100, 611, 428);
        frmFormAngajatPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frmFormAngajatPage.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        txtParolaSauIdAngajat = new JPasswordField();
        txtParolaSauIdAngajat.setBorder(null);
        txtParolaSauIdAngajat.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                    if(txtParolaSauIdAngajat.getText().equals("Parola") || txtParolaSauIdAngajat.getText().equals("ID Angajat"))
                    {
                        txtParolaSauIdAngajat.setText("");
                        if(mode == 0)
                            txtParolaSauIdAngajat.setEchoChar((char)('*'));
                    }
            }
        });


        txtCnp = new JTextField("CNP");
        txtCnp.setHorizontalAlignment(SwingConstants.CENTER);
        txtCnp.setForeground(Color.BLACK);
        txtCnp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(txtCnp.getText().equals("CNP"))
                {
                    txtCnp.setText("");
                }
            }
        });
        txtCnp.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        txtCnp.setColumns(10);
        txtCnp.setBorder(null);
        txtCnp.setBackground(new Color(240, 255, 240));
        txtCnp.setBounds(177, 182, 236, 46);
        panel.add(txtCnp);

        txtIdFarmacie = new JTextField("ID Farmacie");
        txtIdFarmacie.setHorizontalAlignment(SwingConstants.CENTER);
        txtIdFarmacie.setForeground(Color.BLACK);
        txtIdFarmacie.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        txtIdFarmacie.setColumns(10);
        txtIdFarmacie.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(txtIdFarmacie.getText().equals("ID Farmacie"))
                {
                    txtIdFarmacie.setText("");
                }
            }
        });
        txtIdFarmacie.setBorder(null);
        txtIdFarmacie.setBackground(new Color(240, 255, 240));
        txtIdFarmacie.setBounds(177, 125, 236, 46);
        panel.add(txtIdFarmacie);

        btnExecuta = new JButton("Executa");
        btnExecuta.setFocusable(false);
        btnExecuta.setFocusPainted(false);
        btnExecuta.setFocusTraversalKeysEnabled(false);
        btnExecuta.setRequestFocusEnabled(false);
        btnExecuta.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        btnExecuta.setBackground(new Color(240, 255, 240));
        btnExecuta.setBorder(null);
        btnExecuta.setBounds(177, 316, 236, 62);
        panel.add(btnExecuta);
        txtParolaSauIdAngajat.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        txtParolaSauIdAngajat.setBackground(new Color(240, 255, 240));
        txtParolaSauIdAngajat.setHorizontalAlignment(SwingConstants.CENTER);
        txtParolaSauIdAngajat.setBounds(177, 68, 236, 46);
        if(mode == 0)
            txtParolaSauIdAngajat.setText("Parola");
        else txtParolaSauIdAngajat.setText("ID Angajat");
        txtParolaSauIdAngajat.setEchoChar((char)(0));
        panel.add(txtParolaSauIdAngajat);


        txtUsername = new JTextField("Nume angajat");
        txtUsername.setBackground(new Color(240, 255, 240));
        txtUsername.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(txtUsername.getText().equals("Nume angajat"))
                    txtUsername.setText("");
            }
        });
        txtUsername.setForeground(new Color(0, 0, 0));
        txtUsername.setBorder(null);
        txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
        txtUsername.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        //textField.setOpaque(false);
        txtUsername.setBounds(177, 11, 236, 46);
        panel.add(txtUsername);
        txtUsername.setColumns(10);

        txtEmail = new JTextField("Email");
        txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        txtEmail.setColumns(10);
        txtEmail.setBorder(null);
        txtEmail.setBackground(new Color(240, 255, 240));
        txtEmail.setBounds(177, 239, 236, 46);
        txtEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(txtEmail.getText().equals("Email"))
                    txtEmail.setText("");
            }
        });
        panel.add(txtEmail);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(FormAngajat.class.getResource("/images/farmacieBGLogIn_resized.png")));
        lblNewLabel.setBounds(0, 0, 595, 389);
        panel.add(lblNewLabel);
    }
}
