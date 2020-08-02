<%
String sSelected = request.getParameter("sel");
if(sSelected==null || sSelected.trim().equals(""))
	sSelected="NC";
%>
<select name="ESTADO_CIVIL">
    <option value="NC" <%=sSelected.equals("NC")?"selected=\"selected\"":""%>>No consta</option>
	<option value="SOLTERO" <%=sSelected.equals("SOLTERO")?"selected=\"selected\"":""%>>Soltero/a</option>
    <option value="CASADO" <%=sSelected.equals("CASADO")?"selected=\"selected\"":""%>>Casado/a</option>
    <option value="VIUDO" <%=sSelected.equals("VIUDO")?"selected=\"selected\"":""%>>Viudo/a</option>
    <option value="DIVORCIADO" <%=sSelected.equals("DIVORCIADO")?"selected=\"selected\"":""%>>Divorciado/a</option>
</select>