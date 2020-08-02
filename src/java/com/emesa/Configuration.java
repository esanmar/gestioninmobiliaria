package com.emesa;

import java.util.ResourceBundle;
import java.util.Enumeration;

import org.apache.log4j.Logger;

/**
 * Clase de configuraci&oacute;n para <b>Educarioja</b>. Contine constantes y m&eacute;todos de acceso al fichero
 * de propiedades de configuraci&oacute;n
 */
public class Configuration
{
    /** <i>Logger</i> */
    static Logger logger = Logger.getLogger(Configuration.class);

	private static final ResourceBundle rb = ResourceBundle.getBundle("com/emesa/configuration");

    /** Directorio base de la aplicacion */
    private static String sAppBase="";

    static {
        if(getProperty("property.server.base")!=null && !getProperty("property.server.base").trim().equals(""))
            sAppBase=System.getProperty(getProperty("property.server.base")).replace('\\','/')+"/webapps/"+getProperty("app.name");
        else
            sAppBase=getProperty("property.folder.base");
    }


	/**
    * Devuelve el valor asociado a la clave indicada
    *
    * @param sKey Clave
    * @return Valor asociado a <code>sKey</code>
    */
    public static String getProperty(String sKey)
    {
        if(sKey.equals("application.base"))
            return sAppBase;
        if(sKey.startsWith("folder."))
            return sAppBase+rb.getString(sKey).trim();
        else
            return rb.getString(sKey).trim();
    }

    /**
    * Devuelve el listado de los nombres de las propiedades existentes
    *
    * @return Listado de los nombres de las propiedades existentes
    */
    public static Enumeration getPropertyNames()
    {
        return rb.getKeys();
    }

}