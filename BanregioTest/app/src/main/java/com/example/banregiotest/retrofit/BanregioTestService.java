package com.example.banregiotest.retrofit;

import com.example.banregiotest.models.Episode;
import com.example.banregiotest.models.Season;
import com.example.banregiotest.models.TvShow;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BanregioTestService {

    @Headers("Content-Type: application/json")
    @GET("/shows")
    Call<List<TvShow>> getIndexTvShows(
            @Query("page") int page
    );

    @Headers("Content-Type: application/json")
    @GET("/shows/{tvShowId}/seasons")
    Call<List<Season>> getTvShowSeasons(
            @Path(value = "tvShowId", encoded = true) int tvShowId
    );

    @Headers("Content-Type: application/json")
    @GET("/seasons/{seasonId}/episodes")
    Call<List<Episode>> getSeasonEpisodes(
            @Path(value = "seasonId", encoded = true) int seasonId
    );

    @Headers("Content-Type: application/json")
    @GET("/search/shows")
    Call<List<TvShow>> getTvShowSearch(
            @Query("q") String searchText
    );
}
