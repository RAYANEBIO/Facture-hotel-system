/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.model;


/**
 *
 * @author HP
 */


// Les attributs
public class Chambre {
    private int id;
    private int numero;
    private String categorie;
    private double prixParNuit;
    private String statut;
    
    
    // Les constructeurs
    public Chambre(int id, int numero, String categorie, double prixParNuit, String statut)
    {
        this.id = id;
        this.numero = numero;
        this.categorie = categorie;
        this.prixParNuit = prixParNuit;
        this.statut = statut;
    }
    public Chambre(){
        
    }
    
    
    //Les méthodes
    
        //Disponibilité(statut)
    public String estDisponible()
    {
        return statut;
    }
    
    // Getters et setters
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }
    
    public int getnumero(){
        return numero;
    }
    public void setnumero(int numero){
        this.numero = numero;
    }
    
    public String getcategorie(){
       return categorie; 
    } 
    public void setcategorie(String categorie){
        this.categorie = categorie;
    }
    
    public double getprixParNuit(){
       return prixParNuit; 
    }
    public void setprixParNuit(double prixParNuit){
        this.prixParNuit = prixParNuit;
    }
    
    public String getstatut(){
        return statut;
    }
    public void setstatut(String statut){
        this.statut = statut;
    }
}  


 
