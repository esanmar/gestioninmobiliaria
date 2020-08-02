<%@page import="java.util.Vector,com.emesa.gestinm.dao.NotaA"%><%

String sIdInmueble=request.getParameter("cod");
NotaA oNota=new NotaA();
if(sIdInmueble!=null && !sIdInmueble.trim().equals(""))
    oNota.loadFromDB(Integer.parseInt(sIdInmueble));
%>
<form method="post" action="nota_upd.jsp" name="fmNotaA">
<input type="hidden" name="CODIGO" value="<%=sIdInmueble%>"/>
<input type="hidden" name="nota" value="A"/>
<input type="hidden" name="del" value="false"/>
<table class="bordeRojo">
    <tr><th>Notas generales</th></tr>
    <tr><td valign="top" align="center"><textarea name="NOTAS" rows="17" cols="48"><%=oNota.getNOTAS()==null?"":oNota.getNOTAS()%></textarea></td></tr>
<tr>
    <td colspan="3" class="marca" align="right">[<a href="javascript:document.fmNotaA.del.value='true';document.fmNotaA.submit();">Eliminar</a>]&nbsp;&nbsp;[<a href="javascript:document.fmNotaA.del.value='false';document.fmNotaA.submit();">Guardar</a>]</td>
</tr>
</table>
</form>
