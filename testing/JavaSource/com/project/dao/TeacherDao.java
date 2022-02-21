package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Teacher;
import com.project.util.Hibernateutil;

public class TeacherDao {
	
	@SuppressWarnings("unchecked")
	public List < Teacher > getAllTeacher() {

        Transaction transaction = null;
        List < Teacher > listTeacher = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listTeacher = session.createQuery("from Teacher").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listTeacher;
    }
	
	public static Teacher saveTeacher(Teacher Teacher) {
		Transaction transaction = null;
		Teacher createdTeacher = null;
		Session session = null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the Teacher object
			session.save(Teacher);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return createdTeacher;
	}

}
