package com.example.contador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class JugadoresListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Jugador> jugadores;

    public JugadoresListViewAdapter(Context context, List<Jugador> jugadores) {
        this.context = context;
        this.jugadores = jugadores;
    }

    @Override
    public int getCount() {
        return jugadores.size();
    }

    @Override
    public Object getItem(int position) {
        return jugadores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.jugador_vista, parent, false);
        }

        ImageView imagen = convertView.findViewById(R.id.imagen);
        TextView nick = convertView.findViewById(R.id.nick);
        TextView monedas = convertView.findViewById(R.id.monedas);
        TextView mejoras = convertView.findViewById(R.id.mejoras);

        Jugador jugador = jugadores.get(position);

        imagen.setImageResource(jugador.getImagen());
        nick.setText(jugador.getNick());
        monedas.setText(jugador.getMonedas());
        mejoras.setText(jugador.getMejoras());

        return convertView;
    }
}
