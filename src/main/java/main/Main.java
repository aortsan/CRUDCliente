/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.ClienteDAO;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Cliente> listaClientes = null;
    static ClienteDAO clientes = new ClienteDAO();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer opcion;
        Integer inicio = 0;
        Integer limite = 10;

        if (clientes.getConexion() == null) {
            System.err.println("Programa terminado. Error en la conexión.");
            System.exit(0);
        }

        System.out.println("\t\tBIENVENIDO");
        System.out.println("\t\t-----------");
        while (true) {
            try {
                System.out.println("ELIJA ALGUNA DE LAS OPCIONES QUE SE MUESTRAN A CONTINUACIÓN\n");
                System.out.println("  1. Visualizar los diez siguientes.");
                System.out.println("  2. Visualizar los diez siguientes.");
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
                        listarClientes();
                        break;
                    case 2:
                        listarClientes();
                        break;
                    case 3:
                        System.out.println("\nINSERTAR");
                        System.out.println("--------");
                        break;
                    case 4:
                        System.out.println("\nACTUALIZAR");
                        System.out.println("----------");
                        break;
                    case 5:
                        System.out.println("\nBORRAR");
                        System.out.println("------");
                }
                System.out.println();
            } catch (NumberFormatException nfe) {
                System.err.println("\nError: Entrada no válida. " + nfe.getMessage() + "\n");
            }
        }
    }

    public static void listarClientes() {
        Scanner sc = new Scanner(System.in);
        Integer opcion;

        System.out.println("\nIndique según que orden quiere listar: \n");
        System.out.println("  1.  Id del cliente\n"
                + "  2.  Código del cliente\n"
                + "  3.  Empresa\n"
                + "  4.  Contacto\n"
                + "  5.  Cargo del contacto\n"
                + "  6.  Dirección\n"
                + "  7.  Ciudad\n"
                + "  8.  Región\n"
                + "  9.  Código postal\n"
                + "  10. País\n"
                + "  11. Teléfono\n"
                + "  12. Fax");
        System.out.print("\nSu opción: ");
        opcion = Integer.parseInt(sc.nextLine());
        System.out.println();
        switch (opcion) {
            case 1:
                listado("id",0,10);
                break;
            case 2:
                listado("codigo",0,10);
                break;
            case 3:
                listado("empresa",0,10);
                break;
            case 4:
                listado("contacto",0,10);
                break;
            case 5:
                listado("cargo_contacto",0,10);
                break;
            case 6:
                listado("direccion",0,10);
                break;
            case 7:
                listado("ciudad",0,10);
                break;
            case 8:
                listado("region",0,10);
                break;
            case 9:
                listado("cp",0,10);
                break;
            case 10:
                listado("pais",0,10);
                break;
            case 11:
                listado("telefono",0,10);
                break;
            case 12:
                listado("fax",0,10);
                break;
        }
    }

    public static void listado(String orden, Integer inicio, Integer limite) {
        System.out.println("\nLISTADO");
        System.out.println("--------");
        System.out.printf("|%-10s| %-40s| %-20s| %-30s|%n","Id","Empresa","Contacto","Cargo");
        listaClientes = clientes.listar(orden, inicio, limite);
        for (Cliente c : listaClientes) {
            System.out.printf("|%-10d| %-40s| %-20s| %-30s|%n",c.getIdCliente(),c.getEmpresa(),c.getContacto(),c.getCargoContacto());
        }
    }
    
    public static void actualizar() {
        Scanner sc = new Scanner(System.in);
        Integer opcion;

        System.out.println("\nIndique el campo que desea modificar: \n");
        System.out.println("  1.  Id del cliente\n"
                + "  2.  Código del cliente\n"
                + "  3.  Empresa\n"
                + "  4.  Contacto\n"
                + "  5.  Cargo del contacto\n"
                + "  6.  Dirección\n"
                + "  7.  Ciudad\n"
                + "  8.  Región\n"
                + "  9.  Código postal\n"
                + "  10. País\n"
                + "  11. Teléfono\n"
                + "  12. Fax");
        System.out.print("\nSu opción: ");
        opcion = Integer.parseInt(sc.nextLine());
        System.out.println();
        switch (opcion) {
            case 1:
                listado("id",0,10);
                break;
            case 2:
                listado("codigo",0,10);
                break;
            case 3:
                listado("empresa",0,10);
                break;
            case 4:
                listado("contacto",0,10);
                break;
            case 5:
                listado("cargo_contacto",0,10);
                break;
            case 6:
                listado("direccion",0,10);
                break;
            case 7:
                listado("ciudad",0,10);
                break;
            case 8:
                listado("region",0,10);
                break;
            case 9:
                listado("cp",0,10);
                break;
            case 10:
                listado("pais",0,10);
                break;
            case 11:
                listado("telefono",0,10);
                break;
            case 12:
                listado("fax",0,10);
                break;
        }
    }

}
