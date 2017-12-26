package top.kylewang.dao;

import top.kylewang.domain.User;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/26 0026 11:23
 */
public interface IUserDao {

    void add(User user);

    void del(User user);

    void update(User user);

    User findById(Integer id);

    List<User> findAll();
}
