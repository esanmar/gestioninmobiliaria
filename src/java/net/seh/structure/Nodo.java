package net.seh.structure;

import java.util.Vector;
import java.util.HashMap;

/**
 * 
 * @author sasa eh
 * @version 0.2
 */
public class Nodo
{
	/** Profundidad del nodo */
	private int nProf=-1;
	/** Datos del nodo */
	private Object oData=null;
	/** Hijos del nodo */
	private Vector vChildren=null;

	/** Acceso r&aacute;pido para los hijos de un nodo */
	private HashMap hChildren=null;


/*---------------------------------------------------------------
 * 
 * 					CONSTRUCTORES
 * 
 */
	/**
	 * Constructor
	 */
	public Nodo()
	{
		this(-1,null,new Vector());
	}

	/**
	 * Constructor
	 * 
	 * @param nProf Profundidad del nodo
	 * @param oData Datos del nodo
	 */
	public Nodo(int nProf, Object oData)
	{
		this(nProf,oData,new Vector());
	}

	/**
	 * Constructor
	 *
	 * @param nProf Profundidad del nodo
	 * @param oData Datos del nodo
	 * @param vChildren Hijos del nodo. Debe ser un Vector de <code>Nodo</code>
	 */
	public Nodo(int nProf, Object oData, Vector vChildren)
	{
		setProf(nProf);
		setData(oData);
		setChildren(vChildren);
		/*
		hChildren = new HashMap();
		System.out.println("[Nodo] "+this);
		for(int i=0; i<this.vChildren.size(); i++) {
			System.out.println("[Nodo] Añadimos "+((Nodo)(this.vChildren.elementAt(i))).getData().hashCode()+" --> "+this.vChildren.elementAt(i));
			hChildren.put(
				new Integer( ((Nodo)(this.vChildren.elementAt(i))).getData().hashCode()),
				this.vChildren.elementAt(i)
			);
		}
		*/
	}


/*---------------------------------------------------------------
 * 
 * 					GETs Y SETs
 * 
 */
	/**
	 * Devuelve los hijos
	 * 
	 * @return Vector
	 */
	public Vector getChildren() {
		return vChildren;
	}

	/**
	 * Returns the data.
	 * 
	 * @return Object
	 */
	public Object getData() {
		return oData;
	}

	/**
	 * Returns the prof.
	 * @return int
	 */
	public int getProf() {
		return nProf;
	}

	/**
	 * Sets the vChildren.
	 * @param vChildren The vChildren to set
	 */
	public void setChildren(Vector vChildren) {
		this.vChildren = vChildren;
	}

	/**
	 * Sets the data.
	 * @param data The data to set
	 */
	public void setData(Object data) {
		oData = data;
	}

	/**
	 * Sets the prof.
	 * @param prof The prof to set
	 */
	public void setProf(int prof) {
		nProf = prof;
	}

/*---------------------------------------------------------------
 * 
 * 					MÉTODOS
 * 
 */
	/**
	 * A&ntilde;ade una lista de <i>hijos</i> al nodo
	 * 
	 * @param vObjs Vector de objetos
	 */
	public void addChildren(Vector vObjs)
	{
		for(int i=0; i<vObjs.size(); i++)
			this.addChild(vObjs.elementAt(i));
	}

	/**
	 * A&ntilde;ade un hijo al nodo
	 * 
	 * @param oChild Nodo hijo
	 */
	public void addChildNode(Nodo oChild)
	{
		addChildNode(getChildren().size(),oChild);
	}

	/**
	 * A&ntilde;ade un hijo al nodo. Es el que realmente a&ntilde;ade el objeto hijo.
	 * 
	 * @param index &Iacute;ndice donde a&ntilde;adir el nodo hijo.
	 * @param oChild Nodo hijo
	 */
	public void addChildNode(int index,Nodo oChild)
	{
		//this.hChildren.put(new Integer(oChild.getData().hashCode()),oChild);
		this.vChildren.add(index, oChild);
	}

	/**
	 * A&ntilde;ade un hijo al nodo
	 * 
	 * @param oChild Objeto que representa al nodo hijo
	 */
	public Nodo addChild(Object oChild)
	{
		Nodo oNodoChild = new Nodo(getProf()+1,oChild);
		addChildNode(new Nodo(getProf()+1,oChild));
		return oNodoChild;
	}

	/**
	 * A&ntilde;ade un hijo al nodo
	 * 
	 * @param index &Iacute;ndice donde a&ntilde;adir el nodo hijo.
	 * @param oChild Objeto que representa al nodo hijo
	 */
	public Nodo addChild(int index,Object oChild)
	{
		Nodo oNodoChild = new Nodo(getProf()+1,oChild);
		addChildNode(index, oNodoChild);
		return oNodoChild;
	}

	/**
	 * A&ntilde;ade un hijo al nodo
	 * 
	 * @param index &Iacute;ndice donde a&ntilde;adir el nodo hijo.
	 * @param oChild Objeto que representa al nodo hijo
	 */
	public Nodo getChild(Object oChild)
	{
		Nodo o = null;
		for (int i=0; i<vChildren.size(); i++) {
			o = ((Nodo)vChildren.elementAt(i));
			if( o.getData().equals(oChild) )
				return o;
		}

		return null;
	}

	/**
	 * Condici&oacute;n para que un nodo sea igual a otro: que sus datos sean los mismos
	 */
	public boolean equals(Object o)
	{
		try  {
			Nodo oNodo = (Nodo)o;
			return getData().equals(oNodo.getData());
		}
		catch(Exception e) {
			return false;
		}
	}

	/**
	 * Representaci&oacute;n del objeto
	 */
	public String toString()
	{
		return "{"+nProf+", "+oData+", "+vChildren+"}";
	}


	/**
	 * Para pruebas...
	 */
	public static void main(String[] args)
	{
		System.out.println("$ Creamos el root");
		Nodo root = new Nodo(0,"Root",new Vector());
		System.out.println("$ Añadimos 3 hijos");
		root.addChild("Hijo 1");
		root.addChild("Hijo 2");
		root.addChild("Hijo 3");
		System.out.println("$ Recogemos el 'Hijo 2' y le añadimos 2 hijos");
		Nodo o = root.getChild("Hijo 2");
		if(o==null) {
			System.out.println("$ No se ha encontrado 'Hijo 2'");
		}
		else {
			o.addChild("Hijo 2.1");
			o.addChild("Hijo 2.2");
		}
		System.out.println("$\n"+root.toString());
	}
}