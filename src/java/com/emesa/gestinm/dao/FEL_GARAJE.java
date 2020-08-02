package com.emesa.gestinm.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Wed Jul 23 16:40:56 CEST 2003
 */
public class FEL_GARAJE
{
	static Logger logger = Logger.getLogger(FEL_GARAJE.class);
	//-- Atributos
	private int CODIGO=-1;
	private int NUM_PLAZAS;
	private int VIGILANTE=0;


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
	 * Devuelve NUM_PLAZAS
	 *
	 * @return NUM_PLAZAS
	 */
	public int getNUM_PLAZAS()
	{
		return this.NUM_PLAZAS;
	}

	/**
	 * Asigna NUM_PLAZAS
	 *
	 * @param unNUM_PLAZAS
	 */
	public void setNUM_PLAZAS(int unNUM_PLAZAS)
	{
		this.NUM_PLAZAS = unNUM_PLAZAS;
	}

	/**
	 * Devuelve VIGILANTE
	 *
	 * @return VIGILANTE
	 */
	public int getVIGILANTE()
	{
		return this.VIGILANTE;
	}

	/**
	 * Asigna VIGILANTE
	 *
	 * @param unVIGILANTE
	 */
	public void setVIGILANTE(int unVIGILANTE)
	{
		this.VIGILANTE = unVIGILANTE;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_GARAJE
	*/
	public FEL_GARAJE loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,NUM_PLAZAS,VIGILANTE FROM FEL_GARAJE WHERE CODIGO=?");
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
				//-- Solo puede haber un rtado puesto que __PK__ es PK
				setElement( (Vector)vRtado.firstElement() );
		}

		return this;
	 }


	/**
     * @return <code>true</code> si ya existe un garaje con ese ID
     */
    public boolean exists() throws java.sql.SQLException {
        if(getCODIGO()==-1)
            return false;
        else {
            String sql = "select CODIGO from FEL_GARAJE where CODIGO="+getCODIGO();
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
     */
    public void setElement(Vector vRow)
    {
			if(vRow.elementAt(0)!=null)
				setCODIGO( Integer.parseInt(vRow.elementAt(0).toString().trim()) );
			if(vRow.elementAt(1)!=null)
				setNUM_PLAZAS( Integer.parseInt(vRow.elementAt(1).toString().trim()) );
			if(vRow.elementAt(2)!=null)
				setVIGILANTE( Integer.parseInt(vRow.elementAt(2).toString().trim()) );
	}

	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		if(getCODIGO()==-1)
            throw new java.sql.SQLException("Garaje sin código asociado");

		StringBuffer sSQL=null;
		boolean bExists=true;
		//-- Chequeamos a ver si es un objeto nuevo
		if(!exists()) {
            bExists=false; // ** TO DO **
			sSQL = new StringBuffer("INSERT INTO FEL_GARAJE ");
			sSQL.append("(CODIGO,NUM_PLAZAS,VIGILANTE");
			sSQL.append(") VALUES (?,?,?)");

		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_GARAJE SET ");
			sSQL.append(" NUM_PLAZAS=?");
			sSQL.append(", VIGILANTE=?");
			sSQL.append(" WHERE CODIGO=?");
		}

		Vector vParams=new Vector();
		if(!bExists)
            vParams.add( new Integer(getCODIGO()) );

		vParams.add( new Integer(getNUM_PLAZAS()) );
		vParams.add( new Integer(getVIGILANTE()) );
		if(bExists)
            vParams.add( new Integer(getCODIGO()) );

		AbstractDBManager dbm = DBManager.getInstance();
		dbm.executeUpdate(sSQL.toString(), vParams);
	}

	/**
     * Borra el registro de la BB.DD.
     *
     * @return n&uacute;mero de registros modificados
     */
    public static int delete(int nId) throws java.sql.SQLException{
        StringBuffer sSQL=new StringBuffer("delete from FEL_GARAJE where Codigo=?");
        Vector vParams=new Vector();

        vParams=new Vector();
        vParams.add(new Integer(nId));

        AbstractDBManager dbm = DBManager.getInstance();
        return dbm.executeUpdate(sSQL.toString(),vParams);
    }



}
