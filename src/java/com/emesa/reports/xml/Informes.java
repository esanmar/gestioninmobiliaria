package com.emesa.reports.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.ConversionException;
import javax.xml.bind.Dispatcher;
import javax.xml.bind.InvalidAttributeException;
import javax.xml.bind.InvalidContentObjectException;
import javax.xml.bind.LocalValidationException;
import javax.xml.bind.MarshallableObject;
import javax.xml.bind.MarshallableRootElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.MissingContentException;
import javax.xml.bind.PredicatedLists;
import javax.xml.bind.RootElement;
import javax.xml.bind.StructureValidationException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidatableObject;
import javax.xml.bind.Validator;
import javax.xml.marshal.XMLScanner;
import javax.xml.marshal.XMLWriter;


public class Informes
    extends MarshallableRootElement
    implements RootElement
{

    private String _DBJNDI;
    private List _Informe = PredicatedLists.createInvalidating(this, new InformePredicate(), new ArrayList());
    private PredicatedLists.Predicate pred_Informe = new InformePredicate();

    public String getDBJNDI() {
        return _DBJNDI;
    }

    public void setDBJNDI(String _DBJNDI) {
        this._DBJNDI = _DBJNDI;
        if (_DBJNDI == null) {
            invalidate();
        }
    }

    public List getInforme() {
        return _Informe;
    }

    public void deleteInforme() {
        _Informe = null;
        invalidate();
    }

    public void emptyInforme() {
        _Informe = PredicatedLists.createInvalidating(this, pred_Informe, new ArrayList());
    }

    public void validateThis()
        throws LocalValidationException
    {
        if (_Informe == null) {
            throw new MissingContentException("Informe");
        }
    }

    public void validate(Validator v)
        throws StructureValidationException
    {
        for (Iterator i = _Informe.iterator(); i.hasNext(); ) {
            v.validate(((ValidatableObject) i.next()));
        }
    }

    public void marshal(Marshaller m)
        throws IOException
    {
        XMLWriter w = m.writer();
        w.start("Informes");
        if (_DBJNDI!= null) {
            w.leaf("DB_JNDI", _DBJNDI.toString());
        }
        for (Iterator i = _Informe.iterator(); i.hasNext(); ) {
            m.marshal(((MarshallableObject) i.next()));
        }
        w.end("Informes");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Informes");
        while (xs.atAttribute()) {
            String an = xs.takeAttributeName();
            throw new InvalidAttributeException(an);
        }
        if (xs.atStart("DB_JNDI")) {
            xs.takeStart("DB_JNDI");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _DBJNDI = String.valueOf(s);
            } catch (Exception x) {
                throw new ConversionException("DB_JNDI", x);
            }
            xs.takeEnd("DB_JNDI");
        }
        {
            List l = PredicatedLists.create(this, pred_Informe, new ArrayList());
            while (xs.atStart("Informe")) {
                l.add(((Informe) u.unmarshal()));
            }
            _Informe = PredicatedLists.createInvalidating(this, pred_Informe, l);
        }
        xs.takeEnd("Informes");
    }

    public static Informes unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static Informes unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static Informes unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((Informes) d.unmarshal(xs, (Informes.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Informes)) {
            return false;
        }
        Informes tob = ((Informes) ob);
        if (_DBJNDI!= null) {
            if (tob._DBJNDI == null) {
                return false;
            }
            if (!_DBJNDI.equals(tob._DBJNDI)) {
                return false;
            }
        } else {
            if (tob._DBJNDI!= null) {
                return false;
            }
        }
        if (_Informe!= null) {
            if (tob._Informe == null) {
                return false;
            }
            if (!_Informe.equals(tob._Informe)) {
                return false;
            }
        } else {
            if (tob._Informe!= null) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_DBJNDI!= null)?_DBJNDI.hashCode(): 0));
        h = ((127 *h)+((_Informe!= null)?_Informe.hashCode(): 0));
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Informes");
        if (_DBJNDI!= null) {
            sb.append(" DB_JNDI=");
            sb.append(_DBJNDI.toString());
        }
        if (_Informe!= null) {
            sb.append(" Informe=");
            sb.append(_Informe.toString());
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        return Accion.newDispatcher();
    }


    private static class InformePredicate
        implements PredicatedLists.Predicate
    {


        public void check(Object ob) {
            if (!(ob instanceof Informe)) {
                throw new InvalidContentObjectException(ob, (Informe.class));
            }
        }

    }

}
