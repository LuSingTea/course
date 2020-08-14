package com.course.file;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
/**
 * @ClassName : config
 * @Description :
 * @Author : cybersa
 * @Date: 2020-08-08 17:09
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.course")
@MapperScan(basePackages = {"com.course.server.mapper"})
public class FileApplication {
    
    private static final Logger LOG = LoggerFactory.getLogger(FileApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FileApplication.class);
        ConfigurableEnvironment environment = app.run(args).getEnvironment();
        LOG.info("启动成功");
        LOG.info("File地址: \t http://127.0.0.1:{}", environment.getProperty("server.port"));
    }

}
