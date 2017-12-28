package top.kylewang.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import top.kylewang.dao.IOrderDao;
import top.kylewang.entity.Customer;
import top.kylewang.entity.Order;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:39
 */
@Repository
public class OrderDaoImpl extends HibernateDaoSupport implements IOrderDao {

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public Integer count(Customer customer) {
        String hql = "select count(*) from Order o where o.customer=?";
        Long count = (Long) getHibernateTemplate().find(hql, customer).listIterator().next();
        return count.intValue();
    }

    @Override
    public List<Order> findOrderByCustomer(Customer customer, Integer currentPage, Integer pageSize) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
        dc.add(Restrictions.eq("customer", customer));
        return (List<Order>) getHibernateTemplate().findByCriteria(dc, (currentPage - 1) * pageSize, pageSize);
    }

    @Override
    public void save(Order order) {
        getHibernateTemplate().save(order);
    }

    @Override
    public void commit() {
        getSessionFactory().getCurrentSession().getTransaction().commit();
    }

}
