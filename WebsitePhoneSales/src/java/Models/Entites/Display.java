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
public class Display {
    private int displayId;
    private String displayType;
    private String displaySize;
    private String displayResolution;
    private String displayProtection;

    public Display() {
    }

    public Display(int displayId, String displayType, String displaySize, String displayResolution, String displayProtection) {
        this.displayId = displayId;
        this.displayType = displayType;
        this.displaySize = displaySize;
        this.displayResolution = displayResolution;
        this.displayProtection = displayProtection;
    }

    public int getDisplayId() {
        return displayId;
    }

    public void setDisplayId(int displayId) {
        this.displayId = displayId;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    public String getDisplayProtection() {
        return displayProtection;
    }

    public void setDisplayProtection(String displayProtection) {
        this.displayProtection = displayProtection;
    }

    @Override
    public String toString() {
        return "Display{" + "displayId=" + displayId + ", displayType=" + displayType + ", displaySize=" + displaySize + ", displayResolution=" + displayResolution + ", displayProtection=" + displayProtection + '}';
    }
    
}
