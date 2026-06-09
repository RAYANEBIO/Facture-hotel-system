/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.model;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Personnel {
    private int id = 0;
    private String nom;
    private String prenom;
    private int telephone = 0;
    private String adress = "";
    private String mot2pass = "";
    private String role = "";
    private String login = "";
    private List<String> affectation = new ArrayList<>();
    
    public Personnel(int id, String nom, String prenom, int telephone , String adress, String mot2pass, String role, String login){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adress = adress;
        this.mot2pass = mot2pass;
        this.role = role;
        this.login = login;
    }
    public Personnel(String nom, String prenom, String adresse, int telephone, String login,
            String motDePasse, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adresse;
        this.telephone = telephone;
        this.login = login;
        this.mot2pass = motDePasse;
        this.role = role;
    }
    // Getters
    public int getId() {return id;}
    public String getNom() { return nom;}
    public String getPrenom() { return prenom;}
    public String getAdress() { return adress;}
    public String getMot2Pass() { return mot2pass;}
    public String getRole() { return role;}
    public String getLogin() { return login;}
    public int getTelephone() { return telephone;}
    public List<String> getAffectation() { return affectation;}
    public int getAffectationNbr()  { return affectation.size();}
    
    // Setters
    
   public  void setId(int id) {this.id = id;}
   public void setNom(String nom) {this.nom = nom;}
   public  void setPrenom(String prenom) {this.prenom = prenom;}
   public  void setAdress(String adress) {this.adress = adress;}
   public  void setMot2Pass(String mot2pass) {this.mot2pass = mot2pass;}
   public  void setRole(String role) {this.role = role;}
   public void setLogin(String login) {this.login = login;}
   public void setTelephone(int telephone) {this.telephone = telephone;} 
   public void newAffectation(String chambre) { this.affectation.add(chambre);}
   public void desAffectation(String chambre) { this.affectation.remove(chambre);}
    
}
