package net.seh.bbdd;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import java.io.*;
import java.util.*;

import net.seh.bbdd.tableform.*;

/**
 * Clase para generar formularios JSP a partir de una tabla.
 * Escribe los JSP a partir del objeto <code>TableForm</code> que se encuentra en
 * sesi&oacute;n
 *
 * @author sasa eh
 * @since 24/06/2003
 * @version 0.5
 * @see net.seh.bbdd.TableForm
 */
public class TableFormServlet extends javax.servlet.http.HttpServlet
{
    /** Nombre de la tabla */
    String sTableName=null;
    /** Directorio en el que se almacenar&aacute;n las JSP */
    String sDirToSave=null;

    /**
    */
    public void init()
    {
        sTableName="";
        String s = getServletConfig().getInitParameter("dir_to_save");
        if(s!=null && !s.trim().equals(""))
            sDirToSave = s;
        else
            sDirToSave=System.getProperty("java.io.tmpdir");
    }

    /**
    */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException,ServletException
    {
        doPost(request,response);
    }

    /**
    */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException,ServletException
    {
        HttpSession session=request.getSession();
        TableForm oTableForm=(TableForm)session.getAttribute("oTableForm");

        //-- Recogemos los parámetros
        sTableName=oTableForm.getTable().getName();
        Enumeration params=request.getParameterNames();
        Vector vShowParams=new Vector();
        Vector vLoadParams=new Vector();
        Vector vObligParams=new Vector();
        String s;
        while(params.hasMoreElements()) {
            s=params.nextElement().toString();
            if(s.startsWith("_load")) {
                vLoadParams.add(s.substring("_load".length()).toUpperCase());
                vShowParams.add(s.substring("_load".length()).toUpperCase());
            }
            else if(s.startsWith("_show") && !vShowParams.contains(s)) {
                vShowParams.add(s.substring("_show".length()).toUpperCase());
            }
            else if(s.startsWith("_x")) {
                vObligParams.add(s.substring("_x".length()).toUpperCase());
            }
        }

        //-- Escribimos el fichero
        PrintWriter pw=null;
        File f=null;
        try {
            f=new File(sDirToSave+"/"+sTableName+".jsp");
            pw=new PrintWriter(new FileOutputStream(f));
        } catch(Exception e) {
            throw new ServletException("Error al crear el fichero en el directorio temporal");
        }

        if(pw!=null) {
            //----------------------------------------------
            //-- Javascript
            pw.println("<script language=\"javascript\">");
            pw.println("<!--");
            pw.println("function checkForm() {");
            pw.println("    var sErrorMsg=\"Los siguientes campos contienen errores:\";");
            pw.println();

            // Controlamos que no haya campos obligatorios vacíos
            for(int i=0; i<vObligParams.size(); i++) {
                pw.println("    if(document.fmUpdate."+vObligParams.elementAt(i)+".value==\"\") {");
                pw.println("        sErrorMsg += \"\\n  - "+vObligParams.elementAt(i)+" no puede estar vacío\";");
                pw.println("    }");
            }

            pw.println("    if(sErrorMsg!=\"Los siguientes campos contienen errores:\") {");
            pw.println("        alert(sErrorMsg);");
            pw.println("        return false;");
            pw.println("    }");
            pw.println("    else {");
            pw.println("        return true;");
            pw.println("    }");
            pw.println("}");
            pw.println();

            pw.println("function checkId() {");
            pw.println("    if(document.fmId.x"+vLoadParams.firstElement()+".value==\"\") { // ## CHECK ##");
            pw.println("        return false;");
            pw.println("    }");
            pw.println("    else {");
            pw.println("        return true;");
            pw.println("    }");
            pw.println("}");
            pw.println();

            pw.println("function cargar() {");
            pw.print("    if( ");
            s="";
            for(int i=0; i<vLoadParams.size(); i++) {
                s+="(document.fmId.x"+vLoadParams.elementAt(i)+".value==\"\") && ";
            }
            pw.println(""+s.substring(0,s.length()-3)+")");
            pw.println("        alert (\"Error: \\n  - Debe indicar al menos un criterio de carga\");");
            pw.println("    else {");

            pw.println("        document.fmId.submit();");
            pw.println("    }");
            pw.println("}");

            pw.println("function delSelected() {");
            pw.println("    if(checkId()) {");
            pw.println("        var is_ok = window.confirm(\"¿Está seguro de que desea eliminar este registro?\");");
            pw.println("        if (is_ok) {");
            pw.println("            submitType('del');");
            pw.println("        }");
            pw.println("    }");
            pw.println("    else {");
            pw.println("        alert (\"Error:\\n  - Identificador requerido\");");
            pw.println("    }");
            pw.println("}");
            pw.println();
            pw.println("function submitType(tipoOp) {");
            pw.println("    if(tipoOp!=\"del\") {");
            for(int i=0; i<vLoadParams.size(); i++) {
                pw.println("        document.fmUpdate."+vLoadParams.elementAt(i)+".value=document.fmId.x"+vLoadParams.elementAt(i)+".value;");
            }
            pw.println("    }");
            pw.println("    document.fmUpdate.op.value=tipoOp;");
            pw.println("    submitForm();");
            pw.println("}");

            pw.println("function submitForm() {");
            pw.println("    if(checkForm()) {");
            pw.println("      document.fmUpdate.submit();");
            pw.println("    }");
            pw.println("}");
            pw.println("//-->");
            pw.println("</script>");

            //----------------------------------------------
            //-- Control de 'reset'
            pw.println("<% // Reestablecer la información");
            pw.println("String sInv=request.getParameter(\"inv\");");
            pw.println("if(sInv!=null && !sInv.equals(\"\")) {");
            pw.println("    session.removeAttribute(\"o"+sTableName+"\");");
            pw.println("}");
            pw.println();
            pw.println("/* ###############################################################");
            pw.println("// Primero recogemos la información propia del objeto");
            pw.println("// Cargamos en el objeto lo que recibimos del formulario");
            pw.println("*/%>");

            //----------------------------------------------
            //-- Llamada a la 'bean'
            pw.println("<jsp:useBean id=\"o"+sTableName+"\" class=\"com.emesa.ext.dao."+sTableName.toUpperCase()+"\" scope=\"session\" />");
            pw.println("<jsp:setProperty name=\"o"+sTableName+"\" property=\"*\" />");

            //----------------------------------------------
            //-- Carga del objeto
            pw.println("<%");
            pw.println("// Cargamos el objeto según los criterios de carga");
            pw.println("// ## CHECK ##");
            for(int i=0; i<vLoadParams.size(); i++) {
                pw.println("String s"+vLoadParams.elementAt(i)+" = request.getParameter(\"x"+vLoadParams.elementAt(i)+"\");");
                pw.println("if(s"+vLoadParams.elementAt(i)+"!=null && !s"+vLoadParams.elementAt(i)+".equals(\"\"))");
                pw.println("    o"+sTableName+".loadFromDB(s"+vLoadParams.elementAt(i)+");");
            }
            pw.println("%>");

            // Parámetros que se utilizan para la carga
            pw.println("<table border=\"0\" cellpadding=\"2\">");
            pw.println("<form method=\"post\" name=\"fmId\" action=\""+f.getName()+"\">");
            for(int i=0; i<vLoadParams.size(); i++) {
                pw.println("  <tr bgcolor=\"#E2CEC7\">");
                pw.println("    <td>"+(vObligParams.contains(vLoadParams.elementAt(i))?"<span class=\"nota\">*</span> ":"")+vLoadParams.elementAt(i).toString().replace('_',' ')+": </td>");
                pw.println("    <td><input type=\"text\" name=\"x"+vLoadParams.elementAt(i)+"\" value=\"<%=o"+sTableName+".get"+vLoadParams.elementAt(i)+"()==null?\"\":o"+sTableName+".get"+vLoadParams.elementAt(i)+"%>\"/></td>");
                pw.print("    <td class=\"nota\">");
                if(i==vLoadParams.size()-1) {
                    pw.println("<input type=\"submit\" value=\"Cargar\" class=\"boton\"/>");
                }

                pw.println("    </td>");
                pw.println("  </tr>");
            }
            pw.println("</form>");
            pw.println();


            // Parámetros que se van a mostrar
            pw.println("<form method=\"post\" name=\"fmUpdate\" action=\""+f.getName().substring(0,f.getName().length()-4)+"_upd.jsp\">");
            pw.println("<input type=\"hidden\" name=\"op\" value=\"add\"/>");
            for(int i=0; i<vLoadParams.size(); i++) {
                pw.println("<input type=\"hidden\" name=\""+vLoadParams.elementAt(i)+"\"/>");
            }

            for(int i=0; i<vShowParams.size(); i++) {
                if(vLoadParams.contains(vShowParams.elementAt(i).toString())) {
                    continue;
                }
                pw.println("  <tr>");
                pw.println("    <td>"+(vObligParams.contains(vShowParams.elementAt(i))?"<span class=\"nota\">*</span> ":"")+vShowParams.elementAt(i).toString().replace('_',' ')+": </td>");
                pw.println("    <td><input type=\"text\" name=\""+vShowParams.elementAt(i)+"\" value=\"<%=o"+sTableName+".get"+vShowParams.elementAt(i)+"()==null?\"\":o"+sTableName+".get"+vShowParams.elementAt(i)+"()%>\"/></td>");
                pw.println("    <td class=\"nota\"></td>");
                pw.println("  </tr>");
            }

            // Botones de Actualizar y borrar
            pw.println("  <tr><td>&nbsp;</td><td align=\"right\"><input type=\"button\" value=\"Borrar\" class=\"boton\" onClick=\"delSelected('del')\"/></td><td align=\"right\">&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"Resetear\" onClick=\"javascript:window.location.href='"+sTableName+".jsp?inv=true'\" class=\"boton\"/>&nbsp;<input type=\"button\" value=\"Enviar\" onClick=\"submitType('mod')\" class=\"boton\"/>");
            pw.println("</tr></form>");
            pw.println("</table>");

            //-- Cerramos...
            pw.close();


            /* ###########################################################################

                    Fichero de 'update'
            */
            pw=null;
            f=null;
            try {
                f=new File(sDirToSave+"/"+sTableName+"_upd.jsp");
                pw=new PrintWriter(new FileOutputStream(f));
            } catch(Exception e) {
                throw new ServletException("Error al crear el fichero de actualización en el directorio temporal");
            }
            if(pw!=null) {
                pw.println("<%-- ###############################################################");
                pw.println("// Cargamos en el objeto lo que recibimos del formulario");
                pw.println("--%>");
                pw.println("<jsp:useBean id=\"o"+sTableName+"\" class=\"com.emesa.ext.dao."+sTableName.toUpperCase()+"\" scope=\"session\" />");
                pw.println("<jsp:setProperty name=\"o"+sTableName+"\" property=\"*\" />");
                pw.println("<%");
                pw.println("String sOp = request.getParameter(\"op\");");
                pw.println();
                pw.println("//-- BORRADO --");
                pw.println("boolean bError=false;");
                pw.println("if(sOp.equals(\"del\")) {");
                pw.println("  try {");
                pw.println("    o"+sTableName+".delete(o"+sTableName+".getID_xxx()); // ## CHECK ##");
                pw.println("%><p>Se ha borrado el registro:</p><%");
                pw.println("  }");
                pw.println("  catch(Exception e) {");
                pw.println("    bError=true;");
                pw.println("    %><p><span class=\"err\">Error</span>, no se ha podido borrar el registro <b><%=o"+sTableName+".getID_xxx()%></b> de la BB.DD.</p><% // ## CHECK ##");
                pw.println("  }");
                pw.println("}");
                pw.println();
                pw.println("//-- ACTUALIZACION --");
                pw.println("else {");
                pw.println("  try {");
                pw.println("    o"+sTableName+".saveToDB();");
                pw.println("    %><p>Se ha actualizado el registro:</p><%");
                pw.println("  }");
                pw.println("  catch(Exception e) {");
                pw.println("    System.err.println(\"["+sTableName+"_upd.jsp] Error: \"+e);");
                pw.println("    bError=true;");
                pw.println("%><p class=\"err\">Error, no se ha podido actualizar el registro <b><%=o"+sTableName+".getID_xxx()%></b> en la BB.DD.</p><%");
                pw.println("  }");
                pw.println("}");

                pw.println("if(!bError) {");
                pw.println("%>");
                pw.println("<table border=\"0\">");
                DBField fd=null;
                for(int i=0;i<oTableForm.getTable().getFields().size(); i++)
                {
                    fd=(DBField)oTableForm.getTable().getFields().elementAt(i);
                    pw.println("  <tr>");
                    pw.println("    <td><b>"+ fd.getName().replace('_',' ')+"</b>:</td>");
                    if(fd.getType().equalsIgnoreCase("int") || fd.getType().equalsIgnoreCase("integer") || fd.getType().equalsIgnoreCase("decimal"))
                        pw.println("    <td><%=o"+sTableName+".get"+fd.getName()+"()==-1?\"\":\"\"+o"+sTableName+".get"+fd.getName()+"()%></td>");
                    else
                        pw.println("    <td><%=o"+sTableName+".get"+fd.getName()+"()==null?\"\":\"\"+o"+sTableName+".get"+fd.getName()+"()%></td>");
                    pw.println("  </tr>");
                }
                pw.println("  <tr>");
                pw.println("    <td colspan=\"2\">&nbsp;</td>");
                pw.println("  </tr>");
                pw.println("  <tr>");
                pw.println("    <td colspan=\"2\" align=\"right\"><input type=\"button\" class=\"boton\" value=\"Volver\" onClick=\"javascript:window.location.href='"+sTableName+".jsp'\"/></td>");
                pw.println("  </tr>");
                pw.println("</table>");
                pw.println("<%");
                pw.println("  // Eliminamos la variable de la sesion");
                pw.println("  session.removeAttribute(\"o"+sTableName+"\");");
                pw.println("}");
                pw.println("%>");

                //-- Cerramos...
                pw.close();
            }
        }

        ServletOutputStream out = response.getOutputStream();
        out.println("<p>Generados los ficheros en el directorio <a href=\""+sDirToSave+"\">"+sDirToSave+"</a>:<br/>");
        out.println("<ul><li><a href=\""+sDirToSave+sTableName+".jsp\">"+sTableName+".jsp</a></li><li><a href=\""+sDirToSave+sTableName+"_upd.jsp\">"+sTableName+"_upd.jsp</a></li>");
        out.println("<li>El texto <b>## CHECK ##</b> se&ntilde;ala c&oacute;digo a comprobar por el usuario</li>");


        //============================================
        //-- doWrapper
        if(request.getParameter("doWrapper")!=null && request.getParameter("doWrapper").equals("true")) {
            //-drv:<DriverName>\n\t-url:<URL>\n\t-t:<TableName>");
            //System.out.println("\t[-user:<User>]\n\t[-p:<Password>]\n");
            String args[]=new String[]{"-drv:"+oTableForm.getDriver(),"-url:"+oTableForm.getURL(),"-t:"+sTableName.toUpperCase(),"-user:"+oTableForm.getUser(),"-p:"+oTableForm.getPassword()};
            try {
                net.seh.bbdd.WrapperMakerMays.main(args);
                out.println("<li>Generado el <i>wrapper</i> de la clase "+sTableName.toUpperCase()+"</li></ul></p>");
            }
            catch(Exception e) {
                out.println("<li><b>Error</b> al crear el <i>wrapper</i> de la clase "+sTableName.toUpperCase()+"</li></ul></p>");
            }
        }

        out.println("<p>[<a href=\"javascript:history.back()\">Volver</a>]</p>");
    }
}
