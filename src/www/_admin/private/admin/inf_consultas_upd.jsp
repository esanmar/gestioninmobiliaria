<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="oinf_consultas" class="com.emesa.dao.INF_CONSULTAS" scope="session" />
<jsp:setProperty name="oinf_consultas" property="*" /><%

String sOp = request.getParameter("op");

//-- BORRADO --
boolean bError=false;
if(sOp.equals("del")) {
  try {
    oinf_consultas.delete();
%>&nbsp;Se ha borrado el registro:<br/><%
  }
  catch(Exception e) {
    bError=true;
    %><span class="err">&nbsp;Error, no se ha podido borrar el registro <b><%=oinf_consultas.getNOMBRE()%></b> de la BB.DD.</span><br/><br/><% 
  }
}

//-- ACTUALIZACION --
else {
    try {
        oinf_consultas.saveToDB();
    %><p>Se ha actualizado el registro:</p><%
    }
    catch(Exception e) {
        System.err.println("[inf_consultas_upd.jsp] Error: "+e);
        bError=true;
%><span class="err">&nbsp;Error, no se ha podido actualizar el registro <b><%=oinf_consultas.getNOMBRE()%></b> en la BB.DD.</span><br/><br/><%
    }
}
if(!bError) {
%>
<table border="0">
  <tr>
    <td><b>Id. consulta</b>:</td>
    <td><%=oinf_consultas.getID_CONSULTA()==-1?"":""+oinf_consultas.getID_CONSULTA()%></td>
  </tr>
  <tr>
    <td><b>Nombre</b>:</td>
    <td><%=oinf_consultas.getNOMBRE()==null?"":""+oinf_consultas.getNOMBRE()%></td>
  </tr>
  <tr>
    <td valign="top"><b>Descripci&oacute;n</b>:</td>
    <td><%=oinf_consultas.getDESCRIPCION()==null?"":""+oinf_consultas.getDESCRIPCION()%></td>
  </tr>
  <tr>
    <td valign="top"><b><i>Query</i></b>:</td>
    <td><%=oinf_consultas.getQUERY()==null?"":""+oinf_consultas.getQUERY()%></td>
  </tr>
  <tr>
    <td><b>Id. BB.DD.</b>:</td>
    <td><%=oinf_consultas.getID_BBDD()==-1?"":""+oinf_consultas.getID_BBDD()%></td>
  </tr>
  <tr>
    <td><b>Tipo usuario</b>:</td>
    <td><%=oinf_consultas.getTIPO_USUARIO()==null?"":""+oinf_consultas.getTIPO_USUARIO()%></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("oinf_consultas");
}
%>
