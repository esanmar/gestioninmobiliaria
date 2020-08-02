<%@page import="java.util.Vector,com.emesa.bbdd.cache.QueryCache"%>
<%
String sel=request.getParameter("sel");

if(sel==null)
    sel="";
%>
<table class="bordeVerde"><%
Vector v=QueryCache.get("roles").getQueryResults();
String s=null;
for(int i=0; i<v.size(); i++) {
    s=((Vector)v.elementAt(i)).elementAt(1).toString();
    %><tr>
	<td><input type="checkbox" name="<%=s%>"<%=sel.indexOf(s)!=-1?" checked=\"true\"":""%>/> <%=s.replace('_',' ')%></td>
</tr><%
}
%></table>