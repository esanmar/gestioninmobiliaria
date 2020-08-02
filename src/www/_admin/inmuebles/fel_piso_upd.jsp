<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_piso" class="com.emesa.gestinm.dao.FEL_PISO" scope="session" />
<jsp:setProperty name="ofel_piso" property="*" />
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

if (request.getParameter("GARAJE")==null)
	ofel_piso.setGARAJE(0);
if (request.getParameter("ASCENSOR")==null)
	ofel_piso.setASCENSOR(0);
if (request.getParameter("TRASTERO")==null)
	ofel_piso.setTRASTERO(0);
if (request.getParameter("PORTERO")==null)
	ofel_piso.setPORTERO(0);
if (request.getParameter("PISCINA")==null)
	ofel_piso.setPISCINA(0);
if (request.getParameter("AIRE_ACONDICIONADO")==null)
	ofel_piso.setAIRE_ACONDICIONADO(0);
if (request.getParameter("COCINA_AMUEBLADA")==null)
	ofel_piso.setCOCINA_AMUEBLADA(0);
if (request.getParameter("EXTERIOR")==null)
	ofel_piso.setEXTERIOR(0);
if (request.getParameter("AMUEBLADO")==null)
	ofel_piso.setAMUEBLADO(0);

String sPrecio_Garaje=(String)request.getParameter("PRECIO_GARAJE");
if (sPrecio_Garaje==null || sPrecio_Garaje.equals(""))
{
	ofel_piso.setPRECIO_GARAJE("");
}

int nCodInm=-1;

//-- BORRADO --
boolean bError=false;
if(sOp.equals("del")) {
  try {
    // No se borra el registro, si no que simplemente se MARCA como borrado, y eso se hace en FEL_INMUEBLE
    //ofel_piso.delete(ofel_piso.getCODIGO());
%> (Se ha borrado el registro)<%
  }
  catch(Exception e) {
    bError=true;
    %><span class="err"> (Error, no se ha podido borrar el registro <b><%=ofel_piso.getCODIGO()%></b> de la BB.DD.)</span><%
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
    ofel_piso.setCODIGO(nCodInm);
    ofel_piso.saveToDB();
    %> (Se ha actualizado el registro)<%
  }
  catch(Exception e) {
    System.err.println("[fel_piso_upd.jsp] Error: "+e);
    bError=true;
%><span class="err"> (Error, no se ha podido actualizar el registro <b><%=ofel_piso.getCODIGO()%></b> en la BB.DD.)</span><%
  }
}
if(!bError) {
%>
<table border="0" cellpadding="5" align="center">
<tr><td><table border="1">
  <tr>
    <td><b>Calefacci&oacute;n</b>:</td>
    <td><%=ofel_piso.getCALEFACCION()==null?"":""+ofel_piso.getCALEFACCION()%></td>
  </tr>
  <tr>
    <td><b>Agua caliente</b>:</td>
    <td><%=ofel_piso.getAGUA_CALIENTE()==null?"":""+ofel_piso.getAGUA_CALIENTE()%></td>
  </tr>
  <tr>
    <td><b>Gastos comunidad</b>:</td>
    <td><%=ofel_piso.getGASTOS_COMUNIDAD()==null?" - ":""+ofel_piso.getGASTOS_COMUNIDAD()%></td>
  </tr>
  <tr>
    <td><b>Precio garaje</b>:</td>
    <td><%=ofel_piso.getPRECIO_GARAJE()==null?" - ":""+ofel_piso.getPRECIO_GARAJE()%></td>
  </tr>
</table></td>
    <td valign="top" rowspan="2"><table border="1">
          <tr>
            <td><b>Terraza</b>:</td>
            <td><%=ofel_piso.getTERRAZA()%> m<sup>2</sup></td>
          </tr>
          <tr><td height="5"/></tr>
          <tr>
            <td><b>Amueblado</b>:</td>
            <td><%=ofel_piso.getAMUEBLADO()==0?"No":"Si"%></td>
          </tr>
          <tr>
            <td><b>Ascensor</b>:</td>
            <td><%=ofel_piso.getASCENSOR()==0?"No":"Si"%></td>
          </tr>
          <tr>
            <td><b>Trastero</b>:</td>
            <td><%=ofel_piso.getTRASTERO()==0?"No":"Si"%></td>
          </tr>
          <tr>
            <td><b>Garaje</b>:</td>
            <td><%=ofel_piso.getGARAJE()==0?"No":"Si"%></td>
          </tr>
          <tr>
            <td><b>Portero</b>:</td>
            <td><%=ofel_piso.getPORTERO()==0?"No":"Si"%></td>
          </tr>
          <tr>
            <td><b>Piscina</b>:</td>
            <td><%=ofel_piso.getPISCINA()==0?"No":"Si"%></td>
          </tr>
          <tr>
            <td><b>Aire acondicionado</b>:</td>
            <td><%=ofel_piso.getAIRE_ACONDICIONADO()==0?"No":"Si"%></td>
          </tr>
          <tr>
            <td><b>Cocina amueblada</b>:</td>
            <td><%=ofel_piso.getCOCINA_AMUEBLADA()==0?"No":"Si"%></td>
          </tr>
    </table>
    </td>
</tr>

<td><table border="1" width="100%">
  <tr>
    <td><b>Antig&uuml;edad</b>:</td>
    <td><%=ofel_piso.getANTIGUEDAD()==-1?"":""+ofel_piso.getANTIGUEDAD()%></td>
  </tr>
  <tr>
    <td><b>Altura</b>:</td>
    <td><%=ofel_piso.getALTURA()==-1?"":""+ofel_piso.getALTURA()%></td>
  </tr>
  <%--tr>
    <td><b>N<sup>o</sup> habitaciones</b>:</td>
    <td><%=ofel_piso.getHABITACIONES()==-1?"":""+ofel_piso.getHABITACIONES()%></td>
  </tr--%>
  <tr>
    <td><b><b>N<sup>o</sup> dormitorios</b>:</td>
    <td><%=ofel_piso.getDORMITORIOS()==-1?"":""+ofel_piso.getDORMITORIOS()%></td>
  </tr>
  <tr>
    <td><b><b>N<sup>o</sup> ba&ntilde;os</b>:</td>
    <td><%=ofel_piso.getBANOS()==-1?"":""+ofel_piso.getBANOS()%></td>
  </tr>
  <tr>
    <td><b><b>N<sup>o</sup> aseos</b>:</td>
    <td><%=ofel_piso.getASEOS()==-1?"":""+ofel_piso.getASEOS()%></td>
  </tr>
    </table></td>
</tr>
</table><%

  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_piso");
}
%>
