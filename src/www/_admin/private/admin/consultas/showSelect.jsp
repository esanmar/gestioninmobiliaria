<%@page import="java.util.Collection"%>
<%
request.setAttribute("search_collection",(Collection)session.getAttribute("inf_rtado"));
request.setAttribute("search_header",(Collection)session.getAttribute("inf_header"));

String sInforme = (String)session.getAttribute("inf_nombre");
String sDescripcion = (String)session.getAttribute("inf_descripcion");

if(sInforme==null)
    sInforme="";
if(sDescripcion!=null)
    sInforme="<b>"+sInforme+"</b>"+": "+sDescripcion;
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
<jsp:include page="/reports/pager.jsp">
    <jsp:param name="sbc" value="#FFE3B5"/>
    <jsp:param name="ps" value="20"/>
    <jsp:param name="dest" value="index.jsp?tab=adm&acc=inf2&acc2=show_rtado"/>
</jsp:include>
</div>
<form method="post" name="fmPDF" action="/gestinm/toPDF" target="_blank"></form>
<form method="post" name="fmExc" action="/gestinm/_admin/consultas/excelResults.jsp" target="_blank"></form>
<table align="center" border="0" width="80%">
<tr align="right"><td>
<img src="/gestinm/images/excel_file.png" onclick="javascript:document.fmExc.submit();" alt="Ver Excel" style="{cursor: hand}"/>&nbsp;&nbsp;
<img src="/gestinm/images/pdf_file.png" onclick="javascript:document.fmPDF.submit();" alt="Ver PDF" style="{cursor: hand}"/>&nbsp;&nbsp;&nbsp;&nbsp;<img src="/gestinm/images/printer.png" onclick="javascript:imprimir()" alt="Imprimir" style="{cursor: hand}"/></td></tr>
</table>
