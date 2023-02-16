package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class ComenziPage {

    private JFrame ComenziPage;
    private JComboBox comboBox;
    private JTextArea detaliiComanda;

    public JTextArea getDetaliiComanda() {
        return detaliiComanda;
    }

    public void setDetaliiComanda(JTextArea detaliiComanda) {
        this.detaliiComanda = detaliiComanda;
    }

    public ComenziPage() {
        initialize();
    }

    public JFrame getComenziPage() {
        return ComenziPage;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    private void initialize() {
        ComenziPage = new JFrame();
        ComenziPage.setResizable(false);
        ComenziPage.setIconImage(Toolkit.getDefaultToolkit().getImage(ComenziPage.class.getResource("/images/pharmacy_80x80.png")));
        ComenziPage.setTitle("Farmacia Jasmine");
        ComenziPage.setBounds(100, 100, 1024, 720);
        ComenziPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        ComenziPage.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 1008, 100);
        panel_1.setBackground(new Color(102, 204, 102));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel logo_farmacie = new JLabel("");
        logo_farmacie.setIcon(new ImageIcon(ComenziPage.class.getResource("/images/pharmacy_80x80.png")));
        logo_farmacie.setBounds(24, 11, 80, 80);
        panel_1.add(logo_farmacie);

        JLabel lblPaginaProdus = new JLabel("Comenzile mele");
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

        JLabel lblDescriere = new JLabel("Detalii comanda:");
        lblDescriere.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDescriere.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        lblDescriere.setBackground(new Color(240, 255, 255));
        lblDescriere.setBounds(10, 125, 149, 25);
        panel_2.add(lblDescriere);

        JLabel lblComanda = new JLabel("Comanda:");
        lblComanda.setHorizontalAlignment(SwingConstants.RIGHT);
        lblComanda.setFont(new Font("Mongolian Baiti", Font.PLAIN, 22));
        lblComanda.setBackground(new Color(240, 255, 255));
        lblComanda.setBounds(10, 40, 149, 25);
        panel_2.add(lblComanda);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecteaza comanda"}));
        comboBox.setRequestFocusEnabled(false);
        comboBox.setBorder(null);
        comboBox.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
        comboBox.setFocusTraversalKeysEnabled(false);
        comboBox.setFocusable(false);
        comboBox.setBackground(new Color(240, 255, 240));
        comboBox.setBounds(169, 36, 477, 36);
        panel_2.add(comboBox);

        detaliiComanda = new JTextArea();
        detaliiComanda.setEditable(false);
        detaliiComanda.setBorder(new LineBorder(new Color(0, 0, 0)));
        detaliiComanda.setBackground(new Color(245, 255, 250));
        detaliiComanda.setBounds(169, 126, 829, 445);
        detaliiComanda.setFont(new Font("Mongolian Baiti", Font.PLAIN, 18));
        panel_2.add(detaliiComanda);
    }
}
