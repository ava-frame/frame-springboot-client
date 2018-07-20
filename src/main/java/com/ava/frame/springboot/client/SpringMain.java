package com.ava.frame.springboot.client;

import com.ava.frame.core.SpringApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by redredava on 2018/7/9.
 * email:zhyx2014@yeah.net
 */
@ComponentScan(basePackageClasses = {SpringApplicationContext.class}, basePackages = {"com.ava.frame.springboot.client", "com.ava.frame.es"})
@SpringBootApplication()
// spring cloud config  client
@EnableAutoConfiguration
public class SpringMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringMain.class,args);
    }
}
