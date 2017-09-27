package com.google.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.demo.hibernate.entity.Users;

public class TestDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestDelete().testDelete();
	}
	
	private void testDelete(){
		//获得Session实例
	    Session session=HibernateSessionFactory.getSession();
		Transaction tx=null;
		//加载要删除的数据
		Users user=(Users)session.get(Users.class, 10);
		try {
			tx=session.beginTransaction();    //开始一个事务
			session.delete(user);             //执行删除
			tx.commit();                      //提交事务
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback();       //事务回滚					
			}
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();   //关闭session
		}
	}
}
