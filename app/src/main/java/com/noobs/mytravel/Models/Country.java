package com.noobs.mytravel.Models;

import java.util.UUID;

public class Country {
    private int id;
    private String name;
    private String continent;
    private String flagImage;
    private String description;

    public Country(int id, String name, String flagImage, String description) {
        this.id = id;
        this.name = name;
        this.flagImage = flagImage;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
