<script language="javascript">
<!--
function checkForm() {
    var sErrorMsg="Los siguientes campos contienen errores:";

    if(document.fmUpdate.ZONA.value=="") {
        sErrorMsg += "\n  - Indique el nombre de la zona";
    }
    else 
    {
        return true;
    }
}

function checkId() {
    if(document.fmUpdate.ZONA.value=="") { // ## CHECK ##
        return false;
    }
    else {
        return true;
    }
}

function cargar() {
    if( (document.fmId.xZONA.value=="") && (document.fmId.xID_ZONA.value=="") )
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
        document.fmUpdate.ZONA.value=document.fmId.xZONA.value;
        document.fmUpdate.ID_ZONA.value=document.fmId.xID_ZONA.value;
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
    session.removeAttribute("ofel_zona");
}

/* ###############################################################
// Primero recogemos la información propia del objeto
// Cargamos en el objeto lo que recibimos del formulario
*/%>
<jsp:useBean id="ofel_zona" class="com.emesa.gestinm.dao.FEL_ZONA" scope="session" />
<jsp:setProperty name="ofel_zona" property="*" />
<%
// Cargamos el objeto según los criterios de carga
// ## CHECK ##
String sID_ZONA = request.getParameter("xID_ZONA");
String sZONA = request.getParameter("xZONA");
if(sID_ZONA!=null && !sID_ZONA.equals(""))
    ofel_zona.loadFromDB(Integer.parseInt(sID_ZONA));
else if(sZONA!=null && !sZONA.equals(""))
    ofel_zona.loadFromDB(sZONA);

%>
<table cellpadding="5">
<tr>
<td>En los campos marcados como <span class="marca">&nbsp;criterios de carga&nbsp;</span> puede utilizar el comod&iacute;n <b>%</b> para realizar b&uacute;squedas de cadenas. As&iacute; <code><b>%ara</b></code> buscar&aacute; cualquier cadena que finalice en <code>'ara'</code>, la cadena <code><b>%ara%</b></code> buscar&aacute; cualquier cadena que contenga <code>'ara'</code>, y por &uacute;ltimo <code><b>ara%</b></code> busca cualquier cadena que comience por <code>'ara'</code>.</td>
</tr>
<tr><td>
<table border="0" cellpadding="2">
<form method="post" name="fmId" action="index.jsp?tab=adm&acc=zon">
<input type="hidden" name="tab" value="adm"/>
<input type="hidden" name="acc" value="zon"/>
  <tr class="marca">
    <td>Id. Zona: </td>
    <td><input type="text" name="xID_ZONA" value="<%=ofel_zona.getID_ZONA()==-1?"":""+ofel_zona.getID_ZONA()%>"/></td>
    <td class="nota"> Solo se utilizar&aacute; en la carga de la zona</td>
  </tr>
  <tr class="marca">
    <td><span class="nota">*</span> Zona: </td>
    <td><input type="text" name="xZONA" value="<%=ofel_zona.getZONA()==null?"":ofel_zona.getZONA()%>"/></td>
    <td class="nota">Para cargar un nombre <i>aproximado</i> utilice el comod&iacute;n <b>%</b>.<br/> As&iacute; <code>%ara%</code> localizar&aacute; la primera zona cuyo nombre contenga <code>ara</code>.</td>
  </tr>
</form>

<form method="post" name="fmUpdate" action="index.jsp?tab=adm&acc=zon">
<input type="hidden" name="tab" value="adm"/>
<input type="hidden" name="acc" value="zon"/>
<input type="hidden" name="op" value="add"/>
<input type="hidden" name="ZONA" value="<%=ofel_zona.getZONA()%>"/>
<input type="hidden" name="ID_ZONA" value="<%=ofel_zona.getID_ZONA()%>"/>
  
</form>
</table>
</td></tr></table>