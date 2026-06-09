/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DBConnexion {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_gestion"; // Remplacez gestion_hotel par le nom                                                                     // de votre base de donnée
    private static final String USER = "root"; // Generalement c'est root ou mettez Le username de votre base de donnée
    private static final String PASSWORD = ""; // Moi j'ai pas defini de Password pour ma base de donnée mais si vous en
                                               // avez defini, mettez le ici

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Chargement du driver
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : Driver MySQL introuvable, verifier son emplacement");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur: Impossible de se connecter à la Base de donnée");
            e.printStackTrace();
        }
        return null;
    }

    // Plus nécessaire si on utilise try-with-resources dans les DAOs,
    // mais gardé pour compatibilité avec le code existant si utilisé ailleurs.
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
