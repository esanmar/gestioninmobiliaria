<%@ page isErrorPage="true" %>
<html>
<head>
<title><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%> - Error</title>
	<link href="/gestinm/css/gestinm_admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table width="700" align="center" class="pagError" cellpadding="3">
    <tr>
        <td align="center" valign="middle"><img src="/gestinm/images/bigX.gif" width="100" height="100" border="0" alt=""></td>
        <td>Se ha producido un error al tramitar la petici&oacute;n, por favor disculpe las molestias.</td>
    </tr>
    <tr>
        <td colspan="2" valign="top" class="bordeTopRojo">
            <table class="pagError"><%
                StackTraceElement[] stElems = exception.getStackTrace();
                if(stElems.length>0) {
                    //log("["+exception.toString()+"] "+stElems[0].toString());

                %><tr><td colspan="2"><b><%=exception%></b></td></tr>
                <tr><td colspan="2"><b><%=stElems[0]%></b></td></tr><%
                }
                for(int i=1; i<stElems.length; i++) {
                    //log(stElems[i].toString());

                %><tr>
                        <td width="40"></td>
                        <td><%=stElems[i]%></td>
                    </tr><%
                    }
            %></table>
        </td>
    </tr>
    <tr>
        <td class="verde" colspan="2" align="right">&copy; 2004 - <a href="<%=com.emesa.gestinm.Customization.getProperty("gestinm.url")%>"><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></a></td>
    </tr>
</table>
</body>
</html>
