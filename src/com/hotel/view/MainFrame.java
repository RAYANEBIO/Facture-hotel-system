package com.hotel.view;

import com.hotel.model.Personnel;
import com.hotel.view.chambre.gestion_Personnel;
import com.hotel.view.client.ClientView;
import com.hotel.view.paiement.Paiement_Form;
import com.hotel.view.paiement.Paiement_Visualizer;
import com.hotel.view.reservation.Reservation_Formulaire;
import javax.swing.*;
import java.awt.*;

/**
 * Fenêtre principale unifiée utilisant un JTabbedPane
 */
public class MainFrame extends JFrame {
    private Personnel user;
    private JTabbedPane tabbedPane;

    public MainFrame(Personnel user) {
        this.user = user;
        initComponents();
        this.setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {
        setTitle("Hôtel Gestion Pro - " + user.getPrenom() + " " + user.getNom() + " [" + user.getRole() + "]");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Header ---
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(44, 62, 80));
        header.setPreferredSize(new Dimension(1200, 70));
        header.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JLabel title = new JLabel("HÔTEL GESTION PRO");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        header.add(title, BorderLayout.WEST);

        JPanel info = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 18));
        info.setOpaque(false);
        JLabel name = new JLabel(user.getPrenom() + " " + user.getNom() + " (" + user.getRole() + ")");
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JButton logout = new JButton("Déconnexion");
        logout.setBackground(new Color(231, 76, 60));
        logout.setForeground(Color.WHITE);
        logout.setFocusPainted(false);
        logout.addActionListener(e -> {
            new ConnexionFrame().setVisible(true);
            dispose();
        });

        info.add(name);
        info.add(logout);
        header.add(info, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // --- Tabs ---
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        // Modules intégrés
        tabbedPane.addTab("Clients", new ClientView());
        tabbedPane.addTab("Reservations", new Reservation_Formulaire());
        /*tabbedPane.addTab("Personnel", new gestionPersonnel());*/
        tabbedPane.addTab("Paiements", new Paiement_Visualizer());
        tabbedPane.addTab("Factures", new Paiement_Form());

        if ("Admin".equalsIgnoreCase(user.getRole())) {
            tabbedPane.addTab("Administration Personnel", new gestion_Personnel());
        }

        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(() -> {
            Personnel d = new Personnel("Admin", "Super", "Siège", 0, "admin", "admin123", "Admin");
            new MainFrame(d).setVisible(true);
        });
    }
}
