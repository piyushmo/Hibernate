package com.exmple.criteria.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionUtil {
	
	private static final ThreadLocal<Session> THREAD_LOCAL = new ThreadLocal<Session>();
	
	private static SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory=new Configuration().configure("com\\example\\criteria\\config\\hibernate.cfg.xml").buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private SessionUtil() {
		
	}
	
	public static Session getThreadLocalSession() {
		
		 Session session = (Session)THREAD_LOCAL.get();
		 
		 if(session == null){
			 session = sessionFactory.openSession();
			 THREAD_LOCAL.set(session);
		 }
		return session;
	}
	
	public static void closeTheadLocalSession() {
		
		Session session = (Session)THREAD_LOCAL.get();
		THREAD_LOCAL.set(null);
		
		if(session !=null) {
			session.close();
		}
	}
	
	public static Session getSession() {
		
		return sessionFactory.openSession();
	}
	
	public static void closeSession(Session session) {
		
		if(session !=null) {
			session.close();
		}
	}
}
