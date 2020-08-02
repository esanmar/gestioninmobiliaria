package com.emesa.gestinm.dao;

import java.util.*;
import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;
import net.seh.bbdd.AbstractDBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Mon Jul 21 10:10:03 CEST 2003
 */
public class FEL_NOTA_F
{
    /** Logger */
    static Logger logger = Logger.getLogger(FEL_NOTA_E.class);
	//-- Atributos
	private int CODIGO=-1;
	private String COMUNICACIONES;
	private String EQUIP_COMERCIAL;


	//-- GETs y SETs
	/**
	 * Devuelve CODIGO
	 *
	 * @return CODIGO
	 */
	public int getCODIGO()
	{
		return this.CODIGO;
	}

	/**
	 * Asigna CODIGO
	 *
	 * @param unCODIGO
	 */
	public void setCODIGO(int unCODIGO)
	{
		this.CODIGO = unCODIGO;
	}

	/**
	 * Devuelve COMUNICACIONES
	 *
	 * @return COMUNICACIONES
	 */
	public String getCOMUNICACIONES()
	{
		return this.COMUNICACIONES;
	}

	/**
	 * Asigna COMUNICACIONES
	 *
	 * @param unCOMUNICACIONES
	 */
	public void setCOMUNICACIONES(String unCOMUNICACIONES)
	{
		this.COMUNICACIONES = unCOMUNICACIONES;
	}

	/**
	 * Devuelve EQUIP_COMERCIAL
	 *
	 * @return EQUIP_COMERCIAL
	 */
	public String getEQUIP_COMERCIAL()
	{
		return this.EQUIP_COMERCIAL;
	}

	/**
	 * Asigna EQUIP_COMERCIAL
	 *
	 * @param unEQUIP_COMERCIAL
	 */
	public void setEQUIP_COMERCIAL(String unEQUIP_COMERCIAL)
	{
		this.EQUIP_COMERCIAL = unEQUIP_COMERCIAL;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_NOTA_F
	*/
	public FEL_NOTA_F loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,COMUNICACIONES,EQUIP_COMERCIAL FROM FEL_NOTA_F WHERE CODIGO=?");
		Vector vParams=new Vector();

		vParams.add(new Integer(nPK));
		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
		}
		catch(Exception e) {
			logger.error("[loadFromDB] Error: "+e);
			return null;
		}

		if(vRtado!=null && !vRtado.isEmpty()) {
			//-- Solo puede haber un rtado puesto que CODIGO es PK
			setElement ( (Vector)vRtado.firstElement() );
		}

        return this;
	}


    /**
     * @return <code>true</code> si ya existe una nota con ese ID
     */
    public boolean exists() throws java.sql.SQLException {
        if(getCODIGO()==-1)
            return false;
        else {
            String sql = "select CODIGO from FEL_NOTA_F where CODIGO="+getCODIGO();
            AbstractDBManager dbm = DBManager.getInstance();
            Vector vRtado=dbm.executeQuery(sql);
            dbm.close();
            if(vRtado!=null && !vRtado.isEmpty())
                return true;
            else
                return false;
        }
    }

    /**
     * @param vRow
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            setCODIGO(Integer.parseInt(vRow.elementAt(0).toString().trim()));
        if(vRow.elementAt(1)!=null)
            setCOMUNICACIONES(vRow.elementAt(1).toString().trim());
        if(vRow.elementAt(2)!=null)
            setEQUIP_COMERCIAL(vRow.elementAt(2).toString().trim());
    }

	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams=new Vector();
		//-- Chequeamos a ver si es un objeto nuevo
		if(!exists()) {
			sSQL = new StringBuffer("INSERT INTO FEL_NOTA_F ");
			sSQL.append("(CODIGO,COMUNICACIONES,EQUIP_COMERCIAL");
			sSQL.append(") VALUES (?,?,?)");

            vParams.add(new Integer(getCODIGO()));
            vParams.add(getCOMUNICACIONES());
            vParams.add(getEQUIP_COMERCIAL());
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_NOTA_F SET ");
            sSQL.append("COMUNICACIONES=?");
			sSQL.append(", EQUIP_COMERCIAL=?");
			sSQL.append(" WHERE CODIGO=?");

            vParams.add(getCOMUNICACIONES());
            vParams.add(getEQUIP_COMERCIAL());
            vParams.add(new Integer(getCODIGO()));
		}

        AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(),vParams);
	}


	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "FEL_NOTA_F-[CODIGO="+getCODIGO()+",COMUNICACIONES="+getCOMUNICACIONES()+",EQUIP_COMERCIAL="+getEQUIP_COMERCIAL()+"]";
	}
}
