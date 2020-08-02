<%@page import="com.emesa.gestinm.dao.FEL_OFICINA"%>
<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_usuario" class="com.emesa.gestinm.dao.FEL_USUARIO" scope="session" />
<jsp:setProperty name="ofel_usuario" property="*" />
<%
String sOp = request.getParameter("op");

//-- BORRADO --
boolean bError=false;
if(sOp.equals("del")) {
  try {
    ofel_usuario.delete(ofel_usuario.getID_USUARIO()); // ## CHECK ##
%>&nbsp;&nbsp;Se ha borrado el registro:<br/><%
  }
  catch(Exception e) {
    bError=true;
    %><span class="err"><br/>Error, no se ha podido borrar el registro <b><%=ofel_usuario.getALIAS()%></b> de la BB.DD.<br/><br/><%
  }
}

//-- ACTUALIZACION --
else {
    String sNewPasswd = request.getParameter("newCLAVE");
    String sOldPasswd = request.getParameter("oldCLAVE");

    // Si ha habido un cambio de clave o es un nuevo usuario...
    if(!sNewPasswd.equals(sOldPasswd) ||
        ofel_usuario.getID_USUARIO()==-1)
    {
        ofel_usuario.setToEncryptCLAVE(sNewPasswd);
    }

  try {
    ofel_usuario.saveToDB();
    %>&nbsp;&nbsp;Se ha actualizado el registro:<br/><%
  }
  catch(Exception e) {
    System.err.println("[fel_usuario_upd.jsp] Error: "+e);
    bError=true;
%><span class="err"><br/>&nbsp;&nbsp;Error, no se ha podido actualizar el registro <b><%=ofel_usuario.getALIAS()%></b> en la BB.DD.<br/><br/><%
  }
}
if(!bError) {
%>
<table border="0">
  <tr>
    <td><b>Id. usuario</b>:</td>
    <td><%=ofel_usuario.getID_USUARIO()==-1?"":""+ofel_usuario.getID_USUARIO()%></td>
  </tr>
  <tr>
    <td><b>Alias</b>:</td>
    <td><%=ofel_usuario.getALIAS()==null?"":ofel_usuario.getALIAS()%></td>
  </tr>
  <tr>
    <td><b>Nombre</b>:</td>
    <td><%=ofel_usuario.getNOMBRE()==null?"":ofel_usuario.getNOMBRE()%></td>
  </tr>
  <tr>
    <td><b>Primer apellido</b>:</td>
    <td><%=ofel_usuario.getAPELLIDO1()==null?"":ofel_usuario.getAPELLIDO1()%></td>
  </tr>
  <tr>
    <td><b>Segundo apellido</b>:</td>
    <td><%=ofel_usuario.getAPELLIDO2()==null?"":ofel_usuario.getAPELLIDO2()%></td>
  </tr>
  <tr>
    <td><b>Tipo de usuario</b>:</td>
    <td><%=ofel_usuario.getID_TIPO_USUARIO()==-1?"":com.emesa.gestinm.bbdd.cache.CacheUtil.getTIPO_USUARIO(ofel_usuario.getID_TIPO_USUARIO())%></td>
  </tr>
  <tr>
    <td><b>Clave</b>:</td>
    <td><%=ofel_usuario.getCLAVE()==null?"":ofel_usuario.getCLAVE()%></td>
  </tr>
  <tr>
    <td><b>Oficina</b>:</td>
    <td><%=ofel_usuario.getID_OFICINA()==-1?"":(new FEL_OFICINA()).loadFromDB(ofel_usuario.getID_OFICINA(),false).getNOMBRE()%></td>
  </tr>
  <tr>
    <td><b>Direcci&oacute;n</b>:</td>
    <td><%=ofel_usuario.getDIRECCION()==null?"":ofel_usuario.getDIRECCION()%></td>
  </tr>
  <tr>
    <td><b>Localidad</b>:</td>
    <td><%=ofel_usuario.getLOCALIDAD()==null?"":ofel_usuario.getLOCALIDAD()%></td>
  </tr>
  <tr>
    <td><b>Provincia</b>:</td>
    <td><%=ofel_usuario.getID_PROVINCIA()==-1?"":com.emesa.gestinm.bbdd.cache.CacheUtil.getProvincia(ofel_usuario.getID_PROVINCIA())%></td>
  </tr>
  <tr>
    <td><b>C.P.</b>:</td>
    <td><%=ofel_usuario.getCP()==-1?"":""+ofel_usuario.getCP()%></td>
  </tr>
  <tr>
    <td><b>Tel&eacute;fono</b>:</td>
    <td><%=ofel_usuario.getTELEFONO()==null?"":""+ofel_usuario.getTELEFONO()%></td>
  </tr>
  <tr>
    <td><b><i>E-mail</i></b>:</td>
    <td><%=ofel_usuario.getEMAIL()==null?"":""+ofel_usuario.getEMAIL()%></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr><!--
  <tr>
    <td colspan="2" align="right"><input type="button" class="boton" value="Volver" onClick="javascript:window.location.href='index.jsp?tab=us'"/></td>
  </tr>-->
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_usuario");
}
%>
