package cn.binux;

import cn.binux.utils.JedisClient;
import cn.binux.utils.impl.JedisClientSingle;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author gou
 */
@EnableHystrix
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages = "cn.binux.mapper")
public class XbinStoreServiceCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(XbinStoreServiceCartApplication.class, args);
    }

    @Bean
    public JedisClient jedisClient() {
        return new JedisClientSingle();
    }
}
