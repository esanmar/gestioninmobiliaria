/*
	-----------------------------------------
	Desarrollado por EMESA S.L.
	http://www.emesa.com
	
	$Id: FEL_NOTA_B.java,v 1.2 2004/03/12 17:06:31 swhite Exp $
	-----------------------------------------
	$Author: swhite $
	$Date: 2004/03/12 17:06:31 $
	-----------------------------------------
*/
package com.emesa.gestinm.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Fri Jul 18 13:49:53 CEST 2003
 */
public class FEL_NOTA_B
{
    private static final SimpleDateFormat sdfDB=new SimpleDateFormat(com.emesa.Configuration.getProperty("db.date_format"));
    private static final SimpleDateFormat sdfShow=new SimpleDateFormat(com.emesa.Configuration.getProperty("show.date_format"));

    /** Logger */
    static Logger logger = Logger.getLogger(FEL_NOTA_B.class);

	//-- Atributos
	private int CODIGO=-1;
	private String TASADOR;
	private java.util.Date FECHA_ENTRADA;
	private String CAPTACION;
	private String EXCLUSIVA;
	private String NO_EXCLUSIVA;
	private String CARTEL;
	private String MOTIVO_VENTA;


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
	 * Devuelve TASADOR
	 *
	 * @return TASADOR
	 */
	public String getTASADOR()
	{
		return this.TASADOR;
	}

	/**
	 * Asigna TASADOR
	 *
	 * @param unTASADOR
	 */
	public void setTASADOR(String unTASADOR)
	{
		this.TASADOR = unTASADOR;
	}

	/**
	 * Devuelve FECHA_ENTRADA
	 *
	 * @return FECHA_ENTRADA
	 */
	public Date getFECHA_ENTRADA()
	{
		return this.FECHA_ENTRADA;
	}

    /**
     * Devuelve FECHA_ENTRADA
     *
     * @return FECHA_ENTRADA
     */
    public String getShowFECHA_ENTRADA()
    {
        if(getFECHA_ENTRADA()!=null)
            return sdfShow.format(this.FECHA_ENTRADA);
        else
            return "";
    }

	/**
	 * Asigna FECHA_ENTRADA
	 *
	 * @param unFECHA_ENTRADA
	 */
	public void setFECHA_ENTRADA(Date unFECHA_ENTRADA)
	{
		this.FECHA_ENTRADA = unFECHA_ENTRADA;
	}

    /**
     * Asigna FECHA_ENTRADA
     *
     * @param unFECHA_ENTRADA con formato <code>show.date_format</code>
     */
    public void setFECHA_ENTRADA(String unFECHA_ENTRADA)
    {
        try {
            this.FECHA_ENTRADA = sdfShow.parse(unFECHA_ENTRADA);
        }
        catch(Exception e) {
            logger.warn("[setFECHA_ENTRADA] Error al formatear "+unFECHA_ENTRADA+": "+e);
        }
    }

	/**
	 * Devuelve CAPTACION
	 *
	 * @return CAPTACION
	 */
	public String getCAPTACION()
	{
		return this.CAPTACION;
	}

	/**
	 * Asigna CAPTACION
	 *
	 * @param unCAPTACION
	 */
	public void setCAPTACION(String unCAPTACION)
	{
		this.CAPTACION = unCAPTACION;
	}

	/**
	 * Devuelve EXCLUSIVA
	 *
	 * @return EXCLUSIVA
	 */
	public String getEXCLUSIVA()
	{
		return this.EXCLUSIVA;
	}

	/**
	 * Asigna EXCLUSIVA
	 *
	 * @param unEXCLUSIVA
	 */
	public void setEXCLUSIVA(String unEXCLUSIVA)
	{
		this.EXCLUSIVA = unEXCLUSIVA;
	}

	/**
	 * Devuelve NO_EXCLUSIVA
	 *
	 * @return NO_EXCLUSIVA
	 */
	public String getNO_EXCLUSIVA()
	{
		return this.NO_EXCLUSIVA;
	}

	/**
	 * Asigna NO_EXCLUSIVA
	 *
	 * @param unNO_EXCLUSIVA
	 */
	public void setNO_EXCLUSIVA(String unNO_EXCLUSIVA)
	{
		this.NO_EXCLUSIVA = unNO_EXCLUSIVA;
	}

	/**
	 * Devuelve CARTEL
	 *
	 * @return CARTEL
	 */
	public String getCARTEL()
	{
		return this.CARTEL;
	}

	/**
	 * Asigna CARTEL
	 *
	 * @param unCARTEL
	 */
	public void setCARTEL(String unCARTEL)
	{
		this.CARTEL = unCARTEL;
	}

	/**
	 * Devuelve MOTIVO_VENTA
	 *
	 * @return MOTIVO_VENTA
	 */
	public String getMOTIVO_VENTA()
	{
		return this.MOTIVO_VENTA;
	}

	/**
	 * Asigna MOTIVO_VENTA
	 *
	 * @param unMOTIVO_VENTA
	 */
	public void setMOTIVO_VENTA(String unMOTIVO_VENTA)
	{
		this.MOTIVO_VENTA = unMOTIVO_VENTA;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_NOTA_B
	*/
	public FEL_NOTA_B loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,TASADOR,FECHA_ENTRADA,CAPTACION,EXCLUSIVA,NO_EXCLUSIVA,CARTEL,MOTIVO_VENTA FROM FEL_NOTA_B WHERE CODIGO=?");
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
     *
     * @param Vector que representa un registro de la BB.DD.
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            setCODIGO(Integer.parseInt( vRow.elementAt(0).toString().trim()) );
        if(vRow.elementAt(1)!=null)
            setTASADOR(vRow.elementAt(1).toString().trim());

        if(vRow.elementAt(2)!=null) {
            try {
                setFECHA_ENTRADA(sdfDB.parse(vRow.elementAt(2).toString().trim()));
            }
            catch(Exception e) {
                logger.warn("[setElement] Error al parsear la fecha: "+e);
            }
        }

        if(vRow.elementAt(3)!=null)
            setCAPTACION(vRow.elementAt(3).toString().trim());
        if(vRow.elementAt(4)!=null)
            setEXCLUSIVA(vRow.elementAt(4).toString().trim());
        if(vRow.elementAt(5)!=null)
            setNO_EXCLUSIVA(vRow.elementAt(5).toString().trim());
        if(vRow.elementAt(6)!=null)
            setCARTEL(vRow.elementAt(6).toString().trim());
        if(vRow.elementAt(7)!=null)
            setMOTIVO_VENTA(vRow.elementAt(7).toString().trim());
    }


	/**
	 * Guarda la informaci&oacute;n del objeto en la tabla.
	 */
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
        Vector vParams = new Vector();

        if(!exists()) {
    		sSQL = new StringBuffer("INSERT INTO FEL_NOTA_B ");
    		sSQL.append("(CODIGO,TASADOR,FECHA_ENTRADA,CAPTACION,EXCLUSIVA,NO_EXCLUSIVA,CARTEL,MOTIVO_VENTA");
    		sSQL.append(") VALUES (?,?,?,?,?,?,?,?)");

            vParams.add(new Integer(getCODIGO()));
            vParams.add(getTASADOR());

            try {
                vParams.add(sdfDB.format(getFECHA_ENTRADA()));
            }
            catch(Exception e) {
                logger.warn("[saveToDB] Error al dar formato a la fecha: "+e);
                vParams.add(null);
            }

            vParams.add(getCAPTACION());
            vParams.add(getEXCLUSIVA());
            vParams.add(getNO_EXCLUSIVA());
            vParams.add(getCARTEL());
            vParams.add(getMOTIVO_VENTA());
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_NOTA_B SET ");
            sSQL.append("TASADOR=?");
            sSQL.append(", FECHA_ENTRADA=?");
            sSQL.append(", CAPTACION=?");
            sSQL.append(", EXCLUSIVA=?");
            sSQL.append(", NO_EXCLUSIVA=?");
            sSQL.append(", CARTEL=?");
			sSQL.append(", MOTIVO_VENTA=?");
			sSQL.append(" WHERE CODIGO=?");

            vParams.add(getTASADOR());

            try {
                vParams.add(sdfDB.format(getFECHA_ENTRADA()));
            }
            catch(Exception e) {
                logger.warn("[saveToDB] Error al dar formato a la fecha: "+e);
                vParams.add(null);
            }

            vParams.add(getCAPTACION());
            vParams.add(getEXCLUSIVA());
            vParams.add(getNO_EXCLUSIVA());
            vParams.add(getCARTEL());
            vParams.add(getMOTIVO_VENTA());

            vParams.add(new Integer(getCODIGO()));
		}

		AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(),vParams);
        dbm.close();
	}


    /**
     * @return <code>true</code> si ya existe una nota con ese ID
     */
    public boolean exists() throws java.sql.SQLException {
        if(getCODIGO()==-1)
            return false;
        else {
            String sql = "select CODIGO from FEL_NOTA_B where CODIGO="+getCODIGO();
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
		return "FEL_NOTA_B-[CODIGO="+getCODIGO()+",TASADOR="+getTASADOR()+",FECHA_ENTRADA="+getFECHA_ENTRADA()+",CAPTACION="+getCAPTACION()+",EXCLUSIVA="+getEXCLUSIVA()+",NO_EXCLUSIVA="+getNO_EXCLUSIVA()+",CARTEL="+getCARTEL()+",MOTIVO_VENTA="+getMOTIVO_VENTA()+"]";
	}
}

