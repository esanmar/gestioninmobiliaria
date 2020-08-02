<%@page import="java.util.Enumeration,com.emesa.dao.INF_PARAMETROS"%>
<jsp:useBean id="oinf_consultas" class="com.emesa.dao.INF_CONSULTAS" scope="session" />
<jsp:include page="inf_consultas_upd.jsp"/>
<ul><%

int nParams=Integer.parseInt(request.getParameter("nparams"));
INF_PARAMETROS o=null;
for(int i=0; i<nParams; i++) {
    o=new INF_PARAMETROS();
    o.setID_PARAMETRO(Integer.parseInt(request.getParameter("ID_PARAMETRO"+i)));
    o.setNOMBRE(request.getParameter("NOMBRE"+i));
    o.setNOMBRE_MOSTRAR(request.getParameter("NOMBRE_MOSTRAR"+i));
    o.setTIPO(request.getParameter("TIPO"+i));
    o.setDESCRIPCION(request.getParameter("DESCRIPCION"+i));

    if (oinf_consultas.getID_CONSULTA()==-1) {
        oinf_consultas.loadFromDB(oinf_consultas.getNOMBRE());
    }

    o.setID_CONSULTA(oinf_consultas.getID_CONSULTA());

    try {
        o.saveToDB();
        %><li>Guardado el par&aacute;metro <b><%=request.getParameter("NOMBRE"+i)%></b> en BB.DD.</li><%
    }
    catch(Exception e) {
        %><li class="err">No se ha podido guardar el par&aacute;metro <b><%=request.getParameter("NOMBRE"+i)%></b> en BB.DD.</li><%
    }
}
%></ul>
