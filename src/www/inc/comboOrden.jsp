<%
String orden=request.getParameter("orden");
if(orden==null)
    orden="-1";
%>
<select name="_orden<%=orden%>">
    <option value="-1">--Elige tipo--</option>
    <option value="asc">Ascendente</option>
    <option value="desc">Descendente</option>
</select>