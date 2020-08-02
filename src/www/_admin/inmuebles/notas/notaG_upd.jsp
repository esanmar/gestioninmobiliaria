<jsp:useBean id="oNota" class="com.emesa.gestinm.dao.FEL_NOTA_G" scope="request"/>
<jsp:setProperty name="oNota" property="*"/><%

//-- Consideramos cuando hay que borrar los campos
if(request.getParameter("del").equals("true")) {
    int nCodigo=oNota.getCODIGO();
    oNota=new com.emesa.gestinm.dao.FEL_NOTA_G();
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
        <td valign="top"><b>Destacable por el propietario</b>:</td>
        <td><%=oNota.getDEST_PROPIETARIO()==null?"":oNota.getDEST_PROPIETARIO()%></td>
    </tr>
    <tr>
        <td valign="top"><b>Destacable por el tasador</b>:</td>
        <td><%=oNota.getDEST_TASADOR()==null?"":oNota.getDEST_TASADOR()%></td>
    </tr>
</table>