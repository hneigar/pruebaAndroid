package com.example.banregiotest.adapters;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.banregiotest.R;
import com.example.banregiotest.listeners.TvShowItemClickListener;
import com.example.banregiotest.models.Season;
import com.example.banregiotest.models.TvShow;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SeasonAdapter extends RecyclerView.Adapter<SeasonViewHolder> {

    // Este context no se está utilizando.
    private Context context;
    ArrayList<Season> seasonArrayList;
    private TvShowItemClickListener tvShowItemClickListener;

    public SeasonAdapter(Context context, ArrayList<Season> seasonArrayList) {
        this.context = context;
        this.seasonArrayList = seasonArrayList;
    }

    @NonNull
    @Override
    public SeasonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.season_item,viewGroup,false);
        return new SeasonViewHolder(view, tvShowItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SeasonViewHolder viewHolder, int i) {
        Season season = seasonArrayList.get(i);
        viewHolder.seasonNumber.setText("Season " + season.getNumber());
        if(season.getName().length() > 0){
            viewHolder.seasonName.setVisibility(View.VISIBLE);
            viewHolder.seasonName.setText(season.getName());
        }else{
            viewHolder.seasonName.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return seasonArrayList.size();
    }

    public void setOnItemClickListener(TvShowItemClickListener listener){
        this.tvShowItemClickListener = listener;
    }
}
