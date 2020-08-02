/*
 * Fichero: PropietarioPopupDecorator.java 
 * 
 * Autor:   sergioarias
 * Fecha:   13-feb-2004
 */
package com.emesa.gestinm.decorators;

import java.text.SimpleDateFormat;

import org.displaytag.decorator.TableDecorator;

import com.emesa.gestinm.dao.FEL_PROVEEDOR;

/**
 * @author sergioarias
 * @since 13-feb-2004
 */
public class PropietarioPUDecorator extends TableDecorator
{
	private static final SimpleDateFormat xsdf = new SimpleDateFormat("yyyy'-'MM'-'dd");

	/**
	 * Constructor
	 */
	public PropietarioPUDecorator() {
	}

	/**
	 * Devuelve un enlace a la ventana padre con la direcci&oacute;n de detalle
	 * para el propietario indicado
	 * 
	 * @return
	 */
	public String getID_PROPIETARIO() {
		FEL_PROVEEDOR o = (FEL_PROVEEDOR)getCurrentRowObject();
		
		return "<a href=\"javascript:window.opener.document.fmUpdate.COD_PROPIETARIO.value="+o.getID_PROPIETARIO()+"; window.close()\">"+o.getID_PROPIETARIO()+"</a>";
	}

	/**
	 * Formato de fecha como YYYY/MM/dd para que sea legible y ordenable a la vez
	 * 
	 * @return
	 */
	public String getFECHA_ALTA() {
		FEL_PROVEEDOR o = (FEL_PROVEEDOR)getCurrentRowObject();
		
		try {
			return xsdf.format(o.getFECHA_ALTA());
		}
		catch(Exception e) {
			return (o.getFECHA_ALTA()!=null?o.getFECHA_ALTA().toLocaleString():"");
		}
	}
}
