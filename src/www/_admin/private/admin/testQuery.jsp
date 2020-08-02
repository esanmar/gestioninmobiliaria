<%@page import="com.emesa.dao.INF_CONSULTAS,java.util.Vector,java.util.StringTokenizer"%>
<html>
<head><title>Test query</title>	<link rel="stylesheet" type="text/css" href="/gestinm/css/gestinm_admin.css"></head>
<body class="bgNaranja">
<%
String sQuery=request.getParameter("q");
String sIdBBDD=request.getParameter("db");
Vector vParams=new Vector();
if(sQuery.indexOf("?")!=-1) {
    String params=request.getParameter("p");
    StringTokenizer st=new StringTokenizer(params,",",false);
    while(st.hasMoreTokens()) {
        vParams.add(st.nextToken());
    }
}
%>
<table>
<tr>
	<td valign="top"><b><i>Query</i>:</td>
	<td><%=sQuery%></td>
</tr>
<tr>
	<td><b>Identificador de BB.DD.</b>:</td>
	<td><%=sIdBBDD%></td>
</tr>
<tr>
	<td valign="top"><b>Resultado</b>:</td>
	<td class="bordeVerde"><%
    try {
        Vector vRtado=com.emesa.dao.INF_CONSULTAS.test(Integer.parseInt(sIdBBDD),sQuery,vParams);

        if(vRtado!=null && !vRtado.isEmpty()) {
            %>Se han encontrado <b><%=vRtado.size()%></b> registros: <ol><%
            for(int i=0;i<vRtado.size(); i++) {
                %><li><%=vRtado.elementAt(i)%></li><%
            }
        }
        else {
            %><i>Se han encontrado <b>0</b> registros</i><%
        }
    }
    catch(Exception e) {
        %><span class="err">&nbsp;Se ha producido un error al ejecutar la <i>query</i>:<br/>&nbsp;<%=e%></span><%
    }
    %></td>
</tr>
<tr>
	<td colspan="2">&nbsp;</td>
</tr>
<tr>
	<td colspan="2" align="right"><input type="button" value="Cerrar" class="boton" onclick="javascript:window.close();"/></td>
</tr>
</table>
</body>
</html>