package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.recyclerview) {
            // Acción para el elemento del RecyclerView
            Intent intent = new Intent(this, RecyclerviewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.listview) {
            // Acción para el elemento del ListView
            Intent intent = new Intent(this, ListViewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.dialog) {
            AlertDialog.Builder constructor = new AlertDialog.Builder(this);
            constructor.setMessage("Dialog de prueba")
                    .setTitle("Título del dialog")
                    .setIcon(R.mipmap.ic_launcher);
            constructor.show();
            return true;
        } else if (id == R.id.ranking) {
            Intent intent = new Intent(this, Ranking.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void irMainActivity(View v){
        //cambiar de activity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void irInfo(View v){
        //cambiar de activity
        Intent i = new Intent(this, Pantalla2.class);
        startActivity(i);
    }
    public void irOpciones(View v){
        //cambiar de activity
        Intent i = new Intent(this, Opciones.class);
        startActivity(i);
    }

    public void cerrarApp(View v){
        finish();
    }

}