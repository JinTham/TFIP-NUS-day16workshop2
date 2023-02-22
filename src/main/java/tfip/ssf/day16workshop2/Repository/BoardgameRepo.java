package tfip.ssf.day16workshop2.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import tfip.ssf.day16workshop2.Model.Boardgame;

@Repository
public class BoardgameRepo {

    @Autowired
    private RedisTemplate redisTemplate;

    public void save(Boardgame boardgame) {
        redisTemplate.opsForValue().set(boardgame.getId(), boardgame);
    }

    public Boardgame findBoardgameById(Integer id) {
        return (Boardgame) redisTemplate.opsForValue().get(id);
    }

    public List<Boardgame> findAllBoardgame() {
        return redisTemplate.opsForList().leftPop("boardgame", 0);
    }

    public void update(Boardgame boardgame) {
        redisTemplate.opsForValue().setIfPresent(boardgame.getId(), boardgame);
    } 
}
