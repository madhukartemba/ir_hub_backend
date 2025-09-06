package com.madhukartemba.irhub.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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

}
