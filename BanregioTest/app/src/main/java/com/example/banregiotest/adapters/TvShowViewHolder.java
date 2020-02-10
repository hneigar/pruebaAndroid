package com.example.banregiotest.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banregiotest.R;
import com.example.banregiotest.listeners.TvShowItemClickListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TvShowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final ImageView coverPageImage;
    public final TextView tvShowTitle;
    public final TextView tvShowDescription;
    public final TextView tvShowGenres;
    public TvShowItemClickListener tvShowItemClickListener;

    public TvShowViewHolder(@NonNull View itemView, TvShowItemClickListener tvShowItemClickListener) {
        super(itemView);

        coverPageImage=(ImageView) itemView.findViewById(R.id.coverPageImage);
        tvShowTitle=(TextView) itemView.findViewById(R.id.tvShowTitle);
        tvShowDescription=(TextView) itemView.findViewById(R.id.tvShowDescription);
        tvShowGenres=(TextView) itemView.findViewById(R.id.tvShowGenres);
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
