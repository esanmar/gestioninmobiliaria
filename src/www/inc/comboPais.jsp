<%@page import="com.emesa.bbdd.cache.*,
				com.emesa.Configuration,
				java.util.Vector" %>
<%
String sSelected = request.getParameter("sel");
if(sSelected==null || sSelected.trim().equals("") || sSelected.trim().equals("-1"))
	sSelected="48"; // 48: España

CacheObject cache = QueryCache.get("paises");
Vector vCats = cache.getQueryResults();
Vector vRowCat=null;
String sId = "0";
%>
<select name="ID_PAIS">
	<%
	for(int i=0; i<vCats.size(); i++) {
		vRowCat=(Vector)vCats.elementAt(i);
		sId = (String)vRowCat.firstElement();
	%>
	<option value="<%=sId%>" <%=sSelected.equals(sId)?"selected=\"selected\"":""%>><%=vRowCat.elementAt(1)%></option>
	<% } %>
</select>