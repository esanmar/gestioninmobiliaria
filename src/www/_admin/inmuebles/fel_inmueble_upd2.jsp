<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>
<jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" />
<jsp:setProperty name="ofel_inmueble" property="*" />
<%
String sOp = request.getParameter("op");

//-- BORRADO --
boolean bError=false;
if(sOp.equals("del")) {
  try {
    ofel_inmueble.delete(ofel_inmueble.getCODIGO());
%>&nbsp;&nbsp;Se ha borrado el registro:<br/><%
  }
  catch(Exception e) {
    bError=true;
    %><span class="err">&nbsp;&nbsp;Error, no se ha podido borrar el registro <b><%=ofel_inmueble.getCODIGO()%></b> de la BB.DD.<br/></span><%
  }
}

//-- ACTUALIZACION --
else {
    if(request.getParameter("ZONA")==null || request.getParameter("ZONA").trim().equals(""))
        ofel_inmueble.setZONA("");
    if(request.getParameter("NUMERO")==null || request.getParameter("NUMERO").trim().equals(""))
        ofel_inmueble.setNUMERO("");
    if(request.getParameter("NOTAS")==null || request.getParameter("NOTAS").trim().equals(""))
        ofel_inmueble.setNOTAS("");

    if(request.getParameter("LLAVES")==null || request.getParameter("LLAVES").trim().equals(""))
        ofel_inmueble.setLLAVES("");

    if(request.getParameter("DESCRIPCION")==null || request.getParameter("DESCRIPCION").trim().equals(""))
        ofel_inmueble.setDESCRIPCION("");

    if(request.getParameter("xFECHA_RESERVA")==null || request.getParameter("xFECHA_RESERVA").trim().equals("")) {
        ofel_inmueble.setFECHA_RESERVA(null);
    }
    else {
        ofel_inmueble.setFormatFECHA_RESERVA(request.getParameter("xFECHA_RESERVA"));
    }

    if(request.getParameter("xFECHA_VENCIMIENTO")==null || request.getParameter("xFECHA_VENCIMIENTO").trim().equals("")) {
        ofel_inmueble.setFECHA_VENCIMIENTO(null);
    }
    else {
        ofel_inmueble.setFormatFECHA_VENCIMIENTO(request.getParameter("xFECHA_VENCIMIENTO"));
    }


    if(request.getParameter("RESERVADO_POR")!=null && request.getParameter("RESERVADO_POR").trim().equals(""))
        ofel_inmueble.setRESERVADO_POR("");
    if(request.getParameter("EN_EXCLUSIVA")!=null && request.getParameter("EN_EXCLUSIVA").trim().equals("1"))
        ofel_inmueble.setEN_EXCLUSIVA(true);
    else
        ofel_inmueble.setEN_EXCLUSIVA(false);
    try {
        ofel_inmueble.saveToDB();
    %>&nbsp;&nbsp;Se ha actualizado el registro:<br/><%
    }
    catch(Exception e) {
        System.err.println("[fel_inmueble_upd.jsp] Error: "+e);
        bError=true;
%><span class="err">&nbsp;&nbsp;Error, no se ha podido actualizar el registro <b><%=ofel_inmueble.getCODIGO()%></b> en la BB.DD.<br/></span><%
  }
}
if(!bError) {
%>
<table border="0" cellpadding="5">
<!-- ############################
    Fila 1-->
<tr>
<td width="40%"><table class="destacado">
      <tr>
        <td><b>C&oacute;digo</b>:</td>
        <td><%=ofel_inmueble.getCODIGO()==-1?"":""+ofel_inmueble.getCODIGO()%></td>
      </tr>
      <tr>
        <td><b>Tipo</b>:</td>
        <td><%=ofel_inmueble.getTIPO()==null?"":""+ofel_inmueble.getTIPO()%></td>
      </tr>
      <tr>
        <td valign="top"><b>Direccion completa</b>:</td>
        <td><%=ofel_inmueble.getTIPO_VIA()==null||ofel_inmueble.getTIPO_VIA().equals("-1")?"":""+ofel_inmueble.getTIPO_VIA()%> <%=ofel_inmueble.getDIRECCION()==null?"":""+ofel_inmueble.getDIRECCION()%> n<sup>o</sup> <%=ofel_inmueble.getNUMERO()==null?"-":""+ofel_inmueble.getNUMERO()%>, piso <%=ofel_inmueble.getPISO()==null?"-":""+ofel_inmueble.getPISO()%>, letra <%=ofel_inmueble.getLETRA()==null?"-":""+ofel_inmueble.getLETRA()%>, bloque <%=ofel_inmueble.getBLOQUE()==null?"-":""+ofel_inmueble.getBLOQUE()%></td>
      </tr>
      <tr>
        <td><b>Estado</b>:</td>
        <td><%=ofel_inmueble.getESTADO()==-1?"":""+com.emesa.gestinm.bbdd.cache.CacheUtil.getEstado(ofel_inmueble.getESTADO())%></td>
      </tr>
      <tr>
        <td><b>En exclusiva</b>:</td>
        <td><%=ofel_inmueble.getEN_EXCLUSIVA()?" Si ":" No "%></td>
      </tr>
  </table></td>

  <td valign="top"><table border="1">
      <tr>
        <td><b>Provincia</b>:</td>
        <td><% // seh: Hasta que las provincias no estén como código...
        String sProv=ofel_inmueble.getPROVINCIA();
        try {
            if(sProv!=null) {
                %><%=com.emesa.gestinm.bbdd.cache.CacheUtil.getProvincia(Integer.parseInt(ofel_inmueble.getPROVINCIA()))%><%
            }
            else
                sProv="-";
        }
        catch(Exception e) {
            %><%=sProv%><%
            }%></td>
      </tr>
      <tr>
        <td><b>Poblaci&oacute;n</b>:</td>
        <td><%=ofel_inmueble.getPOBLACION()==null?"":""+ofel_inmueble.getPOBLACION()%></td>
      </tr>
      <tr>
        <td><b>Zona</b>:</td>
        <td><%=ofel_inmueble.getZONA()==null?"":""+ofel_inmueble.getZONA()%></td>
      </tr>
        <tr>
        <td><b>C&oacute;d. postal</b>:</td>
        <td><%=ofel_inmueble.getCOD_POSTAL()==null?"":""+ofel_inmueble.getCOD_POSTAL()%></td>
      </tr>
  </table></td>
  <td valign="top"><table border="1">
      <tr>
        <td><b>Ultima modificaci&oacute;n</b>:</td>
        <td><%=ofel_inmueble.getULTIMA_MODIFICACION()==null?"":""+ofel_inmueble.getShowULTIMA_MODIFICACION()%></td>
      </tr>
      <tr>
        <td><b>Modificado</b>:</td>
        <td><%=ofel_inmueble.getMODIFICADO()?"Si":"No"%></td>
      </tr>
  </table></td>
</tr>

<!-- ###########################3
    Fila 2-->
<tr>
    <td><table border="1">
      <tr>
        <td><b>Precio venta</b>:</td>
        <td><%=ofel_inmueble.getPRECIO_VENTA()%> &euro;</td>
      </tr>
      <tr>
        <td><b>Precio alquiler</b>:</td>
        <td><%=ofel_inmueble.getPRECIO_ALQUILER()%> &euro;</td>
      </tr>
      <tr>
        <td><b>Precio traspaso</b>:</td>
        <td><%=ofel_inmueble.getPRECIO_TRASPASO()%> &euro;</td>
      </tr>
    </table></td>
    <td><table border="1">
        <tr>
            <td><b>Cod. Propietario</b>:</td>
            <td><%=ofel_inmueble.getCOD_PROPIETARIO()==-1?"":""+ofel_inmueble.getCOD_PROPIETARIO()%></td>
        </tr>
        <tr>
            <td><b>Fecha reserva</b>:</td>
            <td><%=ofel_inmueble.getFECHA_RESERVA()==null?"":""+ofel_inmueble.getShowFECHA_RESERVA()%></td>
        </tr>
        <tr>
            <td><b>Fecha vencimiento</b>:</td>
            <td><%=ofel_inmueble.getFECHA_VENCIMIENTO()==null?"":""+ofel_inmueble.getShowFECHA_VENCIMIENTO()%></td>
        </tr>
        <tr>
            <td><b>Reservado por</b>:</td>
            <td><%=ofel_inmueble.getRESERVADO_POR()==null?"":""+ofel_inmueble.getRESERVADO_POR()%></td>
        </tr>
    </table></td>
    <td><table border="1">
      <tr>
        <td><b>Superficie</b>:</td>
        <td><%=ofel_inmueble.getSUPERFICIE()==-1?"":""+ofel_inmueble.getSUPERFICIE()%>  m<sup>2</sup></td>
      </tr>
      <tr>
        <td><b>Sup construida</b>:</td>
        <td><%=ofel_inmueble.getSUP_CONSTRUIDA()==-1?"":""+ofel_inmueble.getSUP_CONSTRUIDA()%>  m<sup>2</sup></td>
      </tr>
      <tr>
        <td><b>Sup util</b>:</td>
        <td><%=ofel_inmueble.getSUP_UTIL()==-1?"":""+ofel_inmueble.getSUP_UTIL()%> m<sup>2</sup></td>
      </tr>
    </table></td>
</tr>

<!-- ###########################3
    Fila 3-->
  <tr>
    <td valign="top"><table border="1">
        <tr>
        <td><b>Vendedor</b>:</td>
        <td><%=ofel_inmueble.getVENDEDOR()==null || ofel_inmueble.getVENDEDOR().trim().equals("-1")?"<i>Sin vendedor</i>":""+ofel_inmueble.getVENDEDOR()%></td>
      </tr>
      <tr>
        <td valign="top"><b>Notas</b>:</td>
        <td><%=ofel_inmueble.getNOTAS()==null?"":""+ofel_inmueble.getNOTAS()%></td>
      </tr>
      <tr>
        <td><b>Llaves</b>:</td>
        <td><%=ofel_inmueble.getLLAVES()==null?"":""+ofel_inmueble.getLLAVES()%></td>
      </tr>
      <tr>
        <td valign="top"><b>Descripci&oacute;n</b>:</td>
        <td><%=ofel_inmueble.getDESCRIPCION()==null?"":""+ofel_inmueble.getDESCRIPCION()%></td>
      </tr>
   </table></td>
   <td colspan="2" valign="top" class="bordeRojo">&nbsp;<b><%=ofel_inmueble.getTIPO()%></b>
    <%
    /*###################################################################

      Aquí miramos el TIPO DE INMUEBLE e incluimos la JSP que lo actualice
      Hay que considerar que DEBE ser transaccional!!
    */
        String sUpdToInclude="fel_"+ofel_inmueble.getTIPO().toLowerCase().replace('á','a').replace('ú','u').replace('/','_').replace(' ','_')+"_upd.jsp";
        %><jsp:include page="<%=sUpdToInclude%>"/>
   </td>
</tr>
<tr><td colspan="3"></td></tr>
</table>
<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("ofel_inmueble");
}
%>
