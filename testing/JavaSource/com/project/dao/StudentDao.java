package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Student;
import com.project.util.Hibernateutil;

public class StudentDao {
	
	@SuppressWarnings("unchecked")
	public List < Student > getAllStudent() {

        Transaction transaction = null;
        List < Student > listStudent = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listStudent = session.createQuery("from Student").getResultList();

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
	
	public static Student saveStudent(Student student) {
		Transaction transaction = null;
		Student createdStudent = null;
		Session session = null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(student);
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
		return createdStudent;
	}

}
