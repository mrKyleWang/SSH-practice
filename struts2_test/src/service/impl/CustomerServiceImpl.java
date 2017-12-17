package service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import service.CustomerService;
import utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public void save(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		// 打开事务
		Transaction transaction = session.beginTransaction();
		// 调用dao保存客户
		customerDao.save(customer);
		// 提交事务
		transaction.commit();
	}

	@Override
	// 查询所有客户
	public List<Customer> getAll() {
		Session session = HibernateUtils.getCurrentSession();
		// 打开事务
		Transaction transaction = session.beginTransaction();
		List<Customer> list = customerDao.getAll();
		// 提交事务
		transaction.commit();
		return list;
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		// 打开事务
		Transaction transaction = session.beginTransaction();
		List<Customer> list = customerDao.getAll(dc);
		// 提交事务
		transaction.commit();
		return list;
	}

}
