<%@page import="java.util.Vector"%>

<jsp:useBean id="o" class="com.emesa.gestinm.dao.FEL_CONSULTA" scope="session" />
<%-- ###############################################################
// Cargamos en el objeto lo que recibimos del formulario
--%>

<%
String sSQL = request.getParameter("SQL");
String sConsulta=request.getParameter("CONSULTA");
int nCodCli=Integer.parseInt(request.getParameter("COD_CLIENTE"));


o.setCONSULTA(sSQL);
o.setNOMBRE(sConsulta);
o.setID_CLIENTE(nCodCli);


boolean bError=false;

try 
{
    	o.saveToDB();
    %>&nbsp;(Se ha añadido la consulta al cliente)<br/><%
}
  catch(Exception e) {
    System.err.println("[fel_consulta_upd.jsp] Error: "+e);
    bError=true;
%>&nbsp;(<span class="err">Error, no se ha podido actualizar el registro <b></b> en la BB.DD.</span><br/><%
}

if(!bError) 
{

// llevar al pagina de clientes...

%>


<%
  // Eliminamos la variable de la sesion
  session.removeAttribute("o");

}
%>
