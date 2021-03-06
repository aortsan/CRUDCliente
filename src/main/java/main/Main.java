/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.InputMismatchException;
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

        System.out.println("\n\t\tBIENVENIDO");
        System.out.println("\t\t-----------");

        Utilidad.listado();

        while (true) {
            try {
                System.out.println("\nELIJA ALGUNA DE LAS OPCIONES QUE SE MUESTRAN A CONTINUACIÓN\n");
                System.out.println("  1. Visualizar los diez siguientes.");
                System.out.println("  2. Visualizar los diez anteriores.");
                System.out.println("  3. Visualizar un registro al completo.");
                System.out.println("  4. Introducir nuevo registro.");
                System.out.println("  5. Actualizar dato de cliente por IdCliente.");
                System.out.println("  6. Borrar dato por IdCliente.\n");
                System.out.print("Su elección [introduzca 0 para salir]: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 0:
                        System.out.printf("\n%-10s %-10s","","Hasta pronto.");
                        System.out.printf("\n%-10s %-10s","","-------------");
                        System.out.printf("\n%-15s %-10s","","FIN");
                        System.exit(0);
                        break;
                    case 1:
                        Utilidad.siguiente();
                        break;
                    case 2:
                        Utilidad.anterior();
                        break;
                    case 3:
                        Utilidad.existeCliente();
                        break;
                    case 4:
                        Utilidad.introducirCliente();
                        break;
                    case 5:
                        menuActualizar();
                        break;
                    case 6:
                        Utilidad.borrarCliente();
                        break;
                    default:
                        System.out.println("Debe elegir una opción válida.");
                }
            } catch (InputMismatchException | NumberFormatException nfe) {
                System.err.println("\n\tError: Entrada no válida. " + nfe.getMessage() + "\n");
            }
        }
    }

    public static void menuActualizar() {
        Scanner sc = new Scanner(System.in);
        Integer opcion;
        
        while (true) {
            try {
                System.out.println("\nACTUALIZAR");
                System.out.println("----------");

                System.out.println(" Indique el campo que desea modificar:");
                System.out.println("   1.  Código del cliente\n"
                        + "   2.  Empresa\n"
                        + "   3.  Contacto\n"
                        + "   4.  Cargo del contacto\n"
                        + "   5.  Dirección\n"
                        + "   6.  Ciudad\n"
                        + "   7.  Región\n"
                        + "   8.  Código postal\n"
                        + "   9.  País\n"
                        + "   10. Teléfono\n"
                        + "   11. Fax");
                System.out.print(" Su opción [0 para retroceder]: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 0:
                        return;
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
            } catch (InputMismatchException | NumberFormatException nfe) {
                System.err.println("\n\tError: Entrada no válida. " + nfe.getMessage() + "\n");
            }
        }
    }
}
