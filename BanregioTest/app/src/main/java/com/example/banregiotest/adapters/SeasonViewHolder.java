package com.example.banregiotest.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banregiotest.R;
import com.example.banregiotest.listeners.TvShowItemClickListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SeasonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final TextView seasonNumber;
    public final TextView seasonName;
    public TvShowItemClickListener tvShowItemClickListener;

    public SeasonViewHolder(@NonNull View itemView, TvShowItemClickListener tvShowItemClickListener) {
        super(itemView);

        seasonNumber=(TextView) itemView.findViewById(R.id.seasonNumber);
        seasonName=(TextView) itemView.findViewById(R.id.seasonName);
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
