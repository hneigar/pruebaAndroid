package com.example.banregiotest.view_model.factories;

import android.app.Application;

import com.example.banregiotest.view_model.EpisodeViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class EpisodeViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;
    private int mExtra;

    public EpisodeViewModelFactory(Application application, int extra) {
        mApplication = application;
        mExtra = extra;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new EpisodeViewModel(mApplication, mExtra);
    }
}
