<jsp:useBean id="oNota" class="com.emesa.gestinm.dao.FEL_NOTA_D" scope="request"/>
<jsp:setProperty name="oNota" property="*"/><%

//-- Consideramos cuando hay que borrar los campos
if(request.getParameter("del").equals("true")) {
    int nCodigo=oNota.getCODIGO();
    oNota=new com.emesa.gestinm.dao.FEL_NOTA_D();
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
        <td valign="top"><b>Materiales</b>:</td>
        <td><%=oNota.getMATERIALES()==null?"":oNota.getMATERIALES()%></td>
    </tr>
    <tr>
        <td valign="top"><b>Obras a realizar</b>:</td>
        <td><%=oNota.getOBRAS()==null?"":oNota.getOBRAS()%></td>
    </tr>
</table>