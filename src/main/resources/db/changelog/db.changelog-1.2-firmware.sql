-- liquibase formatted sql
-- changeset madhukartemba:2

CREATE TABLE DeviceVersion (
    version INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1000) DEFAULT NULL,
    id CHAR(36) NOT NULL,
    created TIMESTAMP DEFAULT NULL,
    createdBy VARCHAR(255) DEFAULT NULL,
    lastModified TIMESTAMP DEFAULT NULL,
    lastModifiedBy VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uniqueVersion (version)
);

CREATE TABLE Firmware (
    majorVersion INT NOT NULL,
    minorVersion INT NOT NULL,
    description VARCHAR(1024) DEFAULT NULL,
    id CHAR(36) NOT NULL,
    created TIMESTAMP DEFAULT NULL,
    createdBy VARCHAR(255) DEFAULT NULL,
    lastModified TIMESTAMP DEFAULT NULL,
    lastModifiedBy VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uniqueFirmwareVersion (majorVersion, minorVersion)
);

CREATE TABLE DeviceFirmware (
    deviceVersionId CHAR(36) NOT NULL,
    firmwareId CHAR(36) NOT NULL,
    firmwareFile MEDIUMBLOB,
    PRIMARY KEY (deviceVersionId, firmwareId), 
    FOREIGN KEY (deviceVersionId) REFERENCES DeviceVersion(id),
    FOREIGN KEY (firmwareId) REFERENCES Firmware(id)
);

CREATE TABLE Device (
    deviceMacId CHAR(17) NOT NULL,
    deviceVersionId CHAR(36) NOT NULL,
    firmwareId CHAR(36) NOT NULL,
    lastSeenAt TIMESTAMP DEFAULT NULL,
    id CHAR(36) NOT NULL,
    created TIMESTAMP DEFAULT NULL,
    createdBy VARCHAR(255) DEFAULT NULL,
    lastModified TIMESTAMP DEFAULT NULL,
    lastModifiedBy VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY macAddress (deviceMacId),
    FOREIGN KEY (deviceVersionId, firmwareId) REFERENCES DeviceFirmware(deviceVersionId, firmwareId)
);

CREATE TABLE DeviceEvent (
    deviceId CHAR(36) NOT NULL,
    eventType VARCHAR(100) NOT NULL,
    description VARCHAR(1024) DEFAULT NULL,
    capturedAt TIMESTAMP DEFAULT NULL,
    id CHAR(36) NOT NULL,
    created TIMESTAMP DEFAULT NULL,
    createdBy VARCHAR(255) DEFAULT NULL,
    lastModified TIMESTAMP DEFAULT NULL,
    lastModifiedBy VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (deviceId) REFERENCES Device(id) ON DELETE CASCADE
);

CREATE INDEX idx_deviceevent_device_time ON DeviceEvent(deviceId, capturedAt);
