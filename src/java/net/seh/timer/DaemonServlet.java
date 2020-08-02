package net.seh.timer;

import javax.servlet.http.*;

/**
 * Servlet que instancia el <i>demonio</i> que ejecuta una serie de tareas de forma peri&oacute;dica.
 *
 * @see net.seh.timer.Daemon
 * @author sasa eh - 2003/02/11
 * @version 1.0
 */
public class DaemonServlet extends javax.servlet.http.HttpServlet
{
	/** Demonio */
	private static Daemon sitri;


	/**
	 * Inicialización del demonio
	 */
	public void init() throws javax.servlet.ServletException
	{
		log("[DaemonServlet][init] Cargando el demonio...");
		sitri = new Daemon();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws java.io.IOException, javax.servlet.ServletException
	{
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws java.io.IOException, javax.servlet.ServletException
	{
	}

	/**
	 * Recupera el demonio
	 *
	 * @return Demonio
	 */
	public Daemon getDaemon()
	{
		return sitri;
	}	
}

