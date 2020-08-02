package com.emesa.bbdd.cache;

import java.util.*;
import java.io.*;

import org.apache.log4j.Logger;

import com.emesa.Configuration;


/**
 * Clase que continen en una <i>hash</i> est&aacute;tica con los resultados de <i>queries</i> a BB.DD.
 *
 * @see com.emesa.bbdd.DBManager
 * @see net.seh.bbdd.AbstractDBManager
 */
public class QueryCache
{
    /** Logger */
    static Logger logger = Logger.getLogger(QueryCache.class);

	/** Chach&eacute; de <i>quieries</i> */
	private static HashMap oCachedQueries = loadPropertyFile();


	/**
	 * Cargamos la tabla <code>hash</code> del fichero <code>queryCache.properties</code>
	 */
	public static HashMap loadPropertyFile()
	{
		HashMap oCacheProp = new HashMap();
		String sFileName = Configuration.getProperty("folder.properties")+"/queryCache.properties";
		Properties oFileProp = new Properties();
		try {
			oFileProp.load(new FileInputStream(sFileName));
		}
		catch(Exception e)
		{
			logger.error("[loadPropertyFile] Error al abrir el fichero "+sFileName+": "+e);
			return new HashMap();
		}
		// Una vez cargado el fichero, ejecutamos las select y las cacheamos de la forma:
		//	'id_select' --> [ 'timestamp', 'rtado query']
		Enumeration enum = oFileProp.propertyNames();
		String sKey = "";
		CacheObject o = null;
		while(enum.hasMoreElements()) {
			sKey = ((String)enum.nextElement()).trim();
			o = new CacheObject(oFileProp.getProperty(sKey));
			if(o.getQueryResults()==null) {
				logger.error("[loadPropertyFile] La query "+sKey+" da error al ejecutarse");
			}
			//-- Si no ha habido error al ejecutar la query, guardamos el objeto en la caché
			else {
                logger.info("[loadPropertyFile] Cargando: "+sKey+" --> "+o);
				oCacheProp.put(sKey,o);
			}
		}

		return oCacheProp;
	}


	/**
	 * Cargamos la query bajo demanda
	 */
	public static void reloadQuery(String sSelect)
	{
		if(sSelect==null || sSelect.trim().equals(""))
			return;

		CacheObject oQuery = (CacheObject)oCachedQueries.get(sSelect);

		Vector vRtado;
		oQuery.executeQuery();
		if(oQuery.getQueryResults() == null) {
			System.err.println("[QueryCache][reloadQuery] La query "+sSelect+" da error al ejecutarse");
		}
		else {
			// Borramos la vieja y añadimos la nueva
			oCachedQueries.remove(sSelect.trim());
			oCachedQueries.put(sSelect.trim(),oQuery);
		}
	}

	/**
	 * Cargamos TODAS las queries
	 */
	public static void reloadAllQueries()
	{
		oCachedQueries = loadPropertyFile();
	}


	/**
	 * Obtenemos el objeto asociado a la clave
	 *
	 * @param sSelect Clave de acceso al objeto
	 */
	public static CacheObject get(String sSelect)
	{
		if(sSelect==null || sSelect.trim().equals(""))
			return null;

		return (CacheObject)oCachedQueries.get(sSelect);
	}


	/**
	 * N&uacute;mero total de objetos en la cach&eacute;
	 *
	 * @return N&uacute;mero de elemento sen la cach&eacute;
	 */
	public static int size()
	{
		return oCachedQueries.size();
	}


	/**
	 * Devuelve la <code>HashMap</code> que representa la cach&eacute;
	 *
	 * @return HashMap
	 */
	public static HashMap getCache()
	{
		return oCachedQueries;
	}
}
//-- eoClass
