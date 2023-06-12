package Logica;

import Formularios.Frm_AgregarVehiculo;
import Formularios.Frm_RegistroVentas;
import java.util.Scanner;

public class Concesionario {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese Opcion ");
        int opc = in.nextInt();

        switch (opc) {
            case 1: {
                Frm_AgregarVehiculo AV = new Frm_AgregarVehiculo();
                AV.setVisible(true);
                break;
            }
            case 2: {
                Frm_RegistroVentas RV = new Frm_RegistroVentas();
                RV.setVisible(true);
                break;
            }
            default:
                System.out.println("Default");
        }
    }

}
