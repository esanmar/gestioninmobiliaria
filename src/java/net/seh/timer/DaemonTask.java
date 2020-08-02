package net.seh.timer;

import java.util.*;
import java.lang.reflect.Method;


/**
 * 
 */
public class DaemonTask extends TimerTask
{
	/** Nombre de la clase que se instanciar&aacute; */
	private String sClassName;

	/** Clase indicada por sClassName */
	private Class oClass;

	/** Objeto de la clase indicada por sClassName */
	private Object o;

	/** Nombre del m&eacute;todo en la clase que se ejecutar&aacute; */
	private String sMethodName;	


	/**
	 * Constructor
	 */
	public DaemonTask(String sClassName, String sMethodName)
	{
		setClass(sClassName);
		setMethodName(sMethodName);
		//newClass(sClassName);
	}


	/**
	 * Asigna valor al par&aacute;metro e instancia la clase
	 *
	 * @param s Nombre de la clase a instanciar
	 */
	public void setClass(String s)	{
		this.sClassName = s;
		try {
			oClass = Class.forName(sClassName);

			// Más vale que tenga un constructor público y sin argumentos...
			Class []aParams=new Class[]{};

			o = (oClass.getConstructor(aParams)).newInstance(null);
		}
		catch(Exception e) {
			System.err.println("[DaemonTask][setClass] Error: "+e);
		}
	}


	/**
	 * 
	 */
	public void setMethodName(String s)	{
		this.sMethodName = s;
	}


	/**
	 * Interfaz <code>Runnable</code> que llamar&aacute; al m&eacute;todo de la clase indicada
	 */
	public void run()
	{
		Class [] aParams = new Class[]{};
		try {
	  	Method m = oClass.getMethod(sMethodName, aParams);
	  	m.invoke(o,null);
	  }
	  catch (Exception e) {
	  	System.err.println("[DaemonTask][run] Error: "+e);
	  }
	}

	public static void main(String []args) {
		DaemonTask dt = new DaemonTask("net.seh.timer.Prueba","prueba");
		System.out.println("#### Invocamos net.seh.timer.Prueba,prueba");
		dt.run();
	}
}
