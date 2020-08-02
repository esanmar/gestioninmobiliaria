package com.emesa.gestinm.dao;

import java.util.*;
// Not used: import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import net.seh.bbdd.AbstractDBManager;
import com.emesa.bbdd.DBManager;
//Not used: import com.emesa.Configuration;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 * 
 * @since Mon Feb 23 19:22:26 CET 2004
 */
public class FEL_CONSULTA
{
	//-- Atributos
	private int ID_CONSULTA=-1;
	private String NOMBRE;
	private String CONSULTA;
	private int ID_CLIENTE=-1;
	
	
	 /** Logger */
    static Logger logger = Logger.getLogger(FEL_CLIENTE.class);
    


	//-- GETs y SETs
	/**
	 * Devuelve ID_CONSULTA
	 * 
	 * @return ID_CONSULTA
	 */
	public int getID_CONSULTA()
	{
		return this.ID_CONSULTA;
	}

	/**
	 * Asigna ID_CONSULTA
	 * 
	 * @param unID_CONSULTA
	 */
	public void setID_CONSULTA(int unID_CONSULTA)
	{
		this.ID_CONSULTA = unID_CONSULTA;
	}

	/**
	 * Devuelve NOMBRE
	 * 
	 * @return NOMBRE
	 */
	public String getNOMBRE()
	{
		return this.NOMBRE;
	}

	/**
	 * Asigna NOMBRE
	 * 
	 * @param unNOMBRE
	 */
	public void setNOMBRE(String unNOMBRE)
	{
		this.NOMBRE = unNOMBRE;
	}

	/**
	 * Devuelve CONSULTA
	 * 
	 * @return CONSULTA
	 */
	public String getCONSULTA()
	{
		return this.CONSULTA;
	}

	/**
	 * Asigna CONSULTA
	 * 
	 * @param unCONSULTA
	 */
	public void setCONSULTA(String unCONSULTA)
	{
		this.CONSULTA = unCONSULTA;
	}

	/**
	 * Devuelve ID_CLIENTE
	 * 
	 * @return ID_CLIENTE
	 */
	public int getID_CLIENTE()
	{
		return this.ID_CLIENTE;
	}

	/**
	 * Asigna ID_CLIENTE
	 * 
	 * @param unID_CLIENTE
	 */
	public void setID_CLIENTE(int unID_CLIENTE)
	{
		this.ID_CLIENTE = unID_CLIENTE;
	}
	
	 /**
     * Carga del objeto desde un vector que representa un registro de la BB.DD.
     *
     * @param vRow
     */
    public void setElement(Vector vRow) {
    		if(vRow.elementAt(0)!=null)
				this.ID_CONSULTA = Integer.parseInt(vRow.elementAt(0).toString().trim());
			if(vRow.elementAt(1)!=null)
				this.NOMBRE = ((String)vRow.elementAt(1)).trim();
			if(vRow.elementAt(2)!=null)
				this.CONSULTA = ((String)vRow.elementAt(2)).trim();
			if(vRow.elementAt(3)!=null)
				this.ID_CLIENTE = Integer.parseInt(vRow.elementAt(3).toString().trim());
	}
    	

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto fel_consulta
	*/
	public FEL_CONSULTA loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT ID_CONSULTA,NOMBRE,CONSULTA,ID_CLIENTE FROM fel_consulta WHERE ID_CONSULTA=?");
		Vector vParams=new Vector();

		vParams.add(new Integer(nPK));
		Vector vRtado = new Vector();
		try {
			AbstractDBManager dbm = DBManager.getInstance();
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
			return null;
		}

	
		if(vRtado!=null && !vRtado.isEmpty()) {
            //-- Solo puede haber un rtado puesto que CID tiene que ser PK
            setElement( (Vector)vRtado.firstElement() );
        }

        return this;
    }


	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		//-- Chequeamos a ver si es un objeto nuevo
		Vector vParams=new Vector();
		if(getID_CONSULTA()==-1) { // ** TO DO **
			sSQL = new StringBuffer("INSERT INTO fel_consulta ");
			sSQL.append("(NOMBRE,CONSULTA,ID_CLIENTE");
			sSQL.append(") VALUES (?,?,?)");
			
			vParams=new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getCONSULTA());
            vParams.add(new Integer(getID_CLIENTE()));

		}
		else
		{
			sSQL = new StringBuffer("UPDATE fel_consulta SET ");
			sSQL.append(", NOMBRE=?");
			sSQL.append(", CONSULTA=?");
			sSQL.append(", ID_CLIENTE=?");
			sSQL.append(" WHERE ID_CONSULTA= ?");
			
			vParams=new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getCONSULTA());
            vParams.add(new Integer(getID_CLIENTE()));
			
		
		 AbstractDBManager dbm = DBManager.getInstance();
         dbm.executeUpdate(sSQL.toString(),vParams);
        
		}
	}


	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "fel_consulta-[ID_CONSULTA="+getID_CONSULTA()+",NOMBRE="+getNOMBRE()+",CONSULTA="+getCONSULTA()+",ID_CLIENTE="+getID_CLIENTE()+"]";
	}
}
