package com.manjindersinghbangar.device_service.service;

import com.manjindersinghbangar.device_service.dto.DeviceDto;
import com.manjindersinghbangar.device_service.entity.Device;
import com.manjindersinghbangar.device_service.repository.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    public DeviceDto getDeviceById(Long id){
        Device device = deviceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Device not found"));
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
