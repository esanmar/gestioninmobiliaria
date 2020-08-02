<%@page import="java.text.SimpleDateFormat"%>
<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_proveedor" class="com.emesa.gestinm.dao.FEL_PROVEEDOR" scope="session" />
<jsp:setProperty name="ofel_proveedor" property="*" />
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
    ofel_proveedor.delete(ofel_proveedor.getID_PROPIETARIO());
%>&nbsp;Se ha borrado el registro:<br/><%
  }
  catch(Exception e) {
    bError=true;
    %><span class="err"><br/>&nbsp;&nbsp;Error, no se ha podido borrar el registro <em><%=ofel_proveedor.getID_PROPIETARIO()%></em> de la BB.DD.<br/><br/></span><%
  }
}

//-- ACTUALIZACION --
else {
  try {
    ofel_proveedor.saveToDB();
    %>&nbsp;Se ha actualizado el registro:<br/><%
  }
  catch(Exception e) {
    System.err.println("[fel_proveedor_upd.jsp] Error: "+e);
    bError=true;
%><span class="err"><br/>&nbsp;&nbsp;Error, no se ha podido actualizar el registro <em><%=ofel_proveedor.getID_PROPIETARIO()%></em> en la BB.DD.<br/><br/></span><%
  }
}
if(!bError) {
%>
<table border="0" cellpadding="2">
  <tr>
    <td><b>Id. propietario</b>:</td>
    <td><%=ofel_proveedor.getID_PROPIETARIO()==-1?"":""+ofel_proveedor.getID_PROPIETARIO()%></td>
  </tr>
  <tr>
    <td><b>Fecha de alta</b></td>
    <td><%=ofel_proveedor.getShowFECHA_ALTA()%></td>
  </tr>
  <tr>
    <td><b>CIF</b>:</td>
    <td><%=ofel_proveedor.getCIF()==null?"":""+ofel_proveedor.getCIF()%></td>
  </tr>
  <tr>
    <td><b>Nombre persona de contacto</b>:</td>
    <td><%=ofel_proveedor.getPERSONA_CONTACTO()==null?"":""+ofel_proveedor.getPERSONA_CONTACTO()%></td>
  </tr>
  <tr>
    <td><b>Primer apellido persona de contacto</b>:</td>
    <td><%=ofel_proveedor.getCONTACTO_APEL1()==null?"":""+ofel_proveedor.getCONTACTO_APEL1()%></td>
  </tr>
  <tr>
    <td><b>Segundo apellido persona de contacto</b>:</td>
    <td><%=ofel_proveedor.getCONTACTO_APEL2()==null?"":""+ofel_proveedor.getCONTACTO_APEL2()%></td>
  </tr>
  <tr>
    <td><b>Nombre comercial</b>:</td>
    <td><%=ofel_proveedor.getNOMBRE_COMERCIAL()==null?"":""+ofel_proveedor.getNOMBRE_COMERCIAL()%></td>
  </tr>
  <tr>
    <td><b>Raz&oacute;n social</b>:</td>
    <td><%=ofel_proveedor.getRAZON_SOCIAL()==null?"":""+ofel_proveedor.getRAZON_SOCIAL()%></td>
  </tr>
  <tr>
    <td><b>Tel&eacute;fono</b>:</td>
    <td><%=ofel_proveedor.getTELEFONO()==null?"":""+ofel_proveedor.getTELEFONO()%></td>
  </tr>
  <tr>
    <td><b>Tel&eacute;fono 2</b>:</td>
    <td><%=ofel_proveedor.getTELEFONO2()==null?"":""+ofel_proveedor.getTELEFONO2()%></td>
  </tr>
  <tr>
    <td><b>Fax</b>:</td>
    <td><%=ofel_proveedor.getFAX()==null?"":""+ofel_proveedor.getFAX()%></td>
  </tr>
  <tr>
    <td><b>Domicilio</b>:</td>
    <td><%=ofel_proveedor.getDOMICILIO()==null?"":""+ofel_proveedor.getDOMICILIO()%></td>
  </tr>
  <tr>
    <td><b>Poblaci&oacute;n</b>:</td>
    <td><%=ofel_proveedor.getPOBLACION()==null?"":""+ofel_proveedor.getPOBLACION()%></td>
  </tr>
  <tr>
    <td><b>C.P.</b>:</td>
    <td><%=ofel_proveedor.getCP()%></td>
  </tr>
  <tr>
    <td><b>Provincia</b>:</td>
    <td><%=ofel_proveedor.getID_PROVINCIA()==-1?"":com.emesa.gestinm.bbdd.cache.CacheUtil.getProvincia(ofel_proveedor.getID_PROVINCIA())%></td>
  </tr>
  <tr>
    <td><b>Pa&iacute;s</b>:</td>
    <td><%=ofel_proveedor.getID_PAIS()==-1?"":com.emesa.gestinm.bbdd.cache.CacheUtil.getPais(ofel_proveedor.getID_PAIS())%></td>
  </tr>
  <tr>
    <td><b>Estado civil</b>: </td>
    <td><%=ofel_proveedor.getESTADO_CIVIL()%></td>
  </tr>
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_proveedor");
}
%>
