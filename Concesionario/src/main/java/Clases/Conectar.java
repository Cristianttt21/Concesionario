package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Clase que permite establecer la conexion a la base de datos de mysql */

public class Conectar {
    
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/concesionario";
    

    public Conectar() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexion realizada Ok " +conn);
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: " + e);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void desconectar(){
        conn = null;
        if (conn == null){
            System.out.println("Desconectado....");
        }
    }
}
