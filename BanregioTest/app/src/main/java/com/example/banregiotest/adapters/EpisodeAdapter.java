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
import com.example.banregiotest.models.Episode;
import com.example.banregiotest.models.TvShow;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {

    private Context context;
    ArrayList<Episode> episodeArrayList;
    private TvShowItemClickListener tvShowItemClickListener;
    private String defaultImage;

    public EpisodeAdapter(Context context, ArrayList<Episode> episodeArrayList, String defaultImage) {
        this.context = context;
        this.episodeArrayList = episodeArrayList;
        this.defaultImage = defaultImage;
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.episode_item,viewGroup,false);
        return new EpisodeViewHolder(view, tvShowItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder viewHolder, int i) {
        Episode episode = episodeArrayList.get(i);
            viewHolder.episodeTitle.setText(episode.getName());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Spanned htmlDescription = Html.fromHtml(episode.getSumary(), Html.FROM_HTML_MODE_COMPACT);
                viewHolder.episodeSummary.setText(htmlDescription);
            } else {
                viewHolder.episodeSummary.setText(Html.fromHtml(episode.getSumary()));
            }
            if(episode.getTvShowImage() != null){
                Glide.with(context)
                        .load(episode.getTvShowImage().getMedium())
                        .into(viewHolder.episodeCoverPage);
            }else{
                Glide.with(context)
                        .load(defaultImage)
                        .into(viewHolder.episodeCoverPage);
            }
    }

    @Override
    public int getItemCount() {
        return episodeArrayList.size();
    }

    public void setOnItemClickListener(TvShowItemClickListener listener){
        this.tvShowItemClickListener = listener;
    }
}
