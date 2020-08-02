<form method="post" action="index.jsp?tab=inf&acc=dis">
<table>
<tr>
	<td><i>Driver</i>:</td>
	<td><input type="text" name="driver" value="<%=com.emesa.Configuration.getProperty("db.odbc.driver")%>"/></td>
</tr>
<tr>
	<td>URL:</td>
	<td><input type="text" name="URL" value="<%=com.emesa.Configuration.getProperty("db.odbc.url")%>"/></td>
</tr>
<tr>
	<td>Usuario:</td>
	<td><input type="text" name="user" value="<%=com.emesa.Configuration.getProperty("db.odbc.user")%>"/></td>
</tr>
<tr>
	<td>Contrase&ntilde;a:</td>
	<td><input type="text" name="password" value="<%=com.emesa.Configuration.getProperty("db.odbc.password")%>"/></td>
</tr>
<tr>
	<td colspan="2" align="right"><input type="submit" value="Conectar" class="botonClaro"/></td>
</tr>
</table>
