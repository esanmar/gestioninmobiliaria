/*
	-----------------------------------------
	Desarrollado por EMESA S.L.
	http://www.emesa.com
	
	$Id: FEL_VISITAS_INMUEBLE.java,v 1.1 2004/03/12 17:03:52 swhite Exp $
	-----------------------------------------
	$Author: swhite $
	$Date: 2004/03/12 17:03:52 $
	-----------------------------------------
*/
package com.emesa.gestinm.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;


/**
 * @author sergioarias
 * @since 11-mar-2004
 */
public class FEL_VISITAS_INMUEBLE {
	private static final SimpleDateFormat sdfDB=new SimpleDateFormat(com.emesa.Configuration.getProperty("db.date_format"));
	private static final SimpleDateFormat sdfShow=new SimpleDateFormat(com.emesa.Configuration.getProperty("show.date_format"));

	/** Logger */
	static Logger logger = Logger.getLogger(FEL_VISITAS_INMUEBLE.class);

	private static String SQL_QUERY="SELECT v.ID,v.ID_VENDEDOR,v.ID_INMUEBLE,v.FECHA,v.COMENTARIO,u.NOMBRE,u.APELLIDO1 from FEL_VISITAS_INMUEBLE v, FEL_USUARIO u where v.ID_VENDEDOR=u.ID_USUARIO";
	
	private int ID=-1;
	private int ID_INMUEBLE=-1;
	private int ID_VENDEDOR=-1;
	private Date FECHA=null;
	private String COMENTARIO="";
	
	private String NOMBRE_VENDEDOR="";
	private String APELLIDO_VENDEDOR="";
	
	
	/**
	 * Constructor
	 */
	public FEL_VISITAS_INMUEBLE() {
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param vRow Vector que representa al objeto en BB.DD. 
	 * @return Objeto <code>FEL_VISITAS_INMUEBLE</code> representado
	 */
	public static FEL_VISITAS_INMUEBLE setElement(Vector vRow) {
		FEL_VISITAS_INMUEBLE oVisitas=new FEL_VISITAS_INMUEBLE();

//		0 ID
//		1 ID_VENDEDOR
//		2 ID_INMUEBLE
//		3 FECHA
//		4 COMENTARIO
//		5 NOMBRE
//		6 APELLIDO1
		if(vRow.elementAt(0)!=null)
			oVisitas.setID(Integer.parseInt( vRow.elementAt(0).toString().trim()) );
		if(vRow.elementAt(1)!=null)
			oVisitas.setID_VENDEDOR(Integer.parseInt( vRow.elementAt(1).toString().trim()) );
		if(vRow.elementAt(2)!=null)
			oVisitas.setID_INMUEBLE(Integer.parseInt( vRow.elementAt(2).toString().trim()) );

		if(vRow.elementAt(3)!=null) {
			try {
				oVisitas.setFECHA(sdfDB.parse(vRow.elementAt(3).toString().trim()));
			}
			catch(Exception e) {
				logger.warn("[setElement] Error al parsear la fecha: "+e);
			}
		}

		if(vRow.elementAt(4)!=null)
			oVisitas.setCOMENTARIO(vRow.elementAt(4).toString().trim());
		if(vRow.elementAt(5)!=null)
			oVisitas.setNOMBRE_VENDEDOR(vRow.elementAt(5).toString().trim());
		if(vRow.elementAt(6)!=null)
			oVisitas.setAPELLIDO_VENDEDOR(vRow.elementAt(6).toString().trim());

		return oVisitas;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param idInmueble Identificador del inmueble
	 * @return Vector con las visitas
	 */
	public static Vector getVisitas(int idInmueble) {
		Vector vRtado=new Vector();
		Vector vParams = new Vector();
		vParams.add(new Integer(idInmueble));
		AbstractDBManager dbm = DBManager.getInstance();
		Vector vAux = null;
		try {
			vAux=dbm.executeQuery(SQL_QUERY+" AND v.ID_INMUEBLE=? ORDER BY v.ID desc, FECHA desc", vParams);
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
			logger.error("[getVisitas] Error: "+e);
		}

		if(vAux!=null && !vAux.isEmpty()) {
			for(int i=0; i<vAux.size(); i++) {
				vRtado.add(setElement( (Vector)vAux.elementAt(i) ));
			}
		}

		return vRtado;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param id Identificador del comentario
	 * @return Objeto <code>FEL_VISITAS_INMUEBLE</code> cargado de la BB.DD.
	 */
	public static FEL_VISITAS_INMUEBLE loadFromDB(int id) {
		Vector vParams = new Vector();
		vParams.add(new Integer(id));
		AbstractDBManager dbm = DBManager.getInstance();
		Vector vAux = null;
		try {
			vAux=dbm.executeQuery(SQL_QUERY+" AND v.ID=?", vParams);
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
			logger.error("[getVisitas] Error: "+e);
		}

		if(vAux!=null && !vAux.isEmpty()) {
			return setElement( (Vector)vAux.firstElement() );
		}

		return null;
	}
	
	/**
	 * Guarda la informaci&oacute;n del objeto en la tabla.
	 */
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams = new Vector();

		if(getID()==-1) {
			sSQL = new StringBuffer("INSERT INTO FEL_VISITAS_INMUEBLE ");
			sSQL.append("(ID_INMUEBLE, ID_VENDEDOR, FECHA, COMENTARIO");
			sSQL.append(") VALUES (?,?,?,?)");

			vParams.add(new Integer(getID_INMUEBLE()));
			vParams.add(new Integer(getID_VENDEDOR()));
			try {
				vParams.add(sdfDB.format(getFECHA()));
			}
			catch(Exception e) {
				logger.warn("[saveToDB] Error al dar formato a la fecha: "+e);
				vParams.add(sdfDB.format(new Date()));
			}
			vParams.add(getCOMENTARIO());
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_VISITAS_INMUEBLE SET ");
			sSQL.append("ID_INMUEBLE=?");
			sSQL.append(", ID_VENDEDOR=?");
			sSQL.append(", FECHA=?");
			sSQL.append(", COMENTARIO=?");
			sSQL.append(" WHERE ID=?");

			vParams.add(new Integer(getID_INMUEBLE()));
			vParams.add(new Integer(getID_VENDEDOR()));
			try {
				vParams.add(sdfDB.format(getFECHA()));
			}
			catch(Exception e) {
				logger.warn("[saveToDB] Error al dar formato a la fecha: "+e);
				vParams.add(sdfDB.format(new Date()));
			}
			vParams.add(getCOMENTARIO());
			
			vParams.add(new Integer(getID()));
		}

		AbstractDBManager dbm = DBManager.getInstance();
		dbm.executeUpdate(sSQL.toString(),vParams);
		dbm.close();
	}

	/**
	 * 
	 * 
	 * @return N&uacute;mero de filas eliminadas
	 */
	public int delete() throws SQLException {
		Vector vParams=new Vector();
		vParams.add(new Integer(getID()));
		AbstractDBManager dbm = DBManager.getInstance();
		int nRtados=dbm.executeUpdate("delete from FEL_VISITAS_INMUEBLE where ID=?",vParams);
		dbm.close();

		return nRtados; 
	}

	/**
	 * 
	 * @return
	 */
	public String getCOMENTARIO() {
		return COMENTARIO;
	}

	/**
	 * 
	 * @return
	 */
	public Date getFECHA() {
		return FECHA;
	}

	/**
	 * 
	 * @return
	 */
	public int getID() {
		return ID;
	}

	/**
	 * 
	 * @return
	 */
	public int getID_INMUEBLE() {
		return ID_INMUEBLE;
	}

	/**
	 * 
	 * @return
	 */
	public int getID_VENDEDOR() {
		return ID_VENDEDOR;
	}

	/**
	 * 
	 * @param string
	 */
	public void setCOMENTARIO(String string) {
		COMENTARIO = string;
	}

	/**
	 * 
	 * @param date
	 */
	public void setFECHA(Date date) {
		FECHA = date;
	}

	/**
	 * 
	 * @param i
	 */
	public void setID(int i) {
		ID = i;
	}

	/**
	 * 
	 * @param i
	 */
	public void setID_INMUEBLE(int i) {
		ID_INMUEBLE = i;
	}

	/**
	 * 
	 * @param i
	 */
	public void setID_VENDEDOR(int i) {
		ID_VENDEDOR = i;
	}

	/**
	 * 
	 * @return
	 */
	public String getAPELLIDO_VENDEDOR() {
		return APELLIDO_VENDEDOR;
	}

	/**
	 * 
	 * @return
	 */
	public String getNOMBRE_VENDEDOR() {
		return NOMBRE_VENDEDOR;
	}

	/**
	 * 
	 * @param string
	 */
	public void setAPELLIDO_VENDEDOR(String string) {
		APELLIDO_VENDEDOR = string;
	}

	/**
	 * 
	 * @param string
	 */
	public void setNOMBRE_VENDEDOR(String string) {
		NOMBRE_VENDEDOR = string;
	}

}
