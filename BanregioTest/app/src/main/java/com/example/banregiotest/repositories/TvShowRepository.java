package com.example.banregiotest.repositories;

import android.util.Log;

import com.example.banregiotest.models.Episode;
import com.example.banregiotest.models.Season;
import com.example.banregiotest.models.TvShow;
import com.example.banregiotest.retrofit.BanregioTestService;
import com.example.banregiotest.retrofit.RetrofitClient;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowRepository {

    private static final String TAG = TvShowRepository.class.getSimpleName();
    private BanregioTestService banregioTestService;

    public TvShowRepository() {
        banregioTestService = RetrofitClient.getRetrofitInstance().create(BanregioTestService.class);
    }

    public LiveData<List<TvShow>> getTvShows(int page) {
        final MutableLiveData<List<TvShow>> data = new MutableLiveData<>();
        banregioTestService.getIndexTvShows(page)
                .enqueue(new Callback<List<TvShow>>() {


                    @Override
                    public void onResponse(Call<List<TvShow>> call, Response<List<TvShow>> response) {
                        Log.d(TAG,"onResponse response:: " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d(TAG, "Nombre:: " + response.body().get(0).getTitle());
                            Log.d(TAG, "descripcion: " + response.body().get(0).getDescription());
                            Log.d(TAG, "Imagen: " + response.body().get(0).getTvShowImage());
                            Log.d(TAG, "genero: " + response.body().get(0).getGenres().get(0));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TvShow>> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public LiveData<List<Season>> getTvShowSeasons(int tvShowId) {
        final MutableLiveData<List<Season>> data = new MutableLiveData<>();
        banregioTestService.getTvShowSeasons(tvShowId)
                .enqueue(new Callback<List<Season>>() {


                    @Override
                    public void onResponse(Call<List<Season>> call, Response<List<Season>> response) {
                        Log.d(TAG,"onResponse response:: " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d(TAG, "Nombre:: " + response.body().get(0).getName());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Season>> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public LiveData<List<Episode>> getSeasonEpisodes(int episodeId) {
        final MutableLiveData<List<Episode>> data = new MutableLiveData<>();
        banregioTestService.getSeasonEpisodes(episodeId)
                .enqueue(new Callback<List<Episode>>() {


                    @Override
                    public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {
                        Log.d(TAG,"onResponse response:: " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d(TAG, "Nombre:: " + response.body().get(0).getName());
                            Log.d(TAG, "descripcion: " + response.body().get(0).getSumary());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Episode>> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public LiveData<List<TvShow>> getTvShowSearch(String query) {
        final MutableLiveData<List<TvShow>> data = new MutableLiveData<>();
        banregioTestService.getTvShowSearch(query)
                .enqueue(new Callback<List<TvShow>>() {


                    @Override
                    public void onResponse(Call<List<TvShow>> call, Response<List<TvShow>> response) {
                        Log.d(TAG,"onResponse response:: " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d(TAG, "Nombre:: " + response.body().get(0).getTitle());
                            Log.d(TAG, "descripcion: " + response.body().get(0).getDescription());
                            Log.d(TAG, "Imagen: " + response.body().get(0).getTvShowImage());
                            Log.d(TAG, "genero: " + response.body().get(0).getGenres().get(0));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TvShow>> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
