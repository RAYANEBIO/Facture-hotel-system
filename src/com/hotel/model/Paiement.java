/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.model;
import java.time.LocalDate;
/**
 *
 * @author HP
 */
public class Paiement {
    int idPaiement;
    LocalDate date = LocalDate.now();    
    float montantPaye;
    String modePaiement;
    String statutPaiement;
    int idReservation;

    public Paiement(int idPaiement,
                LocalDate date,
                float montantPaye,
                String modePaiement,
                String statutPaiement,
                int idReservation) {

    this.idPaiement = idPaiement;
    this.date = date;
    this.montantPaye = montantPaye;
    this.modePaiement = modePaiement;
    this.statutPaiement = statutPaiement;
    this.idReservation = idReservation;
}

    public Paiement() {
    } 

    public int getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(int idPaiement) {
        this.idPaiement = idPaiement;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(float montantPaye) {
        this.montantPaye = montantPaye;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }
    
}
