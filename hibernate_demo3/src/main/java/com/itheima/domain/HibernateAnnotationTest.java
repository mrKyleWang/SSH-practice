package com.itheima.domain;

import com.itheima.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

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

 	@Test
 	public void test1() {
 		Book book = new Book();
 		book.setName("深入浅出Hibernate");
 		book.setPrice(56d);
 		book.setPublicationDate(new Date());
 		session.save(book);
 	}
    

	// 测试uuid主键生成策略及不生成表中字段映射
	@Test
	public void test2() {
		Person p = new Person();
		p.setName("李四");
		p.setMsg("这是一个好人");
		session.save(p);
	}

	
	
	
	
	
	
}
