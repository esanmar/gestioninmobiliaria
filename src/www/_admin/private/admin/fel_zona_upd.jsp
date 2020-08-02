<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_zona" class="com.emesa.gestinm.dao.FEL_ZONA" scope="session" />
<jsp:setProperty name="ofel_zona" property="*" />
<%
System.out.println("ENTRA AL UPDATE...");
String sOp = request.getParameter("op");

//-- BORRADO --
boolean bError=false;
if(sOp.equals("del")) {
  try {
    ofel_zona.delete();
%>&nbsp;Se ha borrado el registro:<br/><%
  }
  catch(Exception e) {
    bError=true;
    %><span class="err"><br/>&nbsp;&nbsp;Error, no se ha podido actualizar el registro <em><%=ofel_zona.getZONA()%></em> en la BB.DD.<br/><br/></span><%
  }
}

//-- ACTUALIZACION --
else {
  try {
  System.out.println("ANTES DEL SAVE...");
    ofel_zona.saveToDB();
    %>&nbsp;Se ha actualizado el registro:<br/><%
  }
  catch(Exception e) {
    System.err.println("[fel_zona_upd.jsp] Error: "+e);
    bError=true;
%><span class="err"><br/>&nbsp;&nbsp;Error, no se ha podido actualizar el registro <em><%=ofel_zona.getZONA()%></em> en la BB.DD.<br/><br/></span><%
  }
}
if(!bError) {
%>
<table border="0">
  <tr>
    <td><b>Id. Zona</b>:</td>
    <td><%=ofel_zona.getID_ZONA()==-1?"":""+ofel_zona.getID_ZONA()%></td>
  </tr>
  <tr>
    <td><b>Zona</b>:</td>
    <td><%=ofel_zona.getZONA()==null?"":""+ofel_zona.getZONA()%></td>
  </tr>
  
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_zona");
}
%>
