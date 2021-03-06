# db-api

不同系统之间使用数据库接口表进行交互，由ETL或文件或view，在不同的系统的数据库之间进行交互。

系统众多后，系统数据库之间的关系不好维护，同时修改这些接口表也有很大的风险。

db-api就是要来管理这些数据库之间的交互关系的，系统数据库之间的数据交互主要有以下方式：

* ETL+接口表，由ETL定时将某数据库的数据从愿接口表导出，然后导入到另外一个数据库的目标接口表
* 文件，使用文件导入，目前常见的文件格式为CSV
* 数据库视图View，目标接口直接调用远程视图进行操作

# 安装和配置

* 需要python环境，可以使用virtualenv的方式搭建环境，目前在python2.7版本上运行和测试，python3还未测试
* 执行命令安装依赖

	>pip install -r requirements.txt
	
* 启动服务器
	
	>python app.py runserver -p 8080

最新的系统使用Java来实现，位于SparkDemo目录下，使用Maven进行配置。

1. 使用Google Guice来进行依赖注入（DI）功能
2. 使用ORMLite来进行ORM和数据库处理
3. 使用jinjava作为模板引擎，放弃了Freemarker