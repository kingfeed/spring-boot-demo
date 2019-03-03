package com.k.i.n.g.f.demo.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * redisson
 * @author dongfei
 */
@RestController
@RequestMapping("redisson")
public class DemoRedissonController {
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/lock/{id}")
    public Integer doLock(@PathVariable(name = "id") Integer id){
        redisTemplate.opsForValue().increment("id");
        RLock lock = redissonClient.getLock("pet/" + id);
        try {
            lock.lock(30, TimeUnit.SECONDS);
        }catch (Exception ex){

        }finally {
           //lock.unlock();
        }
        return 0;
    }
}
