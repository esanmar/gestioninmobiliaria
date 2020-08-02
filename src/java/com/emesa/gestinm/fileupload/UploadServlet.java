package com.emesa.gestinm.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.emesa.gestinm.dao.FEL_INMUEBLE;
import com.emesa.gestinm.dao.FotosInmueble;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

/*
 * UploadServlet.java
 *
 */
public class UploadServlet extends HttpServlet
{
    static Logger logger = Logger.getLogger(UploadServlet.class);

	private File dir;
	private int fileSize;

	/** M&aacute;ximo tama&ntilde;o por defecto del fichero que se puede subir */
	private static int DEFAULT_FILE_SIZE=3*1024*1024; // 3 Mb
    /** Donde redirecciona el servlet */
    private static String DEFAULT_REDIRECT;

	/**
	 * Inicializaci&oacute;n del <i>servlet</i>
	 *
	 * @param config
	 */
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);

		// Read the uploadDir from the servlet parameters
		String dirName = config.getInitParameter("uploadDir");
		if (dirName != null) {
			dir = new File(dirName);
			if (! dir.isDirectory())
				throw new ServletException("[UploadServlet][init] El nombre de directorio proporcionado (" + dirName +") no es válido.");
		}

		String sFileSize=config.getInitParameter("file_size");
		if(sFileSize==null || sFileSize.trim().equals(""))
			fileSize=DEFAULT_FILE_SIZE;
		else
			fileSize = Integer.parseInt(sFileSize);

        DEFAULT_REDIRECT=config.getInitParameter("redirect");
	}

	/**
	 * Llamamos a <code>doPost</code>
	 *
	 * @param request
	 * @param response
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException
	{
		doPost(request,response);
	}


	/**
     * Los ficheros a subir ser&aacute;n im&aacute;genes asociadas al inmueble, con lo que hay
     * que recuperar el c&oacute;digo del inmueble.<br/>
     * Las fotos se guardar&aacute;n en el directorio <code>dir_upload/<i>id_inmueble</i></code>
	 *
	 * @param request
	 * @param response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException
	{
	    File localDir=dir;
        String sRedirect = "";
        String sUploadDir = "";

        if(sUploadDir!=null && !sUploadDir.trim().equals("")) {
            File oDir = new File(sUploadDir);
            if (! oDir.isDirectory()) {
                System.err.println("[UploadServlet][doPost] El nombre de directorio proporcionado (" + sUploadDir +") no es válido.");
                log("[UploadServlet][doPost] El nombre de directorio proporcionado (" + sUploadDir +") no es válido.");
            } else {
                localDir = oDir;
            }
        }

        // Creamos ahora el directorio correspondiente al ID del inmueble si no existe
        HttpSession session=request.getSession();
        FEL_INMUEBLE oInmueble = (FEL_INMUEBLE)session.getAttribute("ofel_inmueble");
        if(oInmueble==null) {
            throw new ServletException("No se encuentra el objeto FEL_INMUEBLE");
        }
        else {
            sUploadDir=localDir.getAbsolutePath()+("/"+oInmueble.getCODIGO()).replace(' ','_');
            File oDir = new File(sUploadDir);

            // Creamos los directorios si no existen
            oDir.mkdirs();
            localDir=oDir;
        }

        Vector vFilesOk=new Vector();
		String[][] lFicheros=new String[2][4];
        try {
            MultipartParser mp = new MultipartParser(request, 3*1024*1024); // 10MB
            Part part;

            while ((part = mp.readNextPart()) != null) {
                String name = part.getName().trim();

                //-- Parámetros
                if (part.isParam()) {
                  // It's a parameter part
                  ParamPart paramPart = (ParamPart) part;
                  String value = paramPart.getStringValue();
                  log("[UploadServlet][doPost] "+name+" = "+value);

                //-- Configuración
                    if(name.equals("redirect"))
                        sRedirect=value;
                    else if(name.equals("uploadDir"))
                        sUploadDir=value;

                    if(sUploadDir!=null && !sUploadDir.trim().equals("")) {
                        File oDir = new File(sUploadDir);
                        if (! oDir.isDirectory()) {
                            System.err.println("[UploadServlet][doPost] El nombre de directorio proporcionado (" + sUploadDir +") no es válido.");
                        } else {
                            localDir = oDir;
                        }
                    }

					if(name.startsWith("ver")) {
						int pos = Integer.parseInt(""+name.charAt(3));
						if(value.equals("on")) {
							lFicheros[1][pos]="1";
						}
						else {
							lFicheros[1][pos]="0";
						}
					}
                }
                //-- Ficheros
                else if (part.isFile()) {
                    log("[UploadServlet][doPost] Guardamos el fichero "+localDir.getAbsolutePath()+"/["+name+"]");
                    // it's a file part
                    FilePart filePart = (FilePart) part;
                    String fileName = filePart.getFileName();

                    if (fileName != null) {
                        // the part actually contained a file
                        long size = filePart.writeTo(localDir);

                        //-- Actualizamos la BB.DD.
                        //FotosInmueble.addPicture(oInmueble.getCODIGO(),fileName,0);
						if(name.startsWith("file")) {
							int pos = Integer.parseInt(""+name.charAt(4));
							lFicheros[0][pos]=fileName;
						}
                        vFilesOk.add(fileName);
                    }
                    else {
                        // the field did not contain a file
                        log("[UploadServlet][doPost] Debe indicar un fichero y " + name + " no lo es.");
                    }
                }
            } //-- eoWhile
        }
        catch (IOException lEx) {
            System.err.println("[UploadServlet][doPost] Error al operar con el fichero: "+lEx);
            request.setAttribute("error",""+lEx);
        }
        catch(Exception e) {
            System.err.println("[UploadServlet][doPost] Error: "+e);
            request.setAttribute("error",""+e);
        }

		// Guardamos la información en la BB.DD.
		for(int i=0;i<4;i++) {
			if(lFicheros[0][i]!=null) {
				//edu
				int nVisible=0;
				if (lFicheros[1][i]!=null)
					nVisible=Integer.parseInt(lFicheros[1][i]);
					
				try {
					FotosInmueble.addPicture(oInmueble.getCODIGO(),
						lFicheros[0][i],
						nVisible
					);
				} catch (Exception e1) {
					log("Error: "+e1);
				}
			}
		}

        request.setAttribute("files_ok",vFilesOk);
        if(sRedirect==null || sRedirect.trim().equals(""))
            sRedirect=DEFAULT_REDIRECT;

        log("[UploadServlet][doPost] Redireccionamos a: "+sRedirect);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sRedirect);
        dispatcher.forward(request,response);
	}
}
