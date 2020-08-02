<%@page import="java.text.SimpleDateFormat"%>
<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_cliente" class="com.emesa.gestinm.dao.FEL_CLIENTE" scope="session" />
<jsp:setProperty name="ofel_cliente" property="*" />
<body>
<%
String sFechaAlta=request.getParameter("xFECHA_ALTA");
if(sFechaAlta!=null && !sFechaAlta.trim().equals("")) {
    SimpleDateFormat sdf=new SimpleDateFormat(com.emesa.Configuration.getProperty("show.date_format"));
    ofel_proveedor.setFECHA_ALTA(sdf.parse(sFechaAlta));
}

String sOp = request.getParameter("op");

//-- BORRADO --
boolean bError=false;
if(sOp.equals("del")) {
  try {
    ofel_cliente.delete(ofel_cliente.getID_CLIENTE());
%>&nbsp;Se ha borrado el registro:<br/><%
  }
  catch(Exception e) {
    bError=true;
    %><span class="err"><br/>&nbsp;&nbsp;Error, no se ha podido borrar el registro <em><%=ofel_proveedor.getID_CLIENTE()%></em> de la BB.DD.<br/><br/></span><%
  }
}

//-- ACTUALIZACION --
else {
  try {
    ofel_cliente.saveToDB();
    %>&nbsp;Se ha actualizado el registro:<br/><%
  }
  catch(Exception e) {
    System.err.println("[fel_cliente_upd.jsp] Error: "+e);
    bError=true;
%><span class="err"><br/>&nbsp;&nbsp;Error, no se ha podido actualizar el registro <em><%=ofel_cliente.getID_CLIENTE()%></em> en la BB.DD.<br/><br/></span><%
  }
}
if(!bError) {
%>
<table border="0" cellpadding="2">
  <tr>
    <td><b>Id. Cliente</b>:</td>
    <td><%=ofel_cliente.getID_CLIENTE()==-1?"":""+ofel_cliente.getID_CLIENTE()%></td>
  </tr>
  <tr>
    <td><b>Fecha de alta</b></td>
    <td><%=ofel_cliente.getShowFECHA_ALTA()%></td>
  </tr>
  
  <tr>
    <td><b>Nombre</b>:</td>
    <td><%=ofel_cliente.getNombre()==null?"":""+ofel_cliente.getNombre()%></td>
  </tr>
  <tr>
    <td><b>Primer apellido</b>:</td>
    <td><%=ofel_cliente.getAPELLIDO1()==null?"":""+ofel_cliente.getAPELLIDO1()%></td>
  </tr>
  <tr>
    <td><b>Segundo apellido</b>:</td>
    <td><%=ofel_cliente.getAPELLIDO2()==null?"":""+ofel_cliente.getAPELLIDO2()%></td>
  </tr>
 
  <tr>
    <td><b>Tel&eacute;fono</b>:</td>
    <td><%=ofel_cliente.getTELEFONO()==null?"":""+ofel_cliente.getTELEFONO()%></td>
  </tr>
  <tr>
    <td><b>Tel&eacute;fono 2</b>:</td>
    <td><%=ofel_cliente.getTELEFONO2()==null?"":""+ofel_cliente.getTELEFONO2()%></td>
  </tr>
  <tr>
    <td><b>Fax</b>:</td>
    <td><%=ofel_cliente.getFAX()==null?"":""+ofel_cliente.getFAX()%></td>
  </tr>
  <tr>
    <td><b>Domicilio</b>:</td>
    <td><%=ofel_cliente.getDOMICILIO()==null?"":""+ofel_cliente.getDOMICILIO()%></td>
  </tr>
  <tr>
    <td><b>Poblaci&oacute;n</b>:</td>
    <td><%=ofel_cliente.getPOBLACION()==null?"":""+ofel_cliente.getPOBLACION()%></td>
  </tr>
  <tr>
    <td><b>C.P.</b>:</td>
    <td><%=ofel_cliente.getCP()%></td>
  </tr>
  <tr>
    <td><b>Provincia</b>:</td>
    <td><%=ofel_cliente.getID_PROVINCIA()==-1?"":com.emesa.gestinm.bbdd.cache.CacheUtil.getProvincia(ofel_cliente.getID_PROVINCIA())%></td>
  </tr>
  
  
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_cliente");
}
%>
