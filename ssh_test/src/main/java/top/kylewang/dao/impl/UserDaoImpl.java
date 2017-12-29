package top.kylewang.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import top.kylewang.dao.IUserDao;
import top.kylewang.entity.User;

/**
 * @author Kyle.Wang
 * 2017/12/28 0028 20:22
 */
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public User findUserByUsernameAndPassword(User user) throws Exception{
        String hql = "from User where username = ? and password = ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setParameter(0,user.getUsername());
        query.setParameter(1,user.getPassword());
        User existUser = (User) query.uniqueResult();
        return existUser;
    }
}
