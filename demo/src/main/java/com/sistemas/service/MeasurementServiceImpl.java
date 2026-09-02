package com.sistemas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.model.Device;
import com.sistemas.model.Measurement;
import com.sistemas.repository.MeasurementRepository;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final DeviceService deviceService;

    @Autowired
    public MeasurementServiceImpl(MeasurementRepository measurementRepository, DeviceService deviceService) {
        this.measurementRepository = measurementRepository;
        this.deviceService = deviceService;
    }

    @Override
    public List<Measurement> listMeasurements(){
        return measurementRepository.getAll();

    }

    @Override
    public boolean registerMeasurement(Measurement measurement){
        Integer searchedId = measurement.getDevice_id();
    
        if(searchedId != null){
            Device device = deviceService.getDeviceById(searchedId);
            
            if(device !=null){

                boolean validRange = measurement.getValue() >= device.getMinValue() && measurement.getValue() <= device.getMaxValue();
                boolean timeStampUnico = true;
                boolean validTime = true;
                List<Measurement> existingMeasurements = measurementRepository.getAll();
                Measurement lastMeasurement = null;

                for(Measurement existing : existingMeasurements){
                    if(existing.getDevice_id() != null && existing.getDevice_id().equals(searchedId)){
                        if(existing.getTimeStamp().equals(measurement.getTimeStamp())){
                        timeStampUnico = false;
                        }

                        lastMeasurement = existing;
                    }
                    

                }

                if(lastMeasurement != null){

                    long period = 100;
                    long tolerance = 10;

                    long diference = measurement.getTimeStamp() - lastMeasurement.getTimeStamp();

                    long minAllowed = period - tolerance;
                    long maxAllowed = period + tolerance;

                    validTime = (diference >= minAllowed && maxAllowed >= diference);

                }
                
                if(validRange && timeStampUnico && validTime){
                    measurementRepository.registerMeasurement(measurement);
                    return true;
                }
                
            } else {
                return false;
            }
            
        }

        return false;
    }




    

    
}
