package com.example.banregiotest.listeners;

import android.view.View;

// Es buena práctica documentar interfaces. Ya que por su naturaleza estas son implementables.
// Para este caso el nombre es bastante explícito, así que no es mayor problema, pero como
// buena práctica sirve documentarlas siempre.
public interface TvShowItemClickListener {
    void onItemClick(View view, int postion);
}