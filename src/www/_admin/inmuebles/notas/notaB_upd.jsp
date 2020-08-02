<jsp:useBean id="oNotaB" class="com.emesa.gestinm.dao.FEL_NOTA_B" scope="request"/>
<jsp:setProperty name="oNotaB" property="*"/><%

String sFecha = request.getParameter("xFECHA_ENTRADA");
if(sFecha!=null && !sFecha.trim().equals("")) {
    oNotaB.setFECHA_ENTRADA(sFecha);
}

//-- Consideramos cuando hay que borrar los campos
if(request.getParameter("del").equals("true")) {
    int nCodigo=oNotaB.getCODIGO();
    oNotaB=new com.emesa.gestinm.dao.FEL_NOTA_B();
    oNotaB.setCODIGO(nCodigo);
}

try { 
    oNotaB.saveToDB();
    %><p> Actualizada la nota del inmueble <%=oNotaB.getCODIGO()==-1?"":""+oNotaB.getCODIGO()%></p><%
}
catch(Exception e) {
    %><p class="err"> Error al actualizar la nota del inmueble <%=oNotaB.getCODIGO()%></p><%
}
%>
<table>
<tr>
    <td><b>Tasador</b>:</td>
    <td><%=oNotaB.getTASADOR()==null?"":oNotaB.getTASADOR()%></td>
</tr>
<tr>
    <td><b>Fecha entrada</b>:</td>
    <td><%=oNotaB.getShowFECHA_ENTRADA()==null?"":oNotaB.getShowFECHA_ENTRADA()%></td>
</tr>
<tr>
    <td><b>Medio de captaci&oacute;n</b>:</td>
    <td><%=oNotaB.getCAPTACION()==null?"":oNotaB.getCAPTACION()%></td>
</tr>
<tr>
    <td><b>Autorizaci&oacute;n/Exclusiva</b>:</td>
    <td><%=oNotaB.getEXCLUSIVA()==null?"":oNotaB.getEXCLUSIVA()%></td>
</tr>
<tr>
    <td valign="top"><b>Por qu&eacute; no se ha conseguido la exclusiva</b>:</td>
    <td><%=oNotaB.getNO_EXCLUSIVA()==null?"":oNotaB.getNO_EXCLUSIVA()%></td>
</tr>
<tr>
    <td valign="top"><b>Cartel</b>:</td>
    <td><%=oNotaB.getCARTEL()==null?"":oNotaB.getCARTEL()%></td>
</tr>
<tr>
    <td valign="top"><b>Motivo venta</b>:</td>
    <td><%=oNotaB.getMOTIVO_VENTA()==null?"":oNotaB.getMOTIVO_VENTA()%></td>
</tr>
</table>