package com.emesa.reports;

import java.util.Iterator;

import com.emesa.reports.xml.Informe;

/**
 * Clase de acceso a los informes de administraci&oacute;n y de usuario
 *
 * @see com.educarioja.ReportLoader
 * @see com.educarioja.xml.Informe
 */
public class Reports
{
	/** &Iacute;ndice del array para los informes de administraci&oacute;n */
	public static int ADMIN=1;
	/** &Iacute;ndice del array para los informes normales */ 
	public static int NORMAL=0;

	/** Array con los informes */
	private static ReportLoader []aReports = new ReportLoader[]{new ReportLoader("informes.xml"),new ReportLoader("admin_informes.xml")};


	/**
	 * Constructor privado para que no se tenga acceso desde fuera
	 */
	private Reports()
	{}


	/**
	 * Instancia del objeto <code>ReportLoader</code> solicitado
	 *
	 * @param nIndice
	 * @return ReportLoader solicitado
	 */
	public static ReportLoader getInstance(int nIndice)
	{
		return aReports[nIndice];
	}


	/**
	 * Devuleve el <code>Informe</code> solicitado
	 *
	 * @param nIndice ADMIN o NORMAL
	 * @param sInforme Nombre del informe
	 */
	public static Informe getReport(int nIndice,String sInforme)
	{
		return (aReports[nIndice]).getReport(sInforme);
	}


	/**
	 * Devuelve TODOS los informes de ADMIN o NORMAL
	 *
	 * @param nIndice ADMIN o NORMAL
	 * @return <code>Iterator</code> con los valores de la <code>HashMap</code> de informes
	 */
	public static Iterator getAllReports(int nIndice)
	{
		return aReports[nIndice].getAllReports();
	}
}