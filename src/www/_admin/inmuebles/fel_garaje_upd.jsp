<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_garaje" class="com.emesa.gestinm.dao.FEL_GARAJE" scope="session" />
<jsp:setProperty name="ofel_garaje" property="*" />
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
    //ofel_garaje.delete(ofel_garaje.getCODIGO());
%>&nbsp;(Se ha borrado el registro:)<br/><%
  }
  catch(Exception e) {
    bError=true;
    %>&nbsp;(<span class="err">Error, no se ha podido borrar el registro <b><%=ofel_garaje.getCODIGO()%></b> de la BB.DD.</span>)<br/><%
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
    ofel_garaje.setCODIGO(nCodInm);
    // [19/09/2003] seh: Si no se ha indicado el vigilante, se hace set de 0
    if(request.getParameter("VIGILANTE")==null)
        ofel_garaje.setVIGILANTE(0);
    ofel_garaje.saveToDB();
    %>&nbsp;(Se ha actualizado el registro)<br/><%
  }
  catch(Exception e) {
    System.err.println("[fel_garaje_upd.jsp] Error: "+e);
    bError=true;
%>&nbsp;(<span class="err">Error, no se ha podido actualizar el registro <b><%=ofel_garaje.getCODIGO()%></b> en la BB.DD.</span><br/><%
  }
}
if(!bError) {

%><table border="0">
  <tr>
    <td><b>Vigilante</b>:</td>
    <td><%=ofel_garaje.getVIGILANTE()==0?"No":"Si"%></td>
  </tr>
  <tr>
    <td><b>N<up>o</sup> plazas</b>:</td>
    <td><%=ofel_garaje.getNUM_PLAZAS()%></td>
  </tr>
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_garaje");
}
%>
