package com.manjindersinghbangar.device_service.controller;

import com.manjindersinghbangar.device_service.dto.DeviceDto;
import com.manjindersinghbangar.device_service.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {
    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable Long id){
        DeviceDto deviceDto = deviceService.getDeviceById(id);
        return ResponseEntity.ok(deviceDto);
    }

    
}
