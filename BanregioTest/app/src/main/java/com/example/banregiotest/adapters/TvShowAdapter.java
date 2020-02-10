package com.example.banregiotest.adapters;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.banregiotest.R;
import com.example.banregiotest.listeners.TvShowItemClickListener;
import com.example.banregiotest.models.TvShow;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowViewHolder> {

    private Context context;
    ArrayList<TvShow> tvShowArrayList;
    private TvShowItemClickListener tvShowItemClickListener;

    public TvShowAdapter(Context context, ArrayList<TvShow> tvShowArrayList) {
        this.context = context;
        this.tvShowArrayList = tvShowArrayList;
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_show_item,viewGroup,false);
        return new TvShowViewHolder(view, tvShowItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder viewHolder, int i) {
            TvShow tvShow = tvShowArrayList.get(i);
            viewHolder.tvShowTitle.setText(tvShow.getTitle());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Spanned htmlDescription = Html.fromHtml(tvShow.getDescription(), Html.FROM_HTML_MODE_COMPACT);
                int length = 100;
                if(htmlDescription.toString().length() < 100) {
                    length = htmlDescription.toString().length();
                }
                String croopedDescription = htmlDescription.toString().substring(0, length);
                viewHolder.tvShowDescription.setText(croopedDescription+"... ");
            } else {
                viewHolder.tvShowDescription.setText(Html.fromHtml(tvShow.getDescription()));
            }

            if (!tvShow.getGenres().isEmpty()) {
                String genresString = "Genres:";
                for (String genre: tvShow.getGenres()) {
                    genresString += " "+genre;
                }
                viewHolder.tvShowGenres.setText(genresString);
            }
            Glide.with(context)
                    .load(tvShow.getTvShowImage().getMedium())
                    .into(viewHolder.coverPageImage);
    }

    @Override
    public int getItemCount() {
        return tvShowArrayList.size();
    }

    public void setOnItemClickListener(TvShowItemClickListener listener){
        this.tvShowItemClickListener = listener;
    }
}
