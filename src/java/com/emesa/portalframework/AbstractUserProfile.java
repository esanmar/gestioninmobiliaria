package com.emesa.portalframework;

/**
 */
public class AbstractUserProfile implements IUserProfile
{
    String username=null;
    Object password=null;
    String name=null;
    String middlename=null;
    String surname=null;
    Object role=null;

    public AbstractUserProfile() {
        setUsername("");
        setPassword(null);
        setRole(null);
        setName("");
        setMiddlename("");
        setSurname("");
    }

    /** Alias del usuario en el portal */
    public String getUsername() {
        return this.username;
    }
    /** Clave del usuario en el portal */
    public Object getPassword() {
        return this.password;
    }
    /** Nombre del usuario */
    public String getName() {
        return this.name;
    }
    /** Tambi&eacute;n se utilizar&aacute;a para el primer apellido*/
    public String getMiddlename() {
        return this.middlename;
    }
    /** Apellido o segundo apellido */
    public String getSurname() {
        return this.surname;
    }
    /** Rol o tipo del usuario en el portal */
    public Object getRole() {
        return this.role;
    }

    /** Alias del usuario en el portal */
    public void setUsername(String un) {
        this.username=un;
    }
    /** Clave del usuario en el portal */
    public void setPassword(Object p) {
        this.password=p;
    }
    /** Nombre del usuario */
    public void setName(String n) {
        this.name=n;
    }
    /** Tambi&eacute;n se utilizar&aacute;a para el primer apellido*/
    public void setMiddlename(String mn) {
        this.middlename=mn;
    }

    /** Apellido o segundo apellido */
    public void setSurname(String sn) {
        this.surname=sn;
    }
    /** Rol o tipo del usuario en el portal */
    public void setRole(Object role) {
        this.role=role;
    }

    /**
     * Representaci&oacute;n del objeto
     */
    public String toString() {
        return "["+getUsername()+", "+getRole()+", "+getName()+", "+getMiddlename()+", "+getSurname()+"]";
    }
}
