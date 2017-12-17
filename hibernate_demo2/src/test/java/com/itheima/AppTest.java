package com.itheima;

import com.itheima.oneToMany.entity.Customer;
import com.itheima.oneToMany.entity.Order;
import com.itheima.oneToMany.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * 测试一对多
     */
    @Test
    public void testOneToMany(){
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        //----------------------------------------

        //创建对象
        Customer customer = new Customer();
        customer.setName("张三");

        Order order1 = new Order();
        order1.setMoney(100d);
        order1.setReceiverInfo("上海");
        Order order2 = new Order();
        order2.setMoney(199d);
        order2.setReceiverInfo("北京");

        //建立关系
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);
        order1.setC(customer);
        order2.setC(customer);

        session.save(customer);
        session.save(order1);
        session.save(order2);

        //----------------------------------------
        session.getTransaction().commit();
        session.close();

    }


}
