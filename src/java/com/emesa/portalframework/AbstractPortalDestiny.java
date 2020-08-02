package com.emesa.portalframework;

import java.util.Map;

/**
 * Indicador de hacia donde va y que acci&oacute;n piensa realizar el usuario del portal
 */
public class AbstractPortalDestiny implements IPortalDestiny
{
    String tab="";
    Object acc=null;
    Object altAcc=null;
    Map parameters=null;

    /** La <i>tab</i> o pesta&ntilde;a o portal a la que se accede */
    public String getTab() {
        return tab;
    }
    /** Acci&oacute;n que va a realizarse */
    public Object getAction() {
        return acc;
    }
    /** Acci&oacute;n alternativa que va a realizarse */
    public Object getAltAction() {
        return altAcc;
    }
    /** Par&aacute;metros que utiliza */
    public Map getParameters() {
        return parameters;
    }

    /** La <i>tab</i> o pesta&ntilde;a o portal a la que se accede */
    public void setTab(String s) {
        this.tab=s;
    }
    /** Acci&oacute;n que va a realizarse */
    public void setAction(Object acc) {
        this.acc=acc;
    }
    /** Acci&oacute;n alternativa que va a realizarse */
    public void setAltAction(Object altAcc) {
        this.altAcc=altAcc;
    }
    /** Par&aacute;metros que utiliza */
    public void setParameter(Object key, Object value) {
        parameters.put(key,value);
    }
    /** Indicaci&oacute;n de si el usuario puede ir o no al destino se&ntilde;alado */
    public boolean isAllowed(IUserProfile uprofile) {
        return true;
    }
}
