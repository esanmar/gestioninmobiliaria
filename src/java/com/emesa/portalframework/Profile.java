package com.emesa.portalframework;

import java.util.Hashtable;


/**
 * Contiene la informaci&oacute;n del usuario que se arrastrar&aacuta; en la
 * sesi&oacute;n para las comprobaciones de acceso, etc...
 */
public class Profile implements java.io.Serializable
{
    /** */
    private Hashtable ht=null;


    /**
     * Constructor
     */
    public Profile()
    {
        ht=new Hashtable();
        ht.put("usuario","anónimo");
        ht.put("clave","");
        ht.put("nombre","Anónimo");
        ht.put("apellido1","");
        ht.put("apellido2","");
        ht.put("permisos",new PermissionMask());
    }

    /**
     * Devuelve el valor de la propiedad del perfil solicitada
     */
    public Object get(String sKey)
    {
        return ht.get(sKey);
    }

    /**
     * Representaci&oacute;n del objeto
     *
     * @return String que representa al objeto
     */
    public String toString()
    {
        return ht.toString();
    }

    public static void main(String []args) {
        Profile p=new Profile();
        System.out.println("P: "+p);
    }
}