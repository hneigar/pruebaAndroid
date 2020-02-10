package com.example.banregiotest.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvShowImage implements Parcelable{

    @SerializedName("original")@Expose
    String original;

    @SerializedName("medium")@Expose
    String medium;

    public TvShowImage(Parcel in) {
        this.original = in.readString();
        this.medium = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(original);
        dest.writeString(medium);
    }

    public static final Parcelable.Creator<TvShowImage> CREATOR = new Parcelable.Creator<TvShowImage>() {

        public TvShowImage createFromParcel(Parcel in) {
            return new TvShowImage(in);
        }

        public TvShowImage[] newArray(int size) {
            return new TvShowImage[size];
        }
    };

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
