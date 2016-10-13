import com.ws.impl.HelloImpl;
import com.ws.spring.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by laowang on 16-10-12.
 */
public class AspectJTest {
    public static void main(String []args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Hello hello = ctx.getBean("hello",Hello.class);
        hello.foo();
        hello.addUser("wang1","1111");
    }
}
