package com.emesa.gestinm.reports;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emesa.Configuration;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Watermark;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 *
 *
 * @author emesa s.l.
 * @version 1.0
 * @since 2003/07/15
 */
public class PDFReportServlet extends HttpServlet
{
    /** Directorio donde se van a dejar los informes */
    private static String sOutputDir="";
    /** Directorio donde se encuentra el JSP al que redireccionamos */
    private static String sRedirFolder="";


	/**
	 * Inicializaci&oacute;n del servlet
	 */
	public void init() throws ServletException
	{
        sOutputDir=Configuration.getProperty("application.base")+getServletConfig().getInitParameter("pdf_folder");
        sRedirFolder=getServletConfig().getInitParameter("pdf_folder");
	}


	/**
	 * Recogemos el identificador del informe/b&uacute;squeda a realizar,
	 * y ponemos la informaci&oacute;n relativa a ese informe en <code>pageContext</code>
	 *
	 * @param request
	 * @param response
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
        Document document=null;

        try {
            HttpSession session = request.getSession(true);
            com.emesa.gestinm.portalframework.UserProfile oProfile=(com.emesa.gestinm.portalframework.UserProfile)session.getAttribute("_profile_");
            Vector vHeader=(Vector)session.getAttribute("inf_header");
            Vector vRtado=(Vector)session.getAttribute("inf_rtado");
            String sNombreConsulta=(String)session.getAttribute("inf_nombre");
            String sDescripcionConsulta=(String)session.getAttribute("inf_descripcion");

            if(vHeader==null)
                vHeader=new Vector();
            if(vRtado==null)
                vRtado=new Vector();
            if(sNombreConsulta==null)
                sNombreConsulta="Informe";
            if(sDescripcionConsulta==null)
                sDescripcionConsulta="";

            // step 1: creation of a document-object
            document = new Document(PageSize.A4.rotate());

            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            File tmpFile = new File(oProfile.getUsuario()+"_gestinm.pdf");
            String sOutputFile=(sOutputDir+"/"+tmpFile.getName()).replace('\\','/');

            PdfWriter.getInstance(document, new FileOutputStream(sOutputFile));


            //-- seh
            addMetaData(document);
            addHeader(document);
            //-- eoseh

            // step 3: we open the document
            document.open();

            // step 4: we add a paragraph to the document
            document.add(new Paragraph(sNombreConsulta+": "+sDescripcionConsulta,new Font(Font.TIMES_ROMAN,12)));

            PdfPTable table = new PdfPTable(vHeader.size());
            table.setHeaderRows(1);
            //table.setPadding(2);
            //table.setCellsFitPage(true);

            //---------------------
            // Cabecera...
            PdfPCell cell=null;
            for(int i=0; i<vHeader.size(); i++) {
                cell = new PdfPCell(
                    new Phrase(vHeader.elementAt(i).toString(),
                               new Font(Font.HELVETICA,10)
                    ));
                //cell.setHeader(true);
                cell.setBackgroundColor(Color.orange);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            //---------------------
            // Resultados
            Vector vRow=null;
            for(int i=0;i<vRtado.size(); i++) {
                vRow=(Vector)vRtado.elementAt(i);
                for(int j=0; j<vRow.size();j++) {
                    cell=new PdfPCell(
                        new Phrase((vRow.elementAt(j)==null?"":vRow.elementAt(j).toString()),
                               new Font(Font.TIMES_ROMAN,9)
                        ));
                    if(i%2!=0)
                        cell.setBackgroundColor(Color.LIGHT_GRAY);

                    cell.setVerticalAlignment(Element.ALIGN_TOP);
                    table.addCell(cell);
                }
            }

            document.add(table);

            String sRedirect=request.getParameter("redir");
            if(sRedirect==null || sRedirect.trim().equals(""))
                sRedirect=sRedirFolder+"/pdf.jsp";


            request.setAttribute("f",sRedirFolder+"/"+tmpFile.getName());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sRedirect);
            dispatcher.forward(request,response);

            // step 5: we close the document
            document.close();

        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
            // step 5: we close the document
            if(document!=null)
                document.close();
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
            // step 5: we close the document
            if(document!=null)
                document.close();
        }

    }


    protected void addMetaData(Document pdf)
    {
        pdf.addTitle("Informe "+Configuration.getProperty("app.title"));
        pdf.addSubject("Informes");
        pdf.addAuthor(Configuration.getProperty("app.title"));
        pdf.addCreator("emesa s.l.");
        //public boolean addKeywords(String keywords)
        //public boolean addCreator(String creator)
        pdf.addProducer();
        pdf.addCreationDate();
        //public boolean addHeader(String name, String content)
    }

    protected void addHeader(Document pdf)
    {
        try {
            Watermark watermark = new Watermark(Image.getInstance(Configuration.getProperty("application.base")+"/images/logo_watermark.jpg"), 200, 200);
            pdf.add(watermark);
        }
        catch(Exception e) {
            System.err.println("[addHeader] Error al poner la marca de agua: "+e);
        }

        HeaderFooter header = new HeaderFooter(new Phrase("  "+Configuration.getProperty("app.title")), false);
        header.setBackgroundColor(Color.orange);
        pdf.setHeader(header);
        //pdf.resetHeader()
        HeaderFooter footer = new HeaderFooter(new Phrase("Página "), true);
        footer.setAlignment(Element.ALIGN_RIGHT);
        pdf.setFooter(footer);
        //pdf.resetFooter()
        //pdf.resetPageCount()
        //pdf.setPageCount(int pageN)
    }


	/**
	 * Redirecciona a <code>doGet(HttpServletRequest, HttpServletResponse)</code>
	 *
	 * @param request
	 * @param response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		doGet(request,response);
	}

}
