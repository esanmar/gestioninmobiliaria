 package com.emesa.dao;

import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import net.seh.bbdd.AbstractDBManager;

import org.apache.log4j.Logger;
import org.apache.regexp.RE;

import com.emesa.bbdd.DBManager;

/**
 * Generado autom&aacute;ticamente por WrapperMaker.
 *
 * @since Thu Jul 10 12:21:01 CEST 2003
 */
public class Informe
{
    /** Logger */
    static Logger logger = Logger.getLogger(Informe.class);

	//-- Información de los informes
    private int idConsulta=-1;
	private String nombre;
	private String descripcion;
	private String query;
    private Vector vTipoUsuario;

    //-- Información de la BB.DD. asociada
	private String bbdd;
    private String driver;
    private String url;
    private String usuario;
    private String clave;
    private String jndi;

    /** Parámetros de la query del informe */
    private Vector vParams;


    /**
     * Constructor
     */
    public Informe() {
        idConsulta=-1;
        nombre="";
        descripcion="";
        setQuery("");
        vTipoUsuario=new Vector();

        bbdd="";
        driver="";
        url="";
        usuario="";
        clave="";
        jndi="";

        vParams=new Vector();
    }

//---------------- GETs y SETs
    /**
     *
     * @return Par&aacute;metros de la consulta
     */
    public Vector getParameters() {
        return vParams;
    }

    /**
     *
     * @return Identificador de la consulta
     */
    public int getIdConsulta() {
        return idConsulta;
    }

    /**
     *
     * @return Nombre de la consulta
     */
    public String getNombreConsulta() {
        return this.nombre;
    }

    /**
     *
     * @param sQuery
     */
    public void setQuery(String sQuery) {
        this.query=sQuery;
    }

    /**
     *
     * @return Descripci&oacute;n de la consulta
     */
    public String getDescripcion() {
        return this.descripcion;
    }



	/**
	* Carga la informaci&oacute;n de la tabla en el objeto.
	*
	* @param nPK Clave primaria
	* @return Objeto Informe
	*/
	public Informe load(int nPK)
	{
        StringBuffer sSQL=new StringBuffer("SELECT i.NOMBRE,i.DESCRIPCION,QUERY,db.NOMBRE,TIPO_USUARIO,DRIVER,URL,db.USUARIO,db.CLAVE,JNDI,i.ID_CONSULTA FROM INF_CONSULTAS i, INF_BBDD db where ID_CONSULTA=? and i.ID_BBDD=db.ID_BBDD");
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
			//-- Solo puede haber un rtado puesto que ID_CONSULTA es PK
			setElement( (Vector)vRtado.firstElement() );
		}

        return this;
	}


    /**
    * Devuelve un vector con los informes que puede ver el tipo de usuario indicado
    *
    * @param sTipoUsuario Tipo de usuario
    * @return Vector con los informes que puede ver el tipo de usuario indicado
    */
    public static Vector roleReports(String sTipoUsuario)
    {
        StringBuffer sSQL=new StringBuffer("SELECT i.NOMBRE,i.DESCRIPCION,QUERY,db.NOMBRE,TIPO_USUARIO,DRIVER,URL,db.USUARIO,db.CLAVE,JNDI,i.ID_CONSULTA FROM INF_CONSULTAS i, INF_BBDD db where TIPO_USUARIO like '%"+sTipoUsuario+"%' and i.ID_BBDD=db.ID_BBDD order by i.NOMBRE");

        Vector vRtado = new Vector();
        AbstractDBManager dbm=null;
        try {
            dbm = DBManager.getInstance();
            vRtado=dbm.executeQuery(sSQL.toString());
            dbm.close();
        }
        catch(Exception e) {
            if(dbm!=null)
                dbm.close();
            logger.error("[roleReports] Error: "+e);
            return new Vector();
        }

        Informe o=null;
        Vector vReturn = new Vector();
        if(vRtado!=null && !vRtado.isEmpty()) {
            for(int i=0;i<vRtado.size(); i++) {
                o=new Informe();
                o.setElement((Vector)vRtado.elementAt(i));
                vReturn.add(o);
            }
        }
        return vReturn;
    }


    /**
     * Asignaci&oacute;n de los valores del registro al objeto
     *
     * @param vRow Vector que representa un registro en la BB.DD.
     */
    public void setElement(Vector vRow) {
        if(vRow.elementAt(0)!=null)
            this.nombre = vRow.elementAt(0).toString().trim();
        if(vRow.elementAt(1)!=null)
            this.descripcion = vRow.elementAt(1).toString().trim();
        if(vRow.elementAt(2)!=null)
            this.query = vRow.elementAt(2).toString().trim();
        if(vRow.elementAt(3)!=null)
            this.bbdd = vRow.elementAt(3).toString().trim();

        vTipoUsuario = new Vector();
        if(vRow.elementAt(4)!=null) {
            StringTokenizer st = new StringTokenizer( vRow.elementAt(4).toString().trim(),",",false);
            while (st.hasMoreElements()){
                vTipoUsuario.add(st.nextToken().trim());
            }
        }

        if(vRow.elementAt(5)!=null)
            this.driver = vRow.elementAt(5).toString().trim();
        if(vRow.elementAt(6)!=null)
            this.url = vRow.elementAt(6).toString().trim();
        if(vRow.elementAt(7)!=null)
            this.usuario = vRow.elementAt(7).toString().trim();
        if(vRow.elementAt(8)!=null)
            this.clave = vRow.elementAt(8).toString().trim();
        if(vRow.elementAt(9)!=null)
            this.jndi = vRow.elementAt(9).toString().trim();
        if(vRow.elementAt(10)!=null)
            this.idConsulta = Integer.parseInt( vRow.elementAt(10).toString().trim());

        //------------------------------------------------------
        //  PARÁMETROS
        //
        try {
            vParams=INF_PARAMETROS.paramsOfQuery(idConsulta);
        }
        catch(Exception e) {
            logger.warn("[setElement] Error: "+e);
            vParams=new Vector();
        }
    }


    /**
     *
     * @param vValues Valores de los par&aacute;metros necesarios para ejecutar la <i>query</i>
     * @return Vector con los resultados de ejecutar la <i>query</i>
     */
    public Vector execute(Vector vValues) throws java.lang.ClassNotFoundException,java.sql.SQLException {
        AbstractDBManager dbm=null;
        if(jndi!=null && !jndi.trim().equals("")) {
            dbm=net.seh.bbdd.DBManager.getInstance(jndi);
        }
        else {
            Properties p = new Properties();
            p.put("user",usuario);
            p.put("password",clave);
            dbm=net.seh.bbdd.DBManager.getInstance(driver,url,p);
        }

        logger.debug("[execute] Ejecutamos: "+query+"-"+vValues);
        return dbm.executeQuery(query,vValues);
    }

    /**
     *
     * @return Vector con los resultados de ejecutar la <i>query</i> contra
     * la BB.DD. por defecto
     */
    public Vector executeDirect() throws java.sql.SQLException {
        AbstractDBManager dbm=com.emesa.bbdd.DBManager.getInstance();
        return dbm.executeQuery(query);
    }

    /**
     *
     * @param vParams Vector con los par&aacute;metros para ejecutar la <i>query</i>
     * @return Vector con los resultados de ejecutar la <i>query</i> contra
     * la BB.DD. por defecto
     */
    public Vector executeDirect(Vector vParams) throws java.sql.SQLException {
        AbstractDBManager dbm=com.emesa.bbdd.DBManager.getInstance();
        logger.debug("[execute] Ejecutamos: "+query+"-"+vParams);
        return dbm.executeQuery(query,vParams);
    }


    /**
     * Devuelve una cabecera del informe basada en los campos solicitados en la
     * <i>query</i>
     *
     * @return Vector con la cabecera del resultado del informe
     */
    public Vector getHeader() {
        //-- Regexp para coger el título --
        RE regexp=null;
        try {
            regexp=new RE("SELECT (.*?) FROM");
        }
        catch(Exception e) {
            logger.warn("[getHeader] "+e);
            return new Vector();
        }

        String sHeader="";

        if(regexp.match(query.toUpperCase()))
            sHeader=regexp.getParen(1);

        StringTokenizer oSt=new StringTokenizer(sHeader.trim(),",",false);
        Vector vHeader=new Vector();
        String sHead="";
        int nPunto=-1;

        while(oSt.hasMoreTokens())
        {
            sHead=oSt.nextToken();
            nPunto=sHead.indexOf(".");
            if(nPunto!=-1)
                sHead=sHead.substring(nPunto+1);
            vHeader.add(sHead.replace('_',' '));
        }

        return vHeader;
    }


	/** Representaci&oacute;n del objeto */
	public String toString()
	{
		return "Informe-["+getIdConsulta()+", "+nombre+","+query+","+vTipoUsuario+","+bbdd+","+jndi+"]";
	}
}
