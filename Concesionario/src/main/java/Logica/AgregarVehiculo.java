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
 * @author rzl10
 */
public class AgregarVehiculo {
    private final String SQL_INSERT = "INSERT INTO concesionario.vehiculo(placa, marca, tipo, modelo, kilometraje) VALUES (?,?,?,?,?)";
    private PreparedStatement PS;
    private Conectar CN;
    
    public AgregarVehiculo() { 
        PS = null;
        CN = new Conectar();
    }
    
    public int insertDatos(String placa, String marca, String tipo, int modelo, int kilometraje){
        
        try{
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1, placa);
            PS.setString(2, marca);
            PS.setString(3, tipo);
            PS.setInt(4, modelo);
            PS.setInt(5, kilometraje);
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
