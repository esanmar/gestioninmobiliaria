package net.sf.hibernate.x;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

/**
 * @author sergioarias
 * @since 15-oct-2003
 */
public class HibernateSession {
    
   private static SessionFactory sessionFactory;
   public static final ThreadLocal session = new ThreadLocal();
   
	public static Session currentSession()
		throws HibernateException {

	  Session s = (Session) session.get();
	  if (s == null) {

		// Don't get from JNDI, use a static SessionFactory
		if (sessionFactory == null) {
			// Use default hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}

		 s = sessionFactory.openSession();
		 session.set(s);
	  }
	  return s;
	}

	public static void closeSession()
		throws HibernateException {
       
	   Session s = (Session) session.get();
	   session.set(null);
	   if (s != null) s.close();
	}
}
