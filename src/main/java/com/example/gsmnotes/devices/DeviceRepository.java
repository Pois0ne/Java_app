package com.example.gsmnotes.devices;

import com.example.gsmnotes.devices.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}