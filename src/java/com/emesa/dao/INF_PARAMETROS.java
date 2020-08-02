package com.emesa.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Thu Jul 10 12:21:06 CEST 2003
 */
public class INF_PARAMETROS
{
	//-- Atributos
	private int ID_PARAMETRO=-1;
	private String NOMBRE;
    private String NOMBRE_MOSTRAR;
	private String DESCRIPCION;
	private String TIPO;
	private String ACCION="";
	private int ID_CONSULTA;


	//-- GETs y SETs
	/**
	 * Devuelve ID_PARAMETRO
	 *
	 * @return ID_PARAMETRO
	 */
	public int getID_PARAMETRO()
	{
		return this.ID_PARAMETRO;
	}

	/**
	 * Asigna ID_PARAMETRO
	 *
	 * @param unID_PARAMETRO
	 */
	public void setID_PARAMETRO(int unID_PARAMETRO)
	{
		this.ID_PARAMETRO = unID_PARAMETRO;
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
     * Devuelve NOMBRE_MOSTRAR
     *
     * @return NOMBRE_MOSTRAR
     */
    public String getNOMBRE_MOSTRAR()
    {
        return this.NOMBRE_MOSTRAR;
    }

    /**
     * Asigna NOMBRE_MOSTRAR
     *
     * @param unNOMBRE
     */
    public void setNOMBRE_MOSTRAR(String unNOMBRE)
    {
        this.NOMBRE_MOSTRAR = unNOMBRE;
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
	 * Devuelve ACCION
	 *
	 * @return ACCION
	 */
	public String getACCION()
	{
		return this.ACCION;
	}

	/**
	 * Asigna ACCION
	 *
	 * @param unACCION
	 */
	public void setACCION(String unACCION)
	{
		this.ACCION = unACCION;
	}

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
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto INF_PARAMETROS
	*/
	public INF_PARAMETROS loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT ID_PARAMETRO,NOMBRE,DESCRIPCION,TIPO,ACCION,ID_CONSULTA,NOMBRE_MOSTRAR FROM INF_PARAMETROS WHERE ID_PARAMETRO=?");
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
     * Asignaci&oacute;n de los valores del registro al objeto
     *
     * @param vRow Vector que representa un registro en la BB.DD.
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            this.ID_PARAMETRO = Integer.parseInt(vRow.elementAt(0).toString().trim());
        if(vRow.elementAt(1)!=null)
            this.NOMBRE = vRow.elementAt(1).toString().trim();
        if(vRow.elementAt(2)!=null)
            this.DESCRIPCION = vRow.elementAt(2).toString().trim();
        if(vRow.elementAt(3)!=null)
            this.TIPO = vRow.elementAt(3).toString().trim();
        if(vRow.elementAt(4)!=null)
            this.ACCION = vRow.elementAt(4).toString().trim();
        if(vRow.elementAt(5)!=null)
            this.ID_CONSULTA = Integer.parseInt(vRow.elementAt(5).toString().trim());
        if(vRow.elementAt(6)!=null)
            this.NOMBRE_MOSTRAR = vRow.elementAt(6).toString().trim();
    }

	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams=new Vector();
		//-- Chequeamos a ver si es un objeto nuevo
		if(getID_PARAMETRO()==-1) {
			sSQL = new StringBuffer("INSERT INTO INF_PARAMETROS ");
			sSQL.append("(NOMBRE,DESCRIPCION,TIPO,ACCION,ID_CONSULTA,NOMBRE_MOSTRAR");
			sSQL.append(") VALUES (?,?,?,?,?,?)");

            vParams=new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getDESCRIPCION());
            vParams.add(getTIPO());
            vParams.add(getACCION());
            vParams.add(new Integer(getID_CONSULTA()));
            if(getNOMBRE_MOSTRAR()==null)
                vParams.add(getNOMBRE());
            else
                vParams.add(getNOMBRE_MOSTRAR());
		}
		else {
			sSQL = new StringBuffer("UPDATE INF_PARAMETROS SET ");
			sSQL.append("NOMBRE=?");
            sSQL.append(", DESCRIPCION=?");
            sSQL.append(", TIPO=?");
            sSQL.append(", ACCION=?");
            sSQL.append(", ID_CONSULTA=?");
            sSQL.append(", NOMBRE_MOSTRAR=?");
            sSQL.append(" WHERE ID_PARAMETRO=?");

            vParams=new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getDESCRIPCION());
            vParams.add(getTIPO());
            vParams.add(getACCION());
            vParams.add(new Integer(getID_CONSULTA()));
            if(getNOMBRE_MOSTRAR()==null)
                vParams.add(getNOMBRE());
            else
                vParams.add(getNOMBRE_MOSTRAR());
            vParams.add(new Integer(getID_PARAMETRO()));
		}

        AbstractDBManager dbm = DBManager.getInstance();
		dbm.executeUpdate(sSQL.toString(),vParams);
	}

    /**
     *
     * @param idQuery Identificador de la consulta
     * @param Vector de <code>FEL_PARAMETROS</code>
     */
    public static Vector paramsOfQuery(int idQuery) throws java.sql.SQLException{
        String sSQL="SELECT ID_PARAMETRO,NOMBRE,DESCRIPCION,TIPO,ACCION,ID_CONSULTA,NOMBRE_MOSTRAR FROM INF_PARAMETROS WHERE ID_CONSULTA=? order by ID_PARAMETRO ASC";

        AbstractDBManager dbm = DBManager.getInstance();
        Vector vParams=new Vector();
        vParams.add(new Integer(idQuery));

        Vector vRtado=dbm.executeQuery(sSQL,vParams);
        if(vRtado==null || vRtado.isEmpty())
            return new Vector();
        else {
            Vector vReturn=new Vector();
            INF_PARAMETROS o=null;
            for(int i=0; i<vRtado.size(); i++) {
                o=new INF_PARAMETROS();
                o.setElement( (Vector) vRtado.elementAt(i) );

                vReturn.add(o);
            }

            return vReturn;
        }
    }

	/** Representaci&oacute;n del objeto */
	public String toString()
	{
        return "INF_PARAMETROS-[ID_PARAMETRO="+getID_PARAMETRO()+",NOMBRE="+getNOMBRE()+",NOMBRE_MOSTRAR="+getNOMBRE_MOSTRAR()+",DESCRIPCION="+getDESCRIPCION()+",TIPO="+getTIPO()+",ACCION="+getACCION()+",ID_CONSULTA="+getID_CONSULTA()+"]";
	}
}
