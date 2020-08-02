<%@page import="com.emesa.bbdd.tableform.*,java.util.Vector"%>
<jsp:useBean id="oTableForm" class="com.emesa.bbdd.TableForm" scope="session" />
<%-- Sus motivos tendrá, pero no coge 'table' --%>
<jsp:setProperty name="oTableForm" property="*"/>
<%
String sTable=request.getParameter("table");
// Como no coge el atributo 'table', pues...
if(sTable!=null && !sTable.trim().equals("")) {
    oTableForm.setTable(sTable);
}
%>
<h4><%=oTableForm.getDB()!=null?oTableForm.getDB().getName():"NULL"%> <span class="ok">&raquo;</span> <%=oTableForm.getTable()!=null?oTableForm.getTable().getName():"NULL"%></h4>
<%
// Los campos de la tabla
try {
    oTableForm.getTable().loadFields();
%>
<form method="post" action="index.jsp">
<input type="hidden" name="tab" value="adm"/>
<input type="hidden" name="acc" value="inf2"/>
<input type="hidden" name="acc2" value="select"/>
    <table align="center" class="bordeRojo">
    <tr><th align="center"><b>Nombre</b></th>
    <th align="center"><b>Mostrar</b></th><th align="center"><b>Operador</b></th><th align="center"><b>Valor</b></th>
    <th align="center"><b>Condición</b></th>
    <th align="center"><b>Orden</b></th>
    <input type="hidden" name="table" value="<%=sTable%>">
            </tr><%
            Vector vFields=oTableForm.getTable().getFields();
            System.out.println(vFields);
            DBField f=null;
            for (int i=0; vFields!=null && i<vFields.size(); i++) {
                f=(DBField)vFields.elementAt(i);
                if(f!=null) {
                %><tr><td<%=i%2!=0?" bgcolor=\"#E8D3C1\"":""%>><%=f.getName()%></td>
                <td align="center"><input type="checkbox" name="_show<%=f.getName()%>" checked="true"/></td>
                <td align="center">
	                <jsp:include page="/inc/comboOperador.jsp">
	                 <jsp:param name="oper" value="<%=f.getName()%>"/>
	    		</jsp:include>
                </td>
                <td align="center"><input type="text" name="_value<%=f.getName()%>"/></td>
                <td align="center">
	                Y<input type="radio" name="_condY<%=f.getName()%>" />
	                &Oacute;<input type="radio" name="_condO<%=f.getName()%>" />
	        </td>
                <td align="center">
                	<jsp:include page="/inc/comboOrden.jsp">
                	<jsp:param name="orden" value="<%=f.getName()%>"/>
	    		</jsp:include>
                </td>
                </tr><%}
            }
            %>
            <tr class="marca"><td colspan="6" align="right"><input type="submit" value="Enviar" class="boton"/> </td></tr>
    </table>
</form><%
                }
catch(Exception e) {
    %><p class="err">Error al obtener los campos de la tabla <%=oTableForm.getTable()%>: <%=e%></p><%
}
%>