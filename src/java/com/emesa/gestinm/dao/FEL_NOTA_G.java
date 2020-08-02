package com.emesa.gestinm.dao;

import java.util.*;
import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;
import net.seh.bbdd.AbstractDBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Mon Jul 21 10:30:51 CEST 2003
 */
public class FEL_NOTA_G
{
    /** Logger */
    static Logger logger = Logger.getLogger(FEL_NOTA_G.class);
	//-- Atributos
	private int CODIGO=-1;
	private String DEST_PROPIETARIO;
	private String DEST_TASADOR;


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
	 * Devuelve DEST_PROPIETARIO
	 *
	 * @return DEST_PROPIETARIO
	 */
	public String getDEST_PROPIETARIO()
	{
		return this.DEST_PROPIETARIO;
	}

	/**
	 * Asigna DEST_PROPIETARIO
	 *
	 * @param unDEST_PROPIETARIO
	 */
	public void setDEST_PROPIETARIO(String unDEST_PROPIETARIO)
	{
		this.DEST_PROPIETARIO = unDEST_PROPIETARIO;
	}

	/**
	 * Devuelve DEST_TASADOR
	 *
	 * @return DEST_TASADOR
	 */
	public String getDEST_TASADOR()
	{
		return this.DEST_TASADOR;
	}

	/**
	 * Asigna DEST_TASADOR
	 *
	 * @param unDEST_TASADOR
	 */
	public void setDEST_TASADOR(String unDEST_TASADOR)
	{
		this.DEST_TASADOR = unDEST_TASADOR;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_NOTA_G
	*/
	public FEL_NOTA_G loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,DEST_PROPIETARIO,DEST_TASADOR FROM FEL_NOTA_G WHERE CODIGO=?");
		Vector vParams=new Vector();

		vParams.add(new Integer(nPK));
		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
            logger.error("[loadFromDB] Error: "+e);
			return null;
		}

		if(vRtado!=null && !vRtado.isEmpty()) {
			setElement( (Vector)vRtado.firstElement() );
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
            setDEST_PROPIETARIO(vRow.elementAt(1).toString().trim());
        if(vRow.elementAt(2)!=null)
            setDEST_TASADOR(vRow.elementAt(2).toString().trim());
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
			sSQL = new StringBuffer("INSERT INTO FEL_NOTA_G ");
			sSQL.append("(CODIGO,DEST_PROPIETARIO,DEST_TASADOR");
			sSQL.append(") VALUES (?,?,?)");

            vParams.add(new Integer(getCODIGO()));
            vParams.add(getDEST_PROPIETARIO());
            vParams.add(getDEST_TASADOR());
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_NOTA_G SET ");
			sSQL.append("DEST_PROPIETARIO=?");
			sSQL.append(", DEST_TASADOR=?");
			sSQL.append(" WHERE CODIGO=?");

            vParams.add(getDEST_PROPIETARIO());
            vParams.add(getDEST_TASADOR());
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
            String sql = "select CODIGO from FEL_NOTA_G where CODIGO="+getCODIGO();
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
		return "FEL_NOTA_G-[CODIGO="+getCODIGO()+",DEST_PROPIETARIO="+getDEST_PROPIETARIO()+",DEST_TASADOR="+getDEST_TASADOR()+"]";
	}
}
