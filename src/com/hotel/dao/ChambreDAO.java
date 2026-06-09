/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.dao;
import java.sql.*;
import com.hotel.model.Chambre;  
import com.hotel.model.categorie;

/**
 *
 * @author HP
 */
public class ChambreDAO {
   public void ajouterChambre(Chambre ch, categorie cat){
       try{
           Connection con = ConnexionChambre.obtenirConnexion();
           String sql = "INSERT INTO chambre (numero, typeChambre, prixParNuit, statut, description, estClimatise) VALUES (?,?,?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
           
           pst.setInt(1, ch.getnumero());
           pst.setString(2, ch.getcategorie()); 
           pst.setDouble(3, ch.getprixParNuit());
           pst.setString(4, ch.getstatut());
           pst.setString(5, cat.getdescription());
           pst.setBoolean(6, cat.getestClimatise());
           
           pst.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }
   } 
   
    
}
