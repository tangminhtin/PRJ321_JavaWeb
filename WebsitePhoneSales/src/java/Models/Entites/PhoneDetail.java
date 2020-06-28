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
public class PhoneDetail {
    private int phoneDetailId;
    private String phoneDetailImage;
    private String phoneDetailDescription;
    private String phoneDetailVideo;
    private String phoneDetailSpecialFeatures;
    private int displayId;
    private int bodyId;
    private int platformId;
    private int mainCameraId;
    private int selfieCameraId;
    private int storageId;
    private int batteryId;
    private int connectionId;
    private int commentId;

    public PhoneDetail() {
    }

    public PhoneDetail(int phoneDetailId, String phoneDetailImage, String phoneDetailDescription, String phoneDetailVideo, String phoneDetailSpecialFeatures, int displayId, int bodyId, int platformId, int mainCameraId, int selfieCameraId, int storageId, int batteryId, int connectionId, int commentId) {
        this.phoneDetailId = phoneDetailId;
        this.phoneDetailImage = phoneDetailImage;
        this.phoneDetailDescription = phoneDetailDescription;
        this.phoneDetailVideo = phoneDetailVideo;
        this.phoneDetailSpecialFeatures = phoneDetailSpecialFeatures;
        this.displayId = displayId;
        this.bodyId = bodyId;
        this.platformId = platformId;
        this.mainCameraId = mainCameraId;
        this.selfieCameraId = selfieCameraId;
        this.storageId = storageId;
        this.batteryId = batteryId;
        this.connectionId = connectionId;
        this.commentId = commentId;
    }

    public int getPhoneDetailId() {
        return phoneDetailId;
    }

    public void setPhoneDetailId(int phoneDetailId) {
        this.phoneDetailId = phoneDetailId;
    }

    public String getPhoneDetailImage() {
        return phoneDetailImage;
    }

    public void setPhoneDetailImage(String phoneDetailImage) {
        this.phoneDetailImage = phoneDetailImage;
    }

    public String getPhoneDetailDescription() {
        return phoneDetailDescription;
    }

    public void setPhoneDetailDescription(String phoneDetailDescription) {
        this.phoneDetailDescription = phoneDetailDescription;
    }

    public String getPhoneDetailVideo() {
        return phoneDetailVideo;
    }

    public void setPhoneDetailVideo(String phoneDetailVideo) {
        this.phoneDetailVideo = phoneDetailVideo;
    }

    public String getPhoneDetailSpecialFeatures() {
        return phoneDetailSpecialFeatures;
    }

    public void setPhoneDetailSpecialFeatures(String phoneDetailSpecialFeatures) {
        this.phoneDetailSpecialFeatures = phoneDetailSpecialFeatures;
    }

    public int getDisplayId() {
        return displayId;
    }

    public void setDisplayId(int displayId) {
        this.displayId = displayId;
    }

    public int getBodyId() {
        return bodyId;
    }

    public void setBodyId(int bodyId) {
        this.bodyId = bodyId;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public int getMainCameraId() {
        return mainCameraId;
    }

    public void setMainCameraId(int mainCameraId) {
        this.mainCameraId = mainCameraId;
    }

    public int getSelfieCameraId() {
        return selfieCameraId;
    }

    public void setSelfieCameraId(int selfieCameraId) {
        this.selfieCameraId = selfieCameraId;
    }

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public int getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(int batteryId) {
        this.batteryId = batteryId;
    }

    public int getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "PhoneDetail{" + "phoneDetailId=" + phoneDetailId + ", phoneDetailImage=" + phoneDetailImage + ", phoneDetailDescription=" + phoneDetailDescription + ", phoneDetailVideo=" + phoneDetailVideo + ", phoneDetailSpecialFeatures=" + phoneDetailSpecialFeatures + ", displayId=" + displayId + ", bodyId=" + bodyId + ", platformId=" + platformId + ", mainCameraId=" + mainCameraId + ", selfieCameraId=" + selfieCameraId + ", storageId=" + storageId + ", batteryId=" + batteryId + ", connectionId=" + connectionId + ", commentId=" + commentId + '}';
    }
    
}
