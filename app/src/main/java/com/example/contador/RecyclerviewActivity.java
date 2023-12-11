package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerviewActivity extends AppCompatActivity {
    List<Jugador> jugadores = new ArrayList<Jugador>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);


        RecyclerView rv =  findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new JugadoresAdapter(getApplicationContext(),jugadores));
        jugadores.add(new Jugador("pepe","5","0",R.drawable.foto_dani_home_counter));
        jugadores.add(new Jugador("xavi","5","0",R.drawable.xavi));
        jugadores.add(new Jugador("ter stegen","5","0",R.drawable.terstegen));
        jugadores.add(new Jugador("araujo","5","0",R.drawable.araujo));
        jugadores.add(new Jugador("kounde","5","0",R.drawable.kounde));
        jugadores.add(new Jugador("joao cancelo","5","0",R.drawable.joaocancelo));
        jugadores.add(new Jugador("pedri","5","0",R.drawable.pedri));

    }
    public void irPantallaInicio(View v){
        //cambiar de activity
        //Intent i = new Intent(this, PantallaInicio.class);
        //startActivity(i);
        finish();
    }
}