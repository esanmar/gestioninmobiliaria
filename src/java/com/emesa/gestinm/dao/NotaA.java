package com.emesa.gestinm.dao;

import java.util.*;
import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;
import net.seh.bbdd.AbstractDBManager;

/**
 * Las notas de tipo A o generales, est&aacute;n asociadas al igual que el resto con el inmueble,
 * pero en este caso, se encuentran en la misma tabla que el inmueble.
 */
public class NotaA
{
    /** Logger */
    static Logger logger = Logger.getLogger(NotaA.class);
    //-- Atributos
	private int CODIGO=-1;
	private String NOTAS;


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
     * Devuelve NOTAS
	 *
     * @return NOTAS
	 */
	public String getNOTAS()
	{
        return this.NOTAS;
	}

	/**
     * Asigna NOTAS
	 *
     * @param unNOTAS
	 */
    public void setNOTAS(String unNOTAS)
	{
        this.NOTAS = unNOTAS;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
    * @return Objeto NotaA
	*/
	public NotaA loadFromDB(int nPK)
	{
        StringBuffer sSQL=new StringBuffer("SELECT CODIGO,NOTAS FROM FEL_INMUEBLE WHERE CODIGO=?");
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
            setNOTAS(vRow.elementAt(1).toString().trim());
    }


	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	* Solo puede hacer un <code>update</code>
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams=new Vector();

		sSQL = new StringBuffer("UPDATE FEL_INMUEBLE SET ");
		sSQL.append("NOTAS=?");
		sSQL.append(" WHERE CODIGO=?");

        vParams.add(getNOTAS());
        vParams.add(new Integer(getCODIGO()));

		AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(),vParams);
	}


    /*
     * @return <code>true</code> si ya existe una nota con ese ID
     *
    public boolean exists() throws java.sql.SQLException {
        if(getCODIGO()==-1)
            return false;
        else {
            String sql = "select CODIGO from FEL_INMUEBLE where CODIGO="+getCODIGO();
            AbstractDBManager dbm = DBManager.getInstance();
            Vector vRtado=dbm.executeQuery(sql);
            dbm.close();
            if(vRtado!=null && !vRtado.isEmpty())
                return true;
            else
                return false;
        }
    }*/


	/** Representaci&oacute;n del objeto */
	public String toString()
	{
        return "NotaA-[CODIGO="+getCODIGO()+",NOTAS="+getNOTAS()+"]";
	}
}
