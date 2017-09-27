package com.google.hibernate.hibernate_1.dao;

import java.util.List;

import com.google.hibernate.hibernate_1.pojo.QueryResult;
import com.google.hibernate.hibernate_1.pojo.User;

public interface UserDao {
	void insertUser(User user);

	void deleteUser(int id);

	void updateUser(User user);

	User getUserById(int id);

	List<User> findAll();
	//分页，返回总记录数和一页的数据
	QueryResult findAll(int firstResult, int MaxResult);
}
