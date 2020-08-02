<%@page import="java.util.*,com.emesa.gestinm.dao.FotosInmueble"%>
<jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" /><%

Vector vFotos=ofel_inmueble.getPictures();
%><html>
<head>
    <title>Fotos</title>
    <link rel="stylesheet" type="text/css" href="/gestinm/css/gestinm_admin.css">
</head>
<body onload="javascript:showPictureNumber();">
<script language="JavaScript">
<!--
var ie = (document.all)? true:false;
var ns = (document.layers)? true:false;

var index=0;
// Pre-cacheamos las imágenes...
<%
for(int i=0; i<vFotos.size();i++) {
    %>image<%=i%> = new Image(200,120);
    image<%=i%>.src = "<%=com.emesa.Configuration.getProperty("pictures.prefix")%>/<%=ofel_inmueble.getCODIGO()%>/<%=((FotosInmueble)vFotos.elementAt(i)).getPATH_FOTO()%>";
<%
}%>
// Load an image chosen from select list
function loadCached(nav) {
    if(index==0 && nav<0) {
        index=0;
    }
    else if(index==<%=vFotos.size()-1%> && nav>0) {
        index=<%=vFotos.size()-1%>;
    }
    else if(nav<0) {
        index=index-1;
    }
    else if(nav>0) {
        index=index+1;
    }

    var img = "image"+index;
    document.thumbnail.src = eval(img + ".src");
}

function showPictureNumber() {
    if(ie) {
        document.all.capaVentana.innerHTML="[ <b>"+(index+1)+" / <%=vFotos.size()%></b> ]&nbsp;";
    }
    else if(ns) {
        document.layers.capaVentana.innerHTML="[ <b>"+(index+1)+" / <%=vFotos.size()%></b> ]&nbsp;";
    }
}
//-->
</script>
<table align="center" cellpadding="0" cellspacing="2" class="bordeRojo">
    <tr>
        <td colspan="2"><img src="<%=com.emesa.Configuration.getProperty("pictures.prefix")%>/<%=ofel_inmueble.getCODIGO()%>/<%=((FotosInmueble)vFotos.firstElement()).getPATH_FOTO()%>" name="thumbnail" height="480" width="640" border="0"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center" style="{color:#990000; background-color: #BDBCCB;}">
            <div id="capaVentana"></div>
        </td>
    </tr>
    <tr>
        <td align="center" style="{cursor:hand; color:#990000; font-size: 32px; font-wight: bold;background-color: #BDBCCB;}" onclick="javascript:loadCached(-1);showPictureNumber();">&laquo;</td>
        <td align="center" style="{cursor:hand; color:#990000; font-size: 32px; font-wight: bold;background-color: #BDBCCB;}"  onclick="javascript:loadCached(1);showPictureNumber();">&raquo;</td>
        </td>
    </tr>
</table>
</body>
</html>