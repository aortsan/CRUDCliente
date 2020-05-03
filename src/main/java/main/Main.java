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
                        introducirCliente();
                        break;
                    case 4:
                        menuActualizar();
                        break;
                    case 5:
                        borrarCliente();
                        break;
                    default:
                        System.out.println("Debe elegir una opción válida.");
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
                listado("id");
                break;
            case 2:
                listado("codigo");
                break;
            case 3:
                listado("empresa");
                break;
            case 4:
                listado("contacto");
                break;
            case 5:
                listado("cargo_contacto");
                break;
            case 6:
                listado("direccion");
                break;
            case 7:
                listado("ciudad");
                break;
            case 8:
                listado("region");
                break;
            case 9:
                listado("cp");
                break;
            case 10:
                listado("pais");
                break;
            case 11:
                listado("telefono");
                break;
            case 12:
                listado("fax");
                break;
            default:
                System.out.println("Debe elegir una opción válida.");
        }
    }

    public static void listado(String orden) {
        System.out.println("\nLISTADO");
        System.out.println("--------");
        System.out.println("+----------+----------------------------------------+--------------------+------------------------------+");
        System.out.printf("|%-10s|%-40s|%-20s|%-30s|%n", "Id", "Empresa", "Contacto", "Cargo");
        listaClientes = clientes.listar(orden, 0, 10);
        for (Cliente c : listaClientes) {
            System.out.printf("|%10d|%40s|%20s|%30s|%n", c.getIdCliente(), c.getEmpresa(), c.getContacto(), c.getCargoContacto());
        }
        System.out.println("+----------+----------------------------------------+--------------------+------------------------------+");
    }

    public static void menuActualizar() {
        System.out.println("\nACTUALIZAR");
        System.out.println("----------");

        Scanner sc = new Scanner(System.in);
        Integer opcion;

        System.out.println("\nIndique el campo que desea modificar: \n");
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
        System.out.print("\nSu opción: ");
        opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1:
                actualizarCliente("codigo");
                break;
            case 2:
                actualizarCliente("empresa");
                break;
            case 3:
                actualizarCliente("contacto");
                break;
            case 4:
                actualizarCliente("cargo_contacto");
                break;
            case 5:
                actualizarCliente("direccion");
                break;
            case 6:
                actualizarCliente("ciudad");
                break;
            case 7:
                actualizarCliente("region");
                break;
            case 8:
                actualizarCliente("cp");
                break;
            case 9:
                actualizarCliente("pais");
                break;
            case 10:
                actualizarCliente("telefono");
                break;
            case 11:
                actualizarCliente("fax");
                break;
            default:
                System.out.println("Debe elegir una opción válida.");
        }
    }

    public static void actualizarCliente(String campo) {
        Scanner sc = new Scanner(System.in);
        String valorCampo;
        Cliente cliente = existeCliente();

        if (cliente != null) {
            System.out.print("Indique el nuevo valor del campo: ");
            valorCampo = sc.nextLine();

            clientes.update(cliente.getIdCliente(), campo, valorCampo);
        } else {
            System.err.println("El empleado no existe o no se puede leer.");
        }
    }

    /**
     * Insertar un cliente nuevo
     */
    public static void introducirCliente() {
        System.out.println("\nINSERTAR");
        System.out.println("--------");

        Scanner sc = new Scanner(System.in, "ISO-8859-1");
        Cliente cliente = new Cliente();

        System.out.print("Indique el nombre de la empresa: ");
        cliente.setEmpresa(sc.nextLine());

        System.out.print("Indique el nombre del contacto: ");
        cliente.setContacto(sc.nextLine());

        System.out.print("Indique el cargo del contacto: ");
        cliente.setCargoContacto(sc.nextLine());

        System.out.print("Indique la dirección de la empresa: ");
        cliente.setDireccion(sc.nextLine());

        System.out.print("Indique la ciudad en la que se encuentra la empresa: ");
        cliente.setCiudad(sc.nextLine());

        System.out.print("Indique la región en la que se encuentra la empresa: ");
        cliente.setRegion(sc.nextLine());

        System.out.print("Indique el código postal de la empresa: ");
        cliente.setCodigoPostal(sc.nextLine());

        System.out.print("Indique el país de la empresa: ");
        cliente.setPais(sc.nextLine());

        System.out.print("Indique el teléfono de la empresa: ");
        cliente.setTelefono(sc.nextLine());

        System.out.print("Indique el fax de la empresa: ");
        cliente.setFax(sc.nextLine());

        if (clientes.insertar(cliente)) {
            System.out.println("El cliente '" + cliente.getEmpresa() + "' ha sido añadido satisfactoriamente.");
        } else {
            System.err.println("El empleado que intenta introducir no es válido.\n");
        }
    }

    /**
     * Borrar el registro de un cliente a través de su id
     */
    public static void borrarCliente() {
        System.out.println("\nBORRAR");
        System.out.println("------");

        Scanner sc = new Scanner(System.in);
        Cliente cliente = existeCliente();
        String resp;

        if (cliente != null) {
            System.out.println("\n¿Está seguro que desea eliminar al siguiente usuario?"
                    + "\n  " + cliente);
            System.out.print("Su respuesta [Y/N]: ");
            resp = sc.nextLine();

            if (resp.equalsIgnoreCase("y")) {
                clientes.delete(cliente.getIdCliente());
                System.out.println("Entrada eliminada.");
            } else {
                System.out.println("Entrada no eliminada.");
            }
        } else {
            System.err.println("El empleado no existe o no se puede leer.");
        }
    }

    public static Cliente existeCliente() {
        Scanner sc = new Scanner(System.in);
        Cliente cliente;

        System.out.print("Indique el ID del empleado que desea buscar: ");
        cliente = clientes.read(Integer.parseInt(sc.nextLine()));

        return cliente;
    }
}
