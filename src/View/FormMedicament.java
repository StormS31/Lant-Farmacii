package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class FormMedicament {

    private JFrame FormMedicament;
    private JTextField txtDenumire;
    private JTextField txtStoc;
    private JTextField txtFurnizor;
    private JTextField txtPret;
    private JTextField txtCategorie;
    private JButton btnAdauga;
    private JTextArea txtDescriere;

    public JTextArea getTxtDescriere() {
        return txtDescriere;
    }

    public FormMedicament() {
        initialize();
    }

    public JFrame getFrame() {
        return FormMedicament;
    }

    public JTextField getTxtDenumire() {
        return txtDenumire;
    }

    public JTextField getTxtStoc() {
        return txtStoc;
    }

    public JTextField getTxtFurnizor() {
        return txtFurnizor;
    }

    public JTextField getTxtPret() {
        return txtPret;
    }

    public JTextField getTxtCategorie() {
        return txtCategorie;
    }

    public JButton getBtnAdauga() {
        return btnAdauga;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        FormMedicament = new JFrame();
        FormMedicament.setResizable(false);
        FormMedicament.setIconImage(Toolkit.getDefaultToolkit().getImage(FormMedicament.class.getResource("/images/pharmacy_80x80.png")));
        FormMedicament.setTitle("Farmacia Jasmine");
        FormMedicament.setBounds(100, 100, 1024, 720);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        FormMedicament.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 1008, 100);
        panel_1.setBackground(new Color(102, 204, 102));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel logo_farmacie = new JLabel("");
        logo_farmacie.setIcon(new ImageIcon(FormMedicament.class.getResource("/images/pharmacy_80x80.png")));
        logo_farmacie.setBounds(24, 11, 80, 80);
        panel_1.add(logo_farmacie);

        JButton loginBtn = new JButton("");
        loginBtn.setFocusPainted(false);
        loginBtn.setFocusTraversalKeysEnabled(false);
        loginBtn.setFocusable(false);
        loginBtn.setIcon(new ImageIcon(FormMedicament.class.getResource("/images/log-in.png")));
        loginBtn.setActionCommand("");
        loginBtn.setBorder(null);
        loginBtn.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setBackground(new Color(255, 255, 255));
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        loginBtn.setBounds(945, 25, 51, 51);
        panel_1.add(loginBtn);

        JLabel whiteCircleBg = new JLabel("");
        whiteCircleBg.setIcon(new ImageIcon(FormMedicament.class.getResource("/images/white_circle_92.png")));
        whiteCircleBg.setBounds(924, 9, 82, 82);
        panel_1.add(whiteCircleBg);

        JLabel lblPaginaProdus = new JLabel("Pagina produs");
        lblPaginaProdus.setForeground(new Color(255, 255, 255));
        lblPaginaProdus.setFont(new Font("Mongolian Baiti", Font.ITALIC, 23));
        lblPaginaProdus.setBounds(180, 25, 326, 48);
        panel_1.add(lblPaginaProdus);

        JPanel panel_2 = new JPanel();
        panel_2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 11));
        panel_2.setBorder(null);
        panel_2.setBackground(new Color(240, 255, 240));
        panel_2.setBounds(0, 99, 1008, 582);
        panel.add(panel_2);
        panel_2.setLayout(null);

        btnAdauga = new JButton("Adauga");
        btnAdauga.setFocusTraversalKeysEnabled(false);
        btnAdauga.setFocusable(false);
        btnAdauga.setForeground(Color.WHITE);
        btnAdauga.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
        btnAdauga.setBorder(null);
        btnAdauga.setBackground(new Color(102, 204, 102));
        btnAdauga.setBounds(10, 512, 988, 59);
        panel_2.add(btnAdauga);

        JLabel lblDenumireProdus = new JLabel("Denumire produs: ");
        lblDenumireProdus.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDenumireProdus.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblDenumireProdus.setBackground(new Color(240, 255, 255));
        lblDenumireProdus.setBounds(10, 11, 149, 25);
        panel_2.add(lblDenumireProdus);

        JLabel lblStoc = new JLabel("Stoc online:");
        lblStoc.setHorizontalAlignment(SwingConstants.RIGHT);
        lblStoc.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblStoc.setBackground(new Color(240, 255, 255));
        lblStoc.setBounds(10, 47, 149, 25);
        panel_2.add(lblStoc);

        JLabel lblDescriere = new JLabel("Descriere:");
        lblDescriere.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDescriere.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblDescriere.setBackground(new Color(240, 255, 255));
        lblDescriere.setBounds(10, 83, 149, 25);
        panel_2.add(lblDescriere);

        txtDescriere = new JTextArea("");
        txtDescriere.setBackground(new Color(255, 255, 255));
        txtDescriere.setFont(new Font("Times New Roman", Font.BOLD, 23));
        txtDescriere.setBounds(169, 83, 480, 250);
        panel_2.add(txtDescriere);

        JLabel lblPret = new JLabel("Pret:");
        lblPret.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPret.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblPret.setBackground(new Color(240, 255, 255));
        lblPret.setBounds(10, 365, 149, 25);
        panel_2.add(lblPret);

        JLabel lblCategorie = new JLabel("Categorie");
        lblCategorie.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCategorie.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblCategorie.setBackground(new Color(240, 255, 255));
        lblCategorie.setBounds(10, 401, 149, 25);
        panel_2.add(lblCategorie);

        JLabel lblFurnizor = new JLabel("Furnizor");
        lblFurnizor.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFurnizor.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblFurnizor.setBackground(new Color(240, 255, 255));
        lblFurnizor.setBounds(10, 437, 149, 25);
        panel_2.add(lblFurnizor);

        txtDenumire = new JTextField();
        txtDenumire.setBounds(169, 14, 480, 20);
        panel_2.add(txtDenumire);
        txtDenumire.setColumns(10);

        txtStoc = new JTextField();
        txtStoc.setColumns(10);
        txtStoc.setBounds(169, 50, 62, 20);
        panel_2.add(txtStoc);

        txtFurnizor = new JTextField();
        txtFurnizor.setColumns(10);
        txtFurnizor.setBounds(169, 440, 480, 20);
        panel_2.add(txtFurnizor);

        txtPret = new JTextField();
        txtPret.setColumns(10);
        txtPret.setBounds(169, 368, 62, 20);
        panel_2.add(txtPret);

        txtCategorie = new JTextField();
        txtCategorie.setColumns(10);
        txtCategorie.setBounds(169, 404, 187, 20);
        panel_2.add(txtCategorie);

    }
}
