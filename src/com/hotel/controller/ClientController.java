/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.controller;

import com.hotel.dao.ClientDAO;
import com.hotel.model.Client;

import javax.swing.*;
import java.util.List;


public class ClientController {
    
    private ClientDAO clientDAO;
    
    public ClientController() {
        this.clientDAO = new ClientDAO();
    }
    
    /**
     * Ajout d'un nouveau client avec validation 
    * @author Noufous
     */
    public boolean ajouterClient(String nom, String prenom, String telephone, String email, String adresse, JPanel parent) {
        // Validation du nom
        if (nom == null || nom.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, 
                "Le nom est obligatoire !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validation du prénom
        if (prenom == null || prenom.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, 
                "Le prénom est obligatoire !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validation du téléphone
        if (telephone == null || telephone.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, 
                "Le téléphone est obligatoire !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validation format téléphone
        String telClean = telephone.replaceAll("[\\s-()]", "");
        if (!telClean.matches("^\\+?[0-9]{8,15}$")) {
            JOptionPane.showMessageDialog(parent, 
                "Le format du téléphone est invalide !\nExemple: +229 12 34 56 78 ou 12345678", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validation de l'email
        if (email == null || email.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, 
                "L'email est obligatoire !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validation format email
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            JOptionPane.showMessageDialog(parent, 
                "Le format de l'email est invalide !\nExemple: exemple@email.com", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Vérifier si l'email existe déjà
        if (clientDAO.emailExiste(email)) {
            JOptionPane.showMessageDialog(parent, 
                "Cet email est déjà utilisé par un autre client !", 
                "Email en doublon", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validation de l'adresse
        if (adresse == null || adresse.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, 
                "L'adresse est obligatoire !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Création et ajout du client
        Client client = new Client(
            nom.trim(), 
            prenom.trim(), 
            telephone.trim(), 
            email.trim().toLowerCase(), 
            adresse.trim()
        );
        
        boolean success = clientDAO.ajouter(client);
        
        if (success) {
            JOptionPane.showMessageDialog(parent, 
                "Client ajouté avec succès !\nID: " + client.getIdClient(), 
                "Succès", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(parent, 
                "Erreur lors de l'ajout du client !\nVeuillez vérifier la connexion à la base de données.", 
                "Erreur", 
                JOptionPane.ERROR_MESSAGE);
        }
        
        return success;
    }
    
    /**
     * Modifier un client existant avec validation complète
     */
    public boolean modifierClient(int id, String nom, String prenom, String telephone, String email, String adresse, JPanel parent) {
        // Validation du nom
        if (nom == null || nom.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, 
                "Le nom est obligatoire !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validation du prénom
        if (prenom == null || prenom.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, 
                "Le prénom est obligatoire !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validation du téléphone
        if (telephone == null || telephone.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, 
                "Le téléphone est obligatoire !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validation format téléphone
        String telClean = telephone.replaceAll("[\\s-()]", "");
        if (!telClean.matches("^\\+?[0-9]{8,15}$")) {
            JOptionPane.showMessageDialog(parent, 
                "Le format du téléphone est invalide !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validation de l'email
        if (email == null || email.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, 
                "L'email est obligatoire !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validation format email
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            JOptionPane.showMessageDialog(parent, 
                "Le format de l'email est invalide !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Vérifier si l'email existe déjà (sauf pour ce client)
        if (clientDAO.emailExiste(email, id)) {
            JOptionPane.showMessageDialog(parent, 
                "Cet email est déjà utilisé par un autre client !", 
                "Email en doublon", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validation de l'adresse
        if (adresse == null || adresse.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, 
                "L'adresse est obligatoire !", 
                "Erreur de validation", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Modification du client
        Client client = new Client(
            id,
            nom.trim(), 
            prenom.trim(), 
            telephone.trim(), 
            email.trim().toLowerCase(), 
            adresse.trim()
        );
        
        boolean success = clientDAO.modifier(client);
        
        if (success) {
            JOptionPane.showMessageDialog(parent, 
                "Client modifié avec succès !", 
                "Succès", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(parent, 
                "Erreur lors de la modification du client !", 
                "Erreur", 
                JOptionPane.ERROR_MESSAGE);
        }
        
        return success;
    }
    
    /**
     * Supprimer un client avec confirmation
     */
    public boolean supprimerClient(int id, JPanel parent) {
        int confirm = JOptionPane.showConfirmDialog(parent,
            "Êtes-vous sûr de vouloir supprimer ce client ?\n" +
            "Cette action est irréversible.\n\n" +
            "Note: Si le client a des réservations, la suppression échouera.",
            "Confirmation de suppression",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = clientDAO.supprimer(id);
            
            if (success) {
                JOptionPane.showMessageDialog(parent, 
                    "Client supprimé avec succès !", 
                    "Succès", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parent, 
                    "Impossible de supprimer ce client !\n" +
                    "Il a probablement des réservations associées.\n" +
                    "Veuillez d'abord supprimer ou modifier ses réservations.", 
                    "Erreur", 
                    JOptionPane.ERROR_MESSAGE);
            }
            
            return success;
        }
        
        return false;
    }
    
    /**
     * Rechercher des clients par nom ou prénom
     */
    public List<Client> rechercherClients(String recherche) {
        if (recherche == null || recherche.trim().isEmpty()) {
            return clientDAO.getTousLesClients();
        }
        return clientDAO.rechercherParNom(recherche.trim());
    }
    
    /**
     * Obtenir tous les clients
     */
    public List<Client> getTousLesClients() {
        return clientDAO.getTousLesClients();
    }
    
    /**
     * Obtenir un client par son ID
     */
    public Client getClientParId(int id) {
        return clientDAO.rechercherParId(id);
    }
    
    /**
     * Obtenir le nombre total de clients
     */
    public int getNombreClients() {
        return clientDAO.getNombreClients();
    }
    
    /**
     * Vérifier si un client existe
     */
    public boolean clientExiste(int id) {
        return clientDAO.existe(id);
    }
    
    /**
     * Rechercher un client par email
     */
    public Client rechercherParEmail(String email) {
        return clientDAO.rechercherParEmail(email);
    }
    
    /**
     * Rechercher un client par téléphone
     */
    public Client rechercherParTelephone(String telephone) {
        return clientDAO.rechercherParTelephone(telephone);
    }
}
