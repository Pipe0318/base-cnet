package com.sistemas.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sistemas.model.Measurement;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Repository
public class MeasurementInMemory implements MeasurementRepository {

    private List<Measurement> InMemoryMeasurement;
    
    public MeasurementInMemory(){
        InMemoryMeasurement = new ArrayList<>();
    }

    @PostConstruct
    public void metodoInicial(){
        System.out.println("-> [LIFECYCLE] Inicializando Repositorio en Memoria <-");
        
    }

    @PreDestroy
    public void metodoFinal(){
        System.out.println("-> [LIFECYCLE] Finalizando Repositorio en Memoria <-");
    }

    @Override
    public List<Measurement> getAll(){
        return InMemoryMeasurement;
    }

    @Override 
    public void registerMeasurement(Measurement measurement){
        int nextId = InMemoryMeasurement.size() + 1;
        measurement.setId(nextId);
        InMemoryMeasurement.add(measurement);
        
        
    }

    
}
