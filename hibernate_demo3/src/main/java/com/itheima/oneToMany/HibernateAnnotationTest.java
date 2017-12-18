package com.itheima.oneToMany;

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

	// 测试one-to-many注解操作(保存客户时级联保存订单)
	@Test
	public void test3() {
		Customer c = new Customer();
		c.setName("张龙");
		Order o1 = new Order();
		o1.setMoney(100d);
		o1.setReceiverInfo("北京");
		Order o2 = new Order();
		o2.setMoney(2000d);
		o2.setReceiverInfo("上海");
		// 原因:是为了维护外键
		o1.setC(c);
		o2.setC(c);
		// 原因:是为了进行级联操作
		c.getOrders().add(o1);
		c.getOrders().add(o2);

		session.save(c);
	}
	
	
	@Test
	public void test4() {
		
		Customer customer = session.get(Customer.class, 1);
		Order order = session.get(Order.class, 1);
		
		customer.getOrders().remove(order);
		
		//session.delete(customer);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
