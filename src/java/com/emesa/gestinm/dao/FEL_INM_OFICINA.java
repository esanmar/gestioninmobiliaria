package com.emesa.gestinm.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 * 
 * @since Tue Jul 22 19:43:06 CEST 2003
 */
public class FEL_INM_OFICINA
{
	static Logger logger = Logger.getLogger(FEL_INM_OFICINA.class);
	//-- Atributos
	private int CODIGO=-1;
	private int ANTIGUEDAD;
	private int NUM_PLANTAS;
	private int DESPACHOS;
	private int BANOS;
	private int PREPARADO_OFICINA;
	private int TELEFONO;
	private int LUZ;
	private int ASCENSOR;
	private int PORTERO;
	private String CALEFACCION;
	private String AGUA_CALIENTE;
	private String GASTOS_COMUNIDAD;


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
	 * Devuelve ANTIGUEDAD
	 * 
	 * @return ANTIGUEDAD
	 */
	public int getANTIGUEDAD()
	{
		return this.ANTIGUEDAD;
	}

	/**
	 * Asigna ANTIGUEDAD
	 * 
	 * @param unANTIGUEDAD
	 */
	public void setANTIGUEDAD(int unANTIGUEDAD)
	{
		this.ANTIGUEDAD = unANTIGUEDAD;
	}

	/**
	 * Devuelve NUM_PLANTAS
	 * 
	 * @return NUM_PLANTAS
	 */
	public int getNUM_PLANTAS()
	{
		return this.NUM_PLANTAS;
	}

	/**
	 * Asigna NUM_PLANTAS
	 * 
	 * @param unNUM_PLANTAS
	 */
	public void setNUM_PLANTAS(int unNUM_PLANTAS)
	{
		this.NUM_PLANTAS = unNUM_PLANTAS;
	}

	/**
	 * Devuelve DESPACHOS
	 * 
	 * @return DESPACHOS
	 */
	public int getDESPACHOS()
	{
		return this.DESPACHOS;
	}

	/**
	 * Asigna DESPACHOS
	 * 
	 * @param unDESPACHOS
	 */
	public void setDESPACHOS(int unDESPACHOS)
	{
		this.DESPACHOS = unDESPACHOS;
	}

	/**
	 * Devuelve BANOS
	 * 
	 * @return BANOS
	 */
	public int getBANOS()
	{
		return this.BANOS;
	}

	/**
	 * Asigna BANOS
	 * 
	 * @param unBANOS
	 */
	public void setBANOS(int unBANOS)
	{
		this.BANOS = unBANOS;
	}

	/**
	 * Devuelve PREPARADO_OFICINA
	 * 
	 * @return PREPARADO_OFICINA
	 */
	public int getPREPARADO_OFICINA()
	{
		return this.PREPARADO_OFICINA;
	}

	/**
	 * Asigna PREPARADO_OFICINA
	 * 
	 * @param unPREPARADO_OFICINA
	 */
	public void setPREPARADO_OFICINA(int unPREPARADO_OFICINA)
	{
		this.PREPARADO_OFICINA = unPREPARADO_OFICINA;
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
	 * Devuelve LUZ
	 * 
	 * @return LUZ
	 */
	public int getLUZ()
	{
		return this.LUZ;
	}

	/**
	 * Asigna LUZ
	 * 
	 * @param unLUZ
	 */
	public void setLUZ(int unLUZ)
	{
		this.LUZ = unLUZ;
	}

	/**
	 * Devuelve ASCENSOR
	 * 
	 * @return ASCENSOR
	 */
	public int getASCENSOR()
	{
		return this.ASCENSOR;
	}

	/**
	 * Asigna ASCENSOR
	 * 
	 * @param unASCENSOR
	 */
	public void setASCENSOR(int unASCENSOR)
	{
		this.ASCENSOR = unASCENSOR;
	}

	/**
	 * Devuelve PORTERO
	 * 
	 * @return PORTERO
	 */
	public int getPORTERO()
	{
		return this.PORTERO;
	}

	/**
	 * Asigna PORTERO
	 * 
	 * @param unPORTERO
	 */
	public void setPORTERO(int unPORTERO)
	{
		this.PORTERO = unPORTERO;
	}

	/**
	 * Devuelve CALEFACCION
	 * 
	 * @return CALEFACCION
	 */
	public String getCALEFACCION()
	{
		return this.CALEFACCION;
	}

	/**
	 * Asigna CALEFACCION
	 * 
	 * @param unCALEFACCION
	 */
	public void setCALEFACCION(String unCALEFACCION)
	{
		this.CALEFACCION = unCALEFACCION;
	}

	/**
	 * Devuelve AGUA_CALIENTE
	 * 
	 * @return AGUA_CALIENTE
	 */
	public String getAGUA_CALIENTE()
	{
		return this.AGUA_CALIENTE;
	}

	/**
	 * Asigna AGUA_CALIENTE
	 * 
	 * @param unAGUA_CALIENTE
	 */
	public void setAGUA_CALIENTE(String unAGUA_CALIENTE)
	{
		this.AGUA_CALIENTE = unAGUA_CALIENTE;
	}

	/**
	 * Devuelve GASTOS_COMUNIDAD
	 * 
	 * @return GASTOS_COMUNIDAD
	 */
	public String getGASTOS_COMUNIDAD()
	{
		return this.GASTOS_COMUNIDAD;
	}

	/**
	 * Asigna GASTOS_COMUNIDAD
	 * 
	 * @param unGASTOS_COMUNIDAD
	 */
	public void setGASTOS_COMUNIDAD(String unGASTOS_COMUNIDAD)
	{
		this.GASTOS_COMUNIDAD = unGASTOS_COMUNIDAD;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_INM_OFICINA
	*/
	public FEL_INM_OFICINA loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,ANTIGUEDAD,NUM_PLANTAS,DESPACHOS,BANOS,PREPARADO_OFICINA,TELEFONO,LUZ,ASCENSOR,PORTERO,CALEFACCION,AGUA_CALIENTE,GASTOS_COMUNIDAD FROM FEL_INM_OFICINA WHERE CODIGO=?");
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
            String sql = "select CODIGO from FEL_INM_OFICINA where CODIGO="+getCODIGO();
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
				setANTIGUEDAD( Integer.parseInt(vRow.elementAt(1).toString().trim()) );
			if(vRow.elementAt(2)!=null)
				setNUM_PLANTAS( Integer.parseInt(vRow.elementAt(2).toString().trim()) );
			if(vRow.elementAt(3)!=null)
				setDESPACHOS( Integer.parseInt(vRow.elementAt(3).toString().trim()) );
			if(vRow.elementAt(4)!=null)
				setBANOS( Integer.parseInt(vRow.elementAt(4).toString().trim()) );
			if(vRow.elementAt(5)!=null)
				setPREPARADO_OFICINA( Integer.parseInt(vRow.elementAt(5).toString().trim()) );
			if(vRow.elementAt(6)!=null)
				setTELEFONO( Integer.parseInt(vRow.elementAt(6).toString().trim()) );
			if(vRow.elementAt(7)!=null)
				setLUZ( Integer.parseInt(vRow.elementAt(7).toString().trim()) );
			if(vRow.elementAt(8)!=null)
				setASCENSOR( Integer.parseInt(vRow.elementAt(8).toString().trim()) );
			if(vRow.elementAt(9)!=null)
				setPORTERO( Integer.parseInt(vRow.elementAt(9).toString().trim()) );
			if(vRow.elementAt(10)!=null)
				setCALEFACCION(vRow.elementAt(10).toString().trim());
			if(vRow.elementAt(11)!=null)
				setAGUA_CALIENTE(vRow.elementAt(11).toString().trim());
			if(vRow.elementAt(12)!=null)
				setGASTOS_COMUNIDAD(vRow.elementAt(12).toString().trim());
	}



	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		if(getCODIGO()==-1)
            throw new java.sql.SQLException("Oficina sin código asociado");

		StringBuffer sSQL=null;
		boolean bExists=true;
		//-- Chequeamos a ver si es un objeto nuevo
		if(!exists()) {
            bExists=false; // ** TO DO **
			sSQL = new StringBuffer("INSERT INTO FEL_INM_OFICINA ");
			sSQL.append("(CODIGO,ANTIGUEDAD,NUM_PLANTAS,DESPACHOS,BANOS,PREPARADO_OFICINA,TELEFONO,LUZ,ASCENSOR,PORTERO,CALEFACCION,AGUA_CALIENTE,GASTOS_COMUNIDAD");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_INM_OFICINA SET ");
			sSQL.append(" ANTIGUEDAD=?");
			sSQL.append(", NUM_PLANTAS=?");
			sSQL.append(", DESPACHOS=?");
			sSQL.append(", BANOS=?");
			sSQL.append(", PREPARADO_OFICINA=?");
			sSQL.append(", TELEFONO=?");
			sSQL.append(", LUZ=?");
			sSQL.append(", ASCENSOR=?");
			sSQL.append(", PORTERO=?");
			sSQL.append(", CALEFACCION=?");
			sSQL.append(", AGUA_CALIENTE=?");
			sSQL.append(", GASTOS_COMUNIDAD=?");
			sSQL.append(" WHERE CODIGO= ?");
		}
		
		Vector vParams=new Vector();
		if(!bExists)
            vParams.add( new Integer(getCODIGO()) );
            
		vParams.add( new Integer(getANTIGUEDAD()) );
		vParams.add( new Integer(getNUM_PLANTAS()) );
		vParams.add( new Integer(getDESPACHOS()) );
		vParams.add( new Integer(getBANOS()) );
		vParams.add( new Integer(getPREPARADO_OFICINA()) );
		vParams.add( new Integer(getTELEFONO()) );
		vParams.add( new Integer(getLUZ()) );
		vParams.add( new Integer(getASCENSOR()) );
		vParams.add( new Integer(getPORTERO()) );
		vParams.add(getCALEFACCION());
		vParams.add(getAGUA_CALIENTE());
		vParams.add(getGASTOS_COMUNIDAD());
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
        StringBuffer sSQL=new StringBuffer("delete from FEL_INM_OFICINA where Codigo=?");
        Vector vParams=new Vector();

        vParams=new Vector();
        vParams.add(new Integer(nId));

        AbstractDBManager dbm = DBManager.getInstance();
        return dbm.executeUpdate(sSQL.toString(),vParams);
    }


	
}
