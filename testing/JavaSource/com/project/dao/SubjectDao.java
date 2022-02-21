package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Subject;

import com.project.util.Hibernateutil;

public class SubjectDao {
	
	@SuppressWarnings("unchecked")
	public List <Subject > getAllSubject() {

        Transaction transaction = null;
        List < Subject > listStudent = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listStudent = session.createQuery("from Subject").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listStudent;
    }

	public static Subject saveSubject(Subject Subject) {
		Transaction transaction = null;
		Subject createdSubject = null;
		Session session = null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the Subject object
			session.save(Subject);
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
		return createdSubject;
	}
	
}
