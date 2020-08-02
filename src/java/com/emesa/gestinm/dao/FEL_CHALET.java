package com.emesa.gestinm.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Mon Jul 21 12:04:22 CEST 2003
 */
public class FEL_CHALET
{
	static Logger logger = Logger.getLogger(FEL_CHALET.class);
	//-- Atributos

	private int CODIGO=-1;
	private int ANTIGUEDAD;
	private int N_PLANTAS;
	private int HABITACIONES;
	private int DORMITORIOS;
	private int BANOS;
	private int ASEOS;
	private String CARPINTERIA_EXTERIOR;
	private String CARPINTERIA_INTERIOR;
	private String CALEFACCION;
	private String AGUA_CALIENTE;
	private String GASTOS_COMUNIDAD;
	private int AMUEBLADO;
	private int GARAJE;
	private int PISCINA;
	private int TELEFONO;
	private int AIRE_ACONDICIONADO;
	private int SUP_JARDIN;
	private int COCINA_AMUEBLADA;


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
	 * Devuelve N_PLANTAS
	 *
	 * @return N_PLANTAS
	 */
	public int getN_PLANTAS()
	{
		return this.N_PLANTAS;
	}

	/**
	 * Asigna N_PLANTAS
	 *
	 * @param unN_PLANTAS
	 */
	public void setN_PLANTAS(int unN_PLANTAS)
	{
		this.N_PLANTAS = unN_PLANTAS;
	}

	/**
	 * Devuelve HABITACIONES
	 *
	 * @return HABITACIONES
	 */
	public int getHABITACIONES()
	{
		return this.HABITACIONES;
	}

	/**
	 * Asigna HABITACIONES
	 *
	 * @param unHABITACIONES
	 */
	public void setHABITACIONES(int unHABITACIONES)
	{
		this.HABITACIONES = unHABITACIONES;
	}

	/**
	 * Devuelve DORMITORIOS
	 *
	 * @return DORMITORIOS
	 */
	public int getDORMITORIOS()
	{
		return this.DORMITORIOS;
	}

	/**
	 * Asigna DORMITORIOS
	 *
	 * @param unDORMITORIOS
	 */
	public void setDORMITORIOS(int unDORMITORIOS)
	{
		this.DORMITORIOS = unDORMITORIOS;
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
	 * Devuelve ASEOS
	 *
	 * @return ASEOS
	 */
	public int getASEOS()
	{
		return this.ASEOS;
	}

	/**
	 * Asigna ASEOS
	 *
	 * @param unASEOS
	 */
	public void setASEOS(int unASEOS)
	{
		this.ASEOS = unASEOS;
	}

	/**
	 * Devuelve CARPINTERIA_EXTERIOR
	 *
	 * @return CARPINTERIA_EXTERIOR
	 */
	public String getCARPINTERIA_EXTERIOR()
	{
		return this.CARPINTERIA_EXTERIOR;
	}

	/**
	 * Asigna CARPINTERIA_EXTERIOR
	 *
	 * @param unCARPINTERIA_EXTERIOR
	 */
	public void setCARPINTERIA_EXTERIOR(String unCARPINTERIA_EXTERIOR)
	{
		this.CARPINTERIA_EXTERIOR = unCARPINTERIA_EXTERIOR;
	}

	/**
	 * Devuelve CARPINTERIA_INTERIOR
	 *
	 * @return CARPINTERIA_INTERIOR
	 */
	public String getCARPINTERIA_INTERIOR()
	{
		return this.CARPINTERIA_INTERIOR;
	}

	/**
	 * Asigna CARPINTERIA_INTERIOR
	 *
	 * @param unCARPINTERIA_INTERIOR
	 */
	public void setCARPINTERIA_INTERIOR(String unCARPINTERIA_INTERIOR)
	{
		this.CARPINTERIA_INTERIOR = unCARPINTERIA_INTERIOR;
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
	 * Devuelve AMUEBLADO
	 *
	 * @return AMUEBLADO
	 */
	public int getAMUEBLADO()
	{
		return this.AMUEBLADO;
	}

	/**
	 * Asigna AMUEBLADO
	 *
	 * @param unAMUEBLADO
	 */
	public void setAMUEBLADO(int unAMUEBLADO)
	{
		this.AMUEBLADO = unAMUEBLADO;
	}

	/**
	 * Devuelve GARAJE
	 *
	 * @return GARAJE
	 */
	public int getGARAJE()
	{
		return this.GARAJE;
	}

	/**
	 * Asigna GARAJE
	 *
	 * @param unGARAJE
	 */
	public void setGARAJE(int unGARAJE)
	{
		this.GARAJE = unGARAJE;
	}

	/**
	 * Devuelve PISCINA
	 *
	 * @return PISCINA
	 */
	public int getPISCINA()
	{
		return this.PISCINA;
	}

	/**
	 * Asigna PISCINA
	 *
	 * @param unPISCINA
	 */
	public void setPISCINA(int unPISCINA)
	{
		this.PISCINA = unPISCINA;
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
	 * Devuelve SUP_JARDIN
	 *
	 * @return SUP_JARDIN
	 */
	public int getSUP_JARDIN()
	{
		return this.SUP_JARDIN;
	}

	/**
	 * Asigna SUP_JARDIN
	 *
	 * @param unSUP_JARDIN
	 */
	public void setSUP_JARDIN(int unSUP_JARDIN)
	{
		this.SUP_JARDIN = unSUP_JARDIN;
	}

	/**
	 * Devuelve COCINA_AMUEBLADA
	 *
	 * @return COCINA_AMUEBLADA
	 */
	public int getCOCINA_AMUEBLADA()
	{
		return this.COCINA_AMUEBLADA;
	}

	/**
	 * Asigna COCINA_AMUEBLADA
	 *
	 * @param unCOCINA_AMUEBLADA
	 */
	public void setCOCINA_AMUEBLADA(int unCOCINA_AMUEBLADA)
	{
		this.COCINA_AMUEBLADA = unCOCINA_AMUEBLADA;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_CHALET
	*/
	public FEL_CHALET loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,ANTIGUEDAD,N_PLANTAS,HABITACIONES,DORMITORIOS,BANOS,ASEOS,CARPINTERIA_EXTERIOR,CARPINTERIA_INTERIOR,CALEFACCION,AGUA_CALIENTE,GASTOS_COMUNIDAD,AMUEBLADO,GARAJE,PISCINA,TELEFONO,AIRE_ACONDICIONADO,SUP_JARDIN,COCINA_AMUEBLADA FROM FEL_CHALET WHERE CODIGO=?");
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
            String sql = "select CODIGO from FEL_CHALET where CODIGO="+getCODIGO();
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
			setN_PLANTAS( Integer.parseInt(vRow.elementAt(2).toString().trim()) );
		if(vRow.elementAt(3)!=null)
			setHABITACIONES( Integer.parseInt(vRow.elementAt(3).toString().trim()) );
		if(vRow.elementAt(4)!=null)
			setDORMITORIOS( Integer.parseInt(vRow.elementAt(4).toString().trim()) );
		if(vRow.elementAt(5)!=null)
			setBANOS( Integer.parseInt(vRow.elementAt(5).toString().trim()) );
		if(vRow.elementAt(6)!=null)
			setASEOS( Integer.parseInt(vRow.elementAt(6).toString().trim()) );
		if(vRow.elementAt(7)!=null)
			setCARPINTERIA_EXTERIOR(vRow.elementAt(7).toString().trim());
		if(vRow.elementAt(8)!=null)
			setCARPINTERIA_INTERIOR(vRow.elementAt(8).toString().trim());
		if(vRow.elementAt(9)!=null)
			setCALEFACCION(vRow.elementAt(9).toString().trim());
		if(vRow.elementAt(10)!=null)
			setAGUA_CALIENTE(vRow.elementAt(10).toString().trim());
		if(vRow.elementAt(11)!=null)
			setGASTOS_COMUNIDAD(vRow.elementAt(11).toString().trim());
		if(vRow.elementAt(12)!=null)
			setAMUEBLADO( Integer.parseInt(vRow.elementAt(12).toString().trim()) );
		if(vRow.elementAt(13)!=null)
			setGARAJE( Integer.parseInt(vRow.elementAt(13).toString().trim()) );
		if(vRow.elementAt(14)!=null)
			setPISCINA( Integer.parseInt(vRow.elementAt(14).toString().trim()) );
		if(vRow.elementAt(15)!=null)
			setTELEFONO( Integer.parseInt(vRow.elementAt(15).toString().trim()) );
		if(vRow.elementAt(16)!=null)
			setAIRE_ACONDICIONADO( Integer.parseInt(vRow.elementAt(16).toString().trim()) );
		if(vRow.elementAt(17)!=null)
			setSUP_JARDIN( Integer.parseInt(vRow.elementAt(17).toString().trim()) );
		if(vRow.elementAt(18)!=null)
			setCOCINA_AMUEBLADA( Integer.parseInt(vRow.elementAt(18).toString().trim()) );

	}


	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		if(getCODIGO()==-1)
            throw new java.sql.SQLException("Chalet sin código asociado");

		StringBuffer sSQL=null;
		boolean bExists=true;
		//-- Chequeamos a ver si es un objeto nuevo
		if(!exists()) {
            bExists=false;
			sSQL = new StringBuffer("INSERT INTO FEL_CHALET ");
			sSQL.append("(CODIGO,ANTIGUEDAD,N_PLANTAS,HABITACIONES,DORMITORIOS,BANOS,ASEOS,CARPINTERIA_EXTERIOR,CARPINTERIA_INTERIOR,CALEFACCION,AGUA_CALIENTE,GASTOS_COMUNIDAD,AMUEBLADO,GARAJE,PISCINA,TELEFONO,AIRE_ACONDICIONADO,SUP_JARDIN,COCINA_AMUEBLADA");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		}
		else
		{
			sSQL = new StringBuffer("UPDATE FEL_CHALET SET ");
			sSQL.append("ANTIGUEDAD=?");
			sSQL.append(", N_PLANTAS=?");
			sSQL.append(", HABITACIONES=?");
			sSQL.append(", DORMITORIOS=?");
			sSQL.append(", BANOS=?");
			sSQL.append(", ASEOS=?");
			sSQL.append(", CARPINTERIA_EXTERIOR=?");
			sSQL.append(", CARPINTERIA_INTERIOR=?");
			sSQL.append(", CALEFACCION=?");
			sSQL.append(", AGUA_CALIENTE=?");
			sSQL.append(", GASTOS_COMUNIDAD=?");
			sSQL.append(", AMUEBLADO=?");
			sSQL.append(", GARAJE=?");
			sSQL.append(", PISCINA=?");
			sSQL.append(", TELEFONO=?");
			sSQL.append(", AIRE_ACONDICIONADO=?");
			sSQL.append(", SUP_JARDIN=?");
			sSQL.append(", COCINA_AMUEBLADA=?");
			sSQL.append(" WHERE CODIGO= ?");
		}

		Vector vParams=new Vector();
		if(!bExists)
            vParams.add( new Integer(getCODIGO()) );

		vParams.add( new Integer(getANTIGUEDAD()) );
		vParams.add( new Integer(getN_PLANTAS()) );
		vParams.add( new Integer(getHABITACIONES()) );
		vParams.add( new Integer(getDORMITORIOS()) );
		vParams.add( new Integer(getBANOS()) );
		vParams.add( new Integer(getASEOS()) );
		vParams.add( getCARPINTERIA_EXTERIOR() );
		vParams.add( getCARPINTERIA_INTERIOR() );
		vParams.add(getCALEFACCION());
		vParams.add(getAGUA_CALIENTE());
		vParams.add(getGASTOS_COMUNIDAD());
		vParams.add( new Integer(getAMUEBLADO()) );
		vParams.add( new Integer(getGARAJE()) );
		vParams.add( new Integer(getPISCINA()) );
		vParams.add( new Integer(getTELEFONO()) );
		vParams.add( new Integer(getAIRE_ACONDICIONADO()) );
		vParams.add( new Integer(getSUP_JARDIN() ));
		vParams.add( new Integer(getCOCINA_AMUEBLADA()) );

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
        StringBuffer sSQL=new StringBuffer("delete from FEL_CHALET where Codigo=?");
        Vector vParams=new Vector();

        vParams=new Vector();
        vParams.add(new Integer(nId));

        AbstractDBManager dbm = DBManager.getInstance();
        return dbm.executeUpdate(sSQL.toString(),vParams);
    }

    /** Representaci&oacute;n del objeto */
    public String toString()
    {
        return "FEL_CHALET-[CODIGO="+getCODIGO()+",ANTIGUEDAD="+getANTIGUEDAD()+",N_PLANTAS="+getN_PLANTAS()+",HABITACIONES="+getHABITACIONES()+",DORMITORIOS="+getDORMITORIOS()+",BANOS="+getBANOS()+",ASEOS="+getASEOS()+",CARPINTERIA_EXTERIOR="+getCARPINTERIA_EXTERIOR()+",CARPINTERIA_INTERIOR="+getCARPINTERIA_INTERIOR()+",CALEFACCION="+getCALEFACCION()+",AGUA_CALIENTE="+getAGUA_CALIENTE()+",GASTOS_COMUNIDAD="+getGASTOS_COMUNIDAD()+",AMUEBLADO="+getAMUEBLADO()+",GARAJE="+getGARAJE()+",PISCINA="+getPISCINA()+",TELEFONO="+getTELEFONO()+",AIRE_ACONDICIONADO="+getAIRE_ACONDICIONADO()+",SUP_JARDIN="+getSUP_JARDIN()+",COCINA_AMUEBLADA="+getCOCINA_AMUEBLADA()+"]";
    }
}
