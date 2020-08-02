<%@taglib uri="/tags/display" prefix="display" %><html>
<head><link href="/gestinm/css/gestinm_admin.css" rel="stylesheet" type="text/css" /></head>
<body class="bgNaranja"><%
request.setAttribute("test",com.emesa.gestinm.dao.FEL_PROVEEDOR.getPropietarios());
%><display:table 
        name="test" 
        sort="list" 
        width="100%" 
        pagesize="20"
        scope="request"
        decorator="com.emesa.gestinm.decorators.PropietarioPUDecorator">
    <display:column property="ID_PROPIETARIO" title="Id" align="center" sortable="true"/>
    <display:column property="PERSONA_CONTACTO" title="Nombre" sortable="true"/>
    <display:column property="CONTACTO_APEL1" title="Apellido" sortable="true"/>
	<display:column property="TELEFONO" title="Tel&eacute;fono"/>
    <display:column property="DOMICILIO" title="Domicilio"/>
    <display:column property="FECHA_ALTA" title="Fecha Alta" align="center" sortable="true"/>

	<display:setProperty name="paging.banner.include_first_last" value="true"/>
</display:table></body>
</html>