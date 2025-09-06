package com.madhukartemba.irhub.entity;

import java.time.Instant;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "DeviceEvent")
@NoArgsConstructor
@Getter
@Setter
public class DeviceEvent extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "deviceId", nullable = false)
    private Device device;

    public enum EventType {
        BOOT,
        CODE_ADDED,
        CODE_REMOVED
    }

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(length = 1024)
    private String description;

    private Instant capturedAt;

}
