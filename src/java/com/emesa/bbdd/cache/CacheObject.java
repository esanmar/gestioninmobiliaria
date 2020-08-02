package com.emesa.bbdd.cache;

import java.util.Date;
import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import com.emesa.bbdd.DBManager;

/**
 * Clase que representa los objetos almacenados en QueryCache
 */
public class CacheObject
{
	/** Fecha en la que se realiza la <i>query</i> */
	private Date oFecha;
	/** <i>Query</i> a ejecutar */
	private String sQuery;
	/** Vector resultado de la <i>query</i> tal y como lo devuelve DBManagerJNDI */
	private Vector vRtadoQuery;


	/**
	 * Constructor
	 *
	 * @param sQuery
	 */
	public CacheObject(String sQuery)
	{
		this(new Date(),sQuery);
	}

	/**
	 * Constructor
	 *
	 * @param oFecha
	 * @param sQuery
	 */
	public CacheObject(Date oFecha, String sQuery)
	{
		setDate(oFecha);
		setQuery(sQuery);
		executeQuery();
	}

	/**
	 * Constructor
	 *
	 * @param oFecha
	 * @param sQuery
	 * @param vRtadoQuery
	 */
	public CacheObject(Date oFecha, String sQuery, Vector vRtadoQuery)
	{
		setDate(oFecha);
		setQuery(sQuery);
		setQueryResults(vRtadoQuery);
	}

	//-- GETs y SETs
	public Date getDate()
	{ return this.oFecha; }
	public String getQuery()
	{ return this.sQuery; }
	public Vector getQueryResults()
	{ return this.vRtadoQuery; }

	public void setDate(Date oFecha)
	{ this.oFecha=oFecha; }
	public void setQuery(String sQuery)
	{ this.sQuery=sQuery; }
	private void setQueryResults(Vector vRtado)
	{ this.vRtadoQuery=vRtado; }

	/**
	 * Ejecuta la <i>query</i> y modifica el objeto
	 */
	public void executeQuery() {
		AbstractDBManager dbm = DBManager.getInstance();
		try {
			setQueryResults(dbm.executeQuery(getQuery()));
		}
		catch(Exception e) {
			setQueryResults(null);
			System.err.println("[QueryCache][loadPropertyFile] La query "+getQuery()+" da error al ejecutarse: "+e);
		}
	}
}
//--eoClass