package com.google.demo.hibernate;

import org.hibernate.Session;

import com.google.demo.hibernate.entity.Users;

public class TestLoadUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestLoadUser().loadUserById(1);
	}
	
	private void loadUserById(int i){
		//获得Session实例
		Session session=HibernateSessionFactory.getSession();
		//从数据表users中加载编号Id为i的用户对象
		Users user=(Users)session.load(Users.class, i);
		//在控制台输出用户对象信息
		System.out.println(user.getLoginName()+"住在"+user.getAddress());
		HibernateSessionFactory.closeSession();   //关闭session
	}
}
