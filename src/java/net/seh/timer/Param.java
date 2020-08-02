package net.seh.timer;

import java.io.IOException;
import java.io.InputStream;
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


public class Param
    extends MarshallableObject
    implements Element
{

    private String _Classname;
    private String _Value;

    public String getClassname() {
        return _Classname;
    }

    public void setClassname(String _Classname) {
        this._Classname = _Classname;
        if (_Classname == null) {
            invalidate();
        }
    }

    public String getValue() {
        return _Value;
    }

    public void setValue(String _Value) {
        this._Value = _Value;
        if (_Value == null) {
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
        w.start("Param");
        if (_Classname!= null) {
            w.attribute("classname", _Classname.toString());
        }
        if (_Value!= null) {
            w.attribute("value", _Value.toString());
        }
        w.end("Param");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Param");
        while (xs.atAttribute()) {
            String an = xs.takeAttributeName();
            if (an.equals("classname")) {
                if (_Classname!= null) {
                    throw new DuplicateAttributeException(an);
                }
                _Classname = xs.takeAttributeValue();
                continue;
            }
            if (an.equals("value")) {
                if (_Value!= null) {
                    throw new DuplicateAttributeException(an);
                }
                _Value = xs.takeAttributeValue();
                continue;
            }
            throw new InvalidAttributeException(an);
        }
        xs.takeEnd("Param");
    }

    public static Param unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static Param unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static Param unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((Param) d.unmarshal(xs, (Param.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Param)) {
            return false;
        }
        Param tob = ((Param) ob);
        if (_Classname!= null) {
            if (tob._Classname == null) {
                return false;
            }
            if (!_Classname.equals(tob._Classname)) {
                return false;
            }
        } else {
            if (tob._Classname!= null) {
                return false;
            }
        }
        if (_Value!= null) {
            if (tob._Value == null) {
                return false;
            }
            if (!_Value.equals(tob._Value)) {
                return false;
            }
        } else {
            if (tob._Value!= null) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_Classname!= null)?_Classname.hashCode(): 0));
        h = ((127 *h)+((_Value!= null)?_Value.hashCode(): 0));
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Param");
        if (_Classname!= null) {
            sb.append(" classname=");
            sb.append(_Classname.toString());
        }
        if (_Value!= null) {
            sb.append(" value=");
            sb.append(_Value.toString());
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        Dispatcher d = new Dispatcher();
        d.register("Param", (Param.class));
        d.register("Task", (Task.class));
        d.register("Tasks", (Tasks.class));
        d.freezeElementNameMap();
        return d;
    }

}
