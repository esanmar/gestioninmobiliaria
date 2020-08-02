<%
String acc=request.getParameter("acc");
String sTipoInm = request.getParameter("ID_TIPO_INMUEBLE");
if (sTipoInm==null || sTipoInm.equals("null"))
	sTipoInm="-1";

if(acc==null)
    acc="";
if(acc.equals("")) {
 // Menú de segundo nivel
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="javascript:delSelected()">Eliminar</a>]&nbsp;&nbsp;&nbsp;&nbsp;[<a href="index.jsp?tab=inm&inv=true">Reestablecer</a>] &nbsp;[<a href="javascript:cargar('<%=sTipoInm%>');">Cargar</a>] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<a href="javascript:submitType('mod');">Guardar</a>]</td>
    </tr>
</table><jsp:include page="/_admin/inmuebles/index.jsp"/><%
} else if(acc.equals("upd")) {
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=inm">Volver</a>]</td>
    </tr>
</table><jsp:include page="/_admin/inmuebles/fel_inmueble_upd2.jsp"/><%
} else if(acc.equals("vc")) {
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=inm">Volver</a>]</td>
    </tr>
</table><jsp:include page="/_admin/inmuebles/vista_cliente.jsp"/><%
} else if(acc.equals("det")) {
    %><jsp:include page="/_admin/inmuebles/index.jsp"/><%
}%>