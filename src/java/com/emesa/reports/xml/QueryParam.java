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


public class QueryParam
    extends MarshallableObject
    implements Element
{

    private String _Id;
    private String _ParamDesc;
    private Accion _Accion;
    private String _DBJNDI;

    public String getId() {
        return _Id;
    }

    public void setId(String _Id) {
        this._Id = _Id;
        if (_Id == null) {
            invalidate();
        }
    }

    public String getParamDesc() {
        return _ParamDesc;
    }

    public void setParamDesc(String _ParamDesc) {
        this._ParamDesc = _ParamDesc;
        if (_ParamDesc == null) {
            invalidate();
        }
    }

    public Accion getAccion() {
        return _Accion;
    }

    public void setAccion(Accion _Accion) {
        this._Accion = _Accion;
        if (_Accion == null) {
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

    public void validateThis()
        throws LocalValidationException
    {
        if (_Id == null) {
            throw new MissingContentException("Id");
        }
        if (_ParamDesc == null) {
            throw new MissingContentException("Param_desc");
        }
        if (_Accion == null) {
            throw new MissingContentException("Accion");
        }
    }

    public void validate(Validator v)
        throws StructureValidationException
    {
        v.validate(_Accion);
    }

    public void marshal(Marshaller m)
        throws IOException
    {
        XMLWriter w = m.writer();
        w.start("Query_param");
        w.leaf("Id", _Id.toString());
        w.leaf("Param_desc", _ParamDesc.toString());
        m.marshal(_Accion);
        if (_DBJNDI!= null) {
            w.leaf("DB_JNDI", _DBJNDI.toString());
        }
        w.end("Query_param");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Query_param");
        while (xs.atAttribute()) {
            String an = xs.takeAttributeName();
            throw new InvalidAttributeException(an);
        }
        if (xs.atStart("Id")) {
            xs.takeStart("Id");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _Id = String.valueOf(s);
            } catch (Exception x) {
                throw new ConversionException("Id", x);
            }
            xs.takeEnd("Id");
        }
        if (xs.atStart("Param_desc")) {
            xs.takeStart("Param_desc");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _ParamDesc = String.valueOf(s);
            } catch (Exception x) {
                throw new ConversionException("Param_desc", x);
            }
            xs.takeEnd("Param_desc");
        }
        _Accion = ((Accion) u.unmarshal());
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
        xs.takeEnd("Query_param");
    }

    public static QueryParam unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static QueryParam unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static QueryParam unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((QueryParam) d.unmarshal(xs, (QueryParam.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof QueryParam)) {
            return false;
        }
        QueryParam tob = ((QueryParam) ob);
        if (_Id!= null) {
            if (tob._Id == null) {
                return false;
            }
            if (!_Id.equals(tob._Id)) {
                return false;
            }
        } else {
            if (tob._Id!= null) {
                return false;
            }
        }
        if (_ParamDesc!= null) {
            if (tob._ParamDesc == null) {
                return false;
            }
            if (!_ParamDesc.equals(tob._ParamDesc)) {
                return false;
            }
        } else {
            if (tob._ParamDesc!= null) {
                return false;
            }
        }
        if (_Accion!= null) {
            if (tob._Accion == null) {
                return false;
            }
            if (!_Accion.equals(tob._Accion)) {
                return false;
            }
        } else {
            if (tob._Accion!= null) {
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
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_Id!= null)?_Id.hashCode(): 0));
        h = ((127 *h)+((_ParamDesc!= null)?_ParamDesc.hashCode(): 0));
        h = ((127 *h)+((_Accion!= null)?_Accion.hashCode(): 0));
        h = ((127 *h)+((_DBJNDI!= null)?_DBJNDI.hashCode(): 0));
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Query_param");
        if (_Id!= null) {
            sb.append(" Id=");
            sb.append(_Id.toString());
        }
        if (_ParamDesc!= null) {
            sb.append(" Param_desc=");
            sb.append(_ParamDesc.toString());
        }
        if (_Accion!= null) {
            sb.append(" Accion=");
            sb.append(_Accion.toString());
        }
        if (_DBJNDI!= null) {
            sb.append(" DB_JNDI=");
            sb.append(_DBJNDI.toString());
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        return Accion.newDispatcher();
    }

}
