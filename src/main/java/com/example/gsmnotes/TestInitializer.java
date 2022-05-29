package com.example.gsmnotes;

import com.example.gsmnotes.devices.Device;

import static com.example.gsmnotes.Application.deviceService;

public class TestInitializer {

    // TODO: напиши, чтобы приложение заполнялось тестовыми данными для демонстрации
    public static void fillWithSampleData() {

        deviceService.clearAllDevices();

        Device d = new Device();
        d.setName("iPhone 87 Pro from G.V.");
        d.setModel("87 Pro");
        d.setSn("lol-hah-082");
        d.setBrand("Apple");
        d.setHistory("G.V. has given me this amazing device from 2048");
        deviceService.addDevice(d);


    }
}
