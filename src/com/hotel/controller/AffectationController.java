/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.controller;
import com.hotel.dao.PersonnelDAO;
import com.hotel.model.Personnel;

/**
 *
 * @author HP
 */
public class AffectationController {
    
    PersonnelDAO dao = new PersonnelDAO();
    
    public void newPersonnel(Personnel personnel)
    {
        dao.ajouterPersonnel(personnel);
    }
    
    public void deletePersonnel(int id)
    { dao.supprimerPersonnel(id);}
    
    public void modifierInfo(Personnel personnel)
    { dao.personnelUpdate(personnel);}
    
    public void affectation(int id, String Chambre)
    { dao.affecteChambre(id, Chambre);}
    
    public void desAffecter(int id, String Chambre)
    { dao.retireChambre(id, Chambre);}  
    
    public int affectationNbr(int id)
    {
     return dao.peronnelAffectationNbr(id);
    }
    
}
