package com.itheima.demo.web.action;

import com.itheima.demo.VO.ResultVO;
import com.itheima.demo.entity.User;
import com.itheima.demo.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@Namespace("/")
@ParentPackage("json-default")
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    private IUserService userservice;

    {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
        userservice = webApplicationContext.getBean(IUserService.class);
    }

    private String PRODUCT = "/spring-hibernate-struts_homework5/product.html";

    @Override
    public User getModel() {
        return user;
    }

    @Action(value = "login", results = {@Result(name = "result", type = "json", params = {"root", "vo"})})
    public String login() {

        User existUser = userservice.findUser(user.getUsername(), user.getPassword());
        if (existUser != null) {
            ActionContext.getContext().getSession().put("user", existUser);
            ActionContext.getContext().getValueStack().set("vo", ResultVO.ok("登录成功", PRODUCT));
            return "result";
        } else {
            ActionContext.getContext().getValueStack().set("vo", ResultVO.error("用户名或密码错误", null));
            return "result";
        }
    }
}
