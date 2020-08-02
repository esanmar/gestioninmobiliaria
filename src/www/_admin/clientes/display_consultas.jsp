<%@page import="java.text.*,java.util.*,com.emesa.gestinm.dao.FEL_CONSULTA"%><%@taglib uri="/tags/display" prefix="display" %><%

FEL_CONSULTA ofel_consultas = new FEL_CONSULTA();

String sDel=request.getParameter("del");

if(sDel!=null && !sDel.trim().equals("")) {
    try {
        ofel_consultas.delete(Integer.parseInt(sDel));
        %><br/>&nbsp;&nbsp;<span class="nota">Eliminado la consulta <b><%=sDel%></b>.<br/><%
    }
    catch(Exception e) {
        %><br/>&nbsp;&nbsp;<span class="err">Error al eliminar la consulta <b><%=sDel%></b>: <%=e%><br/><%
    }
}

Vector vConsulta = new Vector();
vConsulta=ofel_consultas.getConsultas(ofel_cliente.getID_CLIENTE());
String sSQL="";
%>

<script language="javascript">
<!--
function del(id) {
    document.fmDest.del.value=id;
    document.fmDest.submit();
}

//-->
</script>


<h5>Consultas del Cliente</h5>
<form method="post" action="index.jsp" name="fmDest">
<input type="hidden" name="tab" value="cli"/>
<input type="hidden" name="codcli" value="<%=ofel_cliente.getID_CLIENTE()%>"/>
<input type="hidden" name="acc" value=""/>
<input type="hidden" name="del" value="-1"/>
<table>
<%

for (int i=0; i<vConsulta.size(); i++)
{	
	FEL_CONSULTA o = new FEL_CONSULTA();
	o=(FEL_CONSULTA)vConsulta.elementAt(i);
	sSQL="";
	sSQL=o.getCONSULTA();


%>

<jsp:useBean id="consulta" class="com.emesa.dao.CargaConsulta" scope="session" />

<%

Vector vSelect = new Vector();
vSelect=consulta.loadFromDB(sSQL.toString());
%>


<tr>
<td width="90%"><a href="/gestinm/_admin/index.jsp?tab=inf&acc=inmSel&codCon=<%=o.getID_CONSULTA()%>"><%=o.getNOMBRE()%></a>
<td align="center"><a href="javascript:del(<%=o.getID_CONSULTA()%>);"><img src="/gestinm/images/x.gif" border="0" alt="Eliminar <%=o.getID_CONSULTA()%>"/></a></td>
</td>
</tr>

<%
}
%>

</table>