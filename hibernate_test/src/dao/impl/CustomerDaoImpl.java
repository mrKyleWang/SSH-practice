package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import dao.CustomerDao;
import domain.Customer;
import utils.HibernateUtils;

@SuppressWarnings("unchecked")
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void save(Customer customer) {
		// 获得session
		Session session = HibernateUtils.getCurrentSession();
		// 执行保存
		session.save(customer);
	}

	@Override
	// 查询所有
	public List<Customer> getAll() {
		// 获得session
		Session session = HibernateUtils.getCurrentSession();

		Criteria criteria = session.createCriteria(Customer.class);

		List<Customer> list = criteria.list();
		return list;
	}

	@Override
	public Customer getById(Long cust_id) {
		//获得session 
		Session session = HibernateUtils.getCurrentSession();
		//获取查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		//添加查询条件
		criteria.add(Restrictions.eq("cust_id", cust_id));
		//获取查询结果并返回
		Customer customer = (Customer)criteria.uniqueResult();
		return customer;
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		//获得session
		Session session = HibernateUtils.getCurrentSession();
		//将离线对象关联到session
		Criteria criteria = dc.getExecutableCriteria(session);
		//执行查询并返回
		return criteria.list();
	}

}
