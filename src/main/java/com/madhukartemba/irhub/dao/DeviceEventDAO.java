package com.madhukartemba.irhub.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhukartemba.irhub.entity.Device;
import com.madhukartemba.irhub.entity.DeviceEvent;

public interface DeviceEventDAO extends JpaRepository<DeviceEvent, UUID> {

    public List<DeviceEvent> findAllByDevice(Device device);

}
