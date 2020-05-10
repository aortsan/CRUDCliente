/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import utilidades.Utilidad;
import java.util.Scanner;

/**
 *
 * @author Álvaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer opcion;
        
        Utilidad.conexion();
        
        System.out.println("\t\tBIENVENIDO");
        System.out.println("\t\t-----------");
        
        Utilidad.listado();

        while (true) {
            try {
                System.out.println("\nELIJA ALGUNA DE LAS OPCIONES QUE SE MUESTRAN A CONTINUACIÓN\n");
                System.out.println("  1. Visualizar los diez siguientes.");
                System.out.println("  2. Visualizar los diez anteriores.");
                System.out.println("  3. Introducir nuevo registro.");
                System.out.println("  4. Actualizar dato de cliente por IdCliente.");
                System.out.println("  5. Borrar dato por IdCliente.\n");
                System.out.print("Su elección [introduzca 0 para salir]: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 0:
                        System.out.println("\nHasta pronto.\n");
                        System.out.println("\t    -------------");
                        System.out.println("\t\tFIN\n");
                        System.exit(0);
                        break;
                    case 1:
                        Utilidad.siguiente();
                        break;
                    case 2:
                        Utilidad.anterior();
                        break;
                    case 3:
                        Utilidad.introducirCliente();
                        break;
                    case 4:
                        menuActualizar();
                        break;
                    case 5:
                        Utilidad.borrarCliente();
                        break;
                    default:
                        System.out.println("Debe elegir una opción válida.");
                }
            } catch (NumberFormatException nfe) {
                System.err.println("\nError: Entrada no válida. " + nfe.getMessage() + "\n");
            }
        }
    }

    public static void menuActualizar() {
        System.out.println("\nACTUALIZAR");
        System.out.println("----------");

        Scanner sc = new Scanner(System.in);
        Integer opcion;

        System.out.println("Indique el campo que desea modificar:");
        System.out.println("  1.  Código del cliente\n"
                + "  2.  Empresa\n"
                + "  3.  Contacto\n"
                + "  4.  Cargo del contacto\n"
                + "  5.  Dirección\n"
                + "  6.  Ciudad\n"
                + "  7.  Región\n"
                + "  8.  Código postal\n"
                + "  9.  País\n"
                + "  10. Teléfono\n"
                + "  11. Fax");
        System.out.print("Su opción: ");
        opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1:
                Utilidad.actualizarCliente("codigo");
                break;
            case 2:
                Utilidad.actualizarCliente("empresa");
                break;
            case 3:
                Utilidad.actualizarCliente("contacto");
                break;
            case 4:
                Utilidad.actualizarCliente("cargo_contacto");
                break;
            case 5:
                Utilidad.actualizarCliente("direccion");
                break;
            case 6:
                Utilidad.actualizarCliente("ciudad");
                break;
            case 7:
                Utilidad.actualizarCliente("region");
                break;
            case 8:
                Utilidad.actualizarCliente("cp");
                break;
            case 9:
                Utilidad.actualizarCliente("pais");
                break;
            case 10:
                Utilidad.actualizarCliente("telefono");
                break;
            case 11:
                Utilidad.actualizarCliente("fax");
                break;
            default:
                System.out.println("Debe elegir una opción válida.");
        }
    }
}
