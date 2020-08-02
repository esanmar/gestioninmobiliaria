package com.emesa.gestinm.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;


/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Thu Jul 17 16:48:01 CEST 2003
 */
public class InmuebleDestacado
{
    /** Logger */
    static Logger logger = Logger.getLogger(InmuebleDestacado.class);

    /**
     *
     * @return Vector con los <code>FEL_INMUEBLE</code> destacados
     */
    public static Vector getInmueblesDestacados() {
        AbstractDBManager dbm=DBManager.getInstance();
        Vector vRtado=null;
        try {
            vRtado=dbm.executeQuery("select ID_INMUEBLE from FEL_INMUEBLE_DESTACADO");
        }
        catch(Exception e) {
            logger.error("[getInmueblesDestacados] Error: "+e);
            return new Vector();
        }

        if(vRtado==null)
            return new Vector();

        FEL_INMUEBLE o=null;
        Vector vReturn=new Vector();
        for(int i=0; i<vRtado.size(); i++) {
            o=new FEL_INMUEBLE();
            o.loadFromDB( Integer.parseInt( ((Vector)vRtado.elementAt(i)).firstElement().toString() ) );
            vReturn.add(o);
        }

        return vReturn;
    }


    /**
     */
    public static int add(int idInmueble) throws Exception{
        AbstractDBManager dbm=DBManager.getInstance();
        String sql="";
        Vector vParams=new Vector();
        vParams.add(new Integer(idInmueble));
        Vector vRtado=null;
        try {
            return dbm.executeUpdate("insert into FEL_INMUEBLE_DESTACADO values (?)",vParams);
        }
        catch(Exception e) {
            logger.error("[add] Error: "+e);
            throw e;
        }

        //return 0;
    }


    /**
     */
    public static int del(int idInmueble) throws Exception{
        AbstractDBManager dbm=DBManager.getInstance();
        String sql="";
        Vector vParams=new Vector();
        vParams.add(new Integer(idInmueble));
        Vector vRtado=null;
        try {
            return dbm.executeUpdate("delete from FEL_INMUEBLE_DESTACADO where ID_INMUEBLE=?",vParams);
        }
        catch(Exception e) {
            logger.error("[del] Error: "+e);
            throw e;
        }

        //return 0;
    }
}
