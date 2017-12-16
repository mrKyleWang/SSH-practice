package com.itheima.demo.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.itheima.demo.VO.ResultVO;
import com.itheima.demo.entity.Product;
import com.itheima.demo.service.IProductService;
import com.itheima.demo.service.impl.ProductServiceImpl;
import org.apache.struts2.convention.annotation.*;

import java.util.List;

@SuppressWarnings("serial")
@Namespace("/")
@ParentPackage("base")
public class ProductAction extends ActionSupport {


	private IProductService productService = new ProductServiceImpl();

	@Action(value = "showProduct", results = {
			@Result(name = "result", type = "json", params = { "root", "vo" }) }, interceptorRefs = {
					@InterceptorRef("myStack") })
	public String showProduct() {
		List<Product> list = productService.getAll();
		ActionContext.getContext().getValueStack().set("vo", ResultVO.ok("查询成功",list));
		return "result";
	}

}
