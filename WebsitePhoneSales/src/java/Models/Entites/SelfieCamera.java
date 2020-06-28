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
public class SelfieCamera {
    private int selfieCameraId;
    private String selfieCameraResolution;
    private String selfieCameraFeatures;
    private String selfieCameraVideo;

    public SelfieCamera() {
    }

    public SelfieCamera(int selfieCameraId, String selfieCameraResolution, String selfieCameraFeatures, String selfieCameraVideo) {
        this.selfieCameraId = selfieCameraId;
        this.selfieCameraResolution = selfieCameraResolution;
        this.selfieCameraFeatures = selfieCameraFeatures;
        this.selfieCameraVideo = selfieCameraVideo;
    }

    public int getSelfieCameraId() {
        return selfieCameraId;
    }

    public void setSelfieCameraId(int selfieCameraId) {
        this.selfieCameraId = selfieCameraId;
    }

    public String getSelfieCameraResolution() {
        return selfieCameraResolution;
    }

    public void setSelfieCameraResolution(String selfieCameraResolution) {
        this.selfieCameraResolution = selfieCameraResolution;
    }

    public String getSelfieCameraFeatures() {
        return selfieCameraFeatures;
    }

    public void setSelfieCameraFeatures(String selfieCameraFeatures) {
        this.selfieCameraFeatures = selfieCameraFeatures;
    }

    public String getSelfieCameraVideo() {
        return selfieCameraVideo;
    }

    public void setSelfieCameraVideo(String selfieCameraVideo) {
        this.selfieCameraVideo = selfieCameraVideo;
    }

    @Override
    public String toString() {
        return "SelfieCamera{" + "selfieCameraId=" + selfieCameraId + ", selfieCameraResolution=" + selfieCameraResolution + ", selfieCameraFeatures=" + selfieCameraFeatures + ", selfieCameraVideo=" + selfieCameraVideo + '}';
    }
    
}
