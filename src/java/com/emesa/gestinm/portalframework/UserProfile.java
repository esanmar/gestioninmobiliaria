package com.emesa.gestinm.portalframework;

import java.util.Vector;

/**
 * <i>JavaBean<i> con el perfil del usuario.
 *
 * @see com.emesa.gestinm.dao.UserProfileDAO
 */
public class UserProfile
{
    int idUsuario=-1;
    String usuario=null;
    String nombre=null;
    String apellido1=null;
    String apellido2=null;
    int idTipoUsuario=-1;
    String tipoUsuario=null;
    int idOficina=-1;
    String oficina=null;
    Vector miCartera=null;

    /**
     * Constructor por defecto
     */
    public UserProfile() {
        setIdUsuario(-1);
        setUsuario("");
        setNombre("");
        setApellido1("");
        setApellido2("");
        setIdTipoUsuario(-1);
        setTipoUsuario("");
        setIdOficina(-1);
        setOficina("");
        setMiCartera(new Vector());
    }

    /** Identificador del usuario en el portal */
    public int getIdUsuario() {
        return this.idUsuario;
    }
    /** Alias del usuario en el portal */
    public String getUsuario() {
        return this.usuario;
    }
    /** Nombre del usuario */
    public String getNombre() {
        return this.nombre;
    }
    /** Primer apellido del usuario */
    public String getApellido1() {
        return this.apellido1;
    }
    /** Segundo apellido del usuario */
    public String getApellido2() {
        return this.apellido2;
    }
    /** Identificador del tipo de usuario en el portal */
    public int getIdTipoUsuario() {
        return this.idTipoUsuario;
    }
    /** Tipo de usuario en el portal */
    public String getTipoUsuario() {
        return this.tipoUsuario;
    }
    /** Identificador de la oficina a la que pertenece el usuario */
    public int getIdOficina() {
        return this.idOficina;
    }
    /** Oficina a la que pertenece el usuario */
    public String getOficina() {
        return this.oficina;
    }

    /** Vector con los datos de <em>Mi cartera</em> */
    public Vector getMiCartera() {
        return this.miCartera;
    }


    /** Identificador del usuario en el portal */
    public void setIdUsuario(int n) {
        this.idUsuario=n;
    }
    /** Alias del usuario en el portal */
    public void setUsuario(String s) {
        this.usuario=s;
    }
    /** Nombre del usuario */
    public void setNombre(String s) {
        this.nombre=s;
    }
    /** Primer apellido del usuario */
    public void setApellido1(String s) {
        this.apellido1=s;
    }
    /** Segundo apellido del usuario */
    public void setApellido2(String s) {
        this.apellido2=s;
    }
    /** Identificador del tipo de usuario en el portal */
    public void setIdTipoUsuario(int n) {
        this.idTipoUsuario=n;
    }
    /** Tipo de usuario en el portal */
    public void setTipoUsuario(String s) {
        this.tipoUsuario=s;
    }
    /** Identificador de la oficina a la que pertenece el usuario */
    public void setIdOficina(int n) {
        this.idOficina=n;
    }
    
    /** Oficina a la que pertenece el usuario */
    public void setOficina(String s) {
        this.oficina=s;
    }

    /** Vector con los datos de <em>Mi cartera</em> */
    public void setMiCartera(Vector v) {
        this.miCartera=v;
    }


    /** Vector con los datos de <em>Mi cartera</em> */
    public void refreshMiCartera() {
        com.emesa.gestinm.dao.UserProfileDAO upd = new com.emesa.gestinm.dao.UserProfileDAO();
        upd.reloadMiCartera(this);
    }

    /**
     * Representaci&oacute;n del objeto
     */
    public String toString() {
        return "["+getIdUsuario()+", "+getUsuario()+", "+getNombre()+" "+getApellido1()+" "+getApellido2()+", "+getIdTipoUsuario()+", "+getTipoUsuario()+", "+getIdOficina()+", "+getOficina()+", "+getMiCartera()+"]";
    }
}
