<%@page import="java.util.Vector,com.emesa.gestinm.dao.FEL_NOTA_G"%><%

String sIdInmueble=request.getParameter("cod");
FEL_NOTA_G oNota=new FEL_NOTA_G();
if(sIdInmueble!=null && !sIdInmueble.trim().equals(""))
    oNota.loadFromDB(Integer.parseInt(sIdInmueble));
%>
<form method="post" action="nota_upd.jsp" name="fmNotaG">
<input type="hidden" name="CODIGO" value="<%=sIdInmueble%>"/>
<input type="hidden" name="nota" value="G"/>
<input type="hidden" name="del" value="false"/>
<table class="bordeRojo">
    <tr>
        <th colspan="3">Nota <em>G</em> (destacable)</th>
    </tr>
    <tr>
        <td valign="top"><b>Destacable por el propietario</b>:</td>
        <td colspan="2" valign="top"><textarea name="DEST_PROPIETARIO" rows="6" cols="30"><%=oNota.getDEST_PROPIETARIO()==null?"":oNota.getDEST_PROPIETARIO()%></textarea></td>
    </tr>
    <tr>
        <td valign="top"><b>Destacable por el tasador</b>:</td>
        <td colspan="2" valign="top"><textarea name="DEST_TASADOR" rows="6" cols="30"><%=oNota.getDEST_TASADOR()==null?"":oNota.getDEST_TASADOR()%></textarea></td>
    </tr>
<tr>
    <td colspan="3" class="marca" align="right">[<a href="javascript:document.fmNotaG.del.value='true';document.fmNotaG.submit();">Eliminar</a>]&nbsp;&nbsp;[<a href="javascript:document.fmNotaG.del.value='false';document.fmNotaG.submit();">Guardar</a>]</td>
</tr>
</table>
</form>