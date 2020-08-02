/*
 * Fichero: MiCartera.java 
 * 
 * Autor:   sergioarias
 * Fecha:   17-feb-2004
 */
package com.emesa.gestinm.pojo;

import java.util.Vector;

/**
 * Representaci&oacute;n de <strong>Mi Cartera</strong>
 * 
 * @author sergioarias
 * @since 17-feb-2004
 */
public class MiCartera {
	private int idInmueble=-1;
	private int idPropietario=-1;
	private String zona="";
	private String tipo="";
	private String direccion="";
	private double precVenta=0.0;
	private double precAlquiler=0.0;
	private double superficie=0.0;
	private String estado="";
	private String nombreContacto="";
	private String apel1Contacto="";
	private String contacto="";
	private String tfnoContacto="";


	/**
	 * 
	 * @return
	 */
	public String getApel1Contacto() {
		return apel1Contacto;
	}

	/**
	 * 
	 * @return
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * 
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * 
	 * @return
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * 
	 * @return
	 */
	public int getIdPropietario() {
		return idPropietario;
	}

	/**
	 * 
	 * @return
	 */
	public int getIdInmueble() {
		return idInmueble;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombreContacto() {
		return nombreContacto;
	}

	/**
	 * 
	 * @return
	 */
	public double getPrecAlquiler() {
		return precAlquiler;
	}

	/**
	 * 
	 * @return
	 */
	public double getPrecVenta() {
		return precVenta;
	}

	/**
	 * 
	 * @return
	 */
	public double getSuperficie() {
		return superficie;
	}

	/**
	 * 
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @return
	 */
	public String getZona() {
		return zona;
	}

	/**
	 * 
	 * @param string
	 */
	public void setApel1Contacto(String string) {
		apel1Contacto = string;
	}

	/**
	 * 
	 * @param string
	 */
	public void setContacto(String string) {
		contacto = string;
	}

	/**
	 * 
	 * @param string
	 */
	public void setDireccion(String string) {
		direccion = string;
	}

	/**
	 * 
	 * @param string
	 */
	public void setEstado(String string) {
		estado = string;
	}

	/**
	 * 
	 * @param i
	 */
	public void setIdPropietario(int i) {
		idPropietario = i;
	}

	/**
	 * 
	 * @param i
	 */
	public void setIdInmueble(int i) {
		idInmueble = i;
	}

	/**
	 * 
	 * @param string
	 */
	public void setNombreContacto(String string) {
		nombreContacto = string;
	}

	/**
	 * 
	 * @param d
	 */
	public void setPrecAlquiler(double d) {
		precAlquiler = d;
	}

	/**
	 * 
	 * @param d
	 */
	public void setPrecVenta(double d) {
		precVenta = d;
	}

	/**
	 * 
	 * @param d
	 */
	public void setSuperficie(double d) {
		superficie = d;
	}

	/**
	 * 
	 * @param string
	 */
	public void setTipo(String string) {
		tipo = string;
	}

	/**
	 * 
	 * @param string
	 */
	public void setZona(String string) {
		zona = string;
	}

	/**
	 * 
	 * @return
	 */
	public String getTfnoContacto() {
		return tfnoContacto;
	}

	/**
	 * 
	 * @param string
	 */
	public void setTfnoContacto(String string) {
		tfnoContacto = string;
	}

	/**
	 * <p>Carga en el objeto la informaci&oacute;n contenida en el vector.</p>
	 * <p>El orden de los elementos debe ser:
	 * 		<ol>
	 * 			<li>C&oacute;digo del inmueble</li>
	 * 			<li>Zona</li>
	 * 			<li>Tipo</li>
	 * 			<li>Direcci&oacute;n</li>
	 * 			<li>Precio venta</li>
	 * 			<li>Precio alquiler</li>
	 * 			<li>Superficie</li>
	 * 			<li>Estado</li>
	 * 			<li>C&oacute;d. del propietario</li>
	 * 			<li>Nombre del propietario (contacto)</li>
	 * 			<li>Primer apellido</li>
	 * 			<li>Tfno. de contacto</li>
	 * 		</ol>
	 * </p> 
	 * 
	 * @param vRow
	 */
	public void setElement(Vector vRow) {
		if(vRow.elementAt(0)!=null) {
			setIdInmueble(Integer.parseInt(vRow.elementAt(0).toString()));
		}
		if(vRow.elementAt(1)!=null) {
			setZona(vRow.elementAt(1).toString().trim());
		}
		if(vRow.elementAt(2)!=null) {
			setTipo(vRow.elementAt(2).toString().trim());
		}
		if(vRow.elementAt(3)!=null) {
			setDireccion(vRow.elementAt(3).toString().trim());
		}
		if(vRow.elementAt(4)!=null) {
			setPrecVenta(Double.parseDouble(vRow.elementAt(4).toString()));
		}
		if(vRow.elementAt(5)!=null) {
			setPrecAlquiler(Double.parseDouble(vRow.elementAt(5).toString()));
		}
		/*
		* 			<li>Superficie</li>
		* 			<li>Estado</li>
		* 			<li>C&oacute;d. del propietario</li>
		* 			<li>Nombre del propietario (contacto)</li>
		* 			<li>Primer apellido</li>
		* 			<li>Tfno. de contacto</li>
		*/
		if(vRow.elementAt(6)!=null) {
			setSuperficie(Double.parseDouble(vRow.elementAt(6).toString()));
		}
		if(vRow.elementAt(7)!=null) {
			setEstado(vRow.elementAt(7).toString().trim());
		}
		if(vRow.elementAt(8)!=null) {
			setIdPropietario(Integer.parseInt(vRow.elementAt(8).toString()));
		}
		if(vRow.elementAt(9)!=null) {
			setNombreContacto(vRow.elementAt(9).toString().trim());
		}
		if(vRow.elementAt(10)!=null) {
			setApel1Contacto(vRow.elementAt(10).toString().trim());
		}

		if(vRow.elementAt(11)!=null) {
			setTfnoContacto(vRow.elementAt(11).toString().trim());
		}
	}

}
