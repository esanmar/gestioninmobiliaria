package com.emesa.bbdd;

import com.emesa.Configuration;
import net.seh.bbdd.AbstractDBManager;

/**
 * Clase de acceso a BB.DD. para el proyecto
 *
 * @see net.seh.bbdd.AbstractDBManager
 */
public class DBManager
{
    /**
     */
    private DBManager() {
    }

    /**
     * Devuelve una instancia del gestor de BB.DD. indicado en el fichero de
     * propiedades.
     */
    public static AbstractDBManager getInstance() {
        // JNDI
        if(Configuration.getProperty("db.type").equalsIgnoreCase("jndi"))
            return net.seh.bbdd.DBManager.getInstance(Configuration.getProperty("db.jndi"));
        // ODBC
        else {
            java.util.Properties p=new java.util.Properties();
            p.put("user",Configuration.getProperty("db.odbc.user"));
            p.put("password",Configuration.getProperty("db.odbc.password"));

            try {
                return net.seh.bbdd.DBManager.getInstance(
                        Configuration.getProperty("db.odbc.driver"),
                        Configuration.getProperty("db.odbc.url"),
                        p);
            }
            catch(Exception e) {
                System.err.println("[getInstance] Error: "+e);
                return null;
            }
        }
    }
}