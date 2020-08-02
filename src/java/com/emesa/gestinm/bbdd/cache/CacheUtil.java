package com.emesa.gestinm.bbdd.cache;

import java.util.Vector;

import com.emesa.bbdd.cache.*;
import com.emesa.Configuration;
import org.apache.log4j.Logger;

import net.seh.bbdd.AbstractDBManager;
import com.emesa.bbdd.DBManager;

/**
 * Utilidades de acceso a valores de la cach&eacute;
 *
 * @see com.emesa.bbdd.cache.QueryCache
 * @see com.emesa.bbdd.cache.CacheObject
 */
public class CacheUtil
{
    /** Logger */
    static Logger logger = Logger.getLogger(CacheUtil.class);

    /**
     * Evitamos llamadas al constrcutor haci&eacute;ndolo <code>private</code>
     */
    private CacheUtil() {
    }

    /**
     */
    public static int getID_TIPO_USUARIO(String sTipoUsuario) {
        CacheObject co = QueryCache.get("roles");
        Vector vQueryResults=co.getQueryResults();
        // El orden es [0] ID_TIPO_USUARIO, [1] TIPO_USUARIO
        for(int i=0; i<vQueryResults.size(); i++) {
            if(  ((Vector)vQueryResults.elementAt(i)).elementAt(1).equals(sTipoUsuario) )
                return Integer.parseInt( ((Vector)vQueryResults.elementAt(i)).elementAt(0).toString() );
        }

        return -1;
    }

    /**
     *
     * @return La cadena que representa el tipo de usuario
     */
    public static String getTIPO_USUARIO(int nIdTipoUsuario) {
        CacheObject co = QueryCache.get("roles");
        Vector vQueryResults=co.getQueryResults();
        // El orden es [0] ID_TIPO_USUARIO, [1] TIPO_USUARIO
        for(int i=0; i<vQueryResults.size(); i++) {
            if(  Integer.parseInt(((Vector)vQueryResults.elementAt(i)).elementAt(0).toString())==nIdTipoUsuario )
                return ((Vector)vQueryResults.elementAt(i)).elementAt(1).toString();
        }

        return null;
    }


     /**
     *
     * @return La cadena que representa el tipo de inmueble
     */
    public static String getTIPO_INMUEBLE(int nIdTipoInm) {
        CacheObject co = QueryCache.get("inm");
        Vector vQueryResults=co.getQueryResults();
        for(int i=0; i<vQueryResults.size(); i++) {
            if(  Integer.parseInt(((Vector)vQueryResults.elementAt(i)).elementAt(0).toString())==nIdTipoInm )
                return ((Vector)vQueryResults.elementAt(i)).elementAt(1).toString();
        }

        return null;
    }

    /**
     */
    public static int getID_TIPO_INMUEBLE(String sTipoInm) {
        CacheObject co = QueryCache.get("inm");
        Vector vQueryResults=co.getQueryResults();
        for(int i=0; i<vQueryResults.size(); i++) {
            if(  ((Vector)vQueryResults.elementAt(i)).elementAt(1).equals(sTipoInm) )
                return Integer.parseInt( ((Vector)vQueryResults.elementAt(i)).elementAt(0).toString() );
        }

        return -1;
    }

     /**
     *
     * @return La cadena que representa el tipo de calefacción
     */
    public static String getTIPO_CALEF(int nIdTipoCal) {
        CacheObject co = QueryCache.get("calef");
        Vector vQueryResults=co.getQueryResults();
        for(int i=0; i<vQueryResults.size(); i++) {
            if(  Integer.parseInt(((Vector)vQueryResults.elementAt(i)).elementAt(0).toString())==nIdTipoCal )
                return ((Vector)vQueryResults.elementAt(i)).elementAt(1).toString();
        }

        return null;
    }

    /**
     */
    public static int getID_TIPO_CALEF(String sTipoCal) {
        CacheObject co = QueryCache.get("calef");
        Vector vQueryResults=co.getQueryResults();
        for(int i=0; i<vQueryResults.size(); i++) {
            if(  ((Vector)vQueryResults.elementAt(i)).elementAt(1).equals(sTipoCal) )
                return Integer.parseInt( ((Vector)vQueryResults.elementAt(i)).elementAt(0).toString() );
        }

        return -1;
    }


    /**
     */
    public static String getProvincia(int nIdProv) {
        CacheObject co = QueryCache.get("provincias");
        Vector vQueryResults=co.getQueryResults();
        // El orden es [0] ID_PROVINCIA, [1] PROVINCIA
        for(int i=0; i<vQueryResults.size(); i++) {
            if(  ((Vector)vQueryResults.elementAt(i)).elementAt(0).equals(""+nIdProv) )
                return ((Vector)vQueryResults.elementAt(i)).elementAt(1).toString();
        }

        return null;
    }

    /**
     * @return Nombre del pa&iacute;s asociado al ID
     */
    public static String getPais(int nId) {
        CacheObject co = QueryCache.get("paises");
        Vector vQueryResults=co.getQueryResults();
        // El orden es [0] ID_PAIS, [1] NOMBRE_PAIS
        for(int i=0; i<vQueryResults.size(); i++) {
            if(  ((Vector)vQueryResults.elementAt(i)).elementAt(0).equals(""+nId) )
                return ((Vector)vQueryResults.elementAt(i)).elementAt(1).toString();
        }

        return null;
    }

    /**
     *
     * @return Nombre del estado del inmueble asociado al ID
     */
    public static String getEstado(int nId) {
        CacheObject co = QueryCache.get("inm_estado");
        Vector vQueryResults=co.getQueryResults();
        // El orden es [0] ID_ESTADO, [1] ESTADO
        for(int i=0; i<vQueryResults.size(); i++) {
            if(  ((Vector)vQueryResults.elementAt(i)).elementAt(0).equals(""+nId) )
                return ((Vector)vQueryResults.elementAt(i)).elementAt(1).toString();
        }

        return null;
    }


    /**
     *
     * @param sZona
     */
    public static Vector getDirecciones(String sZona) {
        Vector v=new Vector();
        if(sZona==null)
            return v;
        AbstractDBManager dbm=null;
        try {
            dbm=DBManager.getInstance();
            Vector vParams = new Vector();
            vParams.add(sZona);
            Vector v2=dbm.executeQuery("select distinct trim(DIRECCION) from fel_inmueble where estado!="+Configuration.getProperty("estado.eliminado")+" and estado!="+Configuration.getProperty("estado.vendido")+" and ZONA=? order by DIRECCION",vParams);
            if(v2!=null) {
                for (int i=0; i<v2.size(); i++) {
                    v.add(v2.elementAt(i));
                }
            }
            dbm.close();
        }
        catch(Exception e) {
            logger.error("[getDirecciones] Error: "+e);
            if(dbm!=null)
                dbm.close();
        }

        return v;
    }
}