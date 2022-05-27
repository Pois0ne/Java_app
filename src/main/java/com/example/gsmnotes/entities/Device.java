package com.example.gsmnotes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String model;
    private String brand;

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setHistory(String history) {
        this.history = history;
    }

//    private int id;
    private int imei;
    private String sn;
    private String history;

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Long getId() {
        return id;
    }

    public int getImei() {
        return imei;
    }

    public String getSn() {
        return sn;
    }

    public String getHistory() {
        return history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
