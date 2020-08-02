package com.emesa.gestinm.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Mon Jul 21 12:05:22 CEST 2003
 */
public class FEL_NOTA_J
{
    /** Logger */
    static Logger logger = Logger.getLogger(FEL_NOTA_J.class);
    //-- Atributos
	private int CODIGO=-1;
	private String OTRAS_INM;


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
	 * Devuelve OTRAS_INM
	 *
	 * @return OTRAS_INM
	 */
	public String getOTRAS_INM()
	{
		return this.OTRAS_INM;
	}

	/**
	 * Asigna OTRAS_INM
	 *
	 * @param unOTRAS_INM
	 */
	public void setOTRAS_INM(String unOTRAS_INM)
	{
		this.OTRAS_INM = unOTRAS_INM;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_NOTA_J
	*/
	public FEL_NOTA_J loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,OTRAS_INM FROM FEL_NOTA_J WHERE CODIGO=?");
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
            setOTRAS_INM(vRow.elementAt(1).toString().trim());
    }

	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams= new Vector();
		//-- Chequeamos a ver si es un objeto nuevo
		if(!exists()) {
			sSQL = new StringBuffer("INSERT INTO FEL_NOTA_J ");
			sSQL.append("(CODIGO,OTRAS_INM");
			sSQL.append(") VALUES (?,?)");

            vParams.add(new Integer(getCODIGO()));
            vParams.add(getOTRAS_INM());
        }
		else {
			sSQL = new StringBuffer("UPDATE FEL_NOTA_J SET ");
			sSQL.append("OTRAS_INM=?");
			sSQL.append(" WHERE CODIGO=?");

            vParams.add(getOTRAS_INM());
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
            String sql = "select CODIGO from FEL_NOTA_J where CODIGO="+getCODIGO();
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
		return "FEL_NOTA_J-[CODIGO="+getCODIGO()+",OTRAS_INM="+getOTRAS_INM()+"]";
	}
}
