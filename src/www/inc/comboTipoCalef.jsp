<%@page import="com.emesa.gestinm.bbdd.cache.CacheUtil,com.emesa.bbdd.cache.*,java.util.Vector"%>
<%
String sel=request.getParameter("sel");

if(sel==null || sel.equals("null") || sel.equals("-1") || sel.trim().equals("")) {
    sel="No indicado";
}

%><select name="CALEFACCION"><%
Vector v=QueryCache.get("calef").getQueryResults();
for(int i=0; i<v.size(); i++) {
%><option value="<%=((Vector)v.elementAt(i)).elementAt(1)%>"<%=sel.equalsIgnoreCase( ((Vector)v.elementAt(i)).elementAt(1).toString() )?" selected=\"true\"":""%>><%=((Vector)v.elementAt(i)).elementAt(1).toString()%></option><%
}
%></select>