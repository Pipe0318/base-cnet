package com.sistemas.model;

public class Device {

    private Integer id;
    private String name;
    private String serialNumber;
    private String type;
    private Double maxValue; 
    private Double minValue;
    private Long samplingPeriod;
    private Long timeTolerance;
    private String unit;

    public Device(Integer id, String name, String serialNumber, String type, Double maxValue, Double minValue,
            Long samplingPeriod, Long timeTolerance, String unit) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.type = type;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.samplingPeriod = samplingPeriod;
        this.timeTolerance = timeTolerance;
        this.unit = unit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Long getSamplingPeriod() {
        return samplingPeriod;
    }

    public void setSamplingPeriod(Long samplingPeriod) {
        this.samplingPeriod = samplingPeriod;
    }

    public Long getTimeTolerance() {
        return timeTolerance;
    }

    public void setTimeTolerance(Long timeTolerance) {
        this.timeTolerance = timeTolerance;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    
    



}
