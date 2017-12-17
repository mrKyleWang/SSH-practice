package web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	private UserService service = new UserServiceImpl();
	
	public String login() throws Exception {
		//1.调用service 执行登录操作
		User u = service.login(user);
		//2.将返回的User对象放入session域作为登录标识
		ActionContext.getContext().getSession().put("user",u);
		//3.重定向到项目的首页
		return "toHome";
	}


	@Override
	public User getModel() {
		return user;
	}
}
