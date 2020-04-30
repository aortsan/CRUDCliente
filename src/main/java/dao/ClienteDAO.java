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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alvaro
 */
public class ClienteDAO {

    private Connection conexion = null;

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

    public ArrayList<Cliente> listar(String orden, Integer desde, Integer limite) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        PreparedStatement stm = null;
        
        if(this.conexion == null || orden == null || desde == null || limite == null){
            return listaClientes;
        }
        
        try {
            String query = "SELECT * FROM clientes ORDER BY " + orden + " LIMIT ? OFFSET ?";
            
            stm = conexion.prepareStatement(query);
            stm.setInt(1,limite);
            stm.setInt(2, desde);
            
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()){
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
        } finally{
            try {
                stm.close();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage() + " " + stm.toString());
            }
        }
        
        return listaClientes;
    }
}
