package com.emesa.portalframework;

import java.util.Map;

/**
 * Indicador de hacia donde va y que acci&oacute;n piensa realizar el usuario del portal
 */
public interface IPortalDestiny
{
    String tab=null;
    Object acc=null;
    Object altAcc=null;
    Map parameters=null;

    /** La <i>tab</i> o pesta&ntilde;a o portal a la que se accede */
    public String getTab();
    /** Acci&oacute;n que va a realizarse */
    public Object getAction();
    /** Acci&oacute;n alternativa que va a realizarse */
    public Object getAltAction();
    /** Par&aacute;metros que utiliza */
    public java.util.Map getParameters();
    /** La <i>tab</i> o pesta&ntilde;a o portal a la que se accede */
    public void setTab(String s);
    /** Acci&oacute;n que va a realizarse */
    public void setAction(Object acc);
    /** Acci&oacute;n alternativa que va a realizarse */
    public void setAltAction(Object altAcc);
    /** Par&aacute;metros que utiliza */
    public void setParameter(Object sKey, Object sValue);
    /** Indicaci&oacute;n de si el usuario puede ir o no al destino se&ntilde;alado */
    public boolean isAllowed(IUserProfile uprofile);
}
