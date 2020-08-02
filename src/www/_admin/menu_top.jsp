
<jsp:useBean id="_profile_" class="com.emesa.gestinm.portalframework.UserProfile" scope="session" />

<table border="0" align="center" width="100%" align="right" cellpadding="0" cellspacing="0" class="bordeRojo">
    <tr><td align="left"><img src="/gestinm/images/logo_small.jpg" height="20" border="0" alt=""> <span class="inmTitle"><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></span></td><td align="right" height="10" colspan="2"><i><%=request.getRemoteUser()%></i>&nbsp;&nbsp;&nbsp;&nbsp;[ <a href="/gestinm/logout.jsp">Salir</a> ]&nbsp;</td></tr>
</table>
<table border="0" align="center" width="100%" align="right" cellpadding="0" cellspacing="0">
    <tr>
        <td class="<%=tab.equals("my")?"titEnabled":"titDisabled"%>"><a href="index.jsp?tab=my">Mi cartera</a></td>
        <td class="<%=tab.equals("inm")?"titEnabled":"titDisabled"%>"><a href="index.jsp?tab=inm">Inmuebles</a></td>
        <td class="<%=tab.equals("cli")?"titEnabled":"titDisabled"%>"><a href="index.jsp?tab=cli">Clientes</a></td>
        <td class="<%=tab.equals("prov")?"titEnabled":"titDisabled"%>"><a href="index.jsp?tab=prov">Propietarios</a></td>
        <td class="<%=tab.equals("inf")?"titEnabled":"titDisabled"%>"><a href="index.jsp?tab=inf">Consultas e informes</a></td>
        <td class="<%=tab.equals("diar")?"titEnabled":"titDisabled"%>"><a href="index.jsp?tab=diar">Diario Virtual</a></td>
        <td class="<%=tab.equals("lunes")?"titEnabled":"titDisabled"%>"><a href="index.jsp?tab=lunes">Diario Lunes</a></td>
        <%
        if(_profile_.getTipoUsuario().equals("ADMINISTRADOR"))        
    	{
    	%>
        	<td class="<%=tab.equals("us")?"titEnabled":"titPrivDisabled"%>"><a href="private/index.jsp?tab=us">Usuarios</a></td>
        	<td class="<%=tab.equals("ofi")?"titEnabled":"titPrivDisabled"%>"><a href="private/index.jsp?tab=ofi">Oficinas</a></td>
        	<td class="<%=tab.equals("adm")?"titEnabled":"titPrivDisabled"%>"><a href="private/index.jsp?tab=adm">Administraci&oacute;n</a></td>
    	<%
    	}
    	%>
    </tr>
</table>