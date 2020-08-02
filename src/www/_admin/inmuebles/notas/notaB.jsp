<%@page import="java.util.Vector,com.emesa.gestinm.dao.FEL_NOTA_B"%><%

String sIdInmueble=request.getParameter("cod");
FEL_NOTA_B oNotaB=new FEL_NOTA_B();
if(sIdInmueble!=null && !sIdInmueble.trim().equals(""))
    oNotaB.loadFromDB(Integer.parseInt(sIdInmueble));
%>
<form method="post" name="fmNotaB" action="nota_upd.jsp">
<input type="hidden" name="CODIGO" value="<%=sIdInmueble%>"/>
<input type="hidden" name="nota" value="B"/>
<input type="hidden" name="del" value="false"/>
<table class="bordeRojo">
<tr><th colspan="3">Nota <em>B</em></th></tr>
<tr>
    <td><b>Tasador</b>:</td>
    <td colspan="2"><input type="text" name="TASADOR" value="<%=oNotaB.getTASADOR()==null?"":oNotaB.getTASADOR()%>"/></td>
</tr>
<tr>
    <td><b>Fecha entrada</b>:</td>
    <td><input type="text" name="xFECHA_ENTRADA" size="10" maxlength="10" value="<%=oNotaB.getShowFECHA_ENTRADA()==null?"":oNotaB.getShowFECHA_ENTRADA()%>"/></td>
    <td class="nota">Format dd/mm/aaaa</td>
</tr>
<tr>
    <td valign="top"><b>Medio de captaci&oacute;n</b>:</td>
    <td colspan="2"><textarea rows="3" cols="20" name="CAPTACION"><%=oNotaB.getCAPTACION()==null?"":oNotaB.getCAPTACION()%></textarea></td>
</tr>
<tr>
    <td><b>Autorizaci&oacute;n/Exclusiva</b>:</td>
    <td><input type="text" name="EXCLUSIVA" value="<%=oNotaB.getEXCLUSIVA()==null?"":oNotaB.getEXCLUSIVA()%>"/></td>
    <td class="nota" valign="top">Cuanto dura</span></td>
</tr>
<tr>
    <td valign="top"><b>Por qu&eacute; no se ha conseguido la exclusiva</b>:</td>
    <td colspan="2" valign="top"><textarea name="NO_EXCLUSIVA" rows="3" cols="20"><%=oNotaB.getNO_EXCLUSIVA()==null?"":oNotaB.getNO_EXCLUSIVA()%></textarea></td>
</tr>
<tr>
    <td valign="top"><b>Cartel</b>:</td>
    <td><textarea name="CARTEL" rows="3" cols="15"><%=oNotaB.getCARTEL()==null?"":oNotaB.getCARTEL()%></textarea></td>
    <td valign="top" class="nota">Colocado o no y d&oacute;nde</td>
</tr>
<tr>
    <td valign="top"><b>Motivo venta</b>:</td>
    <td colspan="2" valign="top"><textarea name="MOTIVO_VENTA" rows="3" cols="20"><%=oNotaB.getMOTIVO_VENTA()==null?"":oNotaB.getMOTIVO_VENTA()%></textarea></td>
</tr>
    <tr>
        <td colspan="3" class="marca" align="right">[<a href="javascript:document.fmNotaB.del.value='true';document.fmNotaB.submit();">Eliminar</a>]&nbsp;&nbsp;[<a href="javascript:document.fmNotaB.del.value='false';document.fmNotaB.submit();">Guardar</a>]</td>
    </tr>
</table>
</form>