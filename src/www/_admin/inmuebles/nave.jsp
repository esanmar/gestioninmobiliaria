<jsp:useBean id="ofel_inm_nave" class="com.emesa.gestinm.dao.FEL_INM_NAVE" scope="session" />
<jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" />
<%
int nCod=ofel_inmueble.getCODIGO();

if(nCod!=-1) {
    ofel_inm_nave = new com.emesa.gestinm.dao.FEL_INM_NAVE();
    ofel_inm_nave.loadFromDB(nCod);
    session.setAttribute("ofel_inm_nave",ofel_inm_nave);
}
%>
<table width="100%">
<tr>
<td width="50%" align="center" valign="top">
<table>
<tr>
<td valign="top" align="center">
        <table  border="1">
            <tr>
                <td>Funci&oacute;n actual:</td>
                <td><input type="text" name="FUNCION_ACTUAL" value="<%=ofel_inm_nave.getFUNCION_ACTUAL()==null?"":ofel_inm_nave.getFUNCION_ACTUAL()%>"/></td>
            </tr>
            <tr>
                <td>Superficie:</td>
                <td><input type="text" name="SUP_NAVE" value="<%=ofel_inm_nave.getSUP_NAVE()==0?"":""+ofel_inm_nave.getSUP_NAVE()%>"/></td>
            </tr>
        </table>
</td>
<!-- 3ª columna de la 2ª fila -->
</tr></tr>
<td valign="top">
</td>
</table>
</td>
<td valign="top" align="left" width="50%">
        <table  border="1">
            <tr>
                <td><input type="checkbox" name="SALIDA_GASES" value="1" <%=ofel_inm_nave.getSALIDA_GASES()==0?"":"checked=\"true\""%>/> Salida de gases</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="SOTANO_ALMACEN" value="1" <%=ofel_inm_nave.getSOTANO_ALMACEN()==0?"":"checked=\"true\""%>/> S&oacute;tano / Almac&eacute;n</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="OFICINA" value="1" <%=ofel_inm_nave.getOFICINA()==0?"":"checked=\"true\""%>/> Oficina</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="AIRE_ACONDICIONADO" value="1" <%=ofel_inm_nave.getAIRE_ACONDICIONADO()==0?"":"checked=\"true\""%>/> Aire acondicionado</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="TELEFONO"  value="1" <%=ofel_inm_nave.getTELEFONO()==0?"":"checked=\"true\""%>/> Teléfono</td>
            </tr>
        </table>
</td>
</tr>
</table>
