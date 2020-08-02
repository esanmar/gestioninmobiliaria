<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_inm_nave" class="com.emesa.gestinm.dao.FEL_INM_NAVE" scope="session" />
<jsp:setProperty name="ofel_inm_nave" property="*" />
<jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" />
<jsp:setProperty name="ofel_inmueble" property="*" />
<%
String sOp = request.getParameter("op");

// Datos para la carga unica del Inmueble
String sDireccion=request.getParameter("DIRECCION");
String sNumero=request.getParameter("NUMERO");
String sBloque=request.getParameter("BLOQUE");
String sPiso=request.getParameter("PISO");
String sLetra=request.getParameter("LETRA");
int nCodInm=-1;

//-- BORRADO --
boolean bError=false;
if(sOp.equals("del")) {
  try {
    //ofel_inm_nave.delete(ofel_inm_nave.getCODIGO());
%>&nbsp;Se ha borrado el registro)<br/><%
  }
  catch(Exception e) {
    bError=true;
    %>&nbsp;(<span class="err">Error</span>, no se ha podido borrar el registro <b><%=ofel_inm_nave.getCODIGO()%></b> de la BB.DD.</span>)<br/><%
  }
}

//-- ACTUALIZACION --
else {
  try {
    // [19/09/2003] seh: Solo hacemos el load si el código del inmueble es -11
    if(ofel_inmueble.getCODIGO()==-1) {
        ofel_inmueble=ofel_inmueble.loadUniqueInm(sDireccion,sNumero,sBloque,sPiso,sLetra);
    }
    nCodInm=ofel_inmueble.getCODIGO();
    ofel_inm_nave.setCODIGO(nCodInm);
    // [19/09/2003] seh: set de 0 si los cb no están clickados
    if(request.getParameter("SALIDA_GASES")==null)
        ofel_inm_nave.setSALIDA_GASES(0);
    if(request.getParameter("SOTANO_ALMACEN")==null)
        ofel_inm_nave.setSOTANO_ALMACEN(0);
    if(request.getParameter("OFICINA")==null)
        ofel_inm_nave.setOFICINA(0);
    if(request.getParameter("AIRE_ACONDICIONADO")==null)
        ofel_inm_nave.setAIRE_ACONDICIONADO(0);
    if(request.getParameter("TELEFONO")==null)
        ofel_inm_nave.setTELEFONO(0);
    //-- eoseh

    ofel_inm_nave.saveToDB();
    %>&nbsp;(Se ha actualizado el registro)<br/><%
  }
  catch(Exception e) {
    System.err.println("[fel_inm_nave_upd.jsp] Error: "+e);
    bError=true;
%>&nbsp;(<span class="err">Error, no se ha podido actualizar el registro <b><%=ofel_inm_nave.getCODIGO()%></b> en la BB.DD.)<br/><%
  }
}
if(!bError) {
%>
<table border="0" cellpadding="5">
    <tr><td valign="top"><table border="1">
      <tr>
        <td><b>Sup. nave</b>:</td>
        <td><%=ofel_inm_nave.getSUP_NAVE()==-1?"":""+ofel_inm_nave.getSUP_NAVE()+" m<sup>2</sup>"%></td>
      </tr>
      <tr>
        <td><b>Funci&oacute;n actual</b>:</td>
        <td><%=ofel_inm_nave.getFUNCION_ACTUAL()==null?"":""+ofel_inm_nave.getFUNCION_ACTUAL()%></td>
      </tr>
    </table>
    </td>
    <td><table border="1">
  <tr>
    <td><b>Salida gases</b>:</td>
    <td><%=ofel_inm_nave.getSALIDA_GASES()==1?"Si":"No"%></td>
  </tr>
  <tr>
    <td><b>Sotano / almac&eacute;n</b>:</td>
    <td><%=ofel_inm_nave.getSOTANO_ALMACEN()==1?"Si":"No"%></td>
  </tr>
  <tr>
    <td><b>Tel&eacute;fono</b>:</td>
    <td><%=ofel_inm_nave.getTELEFONO()==1?"Si":"No"%></td>
  </tr>
  <tr>
    <td><b>Oficina</b>:</td>
    <td><%=ofel_inm_nave.getOFICINA()==1?"Si":"No"%></td>
  </tr>
  <tr>
    <td><b>Aire acondicionado</b>:</td>
    <td><%=ofel_inm_nave.getAIRE_ACONDICIONADO()==1?"Si":"No"%></td>
  </tr>
  </table>
  </td>
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_inm_nave");
}
%>
