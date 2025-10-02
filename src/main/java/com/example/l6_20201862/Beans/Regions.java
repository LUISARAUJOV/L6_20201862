package com.example.l6_20201862.Beans;

import java.util.ArrayList;

public class Regions {
    private long regionId;
    private String regionName;

    private ArrayList<Countries> countries;

    public Regions() {}

    public Regions(long regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public ArrayList<Countries> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Countries> countries) {
        this.countries = countries;
    }
}