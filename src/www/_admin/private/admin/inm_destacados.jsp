<%@page import="java.util.Vector,com.emesa.gestinm.dao.FEL_INMUEBLE,com.emesa.gestinm.dao.InmuebleDestacado"%><%

String sDel=request.getParameter("del");
String sAdd=request.getParameter("xCODIGO");

if(sDel!=null && !sDel.trim().equals("")) {
    try {
        InmuebleDestacado.del(Integer.parseInt(sDel));
        %><br/>&nbsp;&nbsp;<span class="nota">Eliminado el inmueble <b><%=sDel%></b>.<br/><%
    }
    catch(Exception e) {
        %><br/>&nbsp;&nbsp;<span class="err">Error al eliminar el inmueble destacado <b><%=sDel%></b>: <%=e%><br/><%
    }
}

if(sAdd!=null && !sAdd.trim().equals("")) {
    try {
        InmuebleDestacado.add(Integer.parseInt(sAdd));
        %><br/>&nbsp;&nbsp;<span class="nota">A&ntilde;adido el inmueble <b><%=sAdd%></b>.<br/><%
    }
    catch(Exception e) {
        %><br/>&nbsp;&nbsp;<span class="err">Error al a&ntilde;adir el inmueble <b><%=sAdd%></b>: <%=e%><br/><%
    }
}

Vector vInmuebles = InmuebleDestacado.getInmueblesDestacados();
FEL_INMUEBLE o=null;
%>
<script language="javascript">
<!--
function del(id) {
    document.fmDest.del.value=id;
    document.fmDest.submit();
}
function add() {
    if(document.fmAdd.xCODIGO.value=="")
        alert("Debe introducir un código de inmueble");
    else
        document.fmAdd.submit();
}

function viewPropery() {
    window.location.href="/gestinm/_admin/index.jsp?tab=inm&xCodigo="+document.fmAdd.xCODIGO.value;
}
//-->
</script>
<br/>
<table cellpadding="2" width="95%" align="center">
<tr>
    <th colspan="11">Inmuebles destacados</th>
</tr>
<tr>
    <th>C&oacute;d.</th>
    <th>Tipo</th>
    <th>Estado</th>
    <th>Zona</th>
    <th>Direcci&oacute;n</th>
    <th>Propietario</th>
    <th>Superficie</th>
    <th>Venta</th>
    <th>Alquiler</th>
    <th>Traspaso</th>
    <th/>
</tr>

<form method="post" action="index.jsp" name="fmDest">
<input type="hidden" name="tab" value="adm"/>
<input type="hidden" name="acc" value="dest"/>
<input type="hidden" name="del" value="-1"/><%

for(int i=0;i<vInmuebles.size(); i++) {
    o=(FEL_INMUEBLE)vInmuebles.elementAt(i);
    %><tr class="<%=(i%2!=0?"odd":"even")%>">
	<td align="center"><%=o.getCODIGO()%></td>
    <td><%=o.getTIPO()%></td>
    <td><%=o.getESTADO()%></td>
    <td><%=o.getZONA()%></td>
    <td><%=o.getDIRECCION()%>, <%=o.getNUMERO()%></td>
    <td align="center"><%=o.getCOD_PROPIETARIO()%></td>
    <td align="right"><%=o.getSUPERFICIE()%> m<sup>2</sup></td>
    <td align="right"><%=o.getPRECIO_VENTA()%> &euro;</td>
    <td align="right"><%=o.getPRECIO_ALQUILER()%> &euro;</td>
    <td align="right"><%=o.getPRECIO_TRASPASO()%> &euro;</td>
	<td align="center"><a href="javascript:del(<%=o.getCODIGO()%>);"><img src="/gestinm/images/x.gif" border="0" alt="Eliminar <%=o.getCODIGO()%>"/></a></td>
</tr><%
}
%></form>
</table>
<table width="95%" align="center">
<form method="post" action="index.jsp" name="fmAdd">
<input type="hidden" name="tab" value="adm"/>
<input type="hidden" name="acc" value="dest"/>
<tr class="marca" align="right">
    <td>C&oacute;d.: <input type="text" name="xCODIGO" size="5"/>&nbsp;&nbsp;&nbsp;&nbsp;[<a href="javascript:add();"> + </a>]&nbsp;&nbsp;&nbsp;[<a href="javascript:viewPropery()">Ver<sup>*</sup></a>]&nbsp;</td>
</tr>

</form></table>
<br/>
&nbsp;<span class="nota"><sup>*</sup> Para ver el inmueble, se le rediigir&aacute; a la secci&oacute;n de <em>Inmuebles</em>.</span>
<br/><br/>