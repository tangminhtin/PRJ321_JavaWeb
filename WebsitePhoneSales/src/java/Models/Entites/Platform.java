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
public class Platform {
    private int platformId;
    private String platformOS;
    private String platformChipset;
    private String platformCPU;
    private String platformGPU;

    public Platform() {
    }

    public Platform(int platformId, String platformOS, String platformChipset, String platformCPU, String platformGPU) {
        this.platformId = platformId;
        this.platformOS = platformOS;
        this.platformChipset = platformChipset;
        this.platformCPU = platformCPU;
        this.platformGPU = platformGPU;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public String getPlatformOS() {
        return platformOS;
    }

    public void setPlatformOS(String platformOS) {
        this.platformOS = platformOS;
    }

    public String getPlatformChipset() {
        return platformChipset;
    }

    public void setPlatformChipset(String platformChipset) {
        this.platformChipset = platformChipset;
    }

    public String getPlatformCPU() {
        return platformCPU;
    }

    public void setPlatformCPU(String platformCPU) {
        this.platformCPU = platformCPU;
    }

    public String getPlatformGPU() {
        return platformGPU;
    }

    public void setPlatformGPU(String platformGPU) {
        this.platformGPU = platformGPU;
    }

    @Override
    public String toString() {
        return "Platform{" + "platformId=" + platformId + ", platformOS=" + platformOS + ", platformChipset=" + platformChipset + ", platformCPU=" + platformCPU + ", platformGPU=" + platformGPU + '}';
    }
    
}
