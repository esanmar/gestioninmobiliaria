package net.seh.bbdd;

import java.util.Properties;
import java.util.Vector;
import java.sql.*;

import org.apache.log4j.Logger;

import net.seh.bbdd.tableform.*;

/**
 * Clase para generar formularios JSP a partir de una tabla
 *
 * @author sasa eh
 * @since 23/06/2003
 * @version 0.5
 */
public class TableForm
{
    /** <i>Logger</i> */
    static Logger logger = Logger.getLogger(TableForm.class);

    /** <i>Driver</i>*/
    String sDriver;
    /** <i>URL</i> de conexo&oacoute;n a la BB.DD.*/
    String sURL;
    /** Usuario y contrase&ntilde;a con la que establecemos la conexi&oacute;n (junto con el resto de las propiedades que queramos a&ntilde;adir*/
    Properties p;

    /** Informaci&oacute;n de la BB.DD. */
    String sDBInfo="";

    /** Vector de <i>cat&aacute;logos</i> (BB.DD.s) disponibles */
    Vector vCatalogs;

    /** Tabla seleccionada */
    DBTable oSelTable;
    /** BB.DD. seleccionada */
    DB oSelDB;


    /**
     * Constructor por defecto
     */
    public TableForm() {
        this("sun.jdbc.odbc.JdbcOdbcDriver","","","");
    }

    /**
     * Constructor
     */
    public TableForm(String sDriver, String sUrl, String sUser, String sPassword) {
        // Driver JDBC/ODBC de Sun por defecto
        setDriver(sDriver);
        setURL(sUrl);
        p=new Properties();
        setUser(sUser);
        setPassword(sPassword);

        try {
            loadCatalogs();
        }
        catch(Exception e)
        {
            vCatalogs=new Vector();
        }
        oSelTable=null;
        oSelDB=null;
    }


    //-- GET's y SET's
    public String getDriver()
    { return this.sDriver; }
    public String getURL()
    { return this.sURL; }
    public String getUser()
    { return p.get("user").toString(); }
    public String getPassword()
    { return p.get("password").toString(); }
    public DBTable getTable()
    { return this.oSelTable; }
    public String getDBInfo()
    { return this.sDBInfo; }
    public Vector getCatalogs()
    { return this.vCatalogs; }

    public void setDriver(String s)
    { this.sDriver = s; }
    public void setURL(String s)
    { this.sURL = s; }
    public void setUser(String s)
    { p.put("user",s); }
    public void setPassword(String s)
    { p.put("password",s); }
    public void setDBInfo(String s)
    { this.sDBInfo=s; }
    public void setTable(String s)
    {
        logger.debug("[setTable] "+getDB().getName()+", "+s+", "+getDriver()+", "+getURL()+", "+getUser()+", "+getPassword());
        oSelTable=new DBTable(getDB().getName(),s,getDriver(),getURL(),getUser(),getPassword(),true);
    }

    public void setDb(String sBBDD)
    {
        logger.debug("[setDB] Asignamos la BB.DD.: "+sBBDD);
        if(vCatalogs==null || vCatalogs.isEmpty()) {
            try {
                loadCatalogs();
            }
            catch(Exception e)
            {
                logger.error("[setDB] Error al cargar los catálogos: "+e);
            }
        }
        int i=vCatalogs.indexOf(new DB(sBBDD));
        if(i>-1) {
            oSelDB=(DB)vCatalogs.get(i);
            try {
                oSelDB.loadTables();
            }
            catch(Exception e) {
                logger.error("[setDB] Error al cargar las tablas de "+oSelDB+": "+e);
            }
        }
    }
    public DB getDB()
    {
        return oSelDB;
    }

    private void setProperties(Properties p)
    { this.p=p; }


    /**
     * Nos conectamos a la BB.DD.
     */
    public void loadCatalogs() throws Exception
    {
        Connection dbConn=null;
        DatabaseMetaData dbmd=null;
        ResultSet rs=null;

        try {
            dbConn=getConnection();
        }
        catch(Exception e)
        {
            throw e;
        }

        //-- Metadata
        if(dbConn!=null && !dbConn.isClosed()) {
            dbmd=dbConn.getMetaData();
            logger.debug("[loadCatalogs] Cargamos la información de la BB.DD.");
            setDBInfo("- Producto y versión: "+dbmd.getDatabaseProductName()+" v. "+dbmd.getDatabaseProductVersion()+"\n- Driver: "+dbmd.getDriverName()+" v. "+dbmd.getDriverVersion());

            //-- Catálogos (BB.DD.):
            vCatalogs=new Vector();
            try {
                rs = dbmd.getCatalogs();
                int j = rs.getMetaData().getColumnCount();
                String sBBDD="";
                for(; rs.next(); ) {
                    vCatalogs.add(new DB(rs.getString(1),sDriver,sURL,getUser(),getPassword(),false));
                }
            } catch(Exception ex) {
                if(rs != null)
                    rs.close();

                if(dbConn!=null && !dbConn.isClosed())
                    dbConn.close();

                throw new Exception("Error al recuperar las BB.DD.: "+getURL()+" con el driver "+getDriver()+" y el usuario/clave "+getUser()+"/"+getPassword()+": "+ex);
            }
        }
        //-- Cerramos todo
        if(rs != null)
            rs.close();

        if(dbConn!=null && !dbConn.isClosed())
            dbConn.close();
    }



    /**
     */
    private Connection getConnection() throws Exception
    {
        Connection dbConn=null;
        AbstractDBManager dbm=null;

        // Nos conectamos a la BB.DD. vía ODBC
        try {
            dbm=DBManager.getInstance(sDriver,sURL,p);
        }
        catch(Exception e) {
            throw new Exception("Error al conectarse a la BB.DD.: "+sURL+" con el driver "+sDriver+" y el usuario/clave "+p+": "+e);
        }

        //-- Obtenemos una conexión
        try {
            dbConn=dbm.getConnection();
        }
        catch(Exception e) {
           dbm.close();
           throw new Exception("Error al obtener una conexión: "+e);
        }

        return dbConn;
    }

    /**
     * Representaci&oacute;n del objeto
     */
    public String toString()
    {
        StringBuffer buffer = new StringBuffer(500);
        buffer.append("TableForm-[sDriver = ");
        buffer.append(this.sDriver);
        buffer.append(", sURL = ");
        buffer.append(this.sURL);
        buffer.append(", p = ");
        if ( this.p!= null )
            buffer.append(this.p.toString()).append(", ");
        else
            buffer.append("NULL ,");

        if ( getDB()!= null )
            buffer.append(getDB().toString()).append(", ");
        else
            buffer.append("NULL , ");
        if (getTable()!= null )
            buffer.append(getTable().getName());
        else
            buffer.append("NULL");
        buffer.append("]");

        return buffer.toString();
    }

    /** Para pruebas */
    public static void main(String []args)
    {
        // MySQL/ifornet
        TableForm tf = new TableForm("org.gjt.mm.mysql.Driver","jdbc:mysql://192.168.1.23:3306/ifornet?autoReconnect=true","ifornet","ifornet");
        System.out.println(tf.getCatalogs());
        tf.setDb("ifornet");
        System.out.println(tf.getDB());
        tf.setTable("ifo_curso");
        System.out.println(tf.getTable());
    }
} //-- eoClass
