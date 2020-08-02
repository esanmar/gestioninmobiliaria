package net.seh.bbdd.tableform;

import java.util.Properties;
import java.util.Vector;
import java.sql.*;

import org.apache.log4j.Logger;

import net.seh.bbdd.*;

/**
 * Representaci&oacute;n de una tabla en la BB.DD.
 */
public class DBTable
{
    /** <i>Logger</i> */
    static Logger logger = Logger.getLogger(DBTable.class);

    /** Nombre de la BBDD a la que pertenece la tabla */
    String sBBDD;
    /** Nombre de la tabla */
    String sName;
    /** Campos de la tabla */
    Vector vFields;

    /** <i>Driver</i>*/
    String sDriver;
    /** <i>URL</i> de conexo&oacoute;n a la BB.DD.*/
    String sURL;
    /** Usuario y contrase&ntilde;a con la que establecemos la conexi&oacute;n (junto con el resto de las propiedades que queramos a&ntilde;adir*/
    Properties p;


    /**
     * Constructor por defecto
     */
    public DBTable(String sDriver, String sURL, String sUser, String sPassword)
    {
        this("","",sDriver,sURL,sUser,sPassword,false);
    }
    /**
     * Constructor
     *
     * @param sName Nombre de la tabla
     */
    public DBTable(String sBBDD,String sName,String sDriver, String sURL, String sUser, String sPassword,boolean loadFields)
    {
        setBBDD(sBBDD);
        setName(sName);
        this.sDriver=sDriver;
        this.sURL=sURL;
        p=new Properties();
        setUser(sUser);
        setPassword(sPassword);

        if(loadFields) {
            try {
                loadFields();
            }
            catch(Exception e)
            {
                System.err.println("Error: "+e);
            }
        }
    }

    /*
     * Constructor
     *
     * @param sName Nombre de la tabla
     * @param vFields Vector de <code>DBField<code>
     *
    public DBTable(String sName,Vector vFields)
    {
        setName("");
        setFields(vFields);
    }
    */

    /**
     */
    public void loadFields() throws Exception
    {
        Connection dbConn=null;
        DatabaseMetaData dbmd=null;
        ResultSet rs=null;
        vFields=new Vector();

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

            try {
                rs=dbmd.getColumns(sBBDD,null,sName,null);
                int j = rs.getMetaData().getColumnCount();
                for(; rs.next(); ) {
                    addField(rs.getString(4),rs.getString(6),rs.getInt(7));
                    }
            }
            catch(Exception e)
            {
                logger.error("[loadFields] Error: "+e);
                if(rs != null)
                    rs.close();

                if(dbConn!=null && !dbConn.isClosed())
                    dbConn.close();

                throw e;
            }
        }
        //-- Cerramos todo
        if(rs != null)
            rs.close();

        if(dbConn!=null && !dbConn.isClosed())
            dbConn.close();
    }

    /**
     * Obtenemos una conexi&oacute;n con la informaci&oacute;n del objeto
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


    //-- GET's y SET's
    public String getName()
    { return sName; }
    public Vector getFields()
    { return vFields; }

    public void setName(String s)
    { this.sName=s; }
    public void setBBDD(String s)
    { this.sBBDD=s; }
    public void setFields(Vector v)
    { this.vFields = v; }
    public void setUser(String s)
    { p.put("user",s); }
    public void setPassword(String s)
    { p.put("password",s); }
    public String getUser()
    { return p.get("user").toString(); }
    public String getPassword()
    { return p.get("password").toString(); }

    /**
     * A&ntilde;ade un campo a la tabla
     *
     * @param sName Nombre del campo
     * @param sType Tipo del campo
     * @param size Tama&ntilde;o del campo
     * @return
     */
    public boolean addField(String sName,String sType, int size)
    {
        return vFields.add(new DBField(sName,sType,size));
    }

    /**
     * Elimina un campo de la representací&oacute;n de la tabla
     *
     * @param sName Nombre del campo a eliminar
     * @retun
     */
    public boolean delField(String sName)
    {
        return vFields.remove(new DBField(sName,null,-1));
    }

    /**
     */
    public boolean equals(Object o)
    {
        if(o==null)
            return false;
        DBTable other;
        try {
            other=(DBTable)o;
        }
        catch(Exception e) {
            return false;
        }
        return other.getName().equals(getName());
    }

    /** Representaci&oacute;n del objeto */
    public String toString()
    {
        return "DBTable-["+sName+", "+vFields+"]";
    }

} //-- eoClass

