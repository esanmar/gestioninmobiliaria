package com.emesa.gestinm.dao;

import java.util.*;
import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;
import net.seh.bbdd.AbstractDBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Mon Jul 21 12:05:16 CEST 2003
 */
public class FEL_NOTA_I
{
    /** Logger */
    static Logger logger = Logger.getLogger(FEL_NOTA_I.class);
    //-- Atributos
	private int CODIGO=-1;
	private String DATOS_REGISTRALES;


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
	 * Devuelve DATOS_REGISTRALES
	 *
	 * @return DATOS_REGISTRALES
	 */
	public String getDATOS_REGISTRALES()
	{
		return this.DATOS_REGISTRALES;
	}

	/**
	 * Asigna DATOS_REGISTRALES
	 *
	 * @param unDATOS_REGISTRALES
	 */
	public void setDATOS_REGISTRALES(String unDATOS_REGISTRALES)
	{
		this.DATOS_REGISTRALES = unDATOS_REGISTRALES;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_NOTA_I
	*/
	public FEL_NOTA_I loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,DATOS_REGISTRALES FROM FEL_NOTA_I WHERE CODIGO=?");
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

		Vector vRow=null;
		if(vRtado!=null && !vRtado.isEmpty()) {
			setElement((Vector)vRtado.firstElement());
		}

        return this;
	}


    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            setCODIGO(Integer.parseInt(vRow.elementAt(0).toString().trim()));
        if(vRow.elementAt(1)!=null)
            setDATOS_REGISTRALES(vRow.elementAt(1).toString().trim());
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
			sSQL = new StringBuffer("INSERT INTO FEL_NOTA_I ");
			sSQL.append("(CODIGO,DATOS_REGISTRALES");
			sSQL.append(") VALUES (?,?)");

            vParams.add(new Integer(getCODIGO()));
            vParams.add(getDATOS_REGISTRALES());
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_NOTA_I SET ");
			sSQL.append("DATOS_REGISTRALES=?");
			sSQL.append(" WHERE CODIGO=?");

            vParams.add(getDATOS_REGISTRALES());
            vParams.add(new Integer(getCODIGO()));
		}

		AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(),vParams);
	}


    /**
     * @return <code>true</code> si ya existe una nota con ese ID
     */
    public boolean exists() throws java.sql.SQLException {
        if(getCODIGO()==-1)
            return false;
        else {
            String sql = "select CODIGO from FEL_NOTA_I where CODIGO="+getCODIGO();
            AbstractDBManager dbm = DBManager.getInstance();
            Vector vRtado=dbm.executeQuery(sql);
            dbm.close();
            if(vRtado!=null && !vRtado.isEmpty())
                return true;
            else
                return false;
        }
    }


	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "FEL_NOTA_I-[CODIGO="+getCODIGO()+",DATOS_REGISTRALES="+getDATOS_REGISTRALES()+"]";
	}
}
