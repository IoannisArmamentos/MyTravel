package com.noobs.mytravel.Models;

public class City {
    private int id, countryId;
    private String name, desc, cityImage;

    public City(int id, String name, int countryId, String desc, String cityImage) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.desc = desc;
        this.cityImage = cityImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
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

    public String getCityImage() {
        return cityImage;
    }

    public void setCityImage(String cityImage) {
        this.cityImage = cityImage;
    }
}
