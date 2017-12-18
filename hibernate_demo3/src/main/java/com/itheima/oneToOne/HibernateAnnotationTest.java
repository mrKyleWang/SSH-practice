package com.itheima.oneToOne;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.itheima.utils.HibernateUtils;

public class HibernateAnnotationTest {
	
	private Session session;
    // 这里面可以做一些初始化的操作，它会在每一个@Test测试之前运行
    @Before
    public void init() {
        session = HibernateUtils.openSession();
		session.beginTransaction();
    }
    
    // 这里面可以做一些资源清理的操作，它会在每一个@Test测试之后运行
    @After
	public void shutDown() {
		session.getTransaction().commit();
		session.close();
	}

	// 测试一对一主键生成策略
	@Test
	public void test7() {
		// 创建丈夫
		Husband husband = new Husband();
		husband.setName("武大郎");

		// 创建妻子
		Wife wife = new Wife();
		wife.setName("潘金莲");

		// 要做双向关联
		husband.setWife(wife);
		wife.setHusband(husband);

		session.save(wife);
	}

	// 测试一对一操作外键映射方案(由idcard维护外键)
	@Test
	public void test6() {
		// 1.创建一个人
		User user = new User();
		user.setName("张龙");
		// 2.创建身份证号
		IDCard idcard = new IDCard();
		idcard.setCardNum("1234567890");
		// 3.身份证号关联人
		user.setIdCard(idcard);
		
		idcard.setUser(user);
		// 4.存储身份证号
		session.save(user);
	}

	
	
}
