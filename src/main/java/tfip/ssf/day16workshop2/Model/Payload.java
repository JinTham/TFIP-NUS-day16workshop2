package tfip.ssf.day16workshop2.Model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("payload")
public class Payload implements Serializable {
    @Id
    private Integer id;

    private String itemName;

    //Constructors
    public Payload(Integer id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }
    //Getters & Setters
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
