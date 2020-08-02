package net.seh.timer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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


public class Tasks
    extends MarshallableRootElement
    implements RootElement
{

    private List _Task = PredicatedLists.createInvalidating(this, new TaskPredicate(), new ArrayList());
    private PredicatedLists.Predicate pred_Task = new TaskPredicate();

    public List getTask() {
        return _Task;
    }

    public void deleteTask() {
        _Task = null;
        invalidate();
    }

    public void emptyTask() {
        _Task = PredicatedLists.createInvalidating(this, pred_Task, new ArrayList());
    }

    public void validateThis()
        throws LocalValidationException
    {
        if (_Task == null) {
            throw new MissingContentException("Task");
        }
    }

    public void validate(Validator v)
        throws StructureValidationException
    {
        for (Iterator i = _Task.iterator(); i.hasNext(); ) {
            v.validate(((ValidatableObject) i.next()));
        }
    }

    public void marshal(Marshaller m)
        throws IOException
    {
        XMLWriter w = m.writer();
        w.start("Tasks");
        for (Iterator i = _Task.iterator(); i.hasNext(); ) {
            m.marshal(((MarshallableObject) i.next()));
        }
        w.end("Tasks");
    }

    public void unmarshal(Unmarshaller u)
        throws UnmarshalException
    {
        XMLScanner xs = u.scanner();
        Validator v = u.validator();
        xs.takeStart("Tasks");
        while (xs.atAttribute()) {
            String an = xs.takeAttributeName();
            throw new InvalidAttributeException(an);
        }
        {
            List l = PredicatedLists.create(this, pred_Task, new ArrayList());
            while (xs.atStart("Task")) {
                l.add(((Task) u.unmarshal()));
            }
            _Task = PredicatedLists.createInvalidating(this, pred_Task, l);
        }
        xs.takeEnd("Tasks");
    }

    public static Tasks unmarshal(InputStream in)
        throws UnmarshalException
    {
        return unmarshal(XMLScanner.open(in));
    }

    public static Tasks unmarshal(XMLScanner xs)
        throws UnmarshalException
    {
        return unmarshal(xs, newDispatcher());
    }

    public static Tasks unmarshal(XMLScanner xs, Dispatcher d)
        throws UnmarshalException
    {
        return ((Tasks) d.unmarshal(xs, (Tasks.class)));
    }

    public boolean equals(Object ob) {
        if (this == ob) {
            return true;
        }
        if (!(ob instanceof Tasks)) {
            return false;
        }
        Tasks tob = ((Tasks) ob);
        if (_Task!= null) {
            if (tob._Task == null) {
                return false;
            }
            if (!_Task.equals(tob._Task)) {
                return false;
            }
        } else {
            if (tob._Task!= null) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = 0;
        h = ((127 *h)+((_Task!= null)?_Task.hashCode(): 0));
        return h;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<<Tasks");
        if (_Task!= null) {
            sb.append(" Task=");
            sb.append(_Task.toString());
        }
        sb.append(">>");
        return sb.toString();
    }

    public static Dispatcher newDispatcher() {
        return Param.newDispatcher();
    }


    private static class TaskPredicate
        implements PredicatedLists.Predicate
    {


        public void check(Object ob) {
            if (!(ob instanceof Task)) {
                throw new InvalidContentObjectException(ob, (Task.class));
            }
        }

    }

}
