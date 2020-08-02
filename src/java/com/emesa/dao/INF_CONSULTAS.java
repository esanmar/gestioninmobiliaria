package com.emesa.dao;

import java.util.Properties;
import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Thu Jul 10 12:21:01 CEST 2003
 */
public class INF_CONSULTAS
{
    /** Logger */
    static Logger logger = Logger.getLogger(INF_CONSULTAS.class);

    //-- Atributos
	private int ID_CONSULTA=-1;
	private String NOMBRE;
	private String DESCRIPCION;
	private String QUERY;
	private int ID_BBDD;
	private String TIPO_USUARIO;


	//-- GETs y SETs
	/**
	 * Devuelve ID_CONSULTA
	 *
	 * @return ID_CONSULTA
	 */
	public int getID_CONSULTA()
	{
		return this.ID_CONSULTA;
	}

	/**
	 * Asigna ID_CONSULTA
	 *
	 * @param unID_CONSULTA
	 */
	public void setID_CONSULTA(int unID_CONSULTA)
	{
		this.ID_CONSULTA = unID_CONSULTA;
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
	 * Devuelve QUERY
	 *
	 * @return QUERY
	 */
	public String getQUERY()
	{
		return this.QUERY;
	}

	/**
	 * Asigna QUERY
	 *
	 * @param unQUERY
	 */
	public void setQUERY(String unQUERY)
	{
		this.QUERY = unQUERY;
	}

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
	 * Devuelve TIPO_USUARIO
	 *
	 * @return TIPO_USUARIO
	 */
	public String getTIPO_USUARIO()
	{
		return this.TIPO_USUARIO;
	}

	/**
	 * Asigna TIPO_USUARIO
	 *
	 * @param unTIPO_USUARIO
	 */
	public void setTIPO_USUARIO(String unTIPO_USUARIO)
	{
		this.TIPO_USUARIO = unTIPO_USUARIO;
	}

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto INF_CONSULTAS
	*/
	public INF_CONSULTAS loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT ID_CONSULTA,NOMBRE,DESCRIPCION,QUERY,ID_BBDD,TIPO_USUARIO FROM INF_CONSULTAS WHERE ID_CONSULTA=?");
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
			setElement( (Vector)vRtado.firstElement() );
		}

        return this;
	}

    /**
    * Carga la informaci&oacute;n de la tabla en el objeto.
    *
    * @param sNombre Nombre que le hemos dado a la consulta
    * @return Objeto INF_CONSULTAS
    */
    public INF_CONSULTAS loadFromDB(String sNombre)
    {
        StringBuffer sSQL=new StringBuffer("SELECT ID_CONSULTA,NOMBRE,DESCRIPCION,QUERY,ID_BBDD,TIPO_USUARIO FROM INF_CONSULTAS WHERE NOMBRE like ?");
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
            this.ID_CONSULTA = Integer.parseInt( vRow.elementAt(0).toString().trim() );
        if(vRow.elementAt(1)!=null)
            this.NOMBRE = vRow.elementAt(1).toString().trim();
        if(vRow.elementAt(2)!=null)
            this.DESCRIPCION = vRow.elementAt(2).toString().trim();
        if(vRow.elementAt(3)!=null)
            this.QUERY = vRow.elementAt(3).toString().trim();
        if(vRow.elementAt(4)!=null)
            this.ID_BBDD = Integer.parseInt( vRow.elementAt(4).toString().trim() );
        if(vRow.elementAt(5)!=null)
            this.TIPO_USUARIO = vRow.elementAt(5).toString().trim();
    }


    /**
     * Ejecuta la <i>query</i> indicada contra la base de datos que se se&ntilde;ale
     *
     * @param nIdBBDD Identificador de la base de datos contra la que se va a probar
     * la <i>query</i>
     * @param sQuery <i>Query</i> a ejecutar
     * @param vParams Vector con el valor de los par&aacute;metros
     * @return Vector con el resultado de ejecutar la <i>query</i> con los par&aacute;metros
     * indicados
     */
    public static Vector test(int nIdBBDD,String sQuery, Vector vParams) throws java.sql.SQLException, ClassNotFoundException {
        INF_BBDD o=new INF_BBDD();
        o.loadFromDB(nIdBBDD);
        AbstractDBManager dbm=null;
        if(o.getJNDI()!=null) {
            dbm=net.seh.bbdd.DBManager.getInstance(o.getJNDI());
        }
        else {
            Properties p=new Properties();
            p.put("user",o.getUSUARIO());
            p.put("password",o.getCLAVE());

            dbm=net.seh.bbdd.DBManager.getInstance(o.getDRIVER(),o.getURL(),p);
        }

        return dbm.executeQuery(sQuery,vParams);
    }


	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams=new Vector();
		//-- Chequeamos a ver si es un objeto nuevo
		if(getID_CONSULTA()==-1) {
			sSQL = new StringBuffer("INSERT INTO INF_CONSULTAS ");
			sSQL.append("(NOMBRE,DESCRIPCION,QUERY,ID_BBDD,TIPO_USUARIO");
			sSQL.append(") VALUES (?,?,?,?,?)");

            vParams=new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getDESCRIPCION());
            vParams.add(getQUERY());
            vParams.add(new Integer(getID_BBDD()));
            vParams.add(getTIPO_USUARIO());
		}
		else {
			sSQL = new StringBuffer("UPDATE INF_CONSULTAS SET ");
			sSQL.append("NOMBRE=?");
            sSQL.append(", DESCRIPCION=?");
            sSQL.append(", QUERY=?");
            sSQL.append(", ID_BBDD=?");
            sSQL.append(", TIPO_USUARIO=?");
			sSQL.append(" WHERE ID_CONSULTA=?");

            vParams=new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getDESCRIPCION());
            vParams.add(getQUERY());
            vParams.add(new Integer(getID_BBDD()));
            vParams.add(getTIPO_USUARIO());
            vParams.add(new Integer(getID_CONSULTA()));
		}

		AbstractDBManager dbm = DBManager.getInstance();
		dbm.executeUpdate(sSQL.toString(),vParams);
	}


    /**
    * Elimina el objeto de la BB.DD.
    *
    * @return N&uacute;mero de registros afectados
    */
    public int delete() throws java.sql.SQLException
    {
        StringBuffer sSQL=new StringBuffer("delete from INF_CONSULTAS where ID_CONSULTA=?");

        Vector vParams=new Vector();
        vParams.add(new Integer(getID_CONSULTA()));

        AbstractDBManager dbm = DBManager.getInstance();
        int n=dbm.executeUpdate(sSQL.toString(),vParams);

        // Borramos ahora todos los parámetros asociados a la consulta
        sSQL=new StringBuffer("delete from INF_PARAMETROS where ID_CONSULTA=?");
        try {
            dbm.executeUpdate(sSQL.toString(),vParams);
        }
        catch(Exception e) {
            logger.warn("[delete] Error al borrar los parámetros de la consulta "+getID_CONSULTA()+": "+e);
        }

        return n;
    }


	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "INF_CONSULTAS-[ID_CONSULTA="+getID_CONSULTA()+",NOMBRE="+getNOMBRE()+",DESCRIPCION="+getDESCRIPCION()+",QUERY="+getQUERY()+",ID_BBDD="+getID_BBDD()+",TIPO_USUARIO="+getTIPO_USUARIO()+"]";
	}
}
