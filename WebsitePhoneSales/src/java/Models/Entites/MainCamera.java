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
public class MainCamera {
    private int mainCameraId;
    private String mainCameraResolution;
    private String mainCameraFeatures;
    private String mainCameraVideo;

    public MainCamera() {
    }

    public MainCamera(int mainCameraId, String mainCameraResolution, String mainCameraFeatures, String mainCameraVideo) {
        this.mainCameraId = mainCameraId;
        this.mainCameraResolution = mainCameraResolution;
        this.mainCameraFeatures = mainCameraFeatures;
        this.mainCameraVideo = mainCameraVideo;
    }

    public int getMainCameraId() {
        return mainCameraId;
    }

    public void setMainCameraId(int mainCameraId) {
        this.mainCameraId = mainCameraId;
    }

    public String getMainCameraResolution() {
        return mainCameraResolution;
    }

    public void setMainCameraResolution(String mainCameraResolution) {
        this.mainCameraResolution = mainCameraResolution;
    }

    public String getMainCameraFeatures() {
        return mainCameraFeatures;
    }

    public void setMainCameraFeatures(String mainCameraFeatures) {
        this.mainCameraFeatures = mainCameraFeatures;
    }

    public String getMainCameraVideo() {
        return mainCameraVideo;
    }

    public void setMainCameraVideo(String mainCameraVideo) {
        this.mainCameraVideo = mainCameraVideo;
    }

    @Override
    public String toString() {
        return "MainCamera{" + "mainCameraId=" + mainCameraId + ", mainCameraResolution=" + mainCameraResolution + ", mainCameraFeatures=" + mainCameraFeatures + ", mainCameraVideo=" + mainCameraVideo + '}';
    }
    
}
