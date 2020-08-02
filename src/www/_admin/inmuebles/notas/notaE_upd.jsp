<jsp:useBean id="oNota" class="com.emesa.gestinm.dao.FEL_NOTA_E" scope="request"/>
<jsp:setProperty name="oNota" property="*"/><%

//-- Consideramos cuando hay que borrar los campos
if(request.getParameter("del").equals("true")) {
    int nCodigo=oNota.getCODIGO();
    oNota=new com.emesa.gestinm.dao.FEL_NOTA_E();
    oNota.setCODIGO(nCodigo);
}

try { 
    String sLuz=request.getParameter("LUZ");
    if(sLuz!=null && sLuz.trim().equals("1"))
        oNota.setLUZ(true);
    else
        oNota.setLUZ(false);
    oNota.saveToDB();
    %><p> Actualizada la nota del inmueble <%=oNota.getCODIGO()==-1?"":""+oNota.getCODIGO()%></p><%
}
catch(Exception e) {
    %><p class="err"> Error al actualizar la nota del inmueble <%=oNota.getCODIGO()%></p><%
}
%>
<table>
    <tr>
        <td><b>Altura real del piso</b>:</td>
        <td><%=oNota.getALTURA_REAL()==null?"":oNota.getALTURA_REAL()%></td>
    </tr>
    <tr>
        <td><b>Pisos por planta</b>:</td>
        <td<%=oNota.getPISOS_PLANTA()==null?"":oNota.getPISOS_PLANTA()%></td>
    </tr>
    <tr>
        <td valign="top"><b>Descripci&oacute;n zona comunitaria</b>:</td>
        <td><%=oNota.getZONA_COMUNITARIA()==null?"":oNota.getZONA_COMUNITARIA()%></td>
    </tr>
    <tr>
        <td><b>Luz el&eacute;ctrica</b>:</td>
        <td><%=oNota.getLUZ()?"Si":"No"%></td>
    </tr>
    <tr>
        <td><b>Portero</b>:</td>
        <td><%=oNota.getPORTERO()==null?"":oNota.getPORTERO()%></td>
    </tr>
    <tr>
        <td valign="top"><b>Ascensores</b>:</td>
        <td><%=oNota.getASCENSORES()==null?"":oNota.getASCENSORES()%></td>
    </tr>
    <tr>
        <td valign="top"><b>Medidas</b>:</td>
        <td><%=oNota.getMEDIDAS()==null?"":oNota.getMEDIDAS()%></td>
    </tr>
    <tr>
        <td valign="top"><b>Muebles</b>:</td>
        <td><%=oNota.getMUEBLES()==null?"":oNota.getMUEBLES()%></td>
    </tr>
</table>