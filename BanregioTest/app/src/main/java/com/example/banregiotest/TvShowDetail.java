package com.example.banregiotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.banregiotest.adapters.SeasonAdapter;
import com.example.banregiotest.listeners.TvShowItemClickListener;
import com.example.banregiotest.models.Season;
import com.example.banregiotest.models.TvShow;
import com.example.banregiotest.view_model.SeasonViewModel;
import com.example.banregiotest.view_model.factories.SeasonViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class TvShowDetail extends AppCompatActivity implements TvShowItemClickListener {

    public ImageView coverPageImage;
    public TextView tvShowTitle;
    public TextView tvShowDescription;
    public TextView tvShowWebPage;
    public RatingBar tvShowRating;

    private RecyclerView seasonRecyclerView;
    private LinearLayoutManager layoutManager;
    private SeasonAdapter seasonAdapter;
    private ArrayList<Season> seasonArrayList = new ArrayList<>();
    SeasonViewModel seasonViewModel;

    TvShow tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        coverPageImage=(ImageView) findViewById(R.id.detailCoverPage);
        tvShowTitle=(TextView) findViewById(R.id.detailTitle);
        tvShowDescription=(TextView) findViewById(R.id.detailDescription);
        tvShowWebPage=(TextView) findViewById(R.id.detailWebPage);
        tvShowRating = (RatingBar) findViewById(R.id.tvShowRating);

        Bundle bundle = getIntent().getExtras();
        tvShow = bundle.getParcelable("tvShow");

        initialiceTvShowData(tvShow);
        initialization();
        getSeasons();

    }

    private void initialization() {
        seasonRecyclerView = (RecyclerView) findViewById(R.id.tvShowsRecyclerView);

        layoutManager = new LinearLayoutManager(TvShowDetail.this);
        seasonRecyclerView.setLayoutManager(layoutManager);

        seasonRecyclerView.setHasFixedSize(true);

        seasonRecyclerView.addItemDecoration(new DividerItemDecoration(seasonRecyclerView.getContext(), DividerItemDecoration.VERTICAL));

        seasonAdapter = new SeasonAdapter(TvShowDetail.this, seasonArrayList);
        seasonRecyclerView.setAdapter(seasonAdapter);
        seasonAdapter.setOnItemClickListener(this);

        seasonViewModel = ViewModelProviders.of(this).get(SeasonViewModel.class);
    }

    protected void initialiceTvShowData(TvShow tvShow){
        setTitle(tvShow.getTitle());

        SeasonViewModelFactory seasonViewModelFactory = new SeasonViewModelFactory(this.getApplication(), tvShow.getId());
        seasonViewModel = ViewModelProviders.of(this, seasonViewModelFactory).get(SeasonViewModel.class);

        tvShowTitle.setText("Premiered: " + tvShow.getPremierDate());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvShowDescription.setText(Html.fromHtml(tvShow.getDescription(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            tvShowDescription.setText(Html.fromHtml(tvShow.getDescription()));
        }

        tvShowWebPage.setText(tvShow.getWebPage());
        tvShowRating.setMax(5);
        tvShowRating.setRating(tvShow.getRating().getAverage()/2);

        Glide.with(TvShowDetail.this)
                .load(tvShow.getTvShowImage().getMedium())
                .into(coverPageImage);
    }

    private void getSeasons() {
        seasonViewModel.getSeasonLiveData().observe(this, seasonsResponse -> {
            if (seasonsResponse != null) {
                //progress_circular_movie_article.setVisibility(View.GONE);
                List<Season> seasons = seasonsResponse;
                //tvShowGenres.setText(String.valueOf(seasons.get(0).getNumber()));
                seasonArrayList.addAll(seasons);
                seasonAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClick(View view, int postion) {
        Season season = seasonArrayList.get(postion);
        if(season != null){
            Intent intent = new Intent(TvShowDetail.this,SeasonDetail.class);
            intent.putExtra("seasonId", season.getId());
            intent.putExtra("tvShowImage", tvShow.getTvShowImage().getMedium());
            startActivity(intent);
        }
    }

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
