package com.manjindersinghbangar.device_service.controller;

import com.manjindersinghbangar.device_service.dto.DeviceDto;
import com.manjindersinghbangar.device_service.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<DeviceDto> createDevice(@RequestBody DeviceDto deviceDto){
        DeviceDto createdDevice = deviceService.createDevice(deviceDto);
        return ResponseEntity.ok(createdDevice);
    }
    
}
