package com.google.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.demo.hibernate.entity.Users;

public class TestUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestUpdate().testUpdate();
	}
	
	private void testUpdate(){
		//获得Session实例
	    Session session=HibernateSessionFactory.getSession();
		Transaction tx=null;
		//加载要修改的数据
		Users user=(Users)session.get(Users.class, new Integer(2));
		//修改数据
		user.setLoginName("popopo");
		try {
			tx=session.beginTransaction();    //开始一个事务			
			session.update(user);             //执行更新
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