<html lang="ES"><jsp:include page="/postLogin"/><%
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
boolean bMenu=true;
if(request.getParameter("top")!=null && !request.getParameter("top").trim().equals("")) {
    try {
        bMenu=(new Boolean(request.getParameter("top"))).booleanValue();
    }
    catch(Exception e) {
    }
}
%><head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-15">
	<meta name="author" content="emesa s.l.">
	<meta name="robots" content="NOINDEX, NOFOLLOW">
	<link rel="shortcut icon" href="/gestinm/images/icon/logo.ico" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="/gestinm/css/gestinm_admin.css">
	<title><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></title>
</head>
<body>
<script language="JavaScript" src="/gestinm/js/emesa.js"></script><%
if(bMenu) {
    %><%@include file="menu_top.jsp"%><%
}
%><table align="center" width="100%" align="right" cellpadding="0" cellspacing="0" class="colorEnabled" border="0">
    <tr>
        <td><jsp:include page="<%=sController%>"/></td>
    </tr>
</table>
<p class="footer">Realizado por <a href="http://www.emesa.com" target="_blank">emesa s.l.</a></p>
</body>
</html>