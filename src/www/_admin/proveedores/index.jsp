<script language="javascript">
<!--
function checkForm() {
    var sErrorMsg="Los siguientes campos contienen errores:";

    if(document.fmUpdate.CIF.value=="") {
        sErrorMsg += "\n  - El campo CIF no puede estar vacío";
    }
    else if(document.fmUpdate.CIF.value!="" && !checkCIF(document.fmUpdate.CIF.value)) {
        sErrorMsg += "\n  - Introduzca un CIF válido";
    }

    if(document.fmUpdate.PERSONA_CONTACTO.value=="") {
        sErrorMsg += "\n  - Indique el nombre de la persona de contacto";
    }
    if(document.fmUpdate.CONTACTO_APEL1.value=="") {
        sErrorMsg += "\n  - Indique el primer apellido";
    }
    if(document.fmUpdate.CP.value!="" && !checkCP(document.fmUpdate.CP.value)) {
        sErrorMsg += "\n  - Introduzca un código postal válido";
    }


    if(sErrorMsg!="Los siguientes campos contienen errores:") {
        alert(sErrorMsg);
        return false;
    }
    else {
        return true;
    }
}

function checkId() {
    if(document.fmId.xID_PROPIETARIO.value=="") {
        return false;
    }
    else {
        return true;
    }
}

function cargar() {
    if( (document.fmId.xNOMBRE_COMERCIAL.value=="") && (document.fmId.xCIF.value=="") &&
        (document.fmId.xID_PROPIETARIO.value=="") && (document.fmId.xPERSONA_CONTACTO.value==""))
        alert ("Error: \n  - Debe indicar al menos un criterio de carga");
    else {
        document.fmId.submit();
    }
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
        document.fmUpdate.NOMBRE_COMERCIAL.value=document.fmId.xNOMBRE_COMERCIAL.value;
        document.fmUpdate.CIF.value=document.fmId.xCIF.value;
        document.fmUpdate.ID_PROPIETARIO.value=document.fmId.xID_PROPIETARIO.value;
        document.fmUpdate.PERSONA_CONTACTO.value=document.fmId.xPERSONA_CONTACTO.value;
        document.fmUpdate.CONTACTO_APEL1.value=document.fmId.xCONTACTO_APEL1.value;
        document.fmUpdate.CONTACTO_APEL2.value=document.fmId.xCONTACTO_APEL2.value;
    }
    document.fmUpdate.op.value=tipoOp;
    submitForm();
}
function submitForm() {
    if(checkForm()) {
      document.fmUpdate.submit();
    }
}
//-->
</script><% // Reestablecer la información

String sInv=request.getParameter("inv");
if(sInv!=null && !sInv.equals("")) {
    session.removeAttribute("ofel_proveedor");
}

/* ###############################################################
// Primero recogemos la información propia del objeto
// Cargamos en el objeto lo que recibimos del formulario

*/%><jsp:useBean id="ofel_proveedor" class="com.emesa.gestinm.dao.FEL_PROVEEDOR" scope="session" />
<jsp:setProperty name="ofel_proveedor" property="*" /><%

// Cargamos el objeto según los criterios de carga
String sID_PROPIETARIO = request.getParameter("xID_PROPIETARIO");
String sNOMBRE_COMERCIAL = request.getParameter("xNOMBRE_COMERCIAL");
String sPERSONA_CONTACTO = request.getParameter("xPERSONA_CONTACTO");
String sCONTACTO_APEL1 = request.getParameter("xCONTACTO_APEL1");
String sCIF = request.getParameter("xCIF");

if(sID_PROPIETARIO!=null && !sID_PROPIETARIO.equals("")) {
    ofel_proveedor = new com.emesa.gestinm.dao.FEL_PROVEEDOR();
    ofel_proveedor.loadFromDB(Integer.parseInt(sID_PROPIETARIO));
}
else if(sCIF!=null && !sCIF.equals("")) {
    ofel_proveedor = new com.emesa.gestinm.dao.FEL_PROVEEDOR();
    ofel_proveedor.loadFromDB(sCIF);
}
else if(sPERSONA_CONTACTO!=null && !sPERSONA_CONTACTO.equals("")
        &&
    sCONTACTO_APEL1!=null && !sCONTACTO_APEL1.equals("")
    ) {
    ofel_proveedor = new com.emesa.gestinm.dao.FEL_PROVEEDOR();
    ofel_proveedor.loadFromDBContacto(sPERSONA_CONTACTO,sCONTACTO_APEL1);
}
else if(sPERSONA_CONTACTO!=null && !sPERSONA_CONTACTO.equals("")) {
    ofel_proveedor = new com.emesa.gestinm.dao.FEL_PROVEEDOR();
    ofel_proveedor.loadFromDBContacto(sPERSONA_CONTACTO);
}
else if(sNOMBRE_COMERCIAL!=null && !sNOMBRE_COMERCIAL.equals("")) {
    ofel_proveedor = new com.emesa.gestinm.dao.FEL_PROVEEDOR();
    ofel_proveedor.loadFromDBNombreComercial(sNOMBRE_COMERCIAL);
}

%><table cellpadding="5" border="0" width="100%"><%--
// [25/08/2003] seh
<tr>
    <td>En los campos marcados como <span style="{background-color:#E2CEC7;}">&nbsp;criterios de carga&nbsp;</span> puede utilizar el comod&iacute;n <b>%</b> para realizar b&uacute;squedas de cadenas. As&iacute; <code><b>%ara</b></code> buscar&aacute; cualquier cadena que finalice en <code>'ara'</code>, la cadena <code><b>%ara%</b></code> buscar&aacute; cualquier cadena que contenga <code>'ara'</code>, y por &uacute;ltimo <code><b>ara%</b></code> busca cualquier cadena que comience por <code>'ara'</code>.</td>
</tr>--%>
<tr>
    <td width="50%">
    <table border="0" cellpadding="2">
    <form method="post" name="fmId" action="index.jsp">
    <input type="hidden" name="tab" value="prov"/>
    <input type="hidden" name="acc" value=""/>
      <tr class="marca">
        <td>Id. propietario: </td>
        <td><input type="text" name="xID_PROPIETARIO" value="<%=ofel_proveedor.getID_PROPIETARIO()==-1?"":""+ofel_proveedor.getID_PROPIETARIO()%>"/></td>
        <td class="nota">Solo para carga</td>
      </tr>
      <tr class="marca">
        <td><span class="nota">*</span> CIF: </td>
        <td><input type="text" name="xCIF" value="<%=ofel_proveedor.getCIF()==null?"":ofel_proveedor.getCIF()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr class="marca">
        <td><span class="nota">*</span> Nombre<br/> persona de contacto: </td>
        <td><input type="text" name="xPERSONA_CONTACTO" value="<%=ofel_proveedor.getPERSONA_CONTACTO()==null?"":ofel_proveedor.getPERSONA_CONTACTO()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr class="marca">
        <td><span class="nota">*</span> Primer apellido<br/> persona de contacto: </td>
        <td><input type="text" name="xCONTACTO_APEL1" value="<%=ofel_proveedor.getCONTACTO_APEL1()==null?"":ofel_proveedor.getCONTACTO_APEL1()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Segundo apellido<br/> persona de contacto: </td>
        <td><input type="text" name="xCONTACTO_APEL2" value="<%=ofel_proveedor.getCONTACTO_APEL2()==null?"":ofel_proveedor.getCONTACTO_APEL2()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr class="marca">
        <td>Nombre comercial: </td>
        <td><input type="text" name="xNOMBRE_COMERCIAL" value="<%=ofel_proveedor.getNOMBRE_COMERCIAL()==null?"":ofel_proveedor.getNOMBRE_COMERCIAL()%>"/></td>
        <td class="nota"></td>
      </tr>
    </form>

    <form method="post" name="fmUpdate" action="index.jsp">
    <input type="hidden" name="tab" value="prov"/>
    <input type="hidden" name="acc" value="upd"/>
    <input type="hidden" name="op" value="add"/>
    <input type="hidden" name="NOMBRE_COMERCIAL" value="<%=ofel_proveedor.getNOMBRE_COMERCIAL()==null?"":ofel_proveedor.getNOMBRE_COMERCIAL()%>"/>
    <input type="hidden" name="CIF" value="<%=ofel_proveedor.getCIF()==null?"":ofel_proveedor.getCIF()%>"/>
    <input type="hidden" name="ID_PROPIETARIO" value="<%=ofel_proveedor.getID_PROPIETARIO()==-1?"":""+ofel_proveedor.getID_PROPIETARIO()%>"/>
    <input type="hidden" name="PERSONA_CONTACTO" value="<%=ofel_proveedor.getPERSONA_CONTACTO()==null?"":ofel_proveedor.getPERSONA_CONTACTO()%>"/>
    <input type="hidden" name="CONTACTO_APEL1" value="<%=ofel_proveedor.getCONTACTO_APEL1()==null?"":ofel_proveedor.getCONTACTO_APEL1()%>"/>
    <input type="hidden" name="CONTACTO_APEL2" value="<%=ofel_proveedor.getCONTACTO_APEL2()==null?"":ofel_proveedor.getCONTACTO_APEL2()%>"/>
    <input type="hidden" name="xFECHA_ALTA" value="<%=ofel_proveedor.getShowFECHA_ALTA()%>"/>
      <tr>
        <td>Raz&oacute;n social: </td>
        <td><input type="text" name="RAZON_SOCIAL" value="<%=ofel_proveedor.getRAZON_SOCIAL()==null?"":ofel_proveedor.getRAZON_SOCIAL()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Tel&eacute;fono: </td>
        <td><input type="text" name="TELEFONO" value="<%=ofel_proveedor.getTELEFONO()==null?"":ofel_proveedor.getTELEFONO()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Tel&eacute;fono 2: </td>
        <td><input type="text" name="TELEFONO2" value="<%=ofel_proveedor.getTELEFONO2()==null?"":ofel_proveedor.getTELEFONO2()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Fax: </td>
        <td><input type="text" name="FAX" value="<%=ofel_proveedor.getFAX()==null?"":ofel_proveedor.getFAX()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Domicilio: </td>
        <td><input type="text" name="DOMICILIO" value="<%=ofel_proveedor.getDOMICILIO()==null?"":ofel_proveedor.getDOMICILIO()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Poblaci&oacute;n: </td>
        <td><input type="text" name="POBLACION" value="<%=ofel_proveedor.getPOBLACION()==null?"":ofel_proveedor.getPOBLACION()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>C.P.: </td>
        <td><input type="text" maxlength="5" size="5" name="CP" value="<%=ofel_proveedor.getCP()==-1 || ofel_proveedor.getCP()==0?"":""+ofel_proveedor.getCP()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Provincia: </td>
        <td><jsp:include page="/inc/comboProvincia.jsp">
            <jsp:param name="sel" value="<%=ofel_proveedor.getID_PROVINCIA()%>"/>
        </jsp:include></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Pais: </td>
        <td><jsp:include page="/inc/comboPais.jsp">
            <jsp:param name="sel" value="<%=ofel_proveedor.getID_PAIS()%>"/>
        </jsp:include></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Estado civil: </td>
        <td><jsp:include page="/inc/comboEstadoCivil.jsp">
            <jsp:param name="sel" value="<%=ofel_proveedor.getESTADO_CIVIL()%>"/>
        </jsp:include></td>
        <td class="nota"></td>
      </tr>
    </form>
    </table>
</td>
<td width="50%" valign="top" class="bordeLeftRojo"><%
    if(ofel_proveedor.getID_PROPIETARIO()!=-1) {
    %><%@include file="/_admin/proveedores/display_inmuebles.jsp"%><%
    }%>
</td>
</tr>
</table>