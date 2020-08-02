package com.emesa.gestinm.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;
/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 * 
 * @since Wed Jul 23 11:17:43 CEST 2003
 */
public class FEL_INM_NAVE
{
	static Logger logger = Logger.getLogger(FEL_INM_NAVE.class);
	//-- Atributos
	private int CODIGO=-1;
	private int SUP_NAVE;
	private String FUNCION_ACTUAL;
	private int SALIDA_GASES;
	private int SOTANO_ALMACEN;
	private int TELEFONO;
	private int OFICINA;
	private int AIRE_ACONDICIONADO;


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
	 * Devuelve SUP_NAVE
	 * 
	 * @return SUP_NAVE
	 */
	public int getSUP_NAVE()
	{
		return this.SUP_NAVE;
	}

	/**
	 * Asigna SUP_NAVE
	 * 
	 * @param unSUP_NAVE
	 */
	public void setSUP_NAVE(int unSUP_NAVE)
	{
		this.SUP_NAVE = unSUP_NAVE;
	}

	/**
	 * Devuelve FUNCION_ACTUAL
	 * 
	 * @return FUNCION_ACTUAL
	 */
	public String getFUNCION_ACTUAL()
	{
		return this.FUNCION_ACTUAL;
	}

	/**
	 * Asigna FUNCION_ACTUAL
	 * 
	 * @param unFUNCION_ACTUAL
	 */
	public void setFUNCION_ACTUAL(String unFUNCION_ACTUAL)
	{
		this.FUNCION_ACTUAL = unFUNCION_ACTUAL;
	}

	/**
	 * Devuelve SALIDA_GASES
	 * 
	 * @return SALIDA_GASES
	 */
	public int getSALIDA_GASES()
	{
		return this.SALIDA_GASES;
	}

	/**
	 * Asigna SALIDA_GASES
	 * 
	 * @param unSALIDA_GASES
	 */
	public void setSALIDA_GASES(int unSALIDA_GASES)
	{
		this.SALIDA_GASES = unSALIDA_GASES;
	}

	/**
	 * Devuelve SOTANO_ALMACEN
	 * 
	 * @return SOTANO_ALMACEN
	 */
	public int getSOTANO_ALMACEN()
	{
		return this.SOTANO_ALMACEN;
	}

	/**
	 * Asigna SOTANO_ALMACEN
	 * 
	 * @param unSOTANO_ALMACEN
	 */
	public void setSOTANO_ALMACEN(int unSOTANO_ALMACEN)
	{
		this.SOTANO_ALMACEN = unSOTANO_ALMACEN;
	}

	/**
	 * Devuelve TELEFONO
	 * 
	 * @return TELEFONO
	 */
	public int getTELEFONO()
	{
		return this.TELEFONO;
	}

	/**
	 * Asigna TELEFONO
	 * 
	 * @param unTELEFONO
	 */
	public void setTELEFONO(int unTELEFONO)
	{
		this.TELEFONO = unTELEFONO;
	}

	/**
	 * Devuelve OFICINA
	 * 
	 * @return OFICINA
	 */
	public int getOFICINA()
	{
		return this.OFICINA;
	}

	/**
	 * Asigna OFICINA
	 * 
	 * @param unOFICINA
	 */
	public void setOFICINA(int unOFICINA)
	{
		this.OFICINA = unOFICINA;
	}

	/**
	 * Devuelve AIRE_ACONDICIONADO
	 * 
	 * @return AIRE_ACONDICIONADO
	 */
	public int getAIRE_ACONDICIONADO()
	{
		return this.AIRE_ACONDICIONADO;
	}

	/**
	 * Asigna AIRE_ACONDICIONADO
	 * 
	 * @param unAIRE_ACONDICIONADO
	 */
	public void setAIRE_ACONDICIONADO(int unAIRE_ACONDICIONADO)
	{
		this.AIRE_ACONDICIONADO = unAIRE_ACONDICIONADO;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_INM_NAVE
	*/
	public FEL_INM_NAVE loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,SUP_NAVE,FUNCION_ACTUAL,SALIDA_GASES,SOTANO_ALMACEN,TELEFONO,OFICINA,AIRE_ACONDICIONADO FROM FEL_INM_NAVE WHERE CODIGO=?");
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
            String sql = "select CODIGO from FEL_INM_NAVE where CODIGO="+getCODIGO();
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
				setSUP_NAVE( Integer.parseInt(vRow.elementAt(1).toString().trim()) );
			if(vRow.elementAt(2)!=null)
				setFUNCION_ACTUAL(vRow.elementAt(2).toString().trim());
			if(vRow.elementAt(3)!=null)
				setSALIDA_GASES( Integer.parseInt(vRow.elementAt(3).toString().trim()) );
			if(vRow.elementAt(4)!=null)
				setSOTANO_ALMACEN( Integer.parseInt(vRow.elementAt(4).toString().trim()) );
			if(vRow.elementAt(5)!=null)
				setTELEFONO( Integer.parseInt(vRow.elementAt(5).toString().trim()) );
			if(vRow.elementAt(6)!=null)
				setOFICINA( Integer.parseInt(vRow.elementAt(6).toString().trim()) );
			if(vRow.elementAt(7)!=null)
				setAIRE_ACONDICIONADO( Integer.parseInt(vRow.elementAt(7).toString().trim()) );
	}



	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		if(getCODIGO()==-1)
            throw new java.sql.SQLException("Nave sin código asociado");

		StringBuffer sSQL=null;
		boolean bExists=true;
		//-- Chequeamos a ver si es un objeto nuevo
		if(!exists()) {
            bExists=false;
			sSQL = new StringBuffer("INSERT INTO FEL_INM_NAVE ");
			sSQL.append("(CODIGO,SUP_NAVE,FUNCION_ACTUAL,SALIDA_GASES,SOTANO_ALMACEN,TELEFONO,OFICINA,AIRE_ACONDICIONADO");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?)");
		
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_INM_NAVE SET ");
			sSQL.append(" SUP_NAVE=?");
			sSQL.append(", FUNCION_ACTUAL=?");
			sSQL.append(", SALIDA_GASES=?");
			sSQL.append(", SOTANO_ALMACEN=?");
			sSQL.append(", TELEFONO=?");
			sSQL.append(", OFICINA=?");
			sSQL.append(", AIRE_ACONDICIONADO=?");
			sSQL.append(" WHERE CODIGO=?");
		}
		
		Vector vParams=new Vector();
		if(!bExists)
            vParams.add( new Integer(getCODIGO()) );
            
		vParams.add( new Integer(getSUP_NAVE()) );
		vParams.add(getFUNCION_ACTUAL());
		vParams.add( new Integer(getSALIDA_GASES()) );
		vParams.add( new Integer(getSOTANO_ALMACEN()) );
		vParams.add( new Integer(getTELEFONO()) );
		vParams.add( new Integer(getOFICINA()) );
		vParams.add( new Integer(getAIRE_ACONDICIONADO()) );
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
        StringBuffer sSQL=new StringBuffer("delete from fel_inm_nave where Codigo=?");
        Vector vParams=new Vector();

        vParams=new Vector();
        vParams.add(new Integer(nId));

        AbstractDBManager dbm = DBManager.getInstance();
        return dbm.executeUpdate(sSQL.toString(),vParams);
    }


}
