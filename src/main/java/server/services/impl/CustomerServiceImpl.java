package server.services.impl;

import dao.CustomerDao;
import mongodb.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import server.services.CustomerService;

import java.util.List;

/**
 * Created by Tellyes_worker on 2018/3/29/0029.
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer getCustomer(String _id) {
        return customerDao.getCustomer(_id);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void add(Customer customer) {
        customerDao.add(customer);
    }

    @Override
    public void addAll(List<Customer> customers) {
        customerDao.addAll(customers);
    }

    @Override
    public void remove(String _id) {
        customerDao.remove(_id);
    }

    @Override
    public List<Customer> findByPage(Customer customer, Pageable pageable) {
        return customerDao.findByPage(customer,pageable);
    }
}
