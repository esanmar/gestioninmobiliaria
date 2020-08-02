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
import javax.xml.bind.ValidatableObject;
import javax.xml.bind.Validator;
import javax.xml.marshal.XMLScanner;
import javax.xml.marshal.XMLWriter;


public class Query
    extends MarshallableObject
    implements Element
{

    private String _SQL;
    private List _QueryParam = PredicatedLists.createInvalidating(this, new QueryParamPredicate(), new ArrayList());
    private PredicatedLists.Predicate pred_QueryParam = new QueryParamPredicate();
    private Detail _Detail;

    public String getSQL() {
        return _SQL;
    }

    public void setSQL(String _SQL) {
        this._SQL = _SQL;
        if (_SQL == null) {
            invalidate();
        }
    }

    public List getQueryParam() {
        return _QueryParam;
    }

    public void deleteQueryParam() {
        _QueryParam = null;
        invalidate();
    }

    public void emptyQueryParam() {
        _QueryParam = PredicatedLists.createInvalidating(this, pred_QueryParam, new ArrayList());
    }

    public Detail getDetail() {
        return _Detail;
    }

    public void setDetail(Detail _Detail) {
        this._Detail = _Detail;
        if (_Detail == null) {
            invalidate();
        }
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
        for (Iterator i = _QueryParam.iterator(); i.hasNext(); ) {
            v.validate(((ValidatableObject) i.next()));
        }
        v.validate(_Detail);
    }

    public void marshal(Marshaller m)
        throws IOException
    {
        XMLWriter w = m.writer();
        w.start("Query");
        w.leaf("SQL", _SQL.toString());
        if (_QueryParam.size()> 0) {
            for (Iterator i = _QueryParam.iterator(); i.hasNext(); ) {
                m.marshal(((MarshallableObject) i.next()));
            }
        }
        if (_Detail!= null) {
            m.marshal(_Detail);
        }
        w.end("Query");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Query");
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
            List l = PredicatedLists.create(this, pred_QueryParam, new ArrayList());
            while (xs.atStart("Query_param")) {
                l.add(((QueryParam) u.unmarshal()));
            }
            _QueryParam = PredicatedLists.createInvalidating(this, pred_QueryParam, l);
        }
        if (xs.atStart("Detail")) {
            _Detail = ((Detail) u.unmarshal());
        }
        xs.takeEnd("Query");
    }

    public static Query unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static Query unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static Query unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((Query) d.unmarshal(xs, (Query.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Query)) {
            return false;
        }
        Query tob = ((Query) ob);
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
        if (_QueryParam!= null) {
            if (tob._QueryParam == null) {
                return false;
            }
            if (!_QueryParam.equals(tob._QueryParam)) {
                return false;
            }
        } else {
            if (tob._QueryParam!= null) {
                return false;
            }
        }
        if (_Detail!= null) {
            if (tob._Detail == null) {
                return false;
            }
            if (!_Detail.equals(tob._Detail)) {
                return false;
            }
        } else {
            if (tob._Detail!= null) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_SQL!= null)?_SQL.hashCode(): 0));
        h = ((127 *h)+((_QueryParam!= null)?_QueryParam.hashCode(): 0));
        h = ((127 *h)+((_Detail!= null)?_Detail.hashCode(): 0));
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Query");
        if (_SQL!= null) {
            sb.append(" SQL=");
            sb.append(_SQL.toString());
        }
        if (_QueryParam!= null) {
            sb.append(" Query_param=");
            sb.append(_QueryParam.toString());
        }
        if (_Detail!= null) {
            sb.append(" Detail=");
            sb.append(_Detail.toString());
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        return Accion.newDispatcher();
    }


    private static class QueryParamPredicate
        implements PredicatedLists.Predicate
    {


        public void check(Object ob) {
            if (!(ob instanceof QueryParam)) {
                throw new InvalidContentObjectException(ob, (QueryParam.class));
            }
        }

    }

}
