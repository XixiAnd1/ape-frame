package com.jingdianjichi.redis.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext1) throws BeansException {
        applicationContext = applicationContext1;
    }

    public static Object getBean(Class type){
        return applicationContext.getBean(type);
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
