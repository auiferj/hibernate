package com.google.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.demo.hibernate.entity.Users;

public class TestAddUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestAddUser().addUser();
	}
	
	private void addUser(){
		//创建实体类（瞬态对象）
		Users user=new Users();
		user.setId(10);
		user.setLoginName("zhangsan");
		user.setLoginPwd("123456");
		user.setName("张三");
		user.setAddress("江苏南京");
		user.setPhone("02512345678");
		user.setMail("123@qq.com");
		//获得Session实例
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=null;
		try {			
            //开始一个事务
			tx=session.beginTransaction();    
			//调用save方法持久化user对象，之后user对象转变为持久态
			session.saveOrUpdate(user);
			//提交事务，向数据库中插入一个新记录
			tx.commit();    
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback();  //事务回滚
			}
  			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();   //关闭session
			//此时，user对象处于托管态
		}
	}
}
