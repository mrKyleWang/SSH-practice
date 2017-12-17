package service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import dao.CustomerDao;
import dao.LinkManDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.LinkManDaoImpl;
import domain.Customer;
import domain.LinkMan;
import service.LinkManService;
import utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {
	private LinkManDao linkManDao = new LinkManDaoImpl();
	private CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public void save(LinkMan linkMan) {
		//获取session，开启事务
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// 根据用户id获取用户对象
		try {
			Long cust_id = linkMan.getCust_id();
			Customer customer = customerDao.getById(cust_id);
			// 将客户放入linkMan中表达关系
			linkMan.setCustomer(customer);
			// 保存linkMan
			linkManDao.save(linkMan);
			
		} catch (Exception e) {
			e.printStackTrace();
			//回滚
			transaction.rollback();
		}
		//提交事务
		transaction.commit();

	}

	@Override
	public List<LinkMan> getAll() {
		//获取session，开启事务
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		List<LinkMan> list = linkManDao.getAll();
		transaction.commit();
		
		return list;
	}

	@Override
	public List<LinkMan> getAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		List<LinkMan> list = linkManDao.getAll(dc);
		transaction.commit();
		return list;
	}

}
