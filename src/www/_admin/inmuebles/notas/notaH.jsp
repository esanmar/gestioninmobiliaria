<%@page import="java.util.Vector,com.emesa.gestinm.dao.FEL_NOTA_H"%><%

String sIdInmueble=request.getParameter("cod");
FEL_NOTA_H oNota=new FEL_NOTA_H();
if(sIdInmueble!=null && !sIdInmueble.trim().equals(""))
    oNota.loadFromDB(Integer.parseInt(sIdInmueble));
%>
<form method="post" action="nota_upd.jsp" name="fmNotaH">
<input type="hidden" name="CODIGO" value="<%=sIdInmueble%>"/>
<input type="hidden" name="nota" value="H"/>
<input type="hidden" name="del" value="false"/>
<table class="bordeRojo" border="0">
    <tr>
        <th colspan="3">Nota <em>H</em> (precio)</th>
    </tr>
    <tr>
        <td valign="top"><b>Forma de pago</b>:</td>
        <td colspan="2"><input type="text" name="FORMA_PAGO" value="<%=oNota.getFORMA_PAGO()==null?"":oNota.getFORMA_PAGO()%>"/></td>
    </tr>
    <tr>
        <td valign="top"><b>Negociable</b>:</td>
        <td colspan="2"><input type="text" name="NEGOCIABLE" value="<%=oNota.getNEGOCIABLE()==null?"":oNota.getNEGOCIABLE()%>"/></td>
    </tr>
    <tr>
        <td colspan="3" align="center" valign="top" ><textarea name="NOT_PRECIO" rows="8" cols="48"><%=oNota.getNOT_PRECIO()==null?"":oNota.getNOT_PRECIO()%></textarea></td>
    </tr>
<tr>
    <td colspan="3" class="marca" align="right">[<a href="javascript:document.fmNotaH.del.value='true';document.fmNotaH.submit();">Eliminar</a>]&nbsp;&nbsp;[<a href="javascript:document.fmNotaH.del.value='false';document.fmNotaH.submit();">Guardar</a>]</td>
</tr>
</table>
</form>