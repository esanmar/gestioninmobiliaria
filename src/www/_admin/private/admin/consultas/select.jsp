<%@page import="java.util.*"%>
<%
Enumeration params=request.getParameterNames();
Enumeration paramsValue;
Enumeration paramsY;
Enumeration paramsO;
Vector vShowParams=new Vector();
Vector vOperParams=new Vector();
Vector vValueParams=new Vector();
Vector vOrdenParams=new Vector();
Vector vCondYParams=new Vector();
Vector vCondOParams=new Vector();
Vector vWhereParam=new Vector();
StringBuffer sCondicion=new StringBuffer();
Vector vCondicion=new Vector();
String s;
String sValue;
int i;
int cont=0;
boolean b;
StringBuffer campo = new StringBuffer();

while(params.hasMoreElements()) {
b = false;
    s=params.nextElement().toString();
    if(s.startsWith("_show") && !vShowParams.contains(s)) {
        vShowParams.add(s.substring("_show".length()));
    }
    else if(s.startsWith("_oper")) {
        if ( !request.getParameter(s).equals("-1") )
        {
            cont++;
            sCondicion= new StringBuffer();
            // Si no es la primera vez que entra coloca el operador AND, OR lo primero
            if(cont>1)
            {
                campo=new StringBuffer();
                campo.append("_condY");
                campo.append( s.substring("_oper".length()) );

                paramsY=request.getParameterNames();
                paramsO=request.getParameterNames();

                while(paramsY.hasMoreElements())
                { 
                    sValue = paramsY.nextElement().toString();
                    if( sValue.equals(campo.toString()) )
                    {
                        sCondicion.append( " AND " );
                        b = true;
                    }
                }

                campo=new StringBuffer();
                campo.append("_condO");
                campo.append( s.substring("_oper".length()) );
                while(paramsO.hasMoreElements())
                { 
                    sValue = paramsO.nextElement().toString();
                    if( sValue.equals(campo.toString()) )
                    {
                        sCondicion.append( " OR " );
                        b = true;
                    }
                }
            }
            
            // Una vez colocado el operador (AND, OR) continuamos con el resto
            campo=new StringBuffer();
            
            sCondicion.append(s.substring("_oper".length()));
            sCondicion.append(" ");
            sCondicion.append( request.getParameter(s) );
            sCondicion.append(" ");
            
            campo.append("_value");
            campo.append( s.substring("_oper".length()) );
            
            vOperParams.add( request.getParameter(s) );
            vWhereParam.add(s.substring("_oper".length()));
            
            paramsValue=request.getParameterNames();
            
            while(paramsValue.hasMoreElements())
            { 
                sValue = paramsValue.nextElement().toString();
                if( sValue.equals(campo.toString()) )
                {
                    sCondicion.append("'");
                    sCondicion.append( request.getParameter(sValue) );
                    sCondicion.append("'");
                    b = true;
                }
            }
        }
    }
   
    else if(s.startsWith("_orden")) {
        if (! request.getParameter(s).equals("-1"))
        {
            vOrdenParams.add(s.substring("_orden".length()));
            vOrdenParams.add(request.getParameter(s));
        }
    }
        
    if (b)
    {
        vCondicion.add(sCondicion);
    }
    
}

StringBuffer sSelect = new StringBuffer();
sSelect.append("SELECT ");

for (i=0; i<vShowParams.size(); i++)
{
    sSelect.append((String)vShowParams.elementAt(i));
    if(i<(vShowParams.size()-1))
        sSelect.append(", ");
}

sSelect.append(" FROM ");
String sTable=request.getParameter("table");
sSelect.append(sTable);

if (vCondicion.size()>0)
{
    sSelect.append(" WHERE ");
    for (int t=0; t<vCondicion.size(); t++)
    {
        sSelect.append(vCondicion.elementAt(t));
        sSelect.append(" ");
    }
}

if (vOrdenParams.size()>0)
{
    sSelect.append(" ORDER BY ");
    for (int n=0; n<vOrdenParams.size(); n++)
    {
        sSelect.append(vOrdenParams.elementAt(n));
        sSelect.append(" ");
        if (n>0 && n<(vOrdenParams.size()-1) && n%2!=0)
            sSelect.append(", ");
    }
}

%><jsp:useBean id="consulta" class="com.emesa.dao.CargaConsulta" scope="session" /><%
Vector vSelect = new Vector();
vSelect=consulta.loadFromDB(sSelect.toString());

//--------------------------------
session.setAttribute("inf_rtado",vSelect);
session.setAttribute("inf_header",vShowParams);
session.removeAttribute("cabecera");
session.setAttribute("inf_nombre","Informe diseñable");
session.setAttribute("inf_descripcion",sSelect.toString());

%><jsp:include page="showSelect.jsp"/>
