package net.seh.bbdd;

import java.util.*;

/**
 * Clase de acceso a BB.DD. que utiliza las clases DBManager<i>X</i>
 *
 * @see net.seh.bbdd.AbstractDBManager
 * @see net.seh.bbdd.DBManagerODBC
 * @see net.seh.bbdd.DBManagerJNDI
 */
public class DBManager
{
	//==============================================================
	//==
	//==	CONSTRUCTOR
	//==
	/**
	 * Al hacer el constructor privado obligamos a acceder a trav&eacute;s de los
	 * m&eacute;todos <code>getInstance()</code>
	 */
	private DBManager()
	{
	}

	//==============================================================
	//==
	//==	MÉTODOS
	//==
	/**
	 * Aprovechando las diferencias en los constructores DBManager<i>X</i>
	 * podemos saber que instancia crear.<br/>Este m&eacute;todo se corresponde con
	 * <code>DBManagerODBC</code>
	 *
	 * @throws ClasNotFoundException si no se ha podido cargar el <i>driver</i>
	 */
	public static DBManagerODBC getInstance()
		throws ClassNotFoundException
	{
		return new DBManagerODBC();
	}


	/**
	 * Aprovechando las diferencias en los constructores DBManager<i>X</i>
	 * podemos saber que instancia crear.<br/>Este m&eacute;todo se corresponde con
	 * <code>DBManagerODBC</code>
	 *
	 * @param sDriver Driver de BB.DD. a utilizar
	 * @param sUrl URL que identifica a la BB.DD.
	 * @param p Objeto de propiedades para el acceso a la BB.DD.
	 * @throws ClasNotFoundException si no se ha podido cargar el <i>driver</i>
	 */
	public static DBManagerODBC getInstance(String sDriver, String sUrl,Properties p)
		throws ClassNotFoundException
	{
		return new DBManagerODBC(sDriver, sUrl, p);
	}


	/**
	 * Aprovechando las diferencias en los constructores DBManager<i>X</i>
	 * podemos saber que instancia crear.<br/>Este m&eacute;todo se corresponde con
	 * <code>DBManagerJNDI</code>
	 *
	 * @param sJNIDName Nombre JNDI que representa la BB.DD.
	 */
	public static DBManagerJNDI getInstance(String sJNDIName)
	{
		return new DBManagerJNDI(sJNDIName);
	}


	/**
	 * Aprovechando las diferencias en los constructores DBManager<i>X</i>
	 * podemos saber que instancia crear.<br/>Este m&eacute;todo se corresponde con
	 * <code>DBManagerJNDI</code>
	 *
	 * @param sJNDIName JNDI que representa a la BB.DD.
	 * @param oEnv Contexto de ejecuci&oacute;n
	 */
	public static DBManagerJNDI getInstance(String sJNDIName, Hashtable oEnv)
	{
		return new DBManagerJNDI(sJNDIName,oEnv);
	}
}