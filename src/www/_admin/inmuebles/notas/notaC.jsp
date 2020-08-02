<%@page import="java.util.Vector,com.emesa.gestinm.dao.FEL_NOTA_C"%><%

String sIdInmueble=request.getParameter("cod");
FEL_NOTA_C oNota=new FEL_NOTA_C();
if(sIdInmueble!=null && !sIdInmueble.trim().equals(""))
    oNota.loadFromDB(Integer.parseInt(sIdInmueble));
%>
<form method="post" action="nota_upd.jsp" name="fmNotaC">
<input type="hidden" name="CODIGO" value="<%=sIdInmueble%>"/>
<input type="hidden" name="nota" value="C"/>
<input type="hidden" name="del" value="false"/>
<table class="bordeRojo">
<tr>
    <th colspan="3">Nota <em>C</em></th>
</tr>
<tr>
    <td valign="top"><b>Diecci&oacute;n completa</b>:</td>
    <td colspan="2" valign="top"><textarea name="DIR_COMPLETA" rows="3" cols="20"><%=oNota.getDIR_COMPLETA()==null?"":oNota.getDIR_COMPLETA()%></textarea></td>
</tr>
<tr>
    <td><b>Garaje</b>:</td>
    <td colspan="2"><input type="text" name="GARAJE" value="<%=oNota.getGARAJE()==null?"":oNota.getGARAJE()%>"/></td>
</tr>
<tr>
    <td><b>Trastero</b>:</td>
    <td colspan="2"><input type="text" name="TRASTERO" value="<%=oNota.getTRASTERO()==null?"":oNota.getTRASTERO()%>"/></td>
</tr>
<tr><td colspan="2" class="destacado">:. Datos de los propietarios</td><td/></tr>
<tr>
    <td valign="top"><b>Nombre y apellidos</b>:</td>
    <td colspan="2"><textarea rows="2" name="NOMBRE_APEL" cols="20"><%=oNota.getNOMBRE_APEL()==null?"":oNota.getNOMBRE_APEL()%></textarea></td>
</tr>
<tr>
    <td valign="top"><b>Direcci&oacute;n y poblaci&oacute;n</b>:</td>
    <td colspan="2" valign="top"><textarea name="DIR_Y_POBLACION" rows="3" cols="20"><%=oNota.getDIR_Y_POBLACION()==null?"":oNota.getDIR_Y_POBLACION()%></textarea></td>
</tr>
<tr>
    <td valign="top"><b>Personas a tratar</b>:</td>
    <td colspan="2" valign="top"><textarea name="PERSONAS_TRATAR" rows="3" cols="20"><%=oNota.getPERSONAS_TRATAR()==null?"":oNota.getPERSONAS_TRATAR()%></textarea></td>
</tr>
<tr>
    <td valign="top"><b>Tel&eacute;fonos</b>:</td>
    <td colspan="2" valign="top"><textarea name="TELEFONOS" rows="3" cols="20"><%=oNota.getTELEFONOS()==null?"":oNota.getTELEFONOS()%></textarea></td>
</tr>
<tr>
    <td valign="top"><b>Horario visitas propietario</b>:</td>
    <td colspan="2"><textarea cols="20" rows="2" name="VISITAS_PROPIETARIO"><%=oNota.getVISITAS_PROPIETARIO()==null?"":oNota.getVISITAS_PROPIETARIO()%></textarea></td>
</tr>
<tr>
    <td valign="top"><b>Horario visitas tasador</b>:</td>
    <td colspan="2"><textarea cols="20" rows="2" name="VISITAS_TASADOR"><%=oNota.getVISITAS_TASADOR()==null?"":oNota.getVISITAS_TASADOR()%></textarea></td>
</tr>
<tr>
    <td colspan="3" class="marca" align="right">[<a href="javascript:document.fmNotaC.del.value='true';document.fmNotaC.submit();">Eliminar</a>]&nbsp;&nbsp;[<a href="javascript:document.fmNotaC.del.value='false';document.fmNotaC.submit();">Guardar</a>]</td>
</tr>
</table>
</form>
