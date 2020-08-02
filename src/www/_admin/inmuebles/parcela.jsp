<jsp:useBean id="ofel_parcela" class="com.emesa.gestinm.dao.FEL_PARCELA" scope="session" />
<%--jsp:setProperty name="ofel_parcela" property="*" /--%>
<jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" />
<%--jsp:setProperty name="ofel_inmueble" property="*" /--%>
<%
// Cargamos el objeto según los criterios de carga
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
	ofel_parcela = new com.emesa.gestinm.dao.FEL_PARCELA();
    	ofel_parcela.loadFromDB(nCod);
    	session.setAttribute("ofel_parcela",ofel_parcela);
}
%>
<table align="center">
    <tr>
        <td width="50%" align="center" valign="top">
            <table border="1" align="center">
                <tr>
                    <td>Antig&uuml;edad:</td>
                    <td><input type="text" name="ANTIGUEDAD" value="<%=ofel_parcela.getANTIGUEDAD()==0?"":""+ofel_parcela.getANTIGUEDAD()%>"/></td>
                </tr>
                <tr>
                    <td>Hect&aacute;reas:</td>
                    <td><input type="text" name="HECTAREAS" value="<%=ofel_parcela.getHECTAREAS()==0?"":""+ofel_parcela.getHECTAREAS()%>"/></td>
                </tr>
                <tr>
                    <td>Toma de Agua </td>
                    <td><input type="text" name="TOMA_AGUA" value="<%=ofel_parcela.getTOMA_AGUA()==null?"":ofel_parcela.getTOMA_AGUA()%>"/></td>
                </tr>
                <tr>
                    <td>Toma de Luz: </td>
                    <td><input type="text" name="TOMA_LUZ" value="<%=ofel_parcela.getTOMA_LUZ()==null?"":ofel_parcela.getTOMA_LUZ()%>"/></td>
                </tr>
            </table>
        </td>
        <td width="10"></td>
        <td valign="top">
            <table valign="top" border="1">
                <tr>
                    <td><input type="checkbox" name="URBANIZABLE"  value="1" <%=ofel_parcela.getURBANIZABLE()==0?"":"checked=\"true\""%>/> Urbanizable</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="AGRICOLA" value="1" <%=ofel_parcela.getAGRICOLA()==0?"":"checked=\"true\""%>/>Agr&iacute;cola</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="DESAGUES" value="1" <%=ofel_parcela.getDESAGUES()==0?"":"checked=\"true\""%>/> Desag&uuml;es</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="RESIDENCIA" value="1" <%=ofel_parcela.getRESIDENCIA()==0?"":"checked=\"true\""%>/> Residencia</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="VALLADO" value="1" <%=ofel_parcela.getVALLADO()==0?"":"checked=\"true\""%>/> Vallado</td>
                </tr>
            </table>
        </td>
    </tr>
</table>
