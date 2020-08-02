<%@page import="java.util.*,com.emesa.bbdd.cache.QueryCache,com.emesa.dao.INF_PARAMETROS"%>
<jsp:useBean id="oinf_consultas" class="com.emesa.dao.INF_CONSULTAS" scope="session" />
<jsp:setProperty name="oinf_consultas" property="*" />
<%
// Recuperamos los tipos de usuario
Vector v=QueryCache.get("roles").getQueryResults();
Vector vTipoUsuario=new Vector();
for(int i=0; i<v.size(); i++) {
    vTipoUsuario.add( ((Vector)v.elementAt(i)).elementAt(1).toString() );
}

String sTipoUsuario="";

Enumeration enum=request.getParameterNames();
String s=null;
while(enum.hasMoreElements()) {
    s=enum.nextElement().toString();
    if(vTipoUsuario.contains(s)) {
        sTipoUsuario+=","+s;
    }
}

if(sTipoUsuario.indexOf("ADMINISTRADOR")==-1)
    sTipoUsuario="ADMINISTRADOR"+sTipoUsuario;
else
    sTipoUsuario=sTipoUsuario.substring(1);

// Asignamos los tipos de usuario que tienen acceso a la consulta
oinf_consultas.setTIPO_USUARIO(sTipoUsuario);

//---------------------------------------------
// No hay parámetros o borramos el registro...
if(request.getParameter("op").equals("del") || oinf_consultas.getQUERY().indexOf("?")==-1) {
    %><jsp:include page="inf_consultas_upd.jsp"/><%
}
//---------------------------------------------
// Parámetros...
else {
    %><p>&nbsp;Todos los campos excepton la descripci&oacute;n son obligatorios. No olvide introducir los par&aacute;metros en el mismo orden en el que aparecen en la <i>query</i>, asimismo, el valor del <em>nombre</em> debe corresponderse con el valor del campo en la tabla.</p><blockquote><em>Query:</em> <%=oinf_consultas.getQUERY()%></blockquote><%
    int nParams=0;
    int lastIndexOf=-1;

    do {
        lastIndexOf=oinf_consultas.getQUERY().indexOf("?",(lastIndexOf+1));
        if(lastIndexOf!=-1) {
            nParams++;
        }
    } while(lastIndexOf!=-1);

%><form method="post" action="index.jsp">
<input type="hidden" name="tab" value="adm"/>
<input type="hidden" name="acc" value="inf"/>
<input type="hidden" name="acc2" value="upd2"/>
<input type="hidden" name="nparams" value="<%=nParams%>"/>
<input type="hidden" name="op" value="<%=request.getParameter("op")%>"/>
<table>
    <tr>
        <th></th>
        <th>Nombre en BB.DD.</th>
        <th>Nombre a mostrar</th>
        <th>Descripci&oacute;n</th>
        <th>Tipo</th>
        <!--th>Acci&oacute;n</th-->
    </tr><%
    Vector vParamsOfQuery=INF_PARAMETROS.paramsOfQuery(oinf_consultas.getID_CONSULTA());
    INF_PARAMETROS o=null;
    String sTipo="";
    for(int i=0; i<nParams; i++) {
        if(vParamsOfQuery.size()>i)
            o=(INF_PARAMETROS)vParamsOfQuery.elementAt(i);
        else
            o=new INF_PARAMETROS();
        %><tr valign="top">
            <td align="center"><%=i+1%><input type="hidden" value="<%=o.getID_PARAMETRO()%>" name="ID_PARAMETRO<%=i%>"</td>
            <td><input type="text" name="NOMBRE<%=i%>" value="<%=o.getNOMBRE()==null?"":o.getNOMBRE()%>"/></td>
            <td><input type="text" name="NOMBRE_MOSTRAR<%=i%>" value="<%=o.getNOMBRE_MOSTRAR()==null?"":o.getNOMBRE_MOSTRAR()%>"/></td>
            <td><input type="text" name="DESCRIPCION<%=i%>" value="<%=o.getDESCRIPCION()==null?"":o.getDESCRIPCION()%>"/></td>
            <td><%sTipo="TIPO"+i;%><jsp:include page="/inc/comboParamTipo.jsp">
                <jsp:param name="name" value="<%=sTipo%>"/>
                <jsp:param name="sel" value="<%=o.getTIPO()%>"/>
                </jsp:include></td>
            <!--td><input type="text" name="ACCION<%=i%>"/></td-->
        </tr><%
    }
%><tr>
    <td colspan="5" align="right"><input type="submit" class="boton" value="Continuar"/></td>
  </tr>
  </table>
</form><%
}
%>