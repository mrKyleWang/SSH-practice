package top.kylewang.dao;

import top.kylewang.entity.Customer;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:38
 */
public interface ICustomerDao {
    List<Customer> findAll() throws Exception;

    void save(Customer customer) throws Exception;

    void del(Customer customer) throws Exception;

    Customer findById(Integer id) throws Exception;
}
