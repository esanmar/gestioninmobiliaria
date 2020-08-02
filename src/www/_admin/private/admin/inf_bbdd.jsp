<%@page import="com.emesa.gestinm.dao.*"%>
<script language="javascript">
<!--
function checkForm() {
    var sErrorMsg="Los siguientes campos contienen errores:";

    if(document.fmUpdate.NOMBRE.value=="") {
        sErrorMsg += "\n  - Indique el nombre con el que quiere identificar esta conexión a BB.DD.";
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
    if(document.fmId.xID_BBDD.value=="") { // ## CHECK ##
        return false;
    }
    else {
        return true;
    }
}

function cargar() {
    if( (document.fmId.xID_BBDD.value=="") && (document.fmId.xNOMBRE.value=="") )
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
        document.fmUpdate.ID_BBDD.value=document.fmId.xID_BBDD.value;
        document.fmUpdate.NOMBRE.value=document.fmId.xNOMBRE.value;
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
    session.removeAttribute("oinf_bbdd");
}

/* ###############################################################
// Primero recogemos la información propia del objeto
// Cargamos en el objeto lo que recibimos del formulario
*/%>
<jsp:useBean id="oinf_bbdd" class="com.emesa.dao.INF_BBDD" scope="session" />
<jsp:setProperty name="oinf_bbdd" property="*" />
<%
// Cargamos el objeto según los criterios de carga
String sID_BBDD = request.getParameter("xID_BBDD");
String sNOMBRE = request.getParameter("xNOMBRE");
if(sID_BBDD!=null && !sID_BBDD.equals("")) {
    oinf_bbdd.loadFromDB(Integer.parseInt(sID_BBDD));
}
else if(sNOMBRE!=null && !sNOMBRE.equals(""))
    oinf_bbdd.loadFromDB(sNOMBRE);
%>
<table border="0" cellpadding="2">
<form method="post" name="fmId" action="index.jsp">
<input type="hidden" name="tab" value="adm"/>
<input type="hidden" name="acc" value="db"/>
  <tr class="marca">
    <td>Id. base de datos: </td>
    <td><input type="text" name="xID_BBDD" value="<%=oinf_bbdd.getID_BBDD()==-1?"":""+oinf_bbdd.getID_BBDD()%>"/></td>
    <td class="nota">Solo se utilizar&aacute; para la carga de la informaci&oacute;n</td>
  </tr>
  <tr class="marca">
    <td><span class="nota">*</span> Nombre: </td>
    <td><input type="text" name="xNOMBRE" value="<%=oinf_bbdd.getNOMBRE()==null?"":oinf_bbdd.getNOMBRE()%>"/></td>
    <td class="nota"></td>
  </tr>
</form>

<form method="post" name="fmUpdate" action="index.jsp">
<input type="hidden" name="tab" value="adm"/>
<input type="hidden" name="acc" value="db"/>
<input type="hidden" name="acc2" value="upd"/>
<input type="hidden" name="op" value="add"/>
<input type="hidden" name="ID_BBDD"/>
<input type="hidden" name="NOMBRE"/>
  <tr>
    <td colspan="3" height="5"/>
  </tr>
  <tr>
    <td colspan="2" class="destacado">&nbsp;:. JNDI</td>
    <td/>
  </tr>
  <tr>
    <td>JNDI: </td>
    <td><input type="text" name="JNDI" value="<%=oinf_bbdd.getJNDI()==null?"":oinf_bbdd.getJNDI()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td colspan="3" height="5"/>
  <tr>
    <td colspan="2" class="destacado">&nbsp;:. ODBC</td>
    <td/>
  </tr>
  <tr>
    <td><i>Driver</i>: </td>
    <td><input type="text" name="DRIVER" value="<%=oinf_bbdd.getDRIVER()==null?"":oinf_bbdd.getDRIVER()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>URL: </td>
    <td><input type="text" name="URL" value="<%=oinf_bbdd.getURL()==null?"":oinf_bbdd.getURL()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>Usuario: </td>
    <td><input type="text" name="USUARIO" value="<%=oinf_bbdd.getUSUARIO()==null?"":oinf_bbdd.getUSUARIO()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td>Contrase&ntilde;a: </td>
    <td><input type="text" name="CLAVE" value="<%=oinf_bbdd.getCLAVE()==null?"":oinf_bbdd.getCLAVE()%>"/></td>
    <td class="nota"></td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>
</form>
</table>
