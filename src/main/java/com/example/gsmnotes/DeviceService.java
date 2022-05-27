package com.example.gsmnotes;

import com.example.gsmnotes.entities.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Component
public class DeviceService {

    @Autowired
    private DeviceRepository repository;

    public List<Device> getAllDevices() {
        return this.repository.findAll();
//        ArrayList<Device> a = new ArrayList<>();
//        Device d = new Device();
//        d.setName("Hello, friends");
//        d.setModel("hehehehe");
//        a.add(d);
//        return a;
    }

    public Device addDevice(Device d) {
        return this.repository.save(d);
    }

    public Device updateDevice(Device d) {
        return this.repository.save(d);
    }


}
