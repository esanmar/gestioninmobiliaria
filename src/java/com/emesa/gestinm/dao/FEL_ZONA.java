package com.emesa.gestinm.dao;


import java.util.*;

import org.apache.log4j.Logger;

import net.seh.bbdd.AbstractDBManager;
import com.emesa.bbdd.DBManager;
import com.emesa.bbdd.cache.*;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 * 
 * @since Mon Aug 25 13:16:36 CEST 2003
 */
public class FEL_ZONA
{
	 /** Logger */
    static Logger logger = Logger.getLogger(FEL_ZONA.class);
	
	//-- Atributos
	private int ID_ZONA=-1;
	private String ZONA;
	
	/** <code>Hashtable</code> con <b>todas</b> las oficinas cacheadas: </i>ID_OFICINA --> Oficina<(i>*/
    static Hashtable hZonas=new Hashtable();

    /**
     * Carga de la <code>Hashtable</code> de las Zonas
     */
    static {
        hZonas=loadZonas();
    }

    /**
     * Carga las oficinas existentes en la BB.DD.
     *
     * @return <code>Hashtable</code> con <b>todas</b> las oficinas cacheadas: </i>ID_OFICINA --> Oficina<(i>
     */
    private static Hashtable loadZonas()
    {
        com.emesa.bbdd.cache.QueryCache.reloadQuery("zonas");
        CacheObject co = QueryCache.get("zonas");
        Vector vZonas = co.getQueryResults();
        FEL_ZONA o=null;
        Hashtable h=new Hashtable();
        for(int i=0; i<vZonas.size(); i++) {
            o=new FEL_ZONA();
            o.loadFromDB(Integer.parseInt( ((Vector)vZonas.elementAt(i)).firstElement().toString() ),true);
            h.put(new Integer( ((Vector)vZonas.elementAt(i)).firstElement().toString() ),o);
        }

        logger.debug("[loadZonas] Cargada la caché: "+h);
        return h;
    }



	//-- GETs y SETs
	/**
	 * Devuelve ID_ZONA
	 * 
	 * @return ID_ZONA
	 */
	public int getID_ZONA()
	{
		return this.ID_ZONA;
	}

	/**
	 * Asigna ID_ZONA
	 * 
	 * @param unID_ZONA
	 */
	public void setID_ZONA(int unID_ZONA)
	{
		this.ID_ZONA = unID_ZONA;
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
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto fel_zona
	*/
	public FEL_ZONA loadFromDB(int nPK)
    {
        return loadFromDB(nPK,false);
    }

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto fel_zona
	*/
	public FEL_ZONA loadFromDB(int nPK, boolean toDB)
	{
		if(toDB) 
		{
			StringBuffer sSQL=new StringBuffer("SELECT ID_ZONA,ZONA FROM fel_zona WHERE ID_ZONA=?");
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
			
			Vector vRow=null;
			if(vRtado!=null && !vRtado.isEmpty()) {
				//-- Solo puede haber un rtado puesto que __PK__ es PK
				vRow=(Vector)vRtado.firstElement();
	
				if(vRow.elementAt(0)!=null)
					this.ID_ZONA = Integer.parseInt(vRow.elementAt(0).toString().trim());
				if(vRow.elementAt(1)!=null)
					this.ZONA = ((String)vRow.elementAt(1)).trim();
			}
	        // Cargamos desde la caché
	 	}
	    else {
	        setObject( (FEL_ZONA)hZonas.get(new Integer(nPK)) );
	    }

    	return this;
	}
	
	
	/**
     */
    public void setObject(FEL_ZONA o) {
    	setID_ZONA(o.getID_ZONA());
    	setZONA(o.getZONA());
     	
    }
	
	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto fel_zona
	*/
	public FEL_ZONA loadFromDB(String sZona)
	{
		StringBuffer sSQL=new StringBuffer("SELECT ID_ZONA,ZONA FROM fel_zona WHERE ZONA like ?");
		Vector vParams=new Vector();

		vParams.add(sZona);
		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
			return null;
		}
		
		Vector vRow=null;
		if(vRtado!=null && !vRtado.isEmpty()) {
			//-- Solo puede haber un rtado puesto que __PK__ es PK
			vRow=(Vector)vRtado.firstElement();

			if(vRow.elementAt(0)!=null)
				this.ID_ZONA = Integer.parseInt(vRow.elementAt(0).toString().trim());
			if(vRow.elementAt(1)!=null)
				this.ZONA = ((String)vRow.elementAt(1)).trim();
		}

		 return this;
	}


	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
		Vector vParams = new Vector();
		//-- Chequeamos a ver si es un objeto nuevo
		if(getID_ZONA()==-1) { // ** TO DO **
			sSQL = new StringBuffer("INSERT INTO fel_zona ");
			sSQL.append("(ZONA");
			sSQL.append(") VALUES (?)");
			
            vParams = new Vector();
            vParams.add(getZONA());
			AbstractDBManager dbm = DBManager.getInstance();
			try {
					dbm.executeUpdate(sSQL.toString(), vParams);
			}catch (Exception e) {
					System.err.println("[fel_zona][loadFromDB] Error :"+e);
				}
		}
		else {
			sSQL = new StringBuffer("UPDATE fel_zona SET ");
			sSQL.append("ZONA='").append(""+getZONA()).append("'");
			sSQL.append(" WHERE ID_ZONA= ?");
			
			vParams.add(new Integer(getID_ZONA()));

			AbstractDBManager dbm = DBManager.getInstance();
			dbm.executeUpdate(sSQL.toString(), vParams);
		}
	}
	
	/**
    * Borra de BB.DD. y de la cach&eacute; la zona identificada por el par&aacute;metro
    *
    * @return N&uacute;mero de registros modificados
    */
    public int delete() throws Exception
    {
        return delete(getID_ZONA());
    }
	
	/**
    * Borra de BB.DD. y de la cach&eacute; la zona identificada por el par&aacute;metro
    *
    * @param nIdOficina Identificador de la zona
    * @return N&uacute;mero de registros modificados
    */
    public static int delete(int nIdOficina) throws Exception
    {
        StringBuffer sSQL=new StringBuffer("delete from FEL_ZONA where ID_ZONA=?");
        Vector vParams=new Vector();

        vParams.add(new Integer(nIdOficina));
        int nRtado=0;
        try {
            AbstractDBManager dbm = DBManager.getInstance();
            nRtado=dbm.executeUpdate(sSQL.toString(),vParams);
            // Actualizamos la caché
            
        }
        catch(Exception e) {
            //-- Tratamiento de la excepcion
            System.err.println("[FEL_ZONA][delete] Error: "+e.getMessage());

            throw e;
        }

        return nRtado;
    }


	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "fel_zona-[ID_ZONA="+getID_ZONA()+",ZONA="+getZONA()+"]";
	}
}
