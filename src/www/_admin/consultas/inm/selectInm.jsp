<%-- /*
    [21/08/2003] seh: Para el caso de un piso que se alquile, interesa considerar si está vacío o no, 
    por lo que esta casilla no se ignorará, si está seleccionada la casilla de alquiler.

    Esto debería ir en un SERVLET...
*/
--%>
<%@page import="java.util.*,com.emesa.Configuration"%>

<%

StringBuffer sSQL=new StringBuffer();
Vector vShowParams=new Vector();
vShowParams.add("C&oacute;d.");
vShowParams.add("Tipo");
vShowParams.add("Poblaci&oacute;n");
vShowParams.add("Zona");
vShowParams.add("Direcci&oacute;n");
vShowParams.add("Num.");
vShowParams.add("Alt.");
vShowParams.add("Estado");
vShowParams.add("Sup. m<sup>2</sup>");
vShowParams.add("Venta (&euro;)");
vShowParams.add("Alq. (&euro;)");
vShowParams.add("Trasp. (&euro;)");

// comprueba si viene de las consultas de clientes
// --edu--
String sConsulta = request.getParameter("codCon");
int nConsulta=-1;

if (sConsulta==null)
{

// --edueof--


Enumeration params=request.getParameterNames();
String sTipo=request.getParameter("ID_TIPO_INMUEBLE");
String s="";

//Vector vParams=new Vector();
String sTable="";
boolean b=false;

// [16/09/2003] seh: Consideración de amueblado en alquiler
boolean bConsiderAmueblado=false;
//-- eoseh

if (sTipo!=null && (sTipo.equals("PISO") || sTipo.equals("ÁTICO") || sTipo.equals("DÚPLEX") || sTipo.equals("APARTAMENTO") || sTipo.equals("ESTUDIO"))){
	sTable="fel_piso";
    bConsiderAmueblado=true;
} else if (sTipo!=null && sTipo.equals("CHALET")) {
	sTable="fel_chalet";
    bConsiderAmueblado=true;
} else if (sTipo!=null && sTipo.equals("PARCELA/TERRENOS")) {
	sTable="fel_parcela";
} else if (sTipo!=null && sTipo.equals("OFICINA")) {
	sTable="fel_inm_oficina";
} else if (sTipo!=null && (sTipo.equals("NAVE INDUSTRIAL") || sTipo.equals("LOCAL COMERCIAL"))) {
	sTable="fel_inm_nave";
} else if (sTipo!=null && sTipo.equals("GARAJE")) {
	sTable="fel_garaje";
}

sSQL.append("SELECT i.Codigo, Tipo, Poblacion, ZONA, Direccion, Numero, trim(Piso), Estado, Superficie, Precio_venta, Precio_alquiler, Precio_traspaso FROM ");
sSQL.append("fel_inmueble i");
if(!sTable.equals(""))
    sSQL.append(",").append(sTable);


/* [21/08/2003] seh 
// Si se introduce algún dato que no sea de la tabla inmueble
if (request.getParameter("ANTIGUEDAD")!=null || request.getParameter("DORMITORIOS")!=null || request.getParameter("BANOS")!=null 
|| request.getParameter("ASCENSOR")!=null || request.getParameter("PORTERO")!=null || request.getParameter("GARAJE")!=null ||
request.getParameter("PISCINA")!=null || request.getParameter("AMUEBLADO")!=null || request.getParameter("TRASTERO")!=null || 
request.getParameter("AIRE_ACONDICIONADO")!=null || request.getParameter("COCINA_AMUEBLADA")!=null || request.getParameter("EXTERIOR")!=null || request.getParameter("CALEFACCION")!=null)
{
	sSQL.append(",");
	sSQL.append(sTable);
}
*/
if (params.hasMoreElements())
{
	sSQL.append(" WHERE ");
    if(sTable!=null && !sTable.trim().equals("")) {
        sSQL.append("i.Codigo=");
    	sSQL.append(sTable);
	    sSQL.append(".Codigo");
	    sSQL.append(" AND ");
    }
    if(sTipo!=null && !sTipo.trim().equals("") && !sTipo.trim().equals("-1"))
        sSQL.append("i.Tipo='").append(sTipo).append("' AND ");
}

//-- [20/08/2003] seh: Ponemos la condición de que el estado del inmueble no sea VENDIDO o ELIMINADO
sSQL.append(" i.Estado!=").append(Configuration.getProperty("estado.vendido")).append(" AND i.Estado!=").append(Configuration.getProperty("estado.eliminado"));
sSQL.append(" AND ");
//-- eoseh

//-- [25/08/2003] seh
boolean bPoblacion=false;
boolean bDireccion=false;
//-- eoseh
while(params.hasMoreElements()) 
{
	b=false;
	s=params.nextElement().toString().trim();

    if (s.equals("DIRECCION"))
    {
        if (!(request.getParameter("DIRECCION").trim().equals("")))
        {
            bDireccion=true;

            sSQL.append(" Direccion like '%");
            sSQL.append(request.getParameter(s));
            sSQL.append("%'");
            b=true;
        }
    }
    //-- [26/08/2003] seh: Si no se ha seleccionado dirección previamente...
    else if(s.equals("selDIRECCION") && !bPoblacion &&
            (request.getParameter("DIRECCION")==null || request.getParameter("DIRECCION").trim().equals(""))
        ){
        if (!(request.getParameter("selDIRECCION").trim().equals("")))
        {
            bDireccion=true;

            sSQL.append(" Direccion='");
            sSQL.append(request.getParameter(s));
            sSQL.append("'");
            b=true;
        }
    }
    //-- eoseh
    else if (s.equals("NUMERO"))
    {
        if(!(request.getParameter("NUMERO").trim().equals("")))
        {
            sSQL.append(" Numero=");
            sSQL.append(request.getParameter("NUMERO"));
            b=true;
        }
    }
    else if (s.equals("ZONA"))
    {
        if(!(request.getParameter("ZONA").trim().equals("")))
        {
        	if (!(request.getParameter("ZONA")).equals("-1"))
        	{
	            sSQL.append(" Zona='");
	            sSQL.append(request.getParameter("ZONA"));
	            sSQL.append("'");
	            b=true;
	        }
        }
    }
    else if (s.equals("POBLACION"))
    {
        if (!(request.getParameter("POBLACION").trim().equals("")))
        {
            bPoblacion=true;

            sSQL.append(" Poblacion like '%");
            sSQL.append(request.getParameter(s));
            sSQL.append("%'");
            b=true;
        }
    }
    //-- [25/08/2003] seh: Si no se ha seleccionado población previamente...
    else if(s.equals("selPOBLACION") && !bPoblacion &&
            (request.getParameter("POBLACION")==null || request.getParameter("POBLACION").trim().equals(""))
        ){
        if (!(request.getParameter("selPOBLACION").trim().equals("")))
        {
            bPoblacion=true;

            sSQL.append(" Poblacion='");
            sSQL.append(request.getParameter(s));
            sSQL.append("'");
            b=true;
        }
    }
    //-- eoseh
    // [25/08/2003] seh:
    else if (s.equals("EN_EXCLUSIVA"))
    {
        if (!(request.getParameter("EN_EXCLUSIVA").trim().equals("")))
        {
            sSQL.append(" EN_EXCLUSIVA=");
            sSQL.append(request.getParameter(s));
            b=true;
        }
    }

    else if (s.equals("VENTA"))
    {
	if (request.getParameter("VENTA").equals("VENTA"))
	{
	        if (request.getParameter("DESDEPRECIO")!=null)
	        {
	            if (request.getParameter("DESDEPRECIO")==null || request.getParameter("DESDEPRECIO").trim().equals(""))
                    sSQL.append(" Precio_venta > 0");
	            else
	                sSQL.append(" Precio_venta >= ").append(request.getParameter("DESDEPRECIO"));
	
	            if (request.getParameter("HASTAPRECIO")!=null && !request.getParameter("HASTAPRECIO").trim().equals("") && !request.getParameter("HASTAPRECIO").trim().equals("null"))
	            {
	                sSQL.append(" AND Precio_venta <=");
	                sSQL.append(request.getParameter("HASTAPRECIO"));
	            }
	            b=true;
	        }
	        else if (request.getParameter("HASTAPRECIO")!=null && !request.getParameter("HASTAPRECIO").trim().equals("") && !request.getParameter("HASTAPRECIO").trim().equals("null"))
	        {
	            sSQL.append(" Precio_venta <=");
	            sSQL.append(request.getParameter("HASTAPRECIO"));
	            b=true;
	        }
        
	}
	else if (request.getParameter("VENTA").equals("ALQUILER"))
	{
	        if (request.getParameter("DESDEPRECIO")!=null)
	        {
	            if (request.getParameter("DESDEPRECIO")==null || request.getParameter("DESDEPRECIO").trim().equals("null") || request.getParameter("DESDEPRECIO").trim().equals(""))
	                sSQL.append(" Precio_alquiler > 0");
	            else
	                sSQL.append(" Precio_alquiler >= ").append(request.getParameter("DESDEPRECIO"));
	            if (request.getParameter("HASTAPRECIO")!=null && !request.getParameter("HASTAPRECIO").trim().equals("") && !request.getParameter("HASTAPRECIO").trim().equals("null"))
	            {
	                sSQL.append(" AND Precio_alquiler <=");
	                sSQL.append(request.getParameter("HASTAPRECIO"));
	            }
	
	            // [21/08/2003] seh: Si no viene indicado AMUEBLADO, se considera
                // [16/09/2003] Se considera SOLO para las tablas fel_piso y fel_chalet
	            if(bConsiderAmueblado &&
                    (request.getParameter("AMUEBLADO")==null || request.getParameter("AMUEBLADO").trim().equals(""))
                   ) {
	                sSQL.append(" AND AMUEBLADO=0");
	            }
	            //-- eoseh
	            b=true;
	        }
	        else if (request.getParameter("HASTAPRECIO")!=null && !request.getParameter("HASTAPRECIO").trim().equals("") && !request.getParameter("HASTAPRECIO").trim().equals("null"))
	        {
	            sSQL.append(" Precio_alquiler <=");
	            sSQL.append(request.getParameter("HASTAPRECIO"));
	            b=true;
	        }
	}
	else if (request.getParameter("VENTA").equals("TRASPASO"))
	{
	        if (request.getParameter("DESDEPRECIO")!=null)
	        {
	            if (request.getParameter("DESDEPRECIO")==null || request.getParameter("DESDEPRECIO").trim().equals(""))
	                sSQL.append(" Precio_traspaso > 0");
	            else
	                sSQL.append(" Precio_traspaso >=").append(request.getParameter("DESDEPRECIO"));
	            if (request.getParameter("HASTAPRECIO")!=null && !request.getParameter("HASTAPRECIO").trim().equals("") && !request.getParameter("HASTAPRECIO").trim().equals("null"))
	            {
	                sSQL.append(" AND Precio_traspaso <=");
	                sSQL.append(request.getParameter("HASTAPRECIO"));
	            }
	            b=true;
	        }
	        else if (request.getParameter("HASTAPRECIO")!=null && !request.getParameter("HASTAPRECIO").trim().equals("") && !request.getParameter("HASTAPRECIO").trim().equals("null"))
	        {
	            sSQL.append(" Precio_traspaso <=");
	            sSQL.append(request.getParameter("HASTAPRECIO"));
	            b=true;
	        }
	}
    }
    else if (s.equals("TOTAL"))
    {
        if (request.getParameter("SUPENTRE")!=null)
        {
            if (request.getParameter("SUPENTRE")==null || request.getParameter("SUPENTRE").trim().equals(""))
                sSQL.append(" Superficie > 0");
            else
                sSQL.append(" Superficie >= ").append(request.getParameter("SUPENTRE"));

            if (request.getParameter("SUPY")!=null && !request.getParameter("SUPY").trim().equals("") && !request.getParameter("SUPY").trim().equals("null"))
            {
                sSQL.append(" AND Superficie <=");
                sSQL.append(request.getParameter("SUPY"));
            }
            b=true;
        }
        else if (request.getParameter("SUPY")!=null && !request.getParameter("SUPY").trim().equals("") && !request.getParameter("SUPY").trim().equals("null"))
        {
            sSQL.append(" Superficie <=");
            sSQL.append(request.getParameter("SUPY"));
            b=true;
        }
    }
    else if (s.equals("UTIL"))
    {
        if (request.getParameter("SUPENTRE")!=null)
        {
            if (request.getParameter("SUPENTRE")==null || request.getParameter("SUPENTRE").trim().equals(""))
                sSQL.append(" Sup_util > 0");
            else
                sSQL.append(" Sup_util >=").append(request.getParameter("SUPENTRE"));
            if (request.getParameter("SUPY")!=null && !request.getParameter("SUPY").trim().equals("") && !request.getParameter("SUPY").trim().equals("null"))
            {
                sSQL.append(" AND Sup_util <=");
                sSQL.append(request.getParameter("SUPY"));
            }
            b=true;
        }
        else if (request.getParameter("SUPY")!=null && !request.getParameter("SUPY").trim().equals("") && !request.getParameter("SUPY").trim().equals("null"))
        {
            sSQL.append(" Sup_util <=");
            sSQL.append(request.getParameter("SUPY"));
            b=true;
        }
    }
    else if (s.equals("CONSTRUIDA"))
    {
        if (request.getParameter("SUPENTRE")!=null)
        {
            if (request.getParameter("SUPENTRE")==null || request.getParameter("SUPENTRE").trim().equals(""))
                sSQL.append(" Sup_construida > 0");
            else
                sSQL.append(" Sup_construida >= ").append(request.getParameter("SUPENTRE"));
            if (request.getParameter("SUPY")!=null && !request.getParameter("SUPY").trim().equals("") && !request.getParameter("SUPY").trim().equals("null"))
            {
                sSQL.append(" AND Sup_construida <=");
                sSQL.append(request.getParameter("SUPY"));
            }
            b=true;
        }
        else if (request.getParameter("SUPY")!=null && !request.getParameter("SUPY").trim().equals("") && !request.getParameter("SUPY").trim().equals("null"))
        {
            sSQL.append(" Sup_construida <=");
            sSQL.append(request.getParameter("SUPY"));
            b=true;
        }
    }
    else if (s.equals("ANTIGUEDAD"))
    {
        if (!(request.getParameter("ANTIGUEDAD").trim().equals("")))
        {
            sSQL.append(" Antiguedad<=");
            sSQL.append(request.getParameter(s));
            b=true;
        }
    }
    else if (s.equals("DORMITORIOS"))
    {
        if (!(request.getParameter("DORMITORIOS").trim().equals("")))
        {
            sSQL.append(" Dormitorios>=");
            sSQL.append(request.getParameter(s));
            b=true;
        }
    }
    else if (s.equals("BANOS"))
    {
        if (!(request.getParameter("BANOS").trim().equals("")))
        {
            sSQL.append(" Banos>=");
            sSQL.append(request.getParameter(s));
            b=true;
        }
    }
    else if (s.equals("ALTURA") && !request.getParameter("ALTURA").trim().equals("")) {
        sSQL.append(" Piso like '%");
        sSQL.append(request.getParameter(s).trim());
        sSQL.append("%'");
        b=true;
    }
    else if (s.equals("CALEFACCION"))
    {
        sSQL.append(" CALEFACCION != 'No indicado'");
        b=true;
    }
    else if (s.equals("ASCENSOR"))
    {
        sSQL.append(" Ascensor=1");
        b=true;
    }
    else if (s.equals("PORTERO"))
    {
        sSQL.append(" Portero=1");
        b=true;
    }
    else if (s.equals("GARAJE"))
    {
        sSQL.append(" Garaje=1");
        b=true;
    }
    else if (s.equals("PISCINA"))
    {
        sSQL.append(" Piscina=1");
        b=true;
    }
    else if (s.equals("AMUEBLADO"))
    {
        sSQL.append(" Amueblado=1");
        b=true;
    }
    else if (s.equals("TRASTERO"))
    {
        sSQL.append(" Trastero=1");
        b=true;
    }
    //-- [03/11/2003] seh: No hay que mirar si es aire acondiconado de piso, de chalet o de nave 
    //-- xq solo se coge una tabla
    else if (s.equals("AIRE_ACONDICIONADO"))
    {
        sSQL.append(" Aire_acondicionado=1");
        b=true;
    }
    else if (s.equals("COCINA_AMUEBLADA"))
    {
        sSQL.append(" Cocina_amueblada=1");
        b=true;
    }
    else if (s.equals("EXTERIOR"))
    {
        sSQL.append(" EXTERIOR=1");
        b=true;
    }
    //#######################################################################
    //-- [21/08/2003] seh: LOCAL COMERCIAL o NAVE INDUSTRIAL
    //-- (el aire acondicionado ya está considerado arriba ^)
    else if (s.equals("FUNCION_ACTUAL") && request.getParameter(s)!=null && !request.getParameter(s).trim().equals(""))
    {
        sSQL.append(" FUNCION_ACTUAL like '%").append(request.getParameter(s).trim()).append("%'");
        b=true;
    }
    else if (s.equals("SALIDA_GASES") && request.getParameter(s)!=null && !request.getParameter(s).trim().equals(""))
    {
        sSQL.append(" SALIDA_GASES=1");
        b=true;
    }
    else if (s.equals("OFICINA") && request.getParameter(s)!=null && !request.getParameter(s).trim().equals(""))
    {
        sSQL.append(" OFICINA=1");
        b=true;
    }
    else if (s.equals("SOTANO_ALMACEN") && request.getParameter(s)!=null && !request.getParameter(s).trim().equals(""))
    {
        sSQL.append(" SOTANO_ALMACEN=1");
        b=true;
    }
    else if (s.equals("TELEFONO") && request.getParameter(s)!=null && !request.getParameter(s).trim().equals(""))
    {
        sSQL.append(" TELEFONO=1");
        b=true;
    }
    //-- eoseh
    //#######################################################################
    //-- Para CHALET y BODEGA
    else if (s.equals("SUP_JARDIN") && request.getParameter(s)!=null && !request.getParameter(s).trim().equals(""))
    {
        sSQL.append(" SUP_JARDIN>=").append(request.getParameter(s));
        b=true;
    }
    else
    {
        b=false;
    }

    if (b)
    {
        sSQL.append(" AND ");
    }
}

// Para quitar el ultimo AND, que no tiene que aparecer
sSQL=new StringBuffer(sSQL.substring(0,sSQL.length()-4));
sSQL.append(" order by FECHA_ALTA desc");

%>

<%// --edu--
}
else
{
// Si viene de las consultas de clientes
%>	
	<%@page import="com.emesa.gestinm.dao.FEL_CONSULTA"%>

<%	
	nConsulta=Integer.parseInt(sConsulta);
	FEL_CONSULTA c = new FEL_CONSULTA();
	c=c.loadFromDB(nConsulta);
    sSQL=new StringBuffer(c.getCONSULTA());
}
%>



<jsp:useBean id="consulta" class="com.emesa.dao.CargaConsulta" scope="session" /><%

Vector vSelect = new Vector();
vSelect=consulta.loadFromDB(sSQL.toString());

//--------------------------------
session.setAttribute("inf_rtado",vSelect);
session.setAttribute("inf_header",vShowParams);
session.removeAttribute("cabecera");
session.setAttribute("inf_nombre","Consulta de inmuebles");
session.setAttribute("inf_descripcion",sSQL.toString());
%>



<jsp:include page="showSelect.jsp"/>