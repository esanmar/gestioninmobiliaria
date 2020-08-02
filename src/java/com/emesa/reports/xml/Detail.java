package com.emesa.reports.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.ConversionException;
import javax.xml.bind.Dispatcher;
import javax.xml.bind.Element;
import javax.xml.bind.InvalidAttributeException;
import javax.xml.bind.InvalidContentObjectException;
import javax.xml.bind.LocalValidationException;
import javax.xml.bind.MarshallableObject;
import javax.xml.bind.Marshaller;
import javax.xml.bind.MissingContentException;
import javax.xml.bind.PredicatedLists;
import javax.xml.bind.StructureValidationException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import javax.xml.marshal.XMLScanner;
import javax.xml.marshal.XMLWriter;


public class Detail
    extends MarshallableObject
    implements Element
{

    private String _SQL;
    private List _DetailParam = PredicatedLists.createInvalidating(this, new DetailParamPredicate(), new ArrayList());
    private PredicatedLists.Predicate pred_DetailParam = new DetailParamPredicate();

    public String getSQL() {
        return _SQL;
    }

    public void setSQL(String _SQL) {
        this._SQL = _SQL;
        if (_SQL == null) {
            invalidate();
        }
    }

    public List getDetailParam() {
        return _DetailParam;
    }

    public void deleteDetailParam() {
        _DetailParam = null;
        invalidate();
    }

    public void emptyDetailParam() {
        _DetailParam = PredicatedLists.createInvalidating(this, pred_DetailParam, new ArrayList());
    }

    public void validateThis()
        throws LocalValidationException
    {
        if (_SQL == null) {
            throw new MissingContentException("SQL");
        }
    }

    public void validate(Validator v)
        throws StructureValidationException
    {
    }

    public void marshal(Marshaller m)
        throws IOException
    {
        XMLWriter w = m.writer();
        w.start("Detail");
        w.leaf("SQL", _SQL.toString());
        for (Iterator i = _DetailParam.iterator(); i.hasNext(); ) {
            w.leaf("Detail_param", ((String) i.next()).toString());
        }
        w.end("Detail");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Detail");
        while (xs.atAttribute()) {
            String an = xs.takeAttributeName();
            throw new InvalidAttributeException(an);
        }
        if (xs.atStart("SQL")) {
            xs.takeStart("SQL");
            String s;
            if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                s = xs.takeChars(XMLScanner.WS_COLLAPSE);
            } else {
                s = "";
            }
            try {
                _SQL = String.valueOf(s);
            } catch (Exception x) {
                throw new ConversionException("SQL", x);
            }
            xs.takeEnd("SQL");
        }
        {
            List l = new ArrayList();
            while (xs.atStart()) {
                if (xs.atStart("Detail_param")) {
                    xs.takeStart("Detail_param");
                    String s;
                    if (xs.atChars(XMLScanner.WS_COLLAPSE)) {
                        s = xs.takeChars(XMLScanner.WS_COLLAPSE);
                    } else {
                        s = "";
                    }
                    String uf;
                    try {
                        uf = String.valueOf(s);
                    } catch (Exception x) {
                        throw new ConversionException("Detail_param", x);
                    }
                    l.add(uf);
                    xs.takeEnd("Detail_param");
                } else {
                    break;
                }
            }
            _DetailParam = PredicatedLists.createInvalidating(this, pred_DetailParam, l);
        }
        xs.takeEnd("Detail");
    }

    public static Detail unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static Detail unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static Detail unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((Detail) d.unmarshal(xs, (Detail.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Detail)) {
            return false;
        }
        Detail tob = ((Detail) ob);
        if (_SQL!= null) {
            if (tob._SQL == null) {
                return false;
            }
            if (!_SQL.equals(tob._SQL)) {
                return false;
            }
        } else {
            if (tob._SQL!= null) {
                return false;
            }
        }
        if (_DetailParam!= null) {
            if (tob._DetailParam == null) {
                return false;
            }
            if (!_DetailParam.equals(tob._DetailParam)) {
                return false;
            }
        } else {
            if (tob._DetailParam!= null) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_SQL!= null)?_SQL.hashCode(): 0));
        h = ((127 *h)+((_DetailParam!= null)?_DetailParam.hashCode(): 0));
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Detail");
        if (_SQL!= null) {
            sb.append(" SQL=");
            sb.append(_SQL.toString());
        }
        if (_DetailParam!= null) {
            sb.append(" Detail_param=");
            sb.append(_DetailParam.toString());
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        return Accion.newDispatcher();
    }


    private static class DetailParamPredicate
        implements PredicatedLists.Predicate
    {


        public void check(Object ob) {
            if (!(ob instanceof String)) {
                throw new InvalidContentObjectException(ob, (String.class));
            }
        }

    }

}
