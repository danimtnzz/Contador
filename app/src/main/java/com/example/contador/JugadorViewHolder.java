package com.example.contador;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JugadorViewHolder extends RecyclerView.ViewHolder{
    ImageView imagen;
    TextView nick, monedas;
    public JugadorViewHolder(@NonNull View itemView) {
        super(itemView);
        imagen=itemView.findViewById(R.id.imagen);
        nick=itemView.findViewById(R.id.nick);
        monedas=itemView.findViewById(R.id.monedas);
    }
}
