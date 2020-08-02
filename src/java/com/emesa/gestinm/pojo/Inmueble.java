/*
 * Creado el 07-ene-2004
 */
package com.emesa.gestinm.pojo;

import java.util.*;

/**
 * @author sergioarias
 * @since 07-ene-2004
 * 
 * @hibernate.class table="fel_inmueble"
 */
public class Inmueble {
	int codigo;
	String tipo;
	int codPropietario;
	String tipoVia;
	String direccion;
	String num;
	String bloque;
	String piso;
	String letra;
	String cp;
	String poblacion;
	String zona;
	String provincia;
	int superficie;
	int supConstruida;
	int supUtil;
	double precioVenta;
	double precioAlquiler;
	double precioTraspaso;
	Date fechaReserva;
	Date fechaVencimiento;
	int estado;
	String descripcion;
	String notas;
	String llaves;
	String referencia;
	String vendedor;
	Date ultimaModificacion;
	int modificado;
	String reservadoPor;
	int enExclusiva;
	Date fechaAlta;

	/**
	 * Constructor
	 *
	 */
	public Inmueble () {
		setBloque("");
		setCodigo(-1);
		setCodPropietario(-1);
		setCp("");
		setDescripcion("");
		setDireccion("");
		setEnExclusiva(0);
		setEstado(1);
		setFechaAlta(null);
		setFechaReserva(null);
		setFechaVencimiento(null);
		setLetra("");
		setLlaves("");
		setModificado(0);
		setNotas("");
		setNum("");
		setPiso("");
		setPoblacion("");
		setPrecioAlquiler(0.0);
		setPrecioTraspaso(0.0);
		setPrecioVenta(0.0);
		setProvincia("");
		setReferencia("");
		setReservadoPor("");
		setSupConstruida(0);
		setSuperficie(0);
		setSupUtil(0);
		setTipo("");
		setTipoVia("");
		setUltimaModificacion(null);
		setVendedor("");
		setZona("");
	}

    /**
     * @return
     * 
     * @hibernate.property
     */
    public String getBloque() {
        return bloque;
    }

    /**
     * @return
     * 
     * @hibernate.id generator-class="native" column="Codigo" not-null="true"
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return
     * 
     * @hibernate.property column="Cod_propietario"
     */
    public int getCodPropietario() {
        return codPropietario;
    }

    /**
     * @return
     * 
     * @hibernate.property column="Cod_postal"
     */
    public String getCp() {
        return cp;
    }

    /**
     * @return
     * 
     * @hibernate.property
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return
     * 
     * @hibernate.property
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @return
     * 
     * @hibernate.property column="EN_EXCLUSIVA"
     */
    public int getEnExclusiva() {
        return enExclusiva;
    }

    /**
     * @return
     * 
     * @hibernate.property
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @return
     * 
     * @hibernate.property type="date" column="Fecha_alta"
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     * @return
     * 
     * @hibernate.property type="date" column="Fecha_reserva"
     */
    public Date getFechaReserva() {
        return fechaReserva;
    }

    /**
     * @return
     * 
     * @hibernate.property type="date" column="Fecha_vencimiento"
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @return
     * 
     * @hibernate.property
     */
    public String getLetra() {
        return letra;
    }

    /**
     * @return
     * 
     * @hibernate.property
     */
    public String getLlaves() {
        return llaves;
    }

    /**
     * @return
     * 
     * @hibernate.property
     */
    public int getModificado() {
        return modificado;
    }

    /**
     * @return
     * 
     * @hibernate.property
     */
    public String getNotas() {
        return notas;
    }

    /**
     * @return
     * 
     * @hibernate.property column="Numero"
     */
    public String getNum() {
        return num;
    }

    /**
     * @return
     * 
     * @hibernate.property
     */
    public String getPiso() {
        return piso;
    }

    /**
     * @return
     * 
     * @hibernate.property
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * @return
     * 
     * @hibernate.property type="double" column="Precio_alquiler"
     */
    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    /**
     * @return
     * 
     * @hibernate.property type="double" column="Precio_traspaso"
     */
    public double getPrecioTraspaso() {
        return precioTraspaso;
    }

    /**
     * @return
     * 
     * @hibernate.property type="double" column="Precio_venta"
     */
    public double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @return
     * 
     * @hibernate.property 
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @return
     * 
     * @hibernate.property 
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @return
     * 
     * @hibernate.property column="RESERVADO_POR"
     */
    public String getReservadoPor() {
        return reservadoPor;
    }

    /**
     * @return
     * 
     * @hibernate.property column="Sup_construida"
     */
    public int getSupConstruida() {
        return supConstruida;
    }

    /**
     * @return
     * 
     * @hibernate.property
     */
    public int getSuperficie() {
        return superficie;
    }

    /**
     * @return
     * 
     * @hibernate.property column="Sup_util"
     */
    public int getSupUtil() {
        return supUtil;
    }

    /**
     * @return
     * 
     * @hibernate.property 
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return
     * 
     * @hibernate.property 
     */
    public String getTipoVia() {
        return tipoVia;
    }

    /**
     * @return
     * 
     * @hibernate.property type="date" column="Ultima_modificacion"
     */
    public Date getUltimaModificacion() {
        return ultimaModificacion;
    }

    /**
     * @return
     * 
     * @hibernate.property 
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @return
     * 
     * @hibernate.property 
     */
    public String getZona() {
        return zona;
    }

    /**
     * @param string
     */
    public void setBloque(String string) {
        bloque = string;
    }

    /**
     * @param i
     */
    public void setCodigo(int i) {
        codigo = i;
    }

    /**
     * @param i
     */
    public void setCodPropietario(int i) {
        codPropietario = i;
    }

    /**
     * @param string
     */
    public void setCp(String string) {
        cp = string;
    }

    /**
     * @param string
     */
    public void setDescripcion(String string) {
        descripcion = string;
    }

    /**
     * @param string
     */
    public void setDireccion(String string) {
        direccion = string;
    }

    /**
     * @param i
     */
    public void setEnExclusiva(int i) {
        enExclusiva = i;
    }

    /**
     * @param i
     */
    public void setEstado(int i) {
        estado = i;
    }

    /**
     * @param date
     */
    public void setFechaAlta(Date date) {
        fechaAlta = date;
    }

    /**
     * @param date
     */
    public void setFechaReserva(Date date) {
        fechaReserva = date;
    }

    /**
     * @param date
     */
    public void setFechaVencimiento(Date date) {
        fechaVencimiento = date;
    }

    /**
     * @param string
     */
    public void setLetra(String string) {
        letra = string;
    }

    /**
     * @param string
     */
    public void setLlaves(String string) {
        llaves = string;
    }

    /**
     * @param i
     */
    public void setModificado(int i) {
        modificado = i;
    }

    /**
     * @param string
     */
    public void setNotas(String string) {
        notas = string;
    }

    /**
     * @param string
     */
    public void setNum(String string) {
        num = string;
    }

    /**
     * @param string
     */
    public void setPiso(String string) {
        piso = string;
    }

    /**
     * @param string
     */
    public void setPoblacion(String string) {
        poblacion = string;
    }

    /**
     * @param d
     */
    public void setPrecioAlquiler(double d) {
        precioAlquiler = d;
    }

    /**
     * @param d
     */
    public void setPrecioTraspaso(double d) {
        precioTraspaso = d;
    }

    /**
     * @param d
     */
    public void setPrecioVenta(double d) {
        precioVenta = d;
    }

    /**
     * @param string
     */
    public void setProvincia(String string) {
        provincia = string;
    }

    /**
     * @param string
     */
    public void setReferencia(String string) {
        referencia = string;
    }

    /**
     * @param string
     */
    public void setReservadoPor(String string) {
        reservadoPor = string;
    }

    /**
     * @param i
     */
    public void setSupConstruida(int i) {
        supConstruida = i;
    }

    /**
     * @param i
     */
    public void setSuperficie(int i) {
        superficie = i;
    }

    /**
     * @param i
     */
    public void setSupUtil(int i) {
        supUtil = i;
    }

    /**
     * @param string
     */
    public void setTipo(String string) {
        tipo = string;
    }

    /**
     * @param string
     */
    public void setTipoVia(String string) {
        tipoVia = string;
    }

    /**
     * @param date
     */
    public void setUltimaModificacion(Date date) {
        ultimaModificacion = date;
    }

    /**
     * @param string
     */
    public void setVendedor(String string) {
        vendedor = string;
    }

    /**
     * @param string
     */
    public void setZona(String string) {
        zona = string;
    }

}
