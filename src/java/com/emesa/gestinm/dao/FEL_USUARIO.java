package com.emesa.gestinm.dao;

import java.util.*;
import org.apache.catalina.realm.RealmBase; // Función de encriptación
import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;
import net.seh.bbdd.AbstractDBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Mon Jul 07 08:49:40 CEST 2003
 */
public class FEL_USUARIO
{
	//-- Atributos
	private int ID_USUARIO=-1;
	private int ID_TIPO_USUARIO=com.emesa.gestinm.bbdd.cache.CacheUtil.getID_TIPO_USUARIO("INVITADO");
	private String NOMBRE;
	private String APELLIDO1;
	private String APELLIDO2;
	private int ID_OFICINA;
	private String TELEFONO;
	private String EMAIL;
	private String DIRECCION;
	private String ALIAS;
	private String CLAVE;
	private String LOCALIDAD;
    private int CP=0;
    private int ID_PROVINCIA=26;

    private static final String CRYPT_MODE = com.emesa.Configuration.getProperty("digest");
    private static final String SELECT_FROM="SELECT ID_USUARIO,ID_TIPO_USUARIO,NOMBRE,APELLIDO1,APELLIDO2,ID_OFICINA,TELEFONO,EMAIL,DIRECCION,ALIAS,CLAVE,LOCALIDAD,ID_PROVINCIA,CP FROM FEL_USUARIO";

    /** Logger */
    static Logger logger = Logger.getLogger(FEL_USUARIO.class);


	//-- GETs y SETs
	/**
	 * Devuelve ID_USUARIO
	 *
	 * @return ID_USUARIO
	 */
	public int getID_USUARIO()
	{
		return this.ID_USUARIO;
	}

	/**
	 * Asigna ID_USUARIO
	 *
	 * @param unID_USUARIO
	 */
	public void setID_USUARIO(int unID_USUARIO)
	{
		this.ID_USUARIO = unID_USUARIO;
	}

	/**
	 * Devuelve ID_TIPO_USUARIO
	 *
	 * @return ID_TIPO_USUARIO
	 */
	public int getID_TIPO_USUARIO()
	{
		return this.ID_TIPO_USUARIO;
	}

	/**
	 * Asigna ID_TIPO_USUARIO
	 *
	 * @param unID_TIPO_USUARIO
	 */
	public void setID_TIPO_USUARIO(int unID_TIPO_USUARIO)
	{
		this.ID_TIPO_USUARIO = unID_TIPO_USUARIO;
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
	 * Devuelve ID_OFICINA
	 *
	 * @return ID_OFICINA
	 */
	public int getID_OFICINA()
	{
		return this.ID_OFICINA;
	}

	/**
	 * Asigna ID_OFICINA
	 *
	 * @param unID_OFICINA
	 */
	public void setID_OFICINA(int unID_OFICINA)
	{
		this.ID_OFICINA = unID_OFICINA;
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
	 * Devuelve EMAIL
	 *
	 * @return EMAIL
	 */
	public String getEMAIL()
	{
		return this.EMAIL;
	}

	/**
	 * Asigna EMAIL
	 *
	 * @param unEMAIL
	 */
	public void setEMAIL(String unEMAIL)
	{
		this.EMAIL = unEMAIL;
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
	 * Devuelve ALIAS
	 *
	 * @return ALIAS
	 */
	public String getALIAS()
	{
		return this.ALIAS;
	}

	/**
	 * Asigna ALIAS
	 *
	 * @param unALIAS
	 */
	public void setALIAS(String unALIAS)
	{
		this.ALIAS = unALIAS;
	}

    /**
     * Devuelve LOCALIDAD
     *
     * @return LOCALIDAD
     */
    public String getLOCALIDAD()
    {
        return this.LOCALIDAD;
    }

    /**
     * Asigna LOCALIDAD
     *
     * @param unLOCALIDAD
     */
    public void setLOCALIDAD(String unLOCALIDAD)
    {
        this.LOCALIDAD = unLOCALIDAD;
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
     * Asigna CLAVE <b>&iexcl;ya encriptada!</b>
     *
     * @param unCLAVE
     */
    public void setCLAVE(String unCLAVE)
    {
        if(unCLAVE==null)
            this.CLAVE = "";
        else
            this.CLAVE = unCLAVE;
    }

    /**
     * Asigna CLAVE <b>sin encriptar</b>
     *
     * @param unCLAVE
     */
    public void setToEncryptCLAVE(String unCLAVE)
    {
        String sToEncrypt = unCLAVE;
        if(unCLAVE==null)
            sToEncrypt = "";

        // La clave DOBLEMENTE encriptada
        setCLAVE(RealmBase.Digest(
                    RealmBase.Digest(unCLAVE,CRYPT_MODE),
                    CRYPT_MODE));
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
     * Asigna CP
     *
     * @param unCP
     */
    public void setCP(int unCP)
    {
        this.CP = unCP;
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
     * Asigna ID_PROVINCIA
     *
     * @param unID_PROVINCIA
     */
    public void setID_PROVINCIA(int unID_PROVINCIA)
    {
        this.ID_PROVINCIA = unID_PROVINCIA;
    }


	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto FEL_USUARIO
	*/
	public FEL_USUARIO loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer(SELECT_FROM+" WHERE ID_USUARIO=?");
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
    * Carga la informaci&oacute;n de la tabla en el objeto.
    *
    * @param s Alias del usuario
    * @return Objeto FEL_USUARIO
    */
    public FEL_USUARIO loadFromDB(String s)
    {
        StringBuffer sSQL=new StringBuffer(SELECT_FROM+" WHERE ALIAS like ?");
        Vector vParams=new Vector();

        vParams.add(s);
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
    * Carga la informaci&oacute;n de la tabla en el objeto.
    *
    * @param sNombre Nombre del usuario
    * @param sApel1 Primer apellido del usuario
    * @return Objeto FEL_USUARIO
    */
    public FEL_USUARIO loadFromDB(String sNombre, String sApel1)
    {
        StringBuffer sSQL=new StringBuffer(SELECT_FROM+" WHERE NOMBRE like ? and APELLIDO1 like ?");
        Vector vParams=new Vector();

        vParams.add(sNombre);
        vParams.add(sApel1);
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
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            this.ID_USUARIO = Integer.parseInt( ((String)vRow.elementAt(0)).trim() );
        if(vRow.elementAt(1)!=null)
            this.ID_TIPO_USUARIO = Integer.parseInt( ((String)vRow.elementAt(1)).trim() );
        if(vRow.elementAt(2)!=null)
            this.NOMBRE = ((String)vRow.elementAt(2)).trim();
        if(vRow.elementAt(3)!=null)
            this.APELLIDO1 = ((String)vRow.elementAt(3)).trim();
        if(vRow.elementAt(4)!=null)
            this.APELLIDO2 = ((String)vRow.elementAt(4)).trim();
        if(vRow.elementAt(5)!=null)
            this.ID_OFICINA = Integer.parseInt( ((String)vRow.elementAt(5)).trim() );
        if(vRow.elementAt(6)!=null)
            this.TELEFONO = ((String)vRow.elementAt(6)).trim();
        if(vRow.elementAt(7)!=null)
            this.EMAIL = ((String)vRow.elementAt(7)).trim();
        if(vRow.elementAt(8)!=null)
            this.DIRECCION = ((String)vRow.elementAt(8)).trim();
        if(vRow.elementAt(9)!=null)
            this.ALIAS = ((String)vRow.elementAt(9)).trim();
        if(vRow.elementAt(10)!=null)
            this.CLAVE = ((String)vRow.elementAt(10)).trim();
        if(vRow.elementAt(11)!=null)
            setLOCALIDAD(((String)vRow.elementAt(11)).trim());
        if(vRow.elementAt(12)!=null)
            setID_PROVINCIA(Integer.parseInt(vRow.elementAt(12).toString().trim()));
        if(vRow.elementAt(13)!=null)
            setCP(Integer.parseInt(vRow.elementAt(13).toString().trim()));
    }

	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams=null;
		//-- Chequeamos a ver si es un objeto nuevo
		if(getID_USUARIO()==-1) {
			sSQL = new StringBuffer("INSERT INTO FEL_USUARIO ");
			sSQL.append("(ID_TIPO_USUARIO,NOMBRE,APELLIDO1,APELLIDO2,ID_OFICINA,TELEFONO,EMAIL,DIRECCION,ALIAS,CLAVE,LOCALIDAD,ID_PROVINCIA,CP");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

            vParams=new Vector();
            vParams.add(new Integer(getID_TIPO_USUARIO()));
            vParams.add(getNOMBRE());
            vParams.add(getAPELLIDO1());
            vParams.add(getAPELLIDO2());
            vParams.add(new Integer(getID_OFICINA()));
            vParams.add(getTELEFONO());
            vParams.add(getEMAIL());
            vParams.add(getDIRECCION());
            vParams.add(getALIAS());

            vParams.add(getCLAVE());

            vParams.add(getLOCALIDAD());
            vParams.add(new Integer(getID_PROVINCIA()));
            vParams.add(new Integer(getCP()));
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_USUARIO SET ");
            sSQL.append("ID_TIPO_USUARIO=?");
            sSQL.append(", NOMBRE=?");
            sSQL.append(", APELLIDO1=?");
            sSQL.append(", APELLIDO2=?");
            sSQL.append(", ID_OFICINA=?");
            sSQL.append(", TELEFONO=?");
            sSQL.append(", EMAIL=?");
            sSQL.append(", DIRECCION=?");
            sSQL.append(", ALIAS=?");
			sSQL.append(", CLAVE=?");
            sSQL.append(", LOCALIDAD=?");
            sSQL.append(", ID_PROVINCIA=?");
            sSQL.append(", CP=?");
			sSQL.append(" WHERE ID_USUARIO=?");

            vParams=new Vector();
            vParams.add(new Integer(getID_TIPO_USUARIO()));
            vParams.add(getNOMBRE());
            vParams.add(getAPELLIDO1());
            vParams.add(getAPELLIDO2());
            vParams.add(new Integer(getID_OFICINA()));
            vParams.add(getTELEFONO());
            vParams.add(getEMAIL());
            vParams.add(getDIRECCION());
            vParams.add(getALIAS());

            // En un UPDATE no se encripta la clave
            vParams.add(getCLAVE());

            vParams.add(getLOCALIDAD());
            vParams.add(new Integer(getID_PROVINCIA()));
            vParams.add(new Integer(getCP()));

            vParams.add(new Integer(getID_USUARIO()));
		}

        //logger.debug("[saveToDB] Ejecutamos: "+sSQL.toString()+"-"+vParams);
        AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(),vParams);
	}


    /**
    * Elimina el registro asociado al identificador
    *
    * @param nId Identificador del usuario
    * @return N&uacute;mero de registros afectados
    */
    public int delete() throws java.sql.SQLException
    {
        return delete(getID_USUARIO());
    }


    /**
    * Elimina el registro asociado al identificador
    *
    * @param nId Identificador del usuario
    * @return N&uacute;mero de registros afectados
    */
    public static int delete(int nId) throws java.sql.SQLException
    {
        StringBuffer sSQL=null;
        Vector vParams=new Vector();
        sSQL = new StringBuffer("delete from FEL_USUARIO where ID_USUARIO=?");
        vParams.add(new Integer(nId));

        AbstractDBManager dbm = DBManager.getInstance();
        return dbm.executeUpdate(sSQL.toString(),vParams);
    }


    /**
    * Comprobamos si ya existe un usuario con ese nombre (alias)
    *
    * @return <code>true</code> si ya existe ese alias en la BB.DD. y <code>false</code> en caso contrario.
    */
    public boolean existsAlias()
    {
        return existsAlias(getALIAS());
    }

    /**
    * Comprobamos si ya existe un usuario con ese nombre (alias)
    *
    * @param sAlias Alias a comprobar en BB.DD.
    * @return <code>true</code> si ya existe ese alias en la BB.DD. y <code>false</code> en caso contrario.
    */
    public static boolean existsAlias(String sAlias)
    {
        StringBuffer sSQL=new StringBuffer("select ALIAS from FEL_USUARIO WHERE ALIAS= ?");
        Vector vParams = new Vector();

        vParams.add(sAlias);

        Vector vRtado = new Vector();
        try {
            AbstractDBManager dbm = DBManager.getInstance();
            vRtado=dbm.executeQuery(sSQL.toString(),vParams);
        }
        catch(Exception e) {
            //-- Tratamiento de la excepcion
            logger.error("[existsAlias] Error al realizar el chequeo del alias: "+e);
            return false;
        }

        if(vRtado!=null && !vRtado.isEmpty())
            return true;
        else
            return false;
    }


	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "FEL_USUARIO-[ID_USUARIO="+getID_USUARIO()+",ID_TIPO_USUARIO="+getID_TIPO_USUARIO()+",NOMBRE="+getNOMBRE()+",APELLIDO1="+getAPELLIDO1()+",APELLIDO2="+getAPELLIDO2()+",ID_OFICINA="+getID_OFICINA()+",TELEFONO="+getTELEFONO()+",EMAIL="+getEMAIL()+",DIRECCION="+getDIRECCION()+",ALIAS="+getALIAS()+",CLAVE="+getCLAVE()+"]";
	}
}
