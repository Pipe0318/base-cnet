package com.sistemas.repository;
import java.util.List;

import com.sistemas.model.Measurement;

public interface  MeasurementRepository {
    List<Measurement> getAll();
    void registerMeasurement(Measurement measurement);

}   
