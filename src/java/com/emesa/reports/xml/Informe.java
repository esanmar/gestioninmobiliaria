package com.emesa.reports.xml;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.ConversionException;
import javax.xml.bind.Dispatcher;
import javax.xml.bind.Element;
import javax.xml.bind.InvalidAttributeException;
import javax.xml.bind.LocalValidationException;
import javax.xml.bind.MarshallableObject;
import javax.xml.bind.Marshaller;
import javax.xml.bind.MissingContentException;
import javax.xml.bind.StructureValidationException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import javax.xml.marshal.XMLScanner;
import javax.xml.marshal.XMLWriter;


public class Informe
    extends MarshallableObject
    implements Element
{

    private String _Nombre;
    private String _Descripcion;
    private String _DBJNDI;
    private Query _Query;

    public String getNombre() {
        return _Nombre;
    }

    public void setNombre(String _Nombre) {
        this._Nombre = _Nombre;
        if (_Nombre == null) {
            invalidate();
        }
    }

    public String getDescripcion() {
        return _Descripcion;
    }

    public void setDescripcion(String _Descripcion) {
        this._Descripcion = _Descripcion;
        if (_Descripcion == null) {
            invalidate();
        }
    }

    public String getDBJNDI() {
        return _DBJNDI;
    }

    public void setDBJNDI(String _DBJNDI) {
        this._DBJNDI = _DBJNDI;
        if (_DBJNDI == null) {
            invalidate();
        }
    }

    public Query getQuery() {
        return _Query;
    }

    public void setQuery(Query _Query) {
        this._Query = _Query;
        if (_Query == null) {
            invalidate();
        }
    }

    public void validateThis()
        throws LocalValidationException
    {
        if (_Nombre == null) {
            throw new MissingContentException("Nombre");
        }
        if (_Descripcion == null) {
            throw new MissingContentException("Descripcion");
        }
        if (_Query == null) {
            throw new MissingContentException("Query");
        }
    }

    public void validate(Validator v)
        throws StructureValidationException
    {
        v.validate(_Query);
    }

    public void marshal(Marshaller m)
        throws IOException
    {
        XMLWriter w = m.writer();
        w.start("Informe");
        w.leaf("Nombre", _Nombre.toString());
        w.leaf("Descripcion", _Descripcion.toString());
        if (_DBJNDI!= null) {
            w.leaf("DB_JNDI", _DBJNDI.toString());
        }
        m.marshal(_Query);
        w.end("Informe");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Informe");
        while (xs.atAttribute()) {
            String an = xs.takeAttributeName();
            throw new InvalidAttributeException(an);
        }
        if (xs.atStart("Nombre")) {
            xs.takeStart("Nombre");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _Nombre = String.valueOf(s);
            } catch (Exception x) {
                throw new ConversionException("Nombre", x);
            }
            xs.takeEnd("Nombre");
        }
        if (xs.atStart("Descripcion")) {
            xs.takeStart("Descripcion");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _Descripcion = String.valueOf(s);
            } catch (Exception x) {
                throw new ConversionException("Descripcion", x);
            }
            xs.takeEnd("Descripcion");
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
        _Query = ((Query) u.unmarshal());
        xs.takeEnd("Informe");
    }

    public static Informe unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static Informe unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static Informe unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((Informe) d.unmarshal(xs, (Informe.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Informe)) {
            return false;
        }
        Informe tob = ((Informe) ob);
        if (_Nombre!= null) {
            if (tob._Nombre == null) {
                return false;
            }
            if (!_Nombre.equals(tob._Nombre)) {
                return false;
            }
        } else {
            if (tob._Nombre!= null) {
                return false;
            }
        }
        if (_Descripcion!= null) {
            if (tob._Descripcion == null) {
                return false;
            }
            if (!_Descripcion.equals(tob._Descripcion)) {
                return false;
            }
        } else {
            if (tob._Descripcion!= null) {
                return false;
            }
        }
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
        if (_Query!= null) {
            if (tob._Query == null) {
                return false;
            }
            if (!_Query.equals(tob._Query)) {
                return false;
            }
        } else {
            if (tob._Query!= null) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_Nombre!= null)?_Nombre.hashCode(): 0));
        h = ((127 *h)+((_Descripcion!= null)?_Descripcion.hashCode(): 0));
        h = ((127 *h)+((_DBJNDI!= null)?_DBJNDI.hashCode(): 0));
        h = ((127 *h)+((_Query!= null)?_Query.hashCode(): 0));
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Informe");
        if (_Nombre!= null) {
            sb.append(" Nombre=");
            sb.append(_Nombre.toString());
        }
        if (_Descripcion!= null) {
            sb.append(" Descripcion=");
            sb.append(_Descripcion.toString());
        }
        if (_DBJNDI!= null) {
            sb.append(" DB_JNDI=");
            sb.append(_DBJNDI.toString());
        }
        if (_Query!= null) {
            sb.append(" Query=");
            sb.append(_Query.toString());
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        return Accion.newDispatcher();
    }

}
