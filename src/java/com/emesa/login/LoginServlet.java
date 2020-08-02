package com.emesa.login;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.seh.bbdd.AbstractDBManager;

import org.apache.catalina.realm.RealmBase;
import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;

/**
 * Servlet de <i>login</i> utilizando los parámetros indicados en su
 * configuraci&oacute;n en <code>web.xml</code>
 *
 * @author emesa s.l.
 * @version 1.0
 * @since 2003/01/31
 */
public class LoginServlet extends HttpServlet
{
	/** Logger */
	static Logger logger = Logger.getLogger(LoginServlet.class);
	/** Tabla de <i>login</i> */
	private static String sLoginTable = "";
	/** Campo en esa tabla que representa al usuario */
	private static String sUserField = "";
	/** Campo en esa tabla que representa la clave */
	private static String sPasswordField = "";
	/** Campo en esa tabla que representa el tipo de usuario y que enlace con la tabla de roles */
	private static String sRoleField = "";
	/** Tabla de roles */
	private static String sRoleTable = "";

	/** Indica si la clave es para el rol o bien para el usuario, por defecto la clave es de usuario */
	private static boolean isRolePassword = false;

	/** Tipo de codificaci&oacute;n utilizada para encriptar las claves */
	private static String sDigest= "MD5";
	/** Direcci&oacute;n para redirigir el <i>response</i> */
	private String sRedirect = "";


	/**
	 * Inicializaci&oacute;n del servlet
	 */
	public void init() throws ServletException
	{
		sLoginTable = getServletConfig().getInitParameter("login_table");
		sUserField = getServletConfig().getInitParameter("user_field");
		sPasswordField = getServletConfig().getInitParameter("password_field");
		sRoleField = getServletConfig().getInitParameter("role_field");
		sRoleTable = getServletConfig().getInitParameter("role_table");
		sDigest = getServletConfig().getInitParameter("login_digest");
		isRolePassword = new Boolean(getServletConfig().getInitParameter("role_password")).booleanValue();
		sRedirect = getServletConfig().getInitParameter("redirect");
	}


	/**
	 * Recogemos el usuario/clave y si hay correspondencia, se guarda en sesi&oacute;n <code>logged=<i>login_user</i></code>
	 *
	 * @param request
	 * @param response
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		log("[LoginServlet][doGet] Acceso por get no permitido");
	}


	/**
	 * Recogemos el usuario/clave y si hay correspondencia, se guarda en sesi&oacute;n <code>logged=<i>login_user</i></code>
	 *
	 * @param request
	 * @param response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		String sUser=request.getParameter("msa_user");
		String sRole=request.getParameter("msa_role");
		String sPassword=request.getParameter("msa_password");
		String sRedirectParam=request.getParameter("msa_redirect");
		if(sRedirectParam==null || sRedirectParam.trim().equals("") )
			sRedirectParam = sRedirect;

		String sQuery="";
		Vector vParams=new Vector();
		log("[LoginServlet][doPost] isRolePassword: "+isRolePassword);
		if(!isRolePassword) {
			sQuery="select U."+sUserField+", U."+sPasswordField+", R."+sRoleField+" from "+sLoginTable+" U,"+sRoleTable+" R where U."+sUserField+"=? and U."+sPasswordField+"=? and R."+sRoleField+"=U."+sRoleField;

			vParams.add(sUser);
			vParams.add(RealmBase.Digest(sPassword,sDigest));
		}
		else {
			sQuery="select U."+sUserField+",R."+sPasswordField+", R."+sRoleField+" from "+sRoleTable+" R,"+sLoginTable+" U where R."+sRoleField+"=? and R."+sPasswordField+"=? and U."+sUserField+"=? and R."+sRoleField+"=U."+sRoleField;

			vParams.add(sRole);
			vParams.add(RealmBase.Digest(sPassword,sDigest));
			vParams.add(sUser);
		}

		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado=null;
		try {
			vRtado=dbm.executeQuery(sQuery,vParams);
		}
		catch(Exception e) {
			log("[LoginServlet][doPost] Error al chequear usuario/clave: "+e);
		}
		if(vRtado!=null && !vRtado.isEmpty()) {
			log("[LoginServlet][doPost] Guardamos en sesión: "+sUser+"/"+(String)((Vector)vRtado.firstElement()).elementAt(2));
			logger.info("Se ha logado el usuario "+sUser+" con rol "+(String)((Vector)vRtado.firstElement()).elementAt(2)+" desde la IP "+request.getRemoteAddr()+"("+request.getRemoteHost()+")");
			HttpSession session = request.getSession();
			session.setAttribute("logged_user",sUser);
			session.setAttribute("logged_role", (String)((Vector)vRtado.firstElement()).elementAt(2));
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sRedirectParam);
		dispatcher.forward(request,response);
	}
}
