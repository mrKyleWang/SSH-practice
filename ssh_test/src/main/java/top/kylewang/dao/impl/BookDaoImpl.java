package top.kylewang.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import top.kylewang.dao.IBookDao;
import top.kylewang.entity.Book;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/28 0028 20:25
 */
@Repository
public class BookDaoImpl extends HibernateDaoSupport implements IBookDao {

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Book> findAll() throws Exception{
        return (List<Book>) getHibernateTemplate().find("from Book");
    }
}
