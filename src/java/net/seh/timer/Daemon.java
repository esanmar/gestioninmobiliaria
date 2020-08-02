package net.seh.timer;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.xml.bind.*;
import java.io.FileInputStream;

/**
 * Clase <i>demonio</i> que ejecuta una serie de tareas de forma peri&oacute;dica.
 */
public class Daemon extends java.util.Timer
{
    /** Para d&iacute;as sin hora */
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd'/'MM'/'yyyy");
    /** Para d&iacute;as CON hora*/
    private static SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd'/'MM'/'yyyy HH':'mm");

    /**
     * Constructor por defecto
     */
    public Daemon()
    {
        super(true);
        loadConfigurationFile("daemon.xml");
    }


    /**
     * Cargamos el fichero con la informaci&oacute;n de configuraci&oacute;n
     */
    public void loadConfigurationFile(String sFileName)
    {
        try {
            Dispatcher d = Tasks.newDispatcher();
            Tasks oTasks = (Tasks)d.unmarshal(new FileInputStream(com.emesa.Configuration.getProperty("folder.xml")+"/"+sFileName));

            // Cargamos tb la Hash
            List lTasks = oTasks.getTask();
            Task oTask;
            DaemonTask dt;
            Date oDate;
            long period;
            for(int i=0; i<lTasks.size(); i++) {
                oTask=(Task)lTasks.get(i);
                // Construimos el DaemonTask
                dt = new DaemonTask(oTask.getTaskClass(),oTask.getTaskMethod());
                try {
                    oDate = sdfDateTime.parse(oTask.getStart());
                }
                catch(Exception e)
                {
                    oDate = sdf.parse(oTask.getStart());
                }
                System.out.println("[Daemon] La tarea "+oTask.getTaskClass()+"."+oTask.getTaskMethod()+"() empezará el <"+sdfDateTime.format(oDate)+">-<"+oTask.getPeriod()+" seg.>");
                // Sin periodo
                if(oTask.getPeriod()==null || oTask.getPeriod().trim().equals("")) {
                    this.schedule(dt,oDate);
                }
                else {
                    this.schedule(dt,oDate,Long.parseLong(oTask.getPeriod())*1000);
                }
            }
        }
        catch(Exception e) {
            System.err.println("[Daemon][loadConfigurationFile] Error: "+e);
        }
    }

    public static void main(String [] args) {
        new Daemon();
        while(true){
            try {
                Thread.sleep(Long.MAX_VALUE);
            }
            catch(Exception e) {}
        }
    }
}
