<%@page import="java.util.*,net.seh.util.Pager"%><%

Collection oSearchCollection = (Collection)request.getAttribute("search_collection");
Collection oSearchHeader = (Collection)request.getAttribute("search_header");
String sPageSize=request.getParameter("ps");
String sDestino=request.getParameter("dest");
if(sPageSize==null || sPageSize.trim().equals(""))
	sPageSize="10";

if(oSearchCollection==null || oSearchCollection.isEmpty()) {
%><p align="center"><i>La cartera de inmuebles est&aacute; vac&iacute;a</i></p><%
} else {
%><script language="JavaScript">

<!--
function submitPageForm(nPag) {
	document.fmPage.pag.value=nPag;
	document.fmPage.submit();
}
//-->
</script><%

	/*###################################################
		Recogemos los par�metros:
			- oSearchCollection
			- Tama�o de p�gina
			- Color de fondo y de "frente"

        Para 'Mi Cartera', las posiciones a considerar para enlace son:
            #0 --> C�digo del inmueble
            #8 --> C�digo del propietario
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

	/*###################################################
		Situamos la p�gina
	*/
	p.setAtPage(nPag);
	List l = p.next();


	/*###################################################
		Mostramos los resultados de forma tabular.
		Si es una Collection de Collections, formamos filas con
		cada Collection primera y las columnas se corresponder�n al
		segundo nivel de Collection
	*/
	Iterator oInnerIt;


	/*###################################################
		Colocamos los enlaces de paginaci�n
			[Anterior] [1 2 3 ... n] [Siguiente]
	*/
%><table border="0" width="100%" align="center"><tr><td align="center"><strong><%=p.getTotalPages() * p.getPageSize()%></strong> resultados: <%
	if(p.hasPrevious()) {
	%><span class="pslink" onclick="javascript:submitPageForm(<%=nPag-1%>)">&nbsp;&laquo;]&nbsp;</span><%
	}%>[
		<%for(int i=1; i<=p.getTotalPages(); i++) { %>
			<%if(p.getPage()!=i) {%>
				<span class="pslink" onclick="javascript:submitPageForm(<%=i%>)"><%=i%></span>
			<%} else {%>
			<b><%=i%></b>
		<%}}%>]<%

if(p.hasNext()) {
    %><span class="pslink" onclick="javascript:submitPageForm(<%=nPag+1%>)">&nbsp;[&raquo&nbsp;</span><%
	}
	%></td></tr></table><%
//###################################################
%><table align="center" cellpadding="3"><%

	/*
		Mostramos la cabecera... si la tiene
	*/
	if (oSearchHeader!=null && !oSearchHeader.isEmpty())
	{
		oInnerIt = oSearchHeader.iterator();
		out.println("<tr>");
		while(oInnerIt.hasNext()) {
			out.println("<th>"+oInnerIt.next()+"</th>");
		}
		out.println("<tr/>");
	}
	
    for(int i=0; i<l.size(); i++) { %>
			<tr class="<%=i % 2==0?"odd":"even"%>">
			<%
				// Si el elemento es a su vez un Collection...
				if(implementsCollection(l.get(i))) {
					oInnerIt = ((Collection)l.get(i)).iterator();
					Object o;
                    int j=-1;
					while(oInnerIt.hasNext()) {
                        j++;
						o = oInnerIt.next();
                        if(j==0) {
                        %><td align="center"><a href="index.jsp?tab=inm&xCodigo=<%=(o==null?"":o.toString())%>"><%=(o==null?"":o.toString())%></a></td><%
                        } else if (j==8) {
                        %><td><a href="index.jsp?tab=prov&xID_PROPIETARIO=<%=(o==null?"":o.toString())%>"><%o = oInnerIt.next();%><%=(o==null?"":o.toString())%></a></td><%
                        } else {%>
						<td><%=(o==null?"":o.toString())%></td><%
                        }
                    }
					if( ((Collection)l.get(i)).isEmpty() ) {
						out.println("<td align=\"center\"> - </td>");
					}
				} else {

            %><td><%=(l.get(i)==null?"":l.get(i).toString())%></td><%
			    }

			%></tr><%

            }
			// Si los �ltimos elementos no cubren toda la tabla,
			// la completamos con blancos para mantener el tama�o
			if(!p.hasNext() && l.size()<p.getPageSize()) {
				for(int i=0; i < (p.getPageSize() - l.size()); i++) {
					out.println("<tr><td>&nbsp;</td></tr>");
				}
		}
%></table><%--

	/*###################################################
		Colocamos los enlaces de paginaci�n
			[Anterior] [1 2 3 ... n] [Siguiente]
	*/
--%><table border="0" width="100%" align="center"><tr><td align="center"><strong><%=p.getTotalPages() * p.getPageSize()%></strong> resultados: <%
	if(p.hasPrevious()) {
	%><span class="pslink" onclick="javascript:submitPageForm(<%=nPag-1%>)">&nbsp;&laquo;]&nbsp;</span><%
	}%>[<%
		for(int i=1; i<=p.getTotalPages(); i++) { 
			if(p.getPage()!=i) {
				%><span class="pslink" onclick="javascript:submitPageForm(<%=i%>)"><%=i%></span><%
			} else {
			%><b><%=i%></b><%
		}}%>]<%

if(p.hasNext()) {
    %><span class="pslink" onclick="javascript:submitPageForm(<%=nPag+1%>)">&nbsp;[&raquo&nbsp;</span><%
	}
	%></td></tr></table><%
//###################################################


/*###################################################
    Formamos el formulario que junto con la funci�n JS
    servir� para navegar sin necesidad de mostrar
    los par�metros de navegaci�n.
*/

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
    }
%>
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