package com.emesa.gestinm.misc;

import java.io.File;
import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;
import org.apache.regexp.RE;

import com.emesa.bbdd.DBManager;

/**
 *
 */
public class CSVExport
{
/*==========================================================================
 *
 *      ATRIBUTOS
 */

    /** <i>Logger</i> */
    static Logger logger = Logger.getLogger(CSVExport.class);

    /** Directorio destino donde se van a dejar los CSV */
    String sDestDir=null;
    /**
     * <i>Query</i> a ejecutar para guardar el resultado a un fichero, con
     * los par&aacute;metros representados por <code>?</code>
     */
    String sSQL=null;
    /** Caracter que marca el l&iacute;mite de los campos en el fichero */
    String sFieldLimit=null;
    /** Caracter que marca el final de un registro en el fichero */
    String sLineLimit=null;
    /** Nombre de las tablas de la BB.DD. que se quiere pasar a CSV */
    Object []lTables=null;

/*==========================================================================
 *
 *      CONSTRUCTORES
 */

    /**
     * Constructor por defecto
     */
    public CSVExport() throws Exception{
        this("",";","\n","SELECT * INTO OUTFILE #outfile# FIELDS TERMINATED BY #field# OPTIONALLY ENCLOSED BY '\"' LINES TERMINATED BY #line# FROM #db#",new String[]{});
    }

    /**
     * Constructor
     *
     * @param sDestDir Directorio destino donde se guardar&aacute;n los ficheros CSV
     * @param lTables <i>Array</i> con los nombre de las tablas que se vana  guardar
     */
    public CSVExport(String sDestDir, Object []lTables) throws Exception {
        this(sDestDir,";","\n","SELECT * INTO OUTFILE #outfile# FIELDS TERMINATED BY #field# OPTIONALLY ENCLOSED BY '\"' LINES TERMINATED BY #line# FROM #db#",lTables);
    }

    /**
     * Constructor completo
     *
     * @param sDestDir Directorio destino donde se guardar&aacute;n los ficheros CSV
     * @param lTables <i>Array</i> con los nombre de las tablas que se vana  guardar
     */
    public CSVExport(String sDestDir, String sFieldLimit, String sLineLimit, String sSQL, Object []lTables)
        throws Exception {
        setDestDir(sDestDir);
        setFieldLimit(sFieldLimit);
        setLineLimit(sLineLimit);
        setSQL(sSQL,sFieldLimit,sLineLimit);
        setTables(lTables);
    }



/*==========================================================================
 *
 *      MÉTODOS
 */
//------------ GET's y SET's
    /**
     *
     * @param sFolderName <i>Path</i> del directorio que va a contener los CSV
     */
    public void setDestDir(String sFolderName) {
        this.sDestDir=sFolderName;
    }
    public String getDestDir()
    { return this.sDestDir; }

    /**
     *
     * @param sFieldLimit Caracter que marca el l&iacute;mite de los campos en el fichero
     */
    public void setFieldLimit(String sFieldLimit) {
        this.sFieldLimit=sFieldLimit;
    }
    public String getFieldLimit()
    { return this.sFieldLimit; }

    /**
     *
     * @param sLineLimit Caracter que marca el final de un registro en el fichero
     */
    public void setLineLimit(String sLineLimit) {
        this.sLineLimit=sLineLimit;
    }
    public String getLineLimit()
    { return this.sLineLimit; }


    /**
     *
     * @param sSQL <i>Query</i> a ejecutar para mandar los datos de la tabla a
     * un fichero CSV.<br/>Tiene que tener los <i>string</i> <code>#field#</code>,
     * <code>#line#</code> <code>#outfile#</code> y <code>#db#</code> en los
     * lugares de la <i>query</i> que corresponda.
     */
    public void setSQL(String sSQL) throws Exception {
        setSQL(sSQL,getFieldLimit(),getLineLimit());
    }

    /**
     *
     * @param sSQL <i>Query</i> a ejecutar para mandar los datos de la tabla a
     * un fichero CSV.<br/>Tiene que tener los <i>string</i> <code>#field#</code>,
     * <code>#line#</code> <code>#outfile#</code> y <code>#db#</code> en los
     * lugares de la <i>query</i> que corresponda.
     *
     * @param sFieldLimit
     * @param sLineLimit
     */
    public void setSQL(String sSQL, String sFieldLimit, String sLineLimit) throws Exception{
        try {
            RE re=new RE("#field#");
            String s1=re.subst(sSQL,"'"+sFieldLimit+"'",RE.REPLACE_ALL);
            re=new RE("#line#");
            this.sSQL=re.subst(s1,"\""+sLineLimit+"\"",RE.REPLACE_ALL);
        }
        catch(Exception e) {
            throw e;
        }
    }
    public String getSQL()
    { return this.sSQL; }


    /**
     *
     * @param lTables <i>Array</i> con los nombres de las tablas que se van a
     * guardar en ficheros CSV
     */
    public void setTables(Object []lTables) {
        this.lTables=lTables;
    }
    public Object[] getTables()
    { return this.lTables; }
    public String getTable(int i)
    { return this.lTables[i].toString(); }

//------------

    /**
     * <p>Exporta las tablas indicadas a ficheros CSV.</p>
     * <p>La conexi&oacute;n a la BB.DD. se obtiene del objeto
     * <code>com.emesa.bbdd.DBManager</code> que mediante su m&eacute;todo
     * <code>getInstance()</code> devuelve un <code>net.seh.bbdd.AbstractDBManager</code>
     * con el que realizar las operaciones de BB.DD.
     *
     * @return N&uacute;mero de ficheros exportados
     */
    public int exportToCSV() {
        int totFiles=0;

        AbstractDBManager dbm = null;
        try {
            dbm=DBManager.getInstance();
        }
        catch(Exception e) {
            logger.error("[exportToCSV] Error: "+e);
        }

        Vector vResult=new Vector();
        RE re=null;
        String sSQL1;
        File f;
        File fTmp;
        // Para cada tabla...
        for(int i=0;i<getTables().length; i++) {
            try {
                fTmp = new File(getDestDir()+"/_"+getTable(i)+".csv.tmp");
                if(fTmp.exists())
                    fTmp.delete();

                re=new RE("#outfile#");
                sSQL1=re.subst(getSQL(),"'"+fTmp.getAbsolutePath().replace('\\','/')+"'",RE.REPLACE_ALL);
                re=new RE("#db#");
                sSQL1=re.subst(sSQL1,getTable(i),RE.REPLACE_ALL);

                // Borramos el fichero temporal...
                if(fTmp.exists()) {
                    fTmp.delete();
                }

                try {
                    vResult=dbm.executeQuery(sSQL1);
                }
                catch(Exception e) {
                    // Si contiene este error, ha realizado la ejecuci&oacute;n
                    if(e.getMessage().indexOf("UPDATE")!=-1) {
                        logger.warn(e);
                    }
                    else {
                        logger.error("Error: "+e);
                        continue;
                    }
                }

                f = new File(getDestDir()+"/"+getTable(i)+".csv");
                if(f.exists())
                    f.delete();

                fTmp.renameTo(f);

                totFiles++;
            }
            catch(Exception e) {
                logger.error("Error: "+e);
            }
        }
        dbm.close();

        return totFiles;
    }


    /** Para pruebas */
    public static void main(String [] args) {
        net.seh.bbdd.AbstractDBManager.setDebug(true);
        CSVExport o = null;
        try {
            o=new CSVExport();
        }
        catch(Exception e) {
            logger.error("[main] "+e.toString());
        }
        o.setTables(args);
        o.setDestDir("c:\\temp");
        logger.info(">> "+o.exportToCSV());
    }
}