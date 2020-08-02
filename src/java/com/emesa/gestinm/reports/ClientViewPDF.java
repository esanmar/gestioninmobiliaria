package com.emesa.gestinm.reports;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emesa.Configuration;
import com.emesa.gestinm.dao.FEL_CHALET;
import com.emesa.gestinm.dao.FEL_INMUEBLE;
import com.emesa.gestinm.dao.FEL_OFICINA;
import com.emesa.gestinm.dao.FEL_PISO;
import com.emesa.gestinm.portalframework.UserProfile;
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
public class ClientViewPDF extends HttpServlet
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
            UserProfile oProfile=(UserProfile)session.getAttribute("_profile_");

            //-- Datos del inmueble
            FEL_INMUEBLE oInmueble=(FEL_INMUEBLE)session.getAttribute("ofel_inmueble");
            FEL_PISO oPiso=(FEL_PISO)session.getAttribute("ofel_piso");
            FEL_CHALET oChalet=(FEL_CHALET)session.getAttribute("ofel_chalet");
            //log("Inmueble: "+oInmueble);
            //log("Piso: "+oPiso);
            //--

            // step 1: creation of a document-object
            document = new Document(PageSize.A4.rotate());

            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            File tmpFile = new File(oProfile.getUsuario()+"_det_inmueble.pdf");
            String sOutputFile=(sOutputDir+"/"+tmpFile.getName()).replace('\\','/');

            PdfWriter.getInstance(document, new FileOutputStream(sOutputFile));

            //-- seh
            addMetaData(document);
            addHeader(document);
            //-- eoseh

            // step 3: we open the document
            document.open();

            // step 4: we add a paragraph to the document
            SimpleDateFormat sdf = new SimpleDateFormat(Configuration.getProperty("show.date_format"));

            if(oInmueble!=null)
                document.add(new Paragraph("Detalle del inmueble "+oInmueble.getCODIGO()+" generado el "+sdf.format(new Date())+". Le ha atendido "+oProfile.getNombre()+" "+oProfile.getApellido1(),new Font(Font.TIMES_ROMAN,12)));

            //log("[seh] Detalle de la oficina");
            if(oInmueble!=null) {
                FEL_OFICINA oOficina = new FEL_OFICINA();
                oOficina.loadFromDB(oProfile.getIdOficina());

                if(oOficina!=null)
                    document.add(new Paragraph(Configuration.getProperty("app.title")+", "+oOficina.getDIRECCION()+" - "+oOficina.getLOCALIDAD()+". Tfn. "+oOficina.getTELEFONO()+", E-mail "+(oOficina.getEMAIL()==null?"":oOficina.getEMAIL()),new Font(Font.TIMES_ROMAN,12)));
                else {
                    document.add(new Paragraph(Configuration.getProperty("app.title")+", oficinas en: ",new Font(Font.TIMES_ROMAN,12)));
                    Enumeration enum=FEL_OFICINA.getOficinas();
                    FEL_OFICINA o=null;
                    while(enum.hasMoreElements()) {
                        o=(FEL_OFICINA)enum.nextElement();
                        document.add(new Paragraph("        > "+o.getDIRECCION()+" - "+o.getLOCALIDAD()+". Tfn. "+(o.getTELEFONO()==null?" - ":o.getTELEFONO()),new Font(Font.TIMES_ROMAN,12)));
                    }
                }
            }
            else {
                document.add(new Paragraph(Configuration.getProperty("app.title")+", oficinas en: ",new Font(Font.TIMES_ROMAN,12)));
                Enumeration enum=FEL_OFICINA.getOficinas();
                FEL_OFICINA o=null;
                while(enum.hasMoreElements()) {
                    o=(FEL_OFICINA)enum.nextElement();
                    document.add(new Paragraph("        > "+o.getDIRECCION()+" - "+o.getLOCALIDAD()+". Tfn. "+(o.getTELEFONO()==null?" - ":o.getTELEFONO()),new Font(Font.TIMES_ROMAN,12)));
                }
            }

            PdfPTable table = new PdfPTable(4);

            //log("[seh] Detalle del inmueble: "+oInmueble);
            //------------------------------------------------------------
            // Información del inmueble
            //
            PdfPCell cell=null;
            cell = new PdfPCell(
                new Phrase("Código del inmueble: "+oInmueble.getCODIGO(), new Font(Font.HELVETICA,14)
                ));
            cell.setBackgroundColor(Color.lightGray);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(4);
            table.addCell(cell);

            cell = new PdfPCell(
                new Phrase("Referencia", new Font(Font.HELVETICA,10)
                ));
            cell.setBackgroundColor(Color.lightGray);
            //cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            //log("[seh] Referencia: "+oInmueble.getREFERENCIA());
            cell = tryCatchCell(oInmueble.getREFERENCIA()==null?"":oInmueble.getREFERENCIA());
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setColspan(3);
            table.addCell(cell);

            cell = new PdfPCell(
                new Phrase("Población", new Font(Font.HELVETICA,10)
                ));
            cell.setBackgroundColor(Color.lightGray);
            table.addCell(cell);

            cell = tryCatchCell(oInmueble.getPOBLACION()==null?"":oInmueble.getPOBLACION());
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setColspan(3);
            table.addCell(cell);


            cell = new PdfPCell(
                new Phrase("Zona", new Font(Font.HELVETICA,10)
                ));
            cell.setBackgroundColor(Color.lightGray);
            table.addCell(cell);

            cell = tryCatchCell(oInmueble.getZONA()==null?"":oInmueble.getZONA());
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setColspan(3);
            table.addCell(cell);


            cell = new PdfPCell(
                new Phrase("Dirección", new Font(Font.HELVETICA,10)
                ));
            cell.setBackgroundColor(Color.lightGray);
            table.addCell(cell);

            cell = tryCatchCell(oInmueble.getDIRECCION()==null?"":oInmueble.getDIRECCION());
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setColspan(3);
            table.addCell(cell);


            cell = new PdfPCell(
                new Phrase("Superficie total", new Font(Font.HELVETICA,10)
                ));
            cell.setBackgroundColor(Color.lightGray);
            table.addCell(cell);

            cell = tryCatchCell(oInmueble.getSUPERFICIE()+" m2");
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);


            cell = new PdfPCell(
                new Phrase("Superficie útil", new Font(Font.HELVETICA,10)
                ));
            cell.setBackgroundColor(Color.lightGray);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = tryCatchCell(oInmueble.getSUP_UTIL()+" m2");
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);

            document.add(table);

            document.add(new Paragraph(" ",new Font(Font.TIMES_ROMAN,12)));


            //log("[seh] Precios");
            //----------------------------
            // Precios
            //
            table = new PdfPTable(2);
            cell = new PdfPCell(
                new Phrase("Precios", new Font(Font.HELVETICA,12)
                ));
            cell.setBackgroundColor(Color.lightGray);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(2);
            table.addCell(cell);

            cell = new PdfPCell(
                new Phrase("Precio venta", new Font(Font.HELVETICA,10)
                ));
            cell.setBackgroundColor(Color.lightGray);
            table.addCell(cell);

            cell = tryCatchCell(oInmueble.getPRECIO_VENTA()+" €");
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);
            cell = new PdfPCell(
                new Phrase("Precio alquiler", new Font(Font.HELVETICA,10)
                ));
            cell.setBackgroundColor(Color.lightGray);
            table.addCell(cell);

            cell = tryCatchCell(oInmueble.getPRECIO_ALQUILER()+" €");
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);

            document.add(table);

            document.add(new Paragraph(" ",new Font(Font.TIMES_ROMAN,12)));


            //log("[seh] PISO <-- "+oInmueble.getTIPO());
            //----------------------------
            // Información del piso
            //
            String sTipo=oInmueble.getTIPO();
            if (sTipo!=null && (sTipo.equals("PISO") || sTipo.equals("ÁTICO") || sTipo.equals("DÚPLEX") || sTipo.equals("APARTAMENTO") || sTipo.equals("ESTUDIO"))) {
                table = new PdfPTable(4);
                cell = new PdfPCell(
                    new Phrase(sTipo, new Font(Font.HELVETICA,12)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(5);
                table.addCell(cell);

                cell = new PdfPCell(
                    new Phrase("Antigüedad", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell(""+oPiso.getANTIGUEDAD());
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = new PdfPCell(
                    new Phrase("Amueblado", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oPiso.getAMUEBLADO()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Número de dormitorios", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell(""+oPiso.getDORMITORIOS());
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = new PdfPCell(
                    new Phrase("Garaje", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oPiso.getGARAJE()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Número de baños", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell(""+oPiso.getBANOS());
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Piscina", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oPiso.getPISCINA()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = new PdfPCell(
                    new Phrase("Aseos", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell(""+oPiso.getASEOS());
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Aire acondicionado", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oPiso.getAIRE_ACONDICIONADO()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Calefacción", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell((oPiso.getCALEFACCION()!=null?oPiso.getCALEFACCION():""));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Cocina amueblada", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oPiso.getCOCINA_AMUEBLADA()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Agua caliente", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell((oPiso.getAGUA_CALIENTE()!=null?oPiso.getAGUA_CALIENTE():""));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = new PdfPCell(
                    new Phrase("Ascensor", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oPiso.getASCENSOR()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Comunidad", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell(oPiso.getGASTOS_COMUNIDAD());
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Trastero", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oPiso.getTRASTERO()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                document.add(table);
            }

            //----------------------------
            // Información del chalet
            //
            else if (sTipo!=null && sTipo.equals("CHALET")) {
                //log("[seh] CHALET <-- "+oInmueble.getTIPO());
                table = new PdfPTable(4);
                cell = new PdfPCell(
                    new Phrase(sTipo, new Font(Font.HELVETICA,12)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(5);
                table.addCell(cell);

                cell = new PdfPCell(
                    new Phrase("Antigüedad", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell(""+oChalet.getANTIGUEDAD());
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = new PdfPCell(
                    new Phrase("Amueblado", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oChalet.getAMUEBLADO()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Número de dormitorios", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell(""+oChalet.getDORMITORIOS());
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = new PdfPCell(
                    new Phrase("Garaje", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oChalet.getGARAJE()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Número de baños", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell(""+oChalet.getBANOS());
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Piscina", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oChalet.getPISCINA()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = new PdfPCell(
                    new Phrase("Aseos", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell(""+oChalet.getASEOS());
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Aire acondicionado", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oChalet.getAIRE_ACONDICIONADO()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Calefacción", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell((oChalet.getCALEFACCION()!=null?oChalet.getCALEFACCION():""));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Cocina amueblada", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = tryCatchCell((oChalet.getCOCINA_AMUEBLADA()==1?"Si":"No"));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                cell = new PdfPCell(
                    new Phrase("Agua caliente", new Font(Font.HELVETICA,10)
                    ));
                cell.setBackgroundColor(Color.lightGray);
                table.addCell(cell);

                cell = tryCatchCell((oChalet.getAGUA_CALIENTE()!=null?oChalet.getAGUA_CALIENTE():""));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);


                document.add(table);
            }

            document.add(new Paragraph(" ",new Font(Font.TIMES_ROMAN,10)));

            //log("[seh] Descripcion");
            //----------------------------
            // Descripción
            //
            table = new PdfPTable(1);
            cell = new PdfPCell(
                new Phrase("Descripción", new Font(Font.HELVETICA,12)
                ));
            cell.setBackgroundColor(Color.lightGray);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell=tryCatchCell(""+oInmueble.getDESCRIPCION(), "Descripción no disponible: Error al procesar la descripción del inmueble");
            table.addCell(cell);

            document.add(table);


//--------------------------------------------------------------------
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



    /**
     * @param s
     * @param sError
     * @return
     */
    private PdfPCell tryCatchCell(String s) {
        return tryCatchCell(s,"Error");
    }

    /**
     * @param s
     * @param sError
     * @return
     */
    private PdfPCell tryCatchCell(String s, String sError) {
        PdfPCell cell=null;
        String sErr="Error";
        if(sError!=null)
            sErr=sError;

        try {
            cell = new PdfPCell(
            new Phrase(s, new Font(Font.HELVETICA,10)
            ));
        }
        catch(Exception e) {
            cell = new PdfPCell(
            new Phrase(sErr, new Font(Font.HELVETICA,10)
            ));
        }

        return cell;
    }

    protected void addMetaData(Document pdf)
    {
        pdf.addTitle(Configuration.getProperty("app.title")+" - Información del inmueble");
        pdf.addSubject("Detalle del inmueble");
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

        HeaderFooter header = new HeaderFooter(new Phrase("  "+Configuration.getProperty("app.title")+" - Información del inmueble"), false);
        header.setBackgroundColor(Color.lightGray);
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
