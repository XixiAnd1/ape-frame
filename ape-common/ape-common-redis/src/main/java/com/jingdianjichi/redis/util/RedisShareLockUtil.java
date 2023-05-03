package com.jingdianjichi.redis.util;


import com.jingdianjichi.redis.exception.ShareLockException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisShareLockUtil {


   /**
    * @Description:
    * @param z 
 * @return: java.lang.Integer
    * @Author: hibiki
    * @Date: 2023/5/3 21:49
    */
    public Integer dsada(String z){
        int i =1;
        return i;
    }
    @Resource
    private RedisUtil redisUtil;

    private static final long OUT_TIME = 10000L;

    /**
     * redis分布式加锁
     * @param key
     * @param requestId
     * @param time
     * @return
     */
    public boolean lock(String key, String requestId, Long time) {
        long currentTime = System.currentTimeMillis();
        long outTIme = currentTime+OUT_TIME;
        boolean result = false;
        //入参校验
        if (StringUtils.isBlank(key) || StringUtils.isBlank(requestId) || time < 0) {
            throw new ShareLockException("redis分布式加锁-加锁入参异常");
        }
        //加锁自旋锁
        while (currentTime < outTIme) {
            //上锁操作,setNx为原子操作
            result = redisUtil.setNx(key, requestId, time, TimeUnit.SECONDS);
            if (result) {
                return result;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTime = System.currentTimeMillis();
        }
        return result;
    }

    /**
     * redis分布式锁-删除锁
     * @param key
     * @param requestId
     * @return
     */
    public boolean unLock(String key,String requestId) {
        if(StringUtils.isBlank(key)||StringUtils.isBlank(requestId)){
            throw new ShareLockException("redis分布式锁-删除锁-入参异常");
        }
        try{
            String value = redisUtil.get(key);
            if(StringUtils.equals(value,requestId)){
                return redisUtil.del(key);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * redis分布式加锁-尝试加锁
     * @param key
     * @param requestId
     * @param time
     * @return
     */
    public boolean tryLock(String key, String requestId, Long time) {

        boolean result = false;
        //入参校验
        if (StringUtils.isBlank(key) || StringUtils.isBlank(requestId) || time < 0) {
            throw new ShareLockException("redis分布式加锁-加锁入参异常");
        }
        //尝试加锁
        return redisUtil.setNx(key, requestId, time, TimeUnit.SECONDS);
    }

}
