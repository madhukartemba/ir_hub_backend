package com.madhukartemba.irhub.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhukartemba.irhub.entity.Firmware;

@Repository
public interface FirmwareDAO extends JpaRepository<Firmware, UUID> {

    public Optional<Firmware> findByMajorVersionAndMinorVersion(int majorVersion, int minorVersion);

}
