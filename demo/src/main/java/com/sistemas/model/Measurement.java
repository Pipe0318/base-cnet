package com.sistemas.model;

public class Measurement {
    private Integer id;
    private Long timeStamp;
    private Double value;
    private Integer device_id;

    public Measurement(){

    }
    
    public Measurement(Integer id, Long timeStamp, Double value, Integer device_id) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.value = value;
        this.device_id = device_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    

    
}
