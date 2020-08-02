


<script language="javascript">
<!--


function checkForm() {
    var sErrorMsg="Los siguientes campos contienen errores:";

    if(document.fmUpdate.NOMBRE.value=="") {
        sErrorMsg += "\n  - Indique el nombre de la persona de contacto";
    }
    if(document.fmUpdate.APELLIDO1.value=="") {
        sErrorMsg += "\n  - Indique el primer apellido";
    }
    if(document.fmUpdate.TELEFONO.value!="") {
        sErrorMsg += "\n  - Introduzca un teléfono";
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
    if(document.fmId.xID_CLIENTE.value=="") {
        return false;
    }
    else {
        return true;
    }
}

function cargar() {
    if( (document.fmId.xNOMBRE.value=="") && (document.fmId.xTELEFONO.value=="") &&
        (document.fmId.xID_CLIENTE.value=="") && (document.fmId.xAPELLIDO1.value==""))
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
        document.fmUpdate.NOMBRE.value=document.fmId.xNOMBRE.value;
        document.fmUpdate.ID_CLIENTE.value=document.fmId.xID_CLIENTE.value;
        document.fmUpdate.TELEFONO.value=document.fmId.xTELEFONO.value;
        document.fmUpdate.APELLIDO1.value=document.fmId.xAPELLIDO1.value;



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
    session.removeAttribute("ofel_cliente");
}

/* ###############################################################
// Primero recogemos la información propia del objeto
// Cargamos en el objeto lo que recibimos del formulario

*/%><jsp:useBean id="ofel_cliente" class="com.emesa.gestinm.dao.FEL_CLIENTE" scope="session" />
<jsp:setProperty name="ofel_cliente" property="*" /><%

// Cargamos el objeto según los criterios de carga
String sID_CLIENTE = request.getParameter("xID_CLIENTE");
String sNOMBRE = request.getParameter("xNOMBRE");
String sTELEFONO = request.getParameter("xTELEFONO");
String sAPELLIDO1 = request.getParameter("xAPELLIDO1");
String sCodcliDel=request.getParameter("codcli");

if(sCodcliDel!=null && !sCodcliDel.equals("-1")) {
	sID_CLIENTE=sCodcliDel;
}

if(sID_CLIENTE!=null && !sID_CLIENTE.equals("")) {
    ofel_cliente = new com.emesa.gestinm.dao.FEL_CLIENTE();
    ofel_cliente.loadFromDB(Integer.parseInt(sID_CLIENTE));
}
else if(sTELEFONO!=null && !sTELEFONO.equals("")) {
    ofel_cliente = new com.emesa.gestinm.dao.FEL_CLIENTE();
    ofel_cliente.loadFromTelefono(sTELEFONO);
}
else if(sNOMBRE!=null && !sNOMBRE.equals("")
        &&
    sAPELLIDO1!=null && !sAPELLIDO1.equals("")
    ) {
    ofel_cliente = new com.emesa.gestinm.dao.FEL_CLIENTE();
    ofel_cliente.loadFromContacto(sNOMBRE, sAPELLIDO1);
}
else if(sNOMBRE!=null && !sNOMBRE.equals("")) {
    ofel_cliente = new com.emesa.gestinm.dao.FEL_CLIENTE();
    ofel_cliente.loadFromNombre(sNOMBRE);
}
else if(sAPELLIDO1!=null && !sAPELLIDO1.equals("")) {
    ofel_cliente = new com.emesa.gestinm.dao.FEL_CLIENTE();
    ofel_cliente.loadFromApellido(sAPELLIDO1);
}

%><table cellpadding="5" border="0" width="100%"><%--
<tr>
    <td>En los campos marcados como <span style="{background-color:#E2CEC7;}">&nbsp;criterios de carga&nbsp;</span> puede utilizar el comod&iacute;n <b>%</b> para realizar b&uacute;squedas de cadenas. As&iacute; <code><b>%ara</b></code> buscar&aacute; cualquier cadena que finalice en <code>'ara'</code>, la cadena <code><b>%ara%</b></code> buscar&aacute; cualquier cadena que contenga <code>'ara'</code>, y por &uacute;ltimo <code><b>ara%</b></code> busca cualquier cadena que comience por <code>'ara'</code>.</td>
</tr>--%>
<tr>
    <td width="50%">
    <table border="0" cellpadding="2">
    <form method="post" name="fmId" action="index.jsp">
    <input type="hidden" name="tab" value="cli"/>
    <input type="hidden" name="acc" value=""/>
      <tr class="marca">
        <td>Id. cliente: </td>
        <td><input type="text" name="xID_CLIENTE" value="<%=ofel_cliente.getID_CLIENTE()==-1?"":""+ofel_cliente.getID_CLIENTE()%>"/></td>
        <td class="nota">Solo para carga</td>
      </tr>
      
      <tr class="marca">
        <td><span class="nota">*</span> Nombre: </td>
        <td><input type="text" name="xNOMBRE" value="<%=ofel_cliente.getNOMBRE()==null?"":ofel_cliente.getNOMBRE()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr class="marca">
        <td><span class="nota">*</span> Primer apellido: </td>
        <td><input type="text" name="xAPELLIDO1" value="<%=ofel_cliente.getAPELLIDO1()==null?"":ofel_cliente.getAPELLIDO1()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Segundo apellido: </td>
        <td><input type="text" name="xAPELLIDO2" value="<%=ofel_cliente.getAPELLIDO2()==null?"":ofel_cliente.getAPELLIDO2()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr class="marca">
        <td>Teléfono: </td>
        <td><input type="text" name="xTELEFONO" value="<%=ofel_cliente.getTELEFONO()==null?"":ofel_cliente.getTELEFONO()%>"/></td>
        <td class="nota"></td>
      </tr>
    </form>

    <form method="post" name="fmUpdate" action="index.jsp">
    <input type="hidden" name="tab" value="cli"/>
    <input type="hidden" name="acc" value="upd"/>
    <input type="hidden" name="op" value="add"/>
    <input type="hidden" name="NOMBRE" value="<%=ofel_cliente.getNOMBRE()==null?"":ofel_cliente.getNOMBRE()%>"/>
    <input type="hidden" name="ID_CLIENTE" value="<%=ofel_cliente.getID_CLIENTE()==-1?"":""+ofel_cliente.getID_CLIENTE()%>"/>
    <input type="hidden" name="TELEFONO" value="<%=ofel_cliente.getTELEFONO()==null?"":ofel_cliente.getTELEFONO()%>"/>
    <input type="hidden" name="APELLIDO1" value="<%=ofel_cliente.getAPELLIDO1()==null?"":ofel_cliente.getAPELLIDO1()%>"/>
    <input type="hidden" name="APELLIDO2" value="<%=ofel_cliente.getAPELLIDO2()==null?"":ofel_cliente.getAPELLIDO2()%>"/>
    <input type="hidden" name="xFECHA_ALTA" value="<%=ofel_cliente.getShowFECHA_ALTA()%>"/>
     
      
      <tr>
        <td>Tel&eacute;fono 2: </td>
        <td><input type="text" name="TELEFONO2" value="<%=ofel_cliente.getTELEFONO2()==null?"":ofel_cliente.getTELEFONO2()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Fax: </td>
        <td><input type="text" name="FAX" value="<%=ofel_cliente.getFAX()==null?"":ofel_cliente.getFAX()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Domicilio: </td>
        <td><input type="text" name="DOMICILIO" value="<%=ofel_cliente.getDOMICILIO()==null?"":ofel_cliente.getDOMICILIO()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Poblaci&oacute;n: </td>
        <td><input type="text" name="POBLACION" value="<%=ofel_cliente.getPOBLACION()==null?"":ofel_cliente.getPOBLACION()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>C.P.: </td>
        <td><input type="text" maxlength="5" size="5" name="CP" value="<%=ofel_cliente.getCP()==-1 || ofel_cliente.getCP()==0?"":""+ofel_cliente.getCP()%>"/></td>
        <td class="nota"></td>
      </tr>
      <tr>
        <td>Provincia: </td>
        <td><jsp:include page="/inc/comboProvincia.jsp">
            <jsp:param name="sel" value="<%=ofel_cliente.getID_PROVINCIA()%>"/>
        </jsp:include></td>
        <td class="nota"></td>
      </tr>
      
    </form>
    </table>
</td>
<td width="50%" valign="top" class="bordeLeftRojo"><%
    if(ofel_cliente.getID_CLIENTE()!=-1) {
    %>
    
    <%@include file="/_admin/clientes/display_consultas.jsp" %>
    
    <%
    }%>
</td>
</tr>
</table>