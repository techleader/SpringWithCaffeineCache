package com.jls.spring.cache.caffeine.service;

import com.jls.spring.cache.caffeine.model.AirCraft;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Meetansh on 21-12-2016.
 */
@Component
public class AircraftService {
    Map<String,AirCraft> airCraftList = new HashMap();

    @CachePut(cacheNames = "AirCraft",key = "#airCraft.getId()")
    public AirCraft addAirCraft(AirCraft airCraft) {
        airCraftList.put(airCraft.getId(),airCraft);
        return airCraft;
    }

    @Cacheable(cacheNames = "AirCraft")
    public AirCraft getAirCraft(String id) {
        sleep(2);
        System.out.println("Reading aircraft from main repo");
        return airCraftList.get(id);
    }

    private void sleep(int seconds) {
        try{
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e){}
    }

}
