package com.example.banregiotest.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banregiotest.R;
import com.example.banregiotest.listeners.TvShowItemClickListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EpisodeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final ImageView episodeCoverPage;
    public final TextView episodeTitle;
    public final TextView episodeSummary;
    public TvShowItemClickListener tvShowItemClickListener;

    public EpisodeViewHolder(@NonNull View itemView, TvShowItemClickListener tvShowItemClickListener) {
        super(itemView);

        episodeCoverPage=(ImageView) itemView.findViewById(R.id.episodeCoverPage);
        episodeTitle=(TextView) itemView.findViewById(R.id.episodeTitle);
        episodeSummary=(TextView) itemView.findViewById(R.id.episodeSummary);
        this.tvShowItemClickListener = tvShowItemClickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(tvShowItemClickListener != null){
            tvShowItemClickListener.onItemClick(v,getAdapterPosition());
        }
    }
}
