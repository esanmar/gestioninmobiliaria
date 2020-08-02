<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_oficina" class="com.emesa.gestinm.dao.FEL_OFICINA" scope="session" />
<jsp:setProperty name="ofel_oficina" property="*" />
<%
String sOp = request.getParameter("op");

//-- BORRADO --
boolean bError=false;
if(sOp.equals("del")) {
  try {
    ofel_oficina.delete();
%>&nbsp;Se ha borrado el registro:<br/><%
  }
  catch(Exception e) {
    bError=true;
    %><span class="err"><br/>&nbsp;&nbsp;Error, no se ha podido actualizar el registro <em><%=ofel_oficina.getNOMBRE()%></em> en la BB.DD.<br/><br/></span><%
  }
}

//-- ACTUALIZACION --
else {
  try {
    ofel_oficina.saveToDB();
    %>&nbsp;Se ha actualizado el registro:<br/><%
  }
  catch(Exception e) {
    System.err.println("[fel_oficina_upd.jsp] Error: "+e);
    bError=true;
%><span class="err"><br/>&nbsp;&nbsp;Error, no se ha podido actualizar el registro <em><%=ofel_oficina.getNOMBRE()%></em> en la BB.DD.<br/><br/></span><%
  }
}
if(!bError) {
%>
<table border="0">
  <tr>
    <td><b>Id. oficina</b>:</td>
    <td><%=ofel_oficina.getID_OFICINA()==-1?"":""+ofel_oficina.getID_OFICINA()%></td>
  </tr>
  <tr>
    <td><b>Nombre</b>:</td>
    <td><%=ofel_oficina.getNOMBRE()==null?"":""+ofel_oficina.getNOMBRE()%></td>
  </tr>
  <tr>
    <td><b>Direcci&oacute;n</b>:</td>
    <td><%=ofel_oficina.getDIRECCION()==null?"":""+ofel_oficina.getDIRECCION()%></td>
  </tr>
  <tr>
    <td><b>Tel&eacute;fono</b>:</td>
    <td><%=ofel_oficina.getTELEFONO()==null?"":""+ofel_oficina.getTELEFONO()%></td>
  </tr>
  <tr>
    <td><b>Fax</b>:</td>
    <td><%=ofel_oficina.getFAX()==null?"":""+ofel_oficina.getFAX()%></td>
  </tr>
  <tr>
    <td><b><i>E-mail</i></b>:</td>
    <td><%=ofel_oficina.getEMAIL()==null?"":""+ofel_oficina.getEMAIL()%></td>
  </tr>
  <tr>
    <td><b>Localidad</b>:</td>
    <td><%=ofel_oficina.getLOCALIDAD()==null?"":""+ofel_oficina.getLOCALIDAD()%></td>
  </tr>
  <tr>
    <td><b>Provincia</b>:</td>
    <td><%=ofel_oficina.getID_PROVINCIA()==-1?"":""+com.emesa.gestinm.bbdd.cache.CacheUtil.getProvincia(ofel_oficina.getID_PROVINCIA())%></td>
  </tr>
  <tr>
    <td><b>C.P.</b>:</td>
    <td><%=ofel_oficina.getCP()==-1?"":""+ofel_oficina.getCP()%></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr><!--
  <tr>
    <td colspan="2" align="right"><input type="button" class="boton" value="Volver" onClick="javascript:window.location.href='index.jsp?tab=ofi'"/></td>
  </tr>-->
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_oficina");
}
%>
