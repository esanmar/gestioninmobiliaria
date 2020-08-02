<%
String acc=request.getParameter("acc");
if(acc==null)
    acc="";
String acc2=request.getParameter("acc2");
if(acc2==null)
    acc2="";
String op=request.getParameter("op");
if(op==null)
    op="";
if(acc.equals("")) {
 // Menú de segundo nivel
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=adm&acc=dest">Destacar inmueble</a>]
        &nbsp;[<a href="index.jsp?tab=adm&acc=db">BB.DD.</a>]
        &nbsp;[<a href="index.jsp?tab=adm&acc=inf">Consultas</a>]
        &nbsp;[<a href="index.jsp?tab=adm&acc=acc">Permisos acceso</a>]
        &nbsp;[<a href="index.jsp?tab=adm&acc=cac">Cach&eacute;</a>]
        &nbsp;[<a href="index.jsp?tab=adm&acc=zon">Zonas</a>]
        </td>
        <td align="right">
        [<a href="index.jsp?tab=adm&acc=inf2&acc2=conf">Informes Dise&ntilde;ables</a>]
        &nbsp;[<a href="index.jsp?tab=adm&acc=inf2&acc2=libre">Consulta libre</a>]<!--
        &nbsp;[<a href="index.jsp?tab=adm&acc=log">Trazas</a>]-->
        &nbsp;
        </td>
    </tr>
</table><jsp:include page="/_admin/private/admin/index.jsp"/><%

/*===========================================================================================
        BASE DE DATOS
*/
} else if(acc.equals("db")) {
    if(acc2.equals("")) {
 // Menú de segundo nivel
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="javascript:delSelected();">Eliminar</a>]&nbsp;&nbsp;&nbsp;[<a href="index.jsp?tab=adm&acc=db&inv=true">Reestablecer</a>] [<a href="javascript:cargar();">Cargar</a>] [<a href="javascript:submitType('mod');">Guardar</a>]&nbsp;</td>
    </tr>
    </table><jsp:include page="/_admin/private/admin/inf_bbdd.jsp"/><%
    }
    else if(acc2.equals("upd")) {
        %><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=adm&acc=db">Volver</a>]&nbsp;</td>
    </tr>
    </table><jsp:include page="/_admin/private/admin/inf_bbdd_upd.jsp"/><%
    }
}

/*===========================================================================================
        CONSULTAS/INFORMES
*/
else if(acc.equals("inf")) {
    if(acc2.equals("")) {
 // Menú de segundo nivel
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="javascript:delSelected();">Eliminar</a>]&nbsp;&nbsp;&nbsp;[<a href="index.jsp?tab=adm&acc=inf&inv=true">Reestablecer</a>] [<a href="javascript:cargar();">Cargar</a>] [<a href="javascript:submitType('mod');">Guardar</a>]&nbsp;</td>
        <td align="right">[<a href="javascript:testQuery();">Probar <i>query</i></a>]&nbsp;</td>
    </tr>
    </table><jsp:include page="/_admin/private/admin/inf_consultas.jsp"/><%
    }
    else if(acc2.equals("upd")) {
        %><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=adm&acc=inf">Volver</a>]&nbsp;</td>
    </tr>
    </table><jsp:include page="/_admin/private/admin/inf_params.jsp"/><%
    }
    else if(acc2.equals("upd2")) {
        %><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=adm&acc=inf">Volver</a>]&nbsp;</td>
    </tr>
    </table><jsp:include page="/_admin/private/admin/inf_params_upd.jsp"/><%
    }

}

/*===========================================================================================
        CONSULTAS DISEÑABLES Y LIBRES
*/
else if(acc.equals("inf2")) {
    %><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=adm">Volver</a>]&nbsp;</td>
    </tr>
    </table><%
    if (acc2.equals("conf") || acc2.equals("dis"))
    {%>
    <jsp:include page="/_admin/private/admin/consultas/indexDis.jsp"/>
    <%}
    else if (acc2.equals("show"))
    {%>
    <jsp:include page="/_admin/private/admin/consultas/showTable.jsp"/>
    <%}
    else if (acc2.equals("select"))
    {%>
    <jsp:include page="/_admin/private/admin/consultas/select.jsp"/>
    <%}
    else if(acc2.equals("show_rtado")) {
    %><jsp:include page="/_admin/private/admin/consultas/showSelect.jsp"/><%
    }

    else if(acc2.equals("libre")) {
        %><jsp:include page="/_admin/private/admin/consultas/libre/index.jsp"/><%
        }
        else if(acc2.equals("l_rtdo")) {
        %><jsp:include page="/_admin/private/admin/consultas/libre/results.jsp"/><%
        }

    }

/*===========================================================================================
        INMUEBLES DESTACADOS
*/
else if(acc.equals("dest")) {
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=adm">Volver</a>]&nbsp;</td>
    </tr>
    </table><jsp:include page="/_admin/private/admin/inm_destacados.jsp"/><%
}

/*===========================================================================================
        PERMISOS DE USUARIO
*/
else if(acc.equals("acc")) {
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=adm">Volver</a>]&nbsp;</td>
    </tr>
    </table><jsp:include page="/_admin/private/admin/access.jsp"/><%
}
/*===========================================================================================
        ACTUALIZA PERMISOS DE USUARIO
*/
else if(acc.equals("aupd")) {
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=adm">Volver</a>]&nbsp;</td>
    </tr>
    </table><jsp:include page="/_admin/private/admin/access_upd.jsp"/><%
}

/*===========================================================================================
        ACTUALIZA LA CACHÉ
*/
else if(acc.equals("cac")) {
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=adm">Volver</a>]&nbsp;</td>
    </tr>
    </table>
    <table cellpadding="2">
        <tr><%
        try {
            com.emesa.bbdd.cache.QueryCache.reloadAllQueries();
            %><td>Cach&eacute; actualizada con &eacute;xito.</td><%
        }
        catch(Exception e) {
            %><td class="err">Error al recargar la cach&eacute;: <%=e%></td><%
        }
        %></tr>
    </table>
<%
}
else if(acc.equals("zon") && op.equals("")) 
{
%>
<table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="javascript:delSelected()">Eliminar</a>]&nbsp;&nbsp;&nbsp;[<a href="index.jsp?tab=adm&acc=zon&inv=true">Reestablecer</a>] [<a href="javascript:cargar();">Cargar</a>] [<a href="javascript:submitType('mod');">Guardar</a>]&nbsp;</td>
    </tr>
</table><jsp:include page="/_admin/private/admin/indexZona.jsp"/><%
} else if(acc.equals("zon") && !op.equals("")) {
 // Menú de segundo nivel
%><table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=adm&acc=zon">Volver</a>]</td>
    </tr>
</table><jsp:include page="/_admin/private/admin/fel_zona_upd.jsp"/>    
<%
}
/*===========================================================================================
        FICHERO DE LOG
*/
else if(acc.equals("log")) 
{
%><!--<table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="submenu">
    <tr>
        <td>&nbsp;[<a href="index.jsp?tab=adm&acc=zon">Volver</a>]</td>
    </tr>
</table><jsp:include page="/_admin/private/admin/show_log.jsp"/>--><%
}

/*===========================================================================================
        MENSAJE A LA APLICACIÓN
*/
else if(acc.equals("msg")) 
{
    application.setAttribute("msg",request.getParameter("msg"));
%><jsp:include page="/_admin/private/admin/index.jsp"/><%}
%>
