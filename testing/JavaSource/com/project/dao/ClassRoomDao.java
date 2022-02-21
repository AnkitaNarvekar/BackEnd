package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.ClassRoom;
import com.project.util.Hibernateutil;

public class ClassRoomDao {
	
	@SuppressWarnings("unchecked")
	public List < ClassRoom > getAllClassRoom() {

        Transaction transaction = null;
        List < ClassRoom > listClassRoom = null;
        try (Session session = Hibernateutil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listClassRoom = session.createQuery("from ClassRoom").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listClassRoom;
    }
	
	public static ClassRoom saveClassRoom(ClassRoom ClassRoom) {
		Transaction transaction = null;
		ClassRoom createdClassRoom = null;
		Session session = null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the ClassRoom object
			session.save(ClassRoom);
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
		return createdClassRoom;
	}
}
