<script language="javascript">
<!--
function checkForm() {
    var sErrorMsg="Los siguientes campos contienen errores:";
    /*
    if(document.fmUpdate.ID_USUARIO.value=="") {
        sErrorMsg += "\n  - ID_USUARIO no puede estar vacío";
    }
    */
    if(document.fmUpdate.ALIAS.value=="") {
        sErrorMsg += "\n  - Introduzca un nombre de usuario";
    }
    if(document.fmUpdate.newCLAVE.value=="" || document.fmUpdate.newCLAVE.value.length<4) {
        sErrorMsg += "\n  - Tiene que indicar una clave mayor de 3 caracteres";
    }
    if(document.fmUpdate.NOMBRE.value=="") {
        sErrorMsg += "\n  - Introduzca su nombre";
    }
    if(document.fmUpdate.APELLIDO1.value=="") {
        sErrorMsg += "\n  - Indique su primer apellido";
    }
    if(document.fmUpdate.ID_OFICINA.value=="") {
        sErrorMsg += "\n  - Indique la oficina a la que pertenece";
    }
    if(document.fmUpdate.ID_TIPO_USUARIO.value=="") {
        sErrorMsg += "\n  - Introduzca el tipo de usuario";
    }

    if(document.fmUpdate.CP.value!="" && !checkCP(document.fmUpdate.CP.value)) {
        sErrorMsg += "\n  - Introduzca un código postal válido";
    }

    if(document.fmUpdate.EMAIL.value!="" && !checkEmail(document.fmUpdate.EMAIL.value)) {
        sErrorMsg += "\n  - Introduzca una dirección de correo-e válida";
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
    if(document.fmId.xAPELLIDO1.value=="") { // ## CHECK ##
        return false;
    }
    else {
        return true;
    }
}

function cargar() {
    if( (document.fmId.xAPELLIDO1.value=="") && (document.fmId.xID_USUARIO.value=="") && (document.fmId.xNOMBRE.value=="") && (document.fmId.xALIAS.value=="") )
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
        document.fmUpdate.APELLIDO1.value=document.fmId.xAPELLIDO1.value;
        document.fmUpdate.ID_USUARIO.value=document.fmId.xID_USUARIO.value;
        document.fmUpdate.NOMBRE.value=document.fmId.xNOMBRE.value;
        document.fmUpdate.ALIAS.value=document.fmId.xALIAS.value;
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
    session.removeAttribute("ofel_usuario");
}

/* ###############################################################
// Primero recogemos la información propia del objeto
// Cargamos en el objeto lo que recibimos del formulario
*/%>
<jsp:useBean id="ofel_usuario" class="com.emesa.gestinm.dao.FEL_USUARIO" scope="session" />
<jsp:setProperty name="ofel_usuario" property="*" />
<%
// Cargamos el objeto según los criterios de carga
String sID_USUARIO = request.getParameter("xID_USUARIO");
String sALIAS = request.getParameter("xALIAS");
String sNOMBRE = request.getParameter("xNOMBRE");
String sAPELLIDO1 = request.getParameter("xAPELLIDO1");

if(sID_USUARIO!=null && !sID_USUARIO.equals(""))
    ofel_usuario.loadFromDB(Integer.parseInt(sID_USUARIO));
else if(sALIAS!=null && !sALIAS.equals(""))
    ofel_usuario.loadFromDB(sALIAS);
else if(sNOMBRE!=null && !sNOMBRE.equals("") &&
    sAPELLIDO1!=null && !sAPELLIDO1.equals(""))
    ofel_usuario.loadFromDB(sNOMBRE,sAPELLIDO1);

%>
<table cellpadding="5">
<tr>
<td>En los campos marcados como <span style="{background-color:#E2CEC7;}">&nbsp;criterios de carga&nbsp;</span> puede utilizar el comod&iacute;n <b>%</b> para realizar b&uacute;squedas de cadenas. As&iacute; <code><b>%ara</b></code> buscar&aacute; cualquier cadena que finalice en <code>'ara'</code>, la cadena <code><b>%ara%</b></code> buscar&aacute; cualquier cadena que contenga <code>'ara'</code>, y por &uacute;ltimo <code><b>ara%</b></code> busca cualquier cadena que comience por <code>'ara'</code>.</td>
</tr>
<tr><td>
<table border="0" cellpadding="2">
<form method="post" name="fmId" action="index.jsp">
  <input type="hidden" name="tab" value="us"/>
  <input type="hidden" name="acc" value=""/>
  <tr class="marca">
    <td>Id. usuario: </td>
    <td><input type="text" name="xID_USUARIO" value="<%=ofel_usuario.getID_USUARIO()==-1?"":""+ofel_usuario.getID_USUARIO()%>"/></td>
    <td class="nota">Solo se utilizar&aacute; para la carga del usuario</td>
  </tr>
  <tr class="marca">
    <td><span class="nota">*</span> Alias: </td>
    <td><input type="text" name="xALIAS" value="<%=ofel_usuario.getALIAS()==null?"":ofel_usuario.getALIAS()%>"/></td>
    <td class="nota"></td>
  </tr>

  <tr class="marca">
    <td><span class="nota">*</span> Nombre: </td>
    <td><input type="text" name="xNOMBRE" value="<%=ofel_usuario.getNOMBRE()==null?"":ofel_usuario.getNOMBRE()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr class="marca">
    <td><span class="nota">*</span> Primer apellido: </td>
    <td><input type="text" name="xAPELLIDO1" value="<%=ofel_usuario.getAPELLIDO1()==null?"":ofel_usuario.getAPELLIDO1()%>"/></td>
    <td class="nota"></td>
  </tr>
</form>

<form method="post" name="fmUpdate" action="index.jsp">
<input type="hidden" name="tab" value="us"/>
<input type="hidden" name="acc" value="upd"/>
<input type="hidden" name="op" value="add"/>
<input type="hidden" name="APELLIDO1" value="<%=ofel_usuario.getAPELLIDO1()==null?"":ofel_usuario.getAPELLIDO1()%>"/>
<input type="hidden" name="ID_USUARIO" value="<%=ofel_usuario.getID_USUARIO()%>"/>
<input type="hidden" name="NOMBRE" value="<%=ofel_usuario.getNOMBRE()==null?"":ofel_usuario.getNOMBRE()%>"/>
<input type="hidden" name="ALIAS" value="<%=ofel_usuario.getALIAS()==null?"":ofel_usuario.getALIAS()%>"/>
<input type="hidden" name="oldCLAVE" value="<%=ofel_usuario.getCLAVE()==null?"":ofel_usuario.getCLAVE()%>"/>
  <tr>
    <td>Segundo apellido: </td>
    <td><input type="text" name="APELLIDO2" value="<%=ofel_usuario.getAPELLIDO2()==null?"":ofel_usuario.getAPELLIDO2()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td><span class="nota">*</span> Tipo de usuario: </td>
    <td><jsp:include page="/inc/comboTipoUsuario.jsp">
            <jsp:param name="sel" value="<%=ofel_usuario.getID_TIPO_USUARIO()%>"/>
        </jsp:include>
    </td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td><span class="nota">*</span> Clave: </td>
    <td><input type="text" name="newCLAVE" value="<%=ofel_usuario.getCLAVE()==null?"":ofel_usuario.getCLAVE()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td><span class="nota">*</span> Oficina: </td>
    <td><jsp:include page="/inc/comboOficina.jsp">
        <jsp:param name="sel" value="<%=ofel_usuario.getID_OFICINA()%>"/>
        </jsp:include>
        </td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>Direcci&oacute;n: </td>
    <td><input type="text" name="DIRECCION" value="<%=ofel_usuario.getDIRECCION()==null?"":ofel_usuario.getDIRECCION()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>Localidad: </td>
    <td><input type="text" name="LOCALIDAD" value="<%=ofel_usuario.getLOCALIDAD()==null?"":ofel_usuario.getLOCALIDAD()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>Provincia: </td>
    <td><jsp:include page="/inc/comboProvincia.jsp">
        <jsp:param name="sel" value="<%=ofel_usuario.getID_PROVINCIA()%>"/>
        </jsp:include>
    </td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>C.P.: </td>
    <td><input type="text" name="CP" size="5" maxlength="5" value="<%=ofel_usuario.getCP()==-1 || ofel_usuario.getCP()==0?"":""+ofel_usuario.getCP()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>Tel&eacute;fono: </td>
    <td><input type="text" name="TELEFONO" value="<%=ofel_usuario.getTELEFONO()==null?"":ofel_usuario.getTELEFONO()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td><i>E-mail</i>: </td>
    <td><input type="text" name="EMAIL" value="<%=ofel_usuario.getEMAIL()==null?"":ofel_usuario.getEMAIL()%>"/></td>
    <td class="nota"></td>
  </tr>
  <!--
  <tr><td>&nbsp;</td><td align="right"><input type="button" value="Borrar" class="boton" onClick="delSelected('del')"/></td><td align="right">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="Resetear" onClick="javascript:window.location.href='fel_usuario.jsp?inv=true'" class="boton"/>&nbsp;<input type="button" value="Enviar" onClick="submitType('mod')" class="boton"/></td></tr>
  -->
</form>
</table>
</td></tr>
</table>