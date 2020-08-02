<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="oinf_bbdd" class="com.emesa.dao.INF_BBDD" scope="session" />
<jsp:setProperty name="oinf_bbdd" property="*" />
<%
String sOp = request.getParameter("op");

//-- BORRADO --
boolean bError=false;
if(sOp.equals("del")) {
  try {
    oinf_bbdd.delete();
%><p>Se ha borrado el registro:</p><%
  }
  catch(Exception e) {
    bError=true;
    %><p><span class="err">Error</span>, no se ha podido borrar el registro <b><%=oinf_bbdd.getNOMBRE()%></b> de la BB.DD.</p><% // ## CHECK ##
  }
}

//-- ACTUALIZACION --
else {
    try {
        if(request.getParameter("JNDI")==null || request.getParameter("JNDI").trim().equals(""))
            oinf_bbdd.setJNDI(null);

        oinf_bbdd.saveToDB();
    %><p>Se ha actualizado el registro:</p><%
    }
    catch(Exception e) {
        System.err.println("[inf_bbdd_upd.jsp] Error: "+e);
        bError=true;
%><p class="err">Error, no se ha podido actualizar el registro <b><%=oinf_bbdd.getNOMBRE()%></b> en la BB.DD.</p><%
  }
}
if(!bError) {
%>
<table border="0">
  <tr>
    <td><b>Id. base de datos</b>:</td>
    <td><%=oinf_bbdd.getID_BBDD()==-1?"":""+oinf_bbdd.getID_BBDD()%></td>
  </tr>
  <tr>
    <td><b>Nombre</b>:</td>
    <td><%=oinf_bbdd.getNOMBRE()==null?"":oinf_bbdd.getNOMBRE()%></td>
  </tr>
  <tr>
    <td><b>JNDI</b>:</td>
    <td><%=oinf_bbdd.getJNDI()==null?"":oinf_bbdd.getJNDI()%></td>
  </tr>
  <tr>
    <td><b><i>Driver</i></b>:</td>
    <td><%=oinf_bbdd.getDRIVER()==null?"":oinf_bbdd.getDRIVER()%></td>
  </tr>
  <tr>
    <td><b>URL</b>:</td>
    <td><%=oinf_bbdd.getURL()==null?"":oinf_bbdd.getURL()%></td>
  </tr>
  <tr>
    <td><b>Usuario</b>:</td>
    <td><%=oinf_bbdd.getUSUARIO()==null?"":oinf_bbdd.getUSUARIO()%></td>
  </tr>
  <tr>
    <td><b>Contrase&ntilde;a</b>:</td>
    <td><%=oinf_bbdd.getCLAVE()==null?"":oinf_bbdd.getCLAVE()%></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("oinf_bbdd");
}
%>
