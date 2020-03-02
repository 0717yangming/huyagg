package com.ym.hygg.huyagg;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class HuyaggApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuyaggApplication.class, args);
    }

}
