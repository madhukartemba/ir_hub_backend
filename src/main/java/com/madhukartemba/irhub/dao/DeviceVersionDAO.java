package com.madhukartemba.irhub.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhukartemba.irhub.entity.DeviceVersion;

@Repository
public interface DeviceVersionDAO extends JpaRepository<DeviceVersion, UUID> {

    public Optional<DeviceVersion> findByVersion(int version);

}
