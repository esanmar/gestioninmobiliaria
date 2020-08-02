<%
String acc=request.getParameter("acc");
if(acc==null)
    acc="inm";

 // Menú de segundo nivel
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=inf&acc=predef">Informes Predefinidos</a>]&nbsp;&nbsp;&nbsp;[<a href="index.jsp?tab=inf&acc=inm">Consulta Inmuebles</a>]
        </td>
    </tr>
</table><%

if (acc.equals("conf") || acc.equals("dis"))
{%>
<jsp:include page="/_admin/consultas/indexDis.jsp"/>
<%}
else if (acc.equals("show"))
{%>
<jsp:include page="/_admin/consultas/showTable.jsp"/>
<%}
else if (acc.equals("select"))
{%>
<jsp:include page="/_admin/consultas/select.jsp"/>
<%}
else if(acc.equals("show_rtado")) {

%><jsp:include page="/_admin/consultas/showSelect.jsp"/><%
}
//---------------- Informes predefinidos ----------------
else if(acc.equals("predef")) {

%><jsp:include page="/_admin/consultas/predef/index.jsp"/><%

} else if(acc.equals("prepar")) {

%><jsp:include page="/_admin/consultas/predef/params.jsp"/><%

}else if(acc.equals("preshow")) {

%><jsp:include page="/_admin/consultas/predef/showResults.jsp"/><%
}
//---------------- Informes 'libres' ----------------
else if(acc.equals("libre")) {
%><jsp:include page="/_admin/consultas/libre/index.jsp"/><%
}
else if(acc.equals("l_rtdo")) {
%><jsp:include page="/_admin/consultas/libre/results.jsp"/><%
}
//---------------- Informes de Inmuebles ----------------
else if(acc.equals("inm")) {
%><jsp:include page="/_admin/consultas/inm/consultaInm.jsp"/><%
}
//---------------- Construir Select de Inmuebles ----------------
else if(acc.equals("inmSel")) {
%><jsp:include page="/_admin/consultas/inm/selectInm.jsp"/><%
} else if(acc.equals("inm_rtado")) {

%><jsp:include page="/_admin/consultas/inm/showSelect.jsp"/><%
}

//---------------- Asigna Inmueble a Cliente ----------------
else if(acc.equals("clicons")) {
%><jsp:include page="/_admin/consultas/inm/fel_consulta_upd.jsp"/><%
}


%>