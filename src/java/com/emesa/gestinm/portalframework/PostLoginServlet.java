package com.emesa.gestinm.portalframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emesa.gestinm.dao.UserProfileDAO;

/**
 */
public class PostLoginServlet extends HttpServlet
{
    /** Nombre con el que guardaremos en sesi&oacute;n el perfil del usuario */
    private final static String UID=com.emesa.Configuration.getProperty("gestinm.profile_id");
    /** */
    static Properties p = null;

    static {
        loadProperties();
    }

    /**
     * Inicializa las propiedades de acceso para el portal seg&uacute;n la
     * informaci&ioacute;n del fichero <code>access.properties</code>
     */
    public static void loadProperties() {
        p=new Properties();
        try {
            p.load(new FileInputStream(com.emesa.Configuration.getProperty("folder.properties")+"/access.properties"));
        }
        catch(Exception e) {
            System.err.println("[PostLoginServlet][loadProperties] Error: "+e);
        }
    }

    /**
     * Inicializaci&oacute;n del servlet
     */
    public void init() throws ServletException
    {
    }

    /**
     * Comprobamos que el usuario es un usuario v&aacute;lido y guardamos su
     * perfil.
     *
     * @param request
     * @param response
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException
    {
        HttpSession session = request.getSession(true);

        if(session.getAttribute(UID)==null) {
            // Debemos llegar aquí tras comprobar que el login es válido.
            String sUser = request.getRemoteUser(); // Usuario logado

            // Antes de guardar el perfil del usuario en sesión, comprobamos que
            // sea un usuario con permisos de acceso
            if(accessGranted(request)) {
                log("[PostLoginServlet] ============================================================");
                log("[PostLoginServlet] Usuario con permisos de acceso:");
                log("[PostLoginServlet]   - Usuario: "+request.getRemoteUser());
                log("[PostLoginServlet]   - Ordenador: "+request.getRemoteHost()+" ("+request.getRemoteAddr()+")");
                log("[PostLoginServlet] ============================================================");

                System.out.println("[PostLoginServlet] ============================================================");
                System.out.println("[PostLoginServlet] Usuario con permisos de acceso:");
                System.out.println("[PostLoginServlet]   - Usuario: "+request.getRemoteUser());
                System.out.println("[PostLoginServlet]   - Ordenador: "+request.getRemoteHost()+" ("+request.getRemoteAddr()+")");
                System.out.println("[PostLoginServlet] ============================================================");

                // Rellenamos el perfil de usuario y lo guardamos en sesión
                UserProfileDAO oProfileDAO=new UserProfileDAO();

                session.setAttribute(UID,oProfileDAO.load(sUser));
            }
            else {
                log("[PostLoginServlet] ============================================================");
                log("[PostLoginServlet] ** ACCESO DENEGADO **:");
                log("[PostLoginServlet]   - Usuario: "+request.getRemoteUser());
                log("[PostLoginServlet]   - Ordenador: "+request.getRemoteHost()+" ("+request.getRemoteAddr()+")");
                log("[PostLoginServlet] ============================================================");

                System.out.println("[PostLoginServlet] ============================================================");
                System.out.println("[PostLoginServlet] ** ACCESO DENEGADO **:");
                System.out.println("[PostLoginServlet]   - Usuario: "+request.getRemoteUser());
                System.out.println("[PostLoginServlet]   - Ordenador: "+request.getRemoteHost()+" ("+request.getRemoteAddr()+")");
                System.out.println("[PostLoginServlet] ============================================================");

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error/acceso_no_permitido.jsp");
                dispatcher.forward(request,response);
            }
        }
    }

    /**
     * Comprobamos que el usuario es un usuario v&aacute;lido y guardamos su
     * perfil.
     *
     * @param request
     * @param response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException
    {
        doGet(request,response);
    }


    /**
     * Comprobamos que el usuario tenga permisos de acceso al portal
     *
     * @param request
     * @return <code>true</code> si la IP tiene el acceso permitido o el usuario
     * es Administrador, y <code>false</code> en caso contrario.
     */
    private boolean accessGranted(HttpServletRequest request) {
        String sUser = request.getRemoteUser(); // Usuario logado

        // Si el usuario no se ha logado...
        if(sUser==null) {
            return false;
        }
        else {
            // Rellenamos el perfil de usuario
            UserProfile oProfile=(new UserProfileDAO()).load(sUser);

            // Roles...
            StringTokenizer st=new StringTokenizer(p.getProperty("access.role"),",",false);
            while(st.hasMoreTokens()) {
                if(st.nextToken().trim().toUpperCase().equals(oProfile.getTipoUsuario().toUpperCase()))
                    return true;
            }

            // IPs...
            st=new StringTokenizer(p.getProperty("access.ip"),",",false);
            while(st.hasMoreTokens()) {
                if(st.nextToken().trim().equals(request.getRemoteAddr()))
                    return true;
            }

            // Nombre de máquina...
            st=new StringTokenizer(p.getProperty("access.host"),",",false);
            while(st.hasMoreTokens()) {
                if(st.nextToken().trim().equals(request.getRemoteHost()))
                    return true;
            }

            return false;
        }
    }
}
