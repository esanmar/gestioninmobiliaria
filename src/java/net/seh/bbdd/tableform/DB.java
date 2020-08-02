package net.seh.bbdd.tableform;

import java.util.Properties;
import java.util.Vector;
import java.sql.*;

import org.apache.log4j.Logger;

import net.seh.bbdd.*;

/**
 */
public class DB
{
    /** <i>Logger</i> */
    static Logger logger = Logger.getLogger(DB.class);

    /** Nombre de la BB.DD. */
    String sName;
    /** Driver */
    String sDriver;
    /** URL */
    String sURL;
    /** Properties de acceso a la BB.DD. */
    Properties p;

    /** Vector de tablas de la BB.DD. */
    Vector vTables;

    /**
     * Constructor
     */
    public DB(String sName) {
        this(sName,"","","","",false);
    }

    /**
     * Constructor
     *
     * @param sName Nombre de la BB.DD.
     */
    public DB(String sName, String sDriver, String sURL, String sUser, String sPassword, boolean loadTables)
    {
        this.sName=sName;
        this.sDriver=sDriver;
        this.sURL=sURL;
        p=new Properties();
        setUser(sUser);
        setPassword(sPassword);
        if(!loadTables)
            vTables=new Vector();
        else {
            try {
                loadTables();
            }
            catch(Exception e)
            {
                System.err.println("Error: "+e);
            }
        }
    }


    //-- GET's y SET's
    public String getName()
    { return this.sName; }
    public Vector getTables()
    { return this.vTables; }
    public void setUser(String s)
    { p.put("user",s); }
    public void setPassword(String s)
    { p.put("password",s); }
    public String getUser()
    { return p.get("user").toString(); }
    public String getPassword()
    { return p.get("password").toString(); }

    /**
     * Nos conectamos a la BB.DD.
     */
    public void loadTables() throws Exception
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

            rs=dbmd.getTables(sName,null,null,new String[]{"TABLE_NAME","TABLE_TYPE"});
            int j = rs.getMetaData().getColumnCount();
            for(vTables=new Vector(); rs.next(); ) {
                vTables.addElement(new DBTable(getName(),rs.getString(2 + 1),sDriver,sURL,getUser(),getPassword(),false));
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
     */
    public boolean equals(Object o)
    {
        logger.debug("[equals] "+this+" vs. "+o);
        if(o==null)
            return false;
        DB other;
        try {
            other=(DB)o;
        }
        catch(Exception e) {
            return false;
        }
        return other.getName().equals(getName());
    }

    /** Representaci&oacute;n del objeto */
    public String toString()
    {
        return "DB-["+sName+", "+vTables+"]";
    }
}  //-- eoClass