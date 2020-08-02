<script language="javascript">
<!--
function checkForm() {
    var sErrorMsg="Los siguientes campos contienen errores:";

    if(document.fmUpdate.NOMBRE.value=="") {
        sErrorMsg += "\n  - Indique el nombre de la oficina";
    }

    if(document.fmUpdate.DIRECCION.value=="") {
        sErrorMsg += "\n  - Indique la dirección de la oficina";
    }

   if(document.fmUpdate.EMAIL.value!="" && !checkEmail(document.fmUpdate.EMAIL.value)) {
        sErrorMsg += "\n  - La dirección de correo indicada no es válida";
    }
    if(document.fmUpdate.CP.value!="" && !checkCP(document.fmUpdate.CP.value)) {
        sErrorMsg += "\n  - El código postal no es correcto";
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
    if(document.fmId.xNOMBRE.value=="") { // ## CHECK ##
        return false;
    }
    else {
        return true;
    }
}

function cargar() {
    if( (document.fmId.xNOMBRE.value=="") && (document.fmId.xID_OFICINA.value=="") )
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
        document.fmUpdate.ID_OFICINA.value=document.fmId.xID_OFICINA.value;
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
</script>
<% // Reestablecer la información
String sInv=request.getParameter("inv");
if(sInv!=null && !sInv.equals("")) {
    session.removeAttribute("ofel_oficina");
}

/* ###############################################################
// Primero recogemos la información propia del objeto
// Cargamos en el objeto lo que recibimos del formulario
*/%>
<jsp:useBean id="ofel_oficina" class="com.emesa.gestinm.dao.FEL_OFICINA" scope="session" />
<jsp:setProperty name="ofel_oficina" property="*" />
<%
// Cargamos el objeto según los criterios de carga
// ## CHECK ##
String sID_OFICINA = request.getParameter("xID_OFICINA");
String sNOMBRE = request.getParameter("xNOMBRE");
if(sID_OFICINA!=null && !sID_OFICINA.equals(""))
{
    ofel_oficina = new com.emesa.gestinm.dao.FEL_OFICINA();
    ofel_oficina.loadFromDB(Integer.parseInt(sID_OFICINA));
}
else if(sNOMBRE!=null && !sNOMBRE.equals(""))
{
    ofel_oficina = new com.emesa.gestinm.dao.FEL_OFICINA();
    ofel_oficina.loadFromDB(sNOMBRE);
}
%>
<table cellpadding="5">
<tr>
<td>En los campos marcados como <span style="{background-color:#E2CEC7;}">&nbsp;criterios de carga&nbsp;</span> puede utilizar el comod&iacute;n <b>%</b> para realizar b&uacute;squedas de cadenas. As&iacute; <code><b>%ara</b></code> buscar&aacute; cualquier cadena que finalice en <code>'ara'</code>, la cadena <code><b>%ara%</b></code> buscar&aacute; cualquier cadena que contenga <code>'ara'</code>, y por &uacute;ltimo <code><b>ara%</b></code> busca cualquier cadena que comience por <code>'ara'</code>.</td>
</tr>
<tr><td>
<table border="0" cellpadding="2">
<form method="post" name="fmId" action="index.jsp">
<input type="hidden" name="tab" value="ofi"/>
<input type="hidden" name="acc" value=""/>
  <tr class="marca">
    <td>Id. oficina: </td>
    <td><input type="text" name="xID_OFICINA" value="<%=ofel_oficina.getID_OFICINA()==-1?"":""+ofel_oficina.getID_OFICINA()%>"/></td>
    <td class="nota"> Solo se utilizar&aacute; en la carga de la oficina</td>
  </tr>
  <tr class="marca">
    <td><span class="nota">*</span> Nombre: </td>
    <td><input type="text" name="xNOMBRE" value="<%=ofel_oficina.getNOMBRE()==null?"":ofel_oficina.getNOMBRE()%>"/></td>
    <td class="nota">Para cargar un nombre <i>aproximado</i> utilice el comod&iacute;n <b>%</b>.<br/> As&iacute; <code>%ara%</code> localizar&aacute; la primera oficina cuyo nombre contenga <code>ara</code>.</td>
  </tr>
</form>

<form method="post" name="fmUpdate" action="index.jsp">
<input type="hidden" name="tab" value="ofi"/>
<input type="hidden" name="acc" value="upd"/>
<input type="hidden" name="op" value="add"/>
<input type="hidden" name="NOMBRE" value="<%=ofel_oficina.getNOMBRE()%>"/>
<input type="hidden" name="ID_OFICINA" value="<%=ofel_oficina.getID_OFICINA()%>"/>
  <tr>
    <td><span class="nota">*</span> Direcci&oacute;n: </td>
    <td><input type="text" name="DIRECCION" value="<%=ofel_oficina.getDIRECCION()==null?"":ofel_oficina.getDIRECCION()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>Tel&eacute;fono: </td>
    <td><input type="text" name="TELEFONO" value="<%=ofel_oficina.getTELEFONO()==null?"":ofel_oficina.getTELEFONO()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>Fax: </td>
    <td><input type="text" name="FAX" value="<%=ofel_oficina.getFAX()==null?"":ofel_oficina.getFAX()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td><i>E-mail</i>: </td>
    <td><input type="text" name="EMAIL" value="<%=ofel_oficina.getEMAIL()==null?"":ofel_oficina.getEMAIL()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>Localidad: </td>
    <td><input type="text" name="LOCALIDAD" value="<%=ofel_oficina.getLOCALIDAD()==null?"":ofel_oficina.getLOCALIDAD()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>Provincia: </td>
    <td>
        <jsp:include page="/inc/comboProvincia.jsp">
            <jsp:param name="sel" value="<%=ofel_oficina.getID_PROVINCIA()%>"/>
        </jsp:include>
    </td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>C.P.: </td>
    <td><input type="text" name="CP" maxlength="5" size="5" value="<%=ofel_oficina.getCP()==-1?"":""+ofel_oficina.getCP()%>"/></td>
    <td class="nota"></td>
  </tr>
</form>
</table>
</td></tr></table>