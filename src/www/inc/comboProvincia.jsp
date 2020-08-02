<%@page import="com.emesa.bbdd.cache.*,
				java.util.Vector" %>
<%
String sSelected = request.getParameter("sel");
if(sSelected==null || sSelected.trim().equals("") || sSelected.trim().equals("-1") || sSelected.trim().equals("null"))
	sSelected="26";

CacheObject cache = QueryCache.get("provincias");
Vector vCats = cache.getQueryResults();
Vector vRowCat=null;
String sId = "-1";
%>
<select name="PROVINCIA">
	<option value="<%=sId%>" <%=sSelected.equals(sId)?"selected=\"selected\"":""%>>-- Seleccione --</option>
	<%
	for(int i=0; i<vCats.size(); i++) {
		vRowCat=(Vector)vCats.elementAt(i);
		sId = (String)vRowCat.firstElement();
	%>
	<option value="<%=sId%>" <%=sSelected.equals(sId)?"selected=\"selected\"":""%>><%=vRowCat.elementAt(1)%></option>
	<% } %>
</select>