package com.itheima.struts.domain;

public class Product {
	
	private String name;
	private Double price;
	private Integer count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Product(String name, Double price, Integer count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", count=" + count + "]";
	}
	
	
}
