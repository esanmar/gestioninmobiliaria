package net.seh.bbdd;

import java.util.*;
import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

/**
 * Generador de clases que contienen la informaci&oacute;n equivalente a una tabla de la BB.DD.
 * elegida.
 *
 * @author sasa eh
 * @version 1.2 - 2003/01/20
 * @since 2002/08/06
 */
public class WrapperMakerMays
{
	/** Configuraci&oacute;n de la clase */
	static final Properties propWM=loadConfigFile("/wrappermaker.properties");
	/** Vector de String[2] que contendr&aacute; la combinaci&oacute;n Tipo-Variable */
	private Vector vTipoVariable=null;
	/** Tabla de la que se est&aacute; realizando el <i>wrapper</i>*/
	private String sTable=null;


	/**
   * Constructor
   *
   * @param sTable Tabla de la que se est&aacute; realizando el <i>wrapper</i>
   */
	WrapperMakerMays(String sTable)
	{
		vTipoVariable=new Vector();
		this.sTable=sTable;
	}



	/**
   * Obtiene una conexi&oacute;n de un <code>DataSource</code> obtenido por JNDI
   *
   * @param sJNDI Nombre JNDI asociado al <code>DataSource</code>
   * @return Conexi&oacute;n con la BB.DD.
   */
   private Connection getConnection(String sJNDI)
   {
   	Connection oConn=null;
   	try
   	{
   		oConn=getDataSource(sJNDI).getConnection();
   	}
   	catch(java.sql.SQLException e)
   	{
   		//Logger.log(4,"[WrapperMaker] Error al obtener la conexión con "+sJNDI+": "+e);
   		System.err.println("[WrapperMaker] Error al obtener la conexión con "+sJNDI+": "+e);
   	}

   	return oConn;
   }

	/**
   * Obtiene una conexi&oacute;n a trav&eacute;s del <i>driver</i> y la URL de la BB.DD.
   *
   * @param sJNDI Nombre JNDI asociado al <code>DataSource</code>
   * @return Conexi&oacute;n con la BB.DD.
   */
   private Connection getConnection(String sDriver,String sUrl,String sUser,String sPassword)
   {
   	Connection oConn=null;
   	try
   	{
  		// Cargamos el driver
			Class.forName(sDriver);
			// Obtenemos la conexión
			oConn=DriverManager.getConnection (sUrl,sUser,sPassword);
		}
		catch(ClassNotFoundException e)
		{
			//Logger.log(4,"[WrapperMaker] Error al cargar el driver "+sDriver+": "+e);
			System.err.println("[WrapperMaker] Error al cargar el driver "+sDriver+": "+e);
		}
		catch(java.sql.SQLException e)
		{
			//Logger.log(4,"[WrapperMaker] Error al obtener la conexión a "+sUrl+" con "+sUser+"/"+sPassword+": "+e);
			System.err.println("[WrapperMaker] Error al obtener la conexión a "+sUrl+" con "+sUser+"/"+sPassword+": "+e);
		}


   	return oConn;
   }


	/**
	 * Recupera el <code>DataSource</code> de la BB.DD. indicada
	 *
   * @param sJndiName Nombre JNDI asociado al <code>DataSource</code>
   * @return DataSource asociado
   */
  private DataSource getDataSource(String sJndiName)
	{
		DataSource ds=null;
		InitialContext initialcontext = null;
    try
    {
    	initialcontext = new InitialContext();
      ds = (DataSource)initialcontext.lookup(sJndiName);
      //Logger.log("[WrapperMaker] Conectados a "+sJndiName);
      System.out.println("[WrapperMaker] Conectados a "+sJndiName);
    }
		catch(NamingException namingexception)
    {
    	//Logger.log(4,"[WrapperMaker] El DS "+sJndiName+" no se ha encontrado: " + namingexception);
    	System.err.println("[WrapperMaker] El DS "+sJndiName+" no se ha encontrado: " + namingexception);
    }
    finally
    {
    	try
      {
      	if(initialcontext != null)
        	initialcontext.close();
			}
      catch(Exception e)
      {
      	//Logger.log(4,"[WrapperMaker] Error al cerrar el contexto: " + e);
      	System.err.println("[WrapperMaker] Error al cerrar el contexto: " + e);
		}
	}

		return ds;
	}


	/**
   * Obtiene los pares Tipo-Variable de la BB.DD.
   *
   * @param oConn Conexi&oacute;n con la BB.DD.
   * @return Vector de String[2] Tipo-Variable.
   */
  private Vector getTableInfo(Connection oConn)
  {
  	/*
    String sDriver="org.gjt.mm.mysql.Driver"; //-- Driver de MySQL
    String sProtocol="jdbc:mysql:";
		String sBd="//localhost/DBLunes";
		String sTable="lun_comentarios";
		*/
		Statement stmt;

		try
    {
  		// Cargamos el driver
			//Class.forName(sDriver);
			// Obtenemos la conexión
      //Connection conn = DriverManager.getConnection (sUrl,sUser,sPassword);//"sasa_eh","NONE");
      stmt = oConn.createStatement();
      String sqlQuery="SELECT * FROM "+sTable;
			ResultSet rs= stmt.executeQuery(sqlQuery);

			ResultSetMetaData rsMetaData = rs.getMetaData();

			int nColumns=rsMetaData.getColumnCount();
			String aTipoVar[]=null;
			for(int i=1; i<nColumns+1; i++)
			{
				aTipoVar=new String[2];
				try
				{
					aTipoVar[0]=propWM.getProperty(rsMetaData.getColumnTypeName(i));
					aTipoVar[1]=rsMetaData.getColumnName(i).toUpperCase();
					vTipoVariable.add(aTipoVar);
				}
				catch(Exception e)
				{
					//Logger.log(4,"[WrapperMaker][getTableInfo] Excepcion en "+i);
					System.err.println("[WrapperMaker][getTableInfo] Excepcion en "+i);
				}
				//Logger.log("[WrapperMaker][getTableInfo] Columna #"+i+"/"+nColumns+": "+rsMetaData.getColumnName(i)+"/"+rsMetaData.getColumnLabel(i)+" - "+rsMetaData.getColumnType(i)+"/"+rsMetaData.getColumnTypeName(i));
				System.out.println("[WrapperMaker][getTableInfo] Columna #"+i+"/"+nColumns+": "+rsMetaData.getColumnName(i)+"/"+rsMetaData.getColumnLabel(i)+" - "+rsMetaData.getColumnType(i)+"/"+rsMetaData.getColumnTypeName(i));
			}
		}
   	catch(Exception e)
    {
    //Logger.log(4,"[WrapperMaker][getTableInfo] "+e);
    	System.err.println("[WrapperMaker][getTableInfo] "+e);
    }

		return vTipoVariable;
  }


	/**
   * Escribe la clase en el fichero <i>$sTable.java</i>
   *
   * @param vTipoVariable Vector de <code>String[2]</code> donde
   * <code>String[0]</code> es el tipo java y <code>String[1]</code> es el nombre de la variable
   */
	private void writeClass(Vector vTipoVariable)
	{
		//-- Ahora formamos la clase
		String sTipo;
		String sVar;
		StringBuffer sClase=new StringBuffer("import java.util.*;\n");
		sClase.append("/**\n * Generado autom&aacute;ticamente por WrapperMaker.\n * \n * @since "+new java.util.Date()+"\n */\n");
		sClase.append("public class ").append(sTable).append("\n{\n");
		//-- Los atributos
		sClase.append("\t//-- Atributos\n");
		for(int i=0;i<vTipoVariable.size();i++)
		{
			sTipo=((String[])vTipoVariable.elementAt(i))[0];
			sVar=((String[])vTipoVariable.elementAt(i))[1];
			sClase.append("\tprivate "+sTipo+" "+sVar+";\n");
		}

		//-- Los métodos getXXX y setXXX
		sClase.append("\n\n\t//-- GETs y SETs");
		for(int i=0;i<vTipoVariable.size();i++)
		{
			sTipo=((String[])vTipoVariable.elementAt(i))[0];
			sVar=((String[])vTipoVariable.elementAt(i))[1];
			//-- GET
			sClase.append("\n\t/**\n\t * Devuelve ").append(sVar).append("\n\t * \n\t * @return ");
			sClase.append(sVar).append("\n\t */\n");
			sClase.append("\tpublic ").append(sTipo).append(" get").append(sVar);
			sClase.append("()\n\t{\n\t\treturn this.").append(sVar).append(";\n\t}\n");

			//-- SET
			sClase.append("\n\t/**\n\t * Asigna ").append(sVar).append("\n");
			sClase.append("\t * \n\t * @param un").append(sVar).append("\n\t */\n");
			sClase.append("\tpublic void ").append("set").append(sVar);
			sClase.append("(").append(sTipo).append(" un").append(sVar).append(")\n\t{\n");
			sClase.append("\t\tthis.").append(sVar).append(" = un").append(sVar).append(";\n\t}\n");
		}


		//-- Sería recomendable un par de métodos saveToDB() y loadFromDB() que dependerán de
		//-- de la forma en que se acceda a la BB.DD.

		//-- loadFromDB(int)
		sClase.append("\n\t/**\n\t* Carga la informaci&oacute;n de la tabla en el objeto.");
		sClase.append("\n\t*\n\t* @param nPK Clave primaria");
		sClase.append("\n\t* @return Objeto ").append(sTable).append("\n\t*/");
		sClase.append("\n\tpublic ").append(sTable).append(" loadFromDB(int nPK)\n\t{");
		/*sClase.append("\n\t\t*\n\t\t\t<TO DO>");
		sClase.append("\n\n\t\t\tAquí se realiza el acceso a la BB.DD. y se asocian\n\t\t\tlos resultados con los atributos del objeto");
		sClase.append("\n\t\t\tvRow devolverá siempre String, así que hay que mirar QUE es lo que esperamos exactamente");
		sClase.append("\n\t\t*");*/
		sClase.append("\n\t\tStringBuffer sSQL=new StringBuffer(\"SELECT ");
		if(!vTipoVariable.isEmpty())
			sClase.append(((String[])vTipoVariable.firstElement())[1]);
		for(int i=1;i<vTipoVariable.size();i++)
		{
			sClase.append(",").append(((String[])vTipoVariable.elementAt(i))[1]);
		}
		sClase.append(" FROM ").append(sTable);
		sClase.append(" WHERE __PK__=?\");");
		sClase.append("\n\t\tVector vParams=new Vector();\n");
		sClase.append("\n\t\tvParams.add(new Integer(nPK));");
		sClase.append("\n\t\tAbstractDBManager dbm = DBManager.getInstance();");
		sClase.append("\n\t\tVector vRtado = new Vector();");
		sClase.append("\n\t\ttry {");
		sClase.append("\n\t\t\tvRtado=dbm.executeQuery(sSQL.toString(),vParams);");
		sClase.append("\n\t\t}");
		sClase.append("\n\t\tcatch(Exception e) {");
		sClase.append("\n\t\t\t//-- Tratamiento de la excepcion");
		sClase.append("\n\t\t\treturn null;");
		sClase.append("\n\t\t}\n");
		sClase.append("\n\t\tVector vRow=null;");
		sClase.append("\n\t\tif(vRtado!=null && !vRtado.isEmpty()) {");
		sClase.append("\n\t\t\t//-- Solo puede haber un rtado puesto que __PK__ es PK");
		sClase.append("\n\t\t\tvRow=(Vector)vRtado.firstElement();\n");

		for(int i=0; i<vTipoVariable.size(); i++) {
			//sTipo=((String[])vTipoVariable.elementAt(i))[0];
			sVar=((String[])vTipoVariable.elementAt(i))[1];

			sClase.append("\n\t\t\tif(vRow.elementAt(").append(""+i).append(")!=null)");
			sClase.append("\n\t\t\t\tset").append(sVar).append("(").append("vRow.elementAt(").append(""+i).append(").toString().trim());");
		}

		sClase.append("\n\t\t}");
		sClase.append("\n\n\t\t return this;");
		sClase.append("\n\t}\n");

		//-- saveToDB()
		sClase.append("\n\n\t/**\n\t* Guarda la informaci&oacute;n del objeto en la tabla.\n\t*/");
		sClase.append("\n\tpublic void saveToDB() throws java.sql.SQLException\n\t{");
		sClase.append("\n\t\tStringBuffer sSQL=null;");
		sClase.append("\n\t\t//-- Chequeamos a ver si es un objeto nuevo");
		sClase.append("\n\t\tif(get__PK__()==null) { // ** TO DO **");
		sClase.append("\n\t\t\tsSQL = new StringBuffer(\"INSERT INTO ").append(sTable).append(" \");");
		sClase.append("\n\t\t\tsSQL.append(\"");

		if(!vTipoVariable.isEmpty())
			sClase.append("(").append(((String[])vTipoVariable.firstElement())[1]);
		for(int i=1;i<vTipoVariable.size();i++)
		{
			sClase.append(",").append(((String[])vTipoVariable.elementAt(i))[1]);
		}
		sClase.append("\");");
		sClase.append("\n\t\t\tsSQL.append(\") VALUES (\").append(");

		if(!vTipoVariable.isEmpty())
			sClase.append("get").append(((String[])vTipoVariable.firstElement())[1]).append("())");
		for(int i=1;i<vTipoVariable.size();i++)
		{
			sClase.append(".append(\",\").append(").append("get").append(((String[])vTipoVariable.elementAt(i))[1]).append("())");
		}
		sClase.append(";");
		sClase.append("\n\t\t\tsSQL.append(\")\");");
		sClase.append("\n\t\t}");

		//-- Las modificaciones
		sClase.append("\n\t\telse {");
		sClase.append("\n\t\t\tsSQL = new StringBuffer(\"UPDATE ").append(sTable).append(" SET \");");

		if(!vTipoVariable.isEmpty()) {
			sVar=((String[])vTipoVariable.firstElement())[1];
			sClase.append("\n\t\t\tsSQL.append(\"").append(sVar).append("='\").append(\"\"+get").append(sVar).append("()).append(\"'\");");
			//sClase.append(((String[])vTipoVariable.firstElement())[1]);
		}
		for(int i=1;i<vTipoVariable.size();i++)
		{
			sVar=((String[])vTipoVariable.elementAt(i))[1];
			sClase.append("\n\t\t\tsSQL.append(\", ").append(sVar).append("='\").append(\"\"+get");
			sClase.append(sVar).append("()).append(\"'\");");
			//sClase.append(",").append(((String[])vTipoVariable.elementAt(i))[1]);
		}

		sClase.append("\n\t\t\tsSQL.append(\" WHERE __PK__= __PK__\");");
		sClase.append("\n\t\t}");

		sClase.append("\n\n\t\t\tAbstractDBManager dbm = DBManager.getInstance();");
		sClase.append("\n\t\t\t\tdbm.executeUpdate(sSQL.toString());");

		sClase.append("\n\t}\n");


		//-- toString()
		sClase.append("\n\n\t/** Representaci&oacute;n del objeto */");
		sClase.append("\n\tpublic String toString()\n\t{\n");
		sClase.append("\t\treturn \"").append(sTable).append("-[");
		if(!vTipoVariable.isEmpty())
		{
			sVar=((String[])vTipoVariable.firstElement())[1];
			sClase.append(sVar).append("=\"+").append("get").append(sVar).append("()");
		}
		for(int i=1;i<vTipoVariable.size();i++)
		{
			sVar=((String[])vTipoVariable.elementAt(i))[1];
			sClase.append("+\",").append(sVar).append("=\"+").append("get").append(sVar).append("()");
		}
		sClase.append("+\"]\";");
		sClase.append("\n\t}");

		//-- eoClass
		sClase.append("\n}");

		PrintWriter pw=null;
    try
    {
			pw=new PrintWriter(new FileWriter(sTable+".java",false));
			pw.println(sClase);
			pw.close();
		}
    catch(IOException e)
    {
    	//Logger.log(4,"[WrapperMaker][writeClass] No se ha podido abrir el fichero "+sTable+".java");
    	System.err.println("[WrapperMaker][writeClass] No se ha podido abrir el fichero "+sTable+".java");
    }
		catch(Exception e)
    {
    	//Logger.log(4,"[WrapperMaker][writeClass] Error: "+e);
    	System.err.println("[WrapperMaker][writeClass] Error: "+e);
		}
	}



	/**
   * Escribe la clase en el fichero <i>$sTable.asp</i>
   *
   * @param vTipoVariable Vector de <code>String[2]</code> donde
   * <code>String[0]</code> es el tipo java y <code>String[1]</code> es el nombre de la variable
   */
	private void writeASP(Vector vTipoVariable)
	{
		//-- Ahora formamos la clase
		String sTipo;
		String sVar;
		StringBuffer sClase=new StringBuffer("<%\n'************************************************************************");
		sClase.append("\n '* Generado automáticamente por WrapperMaker.\n '* \n '* @since ");
		sClase.append(new java.util.Date());
		sClase.append("\n '*");
		sClase.append("\n '* No olvide realizar modificaciones en saveToDB() y loadFromDB()");
		sClase.append("\n '* así como en los lugares que considere necesario");
		sClase.append("\n '* El texto __PK__ debe cambiarse por el atributo que represente");
		sClase.append("\n '* la clave primaria");
		sClase.append("\n '************************************************************************\n");
		sClase.append("\nClass ").append(sTable).append("\n\n");
		//-- Los atributos
		sClase.append("'---- Atributos ----\n");
		sClase.append("\t'Private strConnString = \"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=\" & Server.MapPath(__path_a_bbdd__) '## MS Access 2000 using virtual path\n");
		sClase.append("\t'Private strConnString = \"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=\" & Server.MapPath(__path_a_bbdd__) '## MS Access 2000 on Brinkster\n");
		sClase.append("\t'Private strConnString = \"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=__path_a_bbdd__\" '## MS Access 2000\n");
		sClase.append("\t'Private strConnString = \"DRIVER={Microsoft Access Driver (*.mdb)}; DBQ=\" & Server.MapPath(__path_a_bbdd__) '## MS Access 97 using virtual path\n");
		sClase.append("\t'Private strConnString = \"DRIVER={Microsoft Access Driver (*.mdb)}; DBQ=\" & Server.MapPath(__path_a_bbdd__) '## MS Access 97 on Brinkster\n");
		sClase.append("\t'Private strConnString = \"DRIVER={Microsoft Access Driver (*.mdb)}; DBQ=__path_a_bbdd__\" '## MS Access 97\n");
		sClase.append("\t'Private strConnString = \"Provider=SQLOLEDB;Data Source=SERVER_NAME;database=DB_NAME;uid=UID;pwd=PWD;\" '## MS SQL Server 6.x/7.x/2000 (OLEDB connection)\n");
		sClase.append("\t'Private strConnString = \"driver={SQL Server};server=SERVER_NAME;uid=UID;pwd=PWD;database=DB_NAME\" '## MS SQL Server 6.x/7.x/2000 (ODBC connection)\n");
		sClase.append("\t'Private strConnString = \"driver=MySQL;server=SERVER_IP;uid=UID;pwd=PWD;database=DB_NAME\" '## MySQL\n");
		sClase.append("\t'Private strConnString = \"DSN_NAME\" '## DSN\n");

		for(int i=0;i<vTipoVariable.size();i++)
		{
			//sTipo=((String[])vTipoVariable.elementAt(i))[0];
			sVar=((String[])vTipoVariable.elementAt(i))[1];
			sClase.append("\tPublic "+sVar+"\n");
		}

		//-- Los métodos getXXX y setXXX
		sClase.append("\n\n'---- GETs y SETs ----");
		for(int i=0;i<vTipoVariable.size();i++)
		{
			//sTipo=((String[])vTipoVariable.elementAt(i))[0];
			sVar=((String[])vTipoVariable.elementAt(i))[1];
			//-- GET
			sClase.append("\n\t'/**\n\t '* Devuelve ").append(sVar).append("\n\t '* \n\t '* @return ");
			sClase.append(sVar).append("\n\t '*/\n");
			sClase.append("\tPublic Function ").append(" get").append(sVar);
			sClase.append("()\n\t\tget").append(sVar).append(" = ").append(sVar).append("\n\tEnd Sub\n");

			//-- SET
			sClase.append("\n\t'/**\n\t '* Asigna ").append(sVar).append("\n");
			sClase.append("\t '* \n\t '* @param un").append(sVar).append("\n\t '*/\n");
			sClase.append("\tPublic Sub ").append("set").append(sVar);
			sClase.append("(").append("un").append(sVar).append(")\n");
			sClase.append("\t\t").append(sVar).append(" = un").append(sVar).append(";\n\tEnd Sub\n");
		}

//---- seh
		//-- Sería recomendable un par de métodos saveToDB() y loadFromDB() que dependerán de
		//-- de la forma en que se acceda a la BB.DD.

/*
	'-----------------------------------------------
	'Carga de la BB.DD. la información asociada
	'
	'@param id
	'
	Public Sub load(id)
		dim strSQL
		dim rsUser

		'Create recorset object
		Set rsUser = Server.CreateObject("ADODB.Recordset")

		'Initalise the strSQL variable with an SQL statement to query the database
		strSQL = "SELECT * "
		strSQL = strSQL & "FROM EDR_TIPO_USUARIO "
		strSQL = strSQL & "WHERE EDR_TIPO_USUARIO.ID_TIPOUSUARIO ="& id

		'Query the database
		if not id="" then
			rsUser.Open strSQL, strConnString
		end if

		'If the recordset finds a record for the username entered then load user info
		If not rsUser.EOF Then
			id_tipo_usuario=rsUser("ID_TIPO_USUARIO")
			desc_tipo_usuario=rsUser("DESC_TIPO_USUARIO")
		End If

		rsUser.close
	End Sub
*/
		//-- loadFromDB(int)
		//sClase.append("\n/* ######## < TO DO > ########");
		sClase.append("\n\t'/**\n\t'* Carga la informaci&oacute;n de la tabla en el objeto.");
		sClase.append("\n\t'*\n\t'* @param nPK Clave primaria (hemos supuesto un entero)");
		sClase.append("\n\t'* @return Objeto ").append(sTable).append("\n\t'*/");
		sClase.append("\n\tPublic Sub loadFromDB(nPK)");
		sClase.append("\n\t\tdim rs");
		sClase.append("\n\t\tdim sSQL");
		sClase.append("\n\n\t\t'Creamos el recorset\n\t\tset rs = Server.CreateObject(\"ADODB.Recordset\")");

		sClase.append("\n\t\tsSQL=\"SELECT * FROM ").append(sTable).append(" WHERE __PK__= \" & nPK");
		sClase.append("\n\n\t\t'Accedemos a BB.DD.");
		sClase.append("\n\t\tif not isempty(nPK) and not nPK=\"\" then");
		sClase.append("\n\t\t\trs.Open sSQL, strConnString 'strConnString debe estar definido con anterioridad");
		sClase.append("\n\t\tend if\n");
		sClase.append("\n\t\t'Si encontramos información, la cargamos en el objeto");
		sClase.append("\n\t\tif not rs.EOF then");

		sVar="";
		for(int i=0;i<vTipoVariable.size();i++)
		{
			sVar=((String[])vTipoVariable.elementAt(i))[1];
			sClase.append("\n\t\t\t").append(sVar).append(" = rs(\"").append(sVar).append("\")");
		}
		sClase.append("\n\t\tend if");
		sClase.append("\n\n\t\trs.close");
		sClase.append("\n\tEnd Sub\n");

/*
	'-----------------------------------------------
	'Guarda en la BB.DD. la información asociada
	'
	Public Sub save()
		dim strSQL
		dim rsUser
		dim oConn

		'Creamos la conexion y la abrimos
		set oConn=server.createobject ("adodb.connection")
		oConn.mode=3 'R/W
		oConn.open strConnString

		'Chequeamos si es un usuario nuevo o una modificacion
		if id_usuario="" then
			'Usuario nuevo
			strSQL = "INSERT INTO EDR_TIPO_USUARIO (ID_TIPO_USUARIO,DESC_TIPO_USUARIO) VALUES(" & id_tipo_usuario & ", '" & DESC_TIPO_USUARIO & "')"
		else
			'Actualización de usuario
			strSQL = "UPDATE EDR_TIPO_USUARIO SET DESC_TIPO_USUARIO='" & desc_tipo_usuario & "' WHERE ID_TIPO_USUARIO=" & id_tipo_usuario
		end if
		'response.write strSQL
		oConn.execute(strSQL)
		oConn.close
	End Sub
*/
		//-- saveToDB()
		sClase.append("\n\n\t'/**\n\t'* Guarda la información del objeto en la table.\n\t'*/");
		sClase.append("\n\tPublic Sub saveToDB()");
		sClase.append("\n\t\tdim oConn");
		sClase.append("\n\t\tdim sSQL");
		sClase.append("\n\n\t\t'Creamos la conexion y la abrimos\n\t\tset oConn = server.createObject(\"adodb.connection\")");
		sClase.append("\n\t\toConn.mode=3 'R/W");
		sClase.append("\n\t\toConn.open strConnString 'strConnString debe estar creado");

		sClase.append("\n\t\t'Chequeamos si es un usuario nuevo o una modificacion");
		sClase.append("\n\t\tif isempty(__PK__) or __PK__=\"\" then");
		sClase.append("\n\t\t\t'Nuevo ").append(sTable);
		//strSQL = "INSERT INTO EDR_TIPO_USUARIO (ID_TIPO_USUARIO,DESC_TIPO_USUARIO)
		// VALUES(" & id_tipo_usuario & ", '" & DESC_TIPO_USUARIO & "')"
		sClase.append("\n\t\t\tsSQL = \"INSERT INTO ").append(sTable).append(" (");

		if(!vTipoVariable.isEmpty())
			sClase.append(((String[])vTipoVariable.firstElement())[1]);
		for(int i=1;i<vTipoVariable.size();i++)
		{
			sClase.append(",").append(((String[])vTipoVariable.elementAt(i))[1]);
		}
		sClase.append(") VALUES (");

		sTipo=((String[])vTipoVariable.firstElement())[0];
		if(!vTipoVariable.isEmpty()) {
			if(sTipo!=null && sTipo.equalsIgnoreCase("String"))
				sClase.append("'\" & get").append(((String[])vTipoVariable.firstElement())[1]).append("() & \"'\"");
			else
				sClase.append("\" & get").append(((String[])vTipoVariable.firstElement())[1]).append("() & \"");
		}
		for(int i=1;i<vTipoVariable.size();i++)
		{
			sVar=((String[])vTipoVariable.elementAt(i))[1];
			sTipo=((String[])vTipoVariable.elementAt(i))[0];

			if(sTipo!=null && sTipo.equalsIgnoreCase("String"))
				sClase.append(",'\" & ").append("get").append(sVar).append("() & \"'");
			else
				sClase.append(",\" & ").append("get").append(sVar).append("() & \"");
		}
		sClase.append(") \");");

		sClase.append("\n\t\telse");
		sClase.append("\n\t\t\t'Modificación de "+sTable);
		sClase.append("\n\t\t\tsSQL=\"UPDATE "+sTable+" SET ");
		if(!vTipoVariable.isEmpty()) {
			sClase.append(((String[])vTipoVariable.firstElement())[1]).append(" = ");
			sTipo=((String[])vTipoVariable.firstElement())[0];
			if(sTipo!=null && sTipo.equalsIgnoreCase("String"))
				sClase.append("'\" & get").append(((String[])vTipoVariable.firstElement())[1]).append("() & \"'\"");
			else
				sClase.append("\" & get").append(((String[])vTipoVariable.firstElement())[1]).append("() & \"");
			}

		for(int i=1;i<vTipoVariable.size();i++)
		{
			sVar=((String[])vTipoVariable.elementAt(i))[1];
			sTipo=((String[])vTipoVariable.elementAt(i))[0];
			sClase.append(",").append(sVar).append(" = ");
			if(sTipo!=null && sTipo.equalsIgnoreCase("String"))
				sClase.append("'\" & ").append("get").append(sVar).append("() & \"'");
			else
				sClase.append("\" & ").append("get").append(sVar).append("() & \"");
		}
		sClase.append(" WHERE __PK__=__PK_VALUE__\"");

		sClase.append("\n\t\tend if");
		sClase.append("\n\n\t\toConn.execute(sSQL)");
		sClase.append("\n\t\toConn.close(sSQL)");
		sClase.append("\n\tEnd Sub\n");


		//-- toString()
		sClase.append("\n\n\t'/**\n \t'* Representaci&oacute;n del objeto\n\t'*/");
		sClase.append("\n\tPublic Function toString()\n");
		sClase.append("\t\ttoString \"").append(sTable).append("-[");
		if(!vTipoVariable.isEmpty())
		{
			sVar=((String[])vTipoVariable.firstElement())[1];
			sClase.append(sVar).append("=\"&").append("get").append(sVar).append("()");
		}
		for(int i=1;i<vTipoVariable.size();i++)
		{
			sVar=((String[])vTipoVariable.elementAt(i))[1];
			sClase.append(" & \",").append(sVar).append("=\" & ").append("get").append(sVar).append("()");
		}
		sClase.append(" & \"]\";");
		sClase.append("\n\tEnd Function");


		//-- setProperties()
		//-- Función para recoger la información de un formulario
		sClase.append("\n\n\n\t'Recogemos los valores del objeto pasados por un formulario");
		sClase.append("\n\t'Habría que ver si conviene sacarlos a otro fichero o");
		sClase.append("\n\t'Incluirlos como una función de clase");
		sClase.append("\n\t'/**\n\t'* Carga la información a partir de un formulario\n\t'*/");
		sClase.append("\n\tPublic Sub setProperties()");
		for(int i=0;i<vTipoVariable.size();i++)
		{
			sVar=((String[])vTipoVariable.elementAt(i))[1];
			sClase.append("\n\t\t").append(sVar).append(" = ").append("request.form(\"").append(sVar).append("\")");
		}
		sClase.append("\n\tEnd Sub");

		//-- eoClass
		sClase.append("\nEnd Class\n'**********\n");
		sClase.append("%>");


		PrintWriter pw=null;
    try
    {
			pw=new PrintWriter(new FileWriter(sTable+".asp",false));
			pw.println(sClase);
			pw.close();
		}
    catch(IOException e)
    {
    	//Logger.log(4,"[WrapperMaker][writeClass] No se ha podido abrir el fichero "+sTable+".java");
    	System.err.println("[WrapperMaker][writeClass] No se ha podido abrir el fichero "+sTable+".asp");
    }
		catch(Exception e)
    {
    	//Logger.log(4,"[WrapperMaker][writeClass] Error: "+e);
    	System.err.println("[WrapperMaker][writeClass] Error: "+e);
		}
	}


	/**
   *
   * @param sDSJndi Nombre JNDI asociado al <code>DataSource</code>
   * @param sTable Nombre de la tabla de la que se quiere generar el <i>wrapper</i>
   * @return Nombre de la clase generada
   */
	public String makeWrapper(String sDSJndi, String sTable)
	{
		String sClassName=sTable+".java";
		DataSource ds=getDataSource(sDSJndi);

		return sClassName;
	}


	/**
   * Para pruebas...
   */
	public static void main(String []args)
	{
		if(args.length==0 || args.length<3)
		{
			showSintax();
		}
		else
		{
			String sDS="";
			String sDriver="";;
			String sUrl="";
			String sTable="";
			String sUser="";
			String sPassword="";
			// Para ver si generamos código ASP o Java
			String sCodeType="";

			for(int i=0; i<args.length; i++)
			{
				if(args[i].trim().startsWith("-drv:"))
					sDriver=args[i].trim().substring(5);
				else if(args[i].trim().startsWith("-t:"))
					sTable=args[i].trim().substring(3);
				else if(args[i].trim().startsWith("-url:"))
					sUrl=args[i].trim().substring(5);
				else if(args[i].trim().startsWith("-user:"))
					sUser=args[i].trim().substring(6);
				else if(args[i].trim().startsWith("-p:"))
					sPassword=args[i].trim().substring(3);
				else if(args[i].trim().startsWith("-ds:"))
					sPassword=args[i].trim().substring(4);
				else if(args[i].trim().startsWith("-code:"))
					sCodeType=args[i].trim().substring(6);
			}

			if(
				 	(
				 		sDS.equals("")
			   				&&
			   		(sUrl.equals("") || sDriver.equals("") || sTable.equals(""))
			 		)
			   		||
			   sTable.equals("")
			  )
			{
				showSintax();
			}
			else
			{
				Connection oConn=null;
				WrapperMakerMays wm=new WrapperMakerMays(sTable);
				if(!sDS.equals(""))
				{
					oConn=wm.getConnection(sDS);
				}
				else
				{
					oConn=wm.getConnection(sDriver,sUrl,sUser,sPassword);
				}

				// Escribimos clase Java
				if(sCodeType==null || sCodeType.equals("") || sCodeType.equalsIgnoreCase("java")) {
					wm.writeClass(wm.getTableInfo(oConn));
				}
				// Escribimos claseASP
				else {
					wm.writeASP(wm.getTableInfo(oConn));
				}

				// Cerramos
				try
			  {
			  	oConn.close();
			  }
			  catch (Exception e)
			  {
			  	//Logger.log(4,"[WrapperMaker][main] Error al cerrar la conexión: "+e);
			  	System.err.println("[WrapperMaker][main] Error al cerrar la conexión: "+e);
			  }
			}
		}
	}

	/**
   * Muestra la sintaxis del objeto
   */
	public static void showSintax()
	{
			System.out.println("\nSintaxis:\n\t java net.seh.bd.WrapperMaker (<opcion_url> | <opcion_jndi>)");
			System.out.println("\nOpción URL:");
			System.out.println("\t-drv:<DriverName>\n\t-url:<URL>\n\t-t:<TableName>");
			System.out.println("\t[-user:<User>]\n\t[-p:<Password>]\n");
			System.out.println("\nOpción JNDI:");
			System.out.println("\t-ds:<JNDIDataSourceName>\n\t-t:<TableName>");
			System.out.println("\nY en ambos casos:\n\t-code:<asp|java>");
	}


  /**
  * Carga el fichero de configuraci&oacute;n
  *
  * @param <code>sFile</code> Nombre del fichero de propiedades
  */
  private static Properties loadConfigFile(String sFile)
  {
    Properties p=new Properties();
    try
    {
      p.load(new FileInputStream(
                  new File(com.emesa.Configuration.getProperty("folder.properties")+sFile))
            );
    }
    catch(IOException e)
    {
      //Logger.log(4,"[WrapperMaker][loadConfigFile] Error al abrir el fichero "+sFile);
      System.err.println("[WrapperMaker][main] Error al cerrar la conexión: "+e);
    }
    catch(Exception e)
    {
      //Logger.log(4,"[WrapperMaker][loadConfigFile] Error: "+e);
      System.err.println("[WrapperMaker][loadConfigFile] Error: "+e);
    }

    return p;
  }

}