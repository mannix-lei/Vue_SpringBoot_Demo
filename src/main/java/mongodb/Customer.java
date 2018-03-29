package mongodb;

import java.io.Serializable;

/**
 * Created by Tellyes_worker on 2018/3/29/0029.
 */
public class Customer implements Serializable{

    public Customer(String _id,String name,String password){
        this._id = _id;
        this.name = name;
        this.password = password;
    }

    private String _id;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String name;
    private String password;
    private String type;
}
