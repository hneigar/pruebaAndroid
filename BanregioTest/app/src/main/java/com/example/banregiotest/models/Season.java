package com.example.banregiotest.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Season implements Parcelable {

    @SerializedName("id")@Expose
    int id;

    @SerializedName("number")@Expose
    int number;

    @SerializedName("name")@Expose
    String name;

    @SerializedName("image")@Expose
    String image;

    @SerializedName("summary")@Expose
    String summary;

    public Season(int id, int number, String name, String image, String summary) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.image = image;
        this.summary = summary;
    }

    // Evitar dejar código comentado.
    // Atender recomendaciones de Android Studio mientras sea pertinente.
    public Season(Parcel in) {
        //this.average = in.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //dest.writeFloat(average);
    }

    public static final Parcelable.Creator<Season> CREATOR = new Parcelable.Creator<Season>() {

        public Season createFromParcel(Parcel in) {
            return new Season(in);
        }

        public Season[] newArray(int size) {
            return new Season[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
