<html lang="ES"><%
/* ###################################################
    Los Tab pueden ser:
        - my:   Mi cartera
        - inm:  Inmuebles
        - prov: Proveedores
        - inf:  Informes
################################################### */

String tab=request.getParameter("tab");
if(tab==null || tab.trim().equals(""))
    tab="my";
String sController="controllers/"+tab+"Controller.jsp";
%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15">
	<meta name="author" content="emesa s.l.">
	<meta name="robots" content="NOINDEX, NOFOLLOW">
	<link rel="shortcut icon" href="/gestinm/images/icon/logo.ico" type="image/x-icon"-->
	<link rel="stylesheet" type="text/css" href="/gestinm/css/gestinm_admin.css">
	<title><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></title>
</head>
<body>
<script language="JavaScript" src="/gestinm/js/emesa.js"></script>
<table border="0" align="center" width="100%" align="right" cellpadding="0" cellspacing="0" class="bordeRojo">
    <tr><td align="left"><img src="/gestinm/images/logo_small.jpg" height="20" border="0" alt=""> <span class="inmTitle"><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></span></td><td align="right" height="10" colspan="2"><i><%=request.getRemoteUser()%></i>&nbsp;&nbsp;&nbsp;&nbsp;[ <a href="/gestinm/logout.jsp">Salir</a> ]&nbsp;</td></tr>
</table>
<table border="0" align="center" width="100%" align="right" cellpadding="0" cellspacing="0">
    <tr>
        <td class="<%=tab.equals("my")?"titEnabled":"titDisabled"%>"><a href="../index.jsp?tab=my">Mi cartera</a></td>
        <td class="<%=tab.equals("inm")?"titEnabled":"titDisabled"%>"><a href="../index.jsp?tab=inm">Inmuebles</a></td>
        <td class="<%=tab.equals("cli")?"titEnabled":"titDisabled"%>"><a href="../index.jsp?tab=cli">Clientes</a></td>
        <td class="<%=tab.equals("prov")?"titEnabled":"titDisabled"%>"><a href="../index.jsp?tab=prov">Propietarios</a></td>
        <td class="<%=tab.equals("inf")?"titEnabled":"titDisabled"%>"><a href="../index.jsp?tab=inf">Consultas e informes</a></td>
        <td class="<%=tab.equals("diar")?"titEnabled":"titDisabled"%>"><a href="../index.jsp?tab=diar">Diario virtual</a></td>
        <td class="<%=tab.equals("lunes")?"titEnabled":"titDisabled"%>"><a href="../index.jsp?tab=lunes">Diario Lunes</a></td>
        <td class="<%=tab.equals("us")?"titEnabled":"titPrivDisabled"%>"><a href="index.jsp?tab=us">Usuarios</a></td>
        <td class="<%=tab.equals("ofi")?"titEnabled":"titPrivDisabled"%>"><a href="index.jsp?tab=ofi">Oficinas</a></td>
        <td class="<%=tab.equals("adm")?"titEnabled":"titPrivDisabled"%>"><a href="index.jsp?tab=adm">Administraci&oacute;n</a></td>
    </tr>
</table>
<table align="center" width="100%" align="right" cellpadding="0" cellspacing="0" class="colorEnabled" border="0">
    <!--tr><td height="10" colspan="2"/></tr-->
    <tr>
        <!--td width="10"></td-->
        <td><jsp:include page="<%=sController%>"/></td>
    </tr>
</table>
<p class="footer">Realizado por <a href="http://www.emesa.com">emesa s.l.</a></p>
</body>
</html>