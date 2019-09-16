package org.lanqiao.entity;

public class RadioClass {
    private Integer radioClassId;

    private String radiaoClassName;

    public Integer getRadioClassId() {
        return radioClassId;
    }

    public void setRadioClassId(Integer radioClassId) {
        this.radioClassId = radioClassId;
    }

    public String getRadiaoClassName() {
        return radiaoClassName;
    }

    public void setRadiaoClassName(String radiaoClassName) {
        this.radiaoClassName = radiaoClassName == null ? null : radiaoClassName.trim();
    }
}