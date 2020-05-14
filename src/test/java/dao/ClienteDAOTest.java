/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alvaro
 */
public class ClienteDAOTest {
    private static ClienteDAO clientes;
    
    public ClienteDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        clientes = new ClienteDAO();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConexion method, of class ClienteDAO.
     */
    @Test
    public void testGetConexion() {
        System.out.println("getConexion");
        Connection expResult = null;
        Connection result = clientes.getConexion();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of read method, of class ClienteDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        Integer idCliente = 7;
        Cliente expResult = new Cliente(
                7, 
                "BLONP", 
                "Blondel père et fils", 
                "Frédérique Citeaux", 
                "Gerente de marketing", 
                "24, place Kléber", 
                "Estrasburgo", 
                null, 
                "67000", 
                "Francia", 
                "88.60.15.31", 
                "88.60.15.32");
        Cliente result = clientes.read(idCliente);
//        assertEquals(expResult.getIdCliente(), result.getIdCliente());
//        assertEquals(expResult.getCodigoCliente(), result.getCodigoCliente());
//        assertEquals(expResult.getEmpresa(), result.getEmpresa());
//        assertEquals(expResult.getContacto(), result.getContacto());
//        assertEquals(expResult.getCargoContacto(), result.getCargoContacto());
//        assertEquals(expResult.getDireccion(), result.getDireccion());
//        assertEquals(expResult.getCiudad(), result.getCiudad());
//        assertEquals(expResult.getCodigoPostal(), result.getCodigoPostal());
//        assertEquals(expResult.getPais(), result.getPais());
//        assertEquals(expResult.getTelefono(), result.getTelefono());
//        assertEquals(expResult.getFax(), result.getFax());
        assertTrue(expResult.equals(result));
        
        idCliente = 100;
        expResult = null;
        result = clientes.read(idCliente);
        assertEquals(expResult, result);
        
        idCliente = -1;
        expResult = null;
        result = clientes.read(idCliente);
        assertEquals(expResult, result);
    }

    /**
     * Test of existe method, of class ClienteDAO.
     * El propósito del método existe() es simplemente comprobar si existe
     * un registro con el código o nombre que se pasa.
     */
    @Test
    public void testExiste() {
        System.out.println("existe");
        
        //Existe tanto el código como el nombre de la empresa
        String codigo = "BLONP";
        String empresa = "Blondel père et fils";
        Boolean expResult = true;
        Boolean result = clientes.existe(codigo, empresa);
        assertEquals(expResult, result);
        
        //Existe el nombre de la empresa
        codigo = "DSFSDF";
        empresa = "Blondel père et fils";
        expResult = true;
        result = clientes.existe(codigo, empresa);
        assertEquals(expResult, result);
        
        //Existe el nombre de la empresa
        codigo = null;
        empresa = "Blondel père et fils";
        expResult = false;
        result = clientes.existe(codigo, empresa);
        assertEquals(expResult, result);
        
        //Existe el código de la empresa
        codigo = "BLONP";
        empresa = "Empresa ficticia";
        expResult = true;
        result = clientes.existe(codigo, empresa);
        assertEquals(expResult, result);
        
        //Existe el código de la empresa
        codigo = "BLONP";
        empresa = null;
        expResult = false;
        result = clientes.existe(codigo, empresa);
        assertEquals(expResult, result);
        
        //Ninguno de los dos campos están registrados
        codigo = "DSFSDF";
        empresa = "Empresa ficticia";
        expResult = false;
        result = clientes.existe(codigo, empresa);
        assertEquals(expResult, result);
        
        //No existe
        codigo = null;
        empresa = null;
        expResult = false;
        result = clientes.existe(codigo, empresa);
        assertEquals(expResult, result);
    }

    /**
     * Test of listar method, of class ClienteDAO.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        Integer inicio = null;
        Integer limite = null;
        ClienteDAO instance = new ClienteDAO();
        ArrayList<Cliente> expResult = null;
        ArrayList<Cliente> result = instance.listar(inicio, limite);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ultimoID method, of class ClienteDAO.
     */
    @Test
    public void testUltimoID() {
        System.out.println("ultimoID");
        
        Integer expResult = null;
        Integer result = clientes.ultimoID();
        assertNotEquals(expResult, result);
        
        expResult = 95;
        result = clientes.ultimoID();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertar method, of class ClienteDAO.
     * En este caso no se probará con un registro existente ya que para ese
     * propósito está el método existe() y su prueba en testExiste
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        
        //Caso donde los atributos del cliente han sido insertados con espacios
        Cliente cliente = new Cliente(null," "," "," "," "," "," "," "," "," "," "," ");
        Boolean expResult = false;
        Boolean result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        //Caso donde los atributos del cliente son nulos
        cliente = new Cliente(null, null, null, null, null, null, null, null, null, null, null, null);
        expResult = false;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        //Caso donde los atributos del cliente están vacíos
        cliente = new Cliente();
        expResult = false;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        /*Caso donde los atributos del cliente están rellenados (salvo los 
          considerados como no obligatorios y uno obligatorio - código)*/
        cliente = new Cliente(null, 
                null, 
                "Tabacalera Fumadores", 
                "John Doe", 
                "Representante de ventas", 
                "c/ Caídos en el Invent", 
                "Madrid", 
                null, 
                "28013", 
                "España", 
                "(91) 3825483", 
                null);
        expResult = false;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        /*Caso donde los atributos del cliente están rellenados (salvo los 
          considerados como no obligatorios y uno obligatorio - nombre)*/
        cliente = new Cliente(null, 
                "PARFE", 
                null, 
                "John Doe", 
                "Representante de ventas", 
                "c/ Caídos en el Invent", 
                "Madrid", 
                null, 
                "28013", 
                "España", 
                "(91) 3825483", 
                null);
        expResult = false;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        /*Caso donde los atributos del cliente están rellenados (salvo los 
          considerados como no obligatorios y uno obligatorio - contacto)*/
        cliente = new Cliente(null, 
                "PARFE", 
                "Tabacalera Fumadores", 
                null, 
                "Representante de ventas", 
                "c/ Caídos en el Invent", 
                "Madrid", 
                null, 
                "28013", 
                "España", 
                "(91) 3825483", 
                null);
        expResult = false;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        /*Caso donde los atributos del cliente están rellenados (salvo los 
          considerados como no obligatorios y uno obligatorio - cargo del 
          contacto)*/
        cliente = new Cliente(null, 
                "PARFE", 
                "Tabacalera Fumadores", 
                "John Doe", 
                null, 
                "c/ Caídos en el Invent", 
                "Madrid", 
                null, 
                "28013", 
                "España", 
                "(91) 3825483", 
                null);
        expResult = false;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        /*Caso donde los atributos del cliente están rellenados (salvo los 
          considerados como no obligatorios y uno obligatorio - dirección)*/
        cliente = new Cliente(null, 
                "PARFE", 
                "Tabacalera Fumadores", 
                "John Doe", 
                "Representante de Ventas", 
                null, 
                "Madrid", 
                null, 
                "28013", 
                "España", 
                "(91) 3825483", 
                null);
        expResult = false;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        /*Caso donde los atributos del cliente están rellenados (salvo los 
          considerados como no obligatorios y uno obligatorio - ciudad)*/
        cliente = new Cliente(null, 
                "PARFE", 
                "Tabacalera Fumadores", 
                "John Doe", 
                "Representante de ventas", 
                "c/ Caídos en el Invent", 
                null, 
                null, 
                "28013", 
                "España", 
                "(91) 3825483", 
                null);
        expResult = false;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        /*Caso donde los atributos del cliente están rellenados (salvo los 
          considerados como no obligatorios y uno obligatorio - código postal)*/
        cliente = new Cliente(null, 
                "PARFE", 
                "Tabacalera Fumadores", 
                "John Doe", 
                "Representante de ventas", 
                "c/ Caídos en el Invent", 
                "Madrid", 
                null, 
                null, 
                "España", 
                "(91) 3825483", 
                null);
        expResult = false;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        
        /*Caso donde los atributos del cliente están rellenados (salvo los 
          considerados como no obligatorios y uno obligatorio - país)*/
        cliente = new Cliente(null, 
                "PARFE", 
                "Tabacalera Fumadores", 
                "John Doe", 
                "Representante de ventas", 
                "c/ Caídos en el Invent", 
                "Madrid", 
                null, 
                "28013", 
                null, 
                "(91) 3825483", 
                null);
        expResult = false;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        /*Caso donde los atributos del cliente están rellenados (salvo los 
          considerados como no obligatorios y uno obligatorio - teléfono)*/
        cliente = new Cliente(null, 
                "PARFE", 
                "Tabacalera Fumadores", 
                "John Doe", 
                "Representante de ventas", 
                "c/ Caídos en el Invent", 
                "Madrid", 
                null, 
                "28013", 
                "España", 
                null, 
                null);
        expResult = false;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
        
        /*Caso donde los atributos del cliente están rellenados (salvo los 
          considerados como no obligatorios (el 94 será ignorado por la query)*/
        cliente = new Cliente(94, 
                "PARFE", 
                "Tabacalera Fumadores", 
                "John Doe", 
                "Representante de ventas", 
                "c/ Caídos en el Invent", 
                "Madrid", 
                null, 
                "28013", 
                "España", 
                "(91) 3825483", 
                null);
        expResult = true;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class ClienteDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
        //Todos los campos que se envían son nulos
        Integer id = null;
        String campo = null;
        String valorCampo = null;
        Boolean expResult = false;
        Boolean result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        //El campo 'id' es nulo
        id = null;
        campo = "codigo";
        valorCampo = "ZOLOFT";
        expResult = false;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        //El campo 'campo' es nulo
        id = 96;
        campo = null;
        valorCampo = "ZOLOFT";
        expResult = false;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
                
        //El campo 'valorCampo' es nulo
        id = 96;
        campo = "codigo";
        valorCampo = null;
        expResult = false;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        //Todos los campos son rellenados
        id = 96;
        campo = "codigo";
        valorCampo = "ZOLOFT";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        id = 96;
        campo = "empresa";
        valorCampo = "Quebec";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        id = 96;
        campo = "contacto";
        valorCampo = "Ween";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        id = 96;
        campo = "cargo_contacto";
        valorCampo = "Representante";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        id = 96;
        campo = "direccion";
        valorCampo = "3145 N. Sheffield Ave.";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        id = 96;
        campo = "ciudad";
        valorCampo = "Chicago";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        id = 96;
        campo = "region";
        valorCampo = "IL";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        id = 96;
        campo = "cp";
        valorCampo = "60657";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        id = 96;
        campo = "pais";
        valorCampo = "Estados Unidos";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        id = 96;
        campo = "telefono";
        valorCampo = "(773) 472-0449";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        id = 96;
        campo = "fax";
        valorCampo = "(773) 472-0549";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class ClienteDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        
        Integer idCliente = null;
        Boolean expResult = false;
        Boolean result = clientes.delete(idCliente);
        assertEquals(expResult, result);
        
        idCliente = 96;
        expResult = true;
        result = clientes.delete(idCliente);
        assertEquals(expResult, result);
    }
    
}
