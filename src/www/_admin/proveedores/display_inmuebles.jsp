<%@page import="java.text.*"%><%@taglib uri="/tags/display" prefix="display" %><%

request.setAttribute("test",ofel_proveedor.getInmuebles());
%><h5>Inmuebles del propietario</h5><display:table 
        name="test" 
        sort="list" 
        width="100%" 
        pagesize="20"
        scope="request"
        decorator="com.emesa.gestinm.decorators.InmuebleDecorator">
    <display:column property="CODIGO" title="Cod." align="center" sortable="true"/>
    <display:column property="TIPO" align="center" title="Tipo" sortable="true"/>
    <display:column property="SUPERFICIE" title="Sup. m<sup>2</sup>" align="right" sortable="true"/>
	<display:column property="PRECIO_VENTA" align="right" title="Venta &euro;" sortable="true"/>
	<display:column property="PRECIO_ALQUILER" align="right" title="Alq. &euro;" sortable="true"/>
    <display:column property="FECHA_ALTA" title="Fecha Alta" align="center" sortable="true"/>

	<display:setProperty name="paging.banner.include_first_last" value="true"/>
</display:table></body>
</html>