package com.google.hibernate.hibernate_1.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.hibernate.hibernate_1.dao.impl.UserDaoImpl;
import com.google.hibernate.hibernate_1.pojo.QueryResult;
import com.google.hibernate.hibernate_1.pojo.User;

public class UserDaoImplTest {
	// 会话工厂
	private SessionFactory sessionFactory;

	//读取hibernate配置文件
	@Before
	public void createSqlSessionFactory() {
		Configuration cfg = new Configuration();
		// 配置文件
		String resource = "hibernate.cfg.xml";
		cfg.configure(resource);
		// 创建sessionFactory
		sessionFactory = cfg.buildSessionFactory();

	}
	
	//@Ignore
	//@Test
	public void testInsertUser() {
		User user = new User();
		user.setName("王晓红");
		UserDao userDao = new UserDaoImpl(sessionFactory);
		userDao.insertUser(user);
	}
	
	@Ignore
	//@Test
	public void testDeleteUser() {
		UserDao userDao = new UserDaoImpl(sessionFactory);
		userDao.deleteUser(2);
	}
	
	@Ignore
	//@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId(2);
		user.setName("小小刚");
		UserDao userDao = new UserDaoImpl(sessionFactory);
		userDao.updateUser(user);
	}
	
	@Ignore
	//@Test
	public void testGetUserById() {
		UserDao userDao = new UserDaoImpl(sessionFactory);
		User user = userDao.getUserById(1);
		System.out.println(user);
	}
	
	//@Ignore
	@Test
	public void testFindAll() {
		UserDao userDao = new UserDaoImpl(sessionFactory);
		List<User> findAll = userDao.findAll();
		for (User user : findAll) {
			System.out.println(user);
		}
	}
	
	@Ignore
	//@Test
	public void testFindAllIntInt() {
		UserDao userDao = new UserDaoImpl(sessionFactory);
		QueryResult result = userDao.findAll(0, 5);
		System.out.println(result.getCount());
	}

}
