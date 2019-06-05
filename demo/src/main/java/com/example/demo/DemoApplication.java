package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.*;

@SpringBootApplication
public class DemoApplication {

    private static ApplicationContext context;

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(DemoApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        context = application.run(args);
    }
}
