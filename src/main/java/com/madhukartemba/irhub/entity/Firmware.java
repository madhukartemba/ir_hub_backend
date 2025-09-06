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
@Table(name = "Firmware")
@Getter
@Setter
@NoArgsConstructor
public class Firmware extends BaseEntity {

    private int majorVersion;

    private int minorVersion;

    private String description;

}
