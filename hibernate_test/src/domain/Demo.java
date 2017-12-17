package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import utils.HibernateUtils;

public class Demo {

	@Test
	public void test() {
		// 获得session
		Session session = HibernateUtils.openSession();
		// 获取并开启事务
		Transaction tx = session.beginTransaction();
		// ----------------------------------------
		
		User u1 = new User();
		u1.setUser_name("郝强勇");
		
		User u2  = new User();
		u2.setUser_name("金家德");
		
		Role r1 = new Role();
		r1.setRole_name("保洁");
		
		Role r2 = new Role();
		r2.setRole_name("保安");

		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		
		u2.getRoles().add(r1);
		u2.getRoles().add(r2);
		
//		r1.getUsers().add(u1);
//		r1.getUsers().add(u2);
//		
//		r2.getUsers().add(u1);
//		r2.getUsers().add(u2);
		
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		
		// ----------------------------------------

		// 提交事务
		tx.commit();
		session.close();
	}
}
