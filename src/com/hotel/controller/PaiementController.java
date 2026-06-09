/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.controller;

import com.hotel.dao.PaiementDAO;
import com.hotel.dao.ReservationDAO;
import com.hotel.dao.ClientDAO ;
import com.hotel.model.Paiement;
import java.sql.SQLException;
import java.util.List;
import com.hotel.model.Client;

public class PaiementController {

    private PaiementDAO dao = new PaiementDAO();

    public List<Paiement> getAllPaiements() throws SQLException {
        return dao.findAll();
    }

    public void updatePaiement(Paiement p) throws SQLException {
        dao.update(p);
    }
    private ReservationDAO reservationDAO = new ReservationDAO();

    public float getMontantReservation(int id) throws SQLException {
        return reservationDAO.getMontantTotal(id);
    }
    private ClientDAO clientDAO = new ClientDAO();
    
    public Client getInfo(int idReservation) throws SQLException {
    return clientDAO.getInfo(idReservation);
}

    public float calculerTTC(float ht) {
        return ht + (ht * 18 / 100);
    }

    public float calculerNetAPayer(float ttc, float avance) {
        return ttc - avance;
    }

    public void ajouterPaiement(Paiement p) throws Exception {
        dao.insert(p);
    }
}
