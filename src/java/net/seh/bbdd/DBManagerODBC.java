package net.seh.bbdd;

import java.util.*;
import java.sql.*;


/**
 * Clase de acceso a BB.DD. v&iacute;a JDBC-ODBC
 *
 * @see net.seh.bbdd.AbstractDBManager
 */
public class DBManagerODBC extends AbstractDBManager
{
//==============================================================
//==
//==	ATRIBUTOS
//==
	/** <i>Driver</i> a utilizar */
	private String sDriver;
	/** URL que identifica a la BB.DD. */
	private String sUrl;
	/** Propiedades para el acceso a la BB.DD. */
	private Properties pBBDD;




//==============================================================
//==
//==	CONSTRUCTOR
//==

	/**
	 * Constructor
	 *
	 * @throws ClasNotFoundException si no se ha podido cargar el <i>driver</i>
	 */
	public DBManagerODBC() throws ClassNotFoundException
	{
		this("sun.jdbc.odbc.JdbcOdbcDriver","",new Properties());
	}


	/**
	 * Constructor
	 *
	 * @param sDriver Driver de BB.DD. a utilizar
	 * @param sUrl URL que identifica a la BB.DD.
	 * @param p Objeto de propiedades para el acceso a la BB.DD.
	 * @throws ClasNotFoundException si no se ha podido cargar el <i>driver</i>
	 */
	public DBManagerODBC(String sDriver, String sUrl,Properties p) throws ClassNotFoundException
	{
		setDriver(sDriver);
		setUrl(sUrl);
		setProperties(p);
		// Cargamos el driver
		Class.forName(sDriver);
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
		trace("[getConnection] Obtenemos una conexión para "+sUrl);

		return DriverManager.getConnection(sUrl,pBBDD);
	}


	/**
	 * Asigna el <i>driver</i> indicado
	 *
	 * @param sDriver Driver de BB.DD. a utilizar
	 */
	public void setDriver(String sDriver)
	{
		this.sDriver=sDriver;
	}

	/**
	 * Asigna la URL que identifica a la BB.DD.
	 *
	 * @param sUrl URL a utilizar
	 */
	public void setUrl(String sUrl)
	{
		this.sUrl=sUrl;
	}

	/**
	 * Asigna las propiedades de acceso a la BB.DD
	 *
	 * @param p Propiedades de acceso a la BB.DD.
	 */
	public void setProperties(Properties p)
	{
		this.pBBDD=p;
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
		Properties p=new Properties();
		p.put("user","cp");
		p.put("password","cp_enri");
		Vector vParams = new Vector();
		try {
			DBManagerODBC dbo=null;
/*
			dbo=new DBManagerODBC("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:cp_existencias",p);
			//dbo.getConnection();
			vParams.add(new Integer(1));
			System.out.println(""+dbo.executeQuery("select * from DEF_EXISTENCIAS where id_clase=?",vParams));
			vParams=new Vector();
			vParams.add(new Integer(4));
			vParams.add(new Double(33.2));
			vParams.add("Cosa");
			dbo.beginTransaction();
			System.out.println(""+dbo.executeUpdate("insert into VAL_EXISTENCIAS (ID_CLASE,PRECIO_MEDIO,CLASE) values (?,?,?)",vParams));
			dbo.rollback();

			vParams=new Vector();
			vParams.add(new Integer(5));
			vParams.add(new Double(33.5));
			vParams.add("Pene");
			dbo.beginTransaction();
			System.out.println(""+dbo.executeUpdate("insert into VAL_EXISTENCIAS (ID_CLASE,PRECIO_MEDIO,CLASE) values (?,?,?)",vParams));
			dbo.commit();
*/
//------------------------------------------------------------------
			p=new Properties();
			p.put("user","sa");
			p.put("password","");
			dbo=new DBManagerODBC("org.hsqldb.jdbcDriver","jdbc:hsqldb:"+args[0],p);
			//dbo.getConnection();
			vParams.add(new Integer(1));
			System.out.println(""+dbo.executeQuery("select * from SMS_GROUP where ID_GROUP=?",vParams));
		}
		catch(Exception e) {
			System.out.println(">> Error: "+e);
		}
		System.out.println(">> -- FIN --");
	}
}