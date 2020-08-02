<%
String sel=request.getParameter("sel");
if(sel==null)
    sel="text";
String name=request.getParameter("name");
if(name==null)
    name="TIPO_PARAM";
%>
<select name="<%=name%>">
    <option value="text"<%=sel.equals("text")?" selected=\"true\"":""%>>Texto</option>
    <option value="vendedor"<%=sel.equals("vendedor")?" selected=\"true\"":""%>>Vendedor</option>
    <option value="oficina"<%=sel.equals("oficina")?" selected=\"true\"":""%>>Oficina</option>
    <option value="fecha"<%=sel.equals("fecha")?" selected=\"true\"":""%>>Fecha</option>
    <option value="provincia"<%=sel.equals("provincia")?" selected=\"true\"":""%>>Provincia</option>
    <option value="pais"<%=sel.equals("pais")?" selected=\"true\"":""%>>Pa&iacute;s</option>
</select>