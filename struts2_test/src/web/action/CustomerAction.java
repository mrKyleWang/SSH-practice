package web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private CustomerService service = new CustomerServiceImpl();
	// 封装参数的JavaBean
	private Customer customer = new Customer();

	public String list() throws Exception {
		// 1.创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		// 2.判断参数拼装条件
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		// 3.调用Service将离线对象传递
		List<Customer> list = service.getAll(dc);
//		// 4.将返回的list放入request域，转发到list.jsp显示
//		ServletActionContext.getRequest().setAttribute("list", list);
		
		//4.放到ActionContext
		ActionContext.getContext().put("list",list);
		return "list";
	}

	public String add() throws Exception {
		// 1.调用Service
		service.save(customer);
		// 2.重定向到列表action方法
		return "toList";
	}

	@Override
	public Customer getModel() {
		return customer;
	}
}
