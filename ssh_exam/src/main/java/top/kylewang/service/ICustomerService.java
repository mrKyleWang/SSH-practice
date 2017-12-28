package top.kylewang.service;

import top.kylewang.entity.Customer;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:38
 */
public interface ICustomerService {


    List<Customer> findAll();

    void addCustomer(Customer customer);

    void delCustomer(Customer customer);
}
