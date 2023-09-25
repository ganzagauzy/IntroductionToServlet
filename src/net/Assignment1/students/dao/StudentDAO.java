package net.Assignment1.students.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.Assignment1.students.model.Student;
import net.Assignment1.students.util.HibernateUtil;


public class StudentDAO {

    /**
     * Save Student
     * @param Student
     */
    public void saveStudent(Student Student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(Student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update Student
     * @param Student
     */
    public void updateStudent(Student Student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(Student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete Student
     * @param id
     */
    public void deleteStudent(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a Student object
            Student Student = session.get(Student.class, id);
            if (Student != null) {
                session.delete(Student);
                System.out.println("Student is deleted");
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

    /**
     * Get Student By ID
     * @param id
     * @return
     */
    public Student getStudent(int id) {

        Transaction transaction = null;
        Student Student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an Student object
            Student = session.get(Student.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return Student;
    }

    /**
     * Get all Students
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Student > getAllSftudent() {

        Transaction transaction = null;
        List < Student > listOfStudent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an Student object

            listOfStudent = session.createQuery("from Student").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfStudent;
    }

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	        List < Student > listOfStudent = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an Student object

	            listOfStudent = session.createQuery("from Student").getResultList();

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfStudent;
	}

	

	
}