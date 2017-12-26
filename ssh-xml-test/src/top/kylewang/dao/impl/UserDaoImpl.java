package top.kylewang.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.kylewang.dao.IUserDao;
import top.kylewang.domain.User;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/26 0026 11:23
 */
public class UserDaoImpl extends HibernateDaoSupport implements IUserDao{


    @Override
    public void add(User user) {
        this.getHibernateTemplate().save(user);
    }

    @Override
    public void del(User user) {
        this.getHibernateTemplate().delete(user);
    }

    @Override
    public void update(User user) {
        this.getHibernateTemplate().update(user);
    }

    @Override
    public User findById(Integer id) {
        return this.getHibernateTemplate().get(User.class,id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) this.getHibernateTemplate().find("from User");
    }
}
