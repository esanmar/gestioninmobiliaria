<html>
<head>
    <title><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></title>
    <link href="/gestinm/css/gestinm_admin.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript" src="/gestinm/js/md5.js"></script>
<script language="javascript">
<!--
function crypSubmit() {
	document.loginForm.j_password.value=hex_md5(document.loginForm.j_password.value);
    document.loginForm.action="<%=response.encodeURL("j_security_check")%>";
	document.loginForm.submit();
}
//-->
</script><%

String sErr = request.getParameter("err");
if(sErr==null)
	sErr="";

Integer nErr = (Integer)session.getAttribute("nerr");
if(nErr==null) {
	nErr = new Integer(0);
	session.setAttribute("nerr",nErr);
}
else if(nErr.intValue() >= 3) {
	response.sendRedirect("/gestinm");
}

%><body class="bodyEnabled"><% 
if(!sErr.trim().equals("")) { 
	session.setAttribute("nerr" ,new Integer(nErr.intValue()+1) );

%><table width="800" align="center" class="bordeRojo"><tr><td class="verde">&nbsp;&nbsp;<b>Error: </b>Usuario/clave incorrectos (<%=nErr.intValue()+1%><sup>o</sup> intento de 3)</td></tr></table><%
}
%><table border="0" width="750" align="center" class="bordeVerde">
    <tr>
        <td width="150" height="180">
            <img src="/gestinm/images/foto1.jpg" width="150" height="180" border="1"></a>
        </td>
        <td rowspan="3">
            <table align="center">
            <tr align="center">
                <td><img src="/gestinm/images/logo.gif" border="0" alt="<%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%>"></td><td valign="middle"  class="title"><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></a></td>
            </tr>
            <tr>
			    <td colspan="2" align="center" valign="middle" class="subtitle"><%=com.emesa.gestinm.Customization.getProperty("gestinm.subtitle")%></td>
            </tr>
            </table><br/>
            <form method="post" action="javascript:;" onsubmit="javascript:crypSubmit();" name="loginForm">
                <table align="center">
                    <tr>
                        <td align="right">Usuario:</td><td><input type="text" name="j_username"/></td>
                    <script language="JavaScript">
                    <!--
                    document.loginForm.j_username.focus();
                    //-->
                    </script>
                    </tr>
                    <tr>
                        <td align="right">Clave:</td><td><input type="password" name="j_password"/>
                    </tr>
                    <tr>
                       <td colspan="2" align="right">
                            <input type="submit" class="boton" value="Aceptar"/>
                            <input type="reset" class="boton"/>
                       </td>
                     </tr>
                  </table>
            </form>
        </td>
    </tr>
    <tr>
        <td height="2"></td>
        <td></td>
    </tr>
    <tr>
        <td width="150" height="180">
            <img src="/gestinm/images/foto2.jpg" width="150" height="180" border="1">
        </td>
        <td/>
    </tr>
    <tr>
        <td colspan="2" class="verde" align="right">&copy; 2003 - 2004 <a href="http://www.emesa.com">emesa s.l.</a></td>
    </tr>
</table>
