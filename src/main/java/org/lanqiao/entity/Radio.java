package org.lanqiao.entity;

public class Radio {
    private Integer radioId;

    private String radioName;

    private String radioCoverUrl;

    private String radioDescription;

    private Integer radioSubscription;

    private Integer radioClassId;

    private Integer radioShowNum;

    public Integer getRadioId() {
        return radioId;
    }

    public void setRadioId(Integer radioId) {
        this.radioId = radioId;
    }

    public String getRadioName() {
        return radioName;
    }

    public void setRadioName(String radioName) {
        this.radioName = radioName == null ? null : radioName.trim();
    }

    public String getRadioCoverUrl() {
        return radioCoverUrl;
    }

    public void setRadioCoverUrl(String radioCoverUrl) {
        this.radioCoverUrl = radioCoverUrl == null ? null : radioCoverUrl.trim();
    }

    public String getRadioDescription() {
        return radioDescription;
    }

    public void setRadioDescription(String radioDescription) {
        this.radioDescription = radioDescription == null ? null : radioDescription.trim();
    }

    public Integer getRadioSubscription() {
        return radioSubscription;
    }

    public void setRadioSubscription(Integer radioSubscription) {
        this.radioSubscription = radioSubscription;
    }

    public Integer getRadioClassId() {
        return radioClassId;
    }

    public void setRadioClassId(Integer radioClassId) {
        this.radioClassId = radioClassId;
    }

    public Integer getRadioShowNum() {
        return radioShowNum;
    }

    public void setRadioShowNum(Integer radioShowNum) {
        this.radioShowNum = radioShowNum;
    }
}