package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;
import utils.HibernateUtils;

public class UserServiceImpl implements UserService {

	private UserDao dao = new UserDaoImpl();
	
	@Override
	//实现登录业务
	public User login(User user) {
		//打开事务
		HibernateUtils.getCurrentSession().beginTransaction();
		//1.调用dao根据登录名称查询User对象
		User existUser = dao.getByUserCode(user.getUser_code());
		//提交事务
		HibernateUtils.getCurrentSession().getTransaction().commit();
		
		//获取不到->抛出异常提示用户名不存在	
		if(existUser==null) {
			throw new RuntimeException("用户名不存在!");
		}
		
		//2.比对密码是否一致
		//不一致->抛出异常提示密码错误	
		if(!existUser.getUser_password().equals(user.getUser_password())) {
			throw new RuntimeException("密码错误!");
		}
				
		//3.将数据库查询的User返回
		return existUser;
	}

}
