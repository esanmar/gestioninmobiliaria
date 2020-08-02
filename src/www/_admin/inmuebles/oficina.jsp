<jsp:useBean id="ofel_inm_oficina" class="com.emesa.gestinm.dao.FEL_INM_OFICINA" scope="session" />
<%--jsp:setProperty name="ofel_inm_oficina" property="*"  /--%>
<jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" />
<%--jsp:setProperty name="ofel_inmueble" property="*" /--%>
<%
// Cargamos el objeto según los criterios de carga
// ## CHECK ##
String sCODIGO = request.getParameter("xCodigo");
String sDireccion = request.getParameter("xDireccion");
String sNumero = request.getParameter("xNumero");
int nCod=-1;

boolean bLoad=false;

//-- edu --
nCod=ofel_inmueble.getCODIGO();

if(nCod!=-1)
	bLoad=true;

/*
if(sCODIGO!=null && !sCODIGO.equals(""))
{
    nCod = Integer.parseInt(sCODIGO);
    bLoad=true;
}
else if(sDireccion!=null && !sDireccion.equals(""))
{
    ofel_inmueble.loadDirFromDB(sDireccion, sNumero);
    nCod=ofel_inmueble.getCODIGO();
    bLoad=true;
}
*/

if(bLoad) {
    ofel_inm_oficina=new com.emesa.gestinm.dao.FEL_INM_OFICINA();
    ofel_inm_oficina.loadFromDB(nCod);
    session.setAttribute("ofel_inm_oficina",ofel_inm_oficina);
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
                <td><jsp:include page="/inc/comboTipoCalef.jsp"><jsp:param name="sel" value="<%=ofel_inm_oficina.getCALEFACCION()%>"/></jsp:include></td>
            </tr>
            <tr>
                <td>Agua caliente:</td>
                <td><jsp:include page="/inc/comboTipoAgua.jsp"><jsp:param name="sel" value="<%=ofel_inm_oficina.getAGUA_CALIENTE()%>"/></jsp:include></td>
            </tr>
            <tr>
                <td>Comunidad:</td>
                <td><input type="text" name="GASTOS_COMUNIDAD" value="<%=ofel_inm_oficina.getGASTOS_COMUNIDAD()==null?"":ofel_inm_oficina.getGASTOS_COMUNIDAD()%>"/></td>
            </tr>
        </table>
</td>
<!-- 3ª columna de la 2ª fila -->
</tr>
<tr>
<tr></tr>
<td valign="top">
        <table  border="1" align="center" border="1" align="center">
            <tr>
                <td>Antig&uuml;edad:</td>
                <td><input type="text" name="ANTIGUEDAD" value="<%=ofel_inm_oficina.getANTIGUEDAD()==0?"":""+ofel_inm_oficina.getANTIGUEDAD()%>"/></td>
            </tr>
            <tr>
                <td>N<sup>o</sup> Plantas:</td>
                <td><input type="text" name="NUM_PLANTAS" value="<%=ofel_inm_oficina.getNUM_PLANTAS()==0?"":""+ofel_inm_oficina.getNUM_PLANTAS()%>"/></td>
            </tr>
            <tr>
                <td>N<sup>o</sup> Despachos: </td>
                <td><input type="text" name="DESPACHOS" value="<%=ofel_inm_oficina.getDESPACHOS()==0?"":""+ofel_inm_oficina.getDESPACHOS()%>"/></td>
            </tr>
            <tr>
                <td>N<sup>o</sup> ba&ntilde;os: </td>
                <td><input type="text" name="BANOS" value="<%=ofel_inm_oficina.getBANOS()==0?"":""+ofel_inm_oficina.getBANOS()%>"/></td>
            </tr>
        </table>
</td>
</table>
</td>
<td valign="top" align="left" width="50%">
        <table  border="1">
            <tr>
                <td><input type="checkbox" name="PREPARADO_OFICINA" value="1" <%=ofel_inm_oficina.getPREPARADO_OFICINA()==0?"":"checked=\"true\""%>/> Preparado como oficina</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="LUZ" value="1" <%=ofel_inm_oficina.getLUZ()==0?"":"checked=\"true\""%>/> Luz</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="ASCENSOR" value="1" <%=ofel_inm_oficina.getASCENSOR()==0?"":"checked=\"true\""%>/> Ascensor</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="PORTERO" value="1" <%=ofel_inm_oficina.getPORTERO()==0?"":"checked=\"true\""%>/> Portero</td>
            </tr>
	    <tr>
                <td><input type="checkbox" name="TELEFONO"  value="1" <%=ofel_inm_oficina.getTELEFONO()==0?"":"checked=\"true\""%>/> Teléfono</td>
            </tr>
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