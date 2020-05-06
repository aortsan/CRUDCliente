/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Alvaro
 */
public class Cliente {

    private Integer idCliente;
    private String codigoCliente;
    private String empresa;
    private String contacto;
    private String cargoContacto;
    private String direccion;
    private String ciudad;
    private String region;
    private String codigoPostal;
    private String pais;
    private String telefono;
    private String fax;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String codigoCliente, String empresa, String contacto, String cargoContacto, String direccion, String ciudad, String region, String codigoPostal, String pais, String telefono, String fax) {
        this.idCliente = idCliente;
        this.codigoCliente = codigoCliente;
        this.empresa = empresa;
        this.contacto = contacto;
        this.cargoContacto = cargoContacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.telefono = telefono;
        this.fax = fax;
    }

    /**
     * Obtener el valor de la propiedad id
     *
     * @return
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * Obtener el valor de la propiedad codigo
     *
     * @return
     */
    public String getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * Modificar el valor de la propiedad codigo
     *
     * @param codigoCliente
     */
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * Obtener el valor de la propiedad empresa
     *
     * @return
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Modificar el valor de la propiedad empresa
     *
     * @param empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Obtener el valor de la propiedad contacto
     *
     * @return
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * Modificar el valor de la propiedad contacto
     *
     * @param contacto
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * Obtener el valor de la propiedad cargo del contacto
     *
     * @return
     */
    public String getCargoContacto() {
        return cargoContacto;
    }

    /**
     * Modificar el valor de la propiedad cargo del contacto
     *
     * @param cargoContacto
     */
    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }

    /**
     * Obtener el valor de la propiedad direccion
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Modificar el valor de la propiedad direccion
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtener el valor de la propiedad ciudad
     *
     * @return
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Modificar el valor de la propiedad ciudad
     *
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtener el valor de la propiedad region
     *
     * @return
     */
    public String getRegion() {
        return region;
    }

    /**
     * Modifica el valor de la propiedad region
     *
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Obtener el valor de la propiedad codigo postal
     *
     * @return
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Modificar el valor de la propiedad codigo postal
     *
     * @param codigoPostal
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtener el valor de la propiedad pais
     *
     * @return
     */
    public String getPais() {
        return pais;
    }

    /**
     * Modificar el valor de la propiedad pais
     *
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtener el valor de la propiedad teléfono
     *
     * @return String del objeto
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Modificar el valor de la propiedad teléfono
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtener el valor de la propiedad fax
     *
     * @return String del objeto
     */
    public String getFax() {
        return fax;
    }

    /**
     * Modificar el valor de la propiedad fax
     *
     * @param fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }
    
    /**
     * Comprobar si los campos clave están vacíos
     * @return true si está vacío
     */
    public Boolean isBlank() {
        return this.codigoCliente.isBlank() 
                || this.empresa.isBlank() 
                || this.contacto.isBlank()
                || this.cargoContacto.isBlank() 
                || this.direccion.isBlank() 
                || this.ciudad.isBlank()
                || this.pais.isBlank()
                || this.telefono.isBlank();
    }
    /**
     * Todo aquel campo atributo cuyo valor contenga espacios en blanco será
     * cambiado a nulo
     */
    public void setNull() {
        if(this.codigoCliente.isBlank()) this.codigoCliente = null;
            
        if (this.empresa.isBlank()) this.empresa = null;
            
        if (this.contacto.isBlank()) this.contacto = null;
            
        if (this.cargoContacto.isBlank()) this.cargoContacto = null;
           
        if (this.direccion.isBlank()) this.direccion = null;
            
        if (this.ciudad.isBlank()) this.ciudad = null;
            
        if (this.region.isBlank()) this.region = null;
            
        if (this.codigoPostal.isBlank()) this.codigoPostal = null;
            
        if (this.pais.isBlank()) this.pais = null;
            
        if (this.telefono.isBlank()) this.telefono = null;
        
        if (this.fax.isBlank()) this.fax = null;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", codigoCliente=" + codigoCliente + ", empresa=" + empresa + ", contacto=" + contacto + ", cargoContacto=" + cargoContacto + ", direccion=" + direccion + ", ciudad=" + ciudad + ", region=" + region + ", codigoPostal=" + codigoPostal + ", pais=" + pais + ", telefono=" + telefono + ", fax=" + fax + '}';
    }

}
