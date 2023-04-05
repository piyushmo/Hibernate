package com.example.one.to.one.bi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.one.to.one.bi.bean.Instructor;
import  com.example.one.to.one.bi.util.SessionUtil;

public class InstructorDao {
	public void saveInstructor(Instructor instructor) {
		Transaction transaction = null;
		try  {
			Session session = SessionUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(instructor);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateInstructor(Instructor instructor) {
		Transaction transaction = null;
		try {
			Session session = SessionUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(instructor);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteInstructor(int id) {

		Transaction transaction = null;
		try {
			Session session = SessionUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a instructor object
			Instructor instructor = session.get(Instructor.class, id);
			if (instructor != null) {
				session.delete(instructor);
				System.out.println("instructor is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Instructor getInstructor(int id) {

		Transaction transaction = null;
		Instructor instructor = null;
		try {
			Session session = SessionUtil.getSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an instructor object
			instructor = session.get(Instructor.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return instructor;
	}
}