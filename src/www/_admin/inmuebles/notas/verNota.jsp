<html>
<head>
    <title>Notas</title>
    <link rel="stylesheet" type="text/css" href="/gestinm/css/gestinm_admin.css">
</head>
<body>
<%
String sNota=request.getParameter("nota");

if(sNota==null)
    sNota="A";

String sFileNota="nota"+sNota+".jsp";
%>
<form method="post" action="verNota.jsp">
<input type="hidden" name="cod" value="<%=request.getParameter("cod")%>"/>
<table><tr><td><select name="nota" onchange="javascript:document.forms[0].submit();">
    <option value="A"<%="A".equals(sNota)?" selected=\"true\"":""%>>(A) Generales</option>
    <option value="B"<%="B".equals(sNota)?" selected=\"true\"":""%>>(B) Captaci&oacute;n</option>
    <option value="C"<%="C".equals(sNota)?" selected=\"true\"":""%>>(C) Propietarios</option>
    <option value="D"<%="D".equals(sNota)?" selected=\"true\"":""%>>(D) Materiales</option>
    <option value="E"<%="E".equals(sNota)?" selected=\"true\"":""%>>(E) Otros datos</option>
    <option value="F"<%="F".equals(sNota)?" selected=\"true\"":""%>>(F) Entorno</option>
    <option value="G"<%="G".equals(sNota)?" selected=\"true\"":""%>>(G) Destacable</option>
    <option value="H"<%="H".equals(sNota)?" selected=\"true\"":""%>>(H) Precio</option>
    <option value="I"<%="I".equals(sNota)?" selected=\"true\"":""%>>(I) Datos registrales</option>
    <option value="J"<%="J".equals(sNota)?" selected=\"true\"":""%>>(J) Ref. inmobiliarias</option>
    <option value="all"<%="all".equals(sNota)?" selected=\"true\"":""%>>-- Todas --</option>
</select></td>
<td><input type="button" value="Cerrar" class="boton" onclick="window.close();"/></td>
</tr>
</table>
</form>
<jsp:include page="<%=sFileNota%>"/>
</body>
</html>