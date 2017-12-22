package com.itheima.demo.dao.impl;

import com.itheima.demo.dao.IUserDao;
import com.itheima.demo.entity.User;
import com.itheima.demo.utils.HibernateUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {

	@Override
	public User findUser(String username, String password) throws Exception{
		String hql = "from User where username = ? and password = ?";
		Query query = HibernateUtils.openSession().createQuery(hql);
		query.setParameter(0,username);
		query.setParameter(1,password);
        User existUser = (User) query.uniqueResult();
        return existUser;
	}

}
