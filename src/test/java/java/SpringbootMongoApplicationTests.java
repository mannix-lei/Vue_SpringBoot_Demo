package java;

import dao.impl.CustomerDaoImpl;
import mongodb.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * Created by Tellyes_worker on 2018/3/29/0029.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongoApplicationTests {
    @Test
    public void add(){
        String _id = UUID.randomUUID().toString();
        String name = "mannix";
        String password = "888888";
        Customer customer = new Customer(_id,name,password);
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        customerDao.add(customer);
    }
}
