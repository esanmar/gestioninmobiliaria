package com.emesa.gestinm.dao;

import java.util.*;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;

import com.emesa.bbdd.DBManager;
import net.seh.bbdd.AbstractDBManager;
import com.emesa.Configuration;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 * 
 * @since Mon Jul 21 13:42:04 CEST 2003
 */
public class FEL_PARCELA
{
	static Logger logger = Logger.getLogger(FEL_PARCELA.class);
	//-- Atributos
	private int CODIGO=-1;
	private int ANTIGUEDAD;
	private int HECTAREAS;
	private int URBANIZABLE;
	private int AGRICOLA;
	private int DESAGUES;
	private int RESIDENCIA;
	private int VALLADO;
	private String TOMA_AGUA;
	private String TOMA_LUZ;


	//-- GETs y SETs
	/**
	 * Devuelve CODIGO
	 * 
	 * @return CODIGO
	 */
	public int getCODIGO()
	{
		return this.CODIGO;
	}

	/**
	 * Asigna CODIGO
	 * 
	 * @param unCODIGO
	 */
	public void setCODIGO(int unCODIGO)
	{
		this.CODIGO = unCODIGO;
	}

	/**
	 * Devuelve ANTIGUEDAD
	 * 
	 * @return ANTIGUEDAD
	 */
	public int getANTIGUEDAD()
	{
		return this.ANTIGUEDAD;
	}

	/**
	 * Asigna ANTIGUEDAD
	 * 
	 * @param unANTIGUEDAD
	 */
	public void setANTIGUEDAD(int unANTIGUEDAD)
	{
		this.ANTIGUEDAD = unANTIGUEDAD;
	}

	/**
	 * Devuelve HECTAREAS
	 * 
	 * @return HECTAREAS
	 */
	public int getHECTAREAS()
	{
		return this.HECTAREAS;
	}

	/**
	 * Asigna HECTAREAS
	 * 
	 * @param unHECTAREAS
	 */
	public void setHECTAREAS(int unHECTAREAS)
	{
		this.HECTAREAS = unHECTAREAS;
	}

	/**
	 * Devuelve URBANIZABLE
	 * 
	 * @return URBANIZABLE
	 */
	public int getURBANIZABLE()
	{
		return this.URBANIZABLE;
	}

	/**
	 * Asigna URBANIZABLE
	 * 
	 * @param unURBANIZABLE
	 */
	public void setURBANIZABLE(int unURBANIZABLE)
	{
		this.URBANIZABLE = unURBANIZABLE;
	}

	/**
	 * Devuelve AGRICOLA
	 * 
	 * @return AGRICOLA
	 */
	public int getAGRICOLA()
	{
		return this.AGRICOLA;
	}

	/**
	 * Asigna AGRICOLA
	 * 
	 * @param unAGRICOLA
	 */
	public void setAGRICOLA(int unAGRICOLA)
	{
		this.AGRICOLA = unAGRICOLA;
	}

	/**
	 * Devuelve DESAGUES
	 * 
	 * @return DESAGUES
	 */
	public int getDESAGUES()
	{
		return this.DESAGUES;
	}

	/**
	 * Asigna DESAGUES
	 * 
	 * @param unDESAGUES
	 */
	public void setDESAGUES(int unDESAGUES)
	{
		this.DESAGUES = unDESAGUES;
	}

	/**
	 * Devuelve RESIDENCIA
	 * 
	 * @return RESIDENCIA
	 */
	public int getRESIDENCIA()
	{
		return this.RESIDENCIA;
	}

	/**
	 * Asigna RESIDENCIA
	 * 
	 * @param unRESIDENCIA
	 */
	public void setRESIDENCIA(int unRESIDENCIA)
	{
		this.RESIDENCIA = unRESIDENCIA;
	}

	/**
	 * Devuelve VALLADO
	 * 
	 * @return VALLADO
	 */
	public int getVALLADO()
	{
		return this.VALLADO;
	}

	/**
	 * Asigna VALLADO
	 * 
	 * @param unVALLADO
	 */
	public void setVALLADO(int unVALLADO)
	{
		this.VALLADO = unVALLADO;
	}

	/**
	 * Devuelve TOMA_AGUA
	 * 
	 * @return TOMA_AGUA
	 */
	public String getTOMA_AGUA()
	{
		return this.TOMA_AGUA;
	}

	/**
	 * Asigna TOMA_AGUA
	 * 
	 * @param unTOMA_AGUA
	 */
	public void setTOMA_AGUA(String unTOMA_AGUA)
	{
		this.TOMA_AGUA = unTOMA_AGUA;
	}

	/**
	 * Devuelve TOMA_LUZ
	 * 
	 * @return TOMA_LUZ
	 */
	public String getTOMA_LUZ()
	{
		return this.TOMA_LUZ;
	}

	/**
	 * Asigna TOMA_LUZ
	 * 
	 * @param unTOMA_LUZ
	 */
	public void setTOMA_LUZ(String unTOMA_LUZ)
	{
		this.TOMA_LUZ = unTOMA_LUZ;
	}
	
	
	/**
     * @return <code>true</code> si ya existe un piso con ese ID
     */
    public boolean exists() throws java.sql.SQLException {
        if(getCODIGO()==-1)
            return false;
        else {
            String sql = "select CODIGO from FEL_PARCELA where CODIGO="+getCODIGO();
            AbstractDBManager dbm = DBManager.getInstance();
            Vector vRtado=dbm.executeQuery(sql);
            dbm.close();
            if(vRtado!=null && !vRtado.isEmpty())
                return true;
            else
                return false;
        }
    }
    
    
	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto FEL_PARCELA
	*/
	public FEL_PARCELA loadFromDB(int nPK)
	{
		StringBuffer sSQL=new StringBuffer("SELECT CODIGO,ANTIGUEDAD,HECTAREAS,URBANIZABLE,AGRICOLA,DESAGUES,RESIDENCIA,VALLADO,TOMA_AGUA,TOMA_LUZ FROM FEL_PARCELA WHERE CODIGO=?");
		Vector vParams=new Vector();

		vParams.add(new Integer(nPK));
		AbstractDBManager dbm = DBManager.getInstance();
		Vector vRtado = new Vector();
		try {
			vRtado=dbm.executeQuery(sSQL.toString(),vParams);
		}
		catch(Exception e) {
			//-- Tratamiento de la excepcion
			return null;
		}
		
		if(vRtado!=null && !vRtado.isEmpty()) {
				//-- Solo puede haber un rtado puesto que __PK__ es PK
				setElement( (Vector)vRtado.firstElement() );
		}

		return this;
	 }
		
	
	/**
     */
    public void setElement(Vector vRow) 
    {
		
		if(vRow.elementAt(0)!=null)
			setCODIGO( Integer.parseInt(vRow.elementAt(0).toString().trim()) );
		if(vRow.elementAt(1)!=null)
			setANTIGUEDAD( Integer.parseInt(vRow.elementAt(1).toString().trim()) );
		if(vRow.elementAt(2)!=null)
			setHECTAREAS( Integer.parseInt(vRow.elementAt(2).toString().trim()) );
		if(vRow.elementAt(3)!=null)
			setURBANIZABLE( Integer.parseInt(vRow.elementAt(3).toString().trim()) );
		if(vRow.elementAt(4)!=null)
			setAGRICOLA( Integer.parseInt(vRow.elementAt(4).toString().trim()) );
		if(vRow.elementAt(5)!=null)
			setDESAGUES( Integer.parseInt(vRow.elementAt(5).toString().trim()) );
		if(vRow.elementAt(6)!=null)
			setRESIDENCIA( Integer.parseInt(vRow.elementAt(6).toString().trim()) );
		if(vRow.elementAt(7)!=null)
			setVALLADO( Integer.parseInt(vRow.elementAt(7).toString().trim()) );
		if(vRow.elementAt(8)!=null)
			setTOMA_AGUA(vRow.elementAt(8).toString().trim());
		if(vRow.elementAt(9)!=null)
			setTOMA_LUZ(vRow.elementAt(9).toString().trim());
	
	}


	/**
	* Guarda la informaci&oacute;n del objeto en la tabla.
	*/
	public void saveToDB() throws java.sql.SQLException
	{
	 	if(getCODIGO()==-1)
            throw new java.sql.SQLException("Parcela sin código asociado");

		StringBuffer sSQL=null;
		boolean bExists=true;
		//-- Chequeamos a ver si es un objeto nuevo
		if(!exists()) {
            bExists=false;
			sSQL = new StringBuffer("INSERT INTO FEL_PARCELA ");
			sSQL.append("(CODIGO,ANTIGUEDAD,HECTAREAS,URBANIZABLE,AGRICOLA,DESAGUES,RESIDENCIA,VALLADO,TOMA_AGUA,TOMA_LUZ");
			sSQL.append(") VALUES (?,?,?,?,?,?,?,?,?,?)");
		}
		else {
			sSQL = new StringBuffer("UPDATE FEL_PARCELA SET ");
			sSQL.append("ANTIGUEDAD=?");
			sSQL.append(", HECTAREAS=?");
			sSQL.append(", URBANIZABLE=?");
			sSQL.append(", AGRICOLA=?");
			sSQL.append(", DESAGUES=?");
			sSQL.append(", RESIDENCIA=?");
			sSQL.append(", VALLADO=?");
			sSQL.append(", TOMA_AGUA=?");
			sSQL.append(", TOMA_LUZ=?");
			sSQL.append(" WHERE CODIGO=?");
		}
		
		Vector vParams=new Vector();
		if(!bExists)
            vParams.add( new Integer(getCODIGO()) );
            
		vParams.add( new Integer(getANTIGUEDAD()) );
		vParams.add( new Integer(getHECTAREAS()) );
		vParams.add( new Integer(getURBANIZABLE()) );
		vParams.add( new Integer(getAGRICOLA()) );
		vParams.add( new Integer(getDESAGUES()) );
		vParams.add( new Integer(getRESIDENCIA()) );
		vParams.add( new Integer(getVALLADO()) );
		vParams.add(getTOMA_AGUA());
		vParams.add(getTOMA_LUZ());
			
		if(bExists)
            vParams.add( new Integer(getCODIGO()) );
		
	
		AbstractDBManager dbm = DBManager.getInstance();
		dbm.executeUpdate(sSQL.toString(), vParams);
	}
	
		/**
     * Borra el registro de la BB.DD.
     *
     * @return n&uacute;mero de registros modificados
     */
    public static int delete(int nId) throws java.sql.SQLException{
        StringBuffer sSQL=new StringBuffer("delete from FEL_PARCELA where Codigo=?");
        Vector vParams=new Vector();

        vParams=new Vector();
        vParams.add(new Integer(nId));

        AbstractDBManager dbm = DBManager.getInstance();
        return dbm.executeUpdate(sSQL.toString(),vParams);
    }


	
}
