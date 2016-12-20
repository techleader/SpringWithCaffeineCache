package com.jls.spring.cache.caffeine.service;

import com.jls.spring.cache.caffeine.model.AirCraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.stereotype.Component;

/**
 * Created by Meetansh on 21-12-2016.
 */
@Component
public class AircraftServiceExecutor {

    @Autowired
    private AircraftService aircraftService;
    @Autowired
    private CacheManager cacheManager;

    public void run(){
        AirCraft a1 = new AirCraft("123","Ciaz", 100);
        AirCraft a2 = new AirCraft("124","Ciaz", 200);
        AirCraft a3 = new AirCraft("125","Ciaz", 300);

        System.out.println(aircraftService.getAirCraft("123"));
        aircraftService.addAirCraft(a1);
        System.out.println(aircraftService.getAirCraft("123"));
        System.out.println(aircraftService.getAirCraft("123"));
        System.out.println(aircraftService.getAirCraft("123"));
        System.out.println(aircraftService.getAirCraft("124"));
        aircraftService.addAirCraft(a2);
        System.out.println(aircraftService.getAirCraft("124"));
        System.out.println(aircraftService.getAirCraft("124"));
        System.out.println(aircraftService.getAirCraft("124"));
        aircraftService.addAirCraft(a3);
        System.out.println(aircraftService.getAirCraft("125"));
        System.out.println(aircraftService.getAirCraft("125"));
        System.out.println(aircraftService.getAirCraft("125"));

    }

    public void printStat(){
        com.github.benmanes.caffeine.cache.Cache  c= ((com.github.benmanes.caffeine.cache.Cache)cacheManager.getCache("AirCraft").getNativeCache());
        System.out.println(c.stats());

    }
}
