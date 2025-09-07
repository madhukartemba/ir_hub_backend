package com.madhukartemba.irhub.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "DeviceFirmware")
@NoArgsConstructor
@Getter
@Setter
public class DeviceFirmware {

    @EmbeddedId
    private DeviceFirmwareId id;

    @ManyToOne
    @MapsId("deviceVersionId")
    @JoinColumn(name = "deviceVersionId", nullable = false)
    private DeviceVersion deviceVersion;

    @ManyToOne
    @MapsId("firmwareId")
    @JoinColumn(name = "firmwareId", nullable = false)
    private Firmware firmware;

    @Column(name = "firmwareFile", columnDefinition = "MEDIUMBLOB")
    private byte[] firmwareFile;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    public static class DeviceFirmwareId implements Serializable {

        private UUID deviceVersionId;
        private UUID firmwareId;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof DeviceFirmwareId that)) {
                return false;
            }
            return Objects.equals(deviceVersionId, that.deviceVersionId)
                    && Objects.equals(firmwareId, that.firmwareId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(deviceVersionId, firmwareId);
        }
    }
}
