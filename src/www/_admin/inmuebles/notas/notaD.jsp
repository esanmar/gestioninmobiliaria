<%@page import="java.util.Vector,com.emesa.gestinm.dao.FEL_NOTA_D"%><%

String sIdInmueble=request.getParameter("cod");
FEL_NOTA_D oNota=new FEL_NOTA_D();
if(sIdInmueble!=null && !sIdInmueble.trim().equals(""))
    oNota.loadFromDB(Integer.parseInt(sIdInmueble));
%>
<form method="post" action="nota_upd.jsp" name="fmNotaD">
<input type="hidden" name="CODIGO" value="<%=sIdInmueble%>"/>
<input type="hidden" name="nota" value="D"/>
<input type="hidden" name="del" value="false"/>
<table class="bordeRojo">
    <tr>
        <th colspan="3">Nota <em>D</em> (materiales)</th>
    </tr>
    <tr>
        <td valign="top"><b>Materiales</b>:</td>
        <td colspan="2" valign="top"><textarea name="MATERIALES" rows="10" cols="30"><%=oNota.getMATERIALES()==null?"":oNota.getMATERIALES()%></textarea></td>
    </tr>
    <tr>
        <td valign="top"><b>Obras a realizar</b>:</td>
        <td colspan="2" valign="top"><textarea name="OBRAS" rows="10" cols="30"><%=oNota.getOBRAS()==null?"":oNota.getOBRAS()%></textarea></td>
    </tr>
<tr>
    <td colspan="3" class="marca" align="right">[<a href="javascript:document.fmNotaD.del.value='true';document.fmNotaD.submit();">Eliminar</a>]&nbsp;&nbsp;[<a href="javascript:document.fmNotaD.del.value='false';document.fmNotaD.submit();">Guardar</a>]</td>
</tr>
</table>
</form>