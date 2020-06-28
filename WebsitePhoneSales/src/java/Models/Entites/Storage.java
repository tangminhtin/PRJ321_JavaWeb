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
public class Storage {
    private int storageId;
    private int storageRAM;
    private int storageInternal;
    private int storageExternal;

    public Storage() {
    }

    public Storage(int storageId, int storageRAM, int storageInternal, int storageExternal) {
        this.storageId = storageId;
        this.storageRAM = storageRAM;
        this.storageInternal = storageInternal;
        this.storageExternal = storageExternal;
    }

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public int getStorageRAM() {
        return storageRAM;
    }

    public void setStorageRAM(int storageRAM) {
        this.storageRAM = storageRAM;
    }

    public int getStorageInternal() {
        return storageInternal;
    }

    public void setStorageInternal(int storageInternal) {
        this.storageInternal = storageInternal;
    }

    public int getStorageExternal() {
        return storageExternal;
    }

    public void setStorageExternal(int storageExternal) {
        this.storageExternal = storageExternal;
    }

    @Override
    public String toString() {
        return "Storage{" + "storageId=" + storageId + ", storageRAM=" + storageRAM + ", storageInternal=" + storageInternal + ", storageExternal=" + storageExternal + '}';
    }
    
}
