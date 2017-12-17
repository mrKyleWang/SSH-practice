package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Customer;

public interface CustomerService {

	//保存客户
	void save(Customer customer);

	List<Customer> getAll();
	
	//根据条件查询所有客户(离线查询)
	List<Customer> getAll(DetachedCriteria dc);

}
