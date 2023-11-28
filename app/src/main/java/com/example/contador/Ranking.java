package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class Ranking extends ListActivity implements AdapterView.OnItemClickListener {
    List<Jugador> jugadoresMyDb = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        jugadoresMyDb.add(new Jugador("vfvd","5",R.drawable.foto_dani_home_counter));

        // Crear un adaptador personalizado para mostrar los datos en el ListView
        JugadoresListViewAdapter adapter = new JugadoresListViewAdapter(this,jugadoresMyDb);

        // Configurar el adaptador para el ListView

        setListAdapter(adapter);

        // Configurar un oyente de clics en los elementos del ListView
        getListView().setOnItemClickListener(this);

        consultarListaPersonas();
    }

    private void consultarListaPersonas() {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}