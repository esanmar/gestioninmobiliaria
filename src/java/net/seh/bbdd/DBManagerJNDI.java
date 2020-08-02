package net.seh.bbdd;

import java.util.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

/**
 * Clase de acceso a BB.DD. v&iacute;a JNDI
 *
 * @see net.seh.bbdd.AbstractDBManager
 */
public class DBManagerJNDI extends AbstractDBManager
{
//==============================================================
//==
//==	ATRIBUTOS
//==
	/** Nombre de acceso JNDI */
	private String sJNDIName;
	/** <i>Data source</i> que identifica a la BB.DD. a utilizar */
	private DataSource ds = null;
	/** Propiedades para el acceso al contexto de ejecuci&oacute;n */
	private Hashtable oEnvironment;



//==============================================================
//==
//==	CONSTRUCTOR
//==

	/**
	 * Constructor
	 *
	 * @param sJNIDName Nombre JNDI que representa la BB.DD.
	 */
	public DBManagerJNDI(String sJNDIName)
	{
		this(sJNDIName,null);
	}


	/**
	 * Constructor
	 *
	 * @param sJNDIName JNDI que representa a la BB.DD.
	 * @param oEnv Contexto de ejecuci&oacute;n
	 */
	public DBManagerJNDI(String sJNDIName, Hashtable oEnv)
	{
		InitialContext oContext = null;
		try
		{
			// Si el contexto es nulo o vacío, ejecutamos sobre el contexto actual (la JVM actual)
			if(oEnv==null || oEnv.isEmpty())
				oContext = new InitialContext();
			else
				oContext = new InitialContext(oEnv);

			ds = (DataSource)oContext.lookup(sJNDIName);
			trace(" ---- Conectados a " + sJNDIName+ "----");
		}
		catch(NamingException e)
		{
			System.err.println("[DBManagerJNDI] Error al buscar "+sJNDIName+": " + e);
		}
		finally
		{
			try
			{
				if(oContext != null)
				oContext.close();
			}
			catch(NamingException e)
			{
				System.err.println("[DBManagerJNDI] Error al cerrar el contexto: " + e);
			}
		}
	}



//==============================================================
//==
//==	MÉTODOS
//==

	/**
	 * Obtiene una conexi&oacute;n de la BB.DD.
	 *
	 * @return Conexi&oacute;n con la BB.DD.
	 */
	public Connection getConnection()
		throws SQLException
	{
		trace("[getConnection] Obtenemos una conexión");
		return ds.getConnection();
	}


	/**
	 * Obtiene una conexi&oacute;n de la BB.DD. para el usuario y indicado
	 *
	 * @param sUser Usuario
	 * @param sPassword Clave de acceso
	 * @return Conexi&oacute;n con la BB.DD.
	 */
	public Connection getConnection(String sUser, String sPassword)
		throws SQLException
	{
		trace("[getConnection] Obtenemos una conexión para "+sUser);
		return ds.getConnection(sUser,sPassword);
	}




//==============================================================
//==
//==	MAIN
//==

	/**
	 * Funci&oacute;n para pruebas
	 */
	public static void main(String[] args)
	{
		System.out.println(">> -- Inicio --");
		Vector vParams = new Vector();
		try {
			// Hay que asegurarse antes de que existe esta entrada JNDI!!
			DBManagerJNDI dbj=new DBManagerJNDI("jndi/cp_existencias");
			//dbj.getConnection();
			vParams.add(new Integer(1));
			System.out.println(""+dbj.executeQuery("select * from DEF_EXISTENCIAS where id_clase=?",vParams));
			vParams=new Vector();
			vParams.add(new Integer(4));
			vParams.add(new Double(33.2));
			vParams.add("Cosa");
			dbj.beginTransaction();
			System.out.println(""+dbj.executeUpdate("insert into VAL_EXISTENCIAS (ID_CLASE,PRECIO_MEDIO,CLASE) values (?,?,?)",vParams));
			dbj.rollback();

			vParams=new Vector();
			vParams.add(new Integer(5));
			vParams.add(new Double(33.5));
			vParams.add("Pene");
			dbj.beginTransaction();
			System.out.println(""+dbj.executeUpdate("insert into VAL_EXISTENCIAS (ID_CLASE,PRECIO_MEDIO,CLASE) values (?,?,?)",vParams));
			dbj.commit();
		}
		catch(Exception e) {
			System.out.println(">> Error: "+e);
		}
		System.out.println(">> -- FIN --");

	}
}