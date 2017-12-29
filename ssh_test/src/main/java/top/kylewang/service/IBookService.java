package top.kylewang.service;

import top.kylewang.entity.Book;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/28 0028 20:22
 */
public interface IBookService {
    List<Book> findAll();
}
