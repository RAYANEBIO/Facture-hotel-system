package com.hotel.view;

import com.hotel.controller.AuthController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Fenêtre de connexion
 * 
 * @author HP
 */
public class ConnexionFrame extends JFrame {

    private JTextField txtLogin;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private AuthController authController;

    public ConnexionFrame() {
        authController = new AuthController();
        initComponents();
        this.setLocationRelativeTo(null); // Centrer la fenêtre
    }

    private void initComponents() {
        setTitle("Gestion Hôtel - Connexion");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel Principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Titre
        JLabel lblTitle = new JLabel("Connexion");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblTitle, gbc);

        // Login
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(new JLabel("Login:"), gbc);

        txtLogin = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(txtLogin, gbc);

        // Mot de passe
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Mot de passe:"), gbc);

        txtPassword = new JPasswordField(20);
        gbc.gridx = 1;
        mainPanel.add(txtPassword, gbc);

        // Bouton Login
        btnLogin = new JButton("Se connecter");
        btnLogin.setBackground(new Color(51, 153, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(btnLogin, gbc);

        add(mainPanel, BorderLayout.CENTER);

        // Action Listener
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = txtLogin.getText();
                String password = new String(txtPassword.getPassword());

                if (authController.authentifier(login, password, ConnexionFrame.this)) {
                    // Récupérer les infos de l'utilisateur
                    com.hotel.model.Personnel user = authController.getPersonnelByLogin(login);
                    // Ouvrir la fenêtre principale (Dashboard) avec l'utilisateur
                    new MainFrame(user).setVisible(true);
                    dispose(); // Fermer la fenêtre de connexion
                }
            }
        });
    }

    public static void main(String[] args) {
        // Look & Feel Windows
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ConnexionFrame().setVisible(true);
        });
    }
}
