package top.kylewang.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import top.kylewang.domain.User;

public interface IUserService {

	public void add(User user);
	public void update(User user);
	public void del(User user);
	public User  findById(int id);
	public List<User> findAll();
	public List<User> findAllByCriteria(DetachedCriteria dc);
	public List<User> findByNameQuery();
}
