package top.kylewang.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.kylewang.domain.User;
import top.kylewang.service.IUserService;

@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage("struts-default")
public class UserAction extends ActionSupport implements ModelDriven<User> {

	@Autowired
	private IUserService userService;

	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	@Action(value = "user_add",results = {@Result(name = "success",location = "/success.jsp")})
	public String add() {
		userService.add(user);
		return SUCCESS;
	}

}
