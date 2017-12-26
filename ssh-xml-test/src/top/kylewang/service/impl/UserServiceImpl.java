package top.kylewang.service.impl;

import top.kylewang.dao.IUserDao;
import top.kylewang.domain.User;
import top.kylewang.service.IUserService;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/26 0026 11:22
 */
public class UserServiceImpl implements IUserService{

    private IUserDao userDao;
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

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
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
