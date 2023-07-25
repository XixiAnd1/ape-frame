# ape-frameTest
鸡翅编程学习脚手架搭建
本次视频内容：

（1）集成springbootTest
    集成junit和springbootTest，实现自测

（2）服务预热
一、概述
服务启动成功后,只是简单的服务进程启动成功,并且做一些简单的初始化,对于启动成功后到提供最优质的服务质量之间,
会有一段时间把服务的状态调整到最优,那么如果对服务稳定性或者质量有特别高的诉求和要求,那么在服务启动伊始,
并不能满足qps高吞吐和rt高响应,并且由于并没有完全做好初始化准备,也可能造成连锁反应,
导致服务cpu飙高甚至服务无法启动。
二、服务预热
所谓服务预热,就是在服务启动完成到对外提供服务之前,针对特定场景提供一些初始化准备操作,
比如线程池预热、缓存预热、数据库预热、web预热和jvm预热等等,需要注意的是,
预热操作需要在应用真正对外提供服务之前完成,那么我们就可以基于框架的事件或者扩展点来完成这个操作,
比如ContextRefreshedEvent和ApplicationReadyEvent事件,
InitializingBean和ApplicationContextAware扩展点,以及@PostConstruct和init方法等等
三、数据库预热
连接池预热,所谓连接池预热,就是应用启动时根据需要创建若干数据库连接,放到连接池中,
然后应用启动处理数据库读写请求时,可以直接从连接池中拿连接来用,
避免了读写请求创建连接并放入连接池的流程耗时。常见的连接池Druid提供了比较方便的连接池预热能力。
数据库预热,对于InnoDB存储引擎的mysql实例,重启完毕后,一开始十几分钟的性能是非常差的,
原因是因为InnoDB有innodb buffer pool,其对应参数innodb_buffer_pool_size,size越大,
可以放到内存的数据越多,而大多数的项目都会有热点数据的存在,当热点数据经过LRU算法进入到buffer pool之后,
读磁盘的次数减少,读的都是内存,速度是最快的。
四、缓存预热
    (1)连接池预热
    (2)热点数据预热
五、线程池预热

（3）controller的时间格式转换器
    当前端传来date格式的日期变量，后端直接toString会报错，所以使用JacksonConfig来做转换

（4）xxljob集成（分布式任务调度）
    1.下载xxljob源码
    2.更改admin下的application.properties，数据库信息，port信息，邮箱信息
    3.在数据库软件执行tables_xxl_job.sql，创建xxljob数据库
    4.调度中心访问地址：http://localhost:9000/xxl-job-admin (该地址执行器将会使用到，作为回调地址)
        默认登录账号 “admin/123456”
    5.有时需要更新xxl-job-core项目里的包，需要通过maven install该项目
    6.在common项目里新增job，引入xxljob相关依赖
    7.在demo项目里编写客户端代码
    （1）在配置文件里添加相关信息（从xxl-job-executor-sample-springboot项目获取
    （2）确保yml里的executor-appName与网页的执行器的AppName保持一致
    （3）创建SampleXxlJob文件，编写业务逻辑
    （4）在网页创建任务，设置执行时间，观察调度日志









