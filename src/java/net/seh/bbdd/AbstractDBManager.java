package net.seh.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


/**
 * <p>Clase de acceso a BB.DD.</p>
 * <ul><li><b>v 1.1.</b>: Se ha modificado el m&eacute;todo
 * <code>executeQueryRS()</code> para evitar que queden conexiones sin cerrar en
 * ciertos casos.</li></ul>
 *
 * @version 1.1
 * @author sasa eh
 */
public abstract class AbstractDBManager
{
//==============================================================
//==
//==	ATRIBUTOS
//==

	/** Indica si debe haber salida por pantalla */
	protected static boolean DEBUG=false;

	/** Indica si hace <i>commit</i> de forma autom&aacute;tica */
	protected boolean autocommit=true;

	/** Conexi&oacute;n almacenada para el caso de gesti&oacute;n de la transacci&oacute; */
	protected Connection dbConn=null;




//==============================================================
//==
//==	MÉTODOS
//==

	/**
	 * Obtiene una conexi&oacute;n de la BB.DD.
	 *
	 * @return Conexi&oacute;n con la BB.DD.
	 */
	public abstract Connection getConnection() throws SQLException;



	/**
	 * Indica que comienza una transacci&oacute;n
	 */
	public void beginTransaction() throws SQLException
	{
		if(dbConn!=null && !dbConn.isClosed())
			dbConn.close();

		setCommit(false);
		this.dbConn=getConnection();
		this.dbConn.setAutoCommit(false);
	}



	/**
	 * Hacemos <i>rollback</i> de la query transaccional
	 */
	public void rollback() throws SQLException
	{
		if(this.dbConn!=null && !dbConn.getAutoCommit() && !dbConn.isClosed()) {
			trace("[rollback] Haciendo rollback() de "+this.dbConn);
			this.dbConn.rollback();

			// 'Reseteamos' la conexión transaccional
			if(dbConn!=null && !dbConn.isClosed())
				dbConn.close();

			setCommit(true);
		}
	}


	/**
	 * Hacemos <i>commit</i> de la query transaccional
	 */
	public void commit() throws SQLException
	{
		if(this.dbConn!=null && !dbConn.getAutoCommit() && !dbConn.isClosed()) {
			trace("[commit] Haciendo commit() de "+this.dbConn);
			this.dbConn.commit();

			// 'Reseteamos' la conexión transaccional
			if(dbConn!=null && !dbConn.isClosed())
				dbConn.close();

			setCommit(true);
		}
	}


	/**
	 * Control del <i>flag</i> de control de la transaccionalidad
	 *
	 * @param bCommit
	 */
	protected void setCommit(boolean bCommit)
	{
		this.autocommit=bCommit;
	}

	/**
	 * @param sQuery Sentencia SQL (SELECT) a ejecutar
	 */
	public ResultSet executeQueryRS(String sQuery)
		throws java.sql.SQLException
	{
		return executeQueryRS(sQuery,new Vector());
	}


	/**
	 * @param sQuery Sentencia SQL (SELECT) a ejecutar
	 * @param vParams Par&aacute;metros de esa sentencia
	 */
	public ResultSet executeQueryRS(String sQuery, Vector vParams)
		throws java.sql.SQLException
	{
		// Obtenemos una conexión
		trace("[executeQueryRS] Obtenemos una conexión");
		try {
			dbConn=getConnection();
		}
		catch (Exception e) {
			System.err.println("[AbstractDBManager][executeQueryRS] Error: "+e);
            try {
                if(dbConn!=null && !dbConn.isClosed())
                    dbConn.close();
            }
            catch(Exception e1) {}

            return null;
		}

		// Preparamos la sentencia
		trace("[executeQueryRS] Preparamos la sentencia");
		PreparedStatement pst = null;
		try {
			pst = dbConn.prepareStatement(sQuery);
		}
		catch(Exception e) {
			System.err.println("[AbstractDBManager][executeQueryRS] No se pudo preparar el Statement: " + e);

			if(pst != null)
				pst.close();

			if(dbConn!=null && !dbConn.isClosed()) {
				dbConn.close();
			}

			return null;
		}

		// Asignamos los parámetros...
		trace("[executeQueryRS] Asignamos los parámetros...");
		for(int i=0; i<vParams.size(); i++) {
			try {
				pst.setObject(i+1, vParams.elementAt(i));
			}
			catch(Exception e) {
				System.err.println("[AbstractDBManager][executeQueryRS] Fallo al sustituir los argumentos: " + e);

				if(pst != null)
					pst.close();

				if(dbConn!=null && !dbConn.isClosed()) {
					dbConn.close();
				}

				return null;
			}
		}

		// Ejecutamos la sentencia
		trace("[executeQueryRS] Ejecutamos la sentencia "+sQuery+"-"+vParams);
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
		}
		catch(Exception e) {
			System.err.println("[AbstractDBManager][executeQueryRS] Fallo en la ejecucion: " + e);

			if(rs != null)
				rs.close();

			if(pst != null)
				pst.close();

			if(dbConn!=null && !dbConn.isClosed()) {
				dbConn.close();
			}

            throw new SQLException(e.toString());
			//return null;
		}

		return rs;
}


	/**
	 * @param sQuery Sentencia SQL (SELECT) a ejecutar
	 */
	public Vector executeQuery(String sQuery)
		throws java.sql.SQLException
	{
		return executeQuery(sQuery,new Vector());
	}


	/**
	 *
	 * @param sQuery Sentencia SQL (SELECT) a ejecutar
	 * @param vParams Par&aacute;metros de esa sentencia
	 */
	public Vector executeQuery(String sQuery, Vector vParams)
		throws java.sql.SQLException
	{
		Vector vRows=new Vector();
		ResultSet rs = null;
		try {
		  rs = executeQueryRS(sQuery,vParams);
        }
        catch(Exception e) {
            trace("[executeQuery] Se ha producido una excepción, forzamos que se cierre la conexión");
            if(dbConn!=null  && !dbConn.isClosed()) {
                dbConn.close();
            }
            throw new java.sql.SQLException(e.toString());
        }

		if(rs==null) {
            if(rs != null)
                rs.close();

            if(dbConn!=null && !dbConn.isClosed()) {
                dbConn.close();
            }

			return vRows;
		}

		// Formateamos los datos
		Vector vColumns=new Vector();
		trace("[executeQuery] Formateamos los datos como String");
		int j = rs.getMetaData().getColumnCount();

        //---------------------------------------------------------------------
        //-- seh [2003/06/19]: Añadido el try-catch para que en el caso de j=0,
        //--    no salte la excepción y se quede la conexión sin cerrar.
        try {
    		for(; rs.next(); vRows.addElement(vColumns)) {
    			vColumns = new Vector();

    			for(int k=0; k < j; k++)
    				vColumns.addElement(rs.getString(k + 1));
    		}
        } catch(Exception ex) {
            if(dbConn!=null && !dbConn.isClosed()) {
                dbConn.close();
            }

            trace("[executeQuery] Warning: "+ex);
            throw new SQLException(ex.getMessage());
        }

		if(dbConn!=null && !dbConn.isClosed()) {
			dbConn.close();
		}

		return vRows.size() == 0 ? new Vector() : vRows;
	}



	/**
	 * @param sQuery Sentencia SQL (INSERT, UPDATE, DELETE,...) a ejecutar
	 * @return N&uacute;mero de filas modificadas
	 */
	public int executeUpdate(String sQuery)
		throws SQLException
	{
		return executeUpdate(sQuery,new Vector());
	}


	/**
	 * @param sQuery Sentencia SQL (INSERT, UPDATE, DELETE,...) a ejecutar
	 * @param vParams Par&aacute;metros de esa sentencia
	 * @return N&uacute;mero de filas modificadas
	 */
	public int executeUpdate(String sQuery, Vector vParams)
		throws SQLException
	{
		Vector vRtado=new Vector();
		int i=0;

		// Obtenemos la conexión
		trace("[executeUpdate] Obtenemos la conexión");
		try {
			if(autocommit)
				dbConn = getConnection();
		}
		catch(Exception e) {
			System.err.println("[AbstractDBManager][executeUpdate] No hay conexion disponible" + e);
			return i;
		}

		// Preparamos la sentencia
		trace("[executeUpdate] Preparamos la sentencia");
		PreparedStatement pst = null;
		try
		{
			pst = dbConn.prepareStatement(sQuery);
		}
		catch(Exception e)
		{
			System.err.println("[AbstractDBManager][executeUpdate] No se pudo preparar el statement: " + e);

			if(pst != null)
				pst.close();

			if(dbConn!=null && !dbConn.isClosed())
				dbConn.close();

			return i;
		}

		// Realizamos la substitución de los parámetros
		trace("[executeUpdate] Realizamos la substitución de los parámetros");
		for(int j = 0; j < vParams.size(); j++) {
			try {
				pst.setObject(j + 1, vParams.elementAt(j));
			}
			catch(Exception e) {
				System.err.println("[AbstractDBManager][executeUpdate] Fallo al sustituir los argumentos: " + e);

				if(pst != null)
					pst.close();

				if(dbConn!=null && !dbConn.isClosed())
					dbConn.close();

				return i;
			}
		}

		// Ejecutamos la query
		trace("[executeUpdate] Ejecutamos la query "+sQuery+"-"+vParams);
		try {
			i = pst.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("[AbstractDBManager][executeUpdate] Fallo en la ejecucion: " + e);

			if(pst != null)
				pst.close();

			if(dbConn!=null && !dbConn.isClosed())
				dbConn.close();

			//return i;
            throw new SQLException(e.toString());
		}

		if(pst != null)
			pst.close();

		// Solo cerramos la conexión si no es transaccional
		if(autocommit && dbConn!=null && !dbConn.isClosed())
			dbConn.close();

		return i;
	}


	/**
	 * Actualiza el <i>flag</i> de debug
	 *
	 * @param b Booleano
	 */
	public static void setDebug(boolean b)
	{
		DEBUG=b;
	}


	/**
	 * Escribe por <code>System.out</code>
	 *
	 * @param s String a sacar por pantalla si DEBUG==true
	 */
	protected static void trace(String s)
	{
		if(DEBUG)
			System.out.println("[AbstractDBManager]"+s);
	}

    /**
     * Al eliminar el objeto, nos aseguramos de cerrar la conexi&oacute;n
     */
    public void finalize()
    {
        close();
    }

    /**
     * Al eliminar el objeto, nos aseguramos de cerrar la conexi&oacute;n
     */
    public void close()
    {
        try {
            if(dbConn!=null && !dbConn.isClosed())
                dbConn.close();
        }
        catch(Exception e) {
            System.err.println("[close] Error al cerrar la conexión");
        }
    }
}