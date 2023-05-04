package com.jingdianjichi.user.controller;


import com.jingdianjichi.redis.util.RedisShareLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisShareLockUtil redisShareLockUtil;
    @GetMapping("/test")
    public String test(){
        return "Hello day1";
    }

    @GetMapping("/testRedis")
    public void testRedis(){
        redisTemplate.opsForValue().set("name","鸡翅");
    }

    @GetMapping("/testLockRedis")
    public void testLockRedis(){
        boolean b = redisShareLockUtil.lock("jichi","121212",20000L);
        System.out.println(b);
        log.info("dadsa");
    }
}
