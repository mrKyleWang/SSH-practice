package com.itheima.demo.web.action;

import com.itheima.demo.VO.ResultVO;
import com.itheima.demo.entity.Product;
import com.itheima.demo.service.IProductService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SuppressWarnings("serial")
@Namespace("/")
@ParentPackage("base")
public class ProductAction extends ActionSupport implements ModelDriven<Product>{

	private Product product = new Product();
	@Autowired
	private IProductService productService;

	@Action(value = "showProduct", results = {
			@Result(name = "result", type = "json", params = { "root", "vo" }) }, interceptorRefs = {
					@InterceptorRef("myStack") })
	public String showProduct() {
		List<Product> list = productService.getAll();
		ActionContext.getContext().getValueStack().set("vo", ResultVO.ok("查询成功",list));
		return "result";
	}

	@Action(value = "addProduct", results = {
			@Result(name = "result", type = "json", params = { "root", "vo" }) }, interceptorRefs = {
			@InterceptorRef("myStack") })
	public String addProduct(){
		System.out.println("进入");
		Integer saveId = productService.add(product);
		System.out.println(product);
		if (saveId !=null){
			ActionContext.getContext().getValueStack().set("vo", ResultVO.ok("添加成功",null));
		}else{
			ActionContext.getContext().getValueStack().set("vo", ResultVO.error("添加失败",null));
		}
		return "result";
	}

	@Override
	public Product getModel() {
		return product;
	}
}
