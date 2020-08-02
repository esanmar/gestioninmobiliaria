<%@page import="com.emesa.dao.Informe,java.util.*"%>
<jsp:useBean id="_profile_" class="com.emesa.gestinm.portalframework.UserProfile" scope="session" />
<%
Vector vInformes=Informe.roleReports(_profile_.getTipoUsuario());
Informe o;

%><form method="post" action="index.jsp" name="fm">
<table>
<input type="hidden" name="tab" value="inf"/>
<input type="hidden" name="acc" value="prepar"/>
<tr><td>Informe:</td><td><select name="ID_CONSULTA"><%
for(int i=0;i<vInformes.size(); i++) {
    o=(Informe )vInformes.elementAt(i);
    %><option value="<%=o.getIdConsulta()%>"><%=o.getNombreConsulta()%></option><%
}
%></select></td><td><input type="submit" class="boton" value=" &raquo;&raquo; "/></td>
</tr>
</table>
</form>