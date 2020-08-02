package com.emesa.gestinm.misc;

import java.io.File;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.taskdefs.Zip;

import com.emesa.Configuration;

/**
 * Clase encargada de generar los CSV de las tablas de la base de datos marcadas
 * para hacer <i>backup</i>, comprimirlas en un zip y copiar ese zip a un directorio
 * accesible vía FTP.
 */
public class DBStatusBackup
{
    /** Logger */
    static Logger logger = Logger.getLogger(DBStatusBackup.class);

    /** Tablas para hacer 'back-up' */
    Vector vTables=null;

    /**
     * Constructor
     */
    public DBStatusBackup() {
    }


    /**
     * Realiza el proceso de <i>backup</i> que consiste en<br/>
     * <ol>
     *  <li>Generar un fichero <code>csv</code> por cada tabla indicada</li>
     *  <li>Crear un fichero ZIP con esos <code>csv</code> en un directorio accesible
     *  por <code>ftp</code></li>
     * </ol>
     */
    public void run() throws Exception {
        vTables=new Vector();

        StringTokenizer st=new StringTokenizer(Configuration.getProperty("gestinm.backup_tables"),",",false);
        while(st.hasMoreElements()) {
            vTables.add(st.nextToken().toString().trim());
        }

        CSVExport csv=null;
        try {
            logger.debug("[run] CVSExport de "+vTables);
            csv=new CSVExport(Configuration.getProperty("gestinm.csv.dest"),
                                    vTables.toArray());
        }
        catch(Exception e) {
            logger.error("Error: "+e);
            throw e;
        }
        csv.exportToCSV();

        logger.info("ant zip");
        //-- ZIP
        final class AntZip extends Zip {
                public AntZip() {
                project = new Project();
                project.init();
                taskType = "zip";
                taskName = "zip";
                target = new Target();
            }
        }

        AntZip zipTask=new AntZip();

        logger.debug("[run] Hacemos ZIP del contenido de "+Configuration.getProperty("gestinm.csv.dest")+" al zip "+Configuration.getProperty("gestinm.zip.dest")+"/gestinm.zip");
        zipTask.setDestFile(new File(Configuration.getProperty("gestinm.zip.dest")+"/gestinm.zip"));
        zipTask.setBasedir(new File(Configuration.getProperty("gestinm.csv.dest")));
        zipTask.setUpdate(true);
        try {
            zipTask.execute();
        }
        catch(Exception e) {
            logger.error("[run] Error: "+e);
        }
        //-- eoZip
    }


    /**
     * Para pruebas
     */
    public static void main(String[] args) {
        DBStatusBackup bu=new DBStatusBackup();
        try {
            bu.run();
        }
        catch(Exception e) {
            logger.error(e);
        }
    }
}