package net.seh.timer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.ConversionException;
import javax.xml.bind.Dispatcher;
import javax.xml.bind.DuplicateAttributeException;
import javax.xml.bind.Element;
import javax.xml.bind.InvalidAttributeException;
import javax.xml.bind.InvalidContentObjectException;
import javax.xml.bind.LocalValidationException;
import javax.xml.bind.MarshallableObject;
import javax.xml.bind.Marshaller;
import javax.xml.bind.MissingAttributeException;
import javax.xml.bind.MissingContentException;
import javax.xml.bind.PredicatedLists;
import javax.xml.bind.StructureValidationException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidatableObject;
import javax.xml.bind.Validator;
import javax.xml.marshal.XMLScanner;
import javax.xml.marshal.XMLWriter;


public class Task
    extends MarshallableObject
    implements Element
{

    private String _Start;
    private String _Period;
    private String _Desc;
    private String _TaskClass;
    private String _TaskMethod;
    private List _Param = PredicatedLists.createInvalidating(this, new ParamPredicate(), new ArrayList());
    private PredicatedLists.Predicate pred_Param = new ParamPredicate();

    public String getStart() {
        return _Start;
    }

    public void setStart(String _Start) {
        this._Start = _Start;
        if (_Start == null) {
            invalidate();
        }
    }

    public String getPeriod() {
        return _Period;
    }

    public void setPeriod(String _Period) {
        this._Period = _Period;
        if (_Period == null) {
            invalidate();
        }
    }

    public String getDesc() {
        return _Desc;
    }

    public void setDesc(String _Desc) {
        this._Desc = _Desc;
        if (_Desc == null) {
            invalidate();
        }
    }

    public String getTaskClass() {
        return _TaskClass;
    }

    public void setTaskClass(String _TaskClass) {
        this._TaskClass = _TaskClass;
        if (_TaskClass == null) {
            invalidate();
        }
    }

    public String getTaskMethod() {
        return _TaskMethod;
    }

    public void setTaskMethod(String _TaskMethod) {
        this._TaskMethod = _TaskMethod;
        if (_TaskMethod == null) {
            invalidate();
        }
    }

    public List getParam() {
        return _Param;
    }

    public void deleteParam() {
        _Param = null;
        invalidate();
    }

    public void emptyParam() {
        _Param = PredicatedLists.createInvalidating(this, pred_Param, new ArrayList());
    }

    public void validateThis()
        throws LocalValidationException
    {
        if (_Start == null) {
            throw new MissingAttributeException("start");
        }
        if (_TaskClass == null) {
            throw new MissingContentException("TaskClass");
        }
        if (_TaskMethod == null) {
            throw new MissingContentException("TaskMethod");
        }
    }

    public void validate(Validator v)
        throws StructureValidationException
    {
        for (Iterator i = _Param.iterator(); i.hasNext(); ) {
            v.validate(((ValidatableObject) i.next()));
        }
    }

    public void marshal(Marshaller m)
        throws IOException
    {
        XMLWriter w = m.writer();
        w.start("Task");
        w.attribute("start", _Start.toString());
        if (_Period!= null) {
            w.attribute("period", _Period.toString());
        }
        if (_Desc!= null) {
            w.leaf("Desc", _Desc.toString());
        }
        w.leaf("TaskClass", _TaskClass.toString());
        w.leaf("TaskMethod", _TaskMethod.toString());
        if (_Param.size()> 0) {
            for (Iterator i = _Param.iterator(); i.hasNext(); ) {
                m.marshal(((MarshallableObject) i.next()));
            }
        }
        w.end("Task");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Task");
        while (xs.atAttribute()) {
            String an = xs.takeAttributeName();
            if (an.equals("start")) {
                if (_Start!= null) {
                    throw new DuplicateAttributeException(an);
                }
                _Start = xs.takeAttributeValue();
                continue;
            }
            if (an.equals("period")) {
                if (_Period!= null) {
                    throw new DuplicateAttributeException(an);
                }
                _Period = xs.takeAttributeValue();
                continue;
            }
            throw new InvalidAttributeException(an);
        }
        if (xs.atStart("Desc")) {
            xs.takeStart("Desc");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _Desc = String.valueOf(s);
            } catch (Exception x) {
                throw new ConversionException("Desc", x);
            }
            xs.takeEnd("Desc");
        }
        if (xs.atStart("TaskClass")) {
            xs.takeStart("TaskClass");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _TaskClass = String.valueOf(s);
            } catch (Exception x) {
                throw new ConversionException("TaskClass", x);
            }
            xs.takeEnd("TaskClass");
        }
        if (xs.atStart("TaskMethod")) {
            xs.takeStart("TaskMethod");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _TaskMethod = String.valueOf(s);
            } catch (Exception x) {
                throw new ConversionException("TaskMethod", x);
            }
            xs.takeEnd("TaskMethod");
        }
        {
            List l = PredicatedLists.create(this, pred_Param, new ArrayList());
            while (xs.atStart("Param")) {
                l.add(((Param) u.unmarshal()));
            }
            _Param = PredicatedLists.createInvalidating(this, pred_Param, l);
        }
        xs.takeEnd("Task");
    }

    public static Task unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static Task unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static Task unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((Task) d.unmarshal(xs, (Task.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Task)) {
            return false;
        }
        Task tob = ((Task) ob);
        if (_Start!= null) {
            if (tob._Start == null) {
                return false;
            }
            if (!_Start.equals(tob._Start)) {
                return false;
            }
        } else {
            if (tob._Start!= null) {
                return false;
            }
        }
        if (_Period!= null) {
            if (tob._Period == null) {
                return false;
            }
            if (!_Period.equals(tob._Period)) {
                return false;
            }
        } else {
            if (tob._Period!= null) {
                return false;
            }
        }
        if (_Desc!= null) {
            if (tob._Desc == null) {
                return false;
            }
            if (!_Desc.equals(tob._Desc)) {
                return false;
            }
        } else {
            if (tob._Desc!= null) {
                return false;
            }
        }
        if (_TaskClass!= null) {
            if (tob._TaskClass == null) {
                return false;
            }
            if (!_TaskClass.equals(tob._TaskClass)) {
                return false;
            }
        } else {
            if (tob._TaskClass!= null) {
                return false;
            }
        }
        if (_TaskMethod!= null) {
            if (tob._TaskMethod == null) {
                return false;
            }
            if (!_TaskMethod.equals(tob._TaskMethod)) {
                return false;
            }
        } else {
            if (tob._TaskMethod!= null) {
                return false;
            }
        }
        if (_Param!= null) {
            if (tob._Param == null) {
                return false;
            }
            if (!_Param.equals(tob._Param)) {
                return false;
            }
        } else {
            if (tob._Param!= null) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_Start!= null)?_Start.hashCode(): 0));
        h = ((127 *h)+((_Period!= null)?_Period.hashCode(): 0));
        h = ((127 *h)+((_Desc!= null)?_Desc.hashCode(): 0));
        h = ((127 *h)+((_TaskClass!= null)?_TaskClass.hashCode(): 0));
        h = ((127 *h)+((_TaskMethod!= null)?_TaskMethod.hashCode(): 0));
        h = ((127 *h)+((_Param!= null)?_Param.hashCode(): 0));
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Task");
        if (_Start!= null) {
            sb.append(" start=");
            sb.append(_Start.toString());
        }
        if (_Period!= null) {
            sb.append(" period=");
            sb.append(_Period.toString());
        }
        if (_Desc!= null) {
            sb.append(" Desc=");
            sb.append(_Desc.toString());
        }
        if (_TaskClass!= null) {
            sb.append(" TaskClass=");
            sb.append(_TaskClass.toString());
        }
        if (_TaskMethod!= null) {
            sb.append(" TaskMethod=");
            sb.append(_TaskMethod.toString());
        }
        if (_Param!= null) {
            sb.append(" Param=");
            sb.append(_Param.toString());
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        return Param.newDispatcher();
    }


    private static class ParamPredicate
        implements PredicatedLists.Predicate
    {


        public void check(Object ob) {
            if (!(ob instanceof Param)) {
                throw new InvalidContentObjectException(ob, (Param.class));
            }
        }

    }

}
