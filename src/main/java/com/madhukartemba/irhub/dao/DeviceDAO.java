package com.madhukartemba.irhub.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhukartemba.irhub.entity.Device;

@Repository
public interface DeviceDAO extends JpaRepository<Device, UUID> {

    public Optional<Device> findByDeviceMacId(String deviceMacId);

}
