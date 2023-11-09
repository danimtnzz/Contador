package com.example.contador;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends ListActivity implements AdapterView.OnItemClickListener {
    List<Jugador> jugadores = new ArrayList<Jugador>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        jugadores.add(new Jugador("pepe","5",R.drawable.foto_dani_home_counter));
        jugadores.add(new Jugador("xavi","5",R.drawable.xavi));
        jugadores.add(new Jugador("ter stegen","5",R.drawable.terstegen));
        jugadores.add(new Jugador("araujo","5",R.drawable.araujo));
        jugadores.add(new Jugador("kounde","5",R.drawable.kounde));
        jugadores.add(new Jugador("joao cancelo","5",R.drawable.joaocancelo));
        jugadores.add(new Jugador("pedri","5",R.drawable.pedri));
        // Crear un adaptador personalizado para mostrar los datos en el ListView
        JugadoresListViewAdapter adapter = new JugadoresListViewAdapter(this,jugadores);

        // Configurar el adaptador para el ListView
        setListAdapter(adapter);

        // Configurar un oyente de clics en los elementos del ListView
        getListView().setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Manejar el clic en un elemento del ListView
        Jugador jugador = jugadores.get(position);
        // Realiza la acción deseada al hacer clic en un elemento, como abrir un detalle o realizar alguna otra acción.
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
    public void irPantallaInicio(View v){
        //cambiar de activity
        //Intent i = new Intent(this, PantallaInicio.class);
        //startActivity(i);
        finish();
    }
}

