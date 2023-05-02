package com.jingdianjichi.redis.init;

import com.jingdianjichi.redis.util.SpringContextUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InitCache implements CommandLineRunner {

    /**
     * 通过CommandLineRunner接口，项目启动后会执行run方法
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        //通过抽象类获取所有子类缓存，放入map准备进行预热
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        Map<String,AbstractCache> beansMap = applicationContext.getBeansOfType(AbstractCache.class);
        //调用init方法
        if(beansMap.isEmpty()){
            return;
        }
        for (Map.Entry<String,AbstractCache> entry: beansMap.entrySet()){
            AbstractCache abstractCache = (AbstractCache) SpringContextUtil.getBean(entry.getValue().getClass());
            //运行子类实现方法
            abstractCache.initCache();
        }
        System.out.println("31");
    }
}
