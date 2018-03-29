package server.services;

import mongodb.Customer;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Tellyes_worker on 2018/3/29/0029.
 */
public interface CustomerService {
    List<Customer> findAll();
    Customer getCustomer(String _id);
    void update(Customer customer);
    void add(Customer customer);
    void addAll(List<Customer> customers);
    void remove(String _id);
    List<Customer> findByPage(Customer customer, Pageable pageable);
}
