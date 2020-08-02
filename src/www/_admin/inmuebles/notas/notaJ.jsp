<%@page import="java.util.Vector,com.emesa.gestinm.dao.FEL_NOTA_J"%><%

String sIdInmueble=request.getParameter("cod");
FEL_NOTA_J oNota=new FEL_NOTA_J();
if(sIdInmueble!=null && !sIdInmueble.trim().equals(""))
    oNota.loadFromDB(Integer.parseInt(sIdInmueble));
%>
<form method="post" action="nota_upd.jsp" name="fmNotaJ">
<input type="hidden" name="CODIGO" value="<%=sIdInmueble%>"/>
<input type="hidden" name="nota" value="J"/>
<input type="hidden" name="del" value="false"/>
<table class="bordeRojo">
    <tr>
        <th colspan="3">Nota <em>J</em></th>
    </tr>
    <tr>
        <td colspan="3" class="nota">Indicar si lo tienen otras inmobiliarias y a qu&eacute; precio.</td>
    </tr>
    <tr>
        <td colspan="3" align="center" valign="top"><textarea name="OTRAS_INM" rows="15" cols="48"><%=oNota.getOTRAS_INM()==null?"":oNota.getOTRAS_INM()%></textarea></td>
    </tr>
<tr>
    <td colspan="3" class="marca" align="right">[<a href="javascript:document.fmNotaJ.del.value='true';document.fmNotaJ.submit();">Eliminar</a>]&nbsp;&nbsp;[<a href="javascript:document.fmNotaJ.del.value='false';document.fmNotaJ.submit();">Guardar</a>]</td>
</tr>
</table>
</form>
