/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import dao.ClienteDAO;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Utilidad {

    private static ArrayList<Cliente> listaClientes = null;
    private static ClienteDAO clientes = new ClienteDAO();
    private static Integer inicio = 0;
    private static Integer limite = 10;

    public static void conexion() {
        if (clientes.getConexion() == null) {
            System.err.println("Programa terminado. Error en la conexión.");
            System.exit(0);
        }
    }

    public static void siguiente() {
        Integer maxPaginas = ((clientes.ultimoID()) / 10);
        if ((maxPaginas - 1) < (inicio / 10)) {
            inicio = maxPaginas * 10;
        } else {
            inicio += 10;
        }
        listado();
    }

    public static void anterior() {
        if (inicio <= 0) {
            inicio = 0;
        } else {
            inicio -= 10;
        }
        listado();
    }

    public static void listado() {
        System.out.println("\nLISTADO");
        System.out.println("--------");
        System.out.println("+-----+-------+-------------------------------------+-------------------------+------------------------------"
                + "+------------------------------------------------+---------------+---------------+----------+---------------+---------------+"
                + "---------------+");
        System.out.printf("|%-5s|%-7s|%-37s|%-25s|%-30s|%-48s|%-15s|%-15s|%-10s|%-15s|%-15s|%-15s|%n",
                "Id", "Código", "Empresa", "Contacto", "Cargo", "Dirección", "Ciudad", "Región", "C.Postal", "País", "Teléfono", "Fax");
//        listaClientes = clientes.listar(orden, 0, 10);
        listaClientes = clientes.listar(inicio, limite);

        for (Cliente c : listaClientes) {
            System.out.printf("|%5d|%7s|%37s|%25s|%30s|%48s|%15s|%15s|%10s|%15s|%15s|%15s|%n",
                    c.getIdCliente(), c.getCodigoCliente(), c.getEmpresa(),
                    c.getContacto(), c.getCargoContacto(), c.getDireccion(), c.getCiudad(), c.getRegion(),
                    c.getCodigoPostal(), c.getPais(), c.getTelefono(), c.getFax());
        }
        System.out.println("+-----+-------+-------------------------------------+-------------------------+------------------------------"
                + "+------------------------------------------------+---------------+---------------+----------+---------------+---------------+"
                + "---------------+");
    }

    /**
     * Insertar un cliente nuevo
     */
    public static void introducirCliente() {
        System.out.println("\nINSERTAR");
        System.out.println("--------");

        Scanner sc = new Scanner(System.in, "ISO-8859-1");
        Cliente cliente = new Cliente();

        System.out.print("Indique el código de la empresa [ej.ALFKI]: ");
        cliente.setCodigoCliente(sc.nextLine());

        System.out.print("Indique el nombre de la empresa [ej. Alfreds Futterkiste]: ");
        cliente.setEmpresa(sc.nextLine());

        System.out.print("Indique el nombre del contacto [ej. Maria Anders]: ");
        cliente.setContacto(sc.nextLine());

        System.out.print("Indique el cargo del contacto [ej. Representante de ventas]: ");
        cliente.setCargoContacto(sc.nextLine());

        System.out.print("Indique la dirección de la empresa [ej. Obere Str. 57]: ");
        cliente.setDireccion(sc.nextLine());

        System.out.print("Indique la ciudad en la que se encuentra la empresa [ej. Berlin]: ");
        cliente.setCiudad(sc.nextLine());

        System.out.print("Indique la región en la que se encuentra la empresa [ej. B]: ");
        cliente.setRegion(sc.nextLine());

        System.out.print("Indique el código postal de la empresa [ej. 12209]: ");
        cliente.setCodigoPostal(sc.nextLine());

        System.out.print("Indique el país de la empresa [ej. Alemania]: ");
        cliente.setPais(sc.nextLine());

        System.out.print("Indique el teléfono de la empresa [indique el prefijo entre paréntesis]: ");
        cliente.setTelefono(sc.nextLine());

        System.out.print("Indique el fax de la empresa [indique el prefijo entre paréntesis]: ");
        cliente.setFax(sc.nextLine());

        if (clientes.insertar(cliente)) {
            System.out.println("\nEl cliente '" + cliente.getEmpresa() + "' ha sido añadido satisfactoriamente.");
        } else {
            System.err.println("\nEl empleado que intenta introducir no es válido.");
        }
    }

    /**
     * Actualizar un cliente donde se ha de escoger el campo que se desea
     * modificar
     *
     * @param campo
     */
    public static void actualizarCliente(String campo) {
        Scanner sc = new Scanner(System.in);
        String valorCampo;
        String resp;
        Cliente cliente = existeCliente();

        if (cliente != null) {

            System.out.println("\n¿Está seguro que desea eliminar al siguiente usuario?"
                    + "\n\n\t" + cliente + "\n");
            System.out.print("Su respuesta [Y/N]: ");
            resp = sc.nextLine();

            if (resp.equalsIgnoreCase("y")) {
                System.out.print("Indique el nuevo valor del campo: ");
                valorCampo = sc.nextLine();
                                
                if (clientes.update(cliente.getIdCliente(), campo, valorCampo)) {
                    System.out.println("Registro modificado.");
                } else {
                    System.out.println("\n\tRegistro no modificado.");
                }
            }
        } else {
            System.err.println("El empleado no existe o no se puede leer.");
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
                    + "\n\n\t" + cliente + "\n");
            System.out.print("Su respuesta [Y/N]: ");
            resp = sc.nextLine();

            if (resp.equalsIgnoreCase("y")) {
                clientes.delete(cliente.getIdCliente());
                System.out.println("\n\tEntrada eliminada.");
            } else {
                System.out.println("\n\tEntrada no eliminada.");
            }
        } else {
            System.err.println("El empleado no existe o no se puede leer.");
        }
    }

    public static Cliente existeCliente() {
        Scanner sc = new Scanner(System.in);
        Cliente cliente;

        System.out.print("\nIndique el ID del empleado que desea buscar: ");
        cliente = clientes.read(Integer.parseInt(sc.nextLine()));

        return cliente;
    }
}
