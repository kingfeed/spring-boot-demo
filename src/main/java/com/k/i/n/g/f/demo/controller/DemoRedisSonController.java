package com.k.i.n.g.f.demo.controller;

import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("redis-son")
@Slf4j
public class DemoRedisSonController {
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/lock/{id}")
    public Integer doLock(@PathVariable(name = "id") Integer id){
        redisTemplate.opsForValue().increment(String.valueOf(id));
        RLock lock = redissonClient.getLock("pet/" + id);
        try {
            // 尝试获取锁，等待3秒，持有时间30秒
            boolean locked = lock.tryLock(3L,30L,TimeUnit.SECONDS);
            //  lock.lock(30L, TimeUnit.SECONDS); 加锁不设置等待时间，一直等待直到获取或者线程被打断
            if(!locked){
                log.error("locked on {}",id);
            }
            log.info("lock id {}",id);
        }catch (Exception ex){
            log.error("lock exception",ex);
        }finally {
           lock.unlock();
            redisTemplate.opsForValue().increment(String.valueOf(id),-1);
        }
        return 0;
    }
}
