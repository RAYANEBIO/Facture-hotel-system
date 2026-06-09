/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.view.client;

import com.hotel.model.Client;

import javax.swing.*;
import java.awt.*;

/**
 * Formulaire modal pour ajouter ou modifier un client
 * Adapté à la structure réelle de la base de données
 * @author Noufous
 */
public class ClientFormDialog extends JDialog {
    
    private JTextField txtNom;
    private JTextField txtPrenom;
    private JTextField txtTelephone;
    private JTextField txtEmail;
    private JTextArea txtAdresse;
    private JButton btnValider, btnAnnuler;
    private boolean confirmed = false;
    private Client client;
    
    public ClientFormDialog( JFrame parent, String title, boolean modal, Client client) {
        super(parent, title, modal);
        this.client = client;
        initComponents();
        
        if (client != null) {
            // Mode modification - pré-remplir les champs
            txtNom.setText(client.getNom());
            txtPrenom.setText(client.getPrenom());
            txtTelephone.setText(client.getTelephone());
            txtEmail.setText(client.getEmail());
            txtAdresse.setText(client.getAdresse());
        }
    }
    
    private void initComponents() {
        setSize(550, 500);
        setLocationRelativeTo(getParent());
        setResizable(false);
        setLayout(new BorderLayout(10, 10));
        
        // Couleur de fond
        Color bgColor = new Color(236, 240, 241);
        getContentPane().setBackground(bgColor);
        
        // Panel du titre
        JPanel panelTitre = new JPanel();
        panelTitre.setBackground(new Color(52, 73, 94));
        panelTitre.setPreferredSize(new Dimension(550, 60));
        
        JLabel lblTitre = new JLabel(
            client == null ? "➕ Nouveau Client" : "✏️ Modification du Client"
        );
        lblTitre.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitre.setForeground(Color.WHITE);
        panelTitre.add(lblTitre);
        
        add(panelTitre, BorderLayout.NORTH);
        
        // Panel du formulaire
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBackground(bgColor);
        panelForm.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 5, 10, 5);
        
        Font labelFont = new Font("Arial", Font.BOLD, 13);
        Font fieldFont = new Font("Arial", Font.PLAIN, 13);
        
        // Nom
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        JLabel lblNom = new JLabel("Nom * :");
        lblNom.setFont(labelFont);
        panelForm.add(lblNom, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtNom = new JTextField();
        txtNom.setFont(fieldFont);
        txtNom.setPreferredSize(new Dimension(250, 32));
        panelForm.add(txtNom, gbc);
        
        // Prénom
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        JLabel lblPrenom = new JLabel("Prénom * :");
        lblPrenom.setFont(labelFont);
        panelForm.add(lblPrenom, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtPrenom = new JTextField();
        txtPrenom.setFont(fieldFont);
        txtPrenom.setPreferredSize(new Dimension(250, 32));
        panelForm.add(txtPrenom, gbc);
        
        // Téléphone
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        JLabel lblTelephone = new JLabel("Téléphone * :");
        lblTelephone.setFont(labelFont);
        panelForm.add(lblTelephone, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtTelephone = new JTextField();
        txtTelephone.setFont(fieldFont);
        txtTelephone.setPreferredSize(new Dimension(250, 32));
        txtTelephone.setToolTipText("Ex: +229 12 34 56 78 ou 12345678");
        panelForm.add(txtTelephone, gbc);
        
        // Email
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        JLabel lblEmail = new JLabel("Email * :");
        lblEmail.setFont(labelFont);
        panelForm.add(lblEmail, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        txtEmail = new JTextField();
        txtEmail.setFont(fieldFont);
        txtEmail.setPreferredSize(new Dimension(250, 32));
        txtEmail.setToolTipText("Ex: exemple@email.com");
        panelForm.add(txtEmail, gbc);
        
        // Adresse
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.NORTH;
        JLabel lblAdresse = new JLabel("Adresse * :");
        lblAdresse.setFont(labelFont);
        panelForm.add(lblAdresse, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        gbc.anchor = GridBagConstraints.CENTER;
        txtAdresse = new JTextArea(3, 20);
        txtAdresse.setFont(fieldFont);
        txtAdresse.setLineWrap(true);
        txtAdresse.setWrapStyleWord(true);
        JScrollPane scrollAdresse = new JScrollPane(txtAdresse);
        scrollAdresse.setPreferredSize(new Dimension(250, 70));
        panelForm.add(scrollAdresse, gbc);
        
        // Note
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JLabel lblNote = new JLabel("* Tous les champs sont obligatoires");
        lblNote.setFont(new Font("Arial", Font.ITALIC, 11));
        lblNote.setForeground(new Color(127, 140, 141));
        panelForm.add(lblNote, gbc);
        
        add(panelForm, BorderLayout.CENTER);
        
        // Panel des boutons
        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        panelBoutons.setBackground(bgColor);
        
        btnValider = new JButton(client == null ? "✓ Ajouter" : "✓ Modifier");
        btnAnnuler = new JButton("✗ Annuler");
        
        Font btnFont = new Font("Arial", Font.BOLD, 14);
        
        btnValider.setFont(btnFont);
        btnValider.setBackground(new Color(46, 204, 113));
        btnValider.setForeground(Color.WHITE);
        btnValider.setFocusPainted(false);
        btnValider.setPreferredSize(new Dimension(140, 40));
        
        btnAnnuler.setFont(btnFont);
        btnAnnuler.setBackground(new Color(231, 76, 60));
        btnAnnuler.setForeground(Color.WHITE);
        btnAnnuler.setFocusPainted(false);
        btnAnnuler.setPreferredSize(new Dimension(140, 40));
        
        panelBoutons.add(btnValider);
        panelBoutons.add(btnAnnuler);
        
        add(panelBoutons, BorderLayout.SOUTH);
        
        // Listeners
        btnValider.addActionListener(e -> {
            if (validerChamps()) {
                confirmed = true;
                dispose();
            }
        });
        
        btnAnnuler.addActionListener(e -> {
            confirmed = false;
            dispose();
        });
        
        // Enter pour valider
        getRootPane().setDefaultButton(btnValider);
        
        // Escape pour annuler
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke("ESCAPE");
        getRootPane().registerKeyboardAction(
            e -> {
                confirmed = false;
                dispose();
            },
            escapeKeyStroke,
            JComponent.WHEN_IN_FOCUSED_WINDOW
        );
    }
    
    /**
     * Valider les champs du formulaire
     */
    private boolean validerChamps() {
        // Validation du nom
        if (txtNom.getText().trim().isEmpty()) {
            afficherErreur("Le nom est obligatoire !", txtNom);
            return false;
        }
        
        // Validation du prénom
        if (txtPrenom.getText().trim().isEmpty()) {
            afficherErreur("Le prénom est obligatoire !", txtPrenom);
            return false;
        }
        
        // Validation du téléphone
        if (txtTelephone.getText().trim().isEmpty()) {
            afficherErreur("Le téléphone est obligatoire !", txtTelephone);
            return false;
        }
        
        // Validation format téléphone (basique)
        String tel = txtTelephone.getText().replaceAll("[\\s-()]", "");
        if (!tel.matches("^\\+?[0-9]{8,15}$")) {
            afficherErreur("Le format du téléphone est invalide !\nExemple: +229 12 34 56 78 ou 12345678", txtTelephone);
            return false;
        }
        
        // Validation de l'email
        if (txtEmail.getText().trim().isEmpty()) {
            afficherErreur("L'email est obligatoire !", txtEmail);
            return false;
        }
        
        // Validation format email
        if (!txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            afficherErreur("Le format de l'email est invalide !\nExemple: exemple@email.com", txtEmail);
            return false;
        }
        
        // Validation de l'adresse
        if (txtAdresse.getText().trim().isEmpty()) {
            afficherErreur("L'adresse est obligatoire !", txtAdresse);
            return false;
        }
        
        return true;
    }
    
    /**
     * Afficher un message d'erreur et donner le focus au champ
     */
    private void afficherErreur(String message, JComponent champ) {
        JOptionPane.showMessageDialog(this,
            message,
            "Erreur de validation",
            JOptionPane.ERROR_MESSAGE);
        champ.requestFocus();
    }
    
    // Getters pour récupérer les valeurs saisies
    
    public boolean isConfirmed() {
        return confirmed;
    }
    
    public String getNom() {
        return txtNom.getText().trim();
    }
    
    public String getPrenom() {
        return txtPrenom.getText().trim();
    }
    
    public String getTelephone() {
        return txtTelephone.getText().trim();
    }
    
    public String getEmail() {
        return txtEmail.getText().trim();
    }
    
    public String getAdresse() {
        return txtAdresse.getText().trim();
    }
}
