package com.emesa.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Thu Jul 10 12:20:49 CEST 2003
 */
public class INF_BBDD
{
	//-- Atributos
	private int ID_BBDD=-1;
	private String NOMBRE;
	private String DRIVER;
	private String URL;
	private String USUARIO="";
	private String CLAVE="";
	private String JNDI;


	//-- GETs y SETs
	/**
	 * Devuelve ID_BBDD
	 *
	 * @return ID_BBDD
	 */
	public int getID_BBDD()
	{
		return this.ID_BBDD;
	}

	/**
	 * Asigna ID_BBDD
	 *
	 * @param unID_BBDD
	 */
	public void setID_BBDD(int unID_BBDD)
	{
		this.ID_BBDD = unID_BBDD;
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
	 * Devuelve DRIVER
	 *
	 * @return DRIVER
	 */
	public String getDRIVER()
	{
		return this.DRIVER;
	}

	/**
	 * Asigna DRIVER
	 *
	 * @param unDRIVER
	 */
	public void setDRIVER(String unDRIVER)
	{
		this.DRIVER = unDRIVER;
	}

	/**
	 * Devuelve URL
	 *
	 * @return URL
	 */
	public String getURL()
	{
		return this.URL;
	}

	/**
	 * Asigna URL
	 *
	 * @param unURL
	 */
	public void setURL(String unURL)
	{
		this.URL = unURL;
	}

	/**
	 * Devuelve USUARIO
	 *
	 * @return USUARIO
	 */
	public String getUSUARIO()
	{
		return this.USUARIO;
	}

	/**
	 * Asigna USUARIO
	 *
	 * @param unUSUARIO
	 */
	public void setUSUARIO(String unUSUARIO)
	{
		this.USUARIO = unUSUARIO;
	}

	/**
	 * Devuelve CLAVE
	 *
	 * @return CLAVE
	 */
	public String getCLAVE()
	{
		return this.CLAVE;
	}

	/**
	 * Asigna CLAVE
	 *
	 * @param unCLAVE
	 */
	public void setCLAVE(String unCLAVE)
	{
		this.CLAVE = unCLAVE;
	}

	/**
	 * Devuelve JNDI
	 *
	 * @return JNDI
	 */
	public String getJNDI()
	{
		return this.JNDI;
	}

	/**
	 * Asigna JNDI
	 *
	 * @param unJNDI
	 */
	public void setJNDI(String unJNDI)
	{
		this.JNDI = unJNDI;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto INF_BBDD
	*/
	public INF_BBDD loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT ID_BBDD,NOMBRE,DRIVER,URL,USUARIO,CLAVE,JNDI FROM INF_BBDD WHERE ID_BBDD=?");
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
			//-- Solo puede haber un rtado puesto que ID_BBDD es PK
			setElement( (Vector)vRtado.firstElement() );
		}

		 return this;
	}


    /**
    * Carga la informaci&oacute;n de la tabla en el objeto.
    *
    * @param sNombre Nombre asignado a la conexi&oacute;n con la BB.DD.
    * @return Objeto INF_BBDD
    */
    public INF_BBDD loadFromDB(String sNombre)
    {
        StringBuffer sSQL=new StringBuffer("SELECT ID_BBDD,NOMBRE,DRIVER,URL,USUARIO,CLAVE,JNDI FROM INF_BBDD WHERE NOMBRE like ?");
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
            setElement( (Vector)vRtado.firstElement() );
        }

        return this;
    }


    /**
     * Asignaci&oacute;n de los valores del registro al objeto
     *
     * @param vRow Vector que representa un registro en la BB.DD.
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            this.ID_BBDD = Integer.parseInt(vRow.elementAt(0).toString().trim());
        if(vRow.elementAt(1)!=null)
            this.NOMBRE = ((String)vRow.elementAt(1)).trim();
        if(vRow.elementAt(2)!=null)
            this.DRIVER = ((String)vRow.elementAt(2)).trim();
        if(vRow.elementAt(3)!=null)
            this.URL = ((String)vRow.elementAt(3)).trim();
        if(vRow.elementAt(4)!=null)
            this.USUARIO = ((String)vRow.elementAt(4)).trim();
        if(vRow.elementAt(5)!=null)
            this.CLAVE = ((String)vRow.elementAt(5)).trim();
        if(vRow.elementAt(6)!=null)
            this.JNDI = ((String)vRow.elementAt(6)).trim();
    }

	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
        Vector vParams=new Vector();
		//-- Chequeamos a ver si es un objeto nuevo
		if(getID_BBDD()==-1) {
			sSQL = new StringBuffer("INSERT INTO INF_BBDD ");
			sSQL.append("(NOMBRE,DRIVER,URL,USUARIO,CLAVE,JNDI");
			sSQL.append(") VALUES (?,?,?,?,?,?)");

            vParams = new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getDRIVER());
            vParams.add(getURL());
            vParams.add(getUSUARIO());
            vParams.add(getCLAVE());
            vParams.add(getJNDI());
		}
		else {
			sSQL = new StringBuffer("UPDATE INF_BBDD SET ");
            sSQL.append(" NOMBRE=?");
            sSQL.append(", DRIVER=?");
            sSQL.append(", URL=?");
            sSQL.append(", USUARIO=?");
            sSQL.append(", CLAVE=?");
			sSQL.append(", JNDI=?");
			sSQL.append(" WHERE ID_BBDD=?");

            vParams = new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getDRIVER());
            vParams.add(getURL());
            vParams.add(getUSUARIO());
            vParams.add(getCLAVE());
            vParams.add(getJNDI());
            vParams.add(new Integer(getID_BBDD()));
		}

		AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(),vParams);

        // Actualizamos la caché
        com.emesa.bbdd.cache.QueryCache.reloadQuery("base_datos");
	}


    /**
    * Elimina el objeto de la BB.DD.
    *
    * @return N&uacute;mero de registros afectados
    */
    public int delete() throws java.sql.SQLException
    {
        StringBuffer sSQL=new StringBuffer("delete from INF_BBDD where ID_BBDD=?");

        Vector vParams=new Vector();
        vParams.add(new Integer(getID_BBDD()));

        AbstractDBManager dbm = DBManager.getInstance();
        int n=dbm.executeUpdate(sSQL.toString(),vParams);

        // Actualizamos la caché
        com.emesa.bbdd.cache.QueryCache.reloadQuery("base_datos");

        return n;
    }

	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "INF_BBDD-[ID_BBDD="+getID_BBDD()+",NOMBRE="+getNOMBRE()+",DRIVER="+getDRIVER()+",URL="+getURL()+",USUARIO="+getUSUARIO()+",CLAVE="+getCLAVE()+",JNDI="+getJNDI()+"]";
	}
}
