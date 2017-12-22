package com.itheima.demo.dao.impl;

import com.itheima.demo.dao.IProductDao;
import com.itheima.demo.entity.Product;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.itheima.demo.utils.HibernateUtils.*;
@Repository
public class ProductDaoImpl implements IProductDao {

	@Override
	public List<Product> getAll() throws Exception {
		String hql= "from Product";
        Query query = openSession().createQuery(hql);
        List<Product> list = query.list();
        return list;
    }

    @Override
    public Integer add(Product product) throws Exception {
        beginTransaction();
        Integer saveId = (Integer) currentSession().save(product);
        commit();
        return saveId;
    }

}
