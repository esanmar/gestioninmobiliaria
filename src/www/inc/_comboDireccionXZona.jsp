<html><head>
<%@page import="com.emesa.bbdd.cache.*,java.util.Vector"%><%

QueryCache.reloadQuery("zonas");
QueryCache.reloadQuery("direcciones");

%><script language="javascript">
<!--
//---------------------------------------------------------------------------------------------------
    function poblar(s) {
        alert("Poblando: "+s);
        document.xx.selDIRECCION.length=0;
    <%
        String sZona="";
        Vector vZonas = QueryCache.get("zonas").getQueryResults();
        Vector vDirs=new Vector();
        if(vZonas!=null) {
            for(int i=0; i<vZonas.size(); i++) {
                sZona=((Vector)vZonas.elementAt(i)).elementAt(1).toString();
                %>
                if(s=='<%=sZona%>') {
                    <%
                        vDirs=com.emesa.gestinm.bbdd.cache.CacheUtil.getDirecciones(sZona);
                        for(int j=0; j<vDirs.size(); j++) {
                    %>
                            newOpt=document.createElement("OPTION")
                            newOpt.text = '<%=((Vector)vDirs.elementAt(j)).firstElement()%>';
                            document.xx.selDIRECCION.options.add(newOpt,<%=j%>);<%
                        }
                %>}
            <%}
        }%>
}
//-->
</script>
</head>
<body>
<select name="" onchange="javascript:poblar(this.options[this.selectedIndex].text)">
    <option>CENTRO</option>
    <option>AVDA. BURGOS</option>
</select>
<form method="post" name="xx">
<select name="selDIRECCION">
</select>
</form>
</body></html>