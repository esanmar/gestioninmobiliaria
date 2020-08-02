package com.emesa.portalframework;

/**
 * Perfil <i>tipo</i> del usuario del portal
 */
public interface IUserProfile
{
    String username=null;
    Object password=null;
    String name=null;
    String middlename=null;
    String surname=null;
    Object role=null;

    /** Alias del usuario en el portal */
    public String getUsername();
    /** Clave del usuario en el portal */
    public Object getPassword();
    /** Nombre del usuario */
    public String getName();
    /** Tambi&eacute;n se utilizar&aacute;a para el primer apellido*/
    public String getMiddlename();
    /** Apellido o segundo apellido */
    public String getSurname();
    /** Rol o tipo del usuario en el portal */
    public Object getRole();

    /** Alias del usuario en el portal */
    public void setUsername(String un);
    /** Clave del usuario en el portal */
    public void setPassword(Object p);
    /** Nombre del usuario */
    public void setName(String n);
    /** Tambi&eacute;n se utilizar&aacute;a para el primer apellido*/
    public void setMiddlename(String mn);
    /** Apellido o segundo apellido */
    public void setSurname(String sn);
    /** Rol o tipo del usuario en el portal */
    public void setRole(Object role);
}
