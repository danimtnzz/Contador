package com.example.contador;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class Ranking extends ListActivity implements AdapterView.OnItemClickListener {
    private DBHelper dbHelper;
    private List<Jugador> jugadoresMyDb = new ArrayList<>(); // Lista de Jugadores

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        dbHelper = new DBHelper(this);

        // Obtener el intent que inició esta actividad
        Intent intent = getIntent();
        String monedas = "0"; // Valor predeterminado para las monedas

        if (intent != null) {
            Bundle param = intent.getExtras();
            if (param != null) {
                String monedasFromIntent = param.getString("monedas");
                if (monedasFromIntent != null && !monedasFromIntent.isEmpty()) {
                    monedas = monedasFromIntent;
                }
            }
        }

        // Consultar la lista de personas y configurar el adaptador para el ListView
        consultarListaPersonas(monedas);
    }

    private void consultarListaPersonas(String monedas) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT username FROM users", null);

        jugadoresMyDb.clear(); // Limpiar la lista de jugadores antes de agregar nuevos usuarios
        if (cursor != null && cursor.getCount() > 0) {
            int columnIndex = cursor.getColumnIndex("username");
            if (columnIndex != -1) {
                cursor.moveToFirst();
                do {
                    String username = cursor.getString(columnIndex);
                    // Crear un Jugador para cada nombre de usuario y agregarlo a la lista jugadoresMyDb
                    jugadoresMyDb.add(new Jugador(username, monedas, R.drawable.foto_dani_home_counter));
                } while (cursor.moveToNext());
            }
        }

        if (cursor != null) {
            cursor.close();
        }

        // Crear un adaptador personalizado para mostrar los datos en el ListView
        JugadoresListViewAdapter adapter = new JugadoresListViewAdapter(this, jugadoresMyDb);

        // Configurar el adaptador para el ListView
        setListAdapter(adapter);

        // Configurar un oyente de clics en los elementos del ListView
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Acciones cuando se hace clic en un elemento del ListView
    }
}
