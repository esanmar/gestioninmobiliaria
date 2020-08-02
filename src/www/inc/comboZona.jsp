<%@page import="com.emesa.bbdd.cache.*,java.util.Vector" %>
<%
String sSelected = request.getParameter("sel");
if(sSelected==null || sSelected.trim().equals("") || sSelected.trim().equals("-1") || sSelected.trim().equals("null"))
	sSelected="No Indicada";

CacheObject cache = QueryCache.get("zonas");
Vector vCats = cache.getQueryResults();
Vector vRowCat=null;
String sId = "-1";
%>
<select name="ZONA">
	<% if (sSelected.equals("No Indicada")) %>
		<option value="" selected="true">No Indicada</option>
	<%
	for(int i=0; i<vCats.size(); i++) {
		vRowCat=(Vector)vCats.elementAt(i);
		sId = (String)vRowCat.firstElement();
	%>
	<option value="<%=vRowCat.elementAt(1)%>" <%=sSelected.equalsIgnoreCase(vRowCat.elementAt(1).toString())?" selected=\"true\"":""%>><%=vRowCat.elementAt(1).toString()%></option>
	<% } %>
</select>