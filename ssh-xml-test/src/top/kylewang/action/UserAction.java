package top.kylewang.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import top.kylewang.domain.User;
import top.kylewang.service.IUserService;

/**
 * @author Kyle.Wang
 * 2017/12/26 0026 11:23
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{

    private User user= new User();

    @Override
    public User getModel() {
        return user;
    }

    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String add(){
        userService.add(user);
        return "success";
    }
}
