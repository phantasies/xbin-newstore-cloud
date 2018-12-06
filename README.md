README.md

#### 本项目基于xbin-store-cloud重构：

- gradle转pom
- 归档所有api模块到service-api模块下
- 合并所有web模块为一个web-portal模块
- 合并原web模块的js与css
- 拆分static资源到工程外部目录
- 将配置移至bootstramp.yml和application.yml，去掉apollo/config server相关配置
- 废弃turbine与sleuth，独立部署zipkin server
- 重构dao层，改为手写mapper，废弃generator方式
- 增加启动脚本
- 修正错误依赖


#### 模块清单

| 模块 | 说明 |
| --------   | -------   |
|xbin-store-cloud-common  | 常量与工具|
|xbin-store-cloud-common-mapper  | mapper|
|xbin-store-cloud-common-pojo  | 业务对象|
|xbin-store-cloud-eureka-server  | 注册中心|
|xbin-store-cloud-service-admin  | 后台管理模块|
|xbin-store-cloud-service-api  | 微服务接口|
|xbin-store-cloud-service-cart  | 购物车模块|
|xbin-store-cloud-service-homepage  | 首页模块|
|xbin-store-cloud-service-item  | 商品模块|
|xbin-store-cloud-service-notify  | 通知模块|
|xbin-store-cloud-service-order  | 订单模块|
|xbin-store-cloud-service-search  | 搜索模块|
|xbin-store-cloud-service-user  | 用户模块|
|xbin-store-cloud-web-portal  | PC前端模块|

#### 重构说明
1. 原项目微服务拆分太细，每个service模块都对应一个web模块，故将所有web模块合并为一个xbin-store-cloud-web-portal，合并controller/template

2. 同时合并整理所有js和css，并将static资源目录移到工程外部，通过spring.resources.static-locations指定

3. 归档所有api模块到xbin-store-cloud-service-api模块下，为了好看

4. turbine与sleuth废弃，这两个模块是做路由跟踪的，按照zipkin官方改进，zipkin server已经改为单独部署，在客户端指定spring.zipkin.base-url

5. 原项目中的config目录废弃，将配置分散到每个模块的application.yml和bootstrap.yml, deploy-dev.properties表示开发环境配置

6. 原项目中的apollo库是用来连接apollo config server的（携程出品的配置中心），没必要用，本来spring也有spring config server（需要git库）. 原项目中只有turbine这个模块使用的配置中心，重构后废弃。

7. 原项目的mapper均为generator生成，扩展麻烦，改成手写的mapper，更适合编写具体业务的映射

8. 原xbin-store-cloud-service-sso改为xbin-store-cloud-service-user，原xbin-store-cloud-service-portal改为xbin-store-cloud-service-homepage

#### 部署
1.将spring-boot-starter-redis-0.0.1.jar spring-boot-starter-druid-0.0.1.jar打入本地maven库（请自行搜索），也可以使用他人的私库

2.本地编译打包： mvn install -DskipTests=true

3.上传所有jar及control.sh到服务器，假设目录为/home/shopdemo

4.创建数据库shop_demo，导入shop_demo.sql

5.运行： 
````
cd /home/shopdemo
./control.sh eureka-server-1.0.0.jar start
./control.sh xbin-store-cloud-service-user-1.0.0.jar start
./control.sh xbin-store-cloud-service-item-1.0.0.jar start
./control.sh xbin-store-cloud-service-cart-1.0.0.jar start
./control.sh xbin-store-cloud-service-order-1.0.0.jar start
./control.sh xbin-store-cloud-service-notify-1.0.0.jar start
./control.sh xbin-store-cloud-service-search-1.0.0.jar start
./control.sh xbin-store-cloud-service-admin-1.0.0.jar start
./control.sh xbin-store-cloud-web-portal-1.0.0.jar start
```` 
5.访问：

首页： http://192.168.100.222:8101/index

商品页面： http://192.168.100.222:8101/item/148630831972863

体验主流程：访问商品 -> 添加至购物车 -> 登录 -> 提交订单

登录帐号/密码：zhangsan/123456



#### 遗留问题
1.solr未部署，搜索不可用

2.后台管理功能缺失

3.zuul网关缺失

4.fastdfs缺失


#### 其他
部署zipkin server:
````
cd /home/shopdemo
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
````



安装fastdfs（如需存储图片到fastdfs则需要安装，存到文件目录则无需安装）:
```
yum install -y gcc perl
wget https://github.com/happyfish100/libfastcommon/archive/V1.0.39.tar.gz -O /home/tools/libfastcommon-1.0.39.tar.gz
cd /home/tools
tar xvf libfastcommon-1.0.39.tar.gz
cd libfastcommon-1.0.39 
./make.sh 
./make.sh install

wget https://github.com/happyfish100/fastdfs/archive/V5.11.tar.gz -O /home/tools/fastdfs-5.11.tar.gz
cd /home/tools
tar xvf fastdfs-5.11.tar.gz
cd fastdfs-5.11
./make.sh 
./make.sh install
```
配置fastdfs:
```
vi /etc/fdfs/tracker.conf
vi /etc/fdfs/storage.conf
mkdir -p /data/fastdfs/storage/base
mkdir -p /data/fastdfs/storage/storage0
mkdir -p /data/fastdfs/tracker
```

###add
```
部分需要自己安装的jar
mvn install:install-file -DgroupId=org.csource -DartifactId=fastdfs-client-java -Dversion=1.27 -Dpackaging=jar -Dfile=/home/gou/Downloads/fastdfs-client-java-1.27-RELEASE.jar
mvn install:install-file -DgroupId=cn.binux -DartifactId=spring-boot-starter-druid -Dversion=0.0.1 -Dpackaging=jar -Dfile=/home/gou/IdeaProjects/xbin-newstore-cloud/other/spring-boot-starter-druid-0.0.1.jar
mvn install:install-file -DgroupId=cn.binux -DartifactId=spring-boot-starter-redis -Dversion=0.0.1 -Dpackaging=jar -Dfile=/home/gou/IdeaProjects/xbin-newstore-cloud/other/spring-boot-starter-redis-0.0.1.jar




```

