<%@page import="java.io.*,java.util.*,com.emesa.Configuration"%>
<table cellpadding="2">
<tr><td>Las siguientes entradas representan los valores del fichero con los permisos de acceso al portal. El orden de chequeo de los permisos ser&aacute;:
    <ol>
        <li><b>access.role</b>: Los roles indicados, no sufrirán restricciones de acceso.</li>
        <li><b>access.ip</b>: IPs que tienen garantizado el acceso al portal.</li>
        <li><b>access.host</b>: M&aacute;quinas que pueden acceder al portal.</li>
    </ol>
    Para indicar m&aacute;s de un valor, utilice comas (<b>,</b>) como separador.
<td>
</tr>
<tr><td align="center">
    <form method="post" action="index.jsp?tab=adm&acc=aupd">
    <table border="1" cellpadding="3px">
    <tr><th>Variable</td><th>Valor</th></tr><%

    Properties p = new Properties();
    try {
        p.load(new FileInputStream(Configuration.getProperty("folder.properties")+"/access.properties"));

        Enumeration enum=p.propertyNames();
        Object o;
        while(enum.hasMoreElements()) {
            o=enum.nextElement();

        %><tr><td><b><%=o%></b></td><td><input type="text" size="50" name="<%=o%>" value="<%=p.getProperty(o.toString())%>"/></td></tr><%
        }

        %><tr><td height="30px" valign="bottom" colspan="2" align="right"><input type="reset" class="boton" value="Reestablecer"/> <input type="submit" class="boton" value="Enviar"/></td></tr><%
    }
    catch(Exception e) {
        %><tr><td class="err">Error: <%=e%></td></tr><%
    }
    %></table>
    </form>
</td></tr></table>