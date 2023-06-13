/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Clases.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rzl10
 */
public class Cls_ActualizarVehiculo {

    private final String SQL_SELECT = "SELECT placa, marca, tipo, modelo, kilometraje FROM concesionario.vehiculo";
    private PreparedStatement PS;
    private DefaultTableModel DT;
    private ResultSet RS;
    private final Conectar CN;

    public Cls_ActualizarVehiculo() {
        PS = null;
        CN = new Conectar();
    }

    private DefaultTableModel setTitulos() {
        DT = new DefaultTableModel();
        DT.addColumn("placa");
        DT.addColumn("marca");
        DT.addColumn("tipo");
        DT.addColumn("modelo");
        DT.addColumn("kilometraje");
        return DT;
    }

    public int updateData(String marca, String tipo, int modelo, int kilometraje, String placa) {
        
        String SQL_UPDATE = "UPDATE concesionario.vehiculo SET marca = '" + marca + "', tipo = '" + tipo + "', modelo = " + modelo + ", kilometraje = " + kilometraje + " WHERE placa = '" + placa + "'";
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_UPDATE);
            System.out.println("llamado a getconnection: " + PS);
            res = PS.executeUpdate();
            System.out.println("el valor de res" + res);
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
            }
            else {
                JOptionPane.showMessageDialog(null, "Error en Actualizacion");
            }
        } catch (SQLException e) {
            System.out.println("Error actualizando informacion ...");
        } finally {
            PS = null;
            CN.desconectar();
        }

        return res;
    }

    public DefaultTableModel getDatos() {
        try {
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();

            Object[] fila = new Object[5];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getInt(4);
                fila[4] = RS.getInt(5);
                DT.addRow(fila);
            }
            //System.out.println();
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos" + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return DT;
    }
}
