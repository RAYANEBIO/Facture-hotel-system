/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.dao;
import com.hotel.model.Paiement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hotel.model.Client;
import com.hotel.util.DBConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object pour la gestion des clients
 * Adapté à la structure réelle de la table client
 * @author Noufous
 */
public class ClientDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel_gestion",
            "root",
            ""
        );
    }
    public Client getInfo(int idReservation) throws SQLException {

    String sql = "SELECT nom, adresse FROM client WHERE idReservation = ?";

    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idReservation);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Client(
                rs.getString("nom"),
                rs.getString("adresse")
            );
        }
    }

    return null;
}
    /**
     * Ajouter un nouveau client dans la base de données
     * @param client Le client à ajouter
     * @return true si l'ajout a réussi, false sinon
     */
    public boolean ajouter(Client client) {
        String sql = "INSERT INTO client (nom, prenom, telephone, email, adresse) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, client.getNom());
            pstmt.setString(2, client.getPrenom());
            pstmt.setString(3, client.getTelephone());
            pstmt.setString(4, client.getEmail());
            pstmt.setString(5, client.getAdresse());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                // Récupérer l'ID généré automatiquement
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    client.setIdClient(rs.getInt(1));
                }
                return true;
            }
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du client : " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * Modifier un client existant
     * @param client Le client avec les nouvelles informations
     * @return true si la modification a réussi, false sinon
     */
    public boolean modifier(Client client) {
        String sql = "UPDATE client SET nom = ?, prenom = ?, telephone = ?, email = ?, adresse = ? WHERE idClient = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, client.getNom());
            pstmt.setString(2, client.getPrenom());
            pstmt.setString(3, client.getTelephone());
            pstmt.setString(4, client.getEmail());
            pstmt.setString(5, client.getAdresse());
            pstmt.setInt(6, client.getIdClient());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification du client : " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * Supprimer un client de la base de données
     * @param idClient L'ID du client à supprimer
     * @return true si la suppression a réussi, false sinon
     */
    public boolean supprimer(int idClient) {
        String sql = "DELETE FROM client WHERE idClient = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idClient);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du client : " + e.getMessage());
            e.printStackTrace();
            // Si erreur de contrainte (client a des réservations), retourner false
        }
        
        return false;
    }
    
    /**
     * Rechercher un client par son ID
     * @param idClient L'ID du client recherché
     * @return Le client trouvé ou null si non trouvé
     */
    public Client rechercherParId(int idClient) {
        String sql = "SELECT * FROM client WHERE idClient = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idClient);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Client(
                    rs.getInt("idClient"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getString("adresse")
                );
            }
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche du client : " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Rechercher des clients par nom ou prénom (recherche partielle)
     * @param recherche Le terme de recherche
     * @return La liste des clients correspondants
     */
    public List<Client> rechercherParNom(String recherche) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client WHERE nom LIKE ? OR prenom LIKE ? ORDER BY nom, prenom";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            String pattern = "%" + recherche + "%";
            pstmt.setString(1, pattern);
            pstmt.setString(2, pattern);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                clients.add(new Client(
                    rs.getInt("idClient"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getString("adresse")
                ));
            }
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
            e.printStackTrace();
        }
        
        return clients;
    }
    
    /**
     * Rechercher un client par email
     * @param email L'email du client
     * @return Le client trouvé ou null
     */
    public Client rechercherParEmail(String email) {
        String sql = "SELECT * FROM client WHERE email = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Client(
                    rs.getInt("idClient"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getString("adresse")
                );
            }
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche par email : " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Rechercher un client par téléphone
     * @param telephone Le numéro de téléphone
     * @return Le client trouvé ou null
     */
    public Client rechercherParTelephone(String telephone) {
        String sql = "SELECT * FROM client WHERE telephone = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, telephone);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Client(
                    rs.getInt("idClient"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getString("adresse")
                );
            }
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche par téléphone : " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Obtenir tous les clients
     * @return La liste de tous les clients
     */
    public List<Client> getTousLesClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client ORDER BY nom, prenom";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                clients.add(new Client(
                    rs.getInt("idClient"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getString("adresse")
                ));
            }
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des clients : " + e.getMessage());
            e.printStackTrace();
        }
        
        return clients;
    }
    
    /**
     * Obtenir le nombre total de clients dans la base
     * @return Le nombre de clients
     */
    public int getNombreClients() {
        String sql = "SELECT COUNT(*) as total FROM client";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getInt("total");
            }
            
        } catch (SQLException e) {
            System.err.println("Erreur lors du comptage des clients : " + e.getMessage());
            e.printStackTrace();
        }
        
        return 0;
    }
    
    /**
     * Vérifier si un client existe
     * @param idClient L'ID du client
     * @return true si le client existe, false sinon
     */
    public boolean existe(int idClient) {
        return rechercherParId(idClient) != null;
    }
    
    /**
     * Vérifier si un email existe déjà (pour éviter les doublons)
     * @param email L'email à vérifier
     * @return true si l'email existe déjà, false sinon
     */
    public boolean emailExiste(String email) {
        return rechercherParEmail(email) != null;
    }
    
    /**
     * Vérifier si un email existe déjà (sauf pour un client donné lors de modification)
     * @param email L'email à vérifier
     * @param idClientExclus L'ID du client à exclure de la vérification
     * @return true si l'email existe déjà pour un autre client, false sinon
     */
    public boolean emailExiste(String email, int idClientExclus) {
        String sql = "SELECT * FROM client WHERE email = ? AND idClient != ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, email);
            pstmt.setInt(2, idClientExclus);
            ResultSet rs = pstmt.executeQuery();
            
            return rs.next();
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de la vérification de l'email : " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
}
