<%@page import="com.emesa.gestinm.bbdd.cache.CacheUtil,com.emesa.bbdd.cache.*,java.util.Vector"%>
<%
String sel=request.getParameter("sel");
if(sel==null)
    sel="";
%>
<select name="ID_BBDD">
<option value=""<%=sel.equals("")?" selected=\"true\"":""%>>-- Elige BB.DD. --</option><%
Vector v=QueryCache.get("base_datos").getQueryResults();

for(int i=0; i<v.size(); i++) {
    %><option value="<%=((Vector)v.elementAt(i)).elementAt(0)%>"<%=sel.equals( ((Vector)v.elementAt(i)).elementAt(0).toString() )?" selected=\"true\"":""%>><%=((Vector)v.elementAt(i)).elementAt(1).toString()%></option><%
}
%></select>