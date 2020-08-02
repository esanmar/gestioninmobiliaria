package com.emesa.gestinm.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Wed Jul 16 16:56:44 CEST 2003
 */
public class FEL_PISO
{
	static Logger logger = Logger.getLogger(FEL_PISO.class);
	//-- Atributos

	private int CODIGO=-1;
	private int ANTIGUEDAD;
	private int ALTURA;
	private int HABITACIONES;
	private int DORMITORIOS;
	private int BANOS;
	private int AMUEBLADO;
	private int ASCENSOR;
	private int TRASTERO;
	private int GARAJE;
	private int PORTERO;
	private int PISCINA;
	private int AIRE_ACONDICIONADO;
	private String PRECIO_GARAJE;
	private String CALEFACCION;
	private String AGUA_CALIENTE;
	private String GASTOS_COMUNIDAD;
	private int ASEOS;
	private int COCINA_AMUEBLADA;
    private int EXTERIOR=0;
    private double TERRAZA=0.0;


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
	 * Devuelve ALTURA
	 *
	 * @return ALTURA
	 */
	public int getALTURA()
	{
		return this.ALTURA;
	}

	/**
	 * Asigna ALTURA
	 *
	 * @param unALTURA
	 */
	public void setALTURA(int unALTURA)
	{
		this.ALTURA = unALTURA;
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
	 * Devuelve TRASTERO
	 *
	 * @return TRASTERO
	 */
	public int getTRASTERO()
	{
		return this.TRASTERO;
	}

	/**
	 * Asigna TRASTERO
	 *
	 * @param unTRASTERO
	 */
	public void setTRASTERO(int unTRASTERO)
	{
		this.TRASTERO = unTRASTERO;
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
	 * Devuelve PRECIO_GARAJE
	 *
	 * @return PRECIO_GARAJE
	 */
	public String getPRECIO_GARAJE()
	{
		return this.PRECIO_GARAJE;
	}

	/**
	 * Asigna PRECIO_GARAJE
	 *
	 * @param unPRECIO_GARAJE
	 */
	public void setPRECIO_GARAJE(String unPRECIO_GARAJE)
	{
		this.PRECIO_GARAJE = unPRECIO_GARAJE;
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
     * Devuelve EXTERIOR
     *
     * @return EXTERIOR
     */
    public int getEXTERIOR()
    {
        return this.EXTERIOR;
    }

    /**
     * Asigna EXTERIOR
     *
     * @param unEXTERIOR
     */
    public void setEXTERIOR(int unEXTERIOR)
    {
        this.EXTERIOR = unEXTERIOR;
    }


    /**
     * Devuelve TERRAZA
     *
     * @return TERRAZA
     */
    public double getTERRAZA()
    {
        return this.TERRAZA;
    }

    /**
     * Asigna TERRAZA
     *
     * @param unTERRAZA
     */
    public void setTERRAZA(double unTERRAZA)
    {
        this.TERRAZA = unTERRAZA;
    }


	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto fel_piso
	*/
	public FEL_PISO loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT Codigo,Antiguedad,Altura,Habitaciones,Dormitorios,Banos,Amueblado,Ascensor,Trastero,Garaje,Portero,Piscina,Aire_acondicionado,Precio_garaje,Calefaccion,Agua_caliente,Gastos_comunidad,Aseos,Cocina_amueblada,EXTERIOR,TERRAZA FROM fel_piso WHERE Codigo=?");
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
			//-- Solo puede haber un rtado puesto que CODIGO es PK
			setElement( (Vector)vRtado.firstElement() );
		}

		return this;
	 }


	/**
	 * @param vRow Vector que representa un registro de la BB.DD.
     */
    public void setElement(Vector vRow)
    {
	   	if(vRow.elementAt(0)!=null)
			this.CODIGO =  Integer.parseInt( ((String)vRow.elementAt(0)).trim() );
		if(vRow.elementAt(1)!=null)
			this.ANTIGUEDAD = Integer.parseInt( ((String)vRow.elementAt(1)).trim() );
		if(vRow.elementAt(2)!=null)
			this.ALTURA = Integer.parseInt(((String)vRow.elementAt(2)).trim() );
		if(vRow.elementAt(3)!=null)
			this.HABITACIONES = Integer.parseInt( ((String)vRow.elementAt(3)).trim() );
		if(vRow.elementAt(4)!=null)
			this.DORMITORIOS = Integer.parseInt( ((String)vRow.elementAt(4)).trim() );
		if(vRow.elementAt(5)!=null)
			this.BANOS = Integer.parseInt( ((String)vRow.elementAt(5)).trim() );
		if(vRow.elementAt(6)!=null)
			this.AMUEBLADO = Integer.parseInt( ((String)vRow.elementAt(6)).trim() );
		if(vRow.elementAt(7)!=null)
			this.ASCENSOR = Integer.parseInt( ((String)vRow.elementAt(7)).trim() );
		if(vRow.elementAt(8)!=null)
			this.TRASTERO = Integer.parseInt( ((String)vRow.elementAt(8)).trim() );
		if(vRow.elementAt(9)!=null)
			this.GARAJE = Integer.parseInt( ((String)vRow.elementAt(9)).trim() );
		if(vRow.elementAt(10)!=null)
			this.PORTERO = Integer.parseInt( ((String)vRow.elementAt(10)).trim() );
		if(vRow.elementAt(11)!=null)
			this.PISCINA = Integer.parseInt( ((String)vRow.elementAt(11)).trim() );
		if(vRow.elementAt(12)!=null)
			this.AIRE_ACONDICIONADO = Integer.parseInt( ((String)vRow.elementAt(12)).trim() );
		if(vRow.elementAt(13)!=null)
			this.PRECIO_GARAJE = ((String)vRow.elementAt(13)).trim();
		if(vRow.elementAt(14)!=null)
			this.CALEFACCION = ((String)vRow.elementAt(14)).trim();
		if(vRow.elementAt(15)!=null)
			this.AGUA_CALIENTE = ((String)vRow.elementAt(15)).trim();
		if(vRow.elementAt(16)!=null)
			this.GASTOS_COMUNIDAD = ((String)vRow.elementAt(16)).trim();
		if(vRow.elementAt(17)!=null)
			this.ASEOS = Integer.parseInt( ((String)vRow.elementAt(17)).trim() );
		if(vRow.elementAt(18)!=null)
			this.COCINA_AMUEBLADA = Integer.parseInt( ((String)vRow.elementAt(18)).trim() );
        if(vRow.elementAt(19)!=null)
            this.EXTERIOR = Integer.parseInt( ((String)vRow.elementAt(19)).trim() );
        if(vRow.elementAt(20)!=null) {
            try {
                setTERRAZA(Double.parseDouble( ((String)vRow.elementAt(20)).trim() ));
            }
            catch(Exception e) {
                logger.warn("[setElement] Error al parsear TERRAZA: "+e);
            }
        }
	}


	/**
	 * Guarda la informaci&oacute;n del objeto en la tabla.
	 */
	public void saveToDB() throws java.sql.SQLException
	{
        if(getCODIGO()==-1)
            throw new java.sql.SQLException("Piso sin código asociado");

		StringBuffer sSQL=null;
		boolean bExists=true;
		//-- Chequeamos a ver si es un objeto nuevo
		if(!exists()) {
            bExists=false;
			sSQL = new StringBuffer("INSERT INTO fel_piso ");
			sSQL.append("(CODIGO,ANTIGUEDAD,ALTURA,HABITACIONES,DORMITORIOS,BANOS,AMUEBLADO,ASCENSOR,TRASTERO,GARAJE,PORTERO,PISCINA,AIRE_ACONDICIONADO,PRECIO_GARAJE,CALEFACCION,AGUA_CALIENTE,GASTOS_COMUNIDAD,ASEOS,COCINA_AMUEBLADA,EXTERIOR,TERRAZA");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		}
		else
		{
			sSQL = new StringBuffer("UPDATE fel_piso SET ");
            sSQL.append("ANTIGUEDAD=?");
            sSQL.append(", ALTURA=?");
            sSQL.append(", HABITACIONES=?");
            sSQL.append(", DORMITORIOS=?");
            sSQL.append(", BANOS=?");
            sSQL.append(", AMUEBLADO=?");
            sSQL.append(", ASCENSOR=?");
            sSQL.append(", TRASTERO=?");
            sSQL.append(", GARAJE=?");
            sSQL.append(", PORTERO=?");
            sSQL.append(", PISCINA=?");
            sSQL.append(", AIRE_ACONDICIONADO=?");
            sSQL.append(", PRECIO_GARAJE=?");
            sSQL.append(", CALEFACCION=?");
            sSQL.append(", AGUA_CALIENTE=?");
            sSQL.append(", GASTOS_COMUNIDAD=?");
            sSQL.append(", ASEOS=?");
            sSQL.append(", COCINA_AMUEBLADA=?");
            sSQL.append(", EXTERIOR=?");
            sSQL.append(", TERRAZA=?");
            sSQL.append(" WHERE CODIGO= ?");
		}

		Vector vParams=new Vector();

		if(!bExists)
            vParams.add( new Integer(getCODIGO()) );

		vParams.add( new Integer(getANTIGUEDAD()) );
		vParams.add( new Integer(getALTURA()) );
		vParams.add( new Integer(getHABITACIONES()) );
		vParams.add( new Integer(getDORMITORIOS()) );
		vParams.add( new Integer(getBANOS()) );
		vParams.add( new Integer(getAMUEBLADO()) );
		vParams.add( new Integer(getASCENSOR()) );
		vParams.add( new Integer(getTRASTERO()) );
		vParams.add( new Integer(getGARAJE()) );
		vParams.add( new Integer(getPORTERO()) );
		vParams.add( new Integer(getPISCINA()) );
		vParams.add( new Integer(getAIRE_ACONDICIONADO()) );
		vParams.add(getPRECIO_GARAJE());
		vParams.add(getCALEFACCION());
		vParams.add(getAGUA_CALIENTE());
		vParams.add(getGASTOS_COMUNIDAD());
		vParams.add( new Integer(getASEOS() ));
		vParams.add( new Integer(getCOCINA_AMUEBLADA()) );
        vParams.add( new Integer(getEXTERIOR()) );
        vParams.add( new Double(getTERRAZA()) );

		if(bExists)
            vParams.add( new Integer(getCODIGO()) );

		AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(), vParams);
        dbm.close();
	}


    /**
     * @return <code>true</code> si ya existe un piso con ese ID
     */
    public boolean exists() throws java.sql.SQLException {
        if(getCODIGO()==-1)
            return false;
        else {
            String sql = "select CODIGO from FEL_PISO where CODIGO="+getCODIGO();
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
     * Borra el registro de la BB.DD.
     *
     * @return n&uacute;mero de registros modificados
     */
    public static int delete(int nId) throws java.sql.SQLException{
        StringBuffer sSQL=new StringBuffer("delete from FEL_PISO where CODIGO=?");
        Vector vParams=new Vector();

        vParams=new Vector();
        vParams.add(new Integer(nId));

        AbstractDBManager dbm = DBManager.getInstance();
        return dbm.executeUpdate(sSQL.toString(),vParams);
    }

    /** Representaci&oacute;n del objeto */
    public String toString()
    {
        return "FEL_PISO-[Codigo="+getCODIGO()+",Antigüedad="+getANTIGUEDAD()+",Altura="+getALTURA()+",Habitaciones="+getHABITACIONES()+",Dormitorios="+getDORMITORIOS()+"...]";
    }
}