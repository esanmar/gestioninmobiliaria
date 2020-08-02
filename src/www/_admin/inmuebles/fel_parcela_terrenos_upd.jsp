<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_parcela" class="com.emesa.gestinm.dao.FEL_PARCELA" scope="session" />
<jsp:setProperty name="ofel_parcela" property="*" />
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

if (request.getParameter("URBANIZABLE")==null)
	ofel_parcela.setURBANIZABLE(0);
if (request.getParameter("AGRICOLA")==null)
	ofel_parcela.setAGRICOLA(0);
if (request.getParameter("DESAGUES")==null)
	ofel_parcela.setDESAGUES(0);
if (request.getParameter("RESIDENCIA")==null)
	ofel_parcela.setRESIDENCIA(0);
if (request.getParameter("VALLADO")==null)
	ofel_parcela.setVALLADO(0);
	
//-- BORRADO --
boolean bError=false;
if(sOp.equals("del")) {
  try {
    //ofel_parcela.delete(ofel_parcela.getCODIGO());
%>&nbsp;(Se ha borrado el registro)<br/><%
  }
  catch(Exception e) {
    bError=true;
    %>&nbsp;(<span class="err">Error, no se ha podido borrar el registro <b><%=ofel_parcela.getCODIGO()%></b> de la BB.DD.)</span><br/><%
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
    ofel_parcela.setCODIGO(nCodInm);
    ofel_parcela.saveToDB();
    %>&nbsp;(Se ha actualizado el registro)<br/><%
  }
  catch(Exception e) {
    System.err.println("[fel_parcela_upd.jsp] Error: "+e);
    bError=true;
%>&nbsp;(<span class="err">Error, no se ha podido actualizar el registro <b><%=ofel_parcela.getCODIGO()%></b> en la BB.DD.)<br/><%
  }
}
if(!bError) {
%>
<table border="0" cellpadding="5">
<tr>
    <td valign="top"><table border="1">
      <tr>
        <td><b>Antig&uuml;edad</b>:</td>
        <td><%=ofel_parcela.getANTIGUEDAD()==-1?"":""+ofel_parcela.getANTIGUEDAD(   )%></td>
      </tr>
      <tr>
        <td><b>Hectareas</b>:</td>
        <td><%=ofel_parcela.getHECTAREAS()==-1?"":""+ofel_parcela.getHECTAREAS()%></td>
      </tr>
      <tr>
        <td><b>Urbanizable</b>:</td>
        <td><%=ofel_parcela.getURBANIZABLE()==1?"Si":"No"%></td>
      </tr>
      <tr>
        <td><b>Toma agua</b>:</td>
        <td><%=ofel_parcela.getTOMA_AGUA()==null?"":""+ofel_parcela.getTOMA_AGUA()%></td>
      </tr>
      <tr>
        <td><b>Toma luz</b>:</td>
        <td><%=ofel_parcela.getTOMA_LUZ()==null?"":""+ofel_parcela.getTOMA_LUZ()%></td>
      </tr>
    </td></table>
    <td valign="top"><table border="1">
      <tr>
        <td><b>Agricola</b>:</td>
        <td><%=ofel_parcela.getAGRICOLA()==1?"Si":"No"%></td>
      </tr>
      <tr>
        <td><b>Desag&uuml;es</b>:</td>
        <td><%=ofel_parcela.getDESAGUES()==1?"Si":"No"%></td>
      </tr>
      <tr>
        <td><b>Residencia</b>:</td>
        <td><%=ofel_parcela.getRESIDENCIA()==1?"Si":"No"%></td>
      </tr>
      <tr>
        <td><b>Vallado</b>:</td>
        <td><%=ofel_parcela.getVALLADO()==1?"Si":"No"%></td>
      </tr>
    </table></td>
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_parcela");
}
%>
