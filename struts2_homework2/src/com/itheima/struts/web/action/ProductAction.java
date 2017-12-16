package com.itheima.struts.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.itheima.struts.VO.ResultVO;
import com.itheima.struts.entity.Product;
import com.itheima.struts.service.IProductService;
import com.itheima.struts.service.impl.ProductServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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
