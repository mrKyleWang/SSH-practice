package com.itheima.demo.dao.impl;

import com.itheima.demo.dao.IProductDao;
import com.itheima.demo.entity.Product;
import org.hibernate.Query;

import java.util.List;

import static com.itheima.demo.utils.HibernateUtils.openSession;

public class ProductDaoImpl implements IProductDao {

	@Override
	public List<Product> getAll() throws Exception {
		String hql= "from Product";
        Query query = openSession().createQuery(hql);
        List<Product> list = query.list();
        return list;
    }

}
