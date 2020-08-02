package com.emesa.reports;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.Dispatcher;

import com.emesa.Configuration;
import com.emesa.reports.xml.Informe;
import com.emesa.reports.xml.Informes;


/**
 * Servlet para la realizaci&oacute;n de informes/b&uacute;squedas utilizando el XML
 * <i>edr_informes.xml</i>
 *
 * @author emesa s.l.
 * @version 1.0
 * @since 2003/01/31
 * @see com.educarioja.xml.Informes
 * @see javax.xml.bind.Dispatcher
 */
public class ReportLoader
{
	/** Nodo XML que contiene el fichero <i>edr_informes.xml</i> */
	private Informes oInformes;
	/** Hash que relaciona los IDs de los informes con sus objetos */
	private HashMap hInformes;
	/** DNB_JNDI */
	private String DB_JNDI;
	/** Fichero XML que contriene los informes */
	private String sXMLFileName="";


	/**
	 * <p>Constructor.</p>
	 * <p>Cargamos el fichero de configuraci&oacute;n con los informes</p>
	 *
	 * @param sFileName Nombre del fichero XML con los informes
	 */
	public ReportLoader(String sFileName)
	{
		this.sXMLFileName = sFileName;
		loadXMLFile(sFileName);
	}


	/**
	 * <p>Constructor.</p>
	 * <p>Cargamos el fichero de configuraci&oacute;n con los informes</p>
	 *
	 * @param sFileName Nombre del fichero XML con los informes
	 * @param bAbsolutePath Indicador de si el <i>path</i> es o no absoluto
	 */
	public ReportLoader(String sFileName,boolean bAbsolutePath)
	{
		this.sXMLFileName = sFileName;
		loadXMLFile(sFileName, bAbsolutePath);
	}



	/**
	 * Carga el fichero de configuraci&oacute;n con los informes
	 */
	public void loadXMLFile()
	{
		this.loadXMLFile(this.sXMLFileName,false);
	}

	/**
	 */
	public void loadXMLFile(String sFile)
	{
		loadXMLFile(sFile,false);
	}


	/**
	 * Carga el fichero de configuraci&oacute;n con los informes
	 *
	 * @param sFileName Nombre del fichero de configuración
	 * @param bAbsolutePath Indicador de si el <i>path</i> es o no absoluto
	 */
	public void loadXMLFile(String sFileName, boolean bAbsolutePath)
	{
		try {
			Dispatcher d = Informes.newDispatcher();
			if(bAbsolutePath)
				oInformes = (Informes)d.unmarshal(new FileInputStream(sFileName));
			else
				oInformes = (Informes)d.unmarshal(new FileInputStream(Configuration.getProperty("folder.xml")+"/"+sFileName));

			this.DB_JNDI = oInformes.getDBJNDI();

			// Cargamos tb la Hash
			List lInformes = oInformes.getInforme();
			hInformes=new HashMap(lInformes.size());
			Informe oInf;
			for(int i=0; i<lInformes.size(); i++) {
				oInf=(Informe)lInformes.get(i);
				hInformes.put(oInf.getNombre(),oInf);
			}
		}
		catch(Exception e) {
			System.err.println("[ReportLoader][loadXMLFile] Error: "+e);
		}
	}


	/**
	 * Devuelve el objeto asociado a la identificación del informes
	 *
	 * @param sIdinforme Identificador del informe
	 * @return <code>Informe</code>
	 */
	public Informe getReport(String sIdInforme)
	{
		return (Informe)hInformes.get(sIdInforme);
	}


	/**
	 * Devuelve el JNDI por defecto para los informes
	 *
	 * @return El JNDI por defecto para los informes
	 */
	public String getDB_JNDI()
	{
		return this.DB_JNDI;
	}


	/**
	 * Devuelve el conjunto de los informes
	 *
	 * @return <code>Iterator</code> con los valores de la <code>HashMap</code> de informes
	 */
	public Iterator getAllReports()
	{
		return hInformes.values().iterator();
	}

} //-- eoClass