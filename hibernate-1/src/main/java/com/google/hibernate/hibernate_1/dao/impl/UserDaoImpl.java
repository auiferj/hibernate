package com.google.hibernate.hibernate_1.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.google.hibernate.hibernate_1.dao.UserDao;
import com.google.hibernate.hibernate_1.pojo.QueryResult;
import com.google.hibernate.hibernate_1.pojo.User;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory = null;

	/**
	 * 通过构造方法的参数注入sessionFactory； 也可以使用无参构造方法，在方法体中使用单例来获取sessionFactory，新奥；
	 * 也可以没有构造方法，定义一个工具类得到sessionFactory和session，在insertUser中直接使用工具类获取session
	 * 
	 * @param sessionFactory
	 */
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 模板代码
	@Override
	public void insertUser(User user) {
		// Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		// session.beginTransaction();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			// session.getTransaction().commit();
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public void deleteUser(int id) {
		// Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		// session.beginTransaction();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(session.get(User.class, id));// 删除是是对象
			// session.getTransaction().commit();
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public void updateUser(User user) {
		// Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		// session.beginTransaction();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
			// session.getTransaction().commit();
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public User getUserById(int id) {
		// Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		// session.beginTransaction();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User user = (User) session.get(User.class, 1);
			// session.getTransaction().commit();
			tx.commit();
			return user;
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public List<User> findAll() {
		// Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		// session.beginTransaction();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			/**
			 * 有三种方式
			 */
			// List<User> list = session.createQuery("From User").list();//Hql:关键字不区分大小写，类名属性名区分大小写
			//List<User> list = session.createSQLQuery("select * from t_user").addEntity(User.class).list();
			Criteria criteria = session.createCriteria(User.class);
			criteria.addOrder(Order.desc("id"));
			List<User> list = criteria.list();
			// session.getTransaction().commit();
			tx.commit();
			return list;
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public QueryResult findAll(int firstResult, int MaxResult) {
		// Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		// session.beginTransaction();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<User> list = session.createQuery("From User")
					.setFirstResult(firstResult)
					.setMaxResults(MaxResult)
					.list();// Hql:关键字不区分大小写，类名属性名区分大小写
			// Long count = (Long)session.createQuery("SELECT COUNT(*) From
			// User").list().get(0);
			Long count = (Long) session.createQuery("SELECT COUNT(*) From User").uniqueResult();
			// session.getTransaction().commit();
			tx.commit();
			return new QueryResult(count.intValue(), list);
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}
