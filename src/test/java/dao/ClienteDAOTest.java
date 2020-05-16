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
import static org.junit.Assert.assertArrayEquals;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Alvaro
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void test1GetConexion() {
        System.out.println("getConexion");
        Connection expResult = null;
        Connection result = clientes.getConexion();
        assertNotEquals(expResult, result);
    }
    
    /**
     * Test of size method, of class ClienteDAO.
     */
    @Test
    public void test2Size() {
        System.out.println("ultimoID");

        Integer expResult = null;
        Integer result = clientes.size();
        assertNotEquals(expResult, result);

        expResult = 92;
        result = clientes.size();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of listar method, of class ClienteDAO.
     */
    @Test
    public void test3Listar() {
        System.out.println("listar");
        Integer inicio = 0;
        Integer limite = 10;
        ArrayList<Cliente> expResult = new ArrayList<>();
        expResult.add(new Cliente(1, "ALFKI", "Alfreds Futterkiste", "Maria Anders", "Representante de ventas", "Obere Str. 57", "Berlín", null, "12209", "Alemania", "030-0074321", "030-0076545"));
        expResult.add(new Cliente(2, "ANATR", "Ana Trujillo Emparedados y helados", "Ana Trujillo", "Propietario", "Avda. de la Constitución 2222", "México D.F.", null, "05021", "México", "(5) 555-4729", "(5) 555-3745"));
        expResult.add(new Cliente(3, "ANTON", "Antonio Moreno Taquería", "Antonio Moreno", "Propietario", "Mataderos  2312", "México D.F.", null, "05023", "México", "(5) 555-3932", null));
        expResult.add(new Cliente(4, "AROUT", "Around the Horn", "Thomas Hardy", "Representante de ventas", "120 Hanover Sq.", "Londres", null, "WA1 1DP", "Reino Unido", "(71) 555-7788", "(71) 555-6750"));
        expResult.add(new Cliente(5, "BERGS", "Berglunds snabbköp", "Christina Berglund", "Administrador de pedidos", "Berguvsvägen  8", "Luleå", null, "S-958 22", "Suecia", "0921-12 34 65", "0921-12 34 67"));
        expResult.add(new Cliente(6, "BLAUS", "Blauer See Delikatessen", "Hanna Moos", "Representante de ventas", "Forsterstr. 57", "Mannheim", null, "68306", "Alemania", "0621-08460", "0621-08924"));
        expResult.add(new Cliente(7, "BLONP", "Blondel père et fils", "Frédérique Citeaux", "Gerente de marketing", "24, place Kléber", "Estrasburgo", null, "67000", "Francia", "88.60.15.31", "88.60.15.32"));
        expResult.add(new Cliente(8, "BOLID", "Bólido Comidas preparadas", "Martín Sommer", "Propietario", "C/ Araquil, 67", "Madrid", null, "28023", "España", "(91) 555 22 82", "(91) 555 91 99"));
        expResult.add(new Cliente(9, "BONAP", "Bon app'", "Laurence Lebihan", "Propietario", "12, rue des Bouchers", "Marsella", null, "13008", "Francia", "91.24.45.40", "91.24.45.41"));
        expResult.add(new Cliente(10, "BOTTM", "Bottom-Dollar Markets", "Elizabeth Lincoln", "Gerente de contabilidad", "23 Tsawassen Blvd.", "Tsawassen", "BC", "T2F 8M4", "Canadá", "(604) 555-4729", "(604) 555-3745"));
        ArrayList<Cliente> result = clientes.listar(inicio, limite);
        assertArrayEquals(expResult.toArray(),result.toArray());
        
        inicio = 90;
        limite = 10;
        expResult = new ArrayList<>();
        expResult.add(new Cliente(91, "WOLZA", "Wolski  Zajazd", "Zbyszek Piestrzeniewicz", "Propietario", "ul. Filtrowa 68", "Warszawa", null, "01-012", "Polonia", "(26) 642-7012", "(26) 642-7012"));
        expResult.add(new Cliente(100, "PARFE", "Tabacalera Fumadores", "John Doe", "Representante de ventas", "c/ Caídos en el Invent", "Madrid", null, "28013", "España", "913825483", null));
        result = clientes.listar(inicio, limite);
        assertArrayEquals(expResult.toArray(),result.toArray());
        
        inicio = 100;
        limite = null;    
        expResult = null;
        result = clientes.listar(inicio, limite);
        assertEquals(expResult,result);
        
        inicio = null;
        limite = null;    
        expResult = null;
        result = clientes.listar(inicio, limite);
        assertEquals(expResult,result);
        
        inicio = null;
        limite = 10;    
        expResult = null;
        result = clientes.listar(inicio, limite);
        assertEquals(expResult,result);
        
        inicio = -1;
        limite = -1;    
        expResult = new ArrayList();
        result = clientes.listar(inicio, limite);
        assertEquals(expResult,result);
        
        inicio = 200;
        limite = 10;    
        expResult = new ArrayList();
        result = clientes.listar(inicio, limite);
        assertEquals(expResult,result);
    }
    
    /**
     * Test of read method, of class ClienteDAO.
     */
    @Test
    public void testRead_Integer() {
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

        idCliente = 200;
        expResult = null;
        result = clientes.read(idCliente);
        assertEquals(expResult, result);

        idCliente = -1;
        expResult = null;
        result = clientes.read(idCliente);
        assertEquals(expResult, result);
    }
    
           /**
     * Test of read method, of class ClienteDAO.
     */
    @Test
    public void testRead_Cliente() {
        System.out.println("read");
        
        //El cliente existe en la b.d.
        Cliente cliente = new Cliente(
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
        Cliente expResult = cliente;
        Cliente result = clientes.read(cliente);
        assertTrue(expResult.equals(result));
        
        //Cliente vacío
        cliente = new Cliente();
        expResult = null;
        result = clientes.read(cliente);
        assertEquals(expResult, result);
        
        //Cliente con valores nulos
        cliente = new Cliente(null, null, null, null, null, null, null, null, null, null, null, null);
        expResult = null;
        result = clientes.read(cliente);
        assertEquals(expResult, result);
        
        //Cliente con valores vacíos
        cliente = new Cliente(null, " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ");
        expResult = null;
        result = clientes.read(cliente);
        assertEquals(expResult, result);
        
        //El cliente no está registrado en la b.d.
        cliente = new Cliente(
                7,
                "BLOFS",
                "Blel père et fils",
                "Frédérique Citeaux",
                "Gerente de marketing",
                "24, place Kléber",
                "Estrasburgo",
                null,
                "67000",
                "Francia",
                "88.60.15.31",
                "88.60.15.32");
        expResult = null;
        result = clientes.read(cliente);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of insertar method, of class ClienteDAO. En este caso no se probará
     * con un registro existente ya que para ese propósito está el método
     * existe() y su prueba en testExiste
     */
    @Test
    public void test4Insertar() {
        System.out.println("insertar");

        //Caso donde los atributos del cliente han sido insertados con espacios
        Cliente cliente = new Cliente(null, " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ");
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
        
        /*Caso Caso donde los atributos del cliente están rellenados (salvo los 
          considerados como no obligatorios (el 94 será ignorado por la query)*/
        cliente = new Cliente(94,
                "ROLON",
                "Ropero Luongo",
                "Pepito Pérez",
                "Representante de ventas",
                "c/ Avenida de los Invents",
                "Madrid",
                null,
                "28023",
                "España",
                "913825433",
                null);
        expResult = true;
        result = clientes.insertar(cliente);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class ClienteDAO.
     */
    @Test
    public void test6Update() {
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
        id = 113;
        campo = null;
        valorCampo = "ZOLOFT";
        expResult = false;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);

        //El campo 'valorCampo' es nulo
        id = 113;
        campo = "codigo";
        valorCampo = null;
        expResult = false;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);

        //Se excede el número de caracteres admnitidos
        id = 113;
        campo = "codigo";
        valorCampo = "ZOLOFT";
        expResult = false;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);
        
        //Todos los campos son rellenados
        id = 113;
        campo = "empresa";
        valorCampo = "Quebec";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);

        id = 113;
        campo = "contacto";
        valorCampo = "Ween";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);

        id = 113;
        campo = "cargo_contacto";
        valorCampo = "Representante";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);

        id = 113;
        campo = "direccion";
        valorCampo = "3145 N. Sheffield Ave.";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);

        id = 113;
        campo = "ciudad";
        valorCampo = "Chicago";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);

        id = 113;
        campo = "region";
        valorCampo = "IL";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);

        id = 113;
        campo = "cp";
        valorCampo = "60657";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);

        id = 113;
        campo = "pais";
        valorCampo = "Estados Unidos";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);

        id = 113;
        campo = "telefono";
        valorCampo = "(773) 472-0449";
        expResult = true;
        result = clientes.update(id, campo, valorCampo);
        assertEquals(expResult, result);

        id = 113;
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
    public void test6Delete() {
        System.out.println("delete");

        Integer idCliente = null;
        Boolean expResult = false;
        Boolean result = clientes.delete(idCliente);
        assertEquals(expResult, result);

        idCliente = -1;
        expResult = false;
        result = clientes.delete(idCliente);
        assertEquals(expResult, result);

        idCliente = 300000;
        expResult = false;
        result = clientes.delete(idCliente);
        assertEquals(expResult, result);

        idCliente = 113;
        expResult = true;
        result = clientes.delete(idCliente);
        assertEquals(expResult, result);
    }
}