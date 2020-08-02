<%@page import="java.io.*,java.util.*,com.emesa.Configuration"%>
<table cellpadding="2"><%

String sHeader=" (c) emesa s.l. - Permisos de acceso. El orden de comprobación es Rol --> IP --> Host";
Properties p = new Properties();
Properties p2 = new Properties();
try {
    p.load(new FileInputStream(Configuration.getProperty("folder.properties")+"/access.properties"));
    Enumeration enum=request.getParameterNames();
    Object o=null;
    while(enum.hasMoreElements()) {
        o=enum.nextElement();
        if(o!=null && !o.toString().equals("tab") && !o.toString().equals("acc")) {
            p2.setProperty(o.toString(),request.getParameter(o.toString()));
        }
    }
    p2.store(new FileOutputStream(Configuration.getProperty("folder.properties")+"/access.properties"),sHeader);

    %><tr><td>Actualizando los permisos...</td></tr>
    <tr><td><ul><li>Fichero <b><code>access.properties</code></b> modificado con &eacute;xito</li>
    <li>Recargando los permisos de acceso... <%
    try {
        com.emesa.gestinm.portalframework.PostLoginServlet.loadProperties();
        %><b>ok</b><%
    }
    catch(Exception e) {
        %><span class="err"><%=e%></span><%
    }%></li></ul><%
} catch(Exception e) {
    %><tr><td class="err">Error: <%=e%></td></tr><%
}

%></table>