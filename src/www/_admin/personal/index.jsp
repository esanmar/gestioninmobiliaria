<%@page import="java.text.*"%><%@taglib uri="/tags/display" prefix="display" %>
<jsp:useBean id="_profile_" class="com.emesa.gestinm.portalframework.UserProfile" scope="session" /><%

request.setAttribute("test",_profile_.getMiCartera());
%><script language="JavaScript">
<!--
function imprimir()
{
	window.open("/gestinm/imprimir.jsp", "VentanaHija", "resizable=no, toolbar=no, scrollbars=yes, width=800, height=500");
}
//-->
</script>
<table cellpadding="5" width="100%">
    <tr><td>
<div id="toPrintLayer"><br/>
<display:table 
        name="test" 
        sort="list" 
        width="100%" 
        pagesize="25"
        scope="request"
        decorator="com.emesa.gestinm.decorators.MiCarteraDecorator">
    <display:column property="idInmueble" title="Cod." align="center" sortable="true"/>
    <display:column property="zona" title="Zona" sortable="true"/>
    <display:column property="tipo" title="Tipo" sortable="true"/>
    <display:column property="precVenta" title="Venta &euro;" align="right" sortable="true"/>
    <display:column property="precAlquiler" title="Alq. &euro;" align="right" sortable="true"/>
    <display:column property="superficie" title="Sup. m<sup>2</sup>" align="right" sortable="true"/>
    <display:column property="estado" title="Estado"/>
    <display:column property="contacto" title="Contacto" sortable="true"/>
    <display:column property="tfnoContacto" title="Tfn. Contacto" align="right"/>
	<display:setProperty name="paging.banner.include_first_last" value="true"/>
</display:table><br/></div>
</td></tr></table>
<table align="center" border="0" width="75%">
<tr align="right"><td><img src="/gestinm/images/printer.png" onclick="javascript:imprimir()" alt="Imprimir" style="{cursor: hand;}"/></td></tr>
</table>
