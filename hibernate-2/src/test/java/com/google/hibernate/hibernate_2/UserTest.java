package com.google.hibernate.hibernate_2;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.hibernate.hibernate_2.domain.User;

public class UserTest {
	// 会话工厂
		private SessionFactory sessionFactory;

		@Before
		public void createSqlSessionFactory() {
			Configuration cfg = new Configuration();
			// 配置文件
			String resource = "hibernate.cfg.xml";
			cfg.configure(resource);
			// 创建sessionFactory
			this.sessionFactory = cfg.buildSessionFactory();

		}
		
		@Ignore
		//@Test
		public void testSave(){
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			User user = new User();
			user.getAddressSet().add("天通苑三区");
			user.getAddressSet().add("天通苑二区");
			user.getAddressList().add("天通苑西三区27号楼");
			user.getAddressList().add("天通苑西二区22号楼");
			user.getAddressList().add("天通苑北一区17号楼");
			user.getAddressMap().put("家庭","天通苑三区");
			user.getAddressMap().put("公司","天通苑二区");
			user.setName("白百合");
			session.save(user);
			tx.commit();
			session.close();
		}
		
		//@Ignore
		@Test
		public void testGet(){
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			User user = (User) session.get(User.class, 1);
			System.out.println(user.getName());
			System.out.println(user.getAddressSet());
			System.out.println(user.getAddressList());
			System.out.println(user.getAddressMap());
			tx.commit();
			session.close();
		}
}
