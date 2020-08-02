package com.emesa.gestinm.dao;

import java.util.*;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;
import net.seh.bbdd.AbstractDBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Fri Jul 18 19:01:05 CEST 2003
 */
public class FEL_NOTA_C
{
    /** Logger */
    static Logger logger = Logger.getLogger(FEL_NOTA_C.class);

	//-- Atributos
	private int CODIGO=-1;
	private String DIR_COMPLETA;
	private String GARAJE;
	private String TRASTERO;
	private String NOMBRE_APEL;
	private String DIR_Y_POBLACION;
	private String PERSONAS_TRATAR;
	private String TELEFONOS;
	private String VISITAS_PROPIETARIO;
	private String VISITAS_TASADOR;


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
	 * Devuelve DIR_COMPLETA
	 *
	 * @return DIR_COMPLETA
	 */
	public String getDIR_COMPLETA()
	{
		return this.DIR_COMPLETA;
	}

	/**
	 * Asigna DIR_COMPLETA
	 *
	 * @param unDIR_COMPLETA
	 */
	public void setDIR_COMPLETA(String unDIR_COMPLETA)
	{
		this.DIR_COMPLETA = unDIR_COMPLETA;
	}

	/**
	 * Devuelve GARAJE
	 *
	 * @return GARAJE
	 */
	public String getGARAJE()
	{
		return this.GARAJE;
	}

	/**
	 * Asigna GARAJE
	 *
	 * @param unGARAJE
	 */
	public void setGARAJE(String unGARAJE)
	{
		this.GARAJE = unGARAJE;
	}

	/**
	 * Devuelve TRASTERO
	 *
	 * @return TRASTERO
	 */
	public String getTRASTERO()
	{
		return this.TRASTERO;
	}

	/**
	 * Asigna TRASTERO
	 *
	 * @param unTRASTERO
	 */
	public void setTRASTERO(String unTRASTERO)
	{
		this.TRASTERO = unTRASTERO;
	}

	/**
	 * Devuelve NOMBRE_APEL
	 *
	 * @return NOMBRE_APEL
	 */
	public String getNOMBRE_APEL()
	{
		return this.NOMBRE_APEL;
	}

	/**
	 * Asigna NOMBRE_APEL
	 *
	 * @param unNOMBRE_APEL
	 */
	public void setNOMBRE_APEL(String unNOMBRE_APEL)
	{
		this.NOMBRE_APEL = unNOMBRE_APEL;
	}

	/**
	 * Devuelve DIR_Y_POBLACION
	 *
	 * @return DIR_Y_POBLACION
	 */
	public String getDIR_Y_POBLACION()
	{
		return this.DIR_Y_POBLACION;
	}

	/**
	 * Asigna DIR_Y_POBLACION
	 *
	 * @param unDIR_Y_POBLACION
	 */
	public void setDIR_Y_POBLACION(String unDIR_Y_POBLACION)
	{
		this.DIR_Y_POBLACION = unDIR_Y_POBLACION;
	}

	/**
	 * Devuelve PERSONAS_TRATAR
	 *
	 * @return PERSONAS_TRATAR
	 */
	public String getPERSONAS_TRATAR()
	{
		return this.PERSONAS_TRATAR;
	}

	/**
	 * Asigna PERSONAS_TRATAR
	 *
	 * @param unPERSONAS_TRATAR
	 */
	public void setPERSONAS_TRATAR(String unPERSONAS_TRATAR)
	{
		this.PERSONAS_TRATAR = unPERSONAS_TRATAR;
	}

	/**
	 * Devuelve TELEFONOS
	 *
	 * @return TELEFONOS
	 */
	public String getTELEFONOS()
	{
		return this.TELEFONOS;
	}

	/**
	 * Asigna TELEFONOS
	 *
	 * @param unTELEFONOS
	 */
	public void setTELEFONOS(String unTELEFONOS)
	{
		this.TELEFONOS = unTELEFONOS;
	}

	/**
	 * Devuelve VISITAS_PROPIETARIO
	 *
	 * @return VISITAS_PROPIETARIO
	 */
	public String getVISITAS_PROPIETARIO()
	{
		return this.VISITAS_PROPIETARIO;
	}

	/**
	 * Asigna VISITAS_PROPIETARIO
	 *
	 * @param unVISITAS_PROPIETARIO
	 */
	public void setVISITAS_PROPIETARIO(String unVISITAS_PROPIETARIO)
	{
		this.VISITAS_PROPIETARIO = unVISITAS_PROPIETARIO;
	}

	/**
	 * Devuelve VISITAS_TASADOR
	 *
	 * @return VISITAS_TASADOR
	 */
	public String getVISITAS_TASADOR()
	{
		return this.VISITAS_TASADOR;
	}

	/**
	 * Asigna VISITAS_TASADOR
	 *
	 * @param unVISITAS_TASADOR
	 */
	public void setVISITAS_TASADOR(String unVISITAS_TASADOR)
	{
		this.VISITAS_TASADOR = unVISITAS_TASADOR;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_NOTA_C
	*/
	public FEL_NOTA_C loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,DIR_COMPLETA,GARAJE,TRASTERO,NOMBRE_APEL,DIR_Y_POBLACION,PERSONAS_TRATAR,TELEFONOS,VISITAS_PROPIETARIO,VISITAS_TASADOR FROM FEL_NOTA_C WHERE CODIGO=?");
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
			//-- Solo puede haber un rtado puesto que CODIGO es PK
			setElement( (Vector)vRtado.firstElement() );
		}

        return this;
	}


    /**
     * @param vRow
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            setCODIGO(Integer.parseInt(vRow.elementAt(0).toString().trim()) );
        if(vRow.elementAt(1)!=null)
            setDIR_COMPLETA(vRow.elementAt(1).toString().trim());
        if(vRow.elementAt(2)!=null)
            setGARAJE(vRow.elementAt(2).toString().trim());
        if(vRow.elementAt(3)!=null)
            setTRASTERO(vRow.elementAt(3).toString().trim());
        if(vRow.elementAt(4)!=null)
            setNOMBRE_APEL(vRow.elementAt(4).toString().trim());
        if(vRow.elementAt(5)!=null)
            setDIR_Y_POBLACION(vRow.elementAt(5).toString().trim());
        if(vRow.elementAt(6)!=null)
            setPERSONAS_TRATAR(vRow.elementAt(6).toString().trim());
        if(vRow.elementAt(7)!=null)
            setTELEFONOS(vRow.elementAt(7).toString().trim());
        if(vRow.elementAt(8)!=null)
            setVISITAS_PROPIETARIO(vRow.elementAt(8).toString().trim());
        if(vRow.elementAt(9)!=null)
            setVISITAS_TASADOR(vRow.elementAt(9).toString().trim());
    }

	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams =new Vector();
		//-- Chequeamos a ver si es un objeto nuevo
		if(!exists()) {
			sSQL = new StringBuffer("INSERT INTO FEL_NOTA_C ");
			sSQL.append("(CODIGO,DIR_COMPLETA,GARAJE,TRASTERO,NOMBRE_APEL,DIR_Y_POBLACION,PERSONAS_TRATAR,TELEFONOS,VISITAS_PROPIETARIO,VISITAS_TASADOR");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?,?,?)");

            vParams.add(new Integer(getCODIGO()));
            vParams.add(getDIR_COMPLETA());
            vParams.add(getGARAJE());
            vParams.add(getTRASTERO());
            vParams.add(getNOMBRE_APEL());
            vParams.add(getDIR_Y_POBLACION());
            vParams.add(getPERSONAS_TRATAR());
            vParams.add(getTELEFONOS());
            vParams.add(getVISITAS_PROPIETARIO());
            vParams.add(getVISITAS_TASADOR());
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_NOTA_C SET ");
			sSQL.append("DIR_COMPLETA=?");
            sSQL.append(", GARAJE=?");
            sSQL.append(", TRASTERO=?");
            sSQL.append(", NOMBRE_APEL=?");
            sSQL.append(", DIR_Y_POBLACION=?");
            sSQL.append(", PERSONAS_TRATAR=?");
            sSQL.append(", TELEFONOS=?");
            sSQL.append(", VISITAS_PROPIETARIO=?");
            sSQL.append(", VISITAS_TASADOR=?");
			sSQL.append(" WHERE CODIGO=?");

            vParams.add(getDIR_COMPLETA());
            vParams.add(getGARAJE());
            vParams.add(getTRASTERO());
            vParams.add(getNOMBRE_APEL());
            vParams.add(getDIR_Y_POBLACION());
            vParams.add(getPERSONAS_TRATAR());
            vParams.add(getTELEFONOS());
            vParams.add(getVISITAS_PROPIETARIO());
            vParams.add(getVISITAS_TASADOR());

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
            String sql = "select CODIGO from FEL_NOTA_C where CODIGO="+getCODIGO();
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
		return "FEL_NOTA_C-[CODIGO="+getCODIGO()+",DIR_COMPLETA="+getDIR_COMPLETA()+",GARAJE="+getGARAJE()+",TRASTERO="+getTRASTERO()+",NOMBRE_APEL="+getNOMBRE_APEL()+",DIR_Y_POBLACION="+getDIR_Y_POBLACION()+",PERSONAS_TRATAR="+getPERSONAS_TRATAR()+",TELEFONOS="+getTELEFONOS()+",VISITAS_PROPIETARIO="+getVISITAS_PROPIETARIO()+",VISITAS_TASADOR="+getVISITAS_TASADOR()+"]";
	}
}
