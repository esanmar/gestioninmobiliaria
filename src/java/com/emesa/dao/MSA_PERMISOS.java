package com.emesa.dao;

import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;


/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Fri Jul 04 09:04:07 CEST 2003
 */
public class MSA_PERMISOS
{
    /** Logger */
    static Logger logger = Logger.getLogger(MSA_PERMISOS.class);

	//-- Atributos
	private String ROLE;
	private String TAB;
	private String ACC="";
	private String ACC2="";

	//-- GETs y SETs
	/**
	 * Devuelve ROLE
	 *
	 * @return ROLE
	 */
	public String getROLE()
	{
		return this.ROLE;
	}

	/**
	 * Asigna ROLE
	 *
	 * @param unROLE
	 */
	public void setROLE(String unROLE)
	{
		this.ROLE = unROLE;
	}

	/**
	 * Devuelve TAB
	 *
	 * @return TAB
	 */
	public String getTAB()
	{
		return this.TAB;
	}

	/**
	 * Asigna TAB
	 *
	 * @param unTAB
	 */
	public void setTAB(String unTAB)
	{
		this.TAB = unTAB;
	}

	/**
	 * Devuelve ACC
	 *
	 * @return ACC
	 */
	public String getACC()
	{
		return this.ACC;
	}

	/**
	 * Asigna ACC
	 *
	 * @param unACC
	 */
	public void setACC(String unACC)
	{
		this.ACC = unACC;
	}

	/**
	 * Devuelve ACC2
	 *
	 * @return ACC2
	 */
	public String getACC2()
	{
		return this.ACC2;
	}

	/**
	 * Asigna ACC2
	 *
	 * @param unACC2
	 */
	public void setACC2(String unACC2)
	{
		this.ACC2 = unACC2;
	}

    /**
    * Carga la informaci&oacute;n de la tabla en el objeto.
    *
    * @return Objeto MSA_PERMISOS
    */
    public MSA_PERMISOS loadFromDB()
    {
        return loadFromDB(getROLE(),getTAB(),getACC(),getACC2());
    }

	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria (hemos supuesto un entero)
	* @return Objeto MSA_PERMISOS
	*/
	public MSA_PERMISOS loadFromDB(String sRole, String sTab, String sAcc, String sAcc2)
	{
		StringBuffer sSQL=new StringBuffer("SELECT ROLE,TAB,ACC,ACC2 FROM MSA_PERMISOS WHERE ROLE=? AND TAB=? AND ACC=? AND ACC2=?");
		Vector vParams=new Vector();

		vParams.add(sRole);
        vParams.add(sTab);
        vParams.add(sAcc);
        vParams.add(sAcc2);

		Vector vRtado = new Vector();
		try {
            AbstractDBManager dbm = DBManager.getInstance();
            vRtado=dbm.executeQuery(sSQL.toString(),vParams);
            logger.debug("[loadFromDB] Rtado: "+vRtado);
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
			logger.error(e.getMessage());
			return null;
		}

		if(vRtado!=null && !vRtado.isEmpty()) {
			setElement( (Vector)vRtado.firstElement() );
		}
        else {
            return null;
        }

        return this;
	}


    /**
     *
     *
     * @return Vector de <code>MSA_PERMISOS</code> del rol indicado
     */
    public static Vector rolePermissions(String sRole)
    {
        Vector vRtado=new Vector();
        Vector vReturn=new Vector();
        StringBuffer sSQL = new StringBuffer(getSelect()).append(" WHERE ROLE=?");

        Vector vParams=new Vector();
        vParams.add(sRole);
        try {
            AbstractDBManager dbm = DBManager.getInstance();
            vRtado=dbm.executeQuery(sSQL.toString(),vParams);
        }
        catch(Exception e) {
            logger.error("[rolePermissions] "+e.getMessage());
        }

        if(vRtado==null)
            return new Vector();
        else {
            MSA_PERMISOS o = null;
            for (int i=0; i<vRtado.size(); i++) {
                o = new MSA_PERMISOS();
                o.setElement((Vector)vRtado.elementAt(i));
                vReturn.add(o);
            }
        }

        return vReturn;
    }


    /**
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            this.ROLE = ((String)vRow.elementAt(0)).trim();
        if(vRow.elementAt(1)!=null)
            this.TAB = ((String)vRow.elementAt(1)).trim();
        if(vRow.elementAt(2)!=null)
            this.ACC = ((String)vRow.elementAt(2)).trim();
        if(vRow.elementAt(3)!=null)
            this.ACC2 = ((String)vRow.elementAt(3)).trim();
    }

	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
		StringBuffer sSQL=null;
        Vector vParams=null;
		//-- Chequeamos a ver si es un objeto nuevo
		if(getROLE()!=null && getTAB()!=null && getACC()!=null && getACC2()!=null) {
		    // Borramos de la BB.DD. y luego insertamos
            try {
                delete();
            }
            catch(Exception e) {
            }
			sSQL = new StringBuffer("INSERT INTO MSA_PERMISOS ");
			sSQL.append("(ROLE,TAB,ACC,ACC2) VALUES (?,?,?,?)");

            vParams=new Vector();
            vParams.add(getROLE());
            vParams.add(getTAB());
            vParams.add(getACC());
            vParams.add(getACC2());
		}

        AbstractDBManager dbm = DBManager.getInstance();
        dbm.executeUpdate(sSQL.toString(),vParams);
	}


    /**
     * Borramos el objeto de la BB.DD.
     */
    public int delete() throws java.sql.SQLException {
        StringBuffer sSQL=null;
        //-- Chequeamos a ver si es un objeto nuevo
        sSQL = new StringBuffer("delete from MSA_PERMISOS where ");
        sSQL.append("ROLE=? and ");
        sSQL.append("TAB=? and ");
        sSQL.append("ACC=? and ");
        sSQL.append("ACC2=?");

        Vector vParams=new Vector();
        vParams.add(getROLE());
        vParams.add(getTAB());
        vParams.add(getACC());
        vParams.add(getACC2());

        AbstractDBManager dbm = DBManager.getInstance();
        return dbm.executeUpdate(sSQL.toString(),vParams);
    }

    /**
     * Condici&oacute;n de igualdad
     *
     * @return <true>...
     */
    public boolean equals(Object o) {
        if(o==null)
            return false;
        try {
            MSA_PERMISOS ox=(MSA_PERMISOS)o;
            if(ox.getROLE().equals(getROLE()) &&
                ox.getTAB().equals(getTAB()) &&
                ox.getACC().equals(getACC()) &&
                ox.getACC2().equals(getACC2()))
                return true;
            else
                return false;
        }
        catch(Exception e) {
            return false;
        }
    }

    /**
     *
     * @return String que representa una <code>select</code> con todos los campos
     * del objeto y en el orden en el que se hace la inserci&oacute;n en el objeto
     */
    public static String getSelect() {
        return "SELECT ROLE,TAB,ACC,ACC2 FROM MSA_PERMISOS";
    }

    /**
     *
     * @return String que representa al objeto de forma única
     */
    public String key() {
        return getROLE()+getTAB()+getACC()+getACC2();
    }

	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "MSA_PERMISOS-[ROLE="+getROLE()+",TAB="+getTAB()+",ACC="+getACC()+",ACC2="+getACC2()+"]";
	}
}
