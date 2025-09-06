package com.madhukartemba.irhub.entity;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Device")
@NoArgsConstructor
@Getter
@Setter
public class Device extends BaseEntity {

    @Column(nullable = false, unique = true, length = 17)
    @Pattern(
            regexp = "^[0-9A-F]{2}(:[0-9A-F]){5}$",
            message = "MAC address must be in format AA:BB:CC:DD:EE:FF"
    )
    private String deviceMacId;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "deviceVersionId", referencedColumnName = "deviceVersionId", nullable = false),
        @JoinColumn(name = "firmwareId", referencedColumnName = "firmwareId", nullable = false)
    })
    private DeviceFirmware deviceFirmware;

    private Instant lastSeenAt;

    @OneToMany(mappedBy = "device")
    private List<DeviceEvent> deviceEvents;

}
