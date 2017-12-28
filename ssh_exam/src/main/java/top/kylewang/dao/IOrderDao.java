package top.kylewang.dao;

import top.kylewang.entity.Customer;
import top.kylewang.entity.Order;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:38
 */
public interface IOrderDao {
    List<Order> findOrderByCustomer(Customer customer,Integer currentPage,Integer pageSize) throws Exception;
    void save(Order order);
    void commit();
    Integer count(Customer customer);

    Order findById(String orderNum);

    void del(Order existOrder);
}
