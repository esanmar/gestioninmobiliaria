<%@page import="java.util.*,net.seh.util.Pager"%>
<style type="text/css">
<!--
.pslink {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
	color: #336699;
	cursor: hand;
}
-->
</style>
<%
Collection oSearchCollection = (Collection)request.getAttribute("search_collection");
Collection oSearchHeader = (Collection)request.getAttribute("search_header");
String sPageSize=request.getParameter("ps");
String sDestino=request.getParameter("dest");
if(sPageSize==null || sPageSize.trim().equals(""))
	sPageSize="10";

if(oSearchCollection==null || oSearchCollection.isEmpty()) {
%>
<p align="center"><i>No se encontraron resultados</i>
</p>
<%} else {%>
<script language="JavaScript">
<!--
function submitPageForm(nPag) {
	document.fmPage.pag.value=nPag;
	document.fmPage.submit();
}
//-->
</script>
<%
	/*###################################################
		Recogemos los parámetros:
			- oSearchCollection
			- Tamaño de página
			- Color de fondo y de "frente"
	*/
	Pager p = new Pager(oSearchCollection,Integer.parseInt(sPageSize));

	String sPag=request.getParameter("pag");
	int nPag;
	if(sPag!=null && !sPag.trim().equals(""))
		nPag = Integer.parseInt(sPag);
	else
		nPag=1;

	String sSC=request.getParameter("sbc");
	if(sSC==null || sSC.trim().equals(""))
		sSC="#9D9DFF";

	String sSFC=request.getParameter("sfc");
	if(sSFC==null || sSFC.trim().equals(""))
		sSFC="#000000";

	String sHC=request.getParameter("hbc");
	if(sHC==null || sHC.trim().equals(""))
		sHC="#009999";

	String sHFC=request.getParameter("hfc");
	if(sHFC==null || sHFC.trim().equals(""))
		sHFC="#000000";


	/*###################################################
		Situamos la página
	*/
	p.setAtPage(nPag);
	List l = p.next();


	/*###################################################
		Mostramos los resultados de forma tabular.
		Si es una Collection de Collections, formamos filas con
		cada Collection primera y las columnas se corresponderán al
		segundo nivel de Collection
	*/
	Iterator oInnerIt;

%><table align="center"><%

	/*
		Mostramos la cabecera... si la tiene
	*/
	if (oSearchHeader!=null && !oSearchHeader.isEmpty())
	{
		oInnerIt = oSearchHeader.iterator();
		out.println("<tr bgcolor=\""+sHC+"\">");
		while(oInnerIt.hasNext()) {
			out.println("<th>"+oInnerIt.next()+"</th>");
		}
		out.println("<tr/>");
	}
	
    for(int i=0; i<l.size(); i++) { %>
			<tr bgcolor="<%=i % 2==0?"#FFFFFF":sSC%>">
			<%
				// Si el elemento es a su vez un Collection...
				if(implementsCollection(l.get(i))) {
					oInnerIt = ((Collection)l.get(i)).iterator();
					Object o;
					boolean b=true;;
					while(oInnerIt.hasNext()) { 
						o = oInnerIt.next();

						if (o!=null && b)
						{
							b=false;

                        // [20/08/2003] seh: Asignamos a la ventana que nos ha abierto el código del propietario
                        %><td align="center"><font color="<%=sSFC%>"><a href="javascript:window.opener.document.fmUpdate.COD_PROPIETARIO.value=<%=o.toString().trim()%>; window.close()"><%=(o==null?"":o.toString())%></a></font></td>
						<%} else {%>
						<td><font color="<%=sSFC%>"><%=(o==null?"":o.toString())%></font></td>
						<% } %>
<%				}
					if( ((Collection)l.get(i)).isEmpty() ) {
						out.println("<td align=\"center\"> - </td>");
					}
				} else {

            %><td><%=(l.get(i)==null?"":l.get(i).toString())%></td><%
			    }

			%></tr><%

            }
			// Si los últimos elementos no cubren toda la tabla,
			// la completamos con blancos para mantener el tamaño
			if(!p.hasNext() && l.size()<p.getPageSize()) {
				for(int i=0; i < (p.getPageSize() - l.size()); i++) {
					out.println("<tr><td>&nbsp;</td></tr>");
				}
		}
%></table><%--

	/*###################################################
		Colocamos los enlaces de paginación
			[Anterior] [1 2 3 ... n] [Siguiente]
	*/

--%><p align="center">
	<% if(p.hasPrevious()) {%>
	<span class="pslink" onclick="javascript:submitPageForm(<%=nPag-1%>)">&nbsp;&laquo;]&nbsp;</span>
	<%}%>[
		<%for(int i=1; i<=p.getTotalPages(); i++) { %>
			<%if(p.getPage()!=i) {%>
				<span class="pslink" onclick="javascript:submitPageForm(<%=i%>)"><%=i%></span>
			<%} else {%>
			<b><%=i%></b>
		<%}}%>]<%

if(p.hasNext()) {
    %><span class="pslink" onclick="javascript:submitPageForm(<%=nPag+1%>)">&nbsp;[&raquo&nbsp;</span><%
	}
	%></p><%--


	/*###################################################
		Formamos el formulario que junto con la función JS
		servirá para navegar sin necesidad de mostrar
		los parámetros de navegación.
	*/
--%>
<%
if (sDestino==null || sDestino.trim().equals(""))
	sDestino=request.getRequestURI();
%>
	<form action="<%=sDestino%>" method="post" name="fmPage">
<%
	Enumeration enum = request.getParameterNames();
	String sKey="";
	for(int i=0; enum.hasMoreElements(); i++) {
		sKey = (String)enum.nextElement();
		if(sKey.equals("pag"))
			continue;

		%><input type="hidden" name="<%=sKey%>" value="<%=request.getParameter(sKey)%>"/><%

    }
		%><input type="hidden" name="pag" value="1"/>
	</form><%
}%>
<%!
	boolean implementsCollection(Object o) {
		Class []aIFaces = o.getClass().getInterfaces();
		for(int j=0; j<aIFaces.length; j++) {
			if(aIFaces[j].getName().equals("java.util.List") ||
					aIFaces[j].getName().equals("java.util.Set") ||
					aIFaces[j].getName().equals("java.util.Collection")
				)
				return true;
		}

		return false;
	}
%>