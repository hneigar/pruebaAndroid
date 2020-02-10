package com.example.banregiotest.view_model;

import android.app.Application;

import com.example.banregiotest.models.Episode;
import com.example.banregiotest.models.Season;
import com.example.banregiotest.repositories.TvShowRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class EpisodeViewModel extends AndroidViewModel {

    private TvShowRepository tvShowRepository;
    private LiveData<List<Episode>> episodeLiveData;

    public EpisodeViewModel(@NonNull Application application, int episodeId) {
        super(application);

        tvShowRepository = new TvShowRepository();
        this.episodeLiveData = tvShowRepository.getSeasonEpisodes(episodeId);
    }

    public LiveData<List<Episode>> getEpisodeLiveData() {
        return episodeLiveData;
    }
}
