package top.kylewang.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.kylewang.entity.Customer;
import top.kylewang.service.ICustomerService;

import java.io.File;
import java.io.IOException;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 14:38
 */
@Controller
@Scope("prototype")
@Namespace("/customer")
@ParentPackage("struts-default")
@Data
public class CustomerMultiAction extends ActionSupport{

    @Autowired
    private ICustomerService customerService;
    private File cusImg;
    private String cusImgFileName;
    private String cusName;
    private String cusPhone;


    @Action(value = "addCustomer",
            results = {@Result(name = "success",location = "findAllCustomer",type = "redirectAction"),
                        @Result(name = "input",location = "/error.jsp")})
    public String addCustomer(){
        Customer customer = new Customer();
        customer.setCusName(cusName);
        customer.setCusPhone(cusPhone);
        if(cusImg!=null){
            //本地路径
            File cusImgFile = new File(ServletActionContext.getServletContext().getRealPath("/upload"), cusImgFileName);
            try {
                FileUtils.copyFile(cusImg, cusImgFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //服务器路径
            String cusImgSrc = ServletActionContext.getRequest().getContextPath()+"/upload/"+cusImgFileName;
            customer.setCusImgSrc(cusImgSrc);
        }
        customerService.addCustomer(customer);
        return SUCCESS;
    }


}
