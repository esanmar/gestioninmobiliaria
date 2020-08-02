package com.emesa.gestinm.dao;

import java.util.*;

import org.apache.log4j.Logger;

import net.seh.bbdd.AbstractDBManager;
import com.emesa.bbdd.DBManager;
import com.emesa.bbdd.cache.*;


/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Mon Jul 07 10:17:31 CEST 2003
 */
public class FEL_OFICINA
{
    /** Logger */
    static Logger logger = Logger.getLogger(FEL_OFICINA.class);

	//-- Atributos
	private int ID_OFICINA=-1;
	private String NOMBRE;
	private String DIRECCION;
	private String TELEFONO;
	private String EMAIL;
	private String FAX;
	private String LOCALIDAD="Logroño";
	private int ID_PROVINCIA=26;
	private int CP=0;

    /** <code>Hashtable</code> con <b>todas</b> las oficinas cacheadas: </i>ID_OFICINA --> Oficina<(i>*/
    static Hashtable hOficinas=new Hashtable();

    /**
     * Carga de la <code>Hashtable</code> de las oficinas
     */
    static {
        hOficinas=loadOffices();
    }

    /**
     * Carga las oficinas existentes en la BB.DD.
     *
     * @return <code>Hashtable</code> con <b>todas</b> las oficinas cacheadas: </i>ID_OFICINA --> Oficina<(i>
     */
    private static Hashtable loadOffices()
    {
        com.emesa.bbdd.cache.QueryCache.reloadQuery("oficinas");
        CacheObject co = QueryCache.get("oficinas");
        Vector vOficinas = co.getQueryResults();
        FEL_OFICINA o=null;
        Hashtable h=new Hashtable();
        for(int i=0; i<vOficinas.size(); i++) {
            o=new FEL_OFICINA();
            o.loadFromDB(Integer.parseInt( ((Vector)vOficinas.elementAt(i)).firstElement().toString() ),true);
            h.put(new Integer( ((Vector)vOficinas.elementAt(i)).firstElement().toString() ),
                    o);
        }

        logger.debug("[loadOffices] Cargada la caché: "+h);
        return h;
    }


	//-- GETs y SETs
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
     * Asigna CP
     *
     * @param unCP
     */
    public static Enumeration getOficinas()
    {
        return hOficinas.elements();
    }


    /**
    * Carga la informaci&oacute;n de la tabla en el objeto.
    *
    * @param nPK Clave primaria (hemos supuesto un entero)
    * @return Objeto FEL_OFICINA
    */
    public FEL_OFICINA loadFromDB(int nPK)
    {
        return loadFromDB(nPK,false);
    }

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @param toDB Indica si debemos cargarlo desde la BB.DD. (<code>true</code>) o
	* desde la cach&eacute;
	* @return Objeto FEL_OFICINA
	*/
	public FEL_OFICINA loadFromDB(int nPK, boolean toDB)
	{
	   //if(toDB) {
    		StringBuffer sSQL=new StringBuffer("SELECT ID_OFICINA,NOMBRE,DIRECCION,TELEFONO,EMAIL,FAX,LOCALIDAD,ID_PROVINCIA,CP FROM FEL_OFICINA WHERE ID_OFICINA=?");
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
    			//-- Solo puede haber un rtado puesto que ID_OFICINA es PK
    			setElement( (Vector)vRtado.firstElement() );
    		}
       // }
        // Cargamos desde la caché
       // else {
       //     setObject( (FEL_OFICINA)hOficinas.get(new Integer(nPK)) );
       // }

        return this;
	}

    /**
    * Carga la informaci&oacute;n de la tabla en el objeto.
    *
    * @param sNombre Nombre de la oficina
    * @return Objeto FEL_OFICINA
    */
    public FEL_OFICINA loadFromDB(String sNombre)
    {
        StringBuffer sSQL=new StringBuffer("SELECT ID_OFICINA,NOMBRE,DIRECCION,TELEFONO,EMAIL,FAX,LOCALIDAD,ID_PROVINCIA,CP FROM FEL_OFICINA WHERE NOMBRE like ?");
        Vector vParams=new Vector();

        vParams.add(sNombre);
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
            //-- Solo puede haber un rtado puesto que ID_OFICINA es PK
            setElement( (Vector)vRtado.firstElement() );
        }

        return this;
    }


    /**
    * Borra de BB.DD. y de la cach&eacute; la oficina identificada por el par&aacute;metro
    *
    * @return N&uacute;mero de registros modificados
    */
    public int delete() throws Exception
    {
        return delete(getID_OFICINA());
    }


    /**
    * Borra de BB.DD. y de la cach&eacute; la oficina identificada por el par&aacute;metro
    *
    * @param nIdOficina Identificador de la oficina
    * @return N&uacute;mero de registros modificados
    */
    public static int delete(int nIdOficina) throws Exception
    {
        StringBuffer sSQL=new StringBuffer("delete from FEL_OFICINA where ID_OFICINA=?");
        Vector vParams=new Vector();

        vParams.add(new Integer(nIdOficina));
        int nRtado=0;
        try {
            AbstractDBManager dbm = DBManager.getInstance();
            nRtado=dbm.executeUpdate(sSQL.toString(),vParams);
            // Actualizamos la caché
            if(nRtado!=0)
                hOficinas.remove(new Integer(nIdOficina));
        }
        catch(Exception e) {
            //-- Tratamiento de la excepcion
            System.err.println("[FEL_OFICINA][delete] Error: "+e.getMessage());

            throw e;
        }

        return nRtado;
    }


    /**
     */
    public void setElement(Vector vRow)
    {
        if(vRow.elementAt(0)!=null)
            this.ID_OFICINA = Integer.parseInt(vRow.elementAt(0).toString().trim());
        if(vRow.elementAt(1)!=null)
            this.NOMBRE = ((String)vRow.elementAt(1)).trim();
        if(vRow.elementAt(2)!=null)
            this.DIRECCION = ((String)vRow.elementAt(2)).trim();
        if(vRow.elementAt(3)!=null)
            this.TELEFONO = ((String)vRow.elementAt(3)).trim();
        if(vRow.elementAt(4)!=null)
            this.EMAIL = ((String)vRow.elementAt(4)).trim();
        if(vRow.elementAt(5)!=null)
            this.FAX = ((String)vRow.elementAt(5)).trim();
        if(vRow.elementAt(6)!=null)
            this.LOCALIDAD = ((String)vRow.elementAt(6)).trim();
        if(vRow.elementAt(7)!=null)
            this.ID_PROVINCIA = Integer.parseInt(vRow.elementAt(7).toString().trim());
        if(vRow.elementAt(8)!=null)
            this.CP = Integer.parseInt(vRow.elementAt(8).toString().trim());;
    }


    /**
     */
    public void setObject(FEL_OFICINA o) {
        setEMAIL(o.getEMAIL());
        setFAX(o.getFAX());
        setID_OFICINA(o.getID_OFICINA());
        setID_PROVINCIA(o.getID_PROVINCIA());
        setLOCALIDAD(o.getLOCALIDAD());
        setNOMBRE(o.getNOMBRE());
        setTELEFONO(o.getTELEFONO());
        setCP(o.getCP());
        setDIRECCION(o.getDIRECCION());
    }

	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams=new Vector();
		//-- Chequeamos a ver si es un objeto nuevo
		if(getID_OFICINA()==-1) {
			sSQL = new StringBuffer("INSERT INTO FEL_OFICINA ");
			sSQL.append("(NOMBRE,DIRECCION,TELEFONO,EMAIL,FAX,LOCALIDAD,ID_PROVINCIA,CP");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?)");

            vParams = new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getDIRECCION());
            vParams.add(getTELEFONO());
            vParams.add(getEMAIL());
            vParams.add(getFAX());
            vParams.add(getLOCALIDAD());
            vParams.add(new Integer(getID_PROVINCIA()));
            vParams.add(new Integer(getCP()));
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_OFICINA SET ");
            sSQL.append("NOMBRE=?");
            sSQL.append(", DIRECCION=?");
            sSQL.append(", TELEFONO=?");
            sSQL.append(", EMAIL=?");
            sSQL.append(", FAX=?");
            sSQL.append(", LOCALIDAD=?");
            sSQL.append(", ID_PROVINCIA=?");
            sSQL.append(", CP=?");
			sSQL.append(" WHERE ID_OFICINA=?");

            vParams = new Vector();
            vParams.add(getNOMBRE());
            vParams.add(getDIRECCION());
            vParams.add(getTELEFONO());
            vParams.add(getEMAIL());
            vParams.add(getFAX());
            vParams.add(getLOCALIDAD());
            vParams.add(new Integer(getID_PROVINCIA()));
            vParams.add(new Integer(getCP()));
            vParams.add(new Integer(getID_OFICINA()));
        }

        AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(),vParams);

        //-- Actualizamos la caché
        hOficinas=loadOffices();
	}


	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "FEL_OFICINA-[ID_OFICINA="+getID_OFICINA()+",NOMBRE="+getNOMBRE()+",DIRECCION="+getDIRECCION()+",TELEFONO="+getTELEFONO()+",EMAIL="+getEMAIL()+",FAX="+getFAX()+",LOCALIDAD="+getLOCALIDAD()+",ID_PROVINCIA="+getID_PROVINCIA()+",CP="+getCP()+"]";
	}
}
