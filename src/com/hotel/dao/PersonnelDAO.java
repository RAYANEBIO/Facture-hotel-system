/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.dao;
import com.hotel.model.Personnel;
import com.hotel.util.DBConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class PersonnelDAO {
    private List<Personnel> personnels = new ArrayList<>();
    
    public static int nbrPersonnel = 0;
    
    public void ajouterPersonnel(Personnel personnel) 
    { this.personnels.add(personnel); PersonnelDAO.nbrPersonnel++;}
    
    public List<Personnel> getPersonnels() { return this.personnels; }
    
    public void supprimerPersonnel(Personnel personnel) 
    { this.personnels.remove(personnel); PersonnelDAO.nbrPersonnel--;}
    
    public void supprimerPersonnel(int id)
    { personnels.removeIf(u -> u.getId() == id); PersonnelDAO.nbrPersonnel--;}
    
    public void personnelUpdate(Personnel personnel) { 
     for (Personnel p : personnels) 
         if(personnel.getId() == p.getId()) { p = personnel; break;}     
    }
    
    public void affecteChambre(int id, String Chambre)
    {
       for (Personnel p : personnels) 
         if(id == p.getId()) { p.newAffectation(Chambre); break;}   
    }
    
    public void retireChambre(int id, String Chambre)
    {
        for (Personnel p : personnels) 
         if(id == p.getId()) { p.desAffectation(Chambre); break;}   
    }
    
    public int peronnelAffectationNbr(int id)
    {
     for (Personnel p : personnels) 
         if(id == p.getId()) { return p.getAffectationNbr();}  
     
     return -1;
    }
    public Personnel rechercherParLogin(String login) {
        String sql = "SELECT * FROM personnel WHERE login = ?";

        try (Connection conn = DBConnexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToPersonnel(rs);
            }

        } catch (SQLException e) {
            System.err.println("Erreur recherche personnel par login: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Rechercher par ID
     */
    public Personnel rechercherParId(int idPersonnel) {
        String sql = "SELECT * FROM personnel WHERE id_personnel = ?";

        try (Connection conn = DBConnexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPersonnel);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToPersonnel(rs);
            }

        } catch (SQLException e) {
            System.err.println("Erreur recherche personnel par ID: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
private Personnel mapResultSetToPersonnel(ResultSet rs) throws SQLException {
        return new Personnel(
                rs.getInt("id_personnel"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getInt("telephone"),
                rs.getString("adresse"),
                rs.getString("motDePasse"),
                rs.getString("role"),
                rs.getString("login"));
        
    }
}
