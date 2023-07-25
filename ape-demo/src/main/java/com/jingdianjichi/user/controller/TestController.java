package com.jingdianjichi.user.controller;


import com.jingdianjichi.redis.util.RedisShareLockUtil;
import com.jingdianjichi.tool.ExportWordUtil;
import com.jingdianjichi.user.entity.po.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
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

    @GetMapping("/testExport")
    public void testExport() throws Exception {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", "经典鸡翅");
        dataMap.put("auditName", "可乐鸡翅");
        ExportWordUtil.exportWord(dataMap, "导出文件", "wordExport.ftl");
    }

    @PostMapping("/testQuery")
    public void testQuery(@RequestBody SysUser sysUser) throws Exception {
        //2022-12-18 21:49:00
        System.out.println(sysUser);
    }


}
