<%@page import="java.util.Vector,com.emesa.gestinm.dao.FEL_NOTA_I"%><%

String sIdInmueble=request.getParameter("cod");
FEL_NOTA_I oNota=new FEL_NOTA_I();
if(sIdInmueble!=null && !sIdInmueble.trim().equals(""))
    oNota.loadFromDB(Integer.parseInt(sIdInmueble));
%>
<form method="post" action="nota_upd.jsp" name="fmNotaI">
<input type="hidden" name="CODIGO" value="<%=sIdInmueble%>"/>
<input type="hidden" name="nota" value="I"/>
<input type="hidden" name="del" value="false"/>
<table class="bordeRojo">
    <tr>
        <th colspan="3">Nota <em>I</em> (datos registrales)</th>
    </tr>
    <tr>
        <td colspan="3" valign="top" align="center"><textarea name="DATOS_REGISTRALES" rows="17" cols="48"><%=oNota.getDATOS_REGISTRALES()==null?"":oNota.getDATOS_REGISTRALES()%></textarea></td>
    </tr>
<tr>
    <td colspan="3" class="marca" align="right">[<a href="javascript:document.fmNotaI.del.value='true';document.fmNotaI.submit();">Eliminar</a>]&nbsp;&nbsp;[<a href="javascript:document.fmNotaI.del.value='false';document.fmNotaI.submit();">Guardar</a>]</td>
</tr>
</table>
</form>