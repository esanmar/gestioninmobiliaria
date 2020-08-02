package com.emesa.portalframework;

import java.util.BitSet;


/**
 * Representaci&oacute;n de la m&aacute;scara de permisos para los enlaces
 */
public class PermissionMask implements java.io.Serializable
{
	/** M&aacute;scara de permisos*/
	BitSet oMascara;


	/**
	 * Constructor por defecto
	 */
	public PermissionMask()
	{
		this("0");
	}


	/**
	 * Constructor. Asigna los permisos seg&uacute;n la m&aacute;scara
	 *
	 * @param sPermisos M&aacute;scara con los permisos
	 */
	public PermissionMask(String sPermisos)
	{
		oMascara = new BitSet(sPermisos.length());
		char [] aPermisos = sPermisos.toCharArray();
		for(int i=0; i<aPermisos.length; i++) {
			if(aPermisos[i]=='1')
				oMascara.set(i);
			else
				oMascara.clear(i);
		}
	}


	/**
	 * Comprueba si el enlace es accesible para <code>nIndice</code>
	 *
	 * @param nIndice &Iacute;ndice de la m&aacute;scara de permisos a comprobar
	 * @return <code>true</code> si la posici&oacute;n de la m&aacute;scara en el
	 * &iacute;ndice es '1' y <code>false</code> si es '0'
	 */
	public boolean check(int nIndice)
	{
		return oMascara.get(nIndice);
	}

    /**
     * Representaci&oacute;n del objeto
     *
     * @return String
     */
    public String toString() {
        String s="";
        for(int i=0;i<oMascara.size(); i++) {
            s+=(oMascara.get(i)?"1":"0");
        }

        return s;
    }
}