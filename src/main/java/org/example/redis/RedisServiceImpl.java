package org.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value, 100, SECONDS);
    }

    @Override
    public String get(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return  (String)valueOperations.get(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        redisTemplate.expire(key,expire, SECONDS);
        return true;
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long delta) {
        return null;
    }
}
