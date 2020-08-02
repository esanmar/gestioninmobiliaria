package com.emesa.gestinm;

import java.util.ResourceBundle;
import java.util.Enumeration;

import org.apache.log4j.Logger;

/**
 * Clase de configuraci&oacute;n para <b>Educarioja</b>. Contine constantes y m&eacute;todos de acceso al fichero
 * de propiedades de configuraci&oacute;n
 */
public class Customization
{
    /** <i>Logger</i> */
    static Logger logger = Logger.getLogger(Customization.class);

	private static final ResourceBundle rb = ResourceBundle.getBundle("com/emesa/gestinm/custom");

	/**
    * Devuelve el valor asociado a la clave indicada
    *
    * @param sKey Clave
    * @return Valor asociado a <code>sKey</code>
    */
    public static String getProperty(String sKey)
    {
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