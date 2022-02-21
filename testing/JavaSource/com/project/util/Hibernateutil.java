package com.project.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.project.model.ClassRoom;
import com.project.model.Student;
import com.project.model.Subject;
import com.project.model.Teacher;



public class Hibernateutil {
	private static SessionFactory sessionFactory;

	 public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
	   try {
		   
		   
		   Configuration configuration = new Configuration();
			
			Properties hibernateProperties = new Properties();
			hibernateProperties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			hibernateProperties.put(Environment.URL, "jdbc:mysql://localhost:3306/demo");
			hibernateProperties.put(Environment.USER, "root");
			hibernateProperties.put(Environment.PASS, "");
			hibernateProperties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
			hibernateProperties.put(Environment.SHOW_SQL, "true");
			hibernateProperties.put(Environment.FORMAT_SQL, "true");
			hibernateProperties.put(Environment.HBM2DDL_AUTO, "update");
			configuration.setProperties(hibernateProperties);
			
			configuration.addAnnotatedClass(Student.class);
			configuration.addAnnotatedClass(Teacher.class);
			configuration.addAnnotatedClass(ClassRoom.class);
			configuration.addAnnotatedClass(Subject.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		   
	   // Configuration configuration = new Configuration();

	    // Hibernate settings equivalent to hibernate.cfg.xml's properties
	   /* Properties settings = new Properties();
	    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/demo");
	    settings.put(Environment.USER, "root");
	    settings.put(Environment.PASS, "");
	    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

	    settings.put(Environment.SHOW_SQL, "true");

	    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	    settings.put(Environment.HBM2DDL_AUTO, "update");

	    configuration.setProperties(settings);
	    configuration.addAnnotatedClass(Student.class);
	    configuration.addAnnotatedClass(Teacher.class);
	    
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    
	    System.out.println("Hibernate Java Config serviceRegistry created");
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;*/

	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return sessionFactory;
	 }
	}

