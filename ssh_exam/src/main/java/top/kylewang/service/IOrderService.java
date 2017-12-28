package top.kylewang.service;

import top.kylewang.entity.PageBean;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:38
 */
public interface IOrderService {
    PageBean findOrderByCustomer(Integer id, Integer currentPage, Integer customerId);

    void delOrder(String orderNum);
}

