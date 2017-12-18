package com.itheima.manyToMany;

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

	// 测试多对多级联删除(前提是建立了双向的级联 All)
	@Test
	public void test5() {
		Student s = session.get(Student.class, 1);
		session.delete(s);
	}

	// 测试多对多级联保存(保存学生时保存老师)
	@Test
	public void test4() {
		// 1.创建两个老师
		Teacher t1 = new Teacher();
		t1.setName("tom");
		Teacher t2 = new Teacher();
		t2.setName("fox");
		// 2.创建两个学生
		Student s1 = new Student();
		s1.setName("张三");
		Student s2 = new Student();
		s2.setName("张龙");

		// 3.学生关联老师
		s1.getTeachers().add(t1);
		s1.getTeachers().add(t2);

		s2.getTeachers().add(t1);
		s2.getTeachers().add(t2);

		// 4.保存学生
		session.save(s1);
		session.save(s2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	

}
