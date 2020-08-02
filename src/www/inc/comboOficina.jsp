<%@page import="com.emesa.gestinm.dao.FEL_OFICINA,java.util.Enumeration" %>
<%
String sSelected = request.getParameter("sel");
if(sSelected==null || sSelected.trim().equals(""))
	sSelected="-1";

Enumeration enum=FEL_OFICINA.getOficinas();
FEL_OFICINA o=null;
String sId = "-1";

%><select name="ID_OFICINA">
	<option value="<%=sId%>" <%=sSelected.equals(sId)?"selected=\"selected\"":""%>>-- Seleccione oficina --</option><%

	while(enum.hasMoreElements()) {
        o=(FEL_OFICINA)enum.nextElement();
	
    %><option value="<%=o.getID_OFICINA()%>"<%=sSelected.equals(""+o.getID_OFICINA())?" selected=\"selected\"":""%>><%=o.getNOMBRE()%></option><%
    
    }
 %></select>