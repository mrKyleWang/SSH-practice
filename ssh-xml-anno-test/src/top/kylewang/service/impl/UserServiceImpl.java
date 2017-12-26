package top.kylewang.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kylewang.dao.IUserDAO;
import top.kylewang.domain.User;
import top.kylewang.service.IUserService;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDao;

	@Override
	public void add(User user) {
		userDao.add(user);
	}
	@Override
	public void del(User user) {
		userDao.del(user);
	}
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(int id) {
		return userDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAllByCriteria(DetachedCriteria dc) {
		return userDao.findAllByCriteria(dc);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findByNameQuery() {
		return userDao.findByNameQuery();
	}

}
