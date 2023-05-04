# ape-frameTest
鸡翅编程学习脚手架搭建
本次视频内容：
（1）日志log4j集成，异步日志集成
    1.引入log4j2-spring.xml，通过mavenHelper排除dependency冲突
    2.异步日志：引入disruptor与AsyncLogger，一边打日志，业务代码继续往下执行,适用于需要打印大量日志场景
（2）项目整体结构优化
    1.maven引入jar包的版本号统一管理
    2.common项目与业务项目的解耦
    3.业务项目需要的common，才引入到业务项目pom，不应直接放在整体项目pom
    （因为实际开发中，common和业务项目分别在各自的git上，不会混为一谈）
（3）代码优化
    1.删除user相关文件
    2.mapper放入resources
    3.java放入dao
    4.application文件只扫dao