package com.jingdianjichi.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPollConfig {

    @Bean(name = "mailThreadPool")
    public ThreadPoolExecutor getMailThreadPool() {
        ThreadFactory threadFactory = new CustomNameThreadFactory("mail");
        return new ThreadPoolExecutor(20,
                240,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue(40),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

}