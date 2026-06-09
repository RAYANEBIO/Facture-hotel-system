/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.model;

import java.util.List;

/**
 * Classe représentant un client de l'hôtel
 * Adaptée à la structure réelle de la base de données
 * @author Noufous
 */
public class Client {
    
    // Attributs selon la structure réelle de la table client
    private int idClient;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    
    // Constructeur vide
    public Client() {
    }
    
    // Constructeur avec paramètres (sans ID pour création)
    public Client(String nom, String prenom, String telephone, String email, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
    }
    public Client(String nom, String adresse) {
    this.nom = nom;
    this.adresse = adresse;
}
    // Constructeur complet (pour lecture depuis la base de données)
    public Client(int idClient, String nom, String prenom, String telephone, String email, String adresse) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
    }
    
    // Getters et Setters
    public int getIdClient() {
        return idClient;
    }
    
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    /**
     * Méthode pour consulter l'historique des réservations du client
     * Selon le cahier des charges
     * Cette méthode sera complétée quand le module Réservation sera intégré (Laurel)
     */
    public List<Object> consulterHistorique() {
        // TODO: Implémenter avec ReservationDAO quand disponible
        // ReservationDAO reservationDAO = new ReservationDAO();
        // return reservationDAO.getReservationsByClient(this.idClient);
        return null;
    }
    
    /**
     * Obtenir le nom complet du client
     * Utile pour l'affichage dans les interfaces
     */
    public String getNomComplet() {
        return prenom + " " + nom;
    }
    
    /**
     * Vérifier si l'email est valide (format basique)
     */
    public boolean isEmailValide() {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    
    /**
     * Vérifier si le téléphone est valide (format basique)
     */
    public boolean isTelephoneValide() {
        if (telephone == null || telephone.isEmpty()) {
            return false;
        }
        // Accepte les numéros avec ou sans espaces, tirets, etc.
        String tel = telephone.replaceAll("[\\s-()]", "");
        return tel.matches("^\\+?[0-9]{8,15}$");
    }
    
    // Méthode toString pour affichage et debug
    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
