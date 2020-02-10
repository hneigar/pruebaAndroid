package com.example.banregiotest.view_model.factories;

import android.app.Application;

import com.example.banregiotest.view_model.SeasonViewModel;
import com.example.banregiotest.view_model.TvShowSearchViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class TvShowSearchViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;
    private String mExtra;

    public TvShowSearchViewModelFactory(Application application, String extra) {
        mApplication = application;
        mExtra = extra;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TvShowSearchViewModel(mApplication, mExtra);
    }
}
