<%@page import="com.emesa.dao.Informe,com.emesa.dao.INF_PARAMETROS,java.util.*,java.text.SimpleDateFormat,com.emesa.Configuration"%>
<%
String sId=request.getParameter("ID_CONSULTA");
Vector vParamValues=new Vector();
Informe inf=new Informe();
inf.load(Integer.parseInt(sId));

// Si no hay parámetros que rellenar, ejecutamos la query y guardamos el resultado en sessión
if(inf.getParameters().isEmpty()) {
    session.setAttribute("inf_header",inf.getHeader());
    session.setAttribute("inf_rtado",inf.execute(vParamValues));
    session.setAttribute("inf_nombre",inf.getNombreConsulta());
    session.setAttribute("inf_descripcion",inf.getDescripcion());

    %><jsp:include page="showResults.jsp"/><%
}
else {
    // Si hay parámetros que recoger... los recogemos y los guardamos en vParamValues
    if(request.getParameter(((INF_PARAMETROS)inf.getParameters().firstElement()).getNOMBRE())!=null) {
        for(int i=0; i<inf.getParameters().size(); i++) {
            vParamValues.add(request.getParameter( ((INF_PARAMETROS)inf.getParameters().elementAt(i)).getNOMBRE()));
        }

        session.setAttribute("inf_header",inf.getHeader());
        session.setAttribute("inf_rtado",inf.execute(vParamValues));
        session.setAttribute("inf_nombre",inf.getNombreConsulta());
        session.setAttribute("inf_descripcion",inf.getDescripcion());

        %><jsp:include page="showResults.jsp"/><%
    }
    else {

    //---------------------------------------------------------
        /* #######################################################################
            Consideramos los siguientes tipos de parámetros:
                - texto: Tipo 'text'
                - fecha: Tipo 'text' con formato yyyy-MM-dd
                - provincia: Combo de provincias
                - pais: Combo de paises
                - vendedor: Combo con todos los vendedores
                - ofcina: Combo con las oficinas de la inmobiliaria
        */
        %><form method="post" action="index.jsp">
        <input type="hidden" name="tab" value="inf"/>
        <input type="hidden" name="acc" value="prepar"/>
        <input type="hidden" name="ID_CONSULTA" value="<%=inf.getIdConsulta()%>"/>
        <table><%
        INF_PARAMETROS o=null;
        for (int i=0;i<inf.getParameters().size(); i++) {
            o=(INF_PARAMETROS)inf.getParameters().elementAt(i);

            %><tr>
            <td><%=o.getNOMBRE_MOSTRAR()%>:</td><%

            if(o.getTIPO().equalsIgnoreCase("provincia")) {
        
        %><td><jsp:include page="/inc/comboProvincia.jsp"/></td><%

            } else if(o.getTIPO().equalsIgnoreCase("pais")) {

        %><td><jsp:include page="/inc/comboPais.jsp"/></td><%

            } else if(o.getTIPO().equalsIgnoreCase("vendedor")) {

        %><td><jsp:include page="/inc/comboVendedor.jsp"/></td><%
            } else if(o.getTIPO().equalsIgnoreCase("fecha")) {

        %><td><input type="text" name="<%=o.getNOMBRE()%>" size="10" maxlength="10" value="<%=((new SimpleDateFormat(Configuration.getProperty("db.date_format"))).format(new Date()))%>"/> <span class="nota">Formato aaaa-mm-dd</span></td><%
            } else if(o.getTIPO().equalsIgnoreCase("oficina")) {

        %><td><jsp:include page="/inc/comboOficina.jsp"/></td><%
            } else {
        
        %><td><input type="text" name="<%=o.getNOMBRE()%>"/></td><%
            }
            %></tr><%
        } // eoFor
        %>
        <tr>
            <td colspan="2" align="right"><input type="submit" class="boton" value="Enviar"/></td>
        </tr></table>
        </form><%
    }
    //---------------------------------------------------------
}%>
