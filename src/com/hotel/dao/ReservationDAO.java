/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author HP
 */
public class ReservationDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel_gestion",
            "root",
            ""
        );
    }
    
    public float getMontantTotal(int idReservation) throws SQLException {

    float montant = 0;

    String sql = "SELECT montantTotal FROM reservation WHERE idReservation = ?";

    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idReservation);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            montant = rs.getFloat("montantTotal");
        }
    }

    return montant;
}


}
