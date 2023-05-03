# ape-frameTest
鸡翅编程学习脚手架搭建
本次视频内容：
1.服务器redis漏洞中木马复盘（一定要设置redis密码）
2.手写redis分布式锁
    (1)入参校验
    (2)加锁时自旋
    (3)借助redis的setnx来进行锁的设置
3.分布式锁场景
    （1）批任务调度
    （2）并发操作同一个数据时，需要考虑加锁
4.spring注解缓存方式
    （1）通过注解@Cacheable，在controller使用get请求时，
        将数据库的数据查出来的同时，存储到redis缓存
    （2）在application里添加注解@EnableCaching
5.快捷注释
    （1）file-setting-editor-live templates
