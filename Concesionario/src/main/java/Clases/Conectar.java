package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* prueba de act


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rzl10
 */
public class Conectar {
    
    private static Connection conn;
    private static  final String driver = "com.mysql.jdbc.Driver";
    private static  final String user = "root";
    private static  final String password = "";
    private static  final String url = "jdbc:mysql://localhost:3306/concesionario";
    

    public Conectar() {
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Conexion realizada Ok");
            }
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar" + e);
        }

    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void desconectar (){
        conn = null;
        if(conn == null){
            System.out.println("Desconectado...");
        }
    }
}