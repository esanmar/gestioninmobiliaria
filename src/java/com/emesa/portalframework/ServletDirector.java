package com.emesa.portalframework;

import java.io.IOException;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

/**
 * Este <i>servlet</i> se encargar&aacute; de controlar el acceso a las distintas
 * partes del portal a partir de los permisos definidos.
 *
 * @version 1.0
 * @author emesa s.l.
 * @since 30/06/2003
 */
public class ServletDirector extends HttpServlet
{
    /**
     * Inicializaci&oacute;n del servlet
     */
    public void init() throws ServletException
    {
        //sRedirect = getServletConfig().getInitParameter("redirect");
    }


    /**
     *
     * @param request
     * @param response
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        doPost(request, response);
    }


    /**
     * <p>Recoge los parámetros de sessi&oacute;n y los comprueba con la m&aacute;scara
     * de permisos del usuario logado.</p> Si el usuario tiene permisos para
     * realizar la acci&oacute;n solicitada, se le redirecciona adecuadamente,
     * en caso contrario se le manda a una p&aacute;gina de error.
     *
     * @param request
     * @param response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        HttpSession session = request.getSession(true);

        // Recogemos el usuario logado y si no hay nadie logado, asignamos el perfil
        // del usuario anónimo y lo guardamos en sessión
        Profile p = (Profile)session.getAttribute("u_profile");

        if(p==null) {
            p=new Profile();
        }

        log("[doPost] Perfil: "+p);

        // Recogemos las variables de portal (tab) y acción (acc)
        String sTab = request.getParameter("tab");
        if(sTab==null)
            sTab="";
        String sAcc = request.getParameter("acc");
        if(sAcc==null)
            sAcc="";

        log("[doPost] tab="+sTab+"&acc="+sAcc);


        // Comprobamos ahora que el usuario tiene permisos para acceder a ese 'tab'
        // y hacemos un 'include' del controlador indicado.
        if(!sTab.equals("")) {
            if(! ((PermissionMask)p.get("permisos")).check(Integer.parseInt(sTab))) {
                sTab="noPerm";
            }
        }

        log("[doPost] Incluimos: /controllers/_"+sTab+"Controller.jsp" );

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/controllers/_"+sTab+"Controller.jsp");
        dispatcher.include(request,response);
    }
}
