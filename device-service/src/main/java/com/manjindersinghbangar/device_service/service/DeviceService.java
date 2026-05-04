package com.manjindersinghbangar.device_service.service;

import com.manjindersinghbangar.device_service.dto.DeviceDto;
import com.manjindersinghbangar.device_service.entity.Device;
import com.manjindersinghbangar.device_service.exception.DeviceNotFoundException;
import com.manjindersinghbangar.device_service.repository.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    public DeviceDto getDeviceById(Long id){
        Device device = deviceRepository.findById(id).orElseThrow(() -> new DeviceNotFoundException("Device not found"));
        return mapToDto(device);
    }

    public DeviceDto createDevice(DeviceDto input){
        Device device = new Device();
        device.setLocation(input.getLocation());
        device.setType(input.getType());
        device.setUserId(input.getUserId());
        device.setName(input.getName());

        final Device createdDevice = deviceRepository.save(device);
        return mapToDto(createdDevice);
    }

    public DeviceDto updateDevice(Long id, DeviceDto input){
        Device existingDevice = deviceRepository.findById(id).orElseThrow(() -> new DeviceNotFoundException("Device not found"));

        existingDevice.setName(input.getName());
        existingDevice.setType(input.getType());
        existingDevice.setLocation(input.getLocation());
        existingDevice.setUserId(input.getUserId());

        Device updatedDevice = deviceRepository.save(existingDevice);

        return mapToDto(updatedDevice);
    }

    public void deleteDevice(Long id){
        if(!deviceRepository.existsById(id)){
            throw new DeviceNotFoundException("Device with id:- " + id + " does not exists.");
        }
        deviceRepository.deleteById(id);
    }

    private DeviceDto mapToDto(Device device){
        DeviceDto dto = new DeviceDto();
        dto.setLocation(device.getLocation());
        dto.setName(device.getName());
        dto.setUserId(device.getUserId());
        dto.setType(device.getType());
        dto.setId(device.getId());

        return dto;
    }


}
