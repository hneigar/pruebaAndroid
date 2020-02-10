package com.example.banregiotest.view_model.factories;

import android.app.Application;

import com.example.banregiotest.view_model.SeasonViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class SeasonViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;
    private int mExtra;

    public SeasonViewModelFactory(Application application, int extra) {
        mApplication = application;
        mExtra = extra;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SeasonViewModel(mApplication, mExtra);
    }
}
