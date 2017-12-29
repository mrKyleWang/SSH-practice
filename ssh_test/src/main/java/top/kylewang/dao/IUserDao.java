package top.kylewang.dao;

import top.kylewang.entity.User; /**
 * @author Kyle.Wang
 * 2017/12/28 0028 20:22
 */
public interface IUserDao {
    User findUserByUsernameAndPassword(User user) throws Exception;
}
