package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Customer;

public interface CustomerDao {

	//保存客户
	void save(Customer customer);

	//查询所有客户
	List<Customer> getAll();

	Customer getById(Long cust_id);

	//根据条件查询所有客户(离线查询)
	List<Customer> getAll(DetachedCriteria dc);


}
