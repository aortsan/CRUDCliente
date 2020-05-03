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
    
    public ClienteDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
        ClienteDAO instance = new ClienteDAO();
        Connection expResult = null;
        Connection result = instance.getConexion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class ClienteDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        Integer idCliente = null;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        Cliente result = instance.read(idCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class ClienteDAO.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        String orden = "";
        Integer inicio = null;
        Integer limite = null;
        ClienteDAO instance = new ClienteDAO();
        ArrayList<Cliente> expResult = null;
        ArrayList<Cliente> result = instance.listar(orden, inicio, limite);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertar method, of class ClienteDAO.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Cliente cliente = null;
        ClienteDAO instance = new ClienteDAO();
        Boolean expResult = null;
        Boolean result = instance.insertar(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ClienteDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Integer id = null;
        String campo = "";
        String valorCampo = "";
        ClienteDAO instance = new ClienteDAO();
        Boolean expResult = null;
        Boolean result = instance.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ClienteDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Integer idCliente = null;
        ClienteDAO instance = new ClienteDAO();
        Boolean expResult = null;
        Boolean result = instance.delete(idCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
