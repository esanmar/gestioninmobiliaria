package com.emesa.gestinm.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.Configuration;
import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Tue Jul 15 10:13:18 CEST 2003
 */
public class FEL_INMUEBLE
{
    static Logger logger = Logger.getLogger(FEL_INMUEBLE.class);
	//-- Atributos
	private int CODIGO=-1;
	private String TIPO="";
	private int COD_PROPIETARIO=-1;
	private String TIPO_VIA="";
	private String DIRECCION="";
	private String NUMERO="";
	private String BLOQUE="";
	private String PISO="";
	private String LETRA="";
	private String COD_POSTAL="";
	private String POBLACION="";
	private String ZONA="";
	private String PROVINCIA="";
	private int SUPERFICIE=0;
	private int SUP_CONSTRUIDA=0;
	private int SUP_UTIL=0;
	private double PRECIO_VENTA;
	private double PRECIO_ALQUILER;
	private double PRECIO_TRASPASO;
	private Date FECHA_RESERVA=null;
	private Date FECHA_VENCIMIENTO=null;
	private int ESTADO=1;
	private String DESCRIPCION="";
	private String NOTAS="";
	private String LLAVES="";
	private String REFERENCIA="";
	private String VENDEDOR="";
	private Date ULTIMA_MODIFICACION=null;
	private boolean MODIFICADO=false;
    private String RESERVADO_POR="";
    private boolean EN_EXCLUSIVA=false;
    private Date FECHA_ALTA=null;

    /** <i>select</i> para obtener los datos de un inmueble */
    public static final String SELECT_INMUEBLE="SELECT Codigo,Tipo,Cod_Propietario,Tipo_via,Direccion,Numero,Bloque,Piso,Letra,Cod_postal,Poblacion,Zona,Provincia,Superficie,Sup_construida,Sup_util,Precio_venta,Precio_alquiler,Precio_traspaso,Fecha_reserva,Fecha_vencimiento,Estado,Descripcion,Notas,Llaves,Referencia,Vendedor,Ultima_modificacion,Modificado,RESERVADO_POR,EN_EXCLUSIVA,FECHA_ALTA FROM fel_inmueble";

    /** Fotografías asociadas al inmueble */
    private Vector vFotos=null;

	// Formato de las fechas...
    final static SimpleDateFormat sdfBBDD=new SimpleDateFormat(Configuration.getProperty("db.date_format"));
    final static SimpleDateFormat sdfShow=new SimpleDateFormat(Configuration.getProperty("show.date_format"));


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
     * Devuelve un vector con las im&aacute;genes asociadas al inmueble
     *
     * @return Vector con las im&aacute;genes asociadas al inmueble
     */
    public Vector getPictures()
    {
        return this.vFotos;
    }

	/**
	 * Devuelve la primera im&aacute;gen asociadas al inmueble que es
	 * visibles por el cliente
	 *
	 * @return <code>FotosInmueble</code> de la im&aacute;gen asociada 
	 * al inmueble que es visible por el cliente
	 */
	public FotosInmueble getFirstVisiblePicture()
	{
		FotosInmueble o=null;
		for(int i=0; i<vFotos.size(); i++) {
			o=((FotosInmueble)vFotos.elementAt(i));
			if( o.getVISIBLE()==1)
				return o;
		}

		return null;
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
	 * Devuelve TIPO
	 *
	 * @return TIPO
	 */
	public String getTIPO()
	{
		return this.TIPO;
	}

	/**
	 * Asigna TIPO
	 *
	 * @param unTIPO
	 */
	public void setTIPO(String unTIPO)
	{
		this.TIPO = unTIPO;
	}

	/**
	 * Devuelve COD_PROPIETARIO
	 *
	 * @return COD_PROPIETARIO
	 */
	public int getCOD_PROPIETARIO()
	{
		return this.COD_PROPIETARIO;
	}

	/**
	 * Asigna COD_PROPIETARIO
	 *
	 * @param unCOD_PROPIETARIO
	 */
	public void setCOD_PROPIETARIO(int unCOD_PROPIETARIO)
	{
		this.COD_PROPIETARIO = unCOD_PROPIETARIO;
	}

	/**
	 * Devuelve TIPO_VIA
	 *
	 * @return TIPO_VIA
	 */
	public String getTIPO_VIA()
	{
		return this.TIPO_VIA;
	}

	/**
	 * Asigna TIPO_VIA
	 *
	 * @param unTIPO_VIA
	 */
	public void setTIPO_VIA(String unTIPO_VIA)
	{
		this.TIPO_VIA = unTIPO_VIA;
	}

	/**
	 * Devuelve DIRECCION
	 *
	 * @return DIRECCION
	 */
	public String getDIRECCION()
	{
		return this.DIRECCION;
	}

	/**
	 * Asigna DIRECCION
	 *
	 * @param unDIRECCION
	 */
	public void setDIRECCION(String unDIRECCION)
	{
		this.DIRECCION = unDIRECCION;
	}

	/**
	 * Devuelve NUMERO
	 *
	 * @return NUMERO
	 */
	public String getNUMERO()
	{
		return this.NUMERO;
	}

	/**
	 * Asigna NUMERO
	 *
	 * @param unNUMERO
	 */
	public void setNUMERO(String unNUMERO)
	{
		this.NUMERO = unNUMERO;
	}

	/**
	 * Devuelve BLOQUE
	 *
	 * @return BLOQUE
	 */
	public String getBLOQUE()
	{
		return this.BLOQUE;
	}

	/**
	 * Asigna BLOQUE
	 *
	 * @param unBLOQUE
	 */
	public void setBLOQUE(String unBLOQUE)
	{
		this.BLOQUE = unBLOQUE;
	}

	/**
	 * Devuelve PISO
	 *
	 * @return PISO
	 */
	public String getPISO()
	{
		return this.PISO;
	}

	/**
	 * Asigna PISO
	 *
	 * @param unPISO
	 */
	public void setPISO(String unPISO)
	{
		this.PISO = unPISO;
	}

	/**
	 * Devuelve LETRA
	 *
	 * @return LETRA
	 */
	public String getLETRA()
	{
		return this.LETRA;
	}

	/**
	 * Asigna LETRA
	 *
	 * @param unLETRA
	 */
	public void setLETRA(String unLETRA)
	{
		this.LETRA = unLETRA;
	}

	/**
	 * Devuelve COD_POSTAL
	 *
	 * @return COD_POSTAL
	 */
	public String getCOD_POSTAL()
	{
		return this.COD_POSTAL;
	}

	/**
	 * Asigna COD_POSTAL
	 *
	 * @param unCOD_POSTAL
	 */
	public void setCOD_POSTAL(String unCOD_POSTAL)
	{
		this.COD_POSTAL = unCOD_POSTAL;
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
	 * Devuelve ZONA
	 *
	 * @return ZONA
	 */
	public String getZONA()
	{
		return this.ZONA;
	}

	/**
	 * Asigna ZONA
	 *
	 * @param unZONA
	 */
	public void setZONA(String unZONA)
	{
		this.ZONA = unZONA;
	}

	/**
	 * Devuelve PROVINCIA
	 *
	 * @return PROVINCIA
	 */
	public String getPROVINCIA()
	{
		return this.PROVINCIA;
	}

	/**
	 * Asigna PROVINCIA
	 *
	 * @param unPROVINCIA
	 */
	public void setPROVINCIA(String unPROVINCIA)
	{
		this.PROVINCIA = unPROVINCIA;
	}

	/**
	 * Devuelve SUPERFICIE
	 *
	 * @return SUPERFICIE
	 */
	public int getSUPERFICIE()
	{
		return this.SUPERFICIE;
	}

	/**
	 * Asigna SUPERFICIE
	 *
	 * @param unSUPERFICIE
	 */
	public void setSUPERFICIE(int unSUPERFICIE)
	{
		this.SUPERFICIE = unSUPERFICIE;
	}

	/**
	 * Devuelve SUP_CONSTRUIDA
	 *
	 * @return SUP_CONSTRUIDA
	 */
	public int getSUP_CONSTRUIDA()
	{
		return this.SUP_CONSTRUIDA;
	}

	/**
	 * Asigna SUP_CONSTRUIDA
	 *
	 * @param unSUP_CONSTRUIDA
	 */
	public void setSUP_CONSTRUIDA(int unSUP_CONSTRUIDA)
	{
		this.SUP_CONSTRUIDA = unSUP_CONSTRUIDA;
	}

	/**
	 * Devuelve SUP_UTIL
	 *
	 * @return SUP_UTIL
	 */
	public int getSUP_UTIL()
	{
		return this.SUP_UTIL;
	}

	/**
	 * Asigna SUP_UTIL
	 *
	 * @param unSUP_UTIL
	 */
	public void setSUP_UTIL(int unSUP_UTIL)
	{
		this.SUP_UTIL = unSUP_UTIL;
	}

	/**
	 * Devuelve PRECIO_VENTA
	 *
	 * @return PRECIO_VENTA
	 */
	public double getPRECIO_VENTA()
	{
		return this.PRECIO_VENTA;
	}

	/**
	 * Asigna PRECIO_VENTA
	 *
	 * @param unPRECIO_VENTA
	 */
	public void setPRECIO_VENTA(double unPRECIO_VENTA)
	{
		this.PRECIO_VENTA = unPRECIO_VENTA;
	}

	/**
	 * Devuelve PRECIO_ALQUILER
	 *
	 * @return PRECIO_ALQUILER
	 */
	public double getPRECIO_ALQUILER()
	{
		return this.PRECIO_ALQUILER;
	}

	/**
	 * Asigna PRECIO_ALQUILER
	 *
	 * @param unPRECIO_ALQUILER
	 */
	public void setPRECIO_ALQUILER(double unPRECIO_ALQUILER)
	{
		this.PRECIO_ALQUILER = unPRECIO_ALQUILER;
	}

	/**
	 * Devuelve PRECIO_TRASPASO
	 *
	 * @return PRECIO_TRASPASO
	 */
	public double getPRECIO_TRASPASO()
	{
		return this.PRECIO_TRASPASO;
	}

	/**
	 * Asigna PRECIO_TRASPASO
	 *
	 * @param unPRECIO_TRASPASO
	 */
	public void setPRECIO_TRASPASO(double unPRECIO_TRASPASO)
	{
		this.PRECIO_TRASPASO = unPRECIO_TRASPASO;
	}

	/**
	 * Devuelve FECHA_RESERVA
	 *
	 * @return FECHA_RESERVA
	 */
	public java.util.Date getFECHA_RESERVA()
	{
		return this.FECHA_RESERVA;
	}

	/**
     * Devuelve la fecha formateada para ser vista
     *
     * @return Fecha formateada para ser vista
     */
    public String getShowFECHA_RESERVA()
    {
        if(getFECHA_RESERVA()!=null && !getFECHA_RESERVA().equals(""))
            return sdfShow.format(getFECHA_RESERVA());
        else
            return "";
    }


	/**
	 * Asigna FECHA_RESERVA
	 *
	 * @param unFECHA_RESERVA
	 */
	public void setFECHA_RESERVA(java.util.Date unFECHA_RESERVA)
	{
		this.FECHA_RESERVA = unFECHA_RESERVA;
	}

    /**
     * Asigna FECHA_RESERVA
     *
     * @param unFECHA_RESERVA
     */
    public void setFormatFECHA_RESERVA(String unFECHA_RESERVA)
    {
        try {
            this.FECHA_RESERVA = sdfShow.parse(unFECHA_RESERVA);
        }
        catch(Exception e) {
            logger.warn("[setFormatFECHA_RESERVA] Error al formatear "+unFECHA_RESERVA);
        }
    }

	/**
	 * Devuelve FECHA_VENCIMIENTO
	 *
	 * @return FECHA_VENCIMIENTO
	 */
	public java.util.Date getFECHA_VENCIMIENTO()
	{
		return this.FECHA_VENCIMIENTO;
	}


	/**
     * Devuelve la fecha formateada para ser vista
     *
     * @return Fecha formateada para ser vista
     */
    public String getShowFECHA_VENCIMIENTO()
    {
        if(getFECHA_VENCIMIENTO()!=null && !getFECHA_VENCIMIENTO().equals(""))
            return sdfShow.format(getFECHA_VENCIMIENTO());
        else
            return "";
    }

	/**
	 * Asigna FECHA_VENCIMIENTO
	 *
	 * @param unFECHA_VENCIMIENTO
	 */
	public void setFECHA_VENCIMIENTO(java.util.Date unFECHA_VENCIMIENTO)
	{
		this.FECHA_VENCIMIENTO = unFECHA_VENCIMIENTO;
	}

    /**
     * Asigna FECHA_VENCIMIENTO
     *
     * @param unFECHA_RESERVA
     */
    public void setFormatFECHA_VENCIMIENTO(String unFECHA_VENCIMIENTO)
    {
        try {
            this.FECHA_VENCIMIENTO = sdfShow.parse(unFECHA_VENCIMIENTO);
        }
        catch(Exception e) {
            logger.warn("[setFormatFECHA_VENCIMIENTO] Error al formatear "+unFECHA_VENCIMIENTO);
        }

    }

	/**
	 * Devuelve ESTADO
	 *
	 * @return ESTADO
	 */
	public int getESTADO()
	{
		return this.ESTADO;
	}

	/**
	 * Asigna ESTADO
	 *
	 * @param unESTADO
	 */
	public void setESTADO(int unESTADO)
	{
		this.ESTADO = unESTADO;
	}

	/**
	 * Devuelve DESCRIPCION
	 *
	 * @return DESCRIPCION
	 */
	public String getDESCRIPCION()
	{
		return this.DESCRIPCION;
	}

	/**
	 * Asigna DESCRIPCION
	 *
	 * @param unDESCRIPCION
	 */
	public void setDESCRIPCION(String unDESCRIPCION)
	{
		this.DESCRIPCION = unDESCRIPCION;
	}

	/**
	 * Devuelve NOTAS
	 *
	 * @return NOTAS
	 */
	public String getNOTAS()
	{
		return this.NOTAS;
	}

	/**
	 * Asigna NOTAS
	 *
	 * @param unNOTAS
	 */
	public void setNOTAS(String unNOTAS)
	{
		this.NOTAS = unNOTAS;
	}

	/**
	 * Devuelve LLAVES
	 *
	 * @return LLAVES
	 */
	public String getLLAVES()
	{
		return this.LLAVES;
	}

	/**
	 * Asigna LLAVES
	 *
	 * @param unLLAVES
	 */
	public void setLLAVES(String unLLAVES)
	{
		this.LLAVES = unLLAVES;
	}

	/**
	 * Devuelve REFERENCIA
	 *
	 * @return REFERENCIA
	 */
	public String getREFERENCIA()
	{
		return this.REFERENCIA;
	}

	/**
	 * Asigna REFERENCIA
	 *
	 * @param unREFERENCIA
	 */
	public void setREFERENCIA(String unREFERENCIA)
	{
		this.REFERENCIA = unREFERENCIA;
	}

	/**
	 * Devuelve VENDEDOR
	 *
	 * @return VENDEDOR
	 */
	public String getVENDEDOR()
	{
		return this.VENDEDOR;
	}

	/**
	 * Asigna VENDEDOR
	 *
	 * @param unVENDEDOR
	 */
	public void setVENDEDOR(String unVENDEDOR)
	{
		this.VENDEDOR = unVENDEDOR;
	}

	/**
	 * Devuelve ULTIMA_MODIFICACION
	 *
	 * @return ULTIMA_MODIFICACION
	 */
	public java.util.Date getULTIMA_MODIFICACION()
	{
		return this.ULTIMA_MODIFICACION;
	}

	/**
     * Devuelve la fecha formateada para ser vista
     *
     * @return Fecha formateada para ser vista
     */
    public String getShowULTIMA_MODIFICACION()
    {
        if(getULTIMA_MODIFICACION()!=null)
            return sdfShow.format(getULTIMA_MODIFICACION());
        else
            return "";
    }

	/**
	 * Asigna ULTIMA_MODIFICACION
	 *
	 * @param unULTIMA_MODIFICACION
	 */
	public void setULTIMA_MODIFICACION(java.util.Date unULTIMA_MODIFICACION)
	{
		this.ULTIMA_MODIFICACION = unULTIMA_MODIFICACION;
	}

	/**
	 * Devuelve MODIFICADO
	 *
	 * @return MODIFICADO
	 */
	public boolean getMODIFICADO()
	{
		return this.MODIFICADO;
	}

	/**
	 * Asigna MODIFICADO
	 *
	 * @param unMODIFICADO
	 */
	public void setMODIFICADO(boolean unMODIFICADO)
	{
		this.MODIFICADO = unMODIFICADO;
	}


    /**
     * Devuelve RESERVADO_POR
     *
     * @return RESERVADO_POR
     */
    public String getRESERVADO_POR()
    {
        return this.RESERVADO_POR;
    }

    /**
     * Asigna RESERVADO_POR
     *
     * @param unRESERVADO_POR
     */
    public void setRESERVADO_POR(String unRESERVADO_POR)
    {
        this.RESERVADO_POR = unRESERVADO_POR;
    }


    /**
     * Devuelve EN_EXCLUSIVA
     *
     * @return EN_EXCLUSIVA
     */
    public boolean getEN_EXCLUSIVA()
    {
        return this.EN_EXCLUSIVA;
    }

    /**
     * Asigna EN_EXCLUSIVA
     *
     * @param unEN_EXCLUSIVA
     */
    public void setEN_EXCLUSIVA(boolean unEN_EXCLUSIVA)
    {
        this.EN_EXCLUSIVA = unEN_EXCLUSIVA;
    }


    /**
     * Devuelve FECHA_ALTA
     *
     * @return FECHA_ALTA
     */
    public Date getFECHA_ALTA()
    {
        return this.FECHA_ALTA;
    }

    /**
     * Devuelve la fecha formateada para ser vista
     *
     * @return Fecha formateada para ser vista
     */
    public String getShowFECHA_ALTA()
    {
        if(getFECHA_ALTA()!=null && !getFECHA_ALTA().equals(""))
            return sdfShow.format(getFECHA_ALTA());
        else
            return "";
    }

    /**
     * Asigna FECHA_ALTA
     *
     * @param unFECHA_ALTA
     */
    private void setFECHA_ALTA(java.util.Date unFECHA_ALTA)
    {
        this.FECHA_ALTA = unFECHA_ALTA;
    }



	/**
	 * Carga un inmueble un&iacute;vocamente identificado por los par&aacute;metros
	 * indicados
	 * 
	 * @param sDireccion
	 * @param nNum
	 * @param sBloque
	 * @param sPiso
	 * @param sLetra
	 * @return
	 */
	public FEL_INMUEBLE loadUniqueInm(String sDireccion, String nNum, String sBloque, String sPiso, String sLetra)
	{
		StringBuffer sSQL=new StringBuffer(SELECT_INMUEBLE+" WHERE Direccion=? ");
		Vector vParams = new Vector();
		vParams.add(sDireccion);

		if (!nNum.equals(""))
		{
			sSQL.append("and Numero=?");
			vParams.add(nNum);
		}
		else
		{
			sSQL.append(" and (Numero is null or Numero='')");
		}

		if (!sBloque.equals(""))
		{
			sSQL.append(" and Bloque=?");
			vParams.add(sBloque);
		}
		else
		{
			sSQL.append(" and (Bloque is null or Bloque='')");
		}

		if (!sPiso.equals(""))
		{
			sSQL.append(" and Piso=?");
			vParams.add(sPiso);
		}
		else
		{
			sSQL.append(" and (Piso is null or Piso='')");
		}

		if (!sLetra.equals(""))
		{
			sSQL.append(" and Letra=?");
			vParams.add(sLetra);
		}
		else
		{
			sSQL.append(" and (Letra is null or Letra='')");
		}

		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
		}
		catch(Exception e) {
			logger.error("[loadFromDB] Error: "+e);
			return null;
		}

		if(vRtado!=null && !vRtado.isEmpty()) {
            setElement( (Vector)vRtado.firstElement() );
		}

		return this;
	 }


	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param sReferencia Carga un inmueble por su referencia 
	* (<em>&iexcl; ojo, referencia != c&oacute;digo!</em>)
	* @return Objeto fel_inmueble
	*/
	public FEL_INMUEBLE loadRefFromDB(String sReferencia)
	{
		StringBuffer sSQL;
		Vector vParams;

        sSQL=new StringBuffer(SELECT_INMUEBLE+" WHERE Referencia like ?");
		vParams=new Vector();
		vParams.add(sReferencia);

		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
		}
		catch(Exception e) {
			logger.error("[loadFromDB] Error: "+e);
			return null;
		}

		if(vRtado!=null && !vRtado.isEmpty()) {
            setElement( (Vector)vRtado.firstElement() );
		}

		return this;
	 }



	/**
	 * 
	 * 
	 * @param sDireccion
	 * @param sNum
	 * @return
	 */
	public FEL_INMUEBLE loadDirFromDB(String sDireccion, String sNum)
	{
		StringBuffer sSQL;
		Vector vParams;

		if (sNum!=null && !sNum.trim().equals("") && !sNum.trim().equals("-1"))
		{
            sSQL=new StringBuffer(SELECT_INMUEBLE+" WHERE Direccion like ? and Numero=?");
			vParams=new Vector();
			vParams.add(sDireccion);
			vParams.add(sNum);
		}
		else
		{
            sSQL=new StringBuffer(SELECT_INMUEBLE+" WHERE Direccion like ?");
			vParams=new Vector();
			vParams.add(sDireccion);
		}

		AbstractDBManager dbm = null;
		Vector vRtado = new Vector();
		try {
            dbm=DBManager.getInstance();
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
			dbm.close();
		}
		catch(Exception e) {
		    if(dbm!=null)
		        dbm.close();
			logger.error("[loadFromDB] Error: "+e);
			return null;
		}

		if(vRtado!=null && !vRtado.isEmpty()) {
            setElement( (Vector)vRtado.firstElement() );
		}

		return this;
	 }



	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto fel_inmueble
	*/
	public FEL_INMUEBLE loadFromDB(int nPK)
	{
        StringBuffer sSQL=new StringBuffer(SELECT_INMUEBLE+" WHERE Codigo=?");
		Vector vParams=new Vector();

		vParams.add(new Integer(nPK));
		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
		}
		catch(Exception e) {
			logger.error("[loadFromDB] Error: "+e);
			return null;
		}

		if(vRtado!=null && !vRtado.isEmpty()) {
            setElement( (Vector)vRtado.firstElement() );
		}

		return this;
	 }

	/*
	 * Devuelve un vector con los objetos <code>FEL_INMUEBLE</code> resultantes
	 * de ejecutar la <em>query</em> con los par&aacute;metros indicados.
	 * 
	 * @param sWhere <i>WHERE</i> de la <em>query</em>
	 * @param vParams Valores de los par&aacute;metros del <i>WHERE</i>
	 * @return Vector con los objetos <code>FEL_INMUEBLE</code> resultantes
	 * de ejecutar la <em>query</em> con los par&aacute;metros indicados
	 *
	public static Vector getInmueblesCond(String sWhere, Vector vParams) {
		Vector vInms=new Vector();
		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado=dbm.executeQuery(SELECT_INMUEBLE+" "+sWhere, vParams);
		}
		catch(Exception e) {
			logger.error("[getInmueblesCond] Error: "+e);
			return new Vector();
		}

		if(vRtado!=null && !vRtado.isEmpty()) {
			FEL_INMUEBLE o=null;
			for(int i=0; i<vRtado.size(); i++) {
				o=new FEL_INMUEBLE();
				o.setElement( (Vector)vRtado.elementAt(i) );

				vInms.add(o); 
			}
		}

		return vInms;
	}
	*/

	/**
	 *
	 * @param vRow Vector que representa un registro de la BB.DD.
     */
    public void setElement(Vector vRow)
    {
		if(vRow.elementAt(0)!=null)
			this.CODIGO = Integer.parseInt( ((String)vRow.elementAt(0)).trim() );
		if(vRow.elementAt(1)!=null)
			this.TIPO = ((String)vRow.elementAt(1)).trim();
		if(vRow.elementAt(2)!=null)
			this.COD_PROPIETARIO = Integer.parseInt( ((String)vRow.elementAt(2)).trim() );
		if(vRow.elementAt(3)!=null)
			this.TIPO_VIA = ((String)vRow.elementAt(3)).trim();
		if(vRow.elementAt(4)!=null)
			this.DIRECCION = ((String)vRow.elementAt(4)).trim();
		if(vRow.elementAt(5)!=null)
			this.NUMERO = ((String)vRow.elementAt(5)).trim();
		if(vRow.elementAt(6)!=null)
			this.BLOQUE = ((String)vRow.elementAt(6)).trim();
		if(vRow.elementAt(7)!=null)
			this.PISO = ((String)vRow.elementAt(7)).trim();
		if(vRow.elementAt(8)!=null)
			this.LETRA = ((String)vRow.elementAt(8)).trim();
		if(vRow.elementAt(9)!=null)
			this.COD_POSTAL = ((String)vRow.elementAt(9)).trim();
		if(vRow.elementAt(10)!=null)
			this.POBLACION = ((String)vRow.elementAt(10)).trim();
		if(vRow.elementAt(11)!=null)
			this.ZONA = ((String)vRow.elementAt(11)).trim();
		if(vRow.elementAt(12)!=null)
			this.PROVINCIA = ((String)vRow.elementAt(12)).trim();
		if(vRow.elementAt(13)!=null)
			this.SUPERFICIE = Integer.parseInt( ((String)vRow.elementAt(13)).trim() );
		if(vRow.elementAt(14)!=null)
			this.SUP_CONSTRUIDA = Integer.parseInt( ((String)vRow.elementAt(14)).trim() );
		if(vRow.elementAt(15)!=null)
			this.SUP_UTIL = Integer.parseInt( ((String)vRow.elementAt(15)).trim() );
		if(vRow.elementAt(16)!=null)
			this.PRECIO_VENTA = Double.parseDouble( ((String)vRow.elementAt(16)).trim() );
		if(vRow.elementAt(17)!=null)
			this.PRECIO_ALQUILER = Double.parseDouble( ((String)vRow.elementAt(17)).trim() );
		if(vRow.elementAt(18)!=null)
			this.PRECIO_TRASPASO = Double.parseDouble( ((String)vRow.elementAt(18)).trim() );

		if(vRow.elementAt(19)!=null) {
            try {
                setFECHA_RESERVA(sdfBBDD.parse(vRow.elementAt(19).toString().trim()));
            }
            catch(Exception e) {
                logger.warn("[setElement] Error al formatear la fecha de reserva "+vRow.elementAt(19).toString().trim()+": "+e);
            }
    	}

    	if(vRow.elementAt(20)!=null) {
            try {
                setFECHA_VENCIMIENTO(sdfBBDD.parse(vRow.elementAt(20).toString().trim()));
            }
            catch(Exception e) {
                logger.warn("[setElement] Error al formatear la fecha de vencimiento "+vRow.elementAt(20).toString().trim()+": "+e);
            }
    	}

		if(vRow.elementAt(21)!=null)
			this.ESTADO = Integer.parseInt( ((String)vRow.elementAt(21)).trim() );
		if(vRow.elementAt(22)!=null)
			this.DESCRIPCION = ((String)vRow.elementAt(22)).trim();
		if(vRow.elementAt(23)!=null)
			this.NOTAS = ((String)vRow.elementAt(23)).trim();
		if(vRow.elementAt(24)!=null)
			this.LLAVES = ((String)vRow.elementAt(24)).trim();
		if(vRow.elementAt(25)!=null)
			this.REFERENCIA = ((String)vRow.elementAt(25)).trim();
		if(vRow.elementAt(26)!=null)
			this.VENDEDOR = ((String)vRow.elementAt(26)).trim();
		else
		    setVENDEDOR(null);

		if(vRow.elementAt(27)!=null) {
            try {
                setULTIMA_MODIFICACION(sdfBBDD.parse(vRow.elementAt(27).toString().trim()));
            }
            catch(Exception e) {
                logger.warn("[setElement] Error al formatear la fecha de modificacion "+vRow.elementAt(27).toString().trim()+": "+e);
            }
    	}

		if(vRow.elementAt(28)!=null) {
            if( ((String)vRow.elementAt(28)).trim().equals("1"))
                setMODIFICADO(true);
            else
                setMODIFICADO(false);
        }

        if(vRow.elementAt(29)!=null)
            this.RESERVADO_POR = ((String)vRow.elementAt(29)).trim();

        if(vRow.elementAt(30)!=null) {
            if( ((String)vRow.elementAt(30)).trim().equals("1"))
                setEN_EXCLUSIVA(true);
            else
                setEN_EXCLUSIVA(false);
        }

        if(vRow.elementAt(31)!=null) {
            try {
                setFECHA_ALTA(sdfBBDD.parse(vRow.elementAt(31).toString().trim()));
            }
            catch(Exception e) {
                logger.warn("[setElement] Error al formatear la fecha de alta "+vRow.elementAt(28).toString().trim()+": "+e);
            }
        }

        /*----------------------------------------------
         *  LAS FOTOS
         *
        String sql="select PATH_FOTO from fel_fotos_inmueble where ID_INMUEBLE=?";
        Vector vParams =new Vector();
        vFotos = new Vector();
        vParams.add(new Integer(getCODIGO()));

        Vector vRtado=new Vector();
        try {
            AbstractDBManager dbm = DBManager.getInstance();
            vRtado=dbm.executeQuery(sql,vParams);
            dbm.close();
        } catch(Exception e) {
            logger.warn("[setElement] Error al cargar las fotos: "+e);
            vFotos=new Vector();
        }
        if(vRtado!=null && !vRtado.isEmpty()) {
            for(int i=0; i<vRtado.size(); i++)
                vFotos.add( ((Vector)vRtado.elementAt(i)).firstElement());
        }*/
        vFotos=FotosInmueble.getPictures(getCODIGO());
    }


	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB()
	{
		StringBuffer sSQL=null;
		Vector vParams=new Vector();

        setULTIMA_MODIFICACION(new Date());

         //-- Chequeamos a ver si es un objeto nuevo
		if(getCODIGO()==-1) {
			sSQL = new StringBuffer("INSERT INTO fel_inmueble ");
			sSQL.append("(Tipo,Cod_Propietario,Tipo_via,Direccion,Numero,Bloque,Piso,Letra,Cod_postal,Poblacion,Zona,Provincia,Superficie,Sup_construida,Sup_util,Precio_venta,Precio_alquiler,Precio_traspaso,Fecha_reserva,Fecha_vencimiento,Estado,Descripcion,Notas,Llaves,Referencia,Vendedor,Ultima_modificacion,Modificado,RESERVADO_POR,EN_EXCLUSIVA,FECHA_ALTA");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            setFECHA_ALTA(new Date());
		}
		else
		{
			sSQL = new StringBuffer("UPDATE fel_inmueble SET ");
			sSQL.append(" Tipo=?");
			sSQL.append(", Cod_Propietario=?");
			sSQL.append(", Tipo_via=?");
			sSQL.append(", Direccion=?");
			sSQL.append(", Numero=?");
			sSQL.append(", Bloque=?");
			sSQL.append(", Piso=?");
			sSQL.append(", Letra=?");
			sSQL.append(", Cod_postal=?");
			sSQL.append(", Poblacion=?");
			sSQL.append(", Zona=?");
			sSQL.append(", Provincia=?");
			sSQL.append(", Superficie=?");
			sSQL.append(", Sup_construida=?");
			sSQL.append(", Sup_util=?");
			sSQL.append(", Precio_venta=?");
			sSQL.append(", Precio_alquiler=?");
			sSQL.append(", Precio_traspaso=?");
			sSQL.append(", Fecha_reserva=?");
			sSQL.append(", Fecha_vencimiento=?");
			sSQL.append(", Estado=?");
			sSQL.append(", Descripcion=?");
			sSQL.append(", Notas=?");
			sSQL.append(", Llaves=?");
			sSQL.append(", Referencia=?");
			sSQL.append(", Vendedor=?");
			sSQL.append(", Ultima_modificacion=?");
			sSQL.append(", Modificado=?");
            sSQL.append(", RESERVADO_POR=?");
            sSQL.append(", EN_EXCLUSIVA=?");
			sSQL.append(" WHERE Codigo= ?");

            // Si es un Update, es que se ha modificado... se indica
            setMODIFICADO(true);
		}

		// Forma el vector con los parámetros, si es un update será un parámetro más
		vParams=new Vector();
		vParams.add(getTIPO());
		vParams.add( new Integer(getCOD_PROPIETARIO()) );
		vParams.add(getTIPO_VIA());
		vParams.add(getDIRECCION());
		vParams.add(getNUMERO());
		vParams.add(getBLOQUE());
		vParams.add(getPISO());
		vParams.add(getLETRA());
		vParams.add(getCOD_POSTAL());
		vParams.add(getPOBLACION());
		vParams.add(getZONA());
		vParams.add(getPROVINCIA());
		vParams.add( new Integer(getSUPERFICIE()) );
		vParams.add( new Integer(getSUP_CONSTRUIDA()) );
		vParams.add( new Integer(getSUP_UTIL()) );
		vParams.add( new Double(getPRECIO_VENTA()) );
		vParams.add( new Double(getPRECIO_ALQUILER()) );
		vParams.add( new Double(getPRECIO_TRASPASO()) );

		try
		{
            if(getFECHA_RESERVA()==null)
                vParams.add(null);
            else
                vParams.add(sdfBBDD.format(getFECHA_RESERVA()));
        }
        catch(Exception e) {
            logger.warn("[saveToDB] Error al formatear fecha de reserva: "+e);
            vParams.add(null);
        }

        try
		{
            if(getFECHA_VENCIMIENTO()==null)
                vParams.add(null);
            else
                vParams.add(sdfBBDD.format(getFECHA_VENCIMIENTO()));
        }
        catch(Exception e) {
            logger.warn("[saveToDB] Error al formatear fecha de vencimiento: "+e);
            vParams.add(null);
        }

		vParams.add(new Integer( getESTADO()) );
		vParams.add(getDESCRIPCION());
		vParams.add(getNOTAS());
		vParams.add(getLLAVES());
		vParams.add(getREFERENCIA());
		vParams.add(getVENDEDOR());

		try
		{
            vParams.add(sdfBBDD.format(getULTIMA_MODIFICACION()));
        }
        catch(Exception e) {
            logger.warn("[saveToDB] Error al formatear la fecha de modificación: "+e);
            vParams.add(null);
        }

        //-- Modificado
		if (getCODIGO()!=-1)
			vParams.add(new Integer(1));
		else
			vParams.add(new Integer(0));


        vParams.add(getRESERVADO_POR());

        //-- EN_EXCLUSIVA
        if(getEN_EXCLUSIVA())
            vParams.add(new Integer(1));
        else
            vParams.add(new Integer(0));


		// Si estamos haciendo un Update se añade el parámetro de where
		if(getCODIGO()!=-1)
		{
			vParams.add( new Integer(getCODIGO()) );
		}
		else {
            try
            {
                if(getFECHA_ALTA()==null)
                    vParams.add(sdfBBDD.format(new Date()));
                else
                    vParams.add(sdfBBDD.format(getFECHA_ALTA()));
            }
            catch(Exception e) {
                logger.warn("[saveToDB] Error al formatear la fecha de alta: "+e);
                vParams.add(null);
            }
        }

		// Ejecuta la sentencia SQL
		AbstractDBManager dbm = DBManager.getInstance();
		try {
			dbm.executeUpdate(sSQL.toString(), vParams);
		}catch (Exception e) {
            System.err.println("[fel_inmueble][loadFromDB] Error :"+e);
		}
	}


	/**
     * Borra el registro de la BB.DD.
     *
     * @return n&uacute;mero de registros modificados
     */
    public static int delete(int nId) throws java.sql.SQLException{

        String sEstado=Configuration.getProperty("estado.eliminado");
        StringBuffer sSQL=new StringBuffer("update FEL_INMUEBLE set Estado=? where Codigo=?");
        Vector vParams=new Vector();

        vParams=new Vector();
        vParams.add(sEstado);
        vParams.add(new Integer(nId));

        AbstractDBManager dbm = DBManager.getInstance();
        return dbm.executeUpdate(sSQL.toString(),vParams);
    }

    /**
     * Reinicia los campos que contienen <i>null</i> por defecto
     */
    public void reset() {
        setCODIGO(-1);
        setTIPO("");
        setCOD_PROPIETARIO(-1);
        setTIPO_VIA("");
        setDIRECCION("");
        setNUMERO("");
        setBLOQUE("");
        setPISO("");
        setLETRA("");
        setCOD_POSTAL("");
        setPOBLACION("");
        setZONA("");
        setPROVINCIA("");
        setSUPERFICIE(0);
        setSUP_CONSTRUIDA(0);
        setSUP_UTIL(0);
        setPRECIO_VENTA(0.0);
        setPRECIO_ALQUILER(0.0);
        setPRECIO_TRASPASO(0.0);
        setESTADO(1);
        setDESCRIPCION("");
        setNOTAS("");
        setLLAVES("");
        setREFERENCIA("");
        setVENDEDOR("");
        setMODIFICADO(false);
        setRESERVADO_POR("");
        setEN_EXCLUSIVA(false);

        setULTIMA_MODIFICACION(null);
        setFECHA_ALTA(null);
        setFECHA_RESERVA(null);
        setFECHA_VENCIMIENTO(null);
    }

	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "FEL_INMUEBLE-[Codigo="+getCODIGO()+",Tipo="+getTIPO()+",Cod_Propietario="+getCOD_PROPIETARIO()+",Tipo_via="+getTIPO_VIA()+",Direccion="+getDIRECCION()+",Numero="+getNUMERO()+",Bloque="+getBLOQUE()+",Piso="+getPISO()+",Letra="+getLETRA()+",Cod_postal="+getCOD_POSTAL()+",Poblacion="+getPOBLACION()+",Zona="+getZONA()+",Provincia="+getPROVINCIA()+",Superficie="+getSUPERFICIE()+",Sup_construida="+getSUP_CONSTRUIDA()+",Sup_util="+getSUP_UTIL()+",Precio_venta="+getPRECIO_VENTA()+",Precio_alquiler="+getPRECIO_ALQUILER()+",Precio_traspaso="+getPRECIO_TRASPASO()+",Fecha_reserva="+getFECHA_RESERVA()+",Fecha_vencimiento="+getFECHA_VENCIMIENTO()+",Estado="+getESTADO()+",Descripcion="+getDESCRIPCION()+",Notas="+getNOTAS()+",Llaves="+getLLAVES()+",Referencia="+getREFERENCIA()+",Vendedor="+getVENDEDOR()+",Ultima_modificacion="+getULTIMA_MODIFICACION()+",Modificado="+getMODIFICADO()+"]";
	}
}