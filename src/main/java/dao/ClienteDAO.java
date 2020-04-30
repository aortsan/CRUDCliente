/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alvaro
 */
public class ClienteDAO {

    private Connection conexion = null;

    /**
     * Establecer conexión con la base de datos
     */
    public ClienteDAO() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/neptuno", "root", "");
        } catch (SQLException ex) {
            System.err.println("Error al conectar: " + ex.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    /**
     * Listar la base de datos mediante los siguientes parámetros:
     *
     * @param orden
     * @param inicio
     * @param limite
     * @return
     */
    public ArrayList<Cliente> listar(String orden, Integer inicio, Integer limite) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        PreparedStatement stm = null;

        if (this.conexion == null || orden == null || inicio == null || limite == null) {
            return listaClientes;
        }

        try {
            String query = "SELECT * FROM clientes ORDER BY " + orden + " LIMIT ? OFFSET ?";

            stm = conexion.prepareStatement(query);
            stm.setInt(1, limite);
            stm.setInt(2, inicio);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("empresa"),
                        rs.getString("contacto"),
                        rs.getString("cargo_contacto"),
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("region"),
                        rs.getString("cp"),
                        rs.getString("pais"),
                        rs.getString("telefono"),
                        rs.getString("fax")
                );
                listaClientes.add(cliente);
            }

        } catch (SQLException ex) {
            System.err.println("Error al listar: " + ex.getMessage() + " " + stm.toString());
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        return listaClientes;
    }

    /**
     * Insertar un cliente
     *
     * @param cliente
     * @return
     */
    public Boolean insertar(Cliente cliente) {
        Boolean resultado = false;
        PreparedStatement stm = null;

        if (this.conexion == null) {
            return resultado;
        }

        try {
            String query = "INSERT INTO clientes "
                    + "(id, codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) "
                    + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stm = conexion.prepareStatement(query);
            stm.setString(1, cliente.getCodigoCliente());
            stm.setString(2, cliente.getEmpresa());
            stm.setString(3, cliente.getContacto());
            stm.setString(4, cliente.getCargoContacto());
            stm.setString(5, cliente.getDireccion());
            stm.setString(6, cliente.getCiudad());
            stm.setString(7, cliente.getRegion());
            stm.setString(8, cliente.getCodigoPostal());
            stm.setString(9, cliente.getPais());
            stm.setString(10, cliente.getTelefono());
            stm.setString(11, cliente.getTelefono());

            if (stm.executeUpdate() > 0) {
                resultado = true;

            }

        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex.getMessage());
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage() + " " + stm.toString());
            }
        }

        return resultado;
    }

    /**
     * Actualización del cliente a través de un campo que se le pedirá al
     * usuario
     *
     * @param id
     * @param campo
     * @return
     */
    public Boolean update(Integer id, String campo) {
        Boolean resultado = null;
        PreparedStatement stmt = null;

        if (this.conexion == null || id == null || campo == null) {
            return resultado;
        }

        try {

            String sql = "UPDATE clientes SET " + campo + "=? WHERE id = ?";

            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, campo);
            stmt.setInt(2, id);

            if (stmt.executeUpdate() > 0) {
                resultado = true;

            }
        } catch (SQLException e) {
            System.err.println("Error en el Update: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexin: " + ex.getMessage());
            }
        }

        return resultado;
    }

    /**
     * Eliminar un registro a través del id del cliente
     *
     * @param idCliente
     * @return
     */
    public Boolean delete(Integer idCliente) {
        Boolean resultado = false;
        PreparedStatement stmt = null;

        if (this.conexion == null || idCliente == null) {
            return resultado;
        }

        try {
            String sql = "DELETE FROM clientes WHERE id = ?";
            stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, idCliente);

            resultado = stmt.execute();

        } catch (SQLException e) {

            System.err.println("Error en el Delete: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexin: " + ex.getMessage());
            }
        }

        return resultado;

    }
}
