！！！启动项目前必须先启动startup.cmd和rabbitmq-server.bat，尤其是startup.cmd（nacos）否则报错
(有时候将数据库软件打开后,才能启动nacos,否则无法启动nacos)
启动rabbitmq-server.bat要双击rabbitmq-server.bat启动,或
					     在tju_elm_project_plus\erlang26.2\Erlang OTP\lib\Rabbitmq\rabbitmq_server-4.0.3\sbin
                                             启用管理插件 rabbitmq-plugins enable rabbitmq_management
Redis启动教程见博客:https://blog.csdn.net/weixin_44893902/article/details/123087435
          省流版:在Redis-x64-5.0.14.1中cmd,输入redis-server.exe redis.windows.conf

功能：
swagger           localhost:8080/elm/doc.html

nacos               localhost:8848/nacos/              user:nacos        passwd:nacos

rabbitmq          
                        localhost:15672/                     user:guest        passwd:guest