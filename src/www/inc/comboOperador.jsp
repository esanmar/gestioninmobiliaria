<%

String prefix=request.getParameter("oper");
if(prefix==null)
    prefix="";

%>
<select name="_oper<%=prefix%>">
    <option value="-1">--Elige tipo--</option>
    <option value="=">Igual a</option>
    <option value=">">Mayor que</option>
    <option value="<">Menor que</option>
    <option value="!=">Distinto de</option>
    <option value="like">Que contenga</option>
</select>