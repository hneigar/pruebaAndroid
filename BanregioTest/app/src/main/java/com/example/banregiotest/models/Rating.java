package com.example.banregiotest.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// Aquí estamos creando una clase que sólo maneja un campo "average" de tipo float.
// Creo que podríamos prescindir de esta clase por completo, y así evitar tener que
// implementar Parcelable; ya que el tipo float sí se puede incluir en bundles sin problema.
public class Rating implements Parcelable{

    @SerializedName("average")@Expose
    float average;

    public Rating(Parcel in) {
        this.average = in.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(average);
    }

    public static final Parcelable.Creator<Rating> CREATOR = new Parcelable.Creator<Rating>() {

        public Rating createFromParcel(Parcel in) {
            return new Rating(in);
        }

        public Rating[] newArray(int size) {
            return new Rating[size];
        }
    };

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }
}
