package View;

import java.awt.EventQueue;
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
import java.awt.event.MouseMotionAdapter;


public class FormFarmacie {

    private JFrame frmFormFarmaciePage;
    private JTextField txtStrada;
    private JTextField txtNumar;
    private JTextField txtProgram;
    private JButton btnInsereaza;
    private JTextField txtOras;

    public JFrame getFrame() {
        return frmFormFarmaciePage;
    }

    public JTextField getTxtStrada() {
        return txtStrada;
    }

    public JTextField getTxtNumar() {
        return txtNumar;
    }

    public JTextField getTxtProgram() {
        return txtProgram;
    }

    public JButton getBtnInsereaza() {
        return btnInsereaza;
    }

    public JTextField getTxtOras() {
        return txtOras;
    }

    public FormFarmacie() {
        initialize();
    }

    private void initialize() {
        frmFormFarmaciePage = new JFrame();
        frmFormFarmaciePage.setBackground(new Color(255, 255, 255));
        frmFormFarmaciePage.setTitle("Farmacia Jasmine");
        frmFormFarmaciePage.setIconImage(Toolkit.getDefaultToolkit().getImage(FormFarmacie.class.getResource("/images/pharmacy_80x80.png")));
        frmFormFarmaciePage.setBounds(100, 100, 611, 428);
        frmFormFarmaciePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frmFormFarmaciePage.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        txtNumar = new JTextField("Numar");
        txtNumar.setHorizontalAlignment(SwingConstants.CENTER);
        txtNumar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(txtNumar.getText().equals("Numar"))
                    txtNumar.setText("");
            }
        });
        txtNumar.setForeground(Color.BLACK);
        txtNumar.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        txtNumar.setColumns(10);
        txtNumar.setCaretColor(Color.WHITE);
        txtNumar.setBorder(null);
        txtNumar.setBackground(new Color(240, 255, 240));
        txtNumar.setBounds(177, 182, 236, 46);
        panel.add(txtNumar);

        txtStrada = new JTextField("Strada");
        txtStrada.setHorizontalAlignment(SwingConstants.CENTER);
        txtStrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(txtStrada.getText().equals("Strada"))
                    txtStrada.setText("");
            }
        });
        txtStrada.setForeground(Color.BLACK);
        txtStrada.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        txtStrada.setColumns(10);
        txtStrada.setBorder(null);
        txtStrada.setBackground(new Color(240, 255, 240));
        txtStrada.setBounds(177, 125, 236, 46);
        panel.add(txtStrada);

        btnInsereaza = new JButton("Insereaza farmacia");
        btnInsereaza.setFocusable(false);
        btnInsereaza.setFocusPainted(false);
        btnInsereaza.setFocusTraversalKeysEnabled(false);
        btnInsereaza.setRequestFocusEnabled(false);
        btnInsereaza.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        btnInsereaza.setBackground(new Color(240, 255, 240));
        btnInsereaza.setBorder(null);
        btnInsereaza.setBounds(177, 316, 236, 62);
        panel.add(btnInsereaza);


        txtOras = new JTextField("Oras farmacie");
        txtOras.setBackground(new Color(240, 255, 240));
        txtOras.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(txtOras.getText().equals("Oras farmacie"))
                    txtOras.setText("");
            }
        });
        txtOras.setForeground(new Color(0, 0, 0));
        txtOras.setBorder(null);
        txtOras.setHorizontalAlignment(SwingConstants.CENTER);
        txtOras.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        //textField.setOpaque(false);
        txtOras.setBounds(177, 68, 236, 46);
        panel.add(txtOras);
        txtOras.setColumns(10);

        txtProgram = new JTextField("Program");
        txtProgram.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(txtProgram.getText().equals("Program"))
                    txtProgram.setText("");
            }
        });

        txtProgram.setHorizontalAlignment(SwingConstants.CENTER);
        txtProgram.setForeground(Color.BLACK);
        txtProgram.setFont(new Font("Mongolian Baiti", Font.PLAIN, 19));
        txtProgram.setColumns(10);
        txtProgram.setBorder(null);
        txtProgram.setBackground(new Color(240, 255, 240));
        txtProgram.setBounds(177, 239, 236, 46);
        panel.add(txtProgram);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(FormFarmacie.class.getResource("/images/farmacieBGLogIn_resized.png")));
        lblNewLabel.setBounds(0, 0, 595, 389);
        panel.add(lblNewLabel);
    }
}
