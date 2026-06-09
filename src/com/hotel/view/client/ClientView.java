/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.view.client;

import com.hotel.controller.ClientController;
import com.hotel.model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Interface principale de gestion des clients **/
public class ClientView extends JPanel {
    
    private ClientController controller;
    private JTable tableClients;
    private DefaultTableModel tableModel;
    private JTextField txtRecherche;
    private JButton btnAjouter, btnModifier, btnSupprimer, btnRechercher, btnActualiser, btnDetails;
    private JLabel lblTotal;
    
    public ClientView() {
        controller = new ClientController();
        initComponents();
        chargerClients();
    }
    
    private void initComponents() {
        setSize(1100, 700);
        setLayout(new BorderLayout(10, 10));
        
        // Panel du titre et recherche
        JPanel panelTop = new JPanel(new BorderLayout(10, 10));
        panelTop.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
        panelTop.setBackground(new Color(236, 240, 241));
        
        // Titre
        JLabel lblTitre = new JLabel("📋 Gestion des Clients", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitre.setForeground(new Color(44, 62, 80));
        panelTop.add(lblTitre, BorderLayout.NORTH);
        
        // Recherche
        JPanel panelRecherche = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        panelRecherche.setBackground(new Color(236, 240, 241));
        panelRecherche.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(52, 152, 219), 2),
            "Rechercher un client",
            0,
            0,
            new Font("Arial", Font.BOLD, 13),
            new Color(52, 152, 219)
        ));
        
        JLabel lblRecherche = new JLabel("Nom ou Prénom :");
        lblRecherche.setFont(new Font("Arial", Font.PLAIN, 13));
        
        txtRecherche = new JTextField(30);
        txtRecherche.setFont(new Font("Arial", Font.PLAIN, 14));
        txtRecherche.setPreferredSize(new Dimension(300, 32));
        
        btnRechercher = new JButton("🔍 Rechercher");
        btnRechercher.setFont(new Font("Arial", Font.BOLD, 13));
        btnRechercher.setBackground(new Color(52, 152, 219));
        btnRechercher.setForeground(Color.WHITE);
        btnRechercher.setFocusPainted(false);
        btnRechercher.setPreferredSize(new Dimension(140, 32));
        
        btnActualiser = new JButton("🔄 Actualiser");
        btnActualiser.setFont(new Font("Arial", Font.BOLD, 13));
        btnActualiser.setBackground(new Color(149, 165, 166));
        btnActualiser.setForeground(Color.WHITE);
        btnActualiser.setFocusPainted(false);
        btnActualiser.setPreferredSize(new Dimension(130, 32));
        
        panelRecherche.add(lblRecherche);
        panelRecherche.add(txtRecherche);
        panelRecherche.add(btnRechercher);
        panelRecherche.add(btnActualiser);
        
        panelTop.add(panelRecherche, BorderLayout.CENTER);
        add(panelTop, BorderLayout.NORTH);
        
        // Panel Tableau
        String[] colonnes = {"ID", "Nom", "Prénom", "Téléphone", "Email", "Adresse"};
        tableModel = new DefaultTableModel(colonnes, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tableClients = new JTable(tableModel);
        tableClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableClients.getTableHeader().setReorderingAllowed(false);
        tableClients.setRowHeight(28);
        tableClients.setFont(new Font("Arial", Font.PLAIN, 13));
        tableClients.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        tableClients.getTableHeader().setBackground(new Color(52, 73, 94));
        tableClients.getTableHeader().setForeground(Color.WHITE);
        tableClients.setSelectionBackground(new Color(52, 152, 219));
        tableClients.setSelectionForeground(Color.WHITE);
        tableClients.setGridColor(new Color(189, 195, 199));
        
        // Largeur des colonnes
        tableClients.getColumnModel().getColumn(0).setPreferredWidth(50);   // ID
        tableClients.getColumnModel().getColumn(1).setPreferredWidth(120);  // Nom
        tableClients.getColumnModel().getColumn(2).setPreferredWidth(120);  // Prénom
        tableClients.getColumnModel().getColumn(3).setPreferredWidth(130);  // Téléphone
        tableClients.getColumnModel().getColumn(4).setPreferredWidth(200);  // Email
        tableClients.getColumnModel().getColumn(5).setPreferredWidth(250);  // Adresse
        
        JScrollPane scrollPane = new JScrollPane(tableClients);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(149, 165, 166), 1),
            "Liste des Clients",
            0,
            0,
            new Font("Arial", Font.BOLD, 14)
        ));
        add(scrollPane, BorderLayout.CENTER);
        
        // Panel de la section Boutons et statistiques
        JPanel panelBottom = new JPanel(new BorderLayout(10, 10));
        panelBottom.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
        panelBottom.setBackground(new Color(236, 240, 241));
        
        // Statistiques
        JPanel panelStats = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelStats.setBackground(new Color(236, 240, 241));
        lblTotal = new JLabel("Total : 0 client(s)");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 15));
        lblTotal.setForeground(new Color(52, 73, 94));
        panelStats.add(lblTotal);
        panelBottom.add(panelStats, BorderLayout.WEST);
        
        // Boutons d'action
        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBoutons.setBackground(new Color(236, 240, 241));
        
        btnAjouter = new JButton("➕ Nouveau Client");
        btnModifier = new JButton("✏️ Modifier");
        btnSupprimer = new JButton("🗑️ Supprimer");
        btnDetails = new JButton("👁️ Détails");
        
        // Style des boutons
        Font btnFont = new Font("Arial", Font.BOLD, 14);
        
        btnAjouter.setFont(btnFont);
        btnAjouter.setBackground(new Color(46, 204, 113));
        btnAjouter.setForeground(Color.WHITE);
        btnAjouter.setFocusPainted(false);
        btnAjouter.setPreferredSize(new Dimension(180, 42));
        
        btnModifier.setFont(btnFont);
        btnModifier.setBackground(new Color(52, 152, 219));
        btnModifier.setForeground(Color.WHITE);
        btnModifier.setFocusPainted(false);
        btnModifier.setPreferredSize(new Dimension(140, 42));
        
        btnSupprimer.setFont(btnFont);
        btnSupprimer.setBackground(new Color(231, 76, 60));
        btnSupprimer.setForeground(Color.WHITE);
        btnSupprimer.setFocusPainted(false);
        btnSupprimer.setPreferredSize(new Dimension(140, 42));
        
        btnDetails.setFont(btnFont);
        btnDetails.setBackground(new Color(155, 89, 182));
        btnDetails.setForeground(Color.WHITE);
        btnDetails.setFocusPainted(false);
        btnDetails.setPreferredSize(new Dimension(130, 42));
        
        panelBoutons.add(btnAjouter);
        panelBoutons.add(btnModifier);
        panelBoutons.add(btnSupprimer);
        panelBoutons.add(btnDetails);
        
        panelBottom.add(panelBoutons, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);
        
        // Listeners
        btnAjouter.addActionListener(e -> ajouterClient());
        btnModifier.addActionListener(e -> modifierClient());
        btnSupprimer.addActionListener(e -> supprimerClient());
        btnDetails.addActionListener(e -> afficherDetails());
        btnRechercher.addActionListener(e -> rechercherClients());
        btnActualiser.addActionListener(e -> chargerClients());
        
        // Recherche avec Enter
        txtRecherche.addActionListener(e -> rechercherClients());
        
        // Double-clic pour modifier
        tableClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    modifierClient();
                }
            }
        });
    }
    
    private void chargerClients() {
        tableModel.setRowCount(0);
        List<Client> clients = controller.getTousLesClients();
        
        for (Client client : clients) {
            tableModel.addRow(new Object[]{
                client.getIdClient(),
                client.getNom(),
                client.getPrenom(),
                client.getTelephone(),
                client.getEmail(),
                client.getAdresse()
            });
        }
        
        lblTotal.setText("Total : " + clients.size() + " client(s)");
        txtRecherche.setText("");
    }
    
    private void rechercherClients() {
        tableModel.setRowCount(0);
        String recherche = txtRecherche.getText();
        List<Client> clients = controller.rechercherClients(recherche);
        
        for (Client client : clients) {
            tableModel.addRow(new Object[]{
                client.getIdClient(),
                client.getNom(),
                client.getPrenom(),
                client.getTelephone(),
                client.getEmail(),
                client.getAdresse()
            });
        }
        
        lblTotal.setText("Résultats : " + clients.size() + " client(s)");
    }
    
    private void ajouterClient() {
JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
ClientFormDialog dialog = new ClientFormDialog(parentFrame, "Nouveau Client", true, null);
        dialog.setVisible(true);
        
        if (dialog.isConfirmed()) {
            controller.ajouterClient(
                dialog.getNom(),
                dialog.getPrenom(),
                dialog.getTelephone(),
                dialog.getEmail(),
                dialog.getAdresse(),
                this
            );
            chargerClients();
        }
    }
    
    private void modifierClient() {
        int selectedRow = tableClients.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                "Veuillez sélectionner un client à modifier !",
                "Aucune sélection",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int id = (int) tableModel.getValueAt(selectedRow, 0);
        Client client = controller.getClientParId(id);
        
        if (client != null) {
JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
ClientFormDialog dialog = new ClientFormDialog(parentFrame, "Modifier le Client", true, null);
            dialog.setVisible(true);
            
            if (dialog.isConfirmed()) {
                controller.modifierClient(
                    id,
                    dialog.getNom(),
                    dialog.getPrenom(),
                    dialog.getTelephone(),
                    dialog.getEmail(),
                    dialog.getAdresse(),
                    this
                );
                chargerClients();
            }
        }
    }
    
    private void supprimerClient() {
        int selectedRow = tableClients.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                "Veuillez sélectionner un client à supprimer !",
                "Aucune sélection",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int id = (int) tableModel.getValueAt(selectedRow, 0);
        
        if (controller.supprimerClient(id, this)) {
            chargerClients();
        }
    }
    
    private void afficherDetails() {
        int selectedRow = tableClients.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                "Veuillez sélectionner un client pour voir ses détails !",
                "Aucune sélection",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int id = (int) tableModel.getValueAt(selectedRow, 0);
        Client client = controller.getClientParId(id);
        
        if (client != null) {
            String details = String.format(
                "═══════════════════════════════════\n" +
                "         DÉTAILS DU CLIENT\n" +
                "═══════════════════════════════════\n\n" +
                "ID:           %d\n" +
                "Nom:          %s\n" +
                "Prénom:       %s\n" +
                "Téléphone:    %s\n" +
                "Email:        %s\n" +
                "Adresse:      %s\n" +
                "\n═══════════════════════════════════",
                client.getIdClient(),
                client.getNom(),
                client.getPrenom(),
                client.getTelephone(),
                client.getEmail(),
                client.getAdresse()
            );
            
            JOptionPane.showMessageDialog(this,
                details,
                "Informations du Client",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Méthode main pour tester l'interface
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new ClientView().setVisible(true);
        });
    }
}
