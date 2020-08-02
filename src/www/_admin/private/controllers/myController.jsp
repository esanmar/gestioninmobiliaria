<%
String acc=request.getParameter("acc");
if(acc==null)
    acc="";

if(acc.equals("refresh")) {
    %><jsp:useBean id="_profile_" class="com.emesa.gestinm.portalframework.UserProfile" scope="session" /><%
//    _profile_.refreshMiCartera();
}
// Menú de segundo nivel
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>[ <a href="../index.jsp?tab=my&acc=refresh">Refrescar</a> ]</td>
    </tr>
</table><jsp:include page="/_admin/personal/index.jsp"/>