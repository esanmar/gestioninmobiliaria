<!-- seh -->
<link rel="stylesheet" type="text/css" href="/gestinm/css/gestinm_admin.css">
<!-- eoseh -->
<%--
<script language="javascript">
<!--
function saveAll() {
    document.fmNotaA.del.value="false";
    document.fmNotaA.submit();

    document.fmNotaB.del.value="false";
    document.fmNotaB.submit();

    document.fmNotaC.del.value="false";
    document.fmNotaC.submit();

    document.fmNotaD.del.value="false";
    document.fmNotaD.submit();

    document.fmNotaE.del.value="false";
    document.fmNotaE.submit();

    document.fmNotaF.del.value="false";
    document.fmNotaF.submit();

    document.fmNotaG.del.value="false";
    document.fmNotaG.submit();

    document.fmNotaH.del.value="false";
    document.fmNotaH.submit();

    document.fmNotaI.del.value="false";
    document.fmNotaI.submit();

    document.fmNotaJ.del.value="false";
    document.fmNotaJ.submit();
}
//-->
</script>
--%>
<table width="100%" class="bordeVerde">
    <tr><td colspan="2" align="center">[<a href="#A-B">A-B</a>] [<a href="#C-D">C-D</a>] [<a href="#E-F">E-F</a>] [<a href="#G-H">G-H</a>] [<a href="#I-J">I-J</a>]</td></tr>
    <%--tr><td colspan="2" class="marca" align="right">[<a href="javascript:saveAll();">Guardar todas las notas</a>]&nbsp;</td></tr--%>
    <tr><a name="A-B"></a>
        <td width="50%" valign="top">
            <jsp:include page="notaA.jsp"/>
        </td>
        <td width="50%" valign="top">
            <jsp:include page="notaB.jsp"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" height="10"></td>
    </tr><%

    //-------- SEGUNDA FILA DE NOTAS

    %><tr><a name="C-D"></a>
        <td valign="top">
            <jsp:include page="notaC.jsp"/>
        </td>
        <td valign="top">
            <jsp:include page="notaD.jsp"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" height="10"></td>
    </tr><%

    //-------- TERCERA FILA DE NOTAS

    %><tr><a name="E-F"></a>
        <td valign="top">
        <jsp:include page="notaE.jsp"/>
        </td>
        <td valign="top">
        <jsp:include page="notaF.jsp"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" height="10"></td>
    </tr><%

    //-------- CUARTA FILA DE NOTAS

    %><tr><a name="G-H"></a>
        <td valign="top">
            <jsp:include page="notaG.jsp"/>
        </td>
        <td valign="top">
            <jsp:include page="notaH.jsp"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" height="10"></td>
    </tr><%

    //-------- QUINTA FILA DE NOTAS

    %><tr><a name="I-J"></a>
        <td valign="top">
            <jsp:include page="notaI.jsp"/>
        </td>
        <td valign="top">
            <jsp:include page="notaJ.jsp"/>
        </td>
    </tr>
</table>