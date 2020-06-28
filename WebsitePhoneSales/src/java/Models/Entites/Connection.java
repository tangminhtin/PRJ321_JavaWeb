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
public class Connection {
    private int connectionId;
    private String connectionSIM;
    private String connectionMobileNetwork;
    private String connectionWLAN;
    private String connectionBluetooth;
    private String connectionGPS;
    private int connectionNFC;
    private int connectionRadio;
    private String connectionUSB;
    private int connectionJack;

    public Connection() {
    }

    public Connection(int connectionId, String connectionSIM, String connectionMobileNetwork, String connectionWLAN, String connectionBluetooth, String connectionGPS, int connectionNFC, int connectionRadio, String connectionUSB, int connectionJack) {
        this.connectionId = connectionId;
        this.connectionSIM = connectionSIM;
        this.connectionMobileNetwork = connectionMobileNetwork;
        this.connectionWLAN = connectionWLAN;
        this.connectionBluetooth = connectionBluetooth;
        this.connectionGPS = connectionGPS;
        this.connectionNFC = connectionNFC;
        this.connectionRadio = connectionRadio;
        this.connectionUSB = connectionUSB;
        this.connectionJack = connectionJack;
    }

    public int getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    public String getConnectionSIM() {
        return connectionSIM;
    }

    public void setConnectionSIM(String connectionSIM) {
        this.connectionSIM = connectionSIM;
    }

    public String getConnectionMobileNetwork() {
        return connectionMobileNetwork;
    }

    public void setConnectionMobileNetwork(String connectionMobileNetwork) {
        this.connectionMobileNetwork = connectionMobileNetwork;
    }

    public String getConnectionWLAN() {
        return connectionWLAN;
    }

    public void setConnectionWLAN(String connectionWLAN) {
        this.connectionWLAN = connectionWLAN;
    }

    public String getConnectionBluetooth() {
        return connectionBluetooth;
    }

    public void setConnectionBluetooth(String connectionBluetooth) {
        this.connectionBluetooth = connectionBluetooth;
    }

    public String getConnectionGPS() {
        return connectionGPS;
    }

    public void setConnectionGPS(String connectionGPS) {
        this.connectionGPS = connectionGPS;
    }

    public int getConnectionNFC() {
        return connectionNFC;
    }

    public void setConnectionNFC(int connectionNFC) {
        this.connectionNFC = connectionNFC;
    }

    public int getConnectionRadio() {
        return connectionRadio;
    }

    public void setConnectionRadio(int connectionRadio) {
        this.connectionRadio = connectionRadio;
    }

    public String getConnectionUSB() {
        return connectionUSB;
    }

    public void setConnectionUSB(String connectionUSB) {
        this.connectionUSB = connectionUSB;
    }

    public int getConnectionJack() {
        return connectionJack;
    }

    public void setConnectionJack(int connectionJack) {
        this.connectionJack = connectionJack;
    }

    @Override
    public String toString() {
        return "Connection{" + "connectionId=" + connectionId + ", connectionSIM=" + connectionSIM + ", connectionMobileNetwork=" + connectionMobileNetwork + ", connectionWLAN=" + connectionWLAN + ", connectionBluetooth=" + connectionBluetooth + ", connectionGPS=" + connectionGPS + ", connectionNFC=" + connectionNFC + ", connectionRadio=" + connectionRadio + ", connectionUSB=" + connectionUSB + ", connectionJack=" + connectionJack + '}';
    }
    
}
