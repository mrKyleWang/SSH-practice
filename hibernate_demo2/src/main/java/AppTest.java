import com.itheima.oneToMany.entity.Customer;
import com.itheima.oneToMany.entity.Order;
import com.itheima.oneToMany.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static Session session = HibernateUtils.openSession();
    private Customer customer = new Customer();
    private Order order1= new Order();
    private Order order2= new Order();

    @Before
    public void initObject() {
        session.beginTransaction();
        //创建对象
        customer.setName("张三");
        order1.setMoney(100d);
        order1.setReceiverInfo("上海");
        order2.setMoney(199d);
        order2.setReceiverInfo("北京");
    }
    @After
    public void endMethod(){
        session.getTransaction().commit();
        session.close();
    }


    /**
     * 测试一对多
     */
    @Test
    public void testOneToMany1() {
        //建立关系
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);
        order1.setC(customer);
        order2.setC(customer);

        //保存
        session.save(customer);
        session.save(order1);
        session.save(order2);
    }


    /**
     * 级联操作,保存customer自动保存order
     */
    @Test
    public void testOneToMany2() {
        //建立关系
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);
        order1.setC(customer);
        order2.setC(customer);

        //保存
        session.save(customer);
    }

    /**
     * 单向关系维护,由order单方来维护一对多关系
     */
    @Test
    public void testOneToMany3() {
        //建立关系
        order1.setC(customer);
        order2.setC(customer);
        //保存
        session.save(order1);
        session.save(order2);
    }

}
