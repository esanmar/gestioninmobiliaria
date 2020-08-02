<%@page import="java.util.*"%>
<%@ page contentType="application/vnd.ms-excel" %>
<%
Vector vHeader=(Vector)session.getAttribute("inf_header");
Vector vRtado=(Vector)session.getAttribute("inf_rtado");
String sNombreConsulta=(String)session.getAttribute("inf_nombre");
String sDescripcionConsulta=(String)session.getAttribute("inf_descripcion");
%>
<table>
<tr> 
<%
for (int i=0 ; i<vHeader.size(); i++)
{
%>
	<td width="94" nowrap bgcolor="#5A695A" >
	<font color="#FFFFFF"><b>
	<%=vHeader.elementAt(i)%>
	</b></font>
	</td>

<%}%>
</tr>
</table>

<table border="2" bordercolor="#FF9A00">
<%
Vector vRow = null;
for(int j=0;j<vRtado.size();j++)
{
	vRow=(Vector)vRtado.elementAt(j);
%>
	<tr>
<%	for(int t=0;t<vRow.size();t++)
	{
		if (vRow.elementAt(t)!=null)
		{
%>
			<td width="94" bordercolor="#FF9A00" >
			<font color="#000000"><b>
			<div align="center">
			<%=vRow.elementAt(t) + "\t"%>
			</div>
			</b></font>
			</td>
	      <%} else {%>
	      
			<td width="94" bordercolor="#FF9A00" >
			<font color="#000000"><b>
			<div align="center">
			0
			</div>
			</b></font>
			</td>
		<%}
	} %>
	</tr>
<%}%>
</table>
