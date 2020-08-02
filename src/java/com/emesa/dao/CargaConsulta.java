package com.emesa.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;

/**
 *
 * @since Mon Jul 07 10:17:31 CEST 2003
 */
public class CargaConsulta
{
    /** Logger */
    static Logger logger = Logger.getLogger(CargaConsulta.class);

    /**
    * 
    *
    * @param sNombre Nombre de la oficina
    * @return Vector con el resultado de la query
    */
    public Vector loadFromDB(String sSQL)
    {
        AbstractDBManager dbm = DBManager.getInstance();
        Vector vRtado = new Vector();
        try {
            vRtado=dbm.executeQuery(sSQL);
        }
        catch(Exception e) {
            //-- Tratamiento de la excepcion
            return null;
        }

      
        return vRtado;
    }
}
