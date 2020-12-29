import com.zzcedu.blog.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
    @Test
    public  void test1(){
        ApplicationContext as = new ClassPathXmlApplicationContext("spring.xml");
        UserDao userdao = as.getBean("userDao", UserDao.class);
        System.out.println(userdao.findAll());

    }
}
