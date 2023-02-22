package tfip.ssf.day16workshop2.Model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("boardgame")
public class Boardgame {
    
    private Integer id;

    private Integer count;

    //Constructors
    public Boardgame(Integer id, Integer count) {
        this.id = id;
        this.count = count;
    }

    //Getters & Setters
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
