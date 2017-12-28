package top.kylewang.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.kylewang.entity.PageBean;
import top.kylewang.service.IOrderService;

import java.io.IOException;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:37
 */
@Controller
@Scope("prototype")
@Namespace("/order")
@ParentPackage("struts-default")
public class OrderAction extends ActionSupport {

    @Setter
    private String customerId;

    @Setter
    private Integer currentPage;
    @Setter
    private Integer pageSize;
    @Setter
    private String orderNum;

    @Autowired
    private IOrderService orderService;

    /**
     * 查询所有客户信息
     */
    @Action(value = "findOrderByCustomer")
    public void findAllCustomer() {
        //调用service
        Integer customerId = Integer.parseInt(this.customerId);
        PageBean pageBean = orderService.findOrderByCustomer(customerId,currentPage,pageSize);

        PropertyFilter filter = new PropertyFilter() {
            @Override
            public boolean apply(Object o, String s, Object o1) {
                if ("cusPhone".equalsIgnoreCase(s)) {
                    return false;
                }
                if ("cusImgSrc".equalsIgnoreCase(s)) {
                    return false;
                }
                if ("id".equalsIgnoreCase(s)) {
                    return false;
                }
                if ("orders".equalsIgnoreCase(s)) {
                    return false;
                }
                return true;
            }
        };
        String jsonString = JSONObject.toJSONString(pageBean,filter, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(jsonString);
        try {
            ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
            ServletActionContext.getResponse().getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Action(value = "delOrder")
    public void delOrder(){
        orderService.delOrder(orderNum);
    }
}
