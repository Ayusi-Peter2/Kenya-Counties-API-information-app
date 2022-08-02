package com.example.retrofitlibrarydemo.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class countiesResponse {
    //[{"name":"Mombasa","code":"1","areaSqKm":"212.5","capital
    @SerializedName("name")
    private String name;
    @SerializedName("code")
    private String code;
    @SerializedName("areaSqKm")
    private String areaSqKm;
    @SerializedName("capital")
    private List<String> capital;

    public countiesResponse(String name, String code, String areaSqKm, List<String> capital) {
        this.name = name;
        this.code = code;
        this.areaSqKm = areaSqKm;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAreaSqKm() {
        return areaSqKm;
    }

    public void setAreaSqKm(String areaSqKm) {
        this.areaSqKm = areaSqKm;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }
}
