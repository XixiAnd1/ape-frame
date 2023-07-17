# ape-frameTest
鸡翅编程学习脚手架搭建
本次视频内容：
（1）maven的profile实现环境隔离
    1.为每个环境新建一个yml
    2.在application.yml设置变量
    3.在pom.xml引入profiles
    4.在maven标签页可以看到Profiles栏目，可以指定环节加载
（2）springboot插件打包部署
    1.在pom.xml引入spring-boot-maven-plugin
    2.在maven标签页对应项目执行install
    3.找到jar包位置，cmd窗口执行java -jar XXX.jar 即可运行程序
（3）httpclient优化
    1.针对高并发场景下，qps上不去的问题
（4）构造者模式案例
    1.demo项目下的SkuBuilder文件
（5）过滤器模式案例
    1.这种模式允许开发人员使用不同的标准来过滤一组对象