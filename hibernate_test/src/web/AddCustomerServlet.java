package web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

public class AddCustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CustomerService customerService = new CustomerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获得参数并封装到Customer对象
		Customer customer = new Customer();
		try {
			BeanUtils.populate(customer, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.调用Service保存客户
		customerService.save(customer);
		//3.重定向到客户列表
		response.sendRedirect(request.getContextPath()+"/listCustemer");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
