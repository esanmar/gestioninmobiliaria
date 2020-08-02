<%@page import="java.util.Vector,com.emesa.gestinm.dao.FEL_NOTA_E"%><%

String sIdInmueble=request.getParameter("cod");
FEL_NOTA_E oNota=new FEL_NOTA_E();
if(sIdInmueble!=null && !sIdInmueble.trim().equals(""))
    oNota.loadFromDB(Integer.parseInt(sIdInmueble));
%>
<form method="post" action="nota_upd.jsp" name="fmNotaE">
<input type="hidden" name="CODIGO" value="<%=sIdInmueble%>"/>
<input type="hidden" name="nota" value="E"/>
<input type="hidden" name="del" value="false"/>
<table class="bordeRojo">
    <tr>
        <th colspan="3">Nota <em>E</em> (otros datos)</th>
    </tr>
    <tr>
        <td><b>Altura real del piso</b>:</td>
        <td colspan="2"><input type="text" name="ALTURA_REAL" value="<%=oNota.getALTURA_REAL()==null?"":oNota.getALTURA_REAL()%>"/></td>
    </tr>
    <tr>
        <td><b>Pisos por planta</b>:</td>
        <td colspan="2"><input type="text" name="PISOS_PLANTA" size="2" maxlength="3" value="<%=oNota.getPISOS_PLANTA()==null?"":oNota.getPISOS_PLANTA()%>"/></td>
    </tr>
    <tr>
        <td valign="top"><b>Descripci&oacute;n zona comunitaria</b>:</td>
        <td colspan="2" valign="top"><textarea name="ZONA_COMUNITARIA" rows="3" cols="20"><%=oNota.getZONA_COMUNITARIA()==null?"":oNota.getZONA_COMUNITARIA()%></textarea></td>
    </tr>
    <tr>
        <td><b>Luz el&eacute;ctrica</b>:</td>
        <td colspan="2"><input type="checkbox" name="LUZ" value="1"<%=oNota.getLUZ()?" checked=\"true\"":""%>/></td>
    </tr>
    <tr>
        <td><b>Portero</b>:</td>
        <td colspan="2"><input type="text" name="PORTERO" value="<%=oNota.getPORTERO()==null?"":oNota.getPORTERO()%>"/></td>
    </tr>
    <tr>
        <td valign="top"><b>Ascensores</b>:</td>
        <td colspan="2" valign="top"><textarea name="ASCENSORES" rows="3" cols="20"><%=oNota.getASCENSORES()==null?"":oNota.getASCENSORES()%></textarea></td>
    </tr>
    <tr>
        <td valign="top"><b>Medidas</b>:</td>
        <td colspan="2" valign="top"><textarea name="MEDIDAS" rows="3" cols="20"><%=oNota.getMEDIDAS()==null?"":oNota.getMEDIDAS()%></textarea></td>
    </tr>
    <tr>
        <td valign="top"><b>Muebles</b>:</td>
        <td colspan="2" valign="top"><textarea name="MUEBLES" rows="3" cols="20"><%=oNota.getMUEBLES()==null?"":oNota.getMUEBLES()%></textarea></td>
    </tr>

<tr>
    <td colspan="3" class="marca" align="right">[<a href="javascript:document.fmNotaE.del.value='true';document.fmNotaE.submit();">Eliminar</a>]&nbsp;&nbsp;[<a href="javascript:document.fmNotaE.del.value='false';document.fmNotaE.submit();">Guardar</a>]</td>
</tr>
</table>
</form>