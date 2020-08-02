package com.emesa.gestinm.dao;

import java.util.*;
import com.emesa.bbdd.DBManager;
import net.seh.bbdd.AbstractDBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Fri Jul 18 19:43:12 CEST 2003
 */
public class FEL_NOTA_D
{
	//-- Atributos
	private int CODIGO=-1;
	private String MATERIALES;
	private String OBRAS;


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
	 * Devuelve MATERIALES
	 *
	 * @return MATERIALES
	 */
	public String getMATERIALES()
	{
		return this.MATERIALES;
	}

	/**
	 * Asigna MATERIALES
	 *
	 * @param unMATERIALES
	 */
	public void setMATERIALES(String unMATERIALES)
	{
		this.MATERIALES = unMATERIALES;
	}

	/**
	 * Devuelve OBRAS
	 *
	 * @return OBRAS
	 */
	public String getOBRAS()
	{
		return this.OBRAS;
	}

	/**
	 * Asigna OBRAS
	 *
	 * @param unOBRAS
	 */
	public void setOBRAS(String unOBRAS)
	{
		this.OBRAS = unOBRAS;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_NOTA_D
	*/
	public FEL_NOTA_D loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,MATERIALES,OBRAS FROM FEL_NOTA_D WHERE CODIGO=?");
		Vector vParams=new Vector();

		vParams.add(new Integer(nPK));
		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
			return null;
		}

		if(vRtado!=null && !vRtado.isEmpty()) {
			setElement( (Vector)vRtado.firstElement() );
		}

		 return this;
	}

    /**
     *
     * @param vRow
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            setCODIGO(Integer.parseInt(vRow.elementAt(0).toString().trim()) );
        if(vRow.elementAt(1)!=null)
            setMATERIALES(vRow.elementAt(1).toString().trim());
        if(vRow.elementAt(2)!=null)
            setOBRAS(vRow.elementAt(2).toString().trim());
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
			sSQL = new StringBuffer("INSERT INTO FEL_NOTA_D ");
			sSQL.append("(CODIGO,MATERIALES,OBRAS");
			sSQL.append(") VALUES (?,?,?)");

            vParams.add(new Integer(getCODIGO()));
            vParams.add(getMATERIALES());
            vParams.add(getOBRAS());
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_NOTA_D SET ");
			sSQL.append("MATERIALES=?");
            sSQL.append(", OBRAS=?");
			sSQL.append(" WHERE CODIGO=?");

            vParams.add(getMATERIALES());
            vParams.add(getOBRAS());
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
            String sql = "select CODIGO from FEL_NOTA_D where CODIGO="+getCODIGO();
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
		return "FEL_NOTA_D-[CODIGO="+getCODIGO()+",MATERIALES="+getMATERIALES()+",OBRAS="+getOBRAS()+"]";
	}
}
