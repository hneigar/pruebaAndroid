package com.example.banregiotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.banregiotest.adapters.TvShowAdapter;
import com.example.banregiotest.listeners.TvShowItemClickListener;
import com.example.banregiotest.models.TvShow;
import com.example.banregiotest.view_model.TvShowViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TvShowItemClickListener {

    // Es bueno evitar el uso de variables globales si realmente no se necesitan. Es el caso para
    // tvShowsRecyclerView y layoutManager (como señala Android Studio).
    private RecyclerView tvShowsRecyclerView;
    private LinearLayoutManager layoutManager;
    private TvShowAdapter tvShowAdapter;
    private ArrayList<TvShow> tvShowArrayList = new ArrayList<>();
    TvShowViewModel tvShowViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Usar textos hardcodeados nos quita la posibilidad de manejar texto por localización.
        setTitle("Tv Series");

        initialization();

        getTvShows();
    }

    /**
     * It gets initialized the recyclerview, the layouts and the adapter with the view model
     */
    private void initialization() {
        // El casting es innecesario.
        tvShowsRecyclerView = (RecyclerView) findViewById(R.id.tvShowsRecyclerView);

        layoutManager = new LinearLayoutManager(MainActivity.this);
        tvShowsRecyclerView.setLayoutManager(layoutManager);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        tvShowsRecyclerView.setHasFixedSize(true);

        tvShowsRecyclerView.addItemDecoration(new DividerItemDecoration(tvShowsRecyclerView.getContext(), DividerItemDecoration.VERTICAL));

        tvShowAdapter = new TvShowAdapter(MainActivity.this, tvShowArrayList);
        tvShowsRecyclerView.setAdapter(tvShowAdapter);
        tvShowAdapter.setOnItemClickListener(this);

        tvShowViewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);
    }

    /**
     * Get Tv Shows from the ViewModel, they get added to the principal list and the adapter gets notified of it
     */
    private void getTvShows() {
        tvShowViewModel.getTvShoweLiveData().observe(this, tvShowResponse -> {
            if (tvShowResponse != null) {
                // Es bueno evitar dejar código comentado. Un sistema de control de versiones como
                // git nos permite recuperar código que desechamos en algún punto.
                //progress_circular_movie_article.setVisibility(View.GONE);
                // Como dice Android Studio, esta variable es redundante. Podríamos utilizar
                // directamente tvShowResponse.
                List<TvShow> tvShows = tvShowResponse;
                tvShowArrayList.addAll(tvShows);
                tvShowAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * When an item is clicked it will redirect to another screen in order to show the details of the information
     */
    @Override
    // Aquí hay un 'typo' en position.
    public void onItemClick(View view, int postion) {
        TvShow tvShow = tvShowArrayList.get(postion);
        if(tvShow != null){
            Intent intent = new Intent(MainActivity.this,TvShowDetail.class);
            intent.putExtra("tvShow", tvShow);
            startActivity(intent);
        }
    }
}
