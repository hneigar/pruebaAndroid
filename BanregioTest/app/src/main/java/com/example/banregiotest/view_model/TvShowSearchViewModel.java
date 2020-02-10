package com.example.banregiotest.view_model;

import android.app.Application;

import com.example.banregiotest.models.TvShow;
import com.example.banregiotest.repositories.TvShowRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TvShowSearchViewModel extends AndroidViewModel {

    private TvShowRepository tvShowRepository;
    private LiveData<List<TvShow>> tvShowLiveData;

    public TvShowSearchViewModel(@NonNull Application application, String query) {
        super(application);

        tvShowRepository = new TvShowRepository();
        this.tvShowLiveData = tvShowRepository.getTvShowSearch(query);
    }

    public LiveData<List<TvShow>> getTvShoweLiveData() {
        return tvShowLiveData;
    }
}
