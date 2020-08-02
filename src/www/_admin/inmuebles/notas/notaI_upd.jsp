<jsp:useBean id="oNota" class="com.emesa.gestinm.dao.FEL_NOTA_I" scope="request"/>
<jsp:setProperty name="oNota" property="*"/><%

//-- Consideramos cuando hay que borrar los campos
if(request.getParameter("del").equals("true")) {
    int nCodigo=oNota.getCODIGO();
    oNota=new com.emesa.gestinm.dao.FEL_NOTA_I();
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
        <td valign="top"><b>FDatos registrales</b>:</td>
        <td><%=oNota.getDATOS_REGISTRALES()==null?"":oNota.getDATOS_REGISTRALES()%></td>
    </tr>
</table>
