<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_chalet" class="com.emesa.gestinm.dao.FEL_CHALET" scope="session" />
<jsp:setProperty name="ofel_chalet" property="*" />
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
    //ofel_chalet.delete(ofel_chalet.getCODIGO());
%>&nbsp;(Se ha borrado el registro)<br/><%
  }
  catch(Exception e) {
    bError=true;
    %>&nbsp;(<span class="err">Error, no se ha podido borrar el registro <b><%=ofel_chalet.getCODIGO()%></b> de la BB.DD.</span>)<br/><%
  }
}

//-- ACTUALIZACION --
else {
    String sNPlantas=request.getParameter("N_PLANTAS");
    if(sNPlantas==null)
        sNPlantas="0";
    try {
        ofel_chalet.setN_PLANTAS(Integer.parseInt(sNPlantas));
    }
    catch(Exception e) {
        log("[fel_chalet_upd.jsp] Error al parsear el número de plantas ("+sNPlantas+") del chalet");
    }
  try {
    // [19/09/2003] seh: Solo hacemos el load si el código del inmueble es -11
    if(ofel_inmueble.getCODIGO()==-1) {
        ofel_inmueble=ofel_inmueble.loadUniqueInm(sDireccion,sNumero,sBloque,sPiso,sLetra);
    }
    nCodInm=ofel_inmueble.getCODIGO();
    ofel_chalet.setCODIGO(nCodInm);
    // [19/09/2003] seh: set de 0 si los cb no están clickados
    if(request.getParameter("GARAJE")==null)
        ofel_chalet.setGARAJE(0);
    if(request.getParameter("PISCINA")==null)
        ofel_chalet.setPISCINA(0);
    if(request.getParameter("AMUEBLADO")==null)
        ofel_chalet.setAMUEBLADO(0);
    if(request.getParameter("AIRE_ACONDICIONADO")==null)
        ofel_chalet.setAIRE_ACONDICIONADO(0);
    if(request.getParameter("COCINA_AMUEBLADA")==null)
        ofel_chalet.setCOCINA_AMUEBLADA(0);
    if(request.getParameter("TELEFONO")==null)
        ofel_chalet.setTELEFONO(0);
    //-- eoseh

    ofel_chalet.saveToDB();
    %>&nbsp;(Se ha actualizado el registro)<br/><%
  }
  catch(Exception e) {
    System.err.println("[fel_chalet_upd.jsp] Error: "+e);
    bError=true;
%>&nbsp;(<span class="err">Error, no se ha podido actualizar el registro <b><%=ofel_chalet.getCODIGO()%></b> en la BB.DD.</span>)<br/><%
  }
}
if(!bError) {
%>
<table border="0" cellpadding="5">
    <tr>
        <td valign="top"><table border="1">
            <tr>
                <td><b>Calefacci&oacute;n</b>:</td>
                <td><%=ofel_chalet.getCALEFACCION()==null?"":""+ofel_chalet.getCALEFACCION()%></td>
            </tr>
            <tr>
                <td><b>Agua caliente</b>:</td>
                <td><%=ofel_chalet.getAGUA_CALIENTE()==null?"":""+ofel_chalet.getAGUA_CALIENTE()%></td>
            </tr>
            <tr>
                <td><b>Gastos comunidad</b>:</td>
                <td><%=ofel_chalet.getGASTOS_COMUNIDAD()==null?"":""+ofel_chalet.getGASTOS_COMUNIDAD()%> &euro;</td>
            </tr>
          <tr>
            <td><b>Carpinter&iacute;a Exterior</b>:</td>
            <td><%=ofel_chalet.getCARPINTERIA_EXTERIOR()==null?"":""+ofel_chalet.getCARPINTERIA_EXTERIOR()%></td>
          </tr>
          <tr>
            <td><b>Carpinter&iacute;a interior</b>:</td>
            <td><%=ofel_chalet.getCARPINTERIA_INTERIOR()==null?"":""+ofel_chalet.getCARPINTERIA_INTERIOR()%></td>
          </tr>
          <tr><td height="10"></td></tr>
          <tr>
            <td><b>Antig&uuml;edad</b>:</td>
            <td><%=ofel_chalet.getANTIGUEDAD()==-1?"":""+ofel_chalet.getANTIGUEDAD()%></td>
          </tr>
          <tr>
            <td><b>Superficie jard&iacute;n</b>:</td>
            <td><%=ofel_chalet.getSUP_JARDIN()==-1?"0":""+ofel_chalet.getSUP_JARDIN()%> m<sup>2</sup></td>
          </tr>
          <tr>
            <td><b>N<sup>o</sup> plantas</b>:</td>
            <td><%=ofel_chalet.getN_PLANTAS()==-1?"":""+ofel_chalet.getN_PLANTAS()%></td>
          </tr><%--
          <tr>
            <td><b>N<sup>o</sup> Habitaciones</b>:</td>
            <td><=ofel_chalet.getHABITACIONES()==-1?"":""+ofel_chalet.getHABITACIONES()></td>
          </tr>
          --%><tr>
            <td><b>N<sup>o</sup> Dormitorios</b>:</td>
            <td><%=ofel_chalet.getDORMITORIOS()%></td>
          </tr>
          <tr>
            <td><b>N<sup>o</sup> Ba&ntilde;os</b>:</td>
            <td><%=ofel_chalet.getBANOS()%></td>
          </tr>
          <tr>
            <td><b>N<sup>o</sup> Aseos</b>:</td>
            <td><%=ofel_chalet.getASEOS()%></td>
          </tr>
        </table></td>
        <td valign="top"><table border="1">
          <tr>
            <td><b>Amueblado</b>:</td>
            <td><%=ofel_chalet.getAMUEBLADO()==1?"Si":"No"%></td>
          </tr>
          <tr>
            <td><b>Garaje</b>:</td>
            <td><%=ofel_chalet.getGARAJE()==1?"Si":"No"%></td>
          </tr>
          <tr>
            <td><b>Piscina</b>:</td>
            <td><%=ofel_chalet.getPISCINA()==1?"Si":"No"%></td>
          </tr>
          <tr>
            <td><b>Tel&eacute;fono</b>:</td>
            <td><%=ofel_chalet.getTELEFONO()==1?"Si":"No"%></td>
          </tr>
          <tr>
            <td><b>Aire acondicionado</b>:</td>
            <td><%=ofel_chalet.getAIRE_ACONDICIONADO()==1?"Si":"No"%></td>
          </tr>
          <tr>
            <td><b>Cocina amueblada</b>:</td>
            <td><%=ofel_chalet.getCOCINA_AMUEBLADA()==1?"Si":"No"%></td>
          </tr>
        </table></td>
    </tr>
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_chalet");
}
%>
