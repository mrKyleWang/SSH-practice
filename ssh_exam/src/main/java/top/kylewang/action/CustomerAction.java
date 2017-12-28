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
import top.kylewang.entity.Customer;
import top.kylewang.service.ICustomerService;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:37
 */
@Controller
@Scope("prototype")
@Namespace("/customer")
@ParentPackage("struts-default")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

    @Autowired
    private ICustomerService customerService;

    private Customer customer = new Customer();
    @Override
    public Customer getModel() {
        return customer;
    }
    /**
     * 查询所有客户信息
     */
    @Action(value = "findAllCustomer",results = {@Result(name = "success",location = "/customerList.jsp")})
    public String findAllCustomer(){
        //调用service
        List<Customer> customerList = customerService.findAll();
        ActionContext.getContext().getValueStack().set("customerList",customerList);
        return SUCCESS;
    }

    @Action(value = "delCustomer",results = {@Result(name = "success",location = "findAllCustomer",type = "redirectAction")})
    public String delCustomer(){
        customerService.delCustomer(customer);
        return SUCCESS;
    }

}
