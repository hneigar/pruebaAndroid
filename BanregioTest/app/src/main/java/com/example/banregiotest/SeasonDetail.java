package com.example.banregiotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.banregiotest.adapters.EpisodeAdapter;
import com.example.banregiotest.models.Episode;
import com.example.banregiotest.view_model.EpisodeViewModel;
import com.example.banregiotest.view_model.factories.EpisodeViewModelFactory;

import java.util.ArrayList;
import java.util.List;

// Si se trata de una Activity, es buena práctica señalarlo en el nombre, para que sea más
// evidente al revisar el código desde un nivel más general.
public class SeasonDetail extends AppCompatActivity {

    private RecyclerView episodeRecyclerView;
    private LinearLayoutManager layoutManager;
    private EpisodeAdapter episodeAdapter;
    private ArrayList<Episode> episodeArrayList = new ArrayList<>();
    EpisodeViewModel episodeViewModel;
    String tvShowImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_detail);
        // Aquí podría haber una Null pointer exception, ya que no se valida que la action bar no
        // sea null. De nuevo, Android Studio nos advierte de esto.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Episodes");

        Bundle bundle = getIntent().getExtras();
        // Aquí puede haber una Null pointer exception, de la que Android Studio nos advierte.
        int seasonId = bundle.getInt("seasonId");
        tvShowImage = bundle.getString("tvShowImage");

        initialization(seasonId);

        getEpisodes();
    }

    private void initialization(int seasonId) {
        // 'typo' en different.
        //This 2 lines of code are for sending an extra parameter to the ViewModel, in order to get diferent data every time
        EpisodeViewModelFactory seasonViewModelFactory = new EpisodeViewModelFactory(this.getApplication(), seasonId);
        episodeViewModel = ViewModelProviders.of(this, seasonViewModelFactory).get(EpisodeViewModel.class);

        episodeRecyclerView = (RecyclerView) findViewById(R.id.episodesRecyclerView);

        layoutManager = new LinearLayoutManager(SeasonDetail.this);
        episodeRecyclerView.setLayoutManager(layoutManager);

        episodeRecyclerView.setHasFixedSize(true);

        episodeRecyclerView.addItemDecoration(new DividerItemDecoration(episodeRecyclerView.getContext(), DividerItemDecoration.VERTICAL));

        episodeAdapter = new EpisodeAdapter(SeasonDetail.this, episodeArrayList, tvShowImage);
        episodeRecyclerView.setAdapter(episodeAdapter);

        episodeViewModel = ViewModelProviders.of(this).get(EpisodeViewModel.class);
    }

    private void getEpisodes() {
        episodeViewModel.getEpisodeLiveData().observe(this, episodeResponse -> {
            if (episodeResponse != null) {
                // Variable redundante.
                List<Episode> episodes = episodeResponse;
                episodeArrayList.addAll(episodes);
                episodeAdapter.notifyDataSetChanged();
            }
        });
    }

    // Me parece que sobreescribir esta función, para este caso, es innecesario, ya que sólo
    // estamos manejando el 'back' de la manera en que se hace por default. Hay alguna razón
    // por la que se decidió sobreescribirlo?
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
