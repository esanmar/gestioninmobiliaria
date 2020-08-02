<%
String acc=request.getParameter("acc");
if(acc==null)
    acc="";
    
if(acc.equals("")) {
 // Menú de segundo nivel
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=lunes">Refrescar</a>]</td>
    </tr>
</table><jsp:include page="/_admin/lunes/index.jsp"/><%
}
%>