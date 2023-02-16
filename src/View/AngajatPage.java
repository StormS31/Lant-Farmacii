package View;

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
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AngajatPage {

    private JFrame AngajatPage;
    private JTable table;
    private JButton logOff;
    private JComboBox operatiune;
    private  JButton btnExecuta;

    public JButton getBtnExecuta() {
        return btnExecuta;
    }

    public AngajatPage() {
        initialize();
    }

    private void initialize() {
        AngajatPage = new JFrame();
        AngajatPage.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.print("MATA");
            }
        });
        AngajatPage.setResizable(false);
        AngajatPage.setIconImage(Toolkit.getDefaultToolkit().getImage(AngajatPage.class.getResource("/images/pharmacy_80x80.png")));
        AngajatPage.setTitle("Farmacia Ionas");
        AngajatPage.setBounds(100, 100, 1024, 720);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        AngajatPage.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 1008, 100);
        panel_1.setBackground(new Color(102, 204, 102));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel logo_farmacie = new JLabel("");
        logo_farmacie.setIcon(new ImageIcon(AngajatPage.class.getResource("/images/pharmacy_80x80.png")));
        logo_farmacie.setBounds(24, 11, 80, 80);
        panel_1.add(logo_farmacie);

        logOff = new JButton("");
        logOff.setFocusPainted(false);
        logOff.setFocusTraversalKeysEnabled(false);
        logOff.setFocusable(false);
        logOff.setIcon(new ImageIcon(AngajatPage.class.getResource("/images/log-in.png")));
        logOff.setActionCommand("");
        logOff.setBorder(null);
        logOff.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        logOff.setForeground(new Color(255, 255, 255));
        logOff.setBackground(new Color(255, 255, 255));
        logOff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        logOff.setBounds(945, 25, 51, 51);
        panel_1.add(logOff);

        JLabel whiteCircleBg = new JLabel("");
        whiteCircleBg.setIcon(new ImageIcon(AngajatPage.class.getResource("/images/white_circle_92.png")));
        whiteCircleBg.setBounds(924, 9, 82, 82);
        panel_1.add(whiteCircleBg);

        JLabel lblNewLabel = new JLabel("Meniu angajat");
        lblNewLabel.setForeground(new Color(248, 248, 255));
        lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel.setBounds(125, 42, 236, 34);
        panel_1.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(null);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(0, 99, 1008, 582);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
        scrollPane.setBounds(198, 11, 800, 560);
        panel_2.add(scrollPane);

        table = new JTable();
        table.setFocusTraversalKeysEnabled(false);
        table.setFocusable(false);
        table.setOpaque(false);
        table.setRequestFocusEnabled(false);
        table.setBackground(new Color(240, 255, 240));
        table.setRowHeight(60);
        table.setRowMargin(3);
        table.setSize(new Dimension(2, 2));
        table.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                }
        ));
        scrollPane.setViewportView(table);

        btnExecuta = new JButton("Exacuta operatiune!");
        btnExecuta.setFocusTraversalKeysEnabled(false);
        btnExecuta.setFocusable(false);
        btnExecuta.setForeground(Color.WHITE);
        btnExecuta.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
        btnExecuta.setBorder(null);
        btnExecuta.setBackground(new Color(102, 204, 102));
        btnExecuta.setBounds(10, 512, 178, 59);
        panel_2.add(btnExecuta);

        operatiune = new JComboBox();

        operatiune.setFocusTraversalKeysEnabled(false);
        operatiune.setFocusable(false);
        operatiune.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        operatiune.setBackground(new Color(240, 255, 240));
        operatiune.setModel(new DefaultComboBoxModel(new String[] {"Selecteaza operatiunea", "Adauga medicament", "Modifica medicament"}));
        operatiune.setBounds(10, 11, 178, 35);
        panel_2.add(operatiune);

        JTextArea txtrCautatiProdusul = new JTextArea();
        txtrCautatiProdusul.setText(" 1. Selectati operatiunea \r\n dorita.\r\n\r\n 2. Apasati \"executa\".\r\n\r\n 3. Introduceti datele cerute!\r\n\r\n 4. Finalizati!");
        txtrCautatiProdusul.setBorder(null);
        txtrCautatiProdusul.setBackground(new Color(240, 255, 240));
        txtrCautatiProdusul.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        txtrCautatiProdusul.setRequestFocusEnabled(false);
        txtrCautatiProdusul.setEditable(false);
        txtrCautatiProdusul.setBounds(10, 57, 178, 444);
        panel_2.add(txtrCautatiProdusul);
    }

    public JFrame getFrame() {
        return AngajatPage;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getLogOff() {
        return logOff;
    }

    public JComboBox getOperatiune() {
        return operatiune;
    }
}
