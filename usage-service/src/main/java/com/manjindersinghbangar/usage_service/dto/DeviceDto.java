package com.manjindersinghbangar.usage_service.dto;

import com.influxdb.annotations.Column;

public record DeviceDto (Long id,
                         String name,
                         String type,
                         String location,
                         @Column(name = "user_id")
                         Long userId) {
}
