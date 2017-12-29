package top.kylewang.dao;

import top.kylewang.entity.Book;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/28 0028 20:25
 */
public interface IBookDao {
    List<Book> findAll() throws Exception;
}
