<jsp:useBean id="ofel_piso" class="com.emesa.gestinm.dao.FEL_PISO" scope="session" />
<jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" />
<%
int nCod=-1;

boolean bLoad=false;

//-- edu --
nCod=ofel_inmueble.getCODIGO();

if(nCod!=-1)
	bLoad=true;

if(bLoad) {
    ofel_piso=new com.emesa.gestinm.dao.FEL_PISO();
    ofel_piso.loadFromDB(nCod);
    session.setAttribute("ofel_piso",ofel_piso);
}

//-- [21/08/2003] seh: Características de los distintos tipos
if(ofel_inmueble.getTIPO()!=null) {
    if(ofel_inmueble.getTIPO().equals("APARTAMENTO"))
        ofel_piso.setDORMITORIOS(2);
    if(ofel_inmueble.getTIPO().equals("ESTUDIO"))
        ofel_piso.setDORMITORIOS(1);
// --Edu--
//    else
//        ofel_piso.setDORMITORIOS(0);
// --Edu
}
%><table width="100%">
<tr>
<td width="50%" align="center">
<table>
<tr>
<td valign="top" align="center">
        <table  border="1">
            <tr>
                <td>Calefacci&oacute;n:</td>
                <td><jsp:include page="/inc/comboTipoCalef.jsp">
                <jsp:param name="sel" value="<%=ofel_piso.getCALEFACCION()%>"/></jsp:include></td>
            </tr>
            <tr>
                <td>Agua caliente:</td>
                <td><jsp:include page="/inc/comboTipoAgua.jsp">
                <jsp:param name="sel" value="<%=ofel_piso.getAGUA_CALIENTE()%>"/></jsp:include></td>
            </tr>
            <tr>
                <td>Comunidad:</td>
                <td><input type="text" name="GASTOS_COMUNIDAD" value="<%=ofel_piso.getGASTOS_COMUNIDAD()==null?"":ofel_piso.getGASTOS_COMUNIDAD()%>"/></td>
            </tr>
            <tr>
                <td>Precio del garaje:</td>
                <td><input type="text" name="PRECIO_GARAJE" value="<%=ofel_piso.getPRECIO_GARAJE()==null?"":ofel_piso.getPRECIO_GARAJE()%>"/></td>
            </tr>
        </table>
</td>
<!-- 3ª columna de la 2ª fila -->
</tr>
<tr>
<tr></tr>
<td valign="top" align="left">
        <table border="1">
            <tr>
                <td>Antig&uuml;edad:</td>
                <td><input type="text" name="ANTIGUEDAD" size="6" value="<%=ofel_piso.getANTIGUEDAD()==0?"":""+ofel_piso.getANTIGUEDAD()%>"/></td>
            </tr>
            <tr>
                <td>Altura:</td>
                <td><input type="text" name="ALTURA" size="6" value="<%=ofel_piso.getALTURA()==0?"":""+ofel_piso.getALTURA()%>"/></td>
            </tr>
            <%--tr>
                <td>N<sup>o</sup> habitaciones: </td>
                <td><input type="text" name="HABITACIONES" size="6" value="<%=ofel_piso.getHABITACIONES()==0?"":""+ofel_piso.getHABITACIONES()%>"/></td>
            </tr--%>
            <tr>
                <td>N<sup>o</sup> dormitorios: </td>
                <td><input type="text" name="DORMITORIOS" size="6" value="<%=ofel_piso.getDORMITORIOS()==0?"":""+ofel_piso.getDORMITORIOS()%>"/></td>
            </tr>
            <tr>
                <td>N<sup>o</sup> ba&ntilde;os: </td>
                <td><input type="text" name="BANOS" size="6" value="<%=ofel_piso.getBANOS()==0?"":""+ofel_piso.getBANOS()%>"/></td>
            </tr>
            <tr>
                <td>N<sup>o</sup> aseos: </td>
                <td><input type="text" name="ASEOS" size="6" value="<%=ofel_piso.getASEOS()==0?"":""+ofel_piso.getASEOS()%>"/></td>
            </tr>
        </table>
</td>
</table>
</td>
<td valign="top" align="left" width="50%">
    <table border="0">
        <tr>
        <td>
            <table border="1" >
                <tr>
                    <td>Terraza:</td>
                    <td><input type="text" name="TERRAZA" size="5" value="<%=ofel_piso.getTERRAZA()%>"/> m<sup>2</sup></td>
                </tr>
            </table>
        </td>
        </tr>
        <tr><td>
            <table border="1">
            <tr>
                <td><input type="checkbox" name="ASCENSOR"  value="1" <%=ofel_piso.getASCENSOR()==0?"":"checked=\"true\""%>/> Ascensor</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="PORTERO" value="1" <%=ofel_piso.getPORTERO()==0?"":"checked=\"true\""%>/> Portero</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="GARAJE" value="1" <%=ofel_piso.getGARAJE()==0?"":"checked=\"true\""%>/> Garage</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="PISCINA" value="1" <%=ofel_piso.getPISCINA()==0?"":"checked=\"true\""%>/> Piscina</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="AMUEBLADO" value="1" <%=ofel_piso.getAMUEBLADO()==0?"":"checked=\"true\""%>/> Amueblado</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="TRASTERO" value="1" <%=ofel_piso.getTRASTERO()==0?"":"checked=\"true\""%>/> Trastero</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="AIRE_ACONDICIONADO" value="1" <%=ofel_piso.getAIRE_ACONDICIONADO()==0?"":"checked=\"true\""%>/> Aire acondicionado</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="COCINA_AMUEBLADA" value="1" <%=ofel_piso.getCOCINA_AMUEBLADA()==0?"":"checked=\"true\""%>/> Cocina Amueblada</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="EXTERIOR" value="1" <%=ofel_piso.getEXTERIOR()==0?"":"checked=\"true\""%>/> Exterior</td>
            </tr>
        </table>
      </td></tr>
      </table>
</td>
</tr>
</table>
<table>
<tr>
<td valign="top">
<!-- 4ª columna de la 2ª fila -->
</td>
</tr>
</table>