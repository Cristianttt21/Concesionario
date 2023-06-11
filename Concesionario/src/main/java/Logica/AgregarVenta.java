/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Clases.Conectar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian
 */
public class AgregarVenta {
    
    private final String SQL_INSERT = "INSERT INTO concesionario.vehiculo(placa, marca, tipo, modelo, kilometraje) VALUES (?,?,?,?,?)";
    private PreparedStatement PS;
    private Conectar CN;
    
    public AgregarVenta() { 
        PS = null;
        CN = new Conectar();
    }

    public int insertDatos(String monto, String codigo, String nombre, String apellido, String documento) {
        
        try{
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1, monto);
            PS.setString(2, codigo);
            PS.setString(3, nombre);
            PS.setString(4, apellido);
            PS.setString(5, documento);
            int res = PS.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null,"Guardado Exitoso");
            }
        }catch (SQLException e) {
            System.err.println("Error al guardar datos en BD:" + e.getMessage());
        } finally{
            PS = null;
            CN.desconectar();
        }
        
        return 0;

        
    }
    
}
