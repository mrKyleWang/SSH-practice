package top.kylewang.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.kylewang.entity.User;
import top.kylewang.service.IUserService;

/**
 * @author Kyle.Wang
 * 2017/12/28 0028 20:26
 */
@Controller
@Scope("prototype")
@Namespace("/user")
@ParentPackage("struts-default")
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    @Autowired
    private IUserService userService;

    @Action(value = "/login",
            results = {@Result(name = "success", location = "/list.jsp", type = "redirect"),
                    @Result(name = "error", location = "/login.jsp")})
    public String login() {
        User existUser = userService.login(user);
        if(existUser!=null){
        return SUCCESS;
        }else{
            ActionContext.getContext().getValueStack().set("msg","登录失败,用户名或密码错误");
        return ERROR;
        }
    }

    @Override
    public User getModel() {
        return user;
    }
}
