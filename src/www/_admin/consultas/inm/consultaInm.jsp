<%@ taglib uri="oscache" prefix="cache"%>
<%@page import="java.util.Vector,java.util.Date,com.emesa.bbdd.cache.QueryCache"%>
<script language="javascript">
<!--

function submitForm() {
      document.fmId.submit();
}
//-->
</script><%

String sTipo = request.getParameter("ID_TIPO_INMUEBLE"); 
if(sTipo==null)
    sTipo="-1";

%><table cellpadding="2" width="100%" border="0">
<tr class="marca"><td colspan="2" align="right">&nbsp;<input type="button" value="Consultar" onclick="javascript:document.fmId.submit();" class="boton"/>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
<tr>
    <td class="destacado">
        <table width="100%" border="0" cellpadding="1">
        <form name="tipoinm" method="post" action="index.jsp?tab=inf&acc=inm">
        <tr>
        <td>Tipo: </td>
        <td><select name="ID_TIPO_INMUEBLE" onchange="javascript:document.tipoinm.submit();">
        <option value="-1"<%=sTipo.equals("-1")?" selected=\"true\"":""%>>-- No indicado --</option><%
        Vector v=QueryCache.get("inm").getQueryResults();
        
        for(int i=0; i<v.size(); i++) {
            %><option value="<%=((Vector)v.elementAt(i)).elementAt(1)%>"<%=sTipo.equals( ((Vector)v.elementAt(i)).elementAt(1).toString() )?" selected=\"true\"":""%>><%=((Vector)v.elementAt(i)).elementAt(1).toString()%></option><%
        }
        %></select></td>
        </tr>
        </form>

        <form method="post" name="fmId" action="index.jsp">
        <input type="hidden" name="tab" value="inf"/>
        <input type="hidden" name="acc" value="inmSel"/>
        <input type="hidden" name="ID_TIPO_INMUEBLE" value="<%=sTipo%>"/>
        <tr>
            <td>Provincia:</td>
            <td><jsp:include page="/inc/comboProvincia.jsp">
            <jsp:param name="sel" value=""/>
            </jsp:include></td>
        </tr>
        <tr><td colspan="2" height="5"/></tr>
        <tr>
            <td>Poblaci&oacute;n: </td>
            <td><input type="text" name="POBLACION"/></td>
        </tr><%--
        // [25/08/2003] seh
        --%><tr>
            <td></td>
            <td><jsp:include page="/inc/_comboPoblacion.jsp"/></td>
        </tr><%--
        // eoseh
	// Cacheamos y refrescamos cada 4 horas
        --%>
<cache:cache time="14400">
        <%-- ###################################################################################### --%>
        <tr><td colspan="2" height="5"/></tr>
                 <tr>
            <td valign="top">Zona: </td>
            <td><%
                Vector vCats = QueryCache.get("zonas").getQueryResults();
                Vector vRowCat=null;
                %>
                <select name="ZONA" onchange="javascript:poblar(this.options[this.selectedIndex].text)">
                    <option value="" selected="true">No Indicada</option>
                    <%
                    for(int i=0; i<vCats.size(); i++) {
                        vRowCat=(Vector)vCats.elementAt(i);
                    %>
                    <option value="<%=vRowCat.elementAt(1)%>"><%=vRowCat.elementAt(1).toString()%></option>
                    <% } %>
                </select>
            </td>
        </tr>
        <tr><td colspan="2" height="5"/></tr>
        <tr>
            <td valign="top">Direcci&oacute;n: </td>
            <td><input type="text" name="DIRECCION" size="50"/></td>
        </tr>
        <tr>
            <td></td>
            <td><%
                QueryCache.reloadQuery("direcciones");
%><script language="javascript">
<!--
//---------------------------------------------------------------------------------------------------
    function poblar(s) {
<%
    Vector vDirs=new Vector();
%>
        document.fmId.selDIRECCION.length=0;
        if(s=='No Indicada' || s==null || s=='') {
            <%
                vDirs=QueryCache.get("direcciones").getQueryResults();
            %>
                newOpt=document.createElement("OPTION");
                newOpt.text = '-- No indicada --';
                newOpt.value = '';
                document.fmId.selDIRECCION.options.add(newOpt,0);
            <%
                for(int j=0; j<vDirs.size(); j++) {
            %>
                    newOpt=document.createElement("OPTION")
                    newOpt.text = '<%=((Vector)vDirs.elementAt(j)).firstElement()%>';
                    document.fmId.selDIRECCION.options.add(newOpt,<%=j+1%>);<%
                }
            %>
        }
    <%
        String sZona="";
        Vector vZonas = QueryCache.get("zonas").getQueryResults();
        if(vZonas!=null) {
            for(int i=0; i<vZonas.size(); i++) {
                sZona=((Vector)vZonas.elementAt(i)).elementAt(1).toString();
                %>
                if(s=='<%=sZona%>') {
                    <%
                        vDirs=com.emesa.gestinm.bbdd.cache.CacheUtil.getDirecciones(sZona);
                    %>
                        newOpt=document.createElement("OPTION");
                        newOpt.text = '-- No indicada --';
                        newOpt.value = '';
                        document.fmId.selDIRECCION.options.add(newOpt,0);
                    <%

                        for(int j=0; j<vDirs.size(); j++) {
                    %>
                            newOpt=document.createElement("OPTION")
                            newOpt.text = '<%=((Vector)vDirs.elementAt(j)).firstElement()%>';
                            document.fmId.selDIRECCION.options.add(newOpt,<%=j+1%>);<%
                        }
                %>}
            <%}
        }%>
}
//-->
</script>
<select name="selDIRECCION">
</select>
</td>
        </tr>
</cache:cache>
        <tr><td colspan="2" height="5"/></tr>
        <%-- ###################################################################################### 
         <tr>
            <td valign="top">Zona: </td>
            <td><jsp:include page="/inc/comboZona.jsp"/></td>
        </tr>
        <tr><td colspan="2" height="5"/></tr>
        <tr>
            <td valign="top">Direcci&oacute;n: </td>
            <td><input type="text" name="DIRECCION" size="50"/></td>
        </tr>
        // [25/08/2003] seh
        <tr>
            <td></td>
            <td><jsp:include page="/inc/_comboDireccion.jsp"/></td>
        </tr>
        // eoseh
        ######################################################################################--%>
        <tr><td colspan="2" height="5"/></tr>
        <tr>
            <td>N&uacute;mero:</td>
            <td><input type="text" name="NUMERO" size="5"/></td>
        </tr>
        <tr>
            <td>En exclusiva:</td>
            <td><select name="EN_EXCLUSIVA">
                <option value="">Indiferente</option>
                <option value="1">Si</option>
                <option value="0">No</option>
            </select></td>
        </tr>
        </table>
    </td>
    <td valign="top">
        <table class="bordeVerde" cellpadding="1" valign="top">
            <tr><th colspan="2">Precio</th></tr>
            <tr>
            <td>Venta:</td>
            <td><input type="radio" name="VENTA" value="VENTA"/></td>
        </tr>
        <tr>
            <td>Alquiler:</td>
            <td><input type="radio" name="VENTA" value="ALQUILER"/></td>
        </tr>
        <tr>
            <td>Traspaso:</td>
            <td><input type="radio" name="VENTA" value="TRASPASO"/></td>
        </tr>
        <tr>
            <td>Desde:</td>
            <td><input type="input" name="DESDEPRECIO" size="8"/> &euro;</td>
        </tr>
        <tr>
            <td>Hasta:</td>
            <td><input type="input" name="HASTAPRECIO" size="8"/> &euro;</td>
        </tr>
        </table>
    </td>
</tr>
<tr>
    <td valign="top">
        <table class="bordeVerde" cellpadding="1" valign="top">
            <tr><th colspan="3">Superficie</th></tr>
            <tr><td>
                <table>
                    <tr>
                    <td>Total:</td>
                    <td><input type="checkbox" name="TOTAL"/></td>
                </tr>
                <tr>
                    <td>&Uacute;til:</td>
                    <td><input type="checkbox" name="UTIL"/></td>
                </tr>
                <tr>
                    <td>Constru&iacute;da:</td>
                    <td><input type="checkbox" name="CONSTRUIDA"/></td>
                </tr>
                </table>
            </td>
            <td>
                <td>Entre <input type="input" name="SUPENTRE" size="5"/> m<sup>2</sup> y <input type="input" name="SUPY" size="5"/> m<sup>2</sup></td>
            </td>
        </tr>
        </table>
    </td>
<td valign="top" width="100%" class="bordeRojo"><%

if (sTipo!=null && !sTipo.trim().equals("-1") && !sTipo.trim().equals("")) {
    sTipo=sTipo.trim();
    %><b><%=sTipo%></b><%
 	if (sTipo.equals("PISO") || sTipo.equals("ÁTICO") || sTipo.equals("DÚPLEX") || sTipo.equals("APARTAMENTO") || sTipo.equals("ESTUDIO")) {
	    %><jsp:include page="/_admin/consultas/inm/pisoDet.jsp" /><%
    }
    else if(sTipo.equals("NAVE INDUSTRIAL") || sTipo.equals("LOCAL COMERCIAL")) {
        %><jsp:include page="/_admin/consultas/inm/naveDet.jsp" /><%
    }
    else if(sTipo.equals("CHALET") || sTipo.equals("BODEGA")) {
        %><jsp:include page="/_admin/consultas/inm/chaletDet.jsp" /><%
    }
}
%></td>
</tr>
</form>
</table>