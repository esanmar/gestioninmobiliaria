/*
 * Created on 04-mar-2004
 * @author esanjurjo
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
/*
-----------------------------------------
Desarrollado por EMESA S.L.
http://www.emesa.com

$Id: FEL_LUNES.java,v 1.1 2004/03/25 15:20:55 esanjurjo Exp $
-----------------------------------------
$Author: esanjurjo $
$Date: 2004/03/25 15:20:55 $
-----------------------------------------
*/
package com.emesa.gestinm.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import net.seh.bbdd.AbstractDBManager;
import org.apache.log4j.Logger;

import com.emesa.Configuration;
import com.emesa.bbdd.DBManager;


/**
 * @author 
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FEL_LUNES {
	static Logger logger = Logger.getLogger(FEL_LUNES.class);
	
	private int ID_MENSAJE=-1;
	private int ID_USUARIO=-1;
	private Date FECHA_MENSAJE; //aaaa-mm-dd
	private String MENSAJE;
	private String NOMBRE_USUARIO;
	private String APELLIDO1_USUARIO;
	private String APELLIDO2_USUARIO;
	
	//private static final String SELECT_FROM = "SELECT ID_MENSAJE, ID_USUARIO, FECHA, MENSAJE FROM FEL_LUNES";
	private static final String SELECT_FROM = "SELECT FEL_LUNES.ID_MENSAJE, FEL_LUNES.ID_USUARIO, FEL_LUNES.FECHA, FEL_LUNES.MENSAJE, FEL_USUARIO.NOMBRE, FEL_USUARIO.APELLIDO1, FEL_USUARIO.APELLIDO2 FROM FEL_LUNES, FEL_USUARIO WHERE FEL_LUNES.ID_USUARIO =  FEL_USUARIO.ID_USUARIO ";
	private static final String SELECT_ORDER = " ORDER BY FEL_LUNES.FECHA DESC";
	
	final static SimpleDateFormat sdfBBDD=new SimpleDateFormat(Configuration.getProperty("db.date_time_format"));
	final static SimpleDateFormat sdfDBDate=new SimpleDateFormat(Configuration.getProperty("db.date_format"));

//	-- GETs y SETs
	/**
	 * Devuelve ID_MENSAJE
	 *
	 * @return ID_MENSAJE
	 */
	public int getID_MENSAJE()
	{
		return this.ID_MENSAJE;
	}
	/**
	 * Asigna ID_MENSAJE
	 *
	 * @param unID_MENSAJE
	 */
	public void setID_MENSAJE(int unID_MENSAJE)
	{
		this.ID_MENSAJE = unID_MENSAJE;
	}


	/**
	* Devuelve FECHA_MENSAJE
	*
	* @return FECHA_MENSAJE
	*/
	public Date getFECHA()
	{
  		return this.FECHA_MENSAJE;
	}
	/**
   	* Asigna FECHA_MENSAJE
   	*
   	* @param unFECHA
   	*/
  	public void setFECHA(Date unFECHA)
  	{
		this.FECHA_MENSAJE = unFECHA;
  	}


	/**
	 * Devuelve ID_USUARIO
	 *
	 * @return ID_USUARIO
	 */
	public int getID_USUARIO()
	{
		return this.ID_USUARIO;
	}
	/**
	 * Asigna ID_USUARIO
	 *
	 * @param unID_USUARIO
	 */
	public void setID_USUARIO(int unID_USUARIO)
	{
		this.ID_USUARIO = unID_USUARIO;
	}



	/**
	 * Devuelve MENSAJE
	 *
	 * @return MENSAJE
	 */
	public String getMENSAJE()
	{
		return this.MENSAJE;
	}
	/**
	 * Asigna MENSAJE
	 *
	 * @param unMENSAJE
	 */
	public void setMENSAJE(String unMENSAJE)
	{
		this.MENSAJE = unMENSAJE;
	}
	
	/**
	 * NOMBRE_USUARIO
	 * @return
	 */
	public String getNOMBRE_USUARIO()
	{
		return this.NOMBRE_USUARIO;
	}
	/**
	 * 
	 * @param unNOMBRE_USUARIO
	 */
	public void setNOMBRE_USUARIO(String unNOMBRE_USUARIO)
	{
		this.NOMBRE_USUARIO = unNOMBRE_USUARIO;
	}
	/**
	 * APELLIDO1
	 * @return
	 */
	public String getAPELLIDO1_USUARIO()
	{
		return this.APELLIDO1_USUARIO;
	}
	/**
	 * 
	 * @param unAPELLIDO1_USUARIO
	 */
	public void setAPELLIDO1_USUARIO(String unAPELLIDO1_USUARIO)
	{
		this.APELLIDO1_USUARIO = unAPELLIDO1_USUARIO;
	}


	/**
	 * APELLIDO2
	 * @return
	 */
	public String getAPELLIDO2_USUARIO()
	{
		return this.APELLIDO2_USUARIO;
	}
	/**
	 * 
	 * @param unAPELLIDO2_USUARIO
	 */
	public void setAPELLIDO2_USUARIO(String unAPELLIDO2_USUARIO)
	{
		this.APELLIDO2_USUARIO = unAPELLIDO2_USUARIO;
	}
	
	
	
	/**
	* 
	* Carga la informaci&oacute;n de la tabla en el objeto.
	* 
	* @return Objeto FEL_LUNES
	*/
	public Vector loadFromDB()
	{
		String SQL_STRING;
		SQL_STRING = SELECT_FROM + SELECT_ORDER;
		
		StringBuffer sSQL = new StringBuffer(SQL_STRING);

		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado = dbm.executeQuery(sSQL.toString());
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
			return null;
		}

		if(vRtado != null && !vRtado.isEmpty()) {
			Vector vLunes = new Vector();
			
			//Loop, add to vector and return vector
			for(int i = 0; i < vRtado.size() ; i++){
				vLunes.add(setElement( (Vector)vRtado.elementAt(i) ));
			}
			return vLunes;
			
		} else {
			return null;
		}
	 }

	/**
	 * Cargar solo un mansaje basado en su ID
	 * 
	 * @param iMessageId
	 * @return
	 */
	public FEL_LUNES loadFromDB(int iMessageId){
		String SQL_STRING;
		SQL_STRING = SELECT_FROM + " AND ID_MENSAJE=? " + SELECT_ORDER;
		
		Vector vParams = new Vector();
		vParams.add(new Integer(iMessageId));
		
		StringBuffer sSQL = new StringBuffer(SQL_STRING);

		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado = dbm.executeQuery(sSQL.toString(), vParams);
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
			return null;
		}

		if(vRtado != null && !vRtado.isEmpty()) {
			return setElement( (Vector)vRtado.firstElement() );
		} else {
			return null;
		}
	}

	/**
	 * Cargar los mansajes de una fecha
	 * 
	 * @param dFecha
	 * @return
	 */
	public Vector loadFromDB(Date dFecha){
		String SQL_STRING;
		SQL_STRING = SELECT_FROM + " AND FECHA LIKE ? " + SELECT_ORDER;
		
		Vector vParams = new Vector();
		vParams.add(sdfDBDate.format(dFecha)+"%");
		
		StringBuffer sSQL = new StringBuffer(SQL_STRING);

		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		
		try {
			vRtado = dbm.executeQuery(sSQL.toString(), vParams);
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
			return null;
		}

		if(vRtado != null && !vRtado.isEmpty()) {
			Vector vLunes = new Vector();
			
			//Loop, add to vector and return vector
			for(int i = 0; i < vRtado.size() ; i++){
				vLunes.add(setElement( (Vector)vRtado.elementAt(i) ));
			}
			return vLunes;
			
		} else {
			return new Vector();
		}
	}
	
	/**
	 * 
	 * @param dStartFecha
	 * @param dEndFecha
	 * @return
	 */
	public Vector loadFromDB(Date dStartFecha, Date dEndFecha){
			String SQL_STRING;
			SQL_STRING = SELECT_FROM + " AND FECHA > ? AND  FECHA <= ? " + SELECT_ORDER;
		
			Vector vParams = new Vector();
			vParams.add(sdfDBDate.format(dStartFecha)+" 00:00:00");
			vParams.add(sdfDBDate.format(dEndFecha)+" 00:00:00");
		
			StringBuffer sSQL = new StringBuffer(SQL_STRING);

			AbstractDBManager dbm = DBManager.getInstance();
			Vector vRtado = new Vector();

			try {
				vRtado = dbm.executeQuery(sSQL.toString(), vParams);
			}
			catch(Exception e) {
				//-- Tratamiento de la excepcion
				return null;
			}

			if(vRtado != null && !vRtado.isEmpty()) {
				Vector vLunes = new Vector();
			
				//Loop, add to vector and return vector
				for(int i = 0; i < vRtado.size() ; i++){
					vLunes.add(setElement( (Vector)vRtado.elementAt(i) ));
				}
				return vLunes;
			
			} else {
				return new Vector();
			}
		}
	
	
	
	/**
	 * Guarda la informaci&oacute;n del objeto en la tabla.
	 * 
	 * @throws java.sql.SQLException
	 */
	public void saveToDB() throws java.sql.SQLException
	{
		//if(getID_MENSAJE()==-1)
		//	throw new java.sql.SQLException("ID Mensaje no asginado");

		if(getID_USUARIO()==-1)
			throw new java.sql.SQLException("ID usuario no asginado");
					
		StringBuffer sSQL = null;
		
		sSQL = new StringBuffer("INSERT INTO FEL_LUNES ");
		sSQL.append("(ID_MENSAJE, ID_USUARIO, FECHA, MENSAJE");
		sSQL.append(") VALUES (?, ?, ?, ?)");

		Vector vParams = new Vector();

		vParams.add( new Integer(getID_MENSAJE()) );
		vParams.add( new Integer(getID_USUARIO()) );
		vParams.add( sdfBBDD.format(getFECHA()) );
		vParams.add( new String(getMENSAJE()) );

		AbstractDBManager dbm = DBManager.getInstance();
		dbm.executeUpdate(sSQL.toString(), vParams);
	}
		
		
	/**
	 * 
	 * Borra el registro de la BB.DD.
	 *
	 * @param nId
	 * @return n&uacute;mero de registros modificados
	 * @throws java.sql.SQLException
	 */
	public static int delete(int nId) throws java.sql.SQLException{
		String SQL_STRING;
		SQL_STRING = "DELETE FROM FEL_LUNES WHERE ID_MENSAJE=?";
		
		StringBuffer sSQL=new StringBuffer(SQL_STRING);
		Vector vParams = new Vector();
	
		vParams = new Vector();
		vParams.add(new Integer(nId));
	
		AbstractDBManager dbm = DBManager.getInstance();
		return dbm.executeUpdate(sSQL.toString(), vParams);
	}

		 
	/**
	 * setElement
	 * 
	 * @param vRow
	 * @return
	 */
	public FEL_LUNES setElement(Vector vRow)
	{
		FEL_LUNES objLUNES = new FEL_LUNES();
		
		if(vRow.elementAt(0)!=null)
			objLUNES.setID_MENSAJE( Integer.parseInt(vRow.elementAt(0).toString().trim()) );
		if(vRow.elementAt(1)!=null)
			objLUNES.setID_USUARIO( Integer.parseInt(vRow.elementAt(1).toString().trim()) );
		if(vRow.elementAt(2)!=null)
			try {
				objLUNES.setFECHA(sdfBBDD.parse(vRow.elementAt(2).toString().trim()) );
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(vRow.elementAt(3)!=null)
			objLUNES.setMENSAJE(vRow.elementAt(3).toString().trim());
		if(vRow.elementAt(4)!=null)
			objLUNES.setNOMBRE_USUARIO(vRow.elementAt(4).toString().trim());
		if(vRow.elementAt(5)!=null)
			objLUNES.setAPELLIDO1_USUARIO(vRow.elementAt(5).toString().trim());
		if(vRow.elementAt(6)!=null)
			objLUNES.setAPELLIDO2_USUARIO(vRow.elementAt(6).toString().trim());	
		
		return objLUNES;
	}
	
	/**
	 * 
	 */
	public String toString(){
		StringBuffer sTempString = null;
		
		sTempString = new StringBuffer("");
		sTempString.append("<FEL_LUNES>");
		sTempString.append("<ID_MENSAJE>" + getID_MENSAJE() + "</ID_MENSAJE>");
		sTempString.append("<ID_USUARIO>" + getID_USUARIO() + "</ID_USUARIO>");
		sTempString.append("<FECHA>" + getFECHA() + "</FECHA>");
		sTempString.append("<MENSAJE>" + getMENSAJE() + "</MENSAJE>");
		sTempString.append("</FEL_LUNES>");
		
		return sTempString.toString();
	}
}
