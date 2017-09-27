package com.google.hibernate.hibernate_3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.hibernate.hibernate_3.domain.Department;
import com.google.hibernate.hibernate_3.domain.Employee;

public class EnTest {
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

	// 保存，关联
	//@Ignore
	@Test
	public void testSave() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// 新建对象
		Department department = new Department();
		department.setName("开发部");
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		employee1.setName("张三");
		employee2.setName("李四");
		// 关联起来
		department.getEmployeeSet().add(employee1);
		department.getEmployeeSet().add(employee2);
		employee1.setDepartment(department);
		employee2.setDepartment(department);
		session.save(department);
		session.save(employee1);
		session.save(employee2);
		tx.commit();
		session.close();
	}

	// 获取，关联到对方的信息
	// @Ignore
	@Test
	public void testGet() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// 获取一方
		Department department = (Department) session.get(Department.class, 2);
		/*
		 * Employee employee = (Employee)session.get(Employee.class, 1);
		 * System.out.println(employee);
		 * System.out.println(employee.getDepartment());
		 */
		System.out.println(department);
		// 显示另一方
		System.out.println(department.getEmployeeSet());
		tx.commit();
		session.close();
	}

	// 解除关联关系
	@Ignore
	// @Test
	public void testRemoveRelation() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//从员工方
		Employee employee = (Employee)session.get(Employee.class, 1);
		employee.setDepartment(null);
		//从部门方【<set name="employeeSet" table="Employee" invverse="true">设为false】
		Department department = (Department) session.get(Department.class, 2);
		//解除部门2和有关联的所有员工的关联关系
		department.getEmployeeSet().clear();
		//只解除部门2和员工1的关联关系
		department.getEmployeeSet().remove(session.get(Employee.class, 1));
		tx.commit();
		session.close();
	}

	// 删除对象对关联对象的影响
	@Ignore
	// @Test
	public void testDelete() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//删除员工(多方),对部门没有影响
		Employee employee = (Employee)session.get(Employee.class, 1);
		session.delete(employee);
		//删除部门(一方),会把和该部门关联的员工的外键设为null【<set name="employeeSet" table="Employee" invverse="true">设为false】
		//如果没有关联员工，可以删除
		//如果有关联的员工且inverse=true，因为不能维护关联关系，所以会直接执行删除，会有异常出现
		//如果有关联的员工且inverse=false，由于可以维护关联关系，它就会先把关联的员工的外键设为null，再删除部门
		Department department = (Department) session.get(Department.class, 2);
		session.delete(department);
		tx.commit();
		session.close();
	}
}