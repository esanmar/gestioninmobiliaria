package com.emesa.gestinm.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Mon Jul 21 09:27:55 CEST 2003
 */
public class FEL_NOTA_E
{
    /** Logger */
    static Logger logger = Logger.getLogger(FEL_NOTA_E.class);
	//-- Atributos
	private int CODIGO=-1;
	private String ALTURA_REAL="";
	private String PISOS_PLANTA="";
	private String ZONA_COMUNITARIA="";
	private boolean LUZ=false;
	private String PORTERO="";
	private String ASCENSORES="";
    private String MEDIDAS="";
    private String MUEBLES="";


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
	 * Devuelve ALTURA_REAL
	 *
	 * @return ALTURA_REAL
	 */
	public String getALTURA_REAL()
	{
		return this.ALTURA_REAL;
	}

	/**
	 * Asigna ALTURA_REAL
	 *
	 * @param unALTURA_REAL
	 */
	public void setALTURA_REAL(String unALTURA_REAL)
	{
		this.ALTURA_REAL = unALTURA_REAL;
	}

	/**
	 * Devuelve PISOS_PLANTA
	 *
	 * @return PISOS_PLANTA
	 */
	public String getPISOS_PLANTA()
	{
		return this.PISOS_PLANTA;
	}

	/**
	 * Asigna PISOS_PLANTA
	 *
	 * @param unPISOS_PLANTA
	 */
	public void setPISOS_PLANTA(String unPISOS_PLANTA)
	{
		this.PISOS_PLANTA = unPISOS_PLANTA;
	}

	/**
	 * Devuelve ZONA_COMUNITARIA
	 *
	 * @return ZONA_COMUNITARIA
	 */
	public String getZONA_COMUNITARIA()
	{
		return this.ZONA_COMUNITARIA;
	}

	/**
	 * Asigna ZONA_COMUNITARIA
	 *
	 * @param unZONA_COMUNITARIA
	 */
	public void setZONA_COMUNITARIA(String unZONA_COMUNITARIA)
	{
		this.ZONA_COMUNITARIA = unZONA_COMUNITARIA;
	}

	/**
	 * Devuelve LUZ
	 *
	 * @return LUZ
	 */
	public boolean getLUZ()
	{
		return this.LUZ;
	}

	/**
	 * Asigna LUZ
	 *
	 * @param unLUZ
	 */
	public void setLUZ(boolean unLUZ)
	{
		this.LUZ = unLUZ;
	}

	/**
	 * Devuelve PORTERO
	 *
	 * @return PORTERO
	 */
	public String getPORTERO()
	{
		return this.PORTERO;
	}

	/**
	 * Asigna PORTERO
	 *
	 * @param unPORTERO
	 */
	public void setPORTERO(String unPORTERO)
	{
		this.PORTERO = unPORTERO;
	}

	/**
	 * Devuelve ASCENSORES
	 *
	 * @return ASCENSORES
	 */
	public String getASCENSORES()
	{
		return this.ASCENSORES;
	}

	/**
	 * Asigna ASCENSORES
	 *
	 * @param unASCENSORES
	 */
	public void setASCENSORES(String unASCENSORES)
	{
		this.ASCENSORES = unASCENSORES;
	}

    /**
     * Devuelve MEDIDAS
     *
     * @return MEDIDAS
     */
    public String getMEDIDAS()
    {
        return this.MEDIDAS;
    }

    /**
     * Asigna MEDIDAS
     *
     * @param unMEDIDAS
     */
    public void setMEDIDAS(String unMEDIDAS)
    {
        this.MEDIDAS = unMEDIDAS;
    }

    /**
     * Devuelve MUEBLES
     *
     * @return MUEBLES
     */
    public String getMUEBLES()
    {
        return this.MUEBLES;
    }

    /**
     * Asigna MUEBLES
     *
     * @param unMUEBLES
     */
    public void setMUEBLES(String unMUEBLES)
    {
        this.MUEBLES = unMUEBLES;
    }


	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_NOTA_E
	*/
	public FEL_NOTA_E loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,ALTURA_REAL,PISOS_PLANTA,ZONA_COMUNITARIA,LUZ,PORTERO,ASCENSORES,MEDIDAS,MUEBLES FROM FEL_NOTA_E WHERE CODIGO=?");
		Vector vParams=new Vector();

		vParams.add(new Integer(nPK));
		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
            logger.error("[loadFromDb] Error: "+e);
			return null;
		}

		if(vRtado!=null && !vRtado.isEmpty()) {
			setElement( (Vector)vRtado.firstElement() );
		}

        return this;
	}


    /**
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            setCODIGO(Integer.parseInt(vRow.elementAt(0).toString().trim()));
        if(vRow.elementAt(1)!=null)
            setALTURA_REAL(vRow.elementAt(1).toString().trim());
        if(vRow.elementAt(2)!=null)
            setPISOS_PLANTA(vRow.elementAt(2).toString().trim());
        if(vRow.elementAt(3)!=null)
            setZONA_COMUNITARIA(vRow.elementAt(3).toString().trim());

        setLUZ(false);
        if(vRow.elementAt(4)!=null) {
            if(vRow.elementAt(4).toString().trim().equals("1"))
                setLUZ(true);
            else
                setLUZ(false);
        }

        if(vRow.elementAt(5)!=null)
            setPORTERO(vRow.elementAt(5).toString().trim());
        if(vRow.elementAt(6)!=null)
            setASCENSORES(vRow.elementAt(6).toString().trim());
        if(vRow.elementAt(7)!=null)
            setMEDIDAS(vRow.elementAt(7).toString().trim());
        if(vRow.elementAt(8)!=null)
            setMUEBLES(vRow.elementAt(8).toString().trim());
    }

    /**
     * @return <code>true</code> si ya existe una nota con ese ID
     */
    public boolean exists() throws java.sql.SQLException {
        if(getCODIGO()==-1)
            return false;
        else {
            String sql = "select CODIGO from FEL_NOTA_E where CODIGO="+getCODIGO();
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
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
        Vector vParams=new Vector();
		//-- Chequeamos a ver si es un objeto nuevo
		if(!exists()) {
			sSQL = new StringBuffer("INSERT INTO FEL_NOTA_E ");
			sSQL.append("(CODIGO,ALTURA_REAL,PISOS_PLANTA,ZONA_COMUNITARIA,LUZ,PORTERO,ASCENSORES,MEDIDAS,MUEBLES");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?,?)");

            vParams.add(new Integer(getCODIGO()));
            vParams.add(getALTURA_REAL());
            vParams.add(getPISOS_PLANTA());
            vParams.add(getZONA_COMUNITARIA());
            vParams.add(new Boolean(getLUZ()));
            vParams.add(getPORTERO());
            vParams.add(getASCENSORES());
            vParams.add(getMEDIDAS());
            vParams.add(getMUEBLES());
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_NOTA_E SET ");
			sSQL.append("ALTURA_REAL=?");
			sSQL.append(", PISOS_PLANTA=?");
			sSQL.append(", ZONA_COMUNITARIA=?");
			sSQL.append(", LUZ=?");
			sSQL.append(", PORTERO=?");
			sSQL.append(", ASCENSORES=?");
            sSQL.append(", MEDIDAS=?");
            sSQL.append(", MUEBLES=?");
			sSQL.append(" WHERE CODIGO=?");

            vParams.add(getALTURA_REAL());
            vParams.add(getPISOS_PLANTA());
            vParams.add(getZONA_COMUNITARIA());
            vParams.add(new Boolean(getLUZ()));
            vParams.add(getPORTERO());
            vParams.add(getASCENSORES());
            vParams.add(getMEDIDAS());
            vParams.add(getMUEBLES());
            vParams.add(new Integer(getCODIGO()));
		}

		AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(),vParams);
	}


	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "FEL_NOTA_E-[CODIGO="+getCODIGO()+",ALTURA_REAL="+getALTURA_REAL()+",PISOS_PLANTA="+getPISOS_PLANTA()+",ZONA_COMUNITARIA="+getZONA_COMUNITARIA()+",LUZ="+getLUZ()+",PORTERO="+getPORTERO()+",ASCENSORES="+getASCENSORES()+"]";
	}
}
