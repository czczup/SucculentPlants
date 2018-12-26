package com.succulent.wztxy.succulentplants.handbook.model;

public class SucculentSpecies {

    /**
     * id : 129
     * genus_id : 15
     * name_cn :  白兔耳
     * name_en :
     * sun : 5
     * water : 3
     * grow_season : 1
     * grow_difficulty : 1
     */

    private String id;
    private String genus_id;
    private String name_cn;
    private String name_en;
    private String sun;
    private String water;
    private String grow_season;
    private String grow_difficulty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenus_id() {
        return genus_id;
    }

    public void setGenus_id(String genus_id) {
        this.genus_id = genus_id;
    }

    public String getName_cn() {
        return name_cn;
    }

    public void setName_cn(String name_cn) {
        this.name_cn = name_cn;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getGrow_season() {
        return grow_season;
    }

    public void setGrow_season(String grow_season) {
        this.grow_season = grow_season;
    }

    public String getGrow_difficulty() {
        return grow_difficulty;
    }

    public void setGrow_difficulty(String grow_difficulty) {
        this.grow_difficulty = grow_difficulty;
    }
}
