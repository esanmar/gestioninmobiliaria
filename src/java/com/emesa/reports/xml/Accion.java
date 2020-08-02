package com.emesa.reports.xml;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.ConversionException;
import javax.xml.bind.Dispatcher;
import javax.xml.bind.DuplicateAttributeException;
import javax.xml.bind.Element;
import javax.xml.bind.InvalidAttributeException;
import javax.xml.bind.LocalValidationException;
import javax.xml.bind.MarshallableObject;
import javax.xml.bind.Marshaller;
import javax.xml.bind.StructureValidationException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import javax.xml.marshal.XMLScanner;
import javax.xml.marshal.XMLWriter;


public class Accion
    extends MarshallableObject
    implements Element
{

    private String _Tipo;
    private boolean isDefaulted_Tipo = true;
    private final static String DEFAULT_TIPO = String.valueOf("texto");
    private String _Content;

    public boolean defaultedTipo() {
        return (_Tipo!= null);
    }

    public String getTipo() {
        if (_Tipo == null) {
            return DEFAULT_TIPO;
        }
        return _Tipo;
    }

    public void setTipo(String _Tipo) {
        this._Tipo = _Tipo;
        if (_Tipo == null) {
            invalidate();
        }
    }

    public String getContent() {
        return _Content;
    }

    public void setContent(String _Content) {
        this._Content = _Content;
        if (_Content == null) {
            invalidate();
        }
    }

    public void validateThis()
        throws LocalValidationException
    {
    }

    public void validate(Validator v)
        throws StructureValidationException
    {
    }

    public void marshal(Marshaller m)
        throws IOException
    {
        XMLWriter w = m.writer();
        w.start("Accion");
        if (_Tipo!= null) {
            w.attribute("tipo", _Tipo.toString());
        }
        if (_Content!= null) {
            w.chars(_Content.toString());
        }
        w.end("Accion");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Accion");
        while (xs.atAttribute()) {
            String an = xs.takeAttributeName();
            if (an.equals("tipo")) {
                if (_Tipo!= null) {
                    throw new DuplicateAttributeException(an);
                }
                _Tipo = xs.takeAttributeValue();
                continue;
            }
            throw new InvalidAttributeException(an);
        }
        {
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _Content = String.valueOf(s);
            } catch (Exception x) {
                throw new ConversionException("content", x);
            }
        }
        xs.takeEnd("Accion");
    }

    public static Accion unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static Accion unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static Accion unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((Accion) d.unmarshal(xs, (Accion.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Accion)) {
            return false;
        }
        Accion tob = ((Accion) ob);
        if (_Tipo!= null) {
            if (tob._Tipo == null) {
                return false;
            }
            if (!_Tipo.equals(tob._Tipo)) {
                return false;
            }
        } else {
            if (tob._Tipo!= null) {
                return false;
            }
        }
        if (_Content!= null) {
            if (tob._Content == null) {
                return false;
            }
            if (!_Content.equals(tob._Content)) {
                return false;
            }
        } else {
            if (tob._Content!= null) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_Tipo!= null)?_Tipo.hashCode(): 0));
        h = ((127 *h)+((_Content!= null)?_Content.hashCode(): 0));
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Accion");
        sb.append(" tipo=");
        sb.append(getTipo().toString());
        if (_Content!= null) {
            sb.append(" content=");
            sb.append(_Content.toString());
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        Dispatcher d = new Dispatcher();
        d.register("Accion", (Accion.class));
        d.register("Detail", (Detail.class));
        d.register("Informe", (Informe.class));
        d.register("Informes", (Informes.class));
        d.register("Query", (Query.class));
        d.register("Query_param", (QueryParam.class));
        d.freezeElementNameMap();
        return d;
    }

}
