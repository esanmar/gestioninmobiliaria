<%@page import="com.emesa.bbdd.cache.*,
				java.util.Vector" %>
<jsp:useBean id="ofel_inmueble" class="com.emesa.gestinm.dao.FEL_INMUEBLE" scope="session" />
<%
String sSelected = request.getParameter("sel");
//-- Si no hay seleccionado ningún inmueble, entonces ponemos por defecto el del usuario logado
if(
    (ofel_inmueble==null || ofel_inmueble.getCODIGO()==-1)
        &&
    (sSelected==null || sSelected.trim().equals("") || sSelected.trim().equals("-1") || sSelected.trim().equals("null"))
   ){
    %><jsp:useBean id="_profile_" class="com.emesa.gestinm.portalframework.UserProfile" scope="session" /><%
	sSelected=""+_profile_.getIdUsuario();
} 
else if(
    (ofel_inmueble!=null && ofel_inmueble.getCODIGO()!=-1)
        &&
    (sSelected==null || sSelected.trim().equals("") || sSelected.trim().equals("-1") || sSelected.trim().equals("null"))
    ) {
    sSelected="-1";
}

CacheObject cache = QueryCache.get("vendedores");
Vector vCats = cache.getQueryResults();
Vector vRowCat=null;
String sId = "-1";

%><select name="VENDEDOR">
    <option value="<%=sId%>" <%=sSelected.equals(sId)?"selected=\"selected\"":""%>>-- Sin vendedor --</option><%

	for(int i=0; i<vCats.size(); i++) {
		vRowCat=(Vector)vCats.elementAt(i);
		sId = (String)vRowCat.firstElement();

    %><option value="<%=sId%>" <%=sSelected.equals(sId)?"selected=\"selected\"":""%>><%=vRowCat.elementAt(2).toString() +" "+ vRowCat.elementAt(3) +" "+ (vRowCat.elementAt(4)==null?"":vRowCat.elementAt(4).toString()+" ") +" ("+ vRowCat.elementAt(5)+")"%></option><%
    }
%></select>