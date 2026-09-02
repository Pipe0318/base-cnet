package com.sistemas.service;

import java.util.List;

import com.sistemas.model.Measurement;

public interface MeasurementService {
    public List<Measurement> listMeasurements();
    boolean registerMeasurement(Measurement measurement);
}
