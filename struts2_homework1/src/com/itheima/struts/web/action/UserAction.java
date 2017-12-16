package com.itheima.struts.web.action;

import java.util.Map;

import com.itheima.struts.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	
	public String login() {
		if("zs".equals(user.getUsername())&&"123".equals(user.getPassword())) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("user", user);
			return "success";
		}else {
			ActionContext.getContext().getValueStack().set("errorMsg", "用户名或密码错误!");
			return "login";
		}
	}
	
	
	public String showProduct() {
		return "product";
	}

}
