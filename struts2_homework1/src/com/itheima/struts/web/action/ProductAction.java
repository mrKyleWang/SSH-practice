package com.itheima.struts.web.action;

import java.util.ArrayList;
import java.util.List;

import com.itheima.struts.domain.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ognl.Ognl;

@SuppressWarnings("serial")
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	
	private Product product = new Product();

	@Override
	public Product getModel() {
		return product;
	}
	
	public String showProduct() {
		
	List<Product> productList = new ArrayList<Product>();	
		
		Product product1 = new Product("彩电",1799.0,100);
		Product product2 = new Product("冰箱",1099.0,100);
		Product product3 = new Product("空调",2399.0,100);
		Product product4 = new Product("洗衣机",899.0,100);
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		ActionContext.getContext().getValueStack().set("productList",productList);
		return "product";
	}
}
