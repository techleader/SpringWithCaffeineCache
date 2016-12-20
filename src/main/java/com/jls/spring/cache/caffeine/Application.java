package com.jls.spring.cache.caffeine;

import com.jls.spring.cache.caffeine.service.AircraftServiceExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Meetansh on 06-09-2016.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.jls.spring.cache.caffeine")
@EnableCaching
public class Application {

        public static void main(String[] args) {
            ApplicationContext context = SpringApplication.run(Application.class, args);
            ((AircraftServiceExecutor) context.getBean("aircraftServiceExecutor")).run();
            ((AircraftServiceExecutor) context.getBean("aircraftServiceExecutor")).printStat();

        }

}
