/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.controller;

import com.hotel.dao.PersonnelDAO;
import com.hotel.model.Personnel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Controller pour l'authentification
 * 
 * @author HP
 */
public class AuthController {

    private PersonnelDAO personnelDAO;

    public AuthController() {
        this.personnelDAO = new PersonnelDAO();
    }

    /**
     * Valider l'authentification (version simple pour démonstration)
     */
    public boolean authentifier(String login, String password, JFrame parent) {
        // Validation
        if (login == null || login.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Login requis !", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Mot de passe requis !", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Rechercher le personnel par login
        Personnel personnel = personnelDAO.rechercherParLogin(login);

        if (personnel == null) {
            JOptionPane.showMessageDialog(parent, "Utilisateur non trouvé !", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Vérifier le mot de passe
        if (personnel.getMot2Pass() != null && personnel.getMot2Pass().equals(password)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(parent, "Mot de passe incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Rechercher un personnel par login
     */
    public Personnel getPersonnelByLogin(String login) {
        return personnelDAO.rechercherParLogin(login);
    }
}
