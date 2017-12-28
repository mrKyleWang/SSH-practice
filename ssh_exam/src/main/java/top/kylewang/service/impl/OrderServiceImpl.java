package top.kylewang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kylewang.dao.ICustomerDao;
import top.kylewang.dao.IOrderDao;
import top.kylewang.entity.Customer;
import top.kylewang.entity.PageBean;
import top.kylewang.service.IOrderService;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:39
 */
@Service
@Transactional
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private ICustomerDao customerDao;

    @Override
    public PageBean findOrderByCustomer(Integer customerId, Integer currentPage, Integer pageSize) {
        try {
            Customer customer = customerDao.findById(customerId);
            if(customer!=null){
                PageBean pageBean = new PageBean();
                Integer count = orderDao.count(customer);
                Integer totalPage = new Double(Math.ceil(count/pageSize)).intValue();
                pageBean.setTotalPage(totalPage);
                pageBean.setList(orderDao.findOrderByCustomer(customer,currentPage,pageSize));
                return pageBean;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
