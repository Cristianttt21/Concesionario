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
public class Cls_RegistroVentas {
    
    
    private final String SQL_INSERT = "INSERT INTO concesionario.registroventa (monto_venta, vehiculo_placa, apellido, nombre, documento) VALUES (?, ?, ?, ?, ?)";
    private PreparedStatement PS;
    private final Conectar CN;
    
    public Cls_RegistroVentas(){
        PS=null;
        CN= new Conectar();
    }
    
    public int insertDatos(float monto_venta, String vehiculo_placa, String apellido, String nombre, String documento){
        
        try{
            PS=CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setFloat(1, monto_venta);
            PS.setString(2, vehiculo_placa);
            PS.setString(3, apellido);
            PS.setString(4, nombre);
            PS.setString(5, documento);
            
            int respuesta = PS.executeUpdate();
            if (respuesta>0){
                JOptionPane.showMessageDialog(null, "Registro guardado");
            }
            
            
        }catch (SQLException e){
            System.out.println("Error al guardar los datos" + e.getMessage());
        }
        finally{
            PS=null;
            CN.desconectar();
                    }
        
        return 0;
    }
    
    
}
