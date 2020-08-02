<jsp:useBean id="ofel_garaje" class="com.emesa.gestinm.dao.FEL_GARAJE" scope="session" />
<%--jsp:setProperty name="ofel_garaje" property="*" /--%>
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
    ofel_garaje=new com.emesa.gestinm.dao.FEL_GARAJE();
    ofel_garaje.loadFromDB(nCod);
    session.setAttribute("ofel_garaje",ofel_garaje);
}

%><table width="100%">
<tr>
<td width="50%" align="center">
<table>
<tr>
<td valign="top" align="center">
        <table  border="1">
            <tr>
                <td>Vigilante:</td>
                <td><input type="checkbox" value="1" name="VIGILANTE" <%=ofel_garaje.getVIGILANTE()==0?"":" checked=\"true\""%>/></td>
            </tr>
            <tr>
                <td>Num. Plazas:</td>
                <td><input type="text" name="NUM_PLAZAS" size="5" value="<%=ofel_garaje.getNUM_PLAZAS()==0?"":""+ofel_garaje.getNUM_PLAZAS()%>"/></td>
            </tr>
        </table>
</td>
<!-- 3ª columna de la 2ª fila -->
</tr>
<tr>
<tr></tr>
<td valign="top">
        
</td>
</table>
</td>
<td valign="top" align="left" width="50%">
        
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