<html>
<head>
<link href="css/gestinm_admin.css" rel="stylesheet" type="text/css" />
<script language="javascript">
<!--
    var sHeader="<table border=\"0\" width=\"100%\"><tr><td class=\"bordeVerde2\"><img src=\"/gestinm/images/logo_small.jpg\"> <span class=\"inmTitle\"> <%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%> </span></td></tr></table>";
    var sFooter="<table border=\"0\" width=\"100%\"><tr><td class=\"bordeVerde2\" align=\"right\"><span class=\"footerPrint\"><strong><%=com.emesa.gestinm.Customization.getProperty("gestinm.title")%></strong> - <%=com.emesa.gestinm.Customization.getProperty("gestinm.subtitle")%></span></td></tr></table>";

	var ns = (document.layers)? true:false;
	var ie = (document.all)? true:false;

	function prePrint()
	{
		document.all.imprDown.style.visibility = "hidden";
		document.all.cerrDown.style.visibility = "hidden";
	}

	function postPrint()
	{
 		window.onafterprint = setTimeout("window.close()", 5000);
	}

	function cargar()
	{
		document.all.capaVentana.innerHTML = sHeader+window.opener.document.all.toPrintLayer.innerHTML+sFooter;
		var i;
        /*
		for(i=0; i < document.all.capaVentana.all.length; i++)
		{
			document.all.capaVentana.all(i).disabled = true;
		}
        */
		if ( window.opener.document.forms.lanzaImpresion != null )
			window.opener.document.forms.lanzaImpresion.submit();
	}
//-->
</script>
</head>
<body onload="javascript:cargar();">
	<table width="90%" border="0">
	<tr><td align="right">
		<img src="images/printer.png" name="imprDown" id="imprDown" onclick="javascript:prePrint();window.print();postPrint();" alt="Imprimir" style="{cursor: hand}"/>&nbsp;
		<img src="images/x.png" name="cerrDown" id="cerrDown" onclick="javascript:window.close();" alt="Cerrar" style="{cursor: hand}"/>
	</td></tr>
	</table>
	<center>
		<div id="capaVentana">
		</div>
	</center>
</body>
</html>