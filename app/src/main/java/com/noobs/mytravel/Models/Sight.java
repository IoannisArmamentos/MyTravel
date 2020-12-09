package com.noobs.mytravel.Models;

public class Sight {
    private int id, cityId;
    private String image, name, desc;

    public Sight(int id, String name, String desc, String image, int cityId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.image = image;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getSightImage() {
        return image;
    }

    public void setSightImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
