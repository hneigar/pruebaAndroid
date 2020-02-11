package com.example.banregiotest.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TvShow implements Parcelable {

    @SerializedName("id")@Expose
    int id;

    @SerializedName("name")@Expose
    String title;

    @SerializedName("summary")@Expose
    String description;

    @SerializedName("genres")@Expose
    List<String> genres;

    @SerializedName("image")@Expose
    TvShowImage tvShowImage;

    @SerializedName("rating")@Expose
    Rating rating;

    @SerializedName("premiered")@Expose
    String premierDate;

    @SerializedName("officialSite")@Expose
    String webPage;

    List<Season> seasonList;

    public TvShow(int id, String title, String description, List<String> genres, TvShowImage tvShowImage, Rating rating, String premierDate, String webPage, List<Season> seasonList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.tvShowImage = tvShowImage;
        this.rating = rating;
        this.premierDate = premierDate;
        this.webPage = webPage;
        this.seasonList = seasonList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public TvShowImage getTvShowImage() {
        return tvShowImage;
    }

    public void setTvShowImage(TvShowImage tvShowImage) {
        tvShowImage = tvShowImage;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getPremierDate() {
        return premierDate;
    }

    public void setPremierDate(String premierDate) {
        this.premierDate = premierDate;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public List<Season> getSeasonList() {
        return seasonList;
    }

    public void setSeasonList(List<Season> seasonList) {
        this.seasonList = seasonList;
    }

    /**
     * Use when reconstructing User object from parcel
     * This will be used only by the 'CREATOR'
     * @param in a parcel to read this object
     */
    public TvShow(Parcel in) {
        // The order of the properties has to be the same in the writeToParcel method
        this.tvShowImage = in.readParcelable(TvShowImage.class.getClassLoader());
        this.rating =  in.readParcelable(Rating.class.getClassLoader());
        this.id = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        //ArrayList<String> permissionsList = new ArrayList<>();
        //in.readStringList(permissionsList);
        this.premierDate = in.readString();
        this.webPage = in.readString();
        //seasonList = new ArrayList<>();
        //in.readTypedList(seasonList, Season.CREATOR);
    }
    /**
     * Define the kind of object that you gonna parcel,
     * You can use hashCode() here
     */
    @Override
    public int describeContents() {
        return 0;
    }

    // Está bien usar código de otros lados para nuestros proyectos, pero vale la pena al menos
    // modificar los mensajes para que sean únicos a nuestro código y que no queden como un
    // template genérico.
    /**
     * Actual object serialization happens here, Write object content
     * to parcel one by one, reading should be done according to this write order
     * @param dest parcel
     * @param flags Additional flags about how the object should be written
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //The parcelable object has to be the first one
        dest.writeParcelable(this.tvShowImage, flags);
        dest.writeParcelable(this.rating, flags);
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        //dest.writeStringList(genres);
        dest.writeString(premierDate);
        dest.writeString(webPage);
        //dest.writeTypedList(seasonList);
    }

    /**
     * This field is needed for Android to be able to
     * create new objects, individually or as arrays
     *
     * If you don’t do that, Android framework will through exception
     * Parcelable protocol requires a Parcelable.Creator object called CREATOR
     */
    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {

        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
