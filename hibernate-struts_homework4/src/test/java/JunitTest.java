import com.itheima.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


/**
 * @author Kyle.Wang
 * 2017/12/15 0015 20:43
 */
public class JunitTest {


    @Test
    public void test01(){
        Configuration configure = new Configuration().configure();
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUsername("mike");
        user.setPassword("123");
        session.save(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
