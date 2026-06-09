/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Personnel
 */
public class ConnexionChambre {
    
        public static Connection obtenirConnexion(){
            Connection con = null;
            try {
                String url = "jdbc:mysql://localhost:3307/hotel_gestion";
                String user = "root"; //Par défaut dur xampp
                String password = "";
                con= DriverManager.getConnection(url,user,password);
                
                System.out.println("Connexion réussi !");
                
            }catch (Exception e){
                System.out.println("Erreur de connexion : " + e.getMessage());
            }
            return con;
        }
        
    }

