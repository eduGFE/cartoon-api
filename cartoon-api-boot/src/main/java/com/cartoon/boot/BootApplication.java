package com.cartoon.boot;


import com.cartoon.config.DataLoader;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import({DataLoader.class})
@SpringBootApplication(scanBasePackages = {"com.cartoon.controller", "com.cartoon.service"})
@MapperScan({"com.cartoon.dao.data.mapper"})
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}