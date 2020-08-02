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
 * @since Mon Feb 23 13:31:35 CET 2004
 */
public class FEL_CLIENTE
{
	//-- Atributos
	private int ID_CLIENTE=-1;
	private String NOMBRE;
	private String APELLIDO1;
	private String APELLIDO2;
	private String DOMICILIO;
	private String POBLACION;
	private int ID_PROVINCIA=-1;
	private String TELEFONO;
	private String TELEFONO2;
	private String FAX;
	private java.util.Date FECHA_ALTA;
	private int CP;

	 /** Logger */
    static Logger logger = Logger.getLogger(FEL_CLIENTE.class);
    
    private final static String SELECT_CLI="SELECT ID_CLIENTE,NOMBRE,APELLIDO1,APELLIDO2,DOMICILIO,POBLACION,ID_PROVINCIA,TELEFONO,TELEFONO2,FAX,FECHA_ALTA,CP FROM fel_cliente";
    
     // Formato de las fechas...
    final static SimpleDateFormat sdfBBDD=new SimpleDateFormat(Configuration.getProperty("db.date_format"));
    final static SimpleDateFormat sdfShow=new SimpleDateFormat(Configuration.getProperty("show.date_format"));


	//-- GETs y SETs
	/**
	 * Devuelve ID_CLIENTE
	 * 
	 * @return ID_CLIENTE
	 */
	public int getID_CLIENTE()
	{
		return this.ID_CLIENTE;
	}

	/**
	 * Asigna ID_CLIENTE
	 * 
	 * @param unID_CLIENTE
	 */
	public void setID_CLIENTE(int unID_CLIENTE)
	{
		this.ID_CLIENTE = unID_CLIENTE;
	}

	/**
	 * Devuelve NOMBRE
	 * 
	 * @return NOMBRE
	 */
	public String getNOMBRE()
	{
		return this.NOMBRE;
	}

	/**
	 * Asigna NOMBRE
	 * 
	 * @param unNOMBRE
	 */
	public void setNOMBRE(String unNOMBRE)
	{
		this.NOMBRE = unNOMBRE;
	}

	/**
	 * Devuelve APELLIDO1
	 * 
	 * @return APELLIDO1
	 */
	public String getAPELLIDO1()
	{
		return this.APELLIDO1;
	}

	/**
	 * Asigna APELLIDO1
	 * 
	 * @param unAPELLIDO1
	 */
	public void setAPELLIDO1(String unAPELLIDO1)
	{
		this.APELLIDO1 = unAPELLIDO1;
	}

	/**
	 * Devuelve APELLIDO2
	 * 
	 * @return APELLIDO2
	 */
	public String getAPELLIDO2()
	{
		return this.APELLIDO2;
	}

	/**
	 * Asigna APELLIDO2
	 * 
	 * @param unAPELLIDO2
	 */
	public void setAPELLIDO2(String unAPELLIDO2)
	{
		this.APELLIDO2 = unAPELLIDO2;
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
     * Carga del objeto desde un vector que representa un registro de la BB.DD.
     *
     * @param vRow
     */
    public void setElement(Vector vRow) {
    	
    	if(vRow.elementAt(0)!=null)
				this.ID_CLIENTE = Integer.parseInt(vRow.elementAt(0).toString().trim());
			if(vRow.elementAt(1)!=null)
				this.NOMBRE = ((String)vRow.elementAt(1)).trim();
			if(vRow.elementAt(2)!=null)
				this.APELLIDO1 = ((String)vRow.elementAt(2)).trim();
			if(vRow.elementAt(3)!=null)
				this.APELLIDO2 = ((String)vRow.elementAt(3)).trim();
			if(vRow.elementAt(4)!=null)
				this.DOMICILIO = ((String)vRow.elementAt(4)).trim();
			if(vRow.elementAt(5)!=null)
				this.POBLACION = ((String)vRow.elementAt(5)).trim();
			if(vRow.elementAt(6)!=null)
				this.ID_PROVINCIA = Integer.parseInt(vRow.elementAt(6).toString().trim());
			if(vRow.elementAt(7)!=null)
				this.TELEFONO = ((String)vRow.elementAt(7)).trim();
			if(vRow.elementAt(8)!=null)
				this.TELEFONO2 = ((String)vRow.elementAt(8)).trim();
			if(vRow.elementAt(9)!=null)
				this.FAX = ((String)vRow.elementAt(9)).trim();
			if(vRow.elementAt(10)!=null) {
            try {
                setFECHA_ALTA(sdfBBDD.parse(vRow.elementAt(10).toString().trim()));
            }
            catch(Exception e) {
                logger.warn("[setElement] Error al formatear la fecha: "+e);
            }
        }
			if(vRow.elementAt(11)!=null)
				this.CP = Integer.parseInt(vRow.elementAt(11).toString().trim());
    }
    	
   	
   	/**
	 * Obtenemos todos los propietarios de la BB.DD.
	 * 
	 * @return Vector con los propietarios de la BB.DD.
	 */
	public static Vector getClientes() {
		Vector vCli=new Vector();
		Vector vRtado=null;
		
		try {
			AbstractDBManager dbm = DBManager.getInstance();
			vRtado=dbm.executeQuery(SELECT_CLI);
		}
		catch(Exception e) {
			logger.error("Error al recuperar los clientes de la BB.DD: "+e);
			return new Vector();
		}

		if(vRtado!=null) {
			FEL_CLIENTE o=null;
			for(int i=0; i<vRtado.size(); i++) {
				o=new FEL_CLIENTE();
				o.setElement((Vector)vRtado.elementAt(i));
				vCli.add(o);
			}
		}

		return vCli;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto fel_cliente
	*/
	public FEL_CLIENTE loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT ID_CLIENTE,NOMBRE,APELLIDO1,APELLIDO2,DOMICILIO,POBLACION,ID_PROVINCIA,TELEFONO,TELEFONO2,FAX,FECHA_ALTA,CP FROM fel_cliente WHERE ID_CLIENTE=?");
		Vector vParams=new Vector();

		vParams.add(new Integer(nPK));
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
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto fel_cliente
	*/
	public FEL_CLIENTE loadFromNombre(String sNombre)
	{
		StringBuffer sSQL=new StringBuffer("SELECT ID_CLIENTE,NOMBRE,APELLIDO1,APELLIDO2,DOMICILIO,POBLACION,ID_PROVINCIA,TELEFONO,TELEFONO2,FAX,FECHA_ALTA,CP FROM fel_cliente WHERE NOMBRE=?");
		Vector vParams=new Vector();

		vParams.add(sNombre);
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
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto fel_cliente
	*/
	public FEL_CLIENTE loadFromTelefono(String sTelefono)
	{
		StringBuffer sSQL=new StringBuffer("SELECT ID_CLIENTE,NOMBRE,APELLIDO1,APELLIDO2,DOMICILIO,POBLACION,ID_PROVINCIA,TELEFONO,TELEFONO2,FAX,FECHA_ALTA,CP FROM fel_cliente WHERE TELEFONO=?");
		Vector vParams=new Vector();

		vParams.add(sTelefono);
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
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto fel_cliente
	*/
	public FEL_CLIENTE loadFromApellido(String sApellido)
	{
		StringBuffer sSQL=new StringBuffer("SELECT ID_CLIENTE,NOMBRE,APELLIDO1,APELLIDO2,DOMICILIO,POBLACION,ID_PROVINCIA,TELEFONO,TELEFONO2,FAX,FECHA_ALTA,CP FROM fel_cliente WHERE APELLIDO1=?");
		Vector vParams=new Vector();

		vParams.add(sApellido);
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
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto fel_cliente
	*/
	public FEL_CLIENTE loadFromContacto(String sNombre, String sApellido)
	{
		StringBuffer sSQL=new StringBuffer("SELECT ID_CLIENTE,NOMBRE,APELLIDO1,APELLIDO2,DOMICILIO,POBLACION,ID_PROVINCIA,TELEFONO,TELEFONO2,FAX,FECHA_ALTA,CP FROM fel_cliente WHERE NOMBRE=? AND APELLIDO1=?");
		Vector vParams=new Vector();

		vParams.add(sNombre);
		vParams.add(sApellido);
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
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams=new Vector();
		//-- Chequeamos a ver si es un objeto nuevo
		if(getID_CLIENTE()==-1) { // ** TO DO **
			sSQL = new StringBuffer("INSERT INTO fel_cliente ");
			sSQL.append("(NOMBRE,APELLIDO1,APELLIDO2,DOMICILIO,POBLACION,ID_PROVINCIA,TELEFONO,TELEFONO2,FAX,FECHA_ALTA,CP");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			
			vParams=new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getAPELLIDO1());
            vParams.add(getAPELLIDO2());
            vParams.add(getDOMICILIO());
            vParams.add(getPOBLACION());
            vParams.add(new Integer(getID_PROVINCIA()));
            vParams.add(getTELEFONO());
            vParams.add(getTELEFONO2());
            vParams.add(getFAX());

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

            vParams.add(new Integer(getCP()));
			
			
		}
		else {
			sSQL = new StringBuffer("UPDATE fel_cliente SET ");
			sSQL.append(", NOMBRE=?");
			sSQL.append(", APELLIDO1=?");
			sSQL.append(", APELLIDO2=?");
			sSQL.append(", DOMICILIO=?");
			sSQL.append(", POBLACION=?");
			sSQL.append(", ID_PROVINCIA=?");
			sSQL.append(", TELEFONO=?");
			sSQL.append(", TELEFONO2=?");
			sSQL.append(", FAX=?");
			sSQL.append(", FECHA_ALTA=?");
			sSQL.append(", CP=?");
			sSQL.append(" WHERE ID_CLIENTE=?");

		 	vParams=new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getAPELLIDO1());
            vParams.add(getAPELLIDO2());
            vParams.add(getDOMICILIO());
            vParams.add(getPOBLACION());
            vParams.add(new Integer(getID_PROVINCIA()));
            vParams.add(getTELEFONO());
            vParams.add(getTELEFONO2());
            vParams.add(getFAX());
            
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
            
            vParams.add(new Integer(getCP()));
            vParams.add(new Integer(getID_CLIENTE()));
		}

        AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(),vParams);
	}


	 /**
     * Borra el registro de la BB.DD.
     *
     * @return n&uacute;mero de registros modificados
     */
    public static int delete(int nId) throws java.sql.SQLException{
        StringBuffer sSQL=new StringBuffer("delete from FEL_CLIENTE where ID_CLIENTE=?");
        Vector vParams=new Vector();

        vParams=new Vector();
        vParams.add(new Integer(nId));

        AbstractDBManager dbm = DBManager.getInstance();
        return dbm.executeUpdate(sSQL.toString(),vParams);
    }





	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "fel_cliente-[ID_CLIENTE="+getID_CLIENTE()+",NOMBRE="+getNOMBRE()+",APELLIDO1="+getAPELLIDO1()+",APELLIDO2="+getAPELLIDO2()+",DOMICILIO="+getDOMICILIO()+",POBLACION="+getPOBLACION()+",ID_PROVINCIA="+getID_PROVINCIA()+",TELEFONO="+getTELEFONO()+",TELEFONO2="+getTELEFONO2()+",FAX="+getFAX()+",FECHA_ALTA="+getFECHA_ALTA()+",CP="+getCP()+"]";
	}
}
