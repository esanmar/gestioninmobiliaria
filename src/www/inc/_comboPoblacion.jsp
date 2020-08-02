<%@page import="com.emesa.gestinm.bbdd.cache.CacheUtil,com.emesa.bbdd.cache.*,java.util.Vector"%><%

String sel=request.getParameter("sel");
if(sel==null || sel.equals("-1"))
    sel="-1";

QueryCache.reloadQuery("poblaciones");

%><select name="selPOBLACION"><%
Vector v=QueryCache.get("poblaciones").getQueryResults();
%><option value="">-- Poblaci&oacute;n --</option><%
String sPob="";
for(int i=0; i<v.size(); i++) {
    sPob=((Vector)v.elementAt(i)).elementAt(0).toString();
    %><option value="<%=sPob%>"<%=sel.equals(sPob)?" selected=\"true\"":""%>><%=sPob%></option><%
}
%></select>