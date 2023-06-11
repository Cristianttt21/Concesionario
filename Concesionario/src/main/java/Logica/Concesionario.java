/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Logica;

import Formularios.Frm_AgregarVehiculo;
import Formularios.Frm_Venta;
import java.util.Scanner;
/**
 *
 * @author rzl10
 */
public class Concesionario {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opc;
        
        System.out.println("Digite por favor si desea   Registrar vehiculo o Registrar venta");
        opc = entrada.nextInt();
        
        if (opc = 1) {
            Frm_AgregarVehiculo AV = new Frm_AgregarVehiculo();
            AV.setVisible(true);
        }
        else {
            Frm_Venta AgV = new Frm_Venta();
            AgV.setVisible(true);
        }
        
        
    }
}
