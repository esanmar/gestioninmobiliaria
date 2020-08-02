package com.emesa.bbdd.cache;

import java.util.Hashtable;
import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;
import com.emesa.bbdd.DBManager;
import com.emesa.dao.MSA_PERMISOS;

import org.apache.log4j.Logger;

/**
 */
public class PermisosCache
{
    /** Logger */
    static Logger logger = Logger.getLogger(MSA_PERMISOS.class);

    /** */
    static Hashtable h=load();

    /**
     * Carga de BB.DD. la informaci&oacute;n de los permisos
     */
    public static Hashtable load() {
        h=new Hashtable();
        AbstractDBManager dbm = DBManager.getInstance();
        Vector vRtado=null;
        try {
            vRtado=dbm.executeQuery(MSA_PERMISOS.getSelect());
        }
        catch(Exception e) {
            logger.error(e.getMessage());
            return h;
        }

        if(vRtado!=null) {
            MSA_PERMISOS o=null;
            for(int i=0; i<vRtado.size(); i++) {
                o=new MSA_PERMISOS();
                o.setElement((Vector)vRtado.elementAt(i));
                h.put(o.key(),o);
            }
        }

        logger.debug("[load] Cargada: "+h);
        return h;
    }

    /**
     */
    public static Object get(Object key) {
        return h.get(key);
    }
}
