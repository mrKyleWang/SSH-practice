package com.itheima.demo.service;

import com.itheima.demo.entity.Product;

import java.util.List;

public interface IProductService {

	List<Product> getAll();

    Integer add(Product product);
}
