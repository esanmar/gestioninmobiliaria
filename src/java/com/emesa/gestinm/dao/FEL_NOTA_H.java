package com.emesa.gestinm.dao;

import java.util.*;
import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;
import net.seh.bbdd.AbstractDBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Mon Jul 21 11:43:36 CEST 2003
 */
public class FEL_NOTA_H
{
    /** Logger */
    static Logger logger = Logger.getLogger(FEL_NOTA_H.class);

	private int CODIGO=-1;
	private String FORMA_PAGO;
	private String NEGOCIABLE;
	private String NOT_PRECIO;


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
	 * Devuelve FORMA_PAGO
	 *
	 * @return FORMA_PAGO
	 */
	public String getFORMA_PAGO()
	{
		return this.FORMA_PAGO;
	}

	/**
	 * Asigna FORMA_PAGO
	 *
	 * @param unFORMA_PAGO
	 */
	public void setFORMA_PAGO(String unFORMA_PAGO)
	{
		this.FORMA_PAGO = unFORMA_PAGO;
	}

	/**
	 * Devuelve NEGOCIABLE
	 *
	 * @return NEGOCIABLE
	 */
	public String getNEGOCIABLE()
	{
		return this.NEGOCIABLE;
	}

	/**
	 * Asigna NEGOCIABLE
	 *
	 * @param unNEGOCIABLE
	 */
	public void setNEGOCIABLE(String unNEGOCIABLE)
	{
		this.NEGOCIABLE = unNEGOCIABLE;
	}

	/**
	 * Devuelve NOT_PRECIO
	 *
	 * @return NOT_PRECIO
	 */
	public String getNOT_PRECIO()
	{
		return this.NOT_PRECIO;
	}

	/**
	 * Asigna NOT_PRECIO
	 *
	 * @param unNOT_PRECIO
	 */
	public void setNOT_PRECIO(String unNOT_PRECIO)
	{
		this.NOT_PRECIO = unNOT_PRECIO;
	}


	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_NOTA_H
	*/
	public FEL_NOTA_H loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,FORMA_PAGO,NEGOCIABLE,NOT_PRECIO FROM FEL_NOTA_H WHERE CODIGO=?");
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
			setElement((Vector)vRtado.firstElement());
		}

        return this;
	}


    /**
     * @param vRow
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            setCODIGO(Integer.parseInt(vRow.elementAt(0).toString().trim()));
        if(vRow.elementAt(1)!=null)
            setFORMA_PAGO(vRow.elementAt(1).toString().trim());
        if(vRow.elementAt(2)!=null)
            setNEGOCIABLE(vRow.elementAt(2).toString().trim());
        if(vRow.elementAt(3)!=null)
		    setNOT_PRECIO(vRow.elementAt(3).toString().trim());
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
			sSQL = new StringBuffer("INSERT INTO FEL_NOTA_H ");
			sSQL.append("(CODIGO,FORMA_PAGO,NEGOCIABLE,NOT_PRECIO");
			sSQL.append(") VALUES (?,?,?,?)");

            vParams.add(new Integer(getCODIGO()));
            vParams.add(getFORMA_PAGO());
            vParams.add(getNEGOCIABLE());
            vParams.add(getNOT_PRECIO());
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_NOTA_H SET ");
			sSQL.append("FORMA_PAGO=?");
			sSQL.append(", NEGOCIABLE=?");
			sSQL.append(", NOT_PRECIO=?");
			sSQL.append(" WHERE CODIGO=?");

            vParams.add(getFORMA_PAGO());
            vParams.add(getNEGOCIABLE());
            vParams.add(getNOT_PRECIO());
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
            String sql = "select CODIGO from FEL_NOTA_H where CODIGO="+getCODIGO();
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
		return "FEL_NOTA_H-[CODIGO="+getCODIGO()+",FORMA_PAGO="+getFORMA_PAGO()+",NEGOCIABLE="+getNEGOCIABLE()+",NOT_PRECIO="+getNOT_PRECIO()+"]";
	}
}
