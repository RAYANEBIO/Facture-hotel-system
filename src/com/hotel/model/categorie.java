/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.model;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;

//Attributs
public class categorie {
    private int id;
    private boolean estClimatise;
    private String description;
    private String choix_Categorie;
    
    //Les constructeurs

    public categorie(int id, boolean estClimatise, String description, String choix_Categorie)
    {
        this.id = id;
        this.estClimatise = estClimatise;
        this.description = description;
        this.choix_Categorie = choix_Categorie;
    }
    
    public categorie(){
        
    }


    //Les getters et setters
    public int getid()
    {
        return id;
    }
    public void setid(int id)
    {
        this.id = id;
    }
    
    public boolean getestClimatise()
    {
        return estClimatise;
    }
    public void setestClimatise(boolean estClimatise)
    {
        this.estClimatise = estClimatise;
    }
    
    public String getdescription()
    {
        return description;
    }
    public void setdescription(String description)
    {
        this.description = description;
    }
    
    
    // méthode de choix_Categorie
            
    public String choix_Categorie(JComboBox combo){
       String selection = combo.getSelectedItem().toString();
       return selection;
    }
}

