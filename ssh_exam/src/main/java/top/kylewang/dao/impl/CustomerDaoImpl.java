package top.kylewang.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import top.kylewang.dao.ICustomerDao;
import top.kylewang.entity.Customer;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:38
 */
@Repository
public class CustomerDaoImpl extends HibernateDaoSupport implements ICustomerDao{

    @Autowired
    private void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }


    @Override
    public List<Customer> findAll() throws Exception{
        return (List<Customer>) getHibernateTemplate().find("from Customer");
    }

    @Override
    public void save(Customer customer) throws Exception{
        getHibernateTemplate().save(customer);
    }

    @Override
    public void del(Customer customer) throws Exception {
        getHibernateTemplate().delete(customer);
    }

    @Override
    public Customer findById(Integer id) throws Exception {
        return getHibernateTemplate().get(Customer.class,id);
    }
}
