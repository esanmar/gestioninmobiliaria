<jsp:useBean id="oNota" class="com.emesa.gestinm.dao.FEL_NOTA_C" scope="request"/>
<jsp:setProperty name="oNota" property="*"/><%

//-- Consideramos cuando hay que borrar los campos
if(request.getParameter("del").equals("true")) {
    int nCodigo=oNota.getCODIGO();
    oNota=new com.emesa.gestinm.dao.FEL_NOTA_C();
    oNota.setCODIGO(nCodigo);
}

try { 
    oNota.saveToDB();
    %><p> Actualizada la nota del inmueble <%=oNota.getCODIGO()==-1?"":""+oNota.getCODIGO()%></p><%
}
catch(Exception e) {
    %><p class="err"> Error al actualizar la nota del inmueble <%=oNota.getCODIGO()%></p><%
}
%>
<table>
<tr>
    <td valign="top"><b>Diecci&oacute;n completa</b>:</td>
    <td><%=oNota.getDIR_COMPLETA()==null?"":oNota.getDIR_COMPLETA()%></td>
</tr>
<tr>
    <td><b>Garaje</b>:</td>
    <td<%=oNota.getGARAJE()==null?"":oNota.getGARAJE()%></td>
</tr>
<tr>
    <td><b>Trastero</b>:</td>
    <td><%=oNota.getTRASTERO()==null?"":oNota.getTRASTERO()%></td>
</tr>
<tr><td colspan="2" class="destacado">:. Datos de los propietarios</td><td/></tr>
<tr>
    <td><b>Nombre y apellidos</b>:</td>
    <td><%=oNota.getNOMBRE_APEL()==null?"":oNota.getNOMBRE_APEL()%></td>
</tr>
<tr>
    <td valign="top"><b>Direcci&oacute;n y poblaci&oacute;n</b>:</td>
    <td><%=oNota.getDIR_Y_POBLACION()==null?"":oNota.getDIR_Y_POBLACION()%></td>
</tr>
<tr>
    <td valign="top"><b>Personas a tratar</b>:</td>
    <td><%=oNota.getPERSONAS_TRATAR()==null?"":oNota.getPERSONAS_TRATAR()%></td>
</tr>
<tr>
    <td valign="top"><b>Tel&eacute;fonos</b>:</td>
    <td><%=oNota.getTELEFONOS()==null?"":oNota.getTELEFONOS()%></td>
</tr>
<tr>
    <td valign="top"><b>Horario visitas propietario</b>:</td>
    <td><%=oNota.getVISITAS_PROPIETARIO()==null?"":oNota.getVISITAS_PROPIETARIO()%></td>
</tr>
<tr>
    <td valign="top"><b>Horario visitas tasador</b>:</td>
    <td><%=oNota.getVISITAS_TASADOR()==null?"":oNota.getVISITAS_TASADOR()%></td>
</tr>
</table>
