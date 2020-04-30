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
        Scanner sc = new Scanner(System.in, "ISO-8859-1");
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
                        listarClientes(inicio,limite);
                        break;
                    case 2:
                        listarClientes(inicio,limite);
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
                System.err.println("\nError: Entrada no válida." + nfe.getMessage() + "\n");
            }
        }
    }

    public static void listarClientes(Integer inicio, Integer limite) {
        System.out.println("\nLISTADO");
        System.out.println("--------");
        listaClientes = clientes.listar("codigo", inicio, limite);
        for (Cliente c : listaClientes) {
            System.out.println(c);
        }
    }

}
