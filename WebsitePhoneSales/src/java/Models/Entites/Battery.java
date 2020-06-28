/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entites;

/**
 *
 * @author TangMinhTin - CE130438 - tintmce130438@fpt.edu.vn
 */
public class Battery {
    private int batteryId;
    private int batteryCapacity;
    private String batteryType;
    private String batteryTechnology;

    public Battery() {
    }

    public Battery(int batteryId, int batteryCapacity, String batteryType, String batteryTechnology) {
        this.batteryId = batteryId;
        this.batteryCapacity = batteryCapacity;
        this.batteryType = batteryType;
        this.batteryTechnology = batteryTechnology;
    }

    public int getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(int batteryId) {
        this.batteryId = batteryId;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBatteryTechnology() {
        return batteryTechnology;
    }

    public void setBatteryTechnology(String batteryTechnology) {
        this.batteryTechnology = batteryTechnology;
    }

    @Override
    public String toString() {
        return "Battery{" + "batteryId=" + batteryId + ", batteryCapacity=" + batteryCapacity + ", batteryType=" + batteryType + ", batteryTechnology=" + batteryTechnology + '}';
    }
    
}
