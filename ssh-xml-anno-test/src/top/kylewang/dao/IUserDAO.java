package top.kylewang.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import top.kylewang.domain.User;

public interface IUserDAO {

	public void add(User user);
	public void update(User user);
	public void del(User user);
	public User  findById(int id);
	public List<User> findAll();
	
	public List<User> findAllByCriteria(DetachedCriteria dc);
	
	public List<User> findByNameQuery();
}
