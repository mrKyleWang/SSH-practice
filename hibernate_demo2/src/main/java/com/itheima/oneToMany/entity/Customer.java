package com.itheima.oneToMany.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kyle.Wang
 * 2017/12/17 0017 10:43
 */
public class Customer {
    private Integer id; // 主键
    private String name; // 姓名

    // 描述客户可以有多个订单
    private Set<Order> orders = new HashSet<Order>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
