package net.seh.util;

import java.util.*;


/**
 * Paginador de objetos. Dada una colecci&oacute;n (<code>java.util.Collection</code>)
 * de objetos, este objeto se encarga de proporcionar los m&eacute;todos para poder realizar
 * la paginaci&oacute;n sobre los objetos que contiene.
 *
 * @author sasa eh
 * @since 2002/12/04
 * @version 0.9
 * @see java.util.Collection
 * @see java.util.List
 * @see java.util.Vector
 */
public class Pager
{
	/** Objetos a paginar */
	private Vector vObjetos=null;
	/** Tama&ntilde;o de la la p&aacute;gina, i.e. n&uacute;mero de objetos por p&aacute;gina. Por defecto 1 */
	private int nPageSize=1;
	/** Posici&oacute;n del cursor */
	private int nCursor=-1;



	/**
	 * Constructor
	 *
	 * @param oObjetos <code>Collection</code> con los objetos a paginar
	 */
	public Pager(Collection oObjetos)
	{
		this(oObjetos, 1, 0);
	}


	/**
	 * Constructor
	 *
	 * @param oObjetos <code>Collection</code> con los objetos a paginar
	 * @param nPageSize N&acute;mero de objetos por p&aacute;gina
	 */
	public Pager(Collection oObjetos, int nPageSize)
	{
		this(oObjetos, nPageSize, 0);
	}


	/**
	 * Constructor
	 *
	 * @param oObjetos <code>Collection</code> con los objetos a paginar
	 * @param nPageSize N&acute;mero de objetos por p&aacute;gina
	 * @param nCursor &Iacute;ndice dentro del vector de objetos a paginar
	 */
	public Pager(Collection oObjetos, int nPageSize, int nCursor)
	{
		this.vObjetos=new Vector(oObjetos);
		setPageSize(nPageSize);
		setCursor(nCursor);
	}


	/**
	 * @param i P&aacute;gina a situar el cursor
	 */
	public void setAtPage(int n)
	{
		setCursor((n-1)*getPageSize());
	}


	/**
	 * @param i Posici&oacute;n a situar el cursor de 0 a n-1
	 */
	public void setCursor(int i)
	{
		if(i<0)
			setCursorAtStart();
		else if(i>vObjetos.size())
			setCursorAtEnd();
		else
			this.nCursor=i;
	}

	/**
	 * @return Posici&oacute;n del cursor de 0 a n-1
	 */
	public int getCursor()
	{
		return this.nCursor;
	}

	/**
	 * @return P&aacute;gina en la que nos encontramos
	 */
	public int getPage()
	{
		int dif=0;
		if(getCursor() % getPageSize() != 0)
			dif=1;

		return dif + (getCursor()/getPageSize());
	}


	/**
	 * Posicionamos el cursor al inicio
	 */
	public void setCursorAtStart()
	{
		setCursor(0);
	}

	/**
	 * Posicionamos el cursor al final
	 */
	public void setCursorAtEnd()
	{
		setCursor(vObjetos.size());
	}



	/**
	 * Asigna el n&uacute;mero de objetos que contiene una p&aacute;gina.
	 * Si el tama&ntilde;o pasado es mayor que el n&uacute;mero de objetos a paginar, se toma el tama&ntilde;o m&aacute;ximo.
	 * Si el tama&ntilde;o pasado es menor de 1, se utiliza 1.
	 *
	 * @param nPageSize Tama&ntilde;o de la p&aacute;gina
	 */
	public void setPageSize(int nPageSize)
	{
		if(nPageSize > vObjetos.size())
			this.nPageSize=vObjetos.size();
		else if(nPageSize < 1 )
			this.nPageSize=1;
		else
			this.nPageSize=nPageSize;
	}


	/**
	 * 
	 *
	 * @return Tama&ntilde;o de la p&aacute;gina
	 */
	public int getPageSize()
	{
		return this.nPageSize;
	}

	/**
	 *
	 * @return Tama&ntilde;o de la <code>Collection</code> a paginar
	 */
	public int size()
	{
		return this.vObjetos.size();
	}


	/**
	 * 
	 *
	 * @return N&uacte;mero total de p&aacute;ginas
	 */
	public int getTotalPages()
	{
		int dif=0;
		if(this.vObjetos.size() % getPageSize() != 0)
			dif=1;

		return dif + (this.vObjetos.size()/getPageSize());
	}



	/**
	 * Indica si hay m&aacute;s elementos a partir de la posici&oacute;n del cursor
	 *
	 * @return <code>true</code> si hay m&aacute;s elementos a partir de la posici&oacute;n del cursor
	 */
	public boolean hasNext()
	{
		if(this.nCursor < vObjetos.size())
			return true;
		else
			return false;
	}


	/**
	 * 
	 *
	 * @return <code>List</code>
	 */
	public List next()
	{
		int toLimit=this.nCursor+this.nPageSize;
		if(toLimit>vObjetos.size())
			toLimit=vObjetos.size();

		//System.out.println("[Pager][next] "+nCursor+"-"+toLimit+"/"+vObjetos.size()+"; Pagina: "+nPageSize);		System.out.println("[Pager][next] Cursor: "+nCursor+"-"+toLimit+"; Pagina: "+nPageSize);

		List oPage = vObjetos.subList(this.nCursor, toLimit);

		// Actualizamos el cursor
		setCursor(toLimit);

		return oPage;
	}

/*
	 * 
	 *
	public boolean hasPrevious()
	{
		if(this.nCursor < 1)
			return false;
		else
			return true;
	}
*/
	/**
	 * Indica si hay una p&aacute;gina anterior
	 */
	public boolean hasPrevious()
	{
		if(getPage() <= 1)
			return false;
		else
			return true;
	}


	/**
	 * 
	 *
	 * @return <code>List</code>
	 */
	public List previous()
	{
		int fromLimit=this.nCursor-this.nPageSize;
		if(fromLimit<0)
			fromLimit=0;

		//System.out.println("[Pager][previous] "+fromLimit+"-"+nCursor+"/"+vObjetos.size()+"; Pagina: "+nPageSize);
		List oPage = vObjetos.subList(fromLimit,this.nCursor);

		// Actualizamos el cursor
		setCursor(fromLimit);
		return oPage;
	}


	/**
	 * Representaci&oacute;n del objeto
	 *
	 * return <code>String</code> que representa al objeto
	 */
	public String toString()
	{
		return "Pager-["+vObjetos+", "+nCursor+", "+nPageSize+"]";
	}


	/**
	 * Para pruebas
	 */
	public static void main(String[] args)
	{
		Vector vPruebas=new Vector();
		vPruebas.add("1");
		vPruebas.add("2");
		vPruebas.add("3");
		vPruebas.add("4");
		vPruebas.add("5");
		vPruebas.add("6");
		vPruebas.add("7");

		Pager p=new Pager(vPruebas,7);
		System.out.println(">> "+p);
		int i=0;
		while(p.hasNext()) {
			System.out.println(">> #"+(i++)+" -> "+p.next());
		}

		i=0;
		p.setCursorAtEnd();
		System.out.println("\n>> Posicionamos el cursor en "+p.getCursor());
		while(p.hasPrevious()) {
			System.out.println(">> -#"+(i++)+" -> "+p.previous());
		}

		System.out.println("\n>> Nos situamos en la página 2 de "+p.getTotalPages());
		p.setAtPage(2);
		i=0;
		while(p.hasNext()) {
			System.out.println(">> #"+(i++)+" -> "+p.next());
		}

	}
}