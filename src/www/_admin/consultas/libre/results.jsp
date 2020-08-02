<%@page import="com.emesa.dao.Informe"%>
<%
String sQuery=request.getParameter("query");
if(sQuery!=null && !sQuery.trim().toUpperCase().startsWith("SELECT")) {
    %><p class="err">&nbsp;&nbsp;Solo se permiten realizar <i>queries</i> de consulta.<br/><br/></p><%
}
else {
    if(sQuery!=null && !sQuery.trim().equals("")) {
        Informe inf=new Informe();
        inf.setQuery(sQuery);

        boolean bError=false;

        try {
            session.setAttribute("inf_header",inf.getHeader());
            session.setAttribute("inf_rtado",inf.executeDirect());
            session.setAttribute("inf_nombre","Query");
            session.setAttribute("inf_descripcion","");
        }
        catch(Exception e) {
            bError=true;
            %><p class="err">&nbsp;Error al ejecutar la <i>query</i> '<code><%=sQuery%></code>':<br/>&nbsp;&nbsp;&nbsp;<%=e%></p><br/><%
        }
        if(!bError) {
        %><jsp:include page="/_admin/consultas/predef/showResults.jsp"/><%
        }
    } else {
    %><form method="post" action="index.jsp">
    <input type="text" name="query"/> <input type="submit" class="boton" value=" &gt;&gt; "/>
    </form><%
    }
}%>