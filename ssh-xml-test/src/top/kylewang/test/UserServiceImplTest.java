package top.kylewang.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.kylewang.domain.User;
import top.kylewang.service.IUserService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceImplTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testAdd(){
        User user = new User();
        user.setAge(30);
        user.setName("Tom");
        userService.add(user);
    }

    @Test
    public void testUpdate(){
        User user = userService.findById(1);
        user.setName("张三");
        userService.update(user);
    }

    @Test
    public void testDel(){
        User user = userService.findById(1);
        userService.del(user);

    }

    @Test
    public void testFindById(){
        User user = userService.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindAll(){
        List<User> all = userService.findAll();
        System.out.println(all);
    }
	
	

}
