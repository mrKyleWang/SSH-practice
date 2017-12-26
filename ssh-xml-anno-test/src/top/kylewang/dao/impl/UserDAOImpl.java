package top.kylewang.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import org.springframework.stereotype.Repository;
import top.kylewang.dao.IUserDAO;
import top.kylewang.domain.User;
@Repository
public class UserDAOImpl extends HibernateDaoSupport implements IUserDAO {

	@Autowired
	@Qualifier("sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user); // session.save()
	}
	
	@Override
	public void del(User user) {
		this.getHibernateTemplate().delete(user);// session.delete()
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user); // session.update()
	}

	@Override
	public User findById(int id) {
		return this.getHibernateTemplate().get(User.class, id); // session.get()
	}

	@Override
	public List<User> findAll() {
		
		// 原来的hibernate中 session.createQuery(hql).setParameter().list();
		return (List<User>) this.getHibernateTemplate().find("from User");
	}
	
	@Override
	public List<User> findAllByCriteria(DetachedCriteria dc) {

		return (List<User>) this.getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public List<User> findByNameQuery() {

		return (List<User>) this.getHibernateTemplate().findByNamedQuery("findUserBySQL");
	}

	
	
}
