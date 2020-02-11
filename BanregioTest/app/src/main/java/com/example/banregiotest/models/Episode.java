package com.example.banregiotest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Episode {

    // Me parece que la anotación de @Expose es redundante aquí.
    // Estas variables podrían ser privadas.
    @SerializedName("id")@Expose
    int id;

    @SerializedName("name")@Expose
    String name;

    @SerializedName("image")@Expose
    TvShowImage tvShowImage;

    @SerializedName("summary")@Expose
    String sumary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TvShowImage getTvShowImage() {
        return tvShowImage;
    }

    public void setTvShowImage(TvShowImage tvShowImage) {
        this.tvShowImage = tvShowImage;
    }

    public String getSumary() {
        return sumary;
    }

    public void setSumary(String sumary) {
        this.sumary = sumary;
    }
}
