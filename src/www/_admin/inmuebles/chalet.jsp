<jsp:useBean id="ofel_chalet" class="com.emesa.gestinm.dao.FEL_CHALET" scope="session" />
<jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" />
<%
int nCod=ofel_inmueble.getCODIGO();

if(nCod!=-1) {
    ofel_chalet = new com.emesa.gestinm.dao.FEL_CHALET();
    ofel_chalet.loadFromDB(nCod);
    session.setAttribute("ofel_chalet",ofel_chalet);
}
%>
<table width="100%">
<tr>
<td width="50%" align="center">
<table>
<tr>
<td valign="top" align="center">
        <table  border="1">
            <tr>
                <td>Calefacci&oacute;n:</td>
                <td><jsp:include page="/inc/comboTipoCalef.jsp"><jsp:param name="sel" value="<%=ofel_chalet.getCALEFACCION()%>"/></jsp:include></td>
            </tr>
            <tr>
                <td>Agua caliente:</td>
                <td><jsp:include page="/inc/comboTipoAgua.jsp"><jsp:param name="sel" value="<%=ofel_chalet.getAGUA_CALIENTE()%>"/></jsp:include></td>
            </tr>
            <tr>
                <td>Gastos de comunidad:</td>
                <td><input type="text" size="5" name="GASTOS_COMUNIDAD" value="<%=ofel_chalet.getGASTOS_COMUNIDAD()==null?"":ofel_chalet.getGASTOS_COMUNIDAD()%>"/></td>
            </tr>
            <tr>
                <td>Carpinter&iacute;a Exterior:</td>
                <td><input type="text" name="CARPINTERIA_EXTERIOR" value="<%=ofel_chalet.getCARPINTERIA_EXTERIOR()==null?"":ofel_chalet.getCARPINTERIA_EXTERIOR()%>"/></td>
            </tr>
            <tr>
                <td>Carpintería Interior:</td>
                <td><input type="text" name="CARPINTERIA_INTERIOR" value="<%=ofel_chalet.getCARPINTERIA_INTERIOR()==null?"":ofel_chalet.getCARPINTERIA_INTERIOR()%>"/></td>
            </tr>
        </table>
</td>
<!-- 3ª columna de la 2ª fila -->
</tr>
<tr>
<tr></tr>
<td valign="top">
        <table border="1" align="left">
            <tr>
                <td>Antig&uuml;edad:</td>
                <td><input type="text" size="6" name="ANTIGUEDAD" value="<%=ofel_chalet.getANTIGUEDAD()==-1?"":""+ofel_chalet.getANTIGUEDAD()%>"/></td>
            </tr>
            <tr>
                <td>N<sup>o</sup> Plantas:</td>
                <td><input type="text" size="6" name="N_PLANTAS" value="<%=ofel_chalet.getN_PLANTAS()==-1?"":""+ofel_chalet.getN_PLANTAS()%>"/></td>
            </tr>
            <tr>
                <td>Sup. Jard&iacute;n:</td>
                <td><input type="text" size="6" name="SUP_JARDIN" value="<%=ofel_chalet.getSUP_JARDIN()==0?"":""+ofel_chalet.getSUP_JARDIN()%>"/> m<sup>2</sup></td>
            </tr><%--
            <tr>
                <td>N<sup>o</sup> habitaciones: </td>
                <td><input type="text" size="6" name="HABITACIONES" value="<=ofel_chalet.getHABITACIONES()==0?"":""+ofel_chalet.getHABITACIONES()>"/></td>
            </tr>
            --%><tr>
                <td>N<sup>o</sup> dormitorios: </td>
                <td><input type="text" size="6" name="DORMITORIOS" value="<%=ofel_chalet.getDORMITORIOS()==0?"":""+ofel_chalet.getDORMITORIOS()%>"/></td>
            </tr>
            <tr>
                <td>N<sup>o</sup> ba&ntilde;os: </td>
                <td><input type="text" size="6" name="BANOS" value="<%=ofel_chalet.getBANOS()==0?"":""+ofel_chalet.getBANOS()%>"/></td>
            </tr>
            <tr>
                <td>N<sup>o</sup> aseos: </td>
                <td><input type="text" size="6" name="ASEOS" value="<%=ofel_chalet.getASEOS()==0?"":""+ofel_chalet.getASEOS()%>"/></td>
            </tr>
        </table>
</td>
</table>
</td>
<td valign="top" align="left" width="50%">
        <table border="1">
            <tr>
               <td><input type="checkbox" name="GARAJE" value="1" <%=ofel_chalet.getGARAJE()==0?"":"checked=\"true\""%>/> Garaje</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="PISCINA" value="1" <%=ofel_chalet.getPISCINA()==0?"":"checked=\"true\""%>/> Piscina</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="AMUEBLADO" value="1" <%=ofel_chalet.getAMUEBLADO()==0?"":"checked=\"true\""%>/> Amueblado</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="AIRE_ACONDICIONADO" value="1" <%=ofel_chalet.getAIRE_ACONDICIONADO()==0?"":"checked=\"true\""%>/> Aire acondicionado</td>
            </tr>
            <tr>
		<td><input type="checkbox" name="COCINA_AMUEBLADA" value="1" <%=ofel_chalet.getCOCINA_AMUEBLADA()==0?"":"checked=\"true\""%>/> Cocina Amueblada</td>
	    </tr>
	    <tr>
                <td><input type="checkbox" name="TELEFONO"  value="1" <%=ofel_chalet.getTELEFONO()==0?"":"checked=\"true\""%>/> Tel&eacute;fono</td>
            </tr>
        </table>
</td>
</tr>
</table>
