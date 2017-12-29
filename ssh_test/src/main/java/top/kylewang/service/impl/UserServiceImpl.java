package top.kylewang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kylewang.dao.IUserDao;
import top.kylewang.entity.User;
import top.kylewang.service.IUserService;

/**
 * @author Kyle.Wang
 * 2017/12/28 0028 20:25
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User login(User user) {
        try {
            return userDao.findUserByUsernameAndPassword(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
