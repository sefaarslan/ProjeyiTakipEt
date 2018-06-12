package projetakip.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import projetakip.entity.UserEntity;
import projetakip.model.Durum;
import projetakip.model.Person;
import projetakip.model.Proje;
import projetakip.model.User;


public class DAO {
	
	private static DAO uniqueInstance;
	 
 
	public static DAO getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new DAO();
		}
		return uniqueInstance;
	}
	
	
	SessionFactory sessionFactory;

	public DAO() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public User checkUser(UserEntity userEntity) {
		User user = null;
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userEntity.getUserName()));
		criteria.add(Restrictions.eq("password", userEntity.getPassword()));
		List myList = criteria.list();
		if(myList.size() > 0)
			user = (User)myList.get(0);
		session.close();
		return user;
	}

	public List<User> getUserList() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		List<User> myList = criteria.list();
		session.close();		
		return myList;
	}

	public void addUser(User userAdd) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(userAdd);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	public Person addPerson(Person personAdd) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(personAdd);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return personAdd;
	}

	public List<Durum> getDurumList() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Durum.class);
		List<Durum> myList = criteria.list();
		session.close();		
		return myList;
	}

	public void addProje(Proje projeAdd) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(projeAdd);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	public List<Proje> getProjeList() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Proje.class);
		List<Proje> myList = criteria.list();
		session.close();		
		return myList;
	}
	
	

}

