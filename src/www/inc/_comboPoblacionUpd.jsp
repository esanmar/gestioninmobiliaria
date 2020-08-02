<%@page import="com.emesa.gestinm.bbdd.cache.CacheUtil,com.emesa.bbdd.cache.*,java.util.Vector"%><%

String s = request.getParameter("__poblacion");

if(s==null || s.trim().equals(""))
    s=request.getParameter("__poblacionX");
    %>|<%=s%>|