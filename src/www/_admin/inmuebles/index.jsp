<%@page import="java.util.Vector,java.util.Date,com.emesa.bbdd.cache.QueryCache"%>
<script language="javascript">
<!--
function checkForm() {
    var sErrorMsg="Los siguientes campos contienen errores:";

    if(document.fmUpdate.TIPO.value=="" || document.fmUpdate.TIPO.value=="-1" ||document.fmUpdate.TIPO.value=="null") {
        sErrorMsg += "\n  - Es necesario indicar el tipo del inmueble";
    }
    if(document.fmUpdate.POBLACION.value=="") {
        sErrorMsg += "\n  - Poblacion no puede estar vacío";
    }
    if(document.fmUpdate.ESTADO.value=="") {
        sErrorMsg += "\n  - Estado no puede estar vacío";
    }
    if(document.fmUpdate.DIRECCION.value=="") {
        sErrorMsg += "\n  - Direccion no puede estar vacío";
    }
    if(document.fmUpdate.TIPO.value=="") {
        sErrorMsg += "\n  - Tipo no puede estar vacío";
    }
    if(document.fmUpdate.COD_PROPIETARIO.value=="") {
        //sErrorMsg += "\n  - Cod_Propietario no puede estar vacío";
        document.fmUpdate.COD_PROPIETARIO.value="-1";
    }
    if(document.fmUpdate.PROVINCIA.value=="") {
        sErrorMsg += "\n  - Provincia no puede estar vacío";
    }
    /*if(document.fmUpdate.ZONA.value=="") {
        sErrorMsg += "\n  - Zona no puede estar vacío";
    }*/
    // [17/09/2003] seh
    if(document.fmUpdate.xFECHA_RESERVA.value!="" && !checkDate(document.fmUpdate.xFECHA_RESERVA.value,'/')) {
        sErrorMsg += "\n  - Formato de la fecha de reserva: dd/mm/aaaa";
    }
    if(document.fmUpdate.xFECHA_VENCIMIENTO.value!="" && !checkDate(document.fmUpdate.xFECHA_VENCIMIENTO.value,'/')) {
        sErrorMsg += "\n  - Formnato de la fecha de vencimiento: dd/mm/aaaa";
    }
    if(document.fmUpdate.SUPERFICIE.value!="" && !chekInteger(document.fmUpdate.SUPERFICIE.value)) {
        sErrorMsg += "\n  - La superficie debe ser un entero";
    }
    if(document.fmUpdate.SUP_CONSTRUIDA.value!="" && !chekInteger(document.fmUpdate.SUP_CONSTRUIDA.value)) {
        sErrorMsg += "\n  - La superficie construida debe ser un entero";
    }
    if(document.fmUpdate.SUP_UTIL.value!="" && !chekInteger(document.fmUpdate.SUP_UTIL.value)) {
        sErrorMsg += "\n  - La superficie debe ser un entero";
    }
    if (typeof document.fmUpdate.ALTURA != "undefined" &&  document.fmUpdate.ALTURA.value != "" && !chekInteger(document.fmUpdate.ALTURA.value)) {
    	sErrorMsg += "\n  - La altura del inmueble debe ser un número";
	}
    
    if (typeof document.fmUpdate.PRECIO_VENTA != "undefined" &&  document.fmUpdate.PRECIO_VENTA.value != "" && !chekFloat(document.fmUpdate.PRECIO_VENTA.value)) {
    	sErrorMsg += "\n  - El precio del inmueble debe ser un número";
    }
    
    if (typeof document.fmUpdate.PRECIO_ALQUILER != "undefined" &&  document.fmUpdate.PRECIO_ALQUILER.value != "" && !chekFloat(document.fmUpdate.PRECIO_ALQUILER.value)) {
    	sErrorMsg += "\n  - El precio del inmueble debe ser un número";
    }
	
    if (typeof document.fmUpdate.PRECIO_TRASPASO != "undefined" &&  document.fmUpdate.PRECIO_TRASPASO.value != "" && !chekFloat(document.fmUpdate.PRECIO_TRASPASO.value)) {
    	sErrorMsg += "\n  - El precio del inmueble debe ser un número";
    }
    // [08/10/2003] seh
    if (typeof document.fmUpdate.ANTIGUEDAD != "undefined" &&  document.fmUpdate.ANTIGUEDAD.value != "" && !chekInteger(document.fmUpdate.ANTIGUEDAD.value)) {
    	sErrorMsg += "\n  - La antigüedad del inmueble debe ser un número entero";
    }
    if (typeof document.fmUpdate.DORMITORIOS != "undefined" &&  document.fmUpdate.DORMITORIOS.value != "" && !chekInteger(document.fmUpdate.DORMITORIOS.value)) {
    	sErrorMsg += "\n  - El número de dormitorios del inmueble debe ser un entero";
    }
    if (typeof document.fmUpdate.BANOS != "undefined" &&  document.fmUpdate.BANOS.value != "" && !chekInteger(document.fmUpdate.BANOS.value)) {
    	sErrorMsg += "\n  - El número de baños del inmueble debe ser un entero";
    }
    if (typeof document.fmUpdate.ASEOS != "undefined" &&  document.fmUpdate.ASEOS.value != "" && !chekInteger(document.fmUpdate.ASEOS.value)) {
    	sErrorMsg += "\n  - El número de aseos del inmueble debe ser un entero";
    }
    if (typeof document.fmUpdate.TERRAZA != "undefined" &&  document.fmUpdate.TERRAZA.value != "" && !chekFloat(document.fmUpdate.TERRAZA.value)) {
    	sErrorMsg += "\n  - El campo TERRAZA debe ser un número (use el punto para indicar decimal)";
    }
    if (typeof document.fmUpdate.SUP_NAVE != "undefined" &&  document.fmUpdate.SUP_NAVE.value != "" && !chekInteger(document.fmUpdate.SUP_NAVE.value)) {
    	sErrorMsg += "\n  - La superficie del local o nave debe ser un entero";
    }
    // eoseh
    if(sErrorMsg!="Los siguientes campos contienen errores:") {
        alert(sErrorMsg);
        return false;
    }
    else {
        return true;
    }
}


function checkId() {
    if(document.fmId.xCodigo.value=="") {
        return false;
    }
    else {
        return true;
    }
}

function cargar(tipoInm) {
    if( (document.fmId.xCodigo.value=="") && (document.fmId.xNumero.value=="") && (document.fmId.xDireccion.value=="") && (document.fmId.xReferencia.value==""))
    {
        alert ("Error: \n  - Debe indicar al menos un criterio de carga");
    }
    else if(tipoInm=="PISO"){
        document.fmId.ID_TIPO_INMUEBLE.value="PISO";
        document.fmId.submit();
    } else if(tipoInm=="CHALET"){
    	document.fmId.ID_TIPO_INMUEBLE.value="CHALET";
    	document.fmId.submit();
    } else if(tipoInm=="PARCELA/TERRENOS"){
    	document.fmId.ID_TIPO_INMUEBLE.value="PARCELA/TERRENOS";
    	document.fmId.submit();
    } else if(tipoInm=="OFICINA"){
    	document.fmId.ID_TIPO_INMUEBLE.value="OFICINA";
    	document.fmId.submit();
    } else if(tipoInm=="NAVE INDUSTRIAL"){
    	document.fmId.ID_TIPO_INMUEBLE.value="NAVE INDUSTRIAL";
    	document.fmId.submit();
    } else if(tipoInm=="GARAJE"){
    	document.fmId.ID_TIPO_INMUEBLE.value="GARAJE";
    	document.fmId.submit();
    }
    else
        document.fmId.submit();
}
function delSelected() {
    if(checkId()) {
        var is_ok = window.confirm("¿Está seguro de que desea eliminar este registro?");
        if (is_ok) {
            submitType('del');
        }
    }
    else {
        alert ("Error:\n  - Identificador requerido");
    }
}

function submitType(tipoOp) {
    if(tipoOp!="del") {
        document.fmUpdate.CODIGO.value=document.fmId.xCodigo.value;
        document.fmUpdate.NUMERO.value=document.fmId.xNumero.value;
        document.fmUpdate.DIRECCION.value=document.fmId.xDireccion.value;
        document.fmUpdate.ESTADO.value=document.fmId.ESTADO.value;
        if(document.fmId.xEN_EXCLUSIVA.checked)
            document.fmUpdate.EN_EXCLUSIVA.value="1";
        else
            document.fmUpdate.EN_EXCLUSIVA.value="0";

        var is_ok = window.confirm("¿Está seguro de que desea guardar el inmueble de código '"+document.fmUpdate.CODIGO.value+"'?");
        if (is_ok) {
            document.fmUpdate.op.value=tipoOp;
            submitForm();
        }
    }
    else {
        document.fmUpdate.op.value=tipoOp;
        submitForm();
    }
}
function submitForm() {
    if(checkForm()) {
      document.fmUpdate.submit();
    }
}
//-->
</script><%--
// [25/08/2003] seh
<table cellpadding="5"><tr><td>Para dar de alta un inmueble, seleccione primero su <b>tipo</b> para que aparezca la informaci&oacute;n adecuada al tipo de inmueble indicado.</td></tr>
<tr>
    <td>En los campos que representen criterios de carga puede utilizar el comod&iacute;n <b>%</b> para realizar b&uacute;squedas de cadenas. As&iacute; <code><b>%ara</b></code> buscar&aacute; cualquier cadena que finalice en <code>'ara'</code>, la cadena <code><b>%ara%</b></code> buscar&aacute; cualquier cadena que contenga <code>'ara'</code>, y por &uacute;ltimo <code><b>ara%</b></code> busca cualquier cadena que comience por <code>'ara'</code>.</td>
</tr>
</table>--%><% 
// Reestablecer la información
String sInv=request.getParameter("inv");
if(sInv!=null && !sInv.equals("")) {
    session.removeAttribute("ofel_inmueble");
    session.removeAttribute("ofel_piso");
    session.removeAttribute("ofel_chalet");
    session.removeAttribute("ofel_parcela");
    session.removeAttribute("ofel_inm_nave");
    session.removeAttribute("ofel_garaje");
    session.removeAttribute("ofel_inm_oficina");
}

/* ###############################################################
// Primero recogemos la informacion propia del objeto
// Cargamos en el objeto lo que recibimos del formulario
*/
%><jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" />
<jsp:setProperty name="ofel_inmueble" property="*"/><%

// Cargamos el objeto segun los criterios de carga
String sCodigo = request.getParameter("xCodigo");
int nCod=-1;
String sDireccion = request.getParameter("xDireccion");
String sNumero = request.getParameter("xNumero");
String sEstado = request.getParameter("ESTADO");
String sReferencia = request.getParameter("xReferencia");
String sTipo = request.getParameter("ID_TIPO_INMUEBLE");

if(sCodigo!=null && !sCodigo.equals(""))
{
    nCod = Integer.parseInt(sCodigo);
    ofel_inmueble.reset();
    ofel_inmueble.loadFromDB(nCod);
}
else if(sDireccion!=null && !sDireccion.equals(""))
{
    if(sNumero==null)
       sNumero="";

    ofel_inmueble.reset();
    ofel_inmueble.loadDirFromDB(sDireccion, sNumero);
}
else if(sReferencia!=null && !sReferencia.equals(""))
{
    ofel_inmueble.loadRefFromDB(sReferencia.trim());
    nCod=ofel_inmueble.getCODIGO();
    ofel_inmueble.reset();
    ofel_inmueble.loadFromDB(nCod);
}

Date fecha = new Date();
if(sTipo==null || sTipo.equals("-1") || sTipo.equals("")) {
    sTipo=ofel_inmueble.getTIPO();
    if(sTipo==null)
        sTipo="-1";
} // [21/08/2003] seh
else {
    ofel_inmueble.setTIPO(sTipo);
}


%><table width="100%" border="0" cellpadding="5">
    <form name="tipoinm" method="post" action="index.jsp?tab=inm">
    <tr><td class="destacado">&nbsp;Tipo: <select name="ID_TIPO_INMUEBLE" onchange="javascript:document.tipoinm.submit();">
    <option value="-1"<%=sTipo.equals("-1")?" selected=\"true\"":""%>>-- No indicado --</option><%
    Vector v=QueryCache.get("inm").getQueryResults();

    for(int i=0; i<v.size(); i++) {
        %><option value="<%=((Vector)v.elementAt(i)).elementAt(1)%>"<%=sTipo.equals( ((Vector)v.elementAt(i)).elementAt(1).toString() )?" selected=\"true\"":""%>><%=((Vector)v.elementAt(i)).elementAt(1).toString()%></option><%
    }
    %></select></td><td colspan="2"><%
    if(ofel_inmueble.getCODIGO()!=-1) {%><a href="index.jsp?tab=inm&acc=vc"><img src="/gestinm/images/vista_cliente.png" border="0" alt="Vista cliente"></a><%
    }%></td>
    </tr>
    </form>
<tr>
<td class="destacado" valign="top">
	<table border="0" class="destacado">
        <form method="post" name="fmId" action="index.jsp?tab=inm">
        <input type="hidden" name="ID_TIPO_INMUEBLE"/>
        <tr>
            <td>C&oacute;digo:</td>
                <td><input type="text" name="xCodigo" value="<%=ofel_inmueble.getCODIGO()==-1?"":""+ofel_inmueble.getCODIGO()%>" size="20"/><%
                if(ofel_inmueble.getCODIGO()!=-1) {%>&nbsp;&nbsp;<a href="javascript:;" onclick="javascript:window.open('inmuebles/fotos/upload.jsp','fotosUp','width=400, height=390, channelmode=0, dependent=0, directories=0, fullscreen=0, location=0, menubar=0, resizable=1, scrollbars=auto, status=0, toolbar=0');"><img src="/gestinm/images/fotos_add.gif" border="0" alt="Añadir fotos"></a><%
                }
                if(ofel_inmueble.getPictures()!=null && !ofel_inmueble.getPictures().isEmpty()) {%>&nbsp;&nbsp;<a href="javascript:;" onclick="javascript:window.open('inmuebles/fotos/verFotos.jsp','fotos','width=700,height=575,channelmode=0,dependent=0, directories=0, fullscreen=0, location=0, menubar=0, resizable=1, scrollbars=1, status=0, toolbar=0');"><img src="/gestinm/images/fotos.gif" border="0" alt="Ver fotos"></a><%}%></td>
            </tr>
            <tr>
                <td><span style="{color: lavender;}">*</span> Direcci&oacute;n: </td>
                <td><input type="text" name="xDireccion" value="<%=ofel_inmueble.getDIRECCION()==null?"":ofel_inmueble.getDIRECCION()%>" size="35"/></td>
            </tr>
            <tr>
                <td>Num:</td>
                <td><input type="password" name="xNumero" size="3" value="<%=ofel_inmueble.getNUMERO()==null?"":ofel_inmueble.getNUMERO()%>" size="5"/> <img src="/gestinm/images/admiracion.gif" width="18" height="18" border="0" alt=" <%=ofel_inmueble.getNUMERO()==null?"":ofel_inmueble.getNUMERO()%> "></td>
            </tr>
            <tr>
                <td>Estado:</td>
                <td><jsp:include page="/inc/comboEstado.jsp">
                    <jsp:param name="sel" value="<%=ofel_inmueble.getESTADO()%>"/>
                </jsp:include>
                </td>
            </tr>
            <tr>
                <td>En exclusiva: </td>
                <td><input type="checkbox" value="1" name="xEN_EXCLUSIVA"<%=ofel_inmueble.getEN_EXCLUSIVA()?" checked=\"true\"":""%>/></td>
            </tr>
        </form>
    </table>
</td>
<form method="post" name="fmUpdate" action="index.jsp?tab=inm&acc=upd">
<td valign="top">
	<table border="1" align="center">
	    <tr>
	        <td>V&iacute;a: </td>
	        <td><jsp:include page="/inc/comboTipoVia.jsp">
	        <jsp:param name="sel" value="<%=ofel_inmueble.getTIPO_VIA()%>"/>
        	</jsp:include></td>
	    </tr>
            <tr>
                <td>Bloque:</td>
                <td><input type="text" name="BLOQUE" value="<%=ofel_inmueble.getBLOQUE()==null?"":ofel_inmueble.getBLOQUE()%>"/></td>
            </tr>
            <tr>
                <td>Piso:</td>
                <td><input type="text" name="PISO" value="<%=ofel_inmueble.getPISO()==null?"":ofel_inmueble.getPISO()%>"/></td>
            </tr>
            <tr>
                <td>Letra:</td>
                <td><input type="text" name="LETRA" value="<%=ofel_inmueble.getLETRA()==null?"":""+ofel_inmueble.getLETRA()%>"/></td>
            </tr>
       </table>
</td>
<td valign="top">
    <table border="1">
	<input type="hidden" name="op" value="add"/>
	<input type="hidden" name="CODIGO" value="<%=ofel_inmueble.getCODIGO()==0?"":""+ofel_inmueble.getCODIGO()%>" />
	<input type="hidden" name="DIRECCION" value="<%=ofel_inmueble.getDIRECCION()==null?"":ofel_inmueble.getDIRECCION()%>"/>
	<input type="hidden" name="NUMERO" value="<%=ofel_inmueble.getNUMERO()==null?"":ofel_inmueble.getNUMERO()%>"/>
	<input type="hidden" name="ESTADO" value="<%=ofel_inmueble.getESTADO()==0?"":""+ofel_inmueble.getESTADO()%>"/>
	<input type="hidden" name="REFERENCIA" value="<%=ofel_inmueble.getREFERENCIA()==null?"":ofel_inmueble.getREFERENCIA()%>"/>
	<input type="hidden" name="EN_EXCLUSIVA" value="<%=ofel_inmueble.getEN_EXCLUSIVA()?"1":"0"%>"/>
	<input type="hidden" name="xULTIMA_MODIFICACION" value="<%=ofel_inmueble.getShowULTIMA_MODIFICACION()==null?"":ofel_inmueble.getShowULTIMA_MODIFICACION()%>"/>
	<input type="hidden" name="TIPO" value="<%=sTipo%>"/>
	<input type="hidden" name="ID_TIPO_INMUEBLE" value="<%=sTipo%>"/>
        <tr>
            <td>Provincia: </td>
            <td>
            <jsp:include page="/inc/comboProvincia.jsp">
            <jsp:param name="sel" value="<%=ofel_inmueble.getPROVINCIA()%>"/>
            </jsp:include></td>
        </tr>
        <tr>
            <td><span class="nota">*</span> Poblaci&oacute;n: </td>
            <td>
            <input type="text" name="POBLACION" value="<%=ofel_inmueble.getPOBLACION()==null?"":ofel_inmueble.getPOBLACION()%>" size="20"/></td>
        </tr>
        <tr>
            <td><span class="nota">*</span> Zona: </td>

            <td><jsp:include page="/inc/comboZona.jsp">
            <jsp:param name="sel" value="<%=ofel_inmueble.getZONA()%>"/></jsp:include></td>
        </tr>
        <tr>
            <td>C.P: </td>
            <td>
            <input type="text" name="COD_POSTAL" value="<%=ofel_inmueble.getCOD_POSTAL()==null?"":ofel_inmueble.getCOD_POSTAL()%>" size="20"/></td>
        </tr>
     </table>
</td>
</tr>

<tr>
<td valign="top">
        <table class="bordeVerde" valign="top">
            <tr>
	        <td>Venta:</td>
	        <td><input type="text" size="11" name="PRECIO_VENTA" value="<%=ofel_inmueble.getPRECIO_VENTA()==0.0?"":""+ofel_inmueble.getPRECIO_VENTA()%>"/> &euro;</td>
	    </tr>
	    <tr>
	        <td>Alquiler:</td>
	        <td><input type="text"  size="11" name="PRECIO_ALQUILER" value="<%=ofel_inmueble.getPRECIO_ALQUILER()==0.0?"":""+ofel_inmueble.getPRECIO_ALQUILER()%>"/> &euro;</td>
	    </tr>
	    <tr>
	        <td>Traspaso:</td>
	        <td><input type="text" size="11" name="PRECIO_TRASPASO" value="<%=ofel_inmueble.getPRECIO_TRASPASO()==0.0?"":""+ofel_inmueble.getPRECIO_TRASPASO()%>"/> &euro;</td>
	    </tr>
	</table>
</td>
<td valign="top"> 
       <table border="1" align="center">
        <tr>
            <td>Propietario: </td>
            <td><input type="text" size="10" name="COD_PROPIETARIO" value="<%=ofel_inmueble.getCOD_PROPIETARIO()==-1 || ofel_inmueble.getCOD_PROPIETARIO()==0?"":""+ofel_inmueble.getCOD_PROPIETARIO()%>"/> <%
            if(ofel_inmueble.getCOD_PROPIETARIO()!=-1 && ofel_inmueble.getCOD_PROPIETARIO()!=0) {
                %><a href="index.jsp?tab=prov&xID_PROPIETARIO=<%=ofel_inmueble.getCOD_PROPIETARIO()%>"><img src="/gestinm/images/usuarios.png" alt="Ver propietario <%=ofel_inmueble.getCOD_PROPIETARIO()%>" border="0"/></a> | <%
            }
            %><a href="javascript:;" onclick="javascript:window.open('/gestinm/_admin/inmuebles/asigna_propietario.jsp', 'Asigna_propietario', 'resizable=no,toolbar=no,scrollbars=yes,width=800,height=500');"/><img src="/gestinm/images/usuariosS.png" alt="Asignar propietario" border="0"/></a></td>
        </tr>
        <tr>
            <td>Fecha Reserva: </td>
            <td><input type="text" size="10" name="xFECHA_RESERVA" value="<%=ofel_inmueble.getShowFECHA_RESERVA()%>"/></td>
        </tr>
        <tr>
            <td>Fecha Vencimiento: </td>
            <td><input type="text" size="10" name="xFECHA_VENCIMIENTO" value="<%=ofel_inmueble.getShowFECHA_VENCIMIENTO()%>"/></td>
        </tr>
        <tr>
            <td>Reservado por: </td>
            <td><input type="text" name="RESERVADO_POR" value="<%=ofel_inmueble.getRESERVADO_POR()%>"/></td>
        </tr>
     </table>
</td>
<td valign="top">
	<table border="1">
            <tr>
                <td>Superficie:</td>
                <td><input type="text" name="SUPERFICIE" size="6"  value="<%=ofel_inmueble.getSUPERFICIE()==0?"":""+ofel_inmueble.getSUPERFICIE()%>"/> m<sup>2</sup></td>
            </tr>
            <tr>
                <td>Superficie construida:</td>
                <td><input type="text" name="SUP_CONSTRUIDA" size="6" value="<%=ofel_inmueble.getSUP_CONSTRUIDA()==0?"":""+ofel_inmueble.getSUP_CONSTRUIDA()%>"/> m<sup>2</sup></td>
            </tr>
            <tr>
                <td>Superficie &uacute;til:</td>
                <td><input type="text" name="SUP_UTIL"  size="6" value="<%=ofel_inmueble.getSUP_UTIL()==0?"":""+ofel_inmueble.getSUP_UTIL()%>"/> m<sup>2</sup></td>
            </tr>
       </table>
</td>
</tr>
<!--  SEGUNDA FILA -->
<tr><td></td></tr>
<tr>
<td valign="top">
        <table border="1">
            <tr>
                <td>Vendedor:</td>
                <td>
                <jsp:include page="/inc/comboVendedor.jsp">
                    <jsp:param name="sel" value="<%=ofel_inmueble.getVENDEDOR()%>"/>
                </jsp:include>
                </td>
            </tr>
            <tr>
                <td valign="top">Notas:<%if(ofel_inmueble.getCODIGO()!=-1) {%><br/><a href="javascript:;" onclick="javascript:window.open('inmuebles/notas/verNota.jsp?cod=<%=ofel_inmueble.getCODIGO()%>','notas','title=no, scrollbars=yes, resizable=yes, width=420, height=530');"><img src="/gestinm/images/nota1.png" border="0" alt="Ver notas del inmueble"></a><%}%></td>
                <td><textarea rows="6" cols="30" name="NOTAS"><%=ofel_inmueble.getNOTAS()==null?"":ofel_inmueble.getNOTAS()%></textarea></td>
            </tr>
            <tr>
                <td valign="top">Llaves:</td>
                <td>
                <textarea rows="2" cols="30"name="LLAVES"><%=ofel_inmueble.getLLAVES()==null?"":ofel_inmueble.getLLAVES()%></textarea></td>
            </tr>
            <tr>
                <td valign="top">Descripci&oacute;n: </td>
                <td><textarea rows="6" cols="30" name="DESCRIPCION"><%=ofel_inmueble.getDESCRIPCION()==null?"":ofel_inmueble.getDESCRIPCION()%></textarea></td>
            </tr>
        </table>
</td>
<td valign="top" width="100%" colspan="2" class="bordeRojo">
    <%=sTipo!=null && !sTipo.trim().equals("-1")?"&nbsp;<b> "+sTipo+" </b>":""%><%
    //System.out.println("TIPO2--------->" + sTipo);
     if (sTipo!=null && (sTipo.equals("PISO") || sTipo.equals("ÁTICO") || sTipo.equals("DÚPLEX") || sTipo.equals("APARTAMENTO") || sTipo.equals("ESTUDIO"))){
    %><jsp:include page="/_admin/inmuebles/piso.jsp"/><%
    } else if (sTipo!=null && ( sTipo.equals("CHALET") || sTipo.equals("BODEGA") || sTipo.equals("CASA DE PUEBLO")) ) {
    %><jsp:include page="/_admin/inmuebles/chalet.jsp" /><%
    } else if (sTipo!=null && sTipo.equals("PARCELA/TERRENOS")) {
    %><jsp:include page="/_admin/inmuebles/parcela.jsp" /><%
    } else if (sTipo!=null && sTipo.equals("OFICINA")) {
    %><jsp:include page="/_admin/inmuebles/oficina.jsp" /><%
    } else if (sTipo!=null && (sTipo.equals("NAVE INDUSTRIAL") || sTipo.equals("LOCAL COMERCIAL"))) {
    %><jsp:include page="/_admin/inmuebles/nave.jsp" /><%
    } else if (sTipo!=null && sTipo.equals("GARAJE")) {
    %><jsp:include page="/_admin/inmuebles/garaje.jsp" /><%
    }
%></td>
</form>
</tr>
<tr><td></td></tr>
</table>