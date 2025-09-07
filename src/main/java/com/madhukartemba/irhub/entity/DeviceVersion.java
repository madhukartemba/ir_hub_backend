package com.madhukartemba.irhub.entity;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "DeviceVersion")
@Getter
@Setter
@NoArgsConstructor
public class DeviceVersion extends BaseEntity {

    private int version;

    private String name;

    private String description;

    @OneToMany(mappedBy = "deviceVersion", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<DeviceFirmware> deviceFirmwares;

}
