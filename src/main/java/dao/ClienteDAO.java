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
import org.apache.commons.lang3.StringUtils;

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
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_neptuno", "root", "");
        } catch (SQLException ex) {
            System.err.println("Error al conectar: " + ex.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    /**
     * Obtener el número de registros de la tabla.
     *
     * @return
     */
    public Integer size() {
        PreparedStatement stmt = null;
        Integer ultimoId = null;

        if (this.conexion == null) {
            return null;
        }

        try {
            String query = "SELECT COUNT(*) FROM clientes";
            stmt = conexion.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ultimoId = rs.getInt("COUNT(*)");
            }

        } catch (SQLException e) {
            System.err.println("Error en el Select: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error en el Select: " + ex.getMessage());
            }
        }

        return ultimoId;
    }

    /**
     * Listar la base de datos mediante los siguientes parámetros:
     *
     * @param inicio
     * @param limite
     * @return
     */
    public ArrayList<Cliente> listar(Integer inicio, Integer limite) {
        ArrayList<Cliente> listaClientes = null;
        PreparedStatement stmt = null;

        if (this.conexion == null || inicio == null || limite == null){
            return listaClientes;
        }

        try {
            String query = "SELECT * FROM clientes ORDER BY id LIMIT ? OFFSET ?";
            listaClientes = new ArrayList<>();
            
            stmt = conexion.prepareStatement(query);
            stmt.setInt(1, limite);
            stmt.setInt(2, inicio);

            ResultSet rs = stmt.executeQuery();

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
            System.err.println("Error al listar: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        return listaClientes;
    }

    /**
     * Búsqueda de un único cliente a través de su id
     *
     * @param idCliente
     * @return
     */
    public Cliente read(Integer idCliente) {
        Cliente cliente = null;
        PreparedStatement stmt = null;

        if (this.conexion == null || idCliente == null) {
            return null;
        }

        try {
            String query = "SELECT * FROM clientes WHERE id = ?";
            stmt = conexion.prepareStatement(query);
            stmt.setInt(1, idCliente);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
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
            }

        } catch (SQLException e) {
            System.err.println("Error en el Select: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error en el Select: " + ex.getMessage());
            }
        }

        return cliente;
    }
    
    public Cliente read(Cliente cliente) {
        Cliente clienteBD = null;
        PreparedStatement stmt = null;

        if (this.conexion == null || cliente.isBlank()) {
            return clienteBD;
        }

        try {
            String query = "SELECT * FROM clientes WHERE codigo = ? "
                    + "AND empresa = ?";
            stmt = conexion.prepareStatement(query);
            stmt.setString(1, cliente.getCodigoCliente());
            stmt.setString(2, cliente.getEmpresa());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                clienteBD = new Cliente(
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
            }

        } catch (SQLException e) {
            System.err.println("Error en el Select: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error en el Select: " + ex.getMessage());
            }
        }

        return clienteBD;
    }

    /**
     * Insertar un cliente
     *
     * @param cliente
     * @return
     */
    public Boolean insertar(Cliente cliente) {
        Boolean resultado = false;
        PreparedStatement stmt = null;

        if (this.conexion == null || cliente.isBlank()) {
            return resultado;
        }

        try {
            String query = "INSERT INTO clientes "
                    + "(id, codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) "
                    + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stmt = conexion.prepareStatement(query);
            stmt.setString(1, cliente.getCodigoCliente());
            stmt.setString(2, cliente.getEmpresa());
            stmt.setString(3, cliente.getContacto());
            stmt.setString(4, cliente.getCargoContacto());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getCiudad());
            stmt.setString(7, cliente.getRegion());
            stmt.setString(8, cliente.getCodigoPostal());
            stmt.setString(9, cliente.getPais());
            stmt.setString(10, cliente.getTelefono());
            stmt.setString(11, cliente.getFax());

            if (stmt.executeUpdate() > 0) {
                resultado = true;

            }

        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
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
     * @param valorCampo
     * @return
     */
    public Boolean update(Integer id, String campo, String valorCampo) {
        Boolean resultado = false;
        PreparedStatement stmt = null;

        if (this.conexion == null || id == null || StringUtils.isBlank(campo)
                || StringUtils.isBlank(valorCampo)) {
            return resultado;
        }

        try {

            String sql = "UPDATE clientes SET " + campo + " = ? WHERE id = ?";

            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, valorCampo);
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

            if (stmt.executeUpdate() > 0) {
                resultado = true;
            }
            
        } catch (SQLException e) {
            System.err.println("Error en el Delete: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        return resultado;

    }
}
