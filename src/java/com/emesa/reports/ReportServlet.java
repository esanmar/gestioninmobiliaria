package com.emesa.reports;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emesa.reports.xml.Informe;


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
public class ReportServlet extends HttpServlet
{
	/** Redirecci&oacute;n por defecto */
	private String sRedirect = "";


	/**
	 * Inicializaci&oacute;n del servlet
	 */
	public void init() throws ServletException
	{
		sRedirect = getServletConfig().getInitParameter("redirect");
	}


	/**
	 * Recogemos el identificador del informe/b&uacute;squeda a realizar,
	 * y ponemos la informaci&oacute;n relativa a ese informe en <code>pageContext</code>
	 *
	 * @param request
	 * @param response
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		String sReportLoader=request.getParameter("rl");
		if(sReportLoader==null || sReportLoader.trim().equals(""))
			sReportLoader=""+Reports.NORMAL;
		String sIdInforme=request.getParameter("report_id");
		// Con este report_id, seleccionamos el informe y guardamos en request como atributos:
		//	- rl: ReportLoader
		//	- report_id: Identificador del informe
		//	- search_report: El objeto Informe asociado al id
		//	- search_params: El objeto List que representa la lista de parámetros de search_report
		if(sIdInforme!=null) {
			Informe oInforme = Reports.getReport(Integer.parseInt(sReportLoader),sIdInforme);
			request.setAttribute("rl",sReportLoader);
			request.setAttribute("report_id",sIdInforme);
			request.setAttribute("search_report",Reports.getReport(Integer.parseInt(sReportLoader),sIdInforme));
			request.setAttribute("search_params",oInforme.getQuery().getQueryParam());

			log("[doGet] Asignados 'rl', 'report_id', 'search_report' y 'search_params' para "+sIdInforme);
		}

		String sRedirectParam = request.getParameter("redirect");
		if(sRedirectParam==null || sRedirectParam.trim().equals(""))
			sRedirectParam = sRedirect;
		log("[doGet] Forward a "+sRedirectParam);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sRedirectParam);
		dispatcher.forward(request,response);
	}


	/**
	 * Redirecciona a <code>doGet(HttpServletRequest, HttpServletResponse)</code>
	 *
	 * @param request
	 * @param response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		doGet(request,response);
	}

}
