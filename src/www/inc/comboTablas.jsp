<%@page import="com.emesa.gestinm.bbdd.cache.CacheUtil,com.emesa.bbdd.cache.*,java.util.Vector"%>
<%
String sel=request.getParameter("sel");
if(sel==null || sel.equals("-1"))
    sel=""+CacheUtil.getID_TIPO_USUARIO("INVITADO");
%>
<select name="ID_TIPO_USUARIO"><%
Vector v=QueryCache.get("roles").getQueryResults();

for(int i=0; i<v.size(); i++) {
    %><option value="<%=((Vector)v.elementAt(i)).elementAt(0)%>"<%=sel.equals( ((Vector)v.elementAt(i)).elementAt(0).toString() )?" selected=\"true\"":""%>><%=((Vector)v.elementAt(i)).elementAt(1).toString().replace('_',' ')%></option><%
}
%></select>