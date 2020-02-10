package com.example.banregiotest.view_model;

import android.app.Application;

import com.example.banregiotest.models.Season;
import com.example.banregiotest.repositories.TvShowRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class SeasonViewModel extends AndroidViewModel {

    private TvShowRepository tvShowRepository;
    private LiveData<List<Season>> seasonLiveData;

    public SeasonViewModel(@NonNull Application application, int tvShowId) {
        super(application);

        tvShowRepository = new TvShowRepository();
        this.seasonLiveData = tvShowRepository.getTvShowSeasons(tvShowId);
    }

    public LiveData<List<Season>> getSeasonLiveData() {
        return seasonLiveData;
    }
}
