/*
 * Fichero: PropietarioPopupDecorator.java 
 * 
 * Autor:   sergioarias
 * Fecha:   13-feb-2004
 */
package com.emesa.gestinm.decorators;

import java.text.SimpleDateFormat;

import org.displaytag.decorator.TableDecorator;

import com.emesa.gestinm.dao.FEL_INMUEBLE;
//import com.emesa.util.Formats;

/**
 * @author sergioarias
 * @since 13-feb-2004
 */
public class InmuebleDecorator extends TableDecorator
{
//	private static final SimpleDateFormat xsdf = new SimpleDateFormat("yyyy'-'MM'-'dd");

	/**
	 * Constructor
	 */
	public InmuebleDecorator() {
	}

	/**
	 * Formato de fecha como YYYY/MM/dd para que sea legible y ordenable a la vez
	 * 
	 * @return
	 */
	public String getFECHA_ALTA() {
		FEL_INMUEBLE o = (FEL_INMUEBLE)getCurrentRowObject();
		
		try {
			return xsdf.format(o.getFECHA_ALTA());
		}
		catch(Exception e) {
			return (o.getFECHA_ALTA()!=null?o.getFECHA_ALTA().toLocaleString():"");
		}
	}

	/**
	 * Precio de venta formateado
	 * 
	 * @return
	 */
	public String getPRECIO_VENTA() {
		FEL_INMUEBLE o = (FEL_INMUEBLE)getCurrentRowObject();
		
		try {
			return Formats.doubleNumber(o.getPRECIO_VENTA());
		}
		catch(Exception e) {
			return ""+o.getPRECIO_VENTA();
		}
	}

	/**
	 * Precio de alquiler formateado
	 * 
	 * @return
	 */
	public String getPRECIO_ALQUILER() {
		FEL_INMUEBLE o = (FEL_INMUEBLE)getCurrentRowObject();
		
		try {
			return Formats.doubleNumber(o.getPRECIO_ALQUILER());
		}
		catch(Exception e) {
			return ""+o.getPRECIO_ALQUILER();
		}
	}
}
