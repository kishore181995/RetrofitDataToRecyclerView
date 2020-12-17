
package com.example.myapplication.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Slab implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("min")
    @Expose
    private Float min;
    @SerializedName("max")
    @Expose
    private Float max;
    @SerializedName("wagered_percent")
    @Expose
    private Float wageredPercent;
    @SerializedName("wagered_max")
    @Expose
    private Float wageredMax;
    @SerializedName("otc_percent")
    @Expose
    private Float otcPercent;
    @SerializedName("otc_max")
    @Expose
    private Float otcMax;
    private final static long serialVersionUID = -2953807342843805950L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Float getWageredPercent() {
        return wageredPercent;
    }

    public void setWageredPercent(Float wageredPercent) {
        this.wageredPercent = wageredPercent;
    }

    public Float getWageredMax() {
        return wageredMax;
    }

    public void setWageredMax(Float wageredMax) {
        this.wageredMax = wageredMax;
    }

    public Float getOtcPercent() {
        return otcPercent;
    }

    public void setOtcPercent(Float otcPercent) {
        this.otcPercent = otcPercent;
    }

    public Float getOtcMax() {
        return otcMax;
    }

    public void setOtcMax(Float otcMax) {
        this.otcMax = otcMax;
    }

}
