/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import dao.ClienteDAO;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

    /**
     * Si la conexión con la base de datos no se establece, el programa mostrará
     * un mensaje de error y se cerrará.
     */
    public static void conexion() {
        if (clientes.getConexion() == null) {
            System.err.println("Programa terminado. Error en la conexión.");
            System.exit(0);
        }
    }

    /**
     * Visualizar los 10 registros siguientes, tomándose de referencia el último
     * id para limitar el número de páginas.
     */
    public static void siguiente() {
        Integer maxPaginas = ((clientes.ultimoID()) / 10);
        if ((maxPaginas - 1) < (inicio / 10)) {
            inicio = maxPaginas * 10;
        } else {
            inicio += 10;
        }
        listado();
    }

    /**
     * Visualizar los 10 registros anteriores, si llega a 0 no podrá seguir
     * retrocediendo.
     */
    public static void anterior() {
        if (inicio <= 0) {
            inicio = 0;
        } else {
            inicio -= 10;
        }
        listado();
    }

    /**
     * Listado de los clientes. Algunos campos tienen un salto de línea, por lo
     * que con 'palabras[]' se pretende meter el contenido separado por ese
     * salto en un array con el que luego se juntan las cadenas.
     */
    public static void listado() {
        String palabras[];
        listaClientes = clientes.listar(inicio, limite);

        System.out.println("+----+-------+------------------------------+------------------------+------------------------------"
                + "+------------------------------+---------------+----------+---------------+---------------+");
        System.out.printf("|%-4s|%-7s|%-30s|%-24s|%-30s|%-30s|%-15s|%-10s|%-15s|%-15s|%n",
                "Id", "Código", "Empresa", "Contacto", "Cargo", "Dirección", "Ciudad", "C.Postal", "País", "Teléfono");
        System.out.println("+----+-------+------------------------------+------------------------+------------------------------"
                + "+------------------------------+---------------+----------+---------------+---------------+");

        for (Cliente c : listaClientes) {
            palabras = c.getDireccion().split("\\r?\\n");

            if (palabras.length > 1) {
                c.setDireccion(palabras[0] + " " + palabras[1]);
            } else {
                c.setDireccion(palabras[0]);
            }

            System.out.printf("|%-4d|%-7.7s|%-30.28s|%-24.23s|%-30.29s|%-30.28s|%-15.14s|%-10.9s|%-15.14s|%-15.14s|%n",
                    c.getIdCliente(), c.getCodigoCliente(), c.getEmpresa(),
                    c.getContacto(), c.getCargoContacto(), c.getDireccion(), c.getCiudad(),
                    c.getCodigoPostal(), c.getPais(), c.getTelefono());
        }
        System.out.println("+----+-------+------------------------------+------------------------+------------------------------"
                + "+------------------------------+---------------+----------+---------------+---------------+");
    }
    
     /**
     * Comprobar que el registro existe o no.
     *
     * @return
     */
    public static Cliente existeCliente() {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;

        System.out.print("\nIndique el ID del cliente que desea buscar: ");
        cliente = clientes.read(Integer.parseInt(sc.nextLine()));
        
        if(cliente != null){
            registroCompleto(cliente);
        } else {
            System.err.println("El cliente no existe o no se puede leer.");
        }
        
        return cliente;
    }
    
    /**
     * Ver el registro completo de un cliente.
     */
    public static void registroCompleto(Cliente cliente) {
        String palabras[];

        System.out.println("+----+-------+-------------------------------------+-------------------------+------------------------------"
                + "+------------------------------------------------+---------------+---------------+----------+---------------+---------------+"
                + "---------------+");
        System.out.printf("|%-4s|%-7s|%-37s|%-25s|%-30s|%-48s|%-15s|%-15s|%-10s|%-15s|%-15s|%-15s|%n",
                "Id", "Código", "Empresa", "Contacto", "Cargo", "Dirección", "Ciudad", "Región", "C.Postal", "País", "Teléfono", "Fax");
        System.out.println("+----+-------+-------------------------------------+-------------------------+------------------------------"
                + "+------------------------------------------------+---------------+---------------+----------+---------------+---------------+"
                + "---------------+");

        palabras = cliente.getDireccion().split("\\r?\\n");

        if (palabras.length > 1) {
            cliente.setDireccion(palabras[0] + " " + palabras[1]);
        } else {
            cliente.setDireccion(palabras[0]);
        }

        System.out.printf("|%-4d|%-7s|%-37s|%-25s|%-30s|%-48s|%-15s|%-15s|%-10s|%-15s|%-15s|%-15s|%n",
                cliente.getIdCliente(), cliente.getCodigoCliente(), cliente.getEmpresa(),
                cliente.getContacto(), cliente.getCargoContacto(), cliente.getDireccion(), cliente.getCiudad(), cliente.getRegion(),
                cliente.getCodigoPostal(), cliente.getPais(), cliente.getTelefono(), cliente.getFax());
        System.out.println("+----+-------+-------------------------------------+-------------------------+------------------------------"
                + "+------------------------------------------------+---------------+---------------+----------+---------------+---------------+"
                + "---------------+");
    }

    /**
     * Insertar un cliente nuevo.
     */
    public static void introducirCliente() {
        Scanner sc = new Scanner(System.in, "ISO-8859-1");
        Cliente cliente = new Cliente();

        System.out.println("\nINSERTAR");
        System.out.println("--------");
        System.out.println("Los campos indicados con asterisco (*) son OBLIGATORIOS.\n");

        System.out.print("Indique el código de la empresa [ej.VERDE]*: ");
        cliente.setCodigoCliente(sc.nextLine().toUpperCase());

        System.out.print("Indique el nombre de la empresa [ej. Verduras Deliciosas]*: ");
        cliente.setEmpresa(sc.nextLine());

        System.out.print("Indique el nombre del contacto [ej. Hank Scorpio]*: ");
        cliente.setContacto(sc.nextLine());

        System.out.print("Indique el cargo del contacto [ej. Representante de ventas]*: ");
        cliente.setCargoContacto(sc.nextLine());

        System.out.print("Indique la dirección de la empresa [ej. Paseo de Extemadura 11]*: ");
        cliente.setDireccion(sc.nextLine());

        System.out.print("Indique la ciudad en la que se encuentra la empresa [ej. Madrid]*: ");
        cliente.setCiudad(sc.nextLine());

        System.out.print("Indique la región en la que se encuentra la empresa [ej. M]: ");
        cliente.setRegion(sc.nextLine());

        System.out.print("Indique el código postal de la empresa [ej. 28034]*: ");
        cliente.setCodigoPostal(sc.nextLine());

        System.out.print("Indique el país de la empresa [ej. Alemania]*: ");
        cliente.setPais(sc.nextLine());

        System.out.print("Indique el teléfono de la empresa [ej. 913722473]*: ");
        cliente.setTelefono(sc.nextLine());

        System.out.print("Indique el fax de la empresa: ");
        cliente.setFax(sc.nextLine());

        /*Aquellos campos obligatorios que no se han introducido pasarán a ser
        nulo*/
        cliente.setNull();
        
        //salto de línea con propósito estético
        System.out.println("");
        
        if (!clientes.existe(cliente.getCodigoCliente(), cliente.getEmpresa())) {
            if (clientes.insertar(cliente)) {
                System.out.println("El cliente '" + cliente.getEmpresa() + "' ha sido añadido satisfactoriamente.");
                registroCompleto(cliente);
            } else {
                System.err.println("El cliente que intenta introducir no es válido.");
            }
        } else {
            System.err.println("El cliente que intenta registrar existe ya.");
        }
    }

    /**
     * Actualizar un cliente donde se ha de escoger el campo que se desea
     * modificar.
     *
     * @param campo
     */
    public static void actualizarCliente(String campo) {
        Scanner sc = new Scanner(System.in);
        String valorCampo;
        String resp;
        Cliente cliente = existeCliente();

        if (cliente != null) {
            System.out.print("Indique el nuevo valor del campo: ");
            valorCampo = sc.nextLine();

            System.out.println("\n¿Está seguro que desea actualizar al siguiente cliente?"
                    + "\n");
            System.out.print("Su respuesta [Y/N]: ");
            resp = sc.nextLine();

            if (resp.equalsIgnoreCase("y")) {
                if (clientes.update(cliente.getIdCliente(), campo, valorCampo)) {
                    System.out.println("\n\tRegistro modificado.");
                } else {
                    throw new InputMismatchException();
                }
            } else {
                System.out.println("\n\tRegistro no modificado.");
            }
        }
    }

    /**
     * Borrar el registro de un cliente a través de su id.
     */
    public static void borrarCliente() {
        System.out.println("\nBORRAR");
        System.out.println("------");

        Scanner sc = new Scanner(System.in);
        Cliente cliente = existeCliente();
        String resp;

        if (cliente != null) {
            System.out.println("¿Está seguro que desea eliminar al siguiente cliente?");
            System.out.print("Su respuesta [Y/N]: ");
            resp = sc.nextLine();

            if (resp.equalsIgnoreCase("y")) {
                if (clientes.delete(cliente.getIdCliente())) {
                    System.out.println("\n\tEntrada eliminada.");
                } else {
                    throw new InputMismatchException();
                }
            } else {
                System.out.println("\n\tEntrada no eliminada.");
            }
        }
    }
}
