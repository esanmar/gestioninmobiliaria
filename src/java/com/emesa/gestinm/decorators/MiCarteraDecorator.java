/*
 * Fichero: MiCarteraDecorator.java 
 * 
 * Autor:   sergioarias
 * Fecha:   17-feb-2004
 */
package com.emesa.gestinm.decorators;

import java.text.SimpleDateFormat;

import com.emesa.gestinm.pojo.*;
import com.emesa.util.*;
import org.displaytag.decorator.TableDecorator;

/**
 * 
 * @author sergioarias
 * @since 17-feb-2004
 * @see com.emesa.gestinm.decorators.InmuebleDecorator
 */
public class MiCarteraDecorator extends TableDecorator
{
	private static final SimpleDateFormat xsdf = new SimpleDateFormat("yyyy'-'MM'-'dd");

	/**
	 * Precio de venta formateado
	 * 
	 * @return
	 */
	public String getIdInmueble() {
		MiCartera o = (MiCartera)getCurrentRowObject();

		return "<a href=\"index.jsp?tab=inm&xCodigo="+o.getIdInmueble()+"\">&nbsp;"+o.getIdInmueble()+"&nbsp;</a>";
	}

	/**
	 * Precio de venta formateado
	 * 
	 * @return
	 */
	public String getContacto() {
		MiCartera o = (MiCartera)getCurrentRowObject();

		return "<a href=\"index.jsp?tab=prov&xID_PROPIETARIO="+o.getIdPropietario()+"\">"+o.getNombreContacto()+" "+o.getApel1Contacto()+"</a>";
	}

	/**
	 * Precio de venta formateado
	 * 
	 * @return
	 */
	public String getPrecVenta() {
		MiCartera o = (MiCartera)getCurrentRowObject();
		
		try {
			return Formats.doubleNumber(o.getPrecVenta());
		}
		catch(Exception e) {
			return ""+o.getPrecVenta();
		}
	}

	/**
	 * Precio de alquiler formateado
	 * 
	 * @return
	 */
	public String getPrecAlquiler() {
		MiCartera o = (MiCartera)getCurrentRowObject();
		
		try {
			return Formats.doubleNumber(o.getPrecAlquiler());
		}
		catch(Exception e) {
			return ""+o.getPrecAlquiler();
		}
	}

	/**
	 * Superficie formateada
	 * 
	 * @return
	 */
	public String getSuperficie() {
		MiCartera o = (MiCartera)getCurrentRowObject();
		
		try {
			return Formats.doubleNumber(o.getSuperficie());
		}
		catch(Exception e) {
			return ""+o.getSuperficie();
		}
	}
}
