package com.manjindersinghbangar.device_service.entity;

import com.manjindersinghbangar.device_service.model.DeviceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "device")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DeviceType type;
    private String location;
    @Column(name = "user_id")
    private long userId;
}
