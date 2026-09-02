package com.sistemas.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sistemas.model.Device;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Repository
public class DeviceInMemory implements DeviceRepository {
    private List<Device> InMemoryDevices;

    public DeviceInMemory(){
        InMemoryDevices = new ArrayList<>();
    }

    @PostConstruct
    public void metodoInicial(){
        System.out.println("-> [LIFECYCLE] Inicializando Repositorio en Memoria <-");
        registerDevice(new Device(1, "Sensor de temperatura", "TEMP-001", "Temperatura",
                100.0, 0.0, 100L, 10L, "°C"));
    }

    @PreDestroy
    public void metodoFinal(){
        System.out.println("-> [LIFECYCLE] Finalizando Repositorio en Memoria <-");
    }

    @Override
    public List<Device> getAll(){
        return InMemoryDevices;
    }

    @Override
    public void registerDevice(Device device){
        InMemoryDevices.add(device);
    }

    @Override
    public Device getDeviceById(Integer id){
        if (id == null){
            return null;
        }
        for(Device device : InMemoryDevices){
            if(device.getId()!=null && device.getId().equals(id)){
                return device;
            }
        }
        return null;
    }

}
