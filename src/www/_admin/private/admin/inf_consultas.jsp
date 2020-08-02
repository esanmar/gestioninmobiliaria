<script language="javascript">
<!--
function checkForm() {
    var sErrorMsg="Los siguientes campos contienen errores:";

    if(document.fmUpdate.NOMBRE.value=="") {
        sErrorMsg += "\n  - Introduzca el nombre que identificará a la consulta";
    }
    if(document.fmUpdate.QUERY.value=="") {
        sErrorMsg += "\n  - Introduzca la 'query' de la consulta";
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
    if( (document.fmId.xNOMBRE.value=="") && (document.fmId.xID_CONSULTA.value=="") )
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
        document.fmUpdate.ID_CONSULTA.value=document.fmId.xID_CONSULTA.value;
    }
    document.fmUpdate.op.value=tipoOp;
    submitForm();
}
function submitForm() {
    if(checkForm()) {
      document.fmUpdate.submit();
    }
}
function testQuery() {
    var sErrorMsg="Los siguientes campos son obligatorios:";

    if(document.fmUpdate.ID_BBDD.value=="")
        sErrorMsg+=" - Identificador de la base de datos contra la que ejecutar la query";
    if(document.fmUpdate.QUERY.value=="")
        sErrorMsg+=" - Query a ejecutar";

    if(sErrorMsg!="Los siguientes campos son obligatorios:") {
        alert(sErrorMsg);
    }
    else {
      var param=window.prompt("Introduce los valores de los parámetros de la 'query' separados por comas (,):","");
      if(param!=null)
          window.open('admin/testQuery.jsp?q='+document.fmUpdate.QUERY.value+'&db='+document.fmUpdate.ID_BBDD.value+"&p="+param,'testQuery','');
    }
}
//-->
</script><%
// Reestablecer la información
String sInv=request.getParameter("inv");
if(sInv!=null && !sInv.equals("")) {
    session.removeAttribute("oinf_consultas");
}

/* ###############################################################
// Primero recogemos la información propia del objeto
// Cargamos en el objeto lo que recibimos del formulario
*/

%><jsp:useBean id="oinf_consultas" class="com.emesa.dao.INF_CONSULTAS" scope="session" />
<jsp:setProperty name="oinf_consultas" property="*" /><%

// Cargamos el objeto según los criterios de carga
String sNOMBRE = request.getParameter("xNOMBRE");
String sID_CONSULTA = request.getParameter("xID_CONSULTA");
if(sID_CONSULTA!=null && !sID_CONSULTA.equals(""))
    oinf_consultas.loadFromDB(Integer.parseInt(sID_CONSULTA));
else if(sNOMBRE!=null && !sNOMBRE.equals(""))
    oinf_consultas.loadFromDB(sNOMBRE);


%><table border="0" cellpadding="2">
<form method="post" name="fmId" action="index.jsp">
<input type="hidden" name="tab" value="adm"/>
<input type="hidden" name="acc" value="inf"/>
  <tr class="marca">
    <td>Id. consulta: </td>
    <td><input type="text" name="xID_CONSULTA" value="<%=oinf_consultas.getID_CONSULTA()==-1?"":""+oinf_consultas.getID_CONSULTA()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr class="marca">
    <td><span class="nota">*</span> Nombre: </td>
    <td><input type="text" name="xNOMBRE" value="<%=oinf_consultas.getNOMBRE()==null?"":oinf_consultas.getNOMBRE()%>"/></td>
    <td class="nota"></td>
  </tr>
</form>

<form method="post" name="fmUpdate" action="index.jsp">
<input type="hidden" name="tab" value="adm"/>
<input type="hidden" name="acc" value="inf"/>
<input type="hidden" name="acc2" value="upd"/>
<input type="hidden" name="op" value="add"/>
<input type="hidden" name="NOMBRE"/>
<input type="hidden" name="ID_CONSULTA"/>
  <tr>
    <td><span class="nota">*</span> Id. base de datos: </td>
    <td><jsp:include page="/inc/comboBaseDatos.jsp">
        <jsp:param name="sel" value="<%=oinf_consultas.getID_BBDD()%>"/>
        </jsp:include></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td valign="top"><span class="nota">*</span> <i>Query</i>: </td>
    <td><textarea  name="QUERY" rows="4" cols="40"><%=oinf_consultas.getQUERY()==null?"":oinf_consultas.getQUERY()%></textarea></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td valign="top"><span class="nota">*</span> Tipo de usuario: </td>
    <td>
    <jsp:include page="/inc/checkNombreTipoUsuario.jsp">
        <jsp:param name="sel" value="<%=oinf_consultas.getTIPO_USUARIO()%>"/>
    </jsp:include></td>
    <td class="nota" valign="top">Marca los usuarios que quieres que tengan acceso a esta consulta.<br/>El <em>Administrador</em> siempre tendr&aacute; acceso a <em>todas</em> las consultas.</td>
  </tr>
  <tr>
    <td valign="top">Descripci&oacute;n: </td>
    <td><textarea name="DESCRIPCION" rows="4" cols="40"><%=oinf_consultas.getDESCRIPCION()==null?"":oinf_consultas.getDESCRIPCION()%></textarea></td>
    <td class="nota"></td>
  </tr>
</form>
</table>
