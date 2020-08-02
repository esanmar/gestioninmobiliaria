package com.emesa.gestinm.dao;

import java.util.Vector;
import org.apache.log4j.Logger;

import com.emesa.gestinm.portalframework.UserProfile;
import com.emesa.Configuration;
import com.emesa.bbdd.DBManager;
import net.seh.bbdd.AbstractDBManager;


/**
 *
 * @see com.emesa.gestinm.portalframework.UserProfile
 */
public class UserProfileDAO
{
    /** Logger */
    static Logger logger = Logger.getLogger(UserProfileDAO.class);

    private static String sql="select u.ID_USUARIO,u.ALIAS,r.ID_TIPO_USUARIO,r.TIPO_USUARIO,u.NOMBRE,u.APELLIDO1,u.APELLIDO2,o.ID_OFICINA,o.NOMBRE from FEL_USUARIO u, FEL_OFICINA o, FEL_TIPO_USUARIO r where u.ID_OFICINA=o.ID_OFICINA and u.ID_TIPO_USUARIO=r.ID_TIPO_USUARIO";
    private static final String MICARTERA_QUERY="select i.Codigo, i.Zona, i.Tipo, i.Direccion, i.Precio_venta, i.Precio_alquiler, i.Superficie, e.Estado, i.Cod_Propietario, p.PERSONA_CONTACTO, p.CONTACTO_APEL1, p.TELEFONO from fel_inmueble i,fel_usuario u, fel_inm_estado e left join fel_proveedor p on p.ID_PROPIETARIO=i.Cod_Propietario where i.vendedor!='' and i.vendedor=u.id_usuario and i.estado!="+Configuration.getProperty("estado.vendido")+" and i.estado!="+Configuration.getProperty("estado.eliminado")+" and i.estado=e.id_estado";

	/**
	 * Constructor
	 *
	 */
    public UserProfileDAO() {
    }


    /**
     * Devuelve el perfil del usuario indicado en el par&aacute;metro
     *
     * @param sUsuario <i>Alias</i> del usuario
     * @return Perfil del usuario indicado
     */
    public UserProfile load(int idUsuario) {
        Vector vParams=new Vector();
        vParams.add(new Integer(idUsuario));

        UserProfile o = executeQuery(sql+" and u.ID_USUARIO=?",vParams);
		o.setMiCartera(MiCarteraDAO.getMiCartera(idUsuario));
/*
        String sMiCarteraQuery=MICARTERA_QUERY+" and i.VENDEDOR=? order by i.Codigo";
        try {
            AbstractDBManager dbm=DBManager.getInstance();
            o.setMiCartera(dbm.executeQuery(sMiCarteraQuery,vParams));
        }
        catch(Exception e) {
            logger.error("[load] Error: "+e);
        }
*/
        return o;
    }


    /**
     *
     * @param sUsuario <i>Alias</i> del usuario
     * @return
     */
    public UserProfile load(String sUsuario) {
        Vector vParams=new Vector();
        vParams.add(sUsuario);

        UserProfile o = executeQuery(sql+" and u.ALIAS=?",vParams);
		o.setMiCartera(MiCarteraDAO.getMiCartera(sUsuario));
/*
        String sMiCarteraQuery=MICARTERA_QUERY+" and u.ALIAS=? order by i.Codigo";
        try {
            AbstractDBManager dbm=DBManager.getInstance();
            logger.debug("[load] "+sMiCarteraQuery+"-"+vParams);
            o.setMiCartera(dbm.executeQuery(sMiCarteraQuery,vParams));
        }
        catch(Exception e) {
            logger.error("[load] Error: "+e);
        }
*/
        return o;
    }



    /**
     * 
     * 
     * @param sQuery
     * @param vParams
     * @return
     */
    private UserProfile executeQuery(String sQuery, Vector vParams) {
        AbstractDBManager dbm=DBManager.getInstance();
        Vector vRtado=null;
        try {
            vRtado=dbm.executeQuery(sQuery,vParams);
        }
        catch(Exception e) {
            logger.error("[executeQuery] Error: "+e);
        }

        if(vRtado!=null && !vRtado.isEmpty())
            return setUserProfile((Vector)vRtado.firstElement());
        else
            return null;
    }


    /**
     *
     * @param o Perfil del usuario
     */
    public void reloadMiCartera(UserProfile o) {
        Vector vParams=new Vector();
        vParams.add(new Integer(o.getIdUsuario()));
        o.setMiCartera(MiCarteraDAO.getMiCartera(o.getIdUsuario()));
    }

    /**
     */
    private UserProfile setUserProfile(Vector vRow) {
        UserProfile o=new UserProfile();

        /* 0.- ID_USUARIO
         * 1.- ALIAS
         * 2.- ID_TIPO_USUARIO
         * 3.- TIPO_USUARIO
         * 4.- NOMBRE
         * 5.- APELLIDO1
         * 6.- APELLIDO2
         * 7.- ID_OFICINA
         * 8.- NOMBRE
         */
        if(vRow.elementAt(0)!=null)
            o.setIdUsuario(Integer.parseInt(vRow.elementAt(0).toString()));
        if(vRow.elementAt(1)!=null)
            o.setUsuario(vRow.elementAt(1).toString());
        if(vRow.elementAt(2)!=null)
            o.setIdTipoUsuario(Integer.parseInt(vRow.elementAt(2).toString()));
        if(vRow.elementAt(3)!=null)
            o.setTipoUsuario(vRow.elementAt(3).toString());
        if(vRow.elementAt(4)!=null)
            o.setNombre(vRow.elementAt(4).toString());
        if(vRow.elementAt(5)!=null)
            o.setApellido1(vRow.elementAt(5).toString());
        if(vRow.elementAt(6)!=null)
            o.setApellido2(vRow.elementAt(6).toString());
        if(vRow.elementAt(7)!=null)
            o.setIdOficina(Integer.parseInt(vRow.elementAt(7).toString()));
        if(vRow.elementAt(8)!=null)
            o.setOficina(vRow.elementAt(8).toString());

        return o;
    }
}
