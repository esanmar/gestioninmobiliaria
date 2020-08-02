package com.emesa.gestinm.dao;

import java.util.Vector;
import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;
import net.seh.bbdd.AbstractDBManager;

/**
 * Reperesentaci&oacute;n de la tabla FEL_FOTOS_INMUEBLE
 */
public class FotosInmueble
{
    static Logger logger = Logger.getLogger(FotosInmueble.class);
    static final String SQL_QUERY="SELECT ID_FOTO,ID_INMUEBLE,PATH_FOTO,VISIBLE FROM fel_fotos_inmueble";

	private int ID_FOTO=-1;
	private int ID_INMUEBLE=-1;
	private String PATH_FOTO=null;
	private int VISIBLE=0;

//	///////////////////////////////////////////////////////////////////////

    /**
     * Devuelve el nombre de las fotos asociadas a ese inmueble
     *
     * @param idInmueble Identificador del inmueble
     */
    public static Vector getPictures(int idInmueble) {
        //String sql="select PATH_FOTO from fel_fotos_inmueble where ID_INMUEBLE=?";
        Vector vPics = new Vector();
        Vector vParams=new Vector();
        vParams.add(new Integer(idInmueble));

        Vector vRtado=new Vector();
        try {
            AbstractDBManager dbm = DBManager.getInstance();
            vRtado=dbm.executeQuery(SQL_QUERY+" where ID_INMUEBLE=?",vParams);
            dbm.close();
        } catch(Exception e) {
            logger.error("[getPictures] Error: "+e);
            return new Vector();
        }

		if(vRtado!=null && !vRtado.isEmpty()) {
			for(int i=0; i<vRtado.size(); i++) {
				vPics.add( FotosInmueble.setElement((Vector)vRtado.elementAt(i)));
			}
		}

		return vPics;
    }

	/**
	 * 
	 * 
	 * @param vRow
	 * @return
	 */
	public static FotosInmueble setElement(Vector vRow) {
		FotosInmueble o=new FotosInmueble();
		if(vRow.elementAt(0)!=null) {
			o.setID_FOTO(Integer.parseInt(vRow.elementAt(0).toString()));				
		}
		if(vRow.elementAt(1)!=null) {
			o.setID_INMUEBLE(Integer.parseInt(vRow.elementAt(1).toString()));				
		}
		if(vRow.elementAt(2)!=null) {
			o.setPATH_FOTO(vRow.elementAt(2).toString().trim());				
		}
		if(vRow.elementAt(3)!=null) {
			o.setVISIBLE(Integer.parseInt( vRow.elementAt(3).toString()) );				
		}
		return o;
	}

    /**
     * A&ntilde;ade una foto a la tabla.
     *
     * @param idInmueble Identificador del inmueble
     * @param Nombre con extensi&oacute;n de la foto
     * @return N&uacute;mero de registros afectados por la <i>query</i>
     */
    public static int addPicture(int idInmueble, String sPath, int nVisible) throws java.sql.SQLException
    {
        int n=-1;
        String sql="insert into FEL_FOTOS_INMUEBLE (ID_INMUEBLE,PATH_FOTO,VISIBLE) values (?,?,?)";
        Vector vParams =new Vector();
        vParams.add(new Integer(idInmueble));
        vParams.add(sPath);
		vParams.add(new Integer(nVisible));

        //logger.debug("[addPicture] "+sql+"-"+vParams);
        AbstractDBManager dbm = DBManager.getInstance();
        n=dbm.executeUpdate(sql,vParams);
        dbm.close();

        return n;
    }


    /**
     * Elimina una foto a la tabla.
     *
     * @param idInmueble Identificador del inmueble
     * @param Nombre con extensi&oacute;n de la foto
     * @return N&uacute;mero de registros afectados por la <i>query</i>
     */
    public static int delPicture(int idInmueble, String sPath) throws java.sql.SQLException
    {
        int n=-1;
        String sql="delete from FEL_FOTOS_INMUEBLE where ID_INMUEBLE=? and PATH_FOTO=?";
        Vector vParams =new Vector();
        vParams.add(new Integer(idInmueble));
        vParams.add(sPath);

        AbstractDBManager dbm = DBManager.getInstance();
        n=dbm.executeUpdate(sql,vParams);
        dbm.close();

        return n;
    }

//	///////////////////////////////////////////////////////////////////////

	/**
	 * 
	 * @return
	 */
	public int getID_FOTO() {
		return ID_FOTO;
	}

	/**
	 * 
	 * @return
	 */
	public int getID_INMUEBLE() {
		return ID_INMUEBLE;
	}

	/**
	 * 
	 * @return
	 */
	public String getPATH_FOTO() {
		return PATH_FOTO;
	}

	/**
	 * 
	 * @return
	 */
	public int getVISIBLE() {
		return VISIBLE;
	}

	/**
	 * 
	 * @param i
	 */
	public void setID_FOTO(int i) {
		ID_FOTO = i;
	}

	/**
	 * 
	 * @param i
	 */
	public void setID_INMUEBLE(int i) {
		ID_INMUEBLE = i;
	}

	/**
	 * 
	 * @param string
	 */
	public void setPATH_FOTO(String string) {
		PATH_FOTO = string;
	}

	/**
	 * 
	 * @param i
	 */
	public void setVISIBLE(int i) {
		VISIBLE = i;
	}

//	///////////////////////////////////////////////////////////////////////

	public String toString() {
		return "FotosInmueble-{"+getID_FOTO()+", "+getPATH_FOTO()+", "+getVISIBLE()+"}";
	}
}
