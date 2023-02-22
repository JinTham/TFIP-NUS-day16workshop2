package tfip.ssf.day16workshop2.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import tfip.ssf.day16workshop2.Model.Payload;

@Repository
public class PayloadRepo {
    public static final String HASH_KEY_NAME = "Payload-Item";

    @Autowired
    private RedisTemplate redisTemplate;

    public void save(Payload payload) {
        redisTemplate.opsForHash().put(HASH_KEY_NAME,payload.getId(),payload);
    }

    public List<Payload> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY_NAME);
    }

    public Payload findPayloadById(Integer id) {
        return (Payload) redisTemplate.opsForHash().get(HASH_KEY_NAME, id);
    }

    public String deletePayloadById(Integer id) {
        Long lResult = redisTemplate.opsForHash().delete(HASH_KEY_NAME, id);
        if (lResult >= 0) {
            return "Deleted";
        } else {
            return "Failed";
        }
    }
}
