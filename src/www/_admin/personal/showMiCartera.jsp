<script language="JavaScript">
<!--
function imprimir()
{
	window.open("/gestinm/imprimir.jsp", "VentanaHija", "resizable=no, toolbar=no, scrollbars=yes, width=800, height=500");
}
//-->
</script>
<div id="toPrintLayer">
<jsp:include page="pager.jsp">
    <jsp:param name="ps" value="20"/>
    <jsp:param name="dest" value="index.jsp?tab=my"/>
</jsp:include>
</div>
<table align="center" border="0" width="75%">
<tr align="right"><td><img src="/gestinm/images/printer.png" onclick="javascript:imprimir()" alt="Imprimir" style="{cursor: hand}"/></td></tr>
</table>
