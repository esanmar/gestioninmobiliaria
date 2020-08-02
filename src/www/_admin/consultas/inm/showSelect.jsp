<%@page import="java.util.Collection"%>
<%
request.setAttribute("search_collection",(Collection)session.getAttribute("inf_rtado"));
request.setAttribute("search_header",(Collection)session.getAttribute("inf_header"));

String sInforme = (String)session.getAttribute("inf_nombre");
String sDescripcion = (String)session.getAttribute("inf_descripcion");

if(sInforme==null)
    sInforme="";
if(sDescripcion!=null)
    sInforme="<b>"+sInforme+"</b>"+ (sDescripcion!=null && sDescripcion.trim().equals("")&& !sDescripcion.trim().toUpperCase().startsWith("SELECT ")?": "+sDescripcion:"");
%><script language="JavaScript">
<!--
function imprimir()
{
	window.open("/gestinm/imprimir.jsp", "VentanaHija", "resizable=no, toolbar=no, scrollbars=yes, width=800, height=500");
}
//-->
</script>
<div id="toPrintLayer">
<br/>&nbsp;&nbsp;<%=sInforme%><br/><br/>
<jsp:include page="/reports/pager_inmueble.jsp">
    <jsp:param name="sbc" value="#FFE3B5"/>
    <jsp:param name="ps" value="25"/>
    <jsp:param name="dest" value="index.jsp?tab=inf&acc=inm_rtado"/>
</jsp:include>
</div>

<form method="post" name="fmUpdate" action="index.jsp?tab=inf&acc=clicons">
<table align="center" border="0" width="80%">
<tr>
<td align="left">Nombre de Consulta</td>
<td align="left"><input type="text" name="CONSULTA"/></td>
<td align="left">Cliente</td>
<td align="left"><input type="text" name="COD_CLIENTE"/>
<a href="javascript:;" onclick="javascript:window.open('/gestinm/_admin/consultas/inm/asigna_cliente.jsp', 'Asigna_cliente', 'resizable=no,toolbar=no,scrollbars=yes,width=800,height=500');"/><img src="/gestinm/images/usuariosS.png" alt="Asignar cliente" border="0"/></a>
</td>
<td align="left">
<input type="hidden" name="SQL" value="<%=sDescripcion%>">
<input type="button" name="CONSULTA" value="Asigna Consulta" onclick="javascript:document.fmUpdate.submit();" class="boton"/></input></td>
</form>

<form method="post" name="fmPDF" action="/gestinm/toPDF" target="_blank"></form>
<form method="post" name="fmExc" action="/gestinm/_admin/consultas/excelResults.jsp" target="_blank"></form>

<td>
<img src="/gestinm/images/excel_file.png" onclick="javascript:document.fmExc.submit();" alt="Ver Excel" style="{cursor: hand}"/>&nbsp;&nbsp;
<img src="/gestinm/images/pdf_file.png" onclick="javascript:document.fmPDF.submit();" alt="Ver PDF" style="{cursor: hand}"/>&nbsp;&nbsp;&nbsp;&nbsp;<img src="/gestinm/images/printer.png" onclick="javascript:imprimir()" alt="Imprimir" style="{cursor: hand}"/></td></tr>
</table>
