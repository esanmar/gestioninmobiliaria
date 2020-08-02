<%@page import="java.util.Vector,com.emesa.gestinm.dao.FEL_NOTA_F"%><%

String sIdInmueble=request.getParameter("cod");
FEL_NOTA_F oNota=new FEL_NOTA_F();
if(sIdInmueble!=null && !sIdInmueble.trim().equals(""))
    oNota.loadFromDB(Integer.parseInt(sIdInmueble));
%>
<form method="post" action="nota_upd.jsp" name="fmNotaF">
<input type="hidden" name="CODIGO" value="<%=sIdInmueble%>"/>
<input type="hidden" name="nota" value="F"/>
<input type="hidden" name="del" value="false"/>
<table class="bordeRojo">
    <tr>
        <th colspan="3">Nota <em>F</em> (entorno)</th>
    </tr>
    <tr>
        <td valign="top"><b>Comunicaciones</b>:</td>
        <td colspan="2" valign="top"><textarea name="COMUNICACIONES" rows="6" cols="30"><%=oNota.getCOMUNICACIONES()==null?"":oNota.getCOMUNICACIONES()%></textarea></td>
    </tr>
    <tr>
        <td valign="top"><b>Equipamiento comercial</b>:</td>
        <td colspan="2" valign="top"><textarea name="EQUIP_COMERCIAL" rows="6" cols="30"><%=oNota.getEQUIP_COMERCIAL()==null?"":oNota.getEQUIP_COMERCIAL()%></textarea></td>
    </tr>
<tr>
    <td colspan="3" class="marca" align="right">[<a href="javascript:document.fmNotaF.del.value='true';document.fmNotaF.submit();">Eliminar</a>]&nbsp;&nbsp;[<a href="javascript:document.fmNotaF.del.value='false';document.fmNotaF.submit();">Guardar</a>]</td>
</tr>
</table>
</form>