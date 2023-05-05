# ape-frameTest
鸡翅编程学习脚手架搭建
本次视频内容：
（1）aop实现一个操作日志记录
    1.新建log项目,引入aop和gson
    2.设置切点,此时想记录前后端输入输出的报文体
    3.在业务模块的yml中,通过log.aspect.enable控制日志拦截器开关
    4.了解elk（Elasticsearch、Kibana、Logstash ）
（2）freemarker实现自定义word格式文件导出
    1.导出复杂格式的文件时,可以使用freemarker定制模板,然后导出
（3）工具类模块抽取
    1.IPutil, 用于获取本机IP
    2.Md5Utils,用于MD5加密
    3.base64Utils,编码解码
    4.simpleDateFormatUtils, 初始化simpleDate
    5.pinyinUtils，针对拼音做处理