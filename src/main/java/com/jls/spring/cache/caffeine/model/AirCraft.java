package com.jls.spring.cache.caffeine.model;

/**
 * Created by Meetansh on 21-12-2016.
 */

public class AirCraft {
    private String id;
    private String model;
    private int maxSpeed;

    public AirCraft(String id,String model, int maxSpeed){
        this.id = id;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "AirCraft["+id+ ", " + model + ", "+ maxSpeed +"]";
    }
}
