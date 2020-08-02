<%@page import="com.emesa.gestinm.dao.*,java.util.Enumeration"%>
<jsp:useBean id="_profile_" class="com.emesa.gestinm.portalframework.UserProfile" scope="session" />
<jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" />
<script language="JavaScript">
<!--
function imprimir()
{
	window.open("/gestinm/imprimir.jsp", "VentanaHija", "resizable=no, toolbar=no, scrollbars=yes, width=800, height=500");
}
//-->
</script>
<div id="toPrintLayer">
<table cellpadding="5" border="0" align="center">
<tr>
    <td colspan="2" style="{font-family : Tahoma, Arial; font-size : 11pt; color: black; font-weight: bold;}">C&oacute;digo inmueble:  <%=ofel_inmueble.getCODIGO()%></td></tr>
<tr>
    <td>
        <table class="bordeRojo" cellpadding="2" cellspacing="2" border="0"><%--
        <tr>
            <td><b>Referencia</b>:</td>
            <td colspan="4"><%=ofel_inmueble.getREFERENCIA()==null?"":ofel_inmueble.getREFERENCIA()%></td>
        </tr>
        --%><tr>
            <td><b>Poblaci&oacute;n</b>:</td>
            <td colspan="4"><%=ofel_inmueble.getPOBLACION()==null?"":ofel_inmueble.getPOBLACION()%></td>
        </tr>
        <tr>
            <td><b>Zona</b>:</td>
            <td colspan="4"><%=ofel_inmueble.getZONA()==null?"":ofel_inmueble.getZONA()%></td>
        </tr>
        <tr>
            <td><b>Direcci&oacute;n</b>:</td>
            <td colspan="4"><%=ofel_inmueble.getDIRECCION()==null?"":ofel_inmueble.getDIRECCION()%></td>
        </tr>
        <tr>
            <td><b>Superficie total</b>:</td>
            <td><%=ofel_inmueble.getSUPERFICIE()%> m<sup>2</sup></td>
            <td></td>
            <td><b>Superficie &uacute;til</b>:</td>
            <td><%=ofel_inmueble.getSUP_UTIL()==0?" - ":""+ofel_inmueble.getSUP_UTIL()%> m<sup>2</sup></td>
        </tr>
        <tr><td colspan="5" height="1px" class="bgVerde"/></tr>
        <tr>
            <td><b>Precio venta</b>:</td>
            <td colspan="4"><%=com.emesa.util.Formats.doubleNumber(ofel_inmueble.getPRECIO_VENTA())%> &euro;</td>
        </tr>
        <tr>
            <td><b>Precio alquiler</b>:</td>
            <td colspan="4"><%=com.emesa.util.Formats.doubleNumber(ofel_inmueble.getPRECIO_ALQUILER())%> &euro;</td>
        </tr>
        </table>
    </td>
    <td valign="top" align="center" width="50%" rowspan="2"><%
        if(ofel_inmueble.getFirstVisiblePicture()!=null) {
            %><img border="1"  src="<%=com.emesa.Configuration.getProperty("pictures.prefix")%>/<%=ofel_inmueble.getCODIGO()%>/<%=ofel_inmueble.getFirstVisiblePicture().getPATH_FOTO()%>" width="320" height="240"/><%
        }
    %></td>
</tr>
<tr><td><%

String sTipo=ofel_inmueble.getTIPO();

if (sTipo!=null && (sTipo.equals("PISO") || sTipo.equals("ÁTICO") || sTipo.equals("DÚPLEX") || sTipo.equals("APARTAMENTO") || sTipo.equals("ESTUDIO"))){
    %><b><%=sTipo%></b><jsp:include page="vc_piso.jsp"/><%
}
else if (sTipo!=null && sTipo.equals("CHALET")) {
    %><b><%=sTipo%></b><jsp:include page="vc_chalet.jsp"/><%
}
%></td>
</tr>
<tr>
    <td colspan="2"><blockquote><%=ofel_inmueble.getDESCRIPCION()==null?"":ofel_inmueble.getDESCRIPCION()%></blockquote></td></tr>
<tr>
    <td align="right" colspan="2"><hr style="{height: 1px;}"/><%
            if(ofel_inmueble!=null) {
                FEL_OFICINA oOficina = new FEL_OFICINA();
                oOficina.loadFromDB(_profile_.getIdOficina());

                %><table>
                <tr><td align="right">Le ha atendido <b><i><%=_profile_.getNombre()%> <%=_profile_.getApellido1()%></i></b>
                <br/><b><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></b> - <%=oOficina.getDIRECCION()+" - "+oOficina.getLOCALIDAD()%>. <b>Tfn.</b> <%=oOficina.getTELEFONO()==null?"-":oOficina.getTELEFONO()%><%=oOficina.getFAX()==null?"":", <b>Fax</b> "+oOficina.getFAX()%><%=oOficina.getEMAIL()==null?"":", <b>E-mail</b> "+oOficina.getEMAIL()%></b></td></tr>
                </table><%
            } else {
                %><table class="nota">
                <tr><td><b><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></b> - Oficinas en: </td></tr>
                <tr><td align="right"><%
                    Enumeration enum=FEL_OFICINA.getOficinas();
                    FEL_OFICINA o=null;
                    while(enum.hasMoreElements()) {
                        o=(FEL_OFICINA)enum.nextElement();
                        %><b><%=o.getDIRECCION()%> - <%=o.getLOCALIDAD()%></b>. Tfn. <%=o.getTELEFONO()==null?" - ":o.getTELEFONO()%><br/><%
                    }
                    %></td></tr>
                </table><%
            }
%></td>
</tr>
</table>
</div>
<form method="post" name="fmPDF" action="/gestinm/cvPDF" target="_blank"></form>
<table align="center"><tr><td><img src="/gestinm/images/pdf_file.png" onclick="javascript:document.fmPDF.submit();" alt="Ver PDF" style="{cursor: hand}"/>&nbsp;&nbsp;&nbsp;&nbsp;<img src="/gestinm/images/printer.png" onclick="javascript:imprimir()" alt="Imprimir" style="{cursor: hand}"/></td></td></tr>
</table>