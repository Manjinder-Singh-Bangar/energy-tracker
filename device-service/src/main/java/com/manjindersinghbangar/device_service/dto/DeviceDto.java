package com.manjindersinghbangar.device_service.dto;

import com.manjindersinghbangar.device_service.model.DeviceType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeviceDto {
    private Long id;
    private String name;
    private DeviceType type;
    private String location;
    @Column(name = "user_id")
    private Long userId;
}
