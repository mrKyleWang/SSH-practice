package top.kylewang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kylewang.dao.IBookDao;
import top.kylewang.entity.Book;
import top.kylewang.service.IBookService;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/28 0028 20:22
 */
@Service
@Transactional
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookDao bookDao;


    @Override
    public List<Book> findAll() {
        try {
            return bookDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
