<%
String acc=request.getParameter("acc");
if(acc==null)
    acc="";
if(acc.equals("")) {
 // Menú de segundo nivel
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="javascript:delSelected();">Eliminar</a>]&nbsp;&nbsp;&nbsp;[<a href="index.jsp?tab=us&inv=true">Reestablecer</a>] [<a href="javascript:cargar();">Cargar</a>] [<a href="javascript:submitType('mod');">Guardar</a>]&nbsp;</td>
    </tr>
</table><jsp:include page="/_admin/private/usuarios/index.jsp"/><%
} else if(acc.equals("upd")) {
 // Menú de segundo nivel
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=us">Volver</a>]</td>
    </tr>
</table><jsp:include page="/_admin/private/usuarios/fel_usuario_upd.jsp"/><%
}%>
