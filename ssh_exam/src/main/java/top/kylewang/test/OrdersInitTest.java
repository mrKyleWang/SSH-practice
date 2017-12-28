package top.kylewang.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import top.kylewang.dao.ICustomerDao;
import top.kylewang.dao.IOrderDao;
import top.kylewang.entity.Customer;
import top.kylewang.entity.Order;

import java.math.BigDecimal;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 18:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class OrdersInitTest {

    @Autowired
    private IOrderDao orderDao;
    @Autowired
    private ICustomerDao customerDao;

    @Test
    @Transactional
    public void test1() throws Exception {

        int flag = 0;
        for (int i = 50; i < 500; i += 10) {
            Order order = new Order();
            order.setPrice(BigDecimal.valueOf(i));
            if (flag % 2 == 0) {
                Customer c = customerDao.findById(1);
                order.setCustomer(c);
                order.setReceiverInfo("武汉");
            } else {
                Customer c = customerDao.findById(2);
                order.setCustomer(c);
                order.setReceiverInfo("上海");
            }
            orderDao.save(order);
            flag++;
        }
        orderDao.commit();
    }

    @Test
    public void mathTest(){
        Double aDouble = new Double(Math.ceil(1.0*43 / 10));
        System.out.println(aDouble);
        Integer totalPage = aDouble.intValue();
        System.out.println(totalPage);
    }
}
