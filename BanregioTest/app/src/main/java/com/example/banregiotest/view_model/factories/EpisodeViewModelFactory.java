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
        // Hay que revisar que nuestro tipo T sí sea del tipo que esperamos. Para evitar
        // posibles crashes más adelante. Se puede validar con un instanceof.
        return (T) new EpisodeViewModel(mApplication, mExtra);
    }
}
