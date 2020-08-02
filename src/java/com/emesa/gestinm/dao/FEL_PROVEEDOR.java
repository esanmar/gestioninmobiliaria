package com.emesa.gestinm.dao;

import java.util.*;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import net.seh.bbdd.AbstractDBManager;
import com.emesa.bbdd.DBManager;
import com.emesa.Configuration;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Mon Jul 07 19:30:43 CEST 2003
 */
public class FEL_PROVEEDOR
{
    /** Logger */
    static Logger logger = Logger.getLogger(FEL_PROVEEDOR.class);

	//-- Atributos
	private int ID_PROPIETARIO=-1;
	private String CIF;
	private String RAZON_SOCIAL="";
	private String NOMBRE_COMERCIAL="";
	private String DOMICILIO;
	private String POBLACION;
	private int ID_PROVINCIA=-1;
	private int ID_PAIS=-1;
	private String TELEFONO;
	private String TELEFONO2;
	private String FAX;
	private String ESTADO_CIVIL;
	private java.util.Date FECHA_ALTA;
	private String PERSONA_CONTACTO;
	private int CP;
    private String CONTACTO_APEL1="";
    private String CONTACTO_APEL2;

    private final static String SELECT_PROV="SELECT ID_PROPIETARIO,CIF,RAZON_SOCIAL,NOMBRE_COMERCIAL,DOMICILIO,POBLACION,ID_PROVINCIA,ID_PAIS,TELEFONO,TELEFONO2,FAX,ESTADO_CIVIL,FECHA_ALTA,PERSONA_CONTACTO,CP,CONTACTO_APEL1,CONTACTO_APEL2 FROM FEL_PROVEEDOR";
    // Formato de las fechas...
    final static SimpleDateFormat sdfBBDD=new SimpleDateFormat(Configuration.getProperty("db.date_format"));
    final static SimpleDateFormat sdfShow=new SimpleDateFormat(Configuration.getProperty("show.date_format"));

	//-- GETs y SETs
	/**
	 * Devuelve ID_PROPIETARIO
	 *
	 * @return ID_PROPIETARIO
	 */
	public int getID_PROPIETARIO()
	{
		return this.ID_PROPIETARIO;
	}

	/**
	 * Asigna ID_PROPIETARIO
	 *
	 * @param unID_PROPIETARIO
	 */
	public void setID_PROPIETARIO(int unID_PROPIETARIO)
	{
		this.ID_PROPIETARIO = unID_PROPIETARIO;
	}

	/**
	 * Devuelve CIF
	 *
	 * @return CIF
	 */
	public String getCIF()
	{
		return this.CIF;
	}

	/**
	 * Asigna CIF
	 *
	 * @param unCIF
	 */
	public void setCIF(String unCIF)
	{
		this.CIF = unCIF;
	}

	/**
	 * Devuelve RAZON_SOCIAL
	 *
	 * @return RAZON_SOCIAL
	 */
	public String getRAZON_SOCIAL()
	{
		return this.RAZON_SOCIAL;
	}

	/**
	 * Asigna RAZON_SOCIAL
	 *
	 * @param unRAZON_SOCIAL
	 */
	public void setRAZON_SOCIAL(String unRAZON_SOCIAL)
	{
		this.RAZON_SOCIAL = unRAZON_SOCIAL;
	}

	/**
	 * Devuelve NOMBRE_COMERCIAL
	 *
	 * @return NOMBRE_COMERCIAL
	 */
	public String getNOMBRE_COMERCIAL()
	{
		return this.NOMBRE_COMERCIAL;
	}

	/**
	 * Asigna NOMBRE_COMERCIAL
	 *
	 * @param unNOMBRE_COMERCIAL
	 */
	public void setNOMBRE_COMERCIAL(String unNOMBRE_COMERCIAL)
	{
		this.NOMBRE_COMERCIAL = unNOMBRE_COMERCIAL;
	}

	/**
	 * Devuelve DOMICILIO
	 *
	 * @return DOMICILIO
	 */
	public String getDOMICILIO()
	{
		return this.DOMICILIO;
	}

	/**
	 * Asigna DOMICILIO
	 *
	 * @param unDOMICILIO
	 */
	public void setDOMICILIO(String unDOMICILIO)
	{
		this.DOMICILIO = unDOMICILIO;
	}

	/**
	 * Devuelve POBLACION
	 *
	 * @return POBLACION
	 */
	public String getPOBLACION()
	{
		return this.POBLACION;
	}

	/**
	 * Asigna POBLACION
	 *
	 * @param unPOBLACION
	 */
	public void setPOBLACION(String unPOBLACION)
	{
		this.POBLACION = unPOBLACION;
	}

	/**
	 * Devuelve ID_PROVINCIA
	 *
	 * @return ID_PROVINCIA
	 */
	public int getID_PROVINCIA()
	{
		return this.ID_PROVINCIA;
	}

	/**
	 * Asigna ID_PROVINCIA
	 *
	 * @param unID_PROVINCIA
	 */
	public void setID_PROVINCIA(int unID_PROVINCIA)
	{
		this.ID_PROVINCIA = unID_PROVINCIA;
	}

	/**
	 * Devuelve ID_PAIS
	 *
	 * @return ID_PAIS
	 */
	public int getID_PAIS()
	{
		return this.ID_PAIS;
	}

	/**
	 * Asigna ID_PAIS
	 *
	 * @param unID_PAIS
	 */
	public void setID_PAIS(int unID_PAIS)
	{
		this.ID_PAIS = unID_PAIS;
	}

	/**
	 * Devuelve TELEFONO
	 *
	 * @return TELEFONO
	 */
	public String getTELEFONO()
	{
		return this.TELEFONO;
	}

	/**
	 * Asigna TELEFONO
	 *
	 * @param unTELEFONO
	 */
	public void setTELEFONO(String unTELEFONO)
	{
		this.TELEFONO = unTELEFONO;
	}

	/**
	 * Devuelve TELEFONO2
	 *
	 * @return TELEFONO2
	 */
	public String getTELEFONO2()
	{
		return this.TELEFONO2;
	}

	/**
	 * Asigna TELEFONO2
	 *
	 * @param unTELEFONO2
	 */
	public void setTELEFONO2(String unTELEFONO2)
	{
		this.TELEFONO2 = unTELEFONO2;
	}

	/**
	 * Devuelve FAX
	 *
	 * @return FAX
	 */
	public String getFAX()
	{
		return this.FAX;
	}

	/**
	 * Asigna FAX
	 *
	 * @param unFAX
	 */
	public void setFAX(String unFAX)
	{
		this.FAX = unFAX;
	}

	/**
	 * Devuelve ESTADO_CIVIL
	 *
	 * @return ESTADO_CIVIL
	 */
	public String getESTADO_CIVIL()
	{
		return this.ESTADO_CIVIL;
	}

	/**
	 * Asigna ESTADO_CIVIL
	 *
	 * @param unESTADO_CIVIL
	 */
	public void setESTADO_CIVIL(String unESTADO_CIVIL)
	{
		this.ESTADO_CIVIL = unESTADO_CIVIL;
	}

	/**
	 * Devuelve FECHA_ALTA
	 *
	 * @return FECHA_ALTA
	 */
	public java.util.Date getFECHA_ALTA()
	{
		return this.FECHA_ALTA;
	}

    /**
     * Devuelve la fecha de alta formateada para ser vista
     *
     * @return Fecha de alta formateada para ser vista
     */
    public String getShowFECHA_ALTA()
    {
        if(getFECHA_ALTA()!=null)
            return sdfShow.format(getFECHA_ALTA());
        else
            return "";
    }

	/**
	 * Asigna FECHA_ALTA
	 *
	 * @param unFECHA_ALTA
	 */
	public void setFECHA_ALTA(java.util.Date unFECHA_ALTA)
	{
		this.FECHA_ALTA = unFECHA_ALTA;
	}

	/**
	 * Devuelve PERSONA_CONTACTO
	 *
	 * @return PERSONA_CONTACTO
	 */
	public String getPERSONA_CONTACTO()
	{
		return this.PERSONA_CONTACTO;
	}

	/**
	 * Asigna PERSONA_CONTACTO
	 *
	 * @param unPERSONA_CONTACTO
	 */
	public void setPERSONA_CONTACTO(String unPERSONA_CONTACTO)
	{
		this.PERSONA_CONTACTO = unPERSONA_CONTACTO;
	}

	/**
	 * Devuelve CP
	 *
	 * @return CP
	 */
	public int getCP()
	{
		return this.CP;
	}

	/**
	 * Asigna CP
	 *
	 * @param unCP
	 */
	public void setCP(int unCP)
	{
		this.CP = unCP;
	}


    /**
     * Devuelve CONTACTO_APEL1
     *
     * @return CONTACTO_APEL1
     */
    public String getCONTACTO_APEL1()
    {
        return this.CONTACTO_APEL1;
    }

    /**
     * Asigna CONTACTO_APEL1
     *
     * @param unCONTACTO_APEL1
     */
    public void setCONTACTO_APEL1(String unCONTACTO_APEL1)
    {
        this.CONTACTO_APEL1 = unCONTACTO_APEL1;
    }

    /**
     * Devuelve CONTACTO_APEL2
     *
     * @return CONTACTO_APEL2
     */
    public String getCONTACTO_APEL2()
    {
        return this.CONTACTO_APEL2;
    }

    /**
     * Asigna CONTACTO_APEL2
     *
     * @param unCONTACTO_APEL2
     */
    public void setCONTACTO_APEL2(String unCONTACTO_APEL2)
    {
        this.CONTACTO_APEL2 = unCONTACTO_APEL2;
    }

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto FEL_PROVEEDOR
	*/
	public FEL_PROVEEDOR loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer(SELECT_PROV+" WHERE ID_PROPIETARIO=?");
		Vector vParams=new Vector();

		vParams.add(new Integer(nPK));
		Vector vRtado = new Vector();
        AbstractDBManager dbm=null;
		try {
            dbm = DBManager.getInstance();
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
			dbm.close();
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
			if(dbm!=null)
			    dbm.close();
			return null;
		}

		if(vRtado!=null && !vRtado.isEmpty()) {
			//-- Solo puede haber un rtado puesto que ID_PROPIETARIO es PK
			setElement( (Vector)vRtado.firstElement() );
		}

        return this;
	}

    /**
    * Carga la informaci&oacute;n de la tabla en el objeto.
    *
    * @param sCIF CIF de la empresa
    * @return Objeto FEL_PROVEEDOR
    */
    public FEL_PROVEEDOR loadFromDB(String sCIF)
    {
        StringBuffer sSQL=new StringBuffer(SELECT_PROV+" WHERE CIF=?");
        Vector vParams=new Vector();

        vParams.add(sCIF);
        Vector vRtado = new Vector();
        try {
            AbstractDBManager dbm = DBManager.getInstance();
            vRtado=dbm.executeQuery(sSQL.toString(),vParams);
        }
        catch(Exception e) {
            //-- Tratamiento de la excepcion
            return null;
        }

        if(vRtado!=null && !vRtado.isEmpty()) {
            //-- Solo puede haber un rtado puesto que CID tiene que ser PK
            setElement( (Vector)vRtado.firstElement() );
        }

        return this;
    }

    /**
    * Carga la informaci&oacute;n de la tabla en el objeto.
    *
    * @param sContacto persona de contacto
    * @return Objeto FEL_PROVEEDOR
    */
    public FEL_PROVEEDOR loadFromDBContacto(String sContacto)
    {
        StringBuffer sSQL=new StringBuffer(SELECT_PROV+" WHERE PERSONA_CONTACTO like ?");
        Vector vParams=new Vector();

        vParams.add(sContacto);
        Vector vRtado = new Vector();
        try {
            AbstractDBManager dbm = DBManager.getInstance();
            vRtado=dbm.executeQuery(sSQL.toString(),vParams);
        }
        catch(Exception e) {
            //-- Tratamiento de la excepcion
            return null;
        }

        if(vRtado!=null && !vRtado.isEmpty()) {
            //-- Solo puede haber un rtado puesto que CID tiene que ser PK
            setElement( (Vector)vRtado.firstElement() );
        }

        return this;
    }


    /**
    * Carga la informaci&oacute;n de la tabla en el objeto.
    *
    * @param sContacto Nombre de la persona de contacto
    * @param sApel1 Primer apellido de la persona de contacto
    * @return Objeto FEL_PROVEEDOR
    */
    public FEL_PROVEEDOR loadFromDBContacto(String sContacto, String sApel1)
    {
        StringBuffer sSQL=new StringBuffer(SELECT_PROV+" WHERE PERSONA_CONTACTO like ? and CONTACTO_APEL1 like ?");
        Vector vParams=new Vector();

        vParams.add(sContacto);
        vParams.add(sApel1);
        Vector vRtado = new Vector();
        AbstractDBManager dbm=null;
        try {
            dbm = DBManager.getInstance();
            vRtado=dbm.executeQuery(sSQL.toString(),vParams);
            dbm.close();
        }
        catch(Exception e) {
            //-- Tratamiento de la excepcion
            if(dbm!=null)
                dbm.close();
            return null;
        }

        if(vRtado!=null && !vRtado.isEmpty()) {
            //-- Solo puede haber un rtado puesto que CID tiene que ser PK
            setElement( (Vector)vRtado.firstElement() );
        }

        return this;
    }


    /**
    * Carga la informaci&oacute;n de la tabla en el objeto.
    *
    * @param sNombreComercial Nombre comercial
    * @return Objeto FEL_PROVEEDOR
    */
    public FEL_PROVEEDOR loadFromDBNombreComercial(String sNombreComercial)
    {
        StringBuffer sSQL=new StringBuffer(SELECT_PROV+" WHERE NOMBRE_COMERCIAL like ?");
        Vector vParams=new Vector();

        vParams.add(sNombreComercial);
        Vector vRtado = new Vector();
        try {
            AbstractDBManager dbm = DBManager.getInstance();
            vRtado=dbm.executeQuery(sSQL.toString(),vParams);
        }
        catch(Exception e) {
            //-- Tratamiento de la excepcion
            return null;
        }

        if(vRtado!=null && !vRtado.isEmpty()) {
            //-- Solo puede haber un rtado puesto que CID tiene que ser PK
            setElement( (Vector)vRtado.firstElement() );
        }

        return this;
    }

	/**
	 * Obtenemos todos los propietarios de la BB.DD.
	 * 
	 * @return Vector con los propietarios de la BB.DD.
	 */
	public static Vector getPropietarios() {
		Vector vProps=new Vector();
		Vector vRtado=null;
		
		try {
			AbstractDBManager dbm = DBManager.getInstance();
			vRtado=dbm.executeQuery(SELECT_PROV);
		}
		catch(Exception e) {
			logger.error("Error al recuperar los propietarios de la BB.DD: "+e);
			return new Vector();
		}

		if(vRtado!=null) {
			FEL_PROVEEDOR o=null;
			for(int i=0; i<vRtado.size(); i++) {
				o=new FEL_PROVEEDOR();
				o.setElement((Vector)vRtado.elementAt(i));
				vProps.add(o);
			}
		}

		return vProps;
	}

	/**
	 * 
	 * @return Vector con los inmuebles del propietario
	 */
	public Vector getInmuebles() {
		Vector vInms=new Vector();
		Vector vRtado=null;

		try {
			AbstractDBManager dbm = DBManager.getInstance();
			Vector vParams=new Vector();
			vParams.add(new Integer(getID_PROPIETARIO()));
			vParams.add(new Integer(Configuration.getProperty("estado.eliminado")));
			vParams.add(new Integer(Configuration.getProperty("estado.vendido")));
			vRtado=dbm.executeQuery(FEL_INMUEBLE.SELECT_INMUEBLE+" WHERE Cod_Propietario=? AND ESTADO!=? AND ESTADO!=?", vParams);
		}
		catch(Exception e) {
			logger.error("[getInmuebles] Error al recuperar los inmuebeles del propietario: "+e);
			return new Vector();
		}

		if(vRtado!=null) {
			FEL_INMUEBLE o=null;
			for(int i=0; i<vRtado.size(); i++) {
				o=new FEL_INMUEBLE();
				o.setElement((Vector)vRtado.elementAt(i));
				vInms.add(o);
			}
		}

		return vInms;
	}

    /**
     * Carga del objeto desde un vector que representa un registro de la BB.DD.
     *
     * @param vRow
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            this.ID_PROPIETARIO = Integer.parseInt(vRow.elementAt(0).toString().trim());
        if(vRow.elementAt(1)!=null)
            this.CIF = ((String)vRow.elementAt(1)).trim();
        if(vRow.elementAt(2)!=null)
            this.RAZON_SOCIAL = ((String)vRow.elementAt(2)).trim();
        if(vRow.elementAt(3)!=null)
            this.NOMBRE_COMERCIAL = ((String)vRow.elementAt(3)).trim();
        if(vRow.elementAt(4)!=null)
            this.DOMICILIO = ((String)vRow.elementAt(4)).trim();
        if(vRow.elementAt(5)!=null)
            this.POBLACION = ((String)vRow.elementAt(5)).trim();
        if(vRow.elementAt(6)!=null)
            this.ID_PROVINCIA = Integer.parseInt(vRow.elementAt(6).toString().trim());
        if(vRow.elementAt(7)!=null)
            this.ID_PAIS = Integer.parseInt(vRow.elementAt(7).toString().trim());
        if(vRow.elementAt(8)!=null)
            this.TELEFONO = ((String)vRow.elementAt(8)).trim();
        if(vRow.elementAt(9)!=null)
            this.TELEFONO2 = ((String)vRow.elementAt(9)).trim();
        if(vRow.elementAt(10)!=null)
            this.FAX = ((String)vRow.elementAt(10)).trim();
        if(vRow.elementAt(11)!=null)
            this.ESTADO_CIVIL = ((String)vRow.elementAt(11)).trim();

        if(vRow.elementAt(12)!=null) {
            try {
                setFECHA_ALTA(sdfBBDD.parse(vRow.elementAt(12).toString().trim()));
            }
            catch(Exception e) {
                logger.warn("[setElement] Error al formatear la fecha: "+e);
            }
        }

        if(vRow.elementAt(13)!=null)
            this.PERSONA_CONTACTO = ((String)vRow.elementAt(13)).trim();
        if(vRow.elementAt(14)!=null)
            this.CP = Integer.parseInt(vRow.elementAt(14).toString().trim());
        if(vRow.elementAt(15)!=null)
            this.CONTACTO_APEL1 = ((String)vRow.elementAt(15)).trim();
        if(vRow.elementAt(16)!=null)
            this.CONTACTO_APEL2 = ((String)vRow.elementAt(16)).trim();
    }

	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams=new Vector();

        // La fecha de alta...
        if(getFECHA_ALTA()==null) {
            setFECHA_ALTA(new Date());
        }

		//-- Chequeamos a ver si es un objeto nuevo
		if(getID_PROPIETARIO()==-1) { // ** TO DO **
			sSQL = new StringBuffer("INSERT INTO FEL_PROVEEDOR ");
			sSQL.append("(CIF,RAZON_SOCIAL,NOMBRE_COMERCIAL,DOMICILIO,POBLACION,ID_PROVINCIA,ID_PAIS,TELEFONO,TELEFONO2,FAX,ESTADO_CIVIL,FECHA_ALTA,PERSONA_CONTACTO,CP,CONTACTO_APEL1,CONTACTO_APEL2");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            vParams=new Vector();
            vParams.add(getCIF());
            vParams.add(getRAZON_SOCIAL());
            vParams.add(getNOMBRE_COMERCIAL());
            vParams.add(getDOMICILIO());
            vParams.add(getPOBLACION());
            vParams.add(new Integer(getID_PROVINCIA()));
            vParams.add(new Integer(getID_PAIS()));
            vParams.add(getTELEFONO());
            vParams.add(getTELEFONO2());
            vParams.add(getFAX());
            vParams.add(getESTADO_CIVIL());
            try {
                if(getFECHA_ALTA()==null) {
                    vParams.add(sdfBBDD.format(new Date()));
                }
                else {
                    vParams.add(sdfBBDD.format(getFECHA_ALTA()));
                }
            }
            catch(Exception e) {
                logger.warn("[saveToDB] Error al formatear la fecha: "+e);
                vParams.add(null);
            }
            vParams.add(getPERSONA_CONTACTO());
            vParams.add(new Integer(getCP()));
            vParams.add(getCONTACTO_APEL1());
            vParams.add(getCONTACTO_APEL2());
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_PROVEEDOR SET ");
            sSQL.append("CIF=?");
            sSQL.append(", RAZON_SOCIAL=?");
            sSQL.append(", NOMBRE_COMERCIAL=?");
            sSQL.append(", DOMICILIO=?");
            sSQL.append(", POBLACION=?");
            sSQL.append(", ID_PROVINCIA=?");
            sSQL.append(", ID_PAIS=?");
            sSQL.append(", TELEFONO=?");
            sSQL.append(", TELEFONO2=?");
            sSQL.append(", FAX=?");
            sSQL.append(", ESTADO_CIVIL=?");
            sSQL.append(", FECHA_ALTA=?");
            sSQL.append(", PERSONA_CONTACTO=?");
            sSQL.append(", CP=?");
            sSQL.append(", CONTACTO_APEL1=?");
            sSQL.append(", CONTACTO_APEL2=?");
			sSQL.append(" WHERE ID_PROPIETARIO=?");

            vParams=new Vector();
            vParams.add(getCIF());
            vParams.add(getRAZON_SOCIAL());
            vParams.add(getNOMBRE_COMERCIAL());
            vParams.add(getDOMICILIO());
            vParams.add(getPOBLACION());
            vParams.add(new Integer(getID_PROVINCIA()));
            vParams.add(new Integer(getID_PAIS()));
            vParams.add(getTELEFONO());
            vParams.add(getTELEFONO2());
            vParams.add(getFAX());
            vParams.add(getESTADO_CIVIL());
            try {
                if(getFECHA_ALTA()==null) {
                    vParams.add(sdfBBDD.format(new Date()));
                }
                else {
                    vParams.add(sdfBBDD.format(getFECHA_ALTA()));
                }
            }
            catch(Exception e) {
                logger.warn("[saveToDB] Error al formatear la fecha: "+e);
                vParams.add(null);
            }
            vParams.add(getPERSONA_CONTACTO());
            vParams.add(new Integer(getCP()));
            vParams.add(getCONTACTO_APEL1());
            vParams.add(getCONTACTO_APEL2());
            vParams.add(new Integer(getID_PROPIETARIO()));
		}

        AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(),vParams);
	}


    /**
     * Borra el registro de la BB.DD.
     *
     * @return n&uacute;mero de registros modificados
     */
    public int delete() throws java.sql.SQLException
    {
        return delete(getID_PROPIETARIO());
    }

    /**
     * Borra el registro de la BB.DD.
     *
     * @return n&uacute;mero de registros modificados
     */
    public static int delete(int nId) throws java.sql.SQLException{
        StringBuffer sSQL=new StringBuffer("delete from FEL_PROVEEDOR where ID_PROPIETARIO=?");
        Vector vParams=new Vector();

        vParams=new Vector();
        vParams.add(new Integer(nId));

        AbstractDBManager dbm = DBManager.getInstance();
        return dbm.executeUpdate(sSQL.toString(),vParams);
    }

	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "FEL_PROVEEDOR-[ID_PROPIETARIO="+getID_PROPIETARIO()+",CIF="+getCIF()+",RAZON_SOCIAL="+getRAZON_SOCIAL()+",NOMBRE_COMERCIAL="+getNOMBRE_COMERCIAL()+",DOMICILIO="+getDOMICILIO()+",POBLACION="+getPOBLACION()+",ID_PROVINCIA="+getID_PROVINCIA()+",ID_PAIS="+getID_PAIS()+",TELEFONO="+getTELEFONO()+",TELEFONO2="+getTELEFONO2()+",FAX="+getFAX()+",ESTADO_CIVIL="+getESTADO_CIVIL()+",FECHA_ALTA="+getFECHA_ALTA()+",PERSONA_CONTACTO="+getPERSONA_CONTACTO()+",CP="+getCP()+"]";
	}
}
