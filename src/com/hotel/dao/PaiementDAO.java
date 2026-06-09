/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.dao;

import com.hotel.model.Paiement;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaiementDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel_gestion","root","");
    }

    public List<Paiement> findAll() throws SQLException {
        List<Paiement> liste = new ArrayList<>();

        String sql = "SELECT * FROM paiement";
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Paiement p = new Paiement(
                    rs.getInt("idPaiement"),
                    rs.getDate("date").toLocalDate(),
                    rs.getFloat("montantPaye"),
                    rs.getString("modePaiement"),
                    rs.getString("statutPaiement"),
                    rs.getInt("idReservation")
                );
                liste.add(p);
            }
        }
        return liste;
    }

    public void update(Paiement p) throws SQLException {
        String sql = "UPDATE paiement SET datePaiement=?, montantPaye=?, modePaiement=?, statutPaiement=? WHERE idPaiement=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(p.getDate()));
            ps.setFloat(2, p.getMontantPaye());
            ps.setString(3, p.getModePaiement());
            ps.setString(4, p.getStatutPaiement());
            ps.setInt(5, p.getIdPaiement());

            ps.executeUpdate();
        }
    }
    public void insert(Paiement p) throws SQLException {

    String sql = "INSERT INTO paiement(datePaiement,montantPaye,modePaiement,statutPaiement) VALUES (?,?,?,?)";

    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setDate(1, Date.valueOf(p.getDate()));
        ps.setFloat(2, p.getMontantPaye());
        ps.setString(3, p.getModePaiement());
        ps.setString(4, p.getStatutPaiement());

        ps.executeUpdate();
    }
}
}