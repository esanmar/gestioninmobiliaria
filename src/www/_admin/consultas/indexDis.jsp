<%@page import="com.emesa.bbdd.tableform.*"%>
<jsp:useBean id="oTableForm" class="com.emesa.bbdd.TableForm" scope="session" />
<jsp:setProperty name="oTableForm" property="*" /><%

String sDriver=request.getParameter("driver");
String sURL=request.getParameter("URL");
String sUser=request.getParameter("user");
String sPassword=request.getParameter("password");

// Cargamos las BB.DD.
if (sDriver!=null)
	oTableForm.setDriver(sDriver);
if (sURL!=null)
	oTableForm.setURL(sURL);
if (sUser!=null)
	oTableForm.setUser(sUser);
if (sPassword!=null)
	oTableForm.setPassword(sPassword);
try {
    oTableForm.loadCatalogs();
}
catch(Exception e) {
    out.println("<p class=\"err\">Error al recuperar las BB.DD. de la conexi&oacute;n: "+e+"</p>");
    }

%><form method="post" action="index.jsp?tab=inf&acc=dis" name="fmDB">
    <table border="0">
    <tr>
        <td colspan="2"><b>Seleccione una base de datos y una tabla</b>:</td>
        <td></td>
    </tr>
    <tr><td colspan="2">&nbsp;</td></tr>
    <tr>
        <td>Bases de datos: </td>
        <td>
            <select name="db" onchange="javascript:document.fmDB.submit();">
            <option value="<%=(oTableForm.getDB()==null || "".equals(oTableForm.getDB().getName()))?" selected=\"true\"":""%>">-- Elige BB.DD. --</option><%

            DB db=null;
            for(int i=0; i<oTableForm.getCatalogs().size(); i++) {
                db=(DB)oTableForm.getCatalogs().elementAt(i);
                %><option value="<%=db.getName()%>"<%=(db.equals(oTableForm.getDB()))?" selected=\"true\"":""%>"><%=db.getName()%></option><%
            }
            %>
            </select>
        </td>
    </tr>
</form><%

 if(oTableForm.getDB()!=null) {
%><form action="index.jsp?tab=inf&acc=show" method="post" name="fmTables">
<table border="0">
    <tr>
        <td>Tablas de <b><%=oTableForm.getDB().getName()%></b>: </td>
        <td>
            <select name="table" onchange="javascript:document.fmTables.submit();">
            <option value="">-- Elige una tabla --</option><%

            DBTable table=null;
            for(int i=0; i<oTableForm.getDB().getTables().size(); i++) {
                table=(DBTable)oTableForm.getDB().getTables().elementAt(i);
                %><option value="<%=table.getName()%>"><%=table.getName()%></option><%
            }
            %></select>
        </td>
    </tr>
    </table>
</form><%
}%>
