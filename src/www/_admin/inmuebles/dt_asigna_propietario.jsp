<%@page import="com.emesa.dao.Informe,java.util.*"%>
<%
Informe oInf = new Informe();
oInf.setQuery("select ID_PROPIETARIO, RAZON_SOCIAL,NOMBRE_COMERCIAL, DOMICILIO, POBLACION, PERSONA_CONTACTO, TELEFONO from fel_proveedor order by ID_PROPIETARIO");

Vector vHeader=new Vector();
vHeader.add("Propietario");
vHeader.add("Raz&oacute;n social");
vHeader.add("Nombre comercial");
vHeader.add("Domicilio");
vHeader.add("Poblaci&oacute;n");
vHeader.add("Persona contacto");
vHeader.add("Tel&eacute;fono");

session.setAttribute("inf_header",vHeader);
session.setAttribute("inf_rtado",oInf.executeDirect());
%><jsp:include page="showResults.jsp"/>

<%@taglib uri="/tags/display" prefix="display" %><%
request.setAttribute("test",com.educarioja.dao.edr_personal_dge.getPersonal());
%><display:table 
        name="test" 
        sort="list" 
        width="100%" 
        pagesize="25"
        scope="request">
    <display:column property="ID_PROPIETARIO" title="Id" align="center" sortable="true"/>
    <display:column property="PERSONA_CONTACTO" title="Nombre" sortable="true"/>
    <display:column property="CONTACTO_APEL1" title="Apellido" sortable="true"/>
    <display:column property="TELEFONO" title="Tel&eacute;fono" align="center"/>
    <display:column property="DOMICILIO" title="Domicilio"/>
    <display:column property="POBLACION" title="Poblaci&oacute;" sortable="true"/>

	<display:setProperty name="paging.banner.include_first_last" value="true"/>
</display:table></body>
</html>