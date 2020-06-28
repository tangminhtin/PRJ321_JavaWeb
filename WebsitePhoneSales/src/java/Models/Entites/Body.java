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
public class Body {
    private int bodyId;
    private String bodyDimensions;
    private String bodyWeight;
    private String bodyBuild;

    public Body() {
    }

    public Body(int bodyId, String bodyDimensions, String bodyWeight, String bodyBuild) {
        this.bodyId = bodyId;
        this.bodyDimensions = bodyDimensions;
        this.bodyWeight = bodyWeight;
        this.bodyBuild = bodyBuild;
    }

    public int getBodyId() {
        return bodyId;
    }

    public void setBodyId(int bodyId) {
        this.bodyId = bodyId;
    }

    public String getBodyDimensions() {
        return bodyDimensions;
    }

    public void setBodyDimensions(String bodyDimensions) {
        this.bodyDimensions = bodyDimensions;
    }

    public String getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(String bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public String getBodyBuild() {
        return bodyBuild;
    }

    public void setBodyBuild(String bodyBuild) {
        this.bodyBuild = bodyBuild;
    }

    @Override
    public String toString() {
        return "Body{" + "bodyId=" + bodyId + ", bodyDimensions=" + bodyDimensions + ", bodyWeight=" + bodyWeight + ", bodyBuild=" + bodyBuild + '}';
    }
    
}
