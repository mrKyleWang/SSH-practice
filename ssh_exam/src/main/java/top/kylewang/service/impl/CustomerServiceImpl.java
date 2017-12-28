package top.kylewang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kylewang.dao.ICustomerDao;
import top.kylewang.entity.Customer;
import top.kylewang.service.ICustomerService;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:39
 */
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        try {
            return customerDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        try {
            customerDao.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delCustomer(Customer customer) {
        try {
            Customer existCustomer = customerDao.findById(customer.getId());
            if (existCustomer != null) {
                customerDao.del(existCustomer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
