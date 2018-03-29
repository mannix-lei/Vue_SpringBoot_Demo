package dao.impl;

import dao.CustomerDao;
import mongodb.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by Tellyes_worker on 2018/3/29/0029.
 */
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    /**
     * 由springboot自动注入，默认配置会产生mongotemplate这个bean
     */
    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 查找全部
     * @return
     */
    @Override
    public List<Customer> findAll(){
        return mongoTemplate.findAll(Customer.class);
    }

    /**
     * 根据id获取客户信息
     * @param _id
     * @return
     */
    @Override
    public Customer getCustomer(String _id){
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(_id)),Customer.class);
    }

    /**
     * 更新
     * @param customer
     */
    @Override
    public void update(Customer customer) {
        Criteria criteria = Criteria.where("_id").is(customer.get_id());
        Query query = new Query(criteria);
        Update update = Update.update("name",customer.getName()).set("password",customer.getPassword());
        mongoTemplate.updateMulti(query,update,Customer.class);
    }

    /**
     * 添加用户
     * @param customer
     */
    @Override
    public void add(Customer customer) {
        mongoTemplate.insert(customer);
    }

    /**
     * 添加一组用户
     * @param customers
     */
    @Override
    public void addAll(List<Customer> customers) {
        mongoTemplate.insertAll(customers);
    }

    /**
     * 删除用户
     * @param _id
     */
    @Override
    public void remove(String _id) {
        Criteria criteria = Criteria.where("_id").is(_id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query,Customer.class);
    }

    /**
     * 分页查找
     * customer代表过滤条件
     * pageable代表分页bean
     * @param customer
     * @param pageable
     * @return
     */
    @Override
    public List<Customer> findByPage(Customer customer, Pageable pageable) {
        Query query = new Query();
        if(customer != null && customer.getName() != null){
            query = new Query(Criteria.where("name").regex("^" + customer.getName()));
        }
        List<Customer> list = mongoTemplate.find(query.with(pageable),Customer.class);
        return list;
    }
}
