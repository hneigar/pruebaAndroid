package com.example.banregiotest.view_model;

import android.app.Application;

import com.example.banregiotest.models.TvShow;
import com.example.banregiotest.repositories.TvShowRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TvShowViewModel extends AndroidViewModel {

    private TvShowRepository tvShowRepository;
    private LiveData<List<TvShow>> tvShowLiveData;

    public TvShowViewModel(@NonNull Application application) {
        super(application);

        tvShowRepository = new TvShowRepository();
        this.tvShowLiveData = tvShowRepository.getTvShows(1);
    }

    public LiveData<List<TvShow>> getTvShoweLiveData() {
        return tvShowLiveData;
    }
}
