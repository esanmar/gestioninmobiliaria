<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_inm_oficina" class="com.emesa.gestinm.dao.FEL_INM_OFICINA" scope="session" />
<jsp:setProperty name="ofel_inm_oficina" property="*" />
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
    //ofel_inm_oficina.delete(ofel_inm_oficina.getCODIGO());
%><p>Se ha borrado el registro:</p><%
  }
  catch(Exception e) {
    bError=true;
    %>&nbsp;(<span class="err">Error, no se ha podido borrar el registro <b><%=ofel_inm_oficina.getCODIGO()%></b> de la BB.DD.</span>)<br/><%
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
    ofel_inm_oficina.setCODIGO(nCodInm);

    // [19/09/2003] seh: set de 0 si los cb no están clickados
    if(request.getParameter("PREPARADO_OFICINA")==null)
        ofel_inm_oficina.setPREPARADO_OFICINA(0);
    if(request.getParameter("LUZ")==null)
        ofel_inm_oficina.setLUZ(0);
    if(request.getParameter("ASCENSOR")==null)
        ofel_inm_oficina.setASCENSOR(0);
    if(request.getParameter("PORTERO")==null)
        ofel_inm_oficina.setPORTERO(0);
    if(request.getParameter("TELEFONO")==null)
        ofel_inm_oficina.setTELEFONO(0);
    //-- eoseh
    ofel_inm_oficina.saveToDB();
    %>&nbsp;(Se ha actualizado el registro)<br/><%
  }
  catch(Exception e) {
    System.err.println("[fel_inm_oficina_upd.jsp] Error: "+e);
    bError=true;
%>&nbsp;(<span class="err">Error, no se ha podido actualizar el registro <b><%=ofel_inm_oficina.getCODIGO()%></b> en la BB.DD.</span>)<br/><%
  }
}
if(!bError) {
%>
<table border="0">
  <tr>
    <td><b>A&ntilde;o de construcci&oacute;n</b>:</td>
    <td><%=ofel_inm_oficina.getANTIGUEDAD()%></td>
  </tr>
  <tr>
    <td><b>N<sup>o</sup> de plantas</b>:</td>
    <td><%=ofel_inm_oficina.getNUM_PLANTAS()%></td>
  </tr>
  <tr>
    <td><b>Despachos</b>:</td>
    <td><%=ofel_inm_oficina.getDESPACHOS()%></td>
  </tr>
  <tr>
    <td><b>Ba&ntilde;os</b>:</td>
    <td><%=ofel_inm_oficina.getBANOS()%></td>
  </tr>
  <tr>
    <td><b>Preparado oficina</b>:</td>
    <td><%=ofel_inm_oficina.getPREPARADO_OFICINA()==1?"Si":"No"%></td>
  </tr>
  <tr>
    <td><b>Tel&eacute;fono</b>:</td>
    <td><%=ofel_inm_oficina.getTELEFONO()==1?"Si":"No"%></td>
  </tr>
  <tr>
    <td><b>Luz</b>:</td>
    <td><%=ofel_inm_oficina.getLUZ()==1?"Si":"No"%></td>
  </tr>
  <tr>
    <td><b>Ascensor</b>:</td>
    <td><%=ofel_inm_oficina.getASCENSOR()==1?"Si":"No"%></td>
  </tr>
  <tr>
    <td><b>Portero</b>:</td>
    <td><%=ofel_inm_oficina.getPORTERO()==1?"Si":"No"%></td>
  </tr>
  <tr>
    <td><b>Calefacci&oacute;n</b>:</td>
    <td><%=ofel_inm_oficina.getCALEFACCION()==null?"":""+ofel_inm_oficina.getCALEFACCION()%></td>
  </tr>
  <tr>
    <td><b>Agua caliente</b>:</td>
    <td><%=ofel_inm_oficina.getAGUA_CALIENTE()==null?"":""+ofel_inm_oficina.getAGUA_CALIENTE()%></td>
  </tr>
  <tr>
    <td><b>Gastos comunidad</b>:</td>
    <td><%=ofel_inm_oficina.getGASTOS_COMUNIDAD()==null?"":""+ofel_inm_oficina.getGASTOS_COMUNIDAD()%></td>
  </tr>
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_inm_oficina");
}
%>
