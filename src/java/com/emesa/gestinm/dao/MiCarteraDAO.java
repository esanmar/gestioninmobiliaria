/*
 * Fichero: MiCarteraDAO.java 
 * 
 * Autor:   sergioarias
 * Fecha:   17-feb-2004
 */
package com.emesa.gestinm.dao;

import com.emesa.Configuration;
import com.emesa.bbdd.DBManager;
import com.emesa.gestinm.pojo.*;

import java.sql.SQLException;
import java.util.*;

import org.apache.log4j.Logger;

import net.seh.bbdd.AbstractDBManager;

/**
 * @author sergioarias
 * @since 17-feb-2004
 */
public class MiCarteraDAO
{
	static Logger logger = Logger.getLogger(MiCarteraDAO.class);
	private static final String SQL_QUERY="select i.Codigo, i.Zona, i.Tipo, i.Direccion, i.Precio_venta, i.Precio_alquiler, i.Superficie, e.Estado, i.Cod_Propietario, p.PERSONA_CONTACTO, p.CONTACTO_APEL1, p.TELEFONO from fel_inmueble i,fel_usuario u, fel_inm_estado e left join fel_proveedor p on p.ID_PROPIETARIO=i.Cod_Propietario where i.vendedor!='' and i.vendedor=u.id_usuario and i.estado!="+Configuration.getProperty("estado.vendido")+" and i.estado!="+Configuration.getProperty("estado.eliminado")+" and i.estado=e.id_estado";

	/**
	 * Constructor
	 *
	 */
	public MiCarteraDAO() {
	}


	/**
	 * 
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static Vector getMiCartera(int idUsuario) {
		Vector vMiCartera=new Vector();
		Vector vRtado=null;
		Vector vParams=new Vector();
		vParams.add(new Integer(idUsuario));

		AbstractDBManager dbm = DBManager.getInstance();
		try {
			vRtado=dbm.executeQuery(SQL_QUERY+" and i.VENDEDOR=?", vParams);
		} catch (SQLException e) {
			logger.error("Error al recuperar Mi Cartera del usuario "+idUsuario+": "+e);
			//e.printStackTrace();
			return new Vector();
		}

		if(vRtado!=null) {
			MiCartera o=null;
			for(int i=0; i<vRtado.size(); i++) {
				o=new MiCartera();
				o.setElement((Vector)vRtado.elementAt(i));

				vMiCartera.add(o);
			}
		}
		return vMiCartera;
	}

	/**
	 * 
	 * 
	 * @param idUsuario
	 * @return
	 */
	public static Vector getMiCartera(String sAlias) {
		Vector vMiCartera=new Vector();
		Vector vRtado=null;
		Vector vParams=new Vector();
		vParams.add(sAlias);

		AbstractDBManager dbm = DBManager.getInstance();
		try {
			vRtado=dbm.executeQuery(SQL_QUERY+" and u.ALIAS=?", vParams);
		} catch (SQLException e) {
			logger.error("Error al recuperar Mi Cartera del usuario "+sAlias+": "+e);
			//e.printStackTrace();
			return new Vector();
		}

		if(vRtado!=null) {
			MiCartera o=null;
			for(int i=0; i<vRtado.size(); i++) {
				o=new MiCartera();
				o.setElement((Vector)vRtado.elementAt(i));

				vMiCartera.add(o);
			}
		}
		return vMiCartera;
	}
}
