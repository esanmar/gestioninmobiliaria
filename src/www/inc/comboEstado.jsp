<%@page import="com.emesa.bbdd.cache.*,
				java.util.Vector" %>
<%
String sSelected = request.getParameter("sel");

if(sSelected==null || sSelected.trim().equals("") || sSelected.trim().equals("-1") || sSelected.trim().equals("null") || sSelected.trim().equals("0"))
	sSelected="1";

CacheObject cache = QueryCache.get("inm_estado");
Vector vCats = cache.getQueryResults();
Vector vRowCat=null;
String sId = "99";
%>
<select name="ESTADO">
	<%
	for(int i=0; i<vCats.size(); i++) {
		vRowCat=(Vector)vCats.elementAt(i);
		sId = (String)vRowCat.firstElement();

    %><option value="<%=sId%>" <%=sSelected.equals(sId)?"selected=\"selected\"":""%>><%=vRowCat.elementAt(1)%></option><%
    } %>
</select>